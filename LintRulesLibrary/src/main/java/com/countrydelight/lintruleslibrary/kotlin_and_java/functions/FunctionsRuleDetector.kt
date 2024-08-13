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
                    ) {
                        FunctionsRuleHandler.handleFunctionCommentRule(node, context)
                    }
                    if (node.text?.contains("findViewById") == true) {
                        FunctionsRuleHandler.handleFindViewByIdRule(node, context)
                    }
                    val startLine = context.getLocation(node).start?.line
                    val endLine = context.getLocation(node).end?.line
                    if (startLine != null && endLine != null && endLine - startLine + 1 > 100) {
                        FunctionsRuleHandler.handleFunctionMaxLengthRule(node, context)
                    }
                }

            }
        }
    }
}
