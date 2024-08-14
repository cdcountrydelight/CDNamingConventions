package com.countrydelight.lintruleslibrary.kotlin_and_java.blocks

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import com.countrydelight.lintruleslibrary.utils.CategoryPriorityHelper

object LoopIssueUtils {
    private val loopsRuleCategory =
        Category(null, "Nested Loop Rule", CategoryPriorityHelper.LOOP_PRIORITY)

    const val NESTED_LOOP_ISSUE_TEXT =
        "Use of nested loop is discouraged try to optimize the solution or used kotlin in build functions."
    val NestedLoopIssue = Issue.create(
        "NestedLoopIssueRule",
        NESTED_LOOP_ISSUE_TEXT,
        NESTED_LOOP_ISSUE_TEXT,
        loopsRuleCategory,
        6,
        Severity.WARNING,
        Implementation(LoopsRulesDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )
}