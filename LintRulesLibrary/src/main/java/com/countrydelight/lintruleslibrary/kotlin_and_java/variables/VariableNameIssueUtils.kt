package com.countrydelight.lintruleslibrary.kotlin_and_java.variables

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity

object VariableNameIssueUtils {
    const val STATE_FLOW_NAME_ISSUE_TEXT =
        "variables of type StateFlow must end with StateFlow"
    val StateFlowNameIssue = Issue.create(
        "StateFlowNameRule",
        STATE_FLOW_NAME_ISSUE_TEXT,
        STATE_FLOW_NAME_ISSUE_TEXT,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(VariableNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val STATE_NAME_ISSUE_TEXT = "variables of type State must end with State"
    val StateNameIssue = Issue.create(
        "StateNameRule",
        STATE_NAME_ISSUE_TEXT,
        STATE_NAME_ISSUE_TEXT,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(VariableNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val LIST_NAME_ISSUE_TEXT = "variables of type List must end with List"
    val ListNameIssue = Issue.create(
        "ListNameRule",
        LIST_NAME_ISSUE_TEXT,
        LIST_NAME_ISSUE_TEXT,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(VariableNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val MAP_NAME_ISSUE_TEXT = "variables of type Map must end with Map"
    val MapNameIssue = Issue.create(
        "MapNameRule",
        MAP_NAME_ISSUE_TEXT,
        MAP_NAME_ISSUE_TEXT,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(VariableNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val LIVE_DATA_NAME_ISSUE_TEXT = "variables of type LiveData must end with LiveData"
    val LiveDataNameIssue = Issue.create(
        "LiveDataNameRule",
        LIVE_DATA_NAME_ISSUE_TEXT,
        LIVE_DATA_NAME_ISSUE_TEXT,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(VariableNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )
}