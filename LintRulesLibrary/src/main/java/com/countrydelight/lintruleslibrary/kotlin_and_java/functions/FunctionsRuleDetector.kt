package com.countrydelight.lintruleslibrary.kotlin_and_java.functions

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import com.intellij.psi.PsiTypes
import org.jetbrains.uast.UCallExpression
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UMethod
import org.jetbrains.uast.UTryExpression
import org.jetbrains.uast.visitor.AbstractUastVisitor

class FunctionsRuleDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes(): List<Class<out UElement>> {
        return listOf(UMethod::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {
            override fun visitMethod(node: UMethod) {
                val nodeParent = node.uastParent as? UClass
                val isEnumClass = nodeParent?.isEnum ?: false
                val functionDeclaration = node.text?.substringBefore("{")
                val isDataClass =
                    functionDeclaration?.contains("data") == true && functionDeclaration.contains("class")
                val isAnyVariable =
                    functionDeclaration?.contains("var") == true || functionDeclaration?.contains("val") == true
                if (!node.isConstructor && !isDataClass && !isEnumClass && !isAnyVariable) {
                    val notHasComments =
                        node.comments.isEmpty() || node.comments.all { it.text.isBlank() }
                    if (notHasComments
                        && node.text?.contains("override") == false
                        && !node.annotations.any { it.text?.contains("Override") == true }
                        && node.annotations.none { it.qualifiedName?.contains("androidx.room") == true }
                    ) {
                        FunctionsRuleHandler.handleFunctionCommentRule(node, context)
                    }
                    if (node.text?.contains("findViewById") == true) {
                        FunctionsRuleHandler.handleFindViewByIdRule(node, context)
                    }
                    if (node.returnType == PsiTypes.booleanType()) {
                        FunctionsRuleHandler.handleBooleanFunctionNameRule(node, context)
                    }
                    if (node.annotations.any {
                            it.text?.contains("@Insert") == true && it.text?.contains(
                                "REPLACE"
                            ) == true
                        }) {
                        FunctionsRuleHandler.handleUseUpsertRuleInPlaceOfInsert(node, context)
                    }
                    val startLine = context.getLocation(node).start?.line
                    val endLine = context.getLocation(node).end?.line
                    if (startLine != null && endLine != null && endLine - startLine + 1 > 100) {
                        FunctionsRuleHandler.handleFunctionMaxLengthRule(node, context)
                    }
                    node.uastBody?.accept(object : AbstractUastVisitor() {
                        override fun visitCallExpression(childNode: UCallExpression): Boolean {
                            val childFunction = childNode.resolve()
                            if (childFunction != null && childFunction.throwsList.referencedTypes.isNotEmpty()) {
                                val childNodeParent = childNode.uastParent?.uastParent
                                if (childNodeParent is UTryExpression) {
                                    val exceptionCaughtByCatchClause =
                                        childNodeParent.catchClauses.joinToString { catchClause -> catchClause.parameters.joinToString { it.type.canonicalText } }
                                    val doesCatchClauseAContainsException =
                                        exceptionCaughtByCatchClause.contains("java.lang.Exception")
                                    if (!doesCatchClauseAContainsException) {
                                        childFunction.throwsList.referencedTypes.forEach {
                                            if (!exceptionCaughtByCatchClause.contains(it.canonicalText)) {
                                                FunctionsRuleHandler.handleFunctionThrowExceptionRule(
                                                    node,
                                                    context,
                                                    childNodeParent.catchClauses.joinToString { it.parameters.joinToString { it.type.canonicalText } },
                                                    childFunction.name
                                                )
                                            }
                                        }
                                    }
                                } else if (childNodeParent is UMethod) {
                                    val doesChildNodeParentThrowsException =
                                        childNodeParent.throwsList.referencedTypes.map { it.className }
                                            .contains("Exception")
                                    if (!doesChildNodeParentThrowsException) {
                                        childFunction.throwsList.referencedTypes.forEach {
                                            if (!childNodeParent.throwsList.referencedTypes
                                                    .contains(it)
                                            ) {
                                                FunctionsRuleHandler.handleFunctionThrowExceptionRule(
                                                    node,
                                                    context,
                                                    it.canonicalText,
                                                    childFunction.name
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                            return super.visitCallExpression(childNode)
                        }
                    })
                }

            }
        }
    }
}
