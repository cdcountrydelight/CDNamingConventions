package com.countrydelight.lintruleslibrary.kotlin_and_java.functions

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UMethod

class FunctionsRuleDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes(): List<Class<out UElement>> {
        return listOf(UMethod::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {

            override fun visitMethod(node: UMethod) {
                val nodeParent = node.uastParent as? UClass
                val isEnumClass = nodeParent?.isEnum ?: false
                val isDataClass = nodeParent?.text?.contains("data") ?: false
                val isAnyVariable =
                    node.text?.contains("var") == true || node.text?.contains("val") == true
                if (!node.isConstructor && !isDataClass && !isEnumClass && !isAnyVariable) {
                    val notHasComments =
                        node.comments.isEmpty() || node.comments.all { it.text.isBlank() }
                    if (notHasComments
                        && node.text?.contains("override") == false
                        && !node.annotations.any { it.text?.contains("Override") == true }
                    ) {
                        FunctionsRuleHandler.handleFunctionCommentRule(node, context)
                    } else if (node.text?.contains("findViewById") == true) {
                        FunctionsRuleHandler.handleFindViewByIdRule(node, context)
                    }
                }

            }
        }
    }
}
