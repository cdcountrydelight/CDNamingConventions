package com.countrydelight.lintruleslibrary.kotlin_and_java.functions

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity

object FunctionsIssueUtils {

    const val FUNCTION_COMMENT_ISSUE_TEXT =
        "Every function must have a comment"
    val FunctionCommentIssue = Issue.create(
        "FunctionCommentRule",
        FUNCTION_COMMENT_ISSUE_TEXT,
        FUNCTION_COMMENT_ISSUE_TEXT,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(FunctionsRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )
}