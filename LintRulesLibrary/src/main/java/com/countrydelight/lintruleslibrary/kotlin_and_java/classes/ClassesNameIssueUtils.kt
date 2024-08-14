package com.countrydelight.lintruleslibrary.kotlin_and_java.classes

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import com.countrydelight.lintruleslibrary.utils.CategoryPriorityHelper

object ClassesNameIssueUtils {

    private val classRuleCategory =
        Category(null, "Class Rule", CategoryPriorityHelper.CLASS_PRIORITY)

    const val INTERFACE_NAME_ISSUE_TEXT = "Interface name must start with I"
    val InterfaceNameIssue = Issue.create(
        "InterfaceNameRule",
        INTERFACE_NAME_ISSUE_TEXT,
        INTERFACE_NAME_ISSUE_TEXT,
        classRuleCategory,
        6,
        Severity.WARNING,
        Implementation(ClassNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val ACTIVITY_NAME_ISSUE_TEXT = "Activity name must end with Activity"
    val ActivityNameIssue = Issue.create(
        "ActivityNameRule",
        ACTIVITY_NAME_ISSUE_TEXT,
        ACTIVITY_NAME_ISSUE_TEXT,
        classRuleCategory,
        6,
        Severity.WARNING,
        Implementation(ClassNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val APPLICATION_NAME_ISSUE_TEXT = "Application name must end with Application"
    val ApplicationNameIssue = Issue.create(
        "ApplicationNameRule",
        APPLICATION_NAME_ISSUE_TEXT,
        APPLICATION_NAME_ISSUE_TEXT,
        classRuleCategory,
        6,
        Severity.WARNING,
        Implementation(ClassNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val FRAGMENT_NAME_ISSUE_TEXT = "Fragment name must end with Fragment"
    val FragmentNameIssue = Issue.create(
        "FragmentNameRule",
        FRAGMENT_NAME_ISSUE_TEXT,
        FRAGMENT_NAME_ISSUE_TEXT,
        classRuleCategory,
        6,
        Severity.WARNING,
        Implementation(ClassNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val BROADCAST_RECEIVER_NAME_ISSUE_TEXT = "Broadcast Receiver name must end with Receiver"
    val BroadcastReceiverNameIssue = Issue.create(
        "BroadcastReceiverNameRule",
        BROADCAST_RECEIVER_NAME_ISSUE_TEXT,
        BROADCAST_RECEIVER_NAME_ISSUE_TEXT,
        classRuleCategory,
        6,
        Severity.WARNING,
        Implementation(ClassNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )
    const val SERVICE_NAME_ISSUE_TEXT = "Service name must end with Service"
    val ServiceNameIssue = Issue.create(
        "ServiceNameRule",
        SERVICE_NAME_ISSUE_TEXT,
        SERVICE_NAME_ISSUE_TEXT,
        classRuleCategory,
        6,
        Severity.WARNING,
        Implementation(ClassNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val WORKER_NAME_ISSUE_TEXT = "Worker name must end with Worker"
    val WorkerNameIssue = Issue.create(
        "WorkerNameRule",
        WORKER_NAME_ISSUE_TEXT,
        WORKER_NAME_ISSUE_TEXT,
        classRuleCategory,
        6,
        Severity.WARNING,
        Implementation(ClassNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val DATABASE_NAME_ISSUE_TEXT = "Room Database name must end with Database"
    val DatabaseNameIssue = Issue.create(
        "DatabaseNameRule",
        DATABASE_NAME_ISSUE_TEXT,
        DATABASE_NAME_ISSUE_TEXT,
        classRuleCategory,
        6,
        Severity.WARNING,
        Implementation(ClassNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val VIEW_MODEL_NAME_ISSUE_TEXT = "ViewModel name must end with ViewModel"
    val ViewModelNameIssue = Issue.create(
        "ViewModelNameRule",
        VIEW_MODEL_NAME_ISSUE_TEXT,
        VIEW_MODEL_NAME_ISSUE_TEXT,
        classRuleCategory,
        6,
        Severity.WARNING,
        Implementation(ClassNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val ENUM_NAME_ISSUE_TEXT = "Enum class name must end with Enum"
    val EnumNameIssue = Issue.create(
        "EnumNameRule",
        ENUM_NAME_ISSUE_TEXT,
        ENUM_NAME_ISSUE_TEXT,
        classRuleCategory,
        6,
        Severity.WARNING,
        Implementation(ClassNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val INTERFACE_IMPLEMENTATION_NAME_ISSUE_TEXT =
        "Interface implementation class must end with Impl"
    val InterfaceImplementationNameIssue = Issue.create(
        "InterfaceImplementationNameRule",
        "hello",
        "hello",
        classRuleCategory,
        6,
        Severity.WARNING,
        Implementation(ClassNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )


    const val DAO_NAME_ISSUE_TEXT =
        "Dao must end with Dao"
    val DaoNameIssue = Issue.create(
        "DaoNameRule",
        DAO_NAME_ISSUE_TEXT,
        DAO_NAME_ISSUE_TEXT,
        classRuleCategory,
        6,
        Severity.WARNING,
        Implementation(ClassNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )


    const val ENTITY_NAME_ISSUE_TEXT =
        "Entity class name must end with Entity"
    val EntityNameIssue = Issue.create(
        "EntityNameRule",
        ENTITY_NAME_ISSUE_TEXT,
        ENTITY_NAME_ISSUE_TEXT,
        classRuleCategory,
        6,
        Severity.WARNING,
        Implementation(ClassNameRuleDetector::class.java, Scope.JAVA_FILE_SCOPE)
    )
}