package com.countrydelight.lintruleslibrary.kotlin_and_java.functions

import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UMethod

object FunctionsRuleHandler {

    /**
     * This function handles the function comment rule in a UMethod node and reports an issue if the rule is violated.
     *
     * @param node The UMethod node that is being analyzed.
     * @param context The JavaContext which provides context for the analysis, such as reporting issues.
     */
    fun handleFunctionCommentRule(node: UMethod, context: JavaContext) {
        context.report(
            FunctionsIssueUtils.FunctionCommentIssue,
            node as UElement,
            context.getLocation(node as UElement),
            FunctionsIssueUtils.FUNCTION_COMMENT_ISSUE_TEXT
        )

    }


    /**
     * This function handles the findViewById rule in a UMethod node and reports an issue if the rule is violated.
     *
     * @param node The UMethod node that is being analyzed.
     * @param context The JavaContext which provides context for the analysis, such as reporting issues.
     */
    fun handleFindViewByIdRule(node: UMethod, context: JavaContext) {
        context.report(
            FunctionsIssueUtils.FindViewByIdIssue,
            node,
            context.getLocation(node as UElement),
            FunctionsIssueUtils.FIND_VIEW_BY_ID_ISSUE_TEXT
        )
    }
}