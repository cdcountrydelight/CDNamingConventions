package com.countrydelight.lintruleslibrary.kotlin_and_java.variables

import com.android.tools.lint.detector.api.JavaContext
import com.countrydelight.lintruleslibrary.utils.FunctionHelper
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UVariable

object VariableNameRuleHandler {
    /**
     * Handles the rule for variable names ending with "StateFlow".
     * @param node The UVariable node representing the variable to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleStateFlowNameRule(node: UVariable, context: JavaContext) {
        if (isValidName(node) && node.name?.endsWith("StateFlow") == false) {
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
        if (isValidName(node) && node.name?.endsWith("State") == false) {
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
        if (isValidName(node) && node.name?.endsWith("Map") == false) {
            context.report(
                VariableNameIssueUtils.MapNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                VariableNameIssueUtils.MAP_NAME_ISSUE_TEXT
            )
        }
    }


    /**
     * Handles the naming rule for LiveData variables.
     *
     * @param node the UVariable representing the LiveData variable
     * @param context the Java context
     */
    fun handleLiveDataNameRule(node: UVariable, context: JavaContext) {
        if (isValidName(node) && node.name?.endsWith("LiveData") == false) {
            context.report(
                VariableNameIssueUtils.MapNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                VariableNameIssueUtils.LIVE_DATA_NAME_ISSUE_TEXT
            )
        }
    }


    /**
     * Handles the rule for variable names ending with "List".
     * @param node The UVariable node representing the variable to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleListNameRule(node: UVariable, context: JavaContext) {
        if (isValidName(node) && node.name?.endsWith("List") == false) {
            context.report(
                VariableNameIssueUtils.ListNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                VariableNameIssueUtils.LIST_NAME_ISSUE_TEXT
            )
        }
    }

    /**
     * Handles the rule for reporting global variable name issues.
     *
     * This function reports an issue if a global variable is found that can be declared locally inside a function.
     *
     * @param node The variable node to check.
     * @param context The context in which the check is performed.
     * @param functionName The name of the function where the variable can be declared locally.
     */
    fun handleGlobalVariableNameRule(node: UVariable, context: JavaContext, functionName: String) {
        context.report(
            VariableNameIssueUtils.GlobalVariableIssue,
            node as UElement,
            context.getLocation(node as UElement),
            "Global variable can be declared locally inside: $functionName()"
        )
    }


    /**
     * Handles the rule for ensuring proper naming conventions for variables.
     *
     * @param node The variable (UVariable) being analyzed by the Lint rule.
     * @param context The context in which the Lint check is being run, used to report issues.
     */
    fun handleProperVariableNameRule(node: UVariable, context: JavaContext) {
        if (isValidName(node)) {
            context.report(
                VariableNameIssueUtils.ProperVariableNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                VariableNameIssueUtils.PROPER_VARIABLE_NAME_ISSUE_TEXT
            )
        }
    }

    /**
     * Handles the rule for ensuring proper naming conventions for Boolean variables.
     *
     * @param node The variable (UVariable) being analyzed by the Lint rule.
     * @param context The context in which the Lint check is being run, used to report issues.
     */
    fun handleBooleanVariableNameRule(node: UVariable, context: JavaContext) {
        if (isValidName(node)
            && FunctionHelper.getValidStartingNamesOfBooleanVariablesAndFunctions()
                .none { node.name?.startsWith(it) == true }
        ) {
            context.report(
                VariableNameIssueUtils.BooleanVariableNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                "Boolean variables names must start with any of the following predefined words: ${
                    FunctionHelper.getValidStartingNamesOfBooleanVariablesAndFunctions()
                        .joinToString(", ")
                }."
            )
        }
    }


    /**
     * Checks if the given variable node has a valid name.
     *
     * This function ensures that the name of the variable node is not null and does not contain the substring "<set-?>".
     *
     * @param node The variable node to check.
     * @return `true` if the variable node's name is not null and does not contain "<set-?>"; `false` otherwise.
     */
    private fun isValidName(node: UVariable): Boolean {
        return node.name != null && node.name?.contains("<set-?>") == false && node.isPhysical
    }
}