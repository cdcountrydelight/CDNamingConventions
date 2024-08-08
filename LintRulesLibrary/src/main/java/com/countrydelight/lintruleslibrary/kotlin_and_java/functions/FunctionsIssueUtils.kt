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
}