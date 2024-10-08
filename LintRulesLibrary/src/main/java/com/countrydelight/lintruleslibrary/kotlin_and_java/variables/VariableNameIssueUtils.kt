package com.countrydelight.lintruleslibrary.kotlin_and_java.variables

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import com.countrydelight.lintruleslibrary.utils.CategoryPriorityHelper

object VariableNameIssueUtils {

    private val variableRuleCategory =
        Category(null, "Variable Rule", CategoryPriorityHelper.VARIABLES_PRIORITY)


    const val STATE_FLOW_NAME_ISSUE_TEXT =
        "variables of type StateFlow must end with StateFlow"
    val StateFlowNameIssue = Issue.create(
        "StateFlowNameRule",
        STATE_FLOW_NAME_ISSUE_TEXT,
        STATE_FLOW_NAME_ISSUE_TEXT,
        variableRuleCategory,
        6,
        Severity.WARNING,
        Implementation(VariableNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val STATE_NAME_ISSUE_TEXT = "variables of type State must end with State"
    val StateNameIssue = Issue.create(
        "StateNameRule",
        STATE_NAME_ISSUE_TEXT,
        STATE_NAME_ISSUE_TEXT,
        variableRuleCategory,
        6,
        Severity.WARNING,
        Implementation(VariableNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val LIST_NAME_ISSUE_TEXT = "variables of type List must end with List"
    val ListNameIssue = Issue.create(
        "ListNameRule",
        LIST_NAME_ISSUE_TEXT,
        LIST_NAME_ISSUE_TEXT,
        variableRuleCategory,
        6,
        Severity.WARNING,
        Implementation(VariableNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val MAP_NAME_ISSUE_TEXT = "variables of type Map must end with Map"
    val MapNameIssue = Issue.create(
        "MapNameRule",
        MAP_NAME_ISSUE_TEXT,
        MAP_NAME_ISSUE_TEXT,
        variableRuleCategory,
        6,
        Severity.WARNING,
        Implementation(VariableNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val LIVE_DATA_NAME_ISSUE_TEXT = "variables of type LiveData must end with LiveData"
    val LiveDataNameIssue = Issue.create(
        "LiveDataNameRule",
        LIVE_DATA_NAME_ISSUE_TEXT,
        LIVE_DATA_NAME_ISSUE_TEXT,
        variableRuleCategory,
        6,
        Severity.WARNING,
        Implementation(VariableNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    private const val GLOBAL_VARIABLE_ISSUE_TEXT = "Global variable can be declared locally"
    val GlobalVariableIssue = Issue.create(
        id = "GlobalVariableRule",
        briefDescription = GLOBAL_VARIABLE_ISSUE_TEXT,
        explanation = GLOBAL_VARIABLE_ISSUE_TEXT,
        category = variableRuleCategory,
        priority = 6,
        severity = Severity.WARNING,
        implementation = Implementation(VariableNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )


    const val PROPER_VARIABLE_NAME_ISSUE_TEXT =
        "Variable name must adhere the actual use case of the variable,Please use some meaning full variable name"
    val ProperVariableNameIssue = Issue.create(
        id = "ProperVariableNameRule",
        briefDescription = PROPER_VARIABLE_NAME_ISSUE_TEXT,
        explanation = PROPER_VARIABLE_NAME_ISSUE_TEXT,
        category = variableRuleCategory,
        priority = 6,
        severity = Severity.WARNING,
        implementation = Implementation(VariableNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    private const val BOOLEAN_VARIABLE_NAME_ISSUE_TEXT =
        "Boolean Variables must start with predefined words"
    val BooleanVariableNameIssue = Issue.create(
        id = "BooleanVariableNameRule",
        briefDescription = BOOLEAN_VARIABLE_NAME_ISSUE_TEXT,
        explanation = BOOLEAN_VARIABLE_NAME_ISSUE_TEXT,
        category = variableRuleCategory,
        priority = 6,
        severity = Severity.WARNING,
        implementation = Implementation(VariableNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )
}