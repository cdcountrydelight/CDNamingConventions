package com.countrydelight.lintruleslibrary

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import com.countrydelight.lintruleslibrary.classes.ClassesNameIssueUtils
import com.countrydelight.lintruleslibrary.files.FileNameIssueUtils
import com.countrydelight.lintruleslibrary.variables.VariableNameIssueUtils

class LintRulesIssueRegistry : IssueRegistry() {
    override val issues: List<Issue>
        get() {
            val issueList = listOf(
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
            )
            println("Issues:- ${issueList.joinToString { it.id }}")
            return issueList
        }
    override val api: Int
        get() = CURRENT_API

    override val minApi: Int
        get() = 8


}