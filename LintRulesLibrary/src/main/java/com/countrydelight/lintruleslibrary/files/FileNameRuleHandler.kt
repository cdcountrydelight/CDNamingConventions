package com.countrydelight.lintruleslibrary.files

import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UFile

object FileNameRuleHandler {
    /**
     * Handles the rule for package names adhering to snake case convention.
     * @param node The UFile node representing the package to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    fun handlePackageNameRule(node: UFile, context: JavaContext) {
        val packageName = node.packageName.substringAfterLast(".")
        if (!isValidSnakeCase(packageName)) {
            context.report(
                FileNameIssueUtils.PackageNameIssue,
                node,
                context.getLocation(node),
                FileNameIssueUtils.PACKAGE_NAME_ISSUE_TEXT
            )
        }
    }


    /**
     * Checks if a string adheres to snake case convention.
     * @param name The string to check.
     * @return True if the string is in snake case format, false otherwise.
     */
    private fun isValidSnakeCase(name: String): Boolean {
        return name.matches(Regex("^[a-z][a-z0-9_]*$"))
    }
}