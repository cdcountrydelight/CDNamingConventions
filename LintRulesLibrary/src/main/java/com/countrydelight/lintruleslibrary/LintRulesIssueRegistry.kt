package com.countrydelight.lintruleslibrary

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import com.countrydelight.lintruleslibrary.kotlin_and_java.blocks.LoopIssueUtils
import com.countrydelight.lintruleslibrary.kotlin_and_java.classes.ClassesNameIssueUtils
import com.countrydelight.lintruleslibrary.kotlin_and_java.files.FileNameIssueUtils
import com.countrydelight.lintruleslibrary.kotlin_and_java.functions.FunctionsIssueUtils
import com.countrydelight.lintruleslibrary.kotlin_and_java.literals.LiteralIssueUtils
import com.countrydelight.lintruleslibrary.kotlin_and_java.variables.VariableNameIssueUtils
import com.countrydelight.lintruleslibrary.xml.layout.LayoutIssueUtils

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
                VariableNameIssueUtils.LiveDataNameIssue,
                VariableNameIssueUtils.GlobalVariableIssue,
                VariableNameIssueUtils.ProperVariableNameIssue,
                VariableNameIssueUtils.BooleanVariableNameIssue,
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
                //functions
                FunctionsIssueUtils.FunctionCommentIssue,
                FunctionsIssueUtils.FindViewByIdIssue,
                FunctionsIssueUtils.FunctionCommentIssue,
                FunctionsIssueUtils.FunctionExceptionHandlingIssue,
                FunctionsIssueUtils.BooleanFunctionNameIssue,
                FunctionsIssueUtils.ExperimentalFunctionIssue,
                FunctionsIssueUtils.UseUpsertIssue,
                //package
                FileNameIssueUtils.PackageNameIssue,
                //literals
                LiteralIssueUtils.HardCodedLiteralIssue,
                //loops
                LoopIssueUtils.NestedLoopIssue,
                // xml
                // layout
                LayoutIssueUtils.IdNameIssue,
                LayoutIssueUtils.LayoutFileNameRule
            )
        }
    override val api: Int
        get() = CURRENT_API

    override val minApi: Int
        get() = 8

    override val vendor: Vendor
        get() = Vendor(
            "Country Delight",
            "Country Delight",
            "https://countrydelight.in/contact-us",
            "info@countrydelight.in"
        )

}