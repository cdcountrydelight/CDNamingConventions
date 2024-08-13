package com.countrydelight.lintruleslibrary.kotlin_and_java.literals

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import com.countrydelight.lintruleslibrary.utils.CategoryPriorityHelper

object LiteralIssueUtils {
    private val literalsRuleCategory =
        Category(null, "Literals Rule", CategoryPriorityHelper.LITERALS_PRIORITY)


    const val HARDCODED_LITERAL_ISSUE_TEXT =
        "Use of hardcoded literals is discouraged, use constants/enum instead"
    val HardCodedLiteralIssue = Issue.create(
        "HardCodedLiteralsRule",
        HARDCODED_LITERAL_ISSUE_TEXT,
        HARDCODED_LITERAL_ISSUE_TEXT,
        literalsRuleCategory,
        6,
        Severity.WARNING,
        Implementation(LiteralsRulesDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )
}