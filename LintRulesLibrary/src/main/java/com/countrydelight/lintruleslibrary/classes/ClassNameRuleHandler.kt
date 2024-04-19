package com.countrydelight.lintruleslibrary.classes

import com.android.tools.lint.detector.api.JavaContext
import com.intellij.psi.PsiClass
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
                    ClassesNameIssueUtils.DaoNameIssue,
                    node,
                    context.getLocation(node as UElement),
                    ClassesNameIssueUtils.DAO_NAME_ISSUE_TEXT
                )
            }
        }
        //because annotation are internally treated as interface class
        else if (className.first() != 'I' && !node.text.contains("annotation")) {
            context.report(
                ClassesNameIssueUtils.InterfaceNameIssue,
                node,
                context.getLocation(node as UElement),
                ClassesNameIssueUtils.INTERFACE_NAME_ISSUE_TEXT
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
                ClassesNameIssueUtils.EnumNameIssue,
                node,
                context.getLocation(node as UElement),
                ClassesNameIssueUtils.ENUM_NAME_ISSUE_TEXT
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
                ClassesNameIssueUtils.EntityNameIssue,
                node,
                context.getLocation(node as UElement),
                ClassesNameIssueUtils.ENTITY_NAME_ISSUE_TEXT
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
                ClassesNameIssueUtils.BroadcastReceiverNameIssue,
                node,
                context.getLocation(node as UElement),
                ClassesNameIssueUtils.BROADCAST_RECEIVER_NAME_ISSUE_TEXT
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
                ClassesNameIssueUtils.ViewModelNameIssue,
                node,
                context.getLocation(node as UElement),
                ClassesNameIssueUtils.VIEW_MODEL_NAME_ISSUE_TEXT
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
                ClassesNameIssueUtils.FragmentNameIssue,
                node,
                context.getLocation(node as UElement),
                ClassesNameIssueUtils.FRAGMENT_NAME_ISSUE_TEXT
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
                ClassesNameIssueUtils.ApplicationNameIssue,
                node,
                context.getLocation(node as UElement),
                ClassesNameIssueUtils.APPLICATION_NAME_ISSUE_TEXT
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
                ClassesNameIssueUtils.ActivityNameIssue,
                node,
                context.getLocation(node as UElement),
                ClassesNameIssueUtils.ACTIVITY_NAME_ISSUE_TEXT
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
                ClassesNameIssueUtils.DatabaseNameIssue,
                node,
                context.getLocation(node as UElement),
                ClassesNameIssueUtils.DATABASE_NAME_ISSUE_TEXT
            )
        }
    }

    /**
     * Handles the rule for class names ending with "Impl".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handleInterfaceImplementationNameRule(
        node: UClass,
        context: JavaContext,
        superClasses: Array<PsiClass>
    ) {
        val className = node.name
        var showInterfaceImplementationWarning = true
        superClasses.forEach {
            val superClassName = it.name ?: return
            if (superClassName.endsWith("Activity")
                || superClassName.endsWith("BroadcastReceiver")
                || superClassName.endsWith("ViewModel")
                || superClassName.endsWith("Fragment")
                || superClassName.endsWith("Service")
                || superClassName.endsWith("Adapter")
            ) {
                showInterfaceImplementationWarning = false
            }
        }
        if (className != null && !className.endsWith("Impl") && showInterfaceImplementationWarning) {
            context.report(
                ClassesNameIssueUtils.InterfaceImplementationNameIssue,
                node,
                context.getLocation(node as UElement),
                ClassesNameIssueUtils.INTERFACE_IMPLEMENTATION_NAME_ISSUE_TEXT
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
                ClassesNameIssueUtils.ServiceNameIssue,
                node,
                context.getLocation(node as UElement),
                ClassesNameIssueUtils.SERVICE_NAME_ISSUE_TEXT
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
                ClassesNameIssueUtils.WorkerNameIssue,
                node,
                context.getLocation(node as UElement),
                ClassesNameIssueUtils.WORKER_NAME_ISSUE_TEXT
            )
        }
    }


}