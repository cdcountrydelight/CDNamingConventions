package com.countrydelight.lintruleslibrary.kotlin_and_java.functions

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import com.countrydelight.lintruleslibrary.utils.CategoryPriorityHelper

object FunctionsIssueUtils {

    private val functionsRuleCategory =
        Category(null, "Functions Rule", CategoryPriorityHelper.FUNCTION_PRIORITY)


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
        "Function should not be more than 100 lines, Try to break down function into smaller sub functions"
    val FunctionMaxLengthIssue = Issue.create(
        "FunctionMaxLengthRule",
        FUNCTION_MAX_LENGTH_ISSUE_TEXT,
        FUNCTION_MAX_LENGTH_ISSUE_TEXT,
        functionsRuleCategory,
        6,
        Severity.WARNING,
        Implementation(FunctionsRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    private const val FUNCTION_EXCEPTION_HANDLING_ISSUE_TEXT =
        "Every Function must handle the exception either in try catch or must  throw exception"
    val FunctionExceptionHandlingIssue = Issue.create(
        "FunctionExceptionHandlingRule",
        FUNCTION_EXCEPTION_HANDLING_ISSUE_TEXT,
        FUNCTION_EXCEPTION_HANDLING_ISSUE_TEXT,
        functionsRuleCategory,
        6,
        Severity.WARNING,
        Implementation(FunctionsRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)

    )

    private const val BOOLEAN_FUNCTION_NAME_ISSUE_TEXT =
        "Functions of return type Boolean must start with predefined words"
    val BooleanFunctionNameIssue = Issue.create(
        id = "BooleanFunctionNameRule",
        briefDescription = BOOLEAN_FUNCTION_NAME_ISSUE_TEXT,
        explanation = BOOLEAN_FUNCTION_NAME_ISSUE_TEXT,
        category = functionsRuleCategory,
        priority = 6,
        severity = Severity.WARNING,
        implementation = Implementation(FunctionsRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val EXPERIMENTAL_FUNCTION_ISSUE_TEXT =
        "Use of Experimental api is discouraged as it may leads to potential issues"
    val ExperimentalFunctionIssue = Issue.create(
        "ExperimentalApiRule",
        EXPERIMENTAL_FUNCTION_ISSUE_TEXT,
        EXPERIMENTAL_FUNCTION_ISSUE_TEXT,
        functionsRuleCategory,
        6,
        Severity.WARNING,
        Implementation(FunctionsRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)

    )

    const val UPSERT_ISSUE_TEXT =
        "Use @Upsert instead of @Insert(onConflict = OnConflictStrategy.REPLACE) for better performance"
    val UseUpsertIssue = Issue.create(
        "UpsertRule",
        UPSERT_ISSUE_TEXT,
        UPSERT_ISSUE_TEXT,
        functionsRuleCategory,
        6,
        Severity.WARNING,
        Implementation(FunctionsRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)

    )
}