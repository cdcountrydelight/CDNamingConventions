package com.countrydelight.lintruleslibrary.kotlin_and_java.functions

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UMethod

class FunctionsRuleDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes(): List<Class<out UElement>> {
        return listOf(UMethod::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {

            override fun visitMethod(node: UMethod) {
                if (node.comments.isEmpty()
                    && !node.isConstructor
                    && !node.text.contains("override")
                    && !node.annotations.any { it.text.contains("Override") }
                ) {
                    FunctionsRuleHandler.handleFunctionCommentRule(node, context)
                }
            }
        }
    }
}
