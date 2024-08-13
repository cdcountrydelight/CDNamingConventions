package com.countrydelight.lintruleslibrary.kotlin_and_java.literals

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UBinaryExpression
import org.jetbrains.uast.UElement
import org.jetbrains.uast.ULiteralExpression
import org.jetbrains.uast.isNumberLiteral

class LiteralsRulesDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes(): List<Class<out UElement>> {
        return listOf(ULiteralExpression::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {
            override fun visitLiteralExpression(node: ULiteralExpression) {
                if ((node.isNumberLiteral() || node.isString) && node.uastParent is UBinaryExpression) {
                    LiteralRulesHandler.handleHardcodedLiteralRule(node, context)
                }
            }
        }
    }
}
