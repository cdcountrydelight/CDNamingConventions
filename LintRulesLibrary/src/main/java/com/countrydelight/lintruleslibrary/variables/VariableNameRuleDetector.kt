package com.countrydelight.lintruleslibrary.variables

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UVariable

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
                    } else if ((
                                variableType.canonicalText.startsWith("java.util.HashMap")
                                        || variableType.canonicalText.startsWith("java.util.Map"))
                        && node.isPhysical
                    ) {
                        VariableNameRuleHandler.handleMapNameRule(node, context)
                    }
                }
            }
        }
    }

}