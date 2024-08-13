package com.countrydelight.lintruleslibrary.kotlin_and_java.blocks

import com.android.tools.lint.detector.api.JavaContext
import com.countrydelight.lintruleslibrary.kotlin_and_java.blocks.LoopIssueUtils.NESTED_LOOP_ISSUE_TEXT
import org.jetbrains.uast.UElement

object LoopsRulesHandler {

    /**
     * Reports a nested loop issue in the code.
     *
     * @param node The UElement representing the loop that was detected as nested.
     * @param context The JavaContext used to report the issue.
     */
    fun handleNestedLoopRule(node: UElement, context: JavaContext) {
        context.report(
            LoopIssueUtils.NestedLoopIssue,
            node,
            context.getLocation(node),
            NESTED_LOOP_ISSUE_TEXT
        )
    }
}