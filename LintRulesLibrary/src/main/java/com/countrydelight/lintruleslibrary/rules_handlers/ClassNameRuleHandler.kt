package com.countrydelight.lintruleslibrary.rules_handlers

import com.android.tools.lint.detector.api.JavaContext
import com.countrydelight.lintruleslibrary.utils.IssuesUtils
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement

internal object ClassNameRuleHandler {
    /**
     * Handles the rule for class names of type interface.
     * @param node The UClass node to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleInterfaceNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        val isDao = node.annotations.any { it.text.contains("Dao") }
        if (className == null) return
        if (isDao) {
            if (!className.endsWith("Dao")) {
                context.report(
                    IssuesUtils.DaoNameIssue,
                    node,
                    context.getLocation(node as UElement),
                    IssuesUtils.DaoNameIssueText
                )
            }
        }
        //because annotation are internally treated as interface class
        else if (className.first() != 'I' && !node.text.contains("annotation")) {
            context.report(
                IssuesUtils.InterfaceNameIssue,
                node,
                context.getLocation(node as UElement),
                IssuesUtils.InterfaceNameIssueText
            )
        }
    }

    /**
     * Handles the rule for class names ending with "Enum".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleEnumNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Enum")) {
            context.report(
                IssuesUtils.EnumNameIssue,
                node,
                context.getLocation(node as UElement),
                IssuesUtils.EnumNameIssueText
            )
        }
    }

    /**
     * Handles the rule for class names ending with "Entity".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleEntityNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Entity")) {
            context.report(
                IssuesUtils.EntityNameIssue,
                node,
                context.getLocation(node as UElement),
                IssuesUtils.EntityIssueText
            )
        }
    }

    /**
     * Handles the rule for class names ending with "BroadcastReceiver".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleBroadcastReceiverNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Receiver")) {
            context.report(
                IssuesUtils.BroadcastReceiverNameIssue,
                node,
                context.getLocation(node as UElement),
                IssuesUtils.BroadcastReceiverNameIssueText
            )
        }
    }

    /**
     * Handles the rule for class names ending with "ViewModel".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleViewModelNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("ViewModel")) {
            context.report(
                IssuesUtils.ViewModelNameIssue,
                node,
                context.getLocation(node as UElement),
                IssuesUtils.ViewModelNameIssueText
            )
        }
    }


    /**
     * Handles the rule for class names ending with "Fragment".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleFragmentNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Fragment")) {
            context.report(
                IssuesUtils.FragmentNameIssue,
                node,
                context.getLocation(node as UElement),
                IssuesUtils.FragmentNameIssueText
            )
        }
    }

    /**
     * Handles the rule for class names ending with "Application".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleApplicationNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Application")) {
            context.report(
                IssuesUtils.ApplicationNameIssue,
                node,
                context.getLocation(node as UElement),
                IssuesUtils.ApplicationNameIssueText
            )
        }
    }


    /**
     * Handles the rule for class names ending with "Activity".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleActivityNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Activity")) {
            context.report(
                IssuesUtils.ActivityNameIssue,
                node,
                context.getLocation(node as UElement),
                IssuesUtils.ActivityNameIssueText
            )
        }
    }

    /**
     * Handles the rule for class names ending with "Database".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleDatabaseNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Database")) {
            context.report(
                IssuesUtils.DatabaseNameIssue,
                node,
                context.getLocation(node as UElement),
                IssuesUtils.DatabaseNameIssueText
            )
        }
    }

    /**
     * Handles the rule for class names ending with "Impl".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleInterfaceImplementationNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Impl")) {
            context.report(
                IssuesUtils.InterfaceImplementationNameIssue,
                node,
                context.getLocation(node as UElement),
                IssuesUtils.InterfaceImplementationNameIssueText
            )
        }
    }

    /**
     * Handles the rule for class names ending with "Service".
     * @param node The UClass node to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleServiceNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Service")) {
            context.report(
                IssuesUtils.ServiceNameIssue,
                node,
                context.getLocation(node as UElement),
                IssuesUtils.ServiceNameIssueText
            )
        }
    }

    /**
     * Handles the rule for class names ending with "Worker".
     * @param node The UClass node to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleWorkerNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Worker")) {
            context.report(
                IssuesUtils.WorkerNameIssue,
                node,
                context.getLocation(node as UElement),
                IssuesUtils.WorkerNameIssueText
            )
        }
    }


}