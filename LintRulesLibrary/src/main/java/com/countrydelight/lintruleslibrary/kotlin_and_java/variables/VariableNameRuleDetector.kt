package com.countrydelight.lintruleslibrary.kotlin_and_java.variables

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UField
import org.jetbrains.uast.UFile
import org.jetbrains.uast.UMethod
import org.jetbrains.uast.UReferenceExpression
import org.jetbrains.uast.USimpleNameReferenceExpression
import org.jetbrains.uast.UVariable
import org.jetbrains.uast.textRange
import org.jetbrains.uast.visitor.AbstractUastVisitor

class VariableNameRuleDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes(): List<Class<out UElement>> {
        return listOf(UVariable::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {
            override fun visitVariable(node: UVariable) {
                val variableType = node.type
                if (!node.text.contains("fun") && !node.isStatic) {
                    if ((variableType.canonicalText.startsWith("kotlinx.coroutines.flow.MutableStateFlow")
                                || variableType.canonicalText.startsWith("kotlinx.coroutines.flow.StateFlow"))
                        && node.isPhysical
                    ) {
                        VariableNameRuleHandler.handleStateFlowNameRule(node, context)
                    } else if ((variableType.canonicalText.startsWith("androidx.compose.runtime.MutableState")
                                || variableType.canonicalText.startsWith("androidx.compose.runtime.State"))
                        && node.isPhysical
                    ) {
                        VariableNameRuleHandler.handleStateNameRule(node, context)
                    } else if ((variableType.canonicalText.startsWith("java.util.List")
                                || variableType.canonicalText.startsWith("java.util.ArrayList"))
                        && node.isPhysical
                    ) {
                        VariableNameRuleHandler.handleListNameRule(node, context)
                    } else if ((variableType.canonicalText.startsWith("java.util.HashMap")
                                || variableType.canonicalText.startsWith("java.util.Map"))
                        && node.isPhysical
                    ) {
                        VariableNameRuleHandler.handleMapNameRule(node, context)
                    } else if ((variableType.canonicalText.startsWith("androidx.lifecycle.MutableLiveData")
                                || variableType.canonicalText.startsWith("androidx.lifecycle.LiveData"))
                        && node.isPhysical
                    ) {
                        VariableNameRuleHandler.handleLiveDataNameRule(node, context)
                    } else if (node is UField) {
                        val references = findReferencesOfVariable(context.uastFile, node)
                        if (references.isNotEmpty()) {
                            val containingMethods =
                                references.mapNotNull { findContainingMethodOfVariable(it) }
                                    .distinct()
                            if (containingMethods.size == 1 && references.all {
                                    val startOffset = it.textRange?.startOffset
                                    if (startOffset != null) {
                                        startOffset > node.textRange.endOffset
                                    } else true
                                }) {
                                val methodName = containingMethods.first().name
                                VariableNameRuleHandler.handleGlobalVariableNameRule(
                                    node,
                                    context,
                                    methodName
                                )
                            }

                        }
                    }
                }
            }

        }
    }


    private fun findReferencesOfVariable(
        uFile: UFile?,
        variable: UVariable
    ): List<USimpleNameReferenceExpression> {
        val references = mutableListOf<USimpleNameReferenceExpression>()
        uFile?.accept(object : AbstractUastVisitor() {
            override fun visitSimpleNameReferenceExpression(node: USimpleNameReferenceExpression): Boolean {
                if (node.resolvedName == variable.name) {
                    references.add(node)
                }
                return super.visitSimpleNameReferenceExpression(node)
            }
        })
        return references
    }

    private fun findContainingMethodOfVariable(reference: UReferenceExpression): UMethod? {
        var parent = reference.uastParent
        while (parent != null && parent !is UMethod) {
            parent = parent.uastParent
        }
        return parent as? UMethod
    }

}