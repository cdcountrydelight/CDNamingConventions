package com.countrydelight.lintruleslibrary.kotlin_and_java.variables

import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UVariable

object VariableNameRuleHandler {
    /**
     * Handles the rule for variable names ending with "StateFlow".
     * @param node The UVariable node representing the variable to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleStateFlowNameRule(node: UVariable, context: JavaContext) {
        if (node.name?.endsWith("StateFlow") == false) {
            context.report(
                VariableNameIssueUtils.StateFlowNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                VariableNameIssueUtils.STATE_FLOW_NAME_ISSUE_TEXT
            )
        }
    }

    /**
     * Handles the rule for variable names ending with "State".
     * @param node The UVariable node representing the variable to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleStateNameRule(node: UVariable, context: JavaContext) {
        if (node.name?.endsWith("State") == false) {
            context.report(
                VariableNameIssueUtils.StateNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                VariableNameIssueUtils.STATE_NAME_ISSUE_TEXT
            )
        }
    }

    /**
     * Handles the rule for variable names ending with "Map".
     * @param node The UVariable node representing the variable to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleMapNameRule(node: UVariable, context: JavaContext) {
        if (node.name?.endsWith("Map") == false) {
            context.report(
                VariableNameIssueUtils.MapNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                VariableNameIssueUtils.MAP_NAME_ISSUE_TEXT
            )
        }
    }


    /**
     * Handles the rule for variable names ending with "List".
     * @param node The UVariable node representing the variable to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleListNameRule(node: UVariable, context: JavaContext) {
        if (node.name?.endsWith("List") == false) {
            context.report(
                VariableNameIssueUtils.ListNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                VariableNameIssueUtils.LIST_NAME_ISSUE_TEXT
            )
        }
    }
}