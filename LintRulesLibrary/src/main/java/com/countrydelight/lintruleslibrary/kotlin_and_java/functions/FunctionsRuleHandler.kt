package com.countrydelight.lintruleslibrary.kotlin_and_java.functions

import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UMethod

object FunctionsRuleHandler {

    fun handleFunctionCommentRule(node: UMethod, context: JavaContext) {
        context.report(
            FunctionsIssueUtils.FunctionCommentIssue,
            node as UElement,
            context.getLocation(node as UElement),
            FunctionsIssueUtils.FUNCTION_COMMENT_ISSUE_TEXT
        )

    }

    fun handleFindViewByIdRule(node: UMethod, context: JavaContext) {
        context.report(
            FunctionsIssueUtils.FindViewByIdIssue,
            node,
            context.getLocation(node as UElement),
            FunctionsIssueUtils.FIND_VIEW_BY_ID_ISSUE_TEXT
        )
    }
}