package com.countrydelight.lintruleslibrary.kotlin_and_java.functions

import com.android.tools.lint.detector.api.JavaContext
import com.countrydelight.lintruleslibrary.kotlin_and_java.functions.FunctionsIssueUtils.UPSERT_ISSUE_TEXT
import com.countrydelight.lintruleslibrary.utils.FunctionHelper
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


    /**
     * Handles the rule for checking the naming convention of functions that return a Boolean value.
     * @param node The method (UMethod) being analyzed by the Lint rule.
     * @param context The context in which the Lint check is being run, used to report issues.
     */
    fun handleBooleanFunctionNameRule(node: UMethod, context: JavaContext) {
        if (FunctionHelper.getValidStartingNamesOfBooleanVariablesAndFunctions()
                .none { node.name.startsWith(it) }
        ) {
            context.report(
                FunctionsIssueUtils.BooleanFunctionNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                "Functions of return type Boolean must start with any of the following predefined words: ${
                    FunctionHelper.getValidStartingNamesOfBooleanVariablesAndFunctions()
                        .joinToString(", ")
                }."
            )
        }
    }


    /**
     * Handles the rule for recommending the use of 'upsert' in place of 'insert'.
     * @param node The method (UMethod) being analyzed by the Lint rule.
     * @param context The context in which the Lint check is being run, used to report issues.
     */
    fun handleUseUpsertRuleInPlaceOfInsert(node: UMethod, context: JavaContext) {
        context.report(
            FunctionsIssueUtils.UseUpsertIssue,
            node,
            context.getLocation(node as UElement),
            UPSERT_ISSUE_TEXT
        )
    }
}