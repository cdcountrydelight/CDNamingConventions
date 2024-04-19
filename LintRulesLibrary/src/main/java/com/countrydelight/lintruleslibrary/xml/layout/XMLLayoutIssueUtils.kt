package com.countrydelight.lintruleslibrary.xml.layout

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity

object XMLLayoutIssueUtils {

    private const val ID_NAME_ISSUE_TEXT =
        " ID name for an XML element must end with an underscore followed by a combination of uppercase letters in element"
    val IdNameIssue = Issue.create(
        id = "IdNameRule",
        briefDescription = ID_NAME_ISSUE_TEXT,
        explanation = ID_NAME_ISSUE_TEXT,
        category = Category.CORRECTNESS,
        severity = Severity.WARNING,
        implementation = Implementation(
            XMLLayoutRulesDetector::class.java,
            Scope.RESOURCE_FILE_SCOPE
        )
    )
}