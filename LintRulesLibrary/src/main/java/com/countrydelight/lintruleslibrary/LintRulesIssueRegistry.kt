package com.countrydelight.lintruleslibrary

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils

class LintRulesIssueRegistry : IssueRegistry() {
    override val issues: List<Issue>
        get() = listOf(
            IssuesUtils.InterfaceNameIssue,
            IssuesUtils.ActivityNameIssue,
            IssuesUtils.ApplicationNameIssue,
            IssuesUtils.FragmentNameIssue,
            IssuesUtils.BroadcastReceiverNameIssue,
            IssuesUtils.ViewModelNameIssue,
            IssuesUtils.EnumNameIssue,
            IssuesUtils.InterfaceImplementationNameIssue,
            IssuesUtils.StateNameIssue,
            IssuesUtils.StateFlowNameIssue,
            IssuesUtils.ListNameIssue,
            IssuesUtils.PackageNameIssue,
            IssuesUtils.DatabaseNameIssue,
            IssuesUtils.DaoNameIssue,
            IssuesUtils.EntityNameIssue,
            IssuesUtils.MapNameIssue,
            IssuesUtils.ServiceNameIssue
        )

}