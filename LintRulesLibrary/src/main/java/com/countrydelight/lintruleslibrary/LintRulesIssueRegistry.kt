package com.countrydelight.lintruleslibrary

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import com.countrydelight.lintruleslibrary.kotlin_and_java.classes.ClassesNameIssueUtils
import com.countrydelight.lintruleslibrary.kotlin_and_java.files.FileNameIssueUtils
import com.countrydelight.lintruleslibrary.kotlin_and_java.variables.VariableNameIssueUtils
import com.countrydelight.lintruleslibrary.xml.layout.XMLLayoutIssueUtils

class LintRulesIssueRegistry : IssueRegistry() {
    override val issues: List<Issue>
        get() {
            return listOf(
                // kotlin+java
                //variables
                VariableNameIssueUtils.ListNameIssue,
                VariableNameIssueUtils.MapNameIssue,
                VariableNameIssueUtils.StateNameIssue,
                VariableNameIssueUtils.StateFlowNameIssue,
                //classes
                ClassesNameIssueUtils.DatabaseNameIssue,
                ClassesNameIssueUtils.DaoNameIssue,
                ClassesNameIssueUtils.EntityNameIssue,
                ClassesNameIssueUtils.ServiceNameIssue,
                ClassesNameIssueUtils.WorkerNameIssue,
                ClassesNameIssueUtils.InterfaceNameIssue,
                ClassesNameIssueUtils.ActivityNameIssue,
                ClassesNameIssueUtils.ApplicationNameIssue,
                ClassesNameIssueUtils.FragmentNameIssue,
                ClassesNameIssueUtils.BroadcastReceiverNameIssue,
                ClassesNameIssueUtils.ViewModelNameIssue,
                ClassesNameIssueUtils.EnumNameIssue,
                ClassesNameIssueUtils.InterfaceImplementationNameIssue,
                //package
                FileNameIssueUtils.PackageNameIssue,
                // xml
                // layout
                XMLLayoutIssueUtils.IdNameIssue,
                XMLLayoutIssueUtils.LayoutFileNameRule
            )
        }
    override val api: Int
        get() = CURRENT_API

    override val minApi: Int
        get() = 8


}