package com.countrydelight.lintruleslibrary.utils

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import com.countrydelight.lintruleslibrary.RulesDetectors

object IssuesUtils {

    const val InterfaceNameIssueText = "Interface name must start with I"
    val InterfaceNameIssue = Issue.create(
        "InterfaceNameRule",
        InterfaceNameIssueText,
        InterfaceNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val ActivityNameIssueText = "Activity name must end with Activity"
    val ActivityNameIssue = Issue.create(
        "ActivityNameRule",
        ActivityNameIssueText,
        ActivityNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val ApplicationNameIssueText = "Application name must end with Application"
    val ApplicationNameIssue = Issue.create(
        "ApplicationNameRule",
        ApplicationNameIssueText,
        ApplicationNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val FragmentNameIssueText = "Fragment name must end with Fragment"
    val FragmentNameIssue = Issue.create(
        "FragmentNameRule",
        FragmentNameIssueText,
        FragmentNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val BroadcastReceiverNameIssueText = "Broadcast Receiver name must end with Receiver"
    val BroadcastReceiverNameIssue = Issue.create(
        "BroadcastReceiverNameRule",
        BroadcastReceiverNameIssueText,
        BroadcastReceiverNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )
    const val ServiceNameIssueText = "Service name must end with Service"
    val ServiceNameIssue = Issue.create(
        "ServiceNameRule",
        ServiceNameIssueText,
        ServiceNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val WorkerNameIssueText = "Worker name must end with Worker"
    val WorkerNameIssue = Issue.create(
        "WorkerNameRule",
        WorkerNameIssueText,
        WorkerNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val DatabaseNameIssueText = "Room Database name must end with Database"
    val DatabaseNameIssue = Issue.create(
        "DatabaseNameRule",
        DatabaseNameIssueText,
        DatabaseNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val ViewModelNameIssueText = "ViewModel name must end with ViewModel"
    val ViewModelNameIssue = Issue.create(
        "ViewModelNameRule",
        ViewModelNameIssueText,
        ViewModelNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val EnumNameIssueText = "Enum class must end with Enum"
    val EnumNameIssue = Issue.create(
        "EnumNameRule",
        EnumNameIssueText,
        EnumNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val InterfaceImplementationNameIssueText =
        "Interface implementation class must end with Impl"
    val InterfaceImplementationNameIssue = Issue.create(
        "InterfaceImplementationNameRule",
        InterfaceImplementationNameIssueText,
        InterfaceImplementationNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val StateFlowNameIssueText = "variables of type StateFlow must end with StateFlow"
    val StateFlowNameIssue = Issue.create(
        "StateFlowNameRule",
        StateFlowNameIssueText,
        StateFlowNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val StateNameIssueText = "variables of type State must end with State"
    val StateNameIssue = Issue.create(
        "StateNameRule",
        StateNameIssueText,
        StateNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val ListNameIssueText = "variables of type List must end with List"
    val ListNameIssue = Issue.create(
        "ListNameRule",
        ListNameIssueText,
        ListNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )

    const val MapNameIssueText = "variables of type Map must end with Map"
    val MapNameIssue = Issue.create(
        "MapNameRule",
        MapNameIssueText,
        MapNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )


    const val DaoNameIssueText =
        "Dao must end with Dao"
    val DaoNameIssue = Issue.create(
        "DaoNameRule",
        DaoNameIssueText,
        DaoNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )


    const val EntityIssueText =
        "Entity class name must end with Entity"
    val EntityNameIssue = Issue.create(
        "EntityNameRule",
        EntityIssueText,
        EntityIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )


    const val PackageNameIssueText =
        "Package name must be in snake case format for eg:- user_details"
    val PackageNameIssue = Issue.create(
        "PackageNameRule",
        PackageNameIssueText,
        PackageNameIssueText,
        Category.CORRECTNESS,
        6,
        Severity.WARNING,
        Implementation(RulesDetectors::class.java, Scope.JAVA_FILE_SCOPE)
    )


}