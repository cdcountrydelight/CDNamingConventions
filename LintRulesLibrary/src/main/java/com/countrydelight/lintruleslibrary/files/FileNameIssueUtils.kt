package com.countrydelight.lintruleslibrary.files

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity

object FileNameIssueUtils {

    const val PACKAGE_NAME_ISSUE_TEXT =
        "Package name must be in snake case format for eg:- user_detail"
    val PackageNameIssue = Issue.create(
        "PackageNameRule",
        PACKAGE_NAME_ISSUE_TEXT,
        PACKAGE_NAME_ISSUE_TEXT,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(FileNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )
}