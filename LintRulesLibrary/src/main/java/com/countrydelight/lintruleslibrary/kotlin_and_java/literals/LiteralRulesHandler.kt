package com.countrydelight.lintruleslibrary.kotlin_and_java.literals

import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UBinaryExpression
import org.jetbrains.uast.UElement
import org.jetbrains.uast.ULiteralExpression

object LiteralRulesHandler {

    /**
     * Reports a hardcoded literal issue in the code.
     *
     * @param node The ULiteralExpression node that contains the hardcoded literal.
     * @param context The context of the lint check, used for reporting issues.
     */
    fun handleHardcodedLiteralRule(node: ULiteralExpression, context: JavaContext) {
        context.report(
            LiteralIssueUtils.HardCodedLiteralIssue,
            node as UElement,
            context.getLocation(node as UElement),
            LiteralIssueUtils.HARDCODED_LITERAL_ISSUE_TEXT + "${(node.uastParent as UBinaryExpression).operatorIdentifier?.name}"
        )
    }
}