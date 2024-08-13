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

    /**
     * Reports an issue when a function exceeds the maximum allowed length.
     *
     * @param node The UMethod node representing the function that exceeds the maximum length.
     * @param context The context of the lint check, used for reporting issues.
     */
    fun handleFunctionMaxLengthRule(node: UMethod, context: JavaContext) {
        context.report(
            FunctionsIssueUtils.FunctionMaxLengthIssue,
            node,
            context.getLocation(node as UElement),
            FunctionsIssueUtils.FUNCTION_MAX_LENGTH_ISSUE_TEXT
        )
    }

    /**
     * Handles the rule for checking if a function properly manages exceptions thrown by another function.
     *
     * @param node The UMethod instance representing the function being analyzed.
     * @param context The JavaContext providing access to the context of the Lint analysis, including the file and location.
     * @param exceptionName The name of the exception that should be handled by the function.
     * @param functionName The name of the function that potentially throws the exception.
     */
    fun handleFunctionThrowExceptionRule(
        node: UMethod,
        context: JavaContext,
        exceptionName: String,
        functionName: String
    ) {
        context.report(
            FunctionsIssueUtils.FunctionExceptionHandlingIssue,
            node,
            context.getLocation(node as UElement),
            "${node.name}() does not handles exception:- $exceptionName\n thrown by function:- ${functionName}()"
        )
    }
}