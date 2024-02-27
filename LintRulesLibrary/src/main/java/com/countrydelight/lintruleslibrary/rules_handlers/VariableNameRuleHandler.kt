package com.countrydelight.lintruleslibrary.rules_handlers

import com.android.tools.lint.detector.api.JavaContext
import com.countrydelight.lintruleslibrary.utils.IssuesUtils
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
                IssuesUtils.StateFlowNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                IssuesUtils.StateFlowNameIssueText
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
                IssuesUtils.StateNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                IssuesUtils.StateNameIssueText
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
                IssuesUtils.MapNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                IssuesUtils.MapNameIssueText
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
                IssuesUtils.ListNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                IssuesUtils.ListNameIssueText
            )
        }
    }
}