package com.countrydelight.lintruleslibrary.kotlin_and_java.functions

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity

object FunctionsIssueUtils {

    private val functionsRuleCategory = Category(null, "Functions Rule", 99)


    const val FUNCTION_COMMENT_ISSUE_TEXT =
        "Every function must have a comment"
    val FunctionCommentIssue = Issue.create(
        "FunctionCommentRule",
        FUNCTION_COMMENT_ISSUE_TEXT,
        FUNCTION_COMMENT_ISSUE_TEXT,
        functionsRuleCategory,
        6,
        Severity.WARNING,
        Implementation(FunctionsRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val FIND_VIEW_BY_ID_ISSUE_TEXT =
        "Using findViewById is discouraged. Use ViewBinding/DataBinding instead."
    val FindViewByIdIssue = Issue.create(
        "FindViewByIdRule",
        FIND_VIEW_BY_ID_ISSUE_TEXT,
        FIND_VIEW_BY_ID_ISSUE_TEXT,
        functionsRuleCategory,
        6,
        Severity.WARNING,
        Implementation(FunctionsRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val FUNCTION_MAX_LENGTH_ISSUE_TEXT =
        "Function length should not be greater than 100 line, try to break the function into smaller sub functions."
    val FunctionMaxLengthIssue = Issue.create(
        "FunctionMaxLengthRuleRule",
        FUNCTION_MAX_LENGTH_ISSUE_TEXT,
        FUNCTION_MAX_LENGTH_ISSUE_TEXT,
        functionsRuleCategory,
        6,
        Severity.WARNING,
        Implementation(FunctionsRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val FUNCTION_EXCEPTION_HANDLE_ISSUE_TEXT =
        ""
    val FunctionExceptionHandleIssue = Issue.create(
        "FunctionExceptionHandleRule",
        FUNCTION_EXCEPTION_HANDLE_ISSUE_TEXT,
        FUNCTION_EXCEPTION_HANDLE_ISSUE_TEXT,
        functionsRuleCategory,
        6,
        Severity.WARNING,
        Implementation(FunctionsRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )
}