package com.countrydelight.lintruleslibrary.xml.layout

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity

object LayoutIssueUtils {

    private val layoutRuleCategory = Category(null, "Layout Rule", 102)


    private const val ID_NAME_ISSUE_TEXT =
        " ID name for an XML element must end with an underscore followed by a combination of uppercase letters in element"
    val IdNameIssue = Issue.create(
        id = "IdNameRule",
        briefDescription = ID_NAME_ISSUE_TEXT,
        explanation = ID_NAME_ISSUE_TEXT,
        category = layoutRuleCategory,
        severity = Severity.WARNING,
        implementation = Implementation(
            LayoutRulesDetector::class.java,
            Scope.RESOURCE_FILE_SCOPE
        )
    )


    const val LAYOUT_FILE_NAME_ISSUE_TEXT =
        "Layout file name must start with fragment_  for Fragment , activity_  for Activity , item_  for RecyclerView item , layout_  for any other layout "
    val LayoutFileNameRule = Issue.create(
        id = "LayoutFileNameRule",
        briefDescription = LAYOUT_FILE_NAME_ISSUE_TEXT,
        explanation = LAYOUT_FILE_NAME_ISSUE_TEXT,
        category = layoutRuleCategory,
        severity = Severity.WARNING,
        implementation = Implementation(
            LayoutRulesDetector::class.java,
            Scope.RESOURCE_FILE_SCOPE
        )
    )
}