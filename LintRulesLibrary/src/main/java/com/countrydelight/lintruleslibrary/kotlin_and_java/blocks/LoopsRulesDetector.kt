package com.countrydelight.lintruleslibrary.kotlin_and_java.blocks

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UCallExpression
import org.jetbrains.uast.UDoWhileExpression
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UForEachExpression
import org.jetbrains.uast.UForExpression
import org.jetbrains.uast.UWhileExpression


class LoopsRulesDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes(): List<Class<out UElement>> {
        return listOf(
            UForExpression::class.java,
            UDoWhileExpression::class.java,
            UWhileExpression::class.java,
            UForEachExpression::class.java,
            UCallExpression::class.java
        )
    }

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {
            override fun visitForExpression(node: UForExpression) {
                checkNestedLoop(node, context)
            }

            override fun visitForEachExpression(node: UForEachExpression) {
                checkNestedLoop(node, context)
            }

            override fun visitDoWhileExpression(node: UDoWhileExpression) {
                checkNestedLoop(node, context)
            }

            override fun visitWhileExpression(node: UWhileExpression) {
                checkNestedLoop(node, context)
            }

            override fun visitCallExpression(node: UCallExpression) {
                if (node.methodName == "forEach") {
                    checkNestedLoop(node, context)
                }
            }
        }
    }

    /**
     * Checks if the given UElement represents a loop that is nested inside another loop.
     *
     * @param loopExpression The UElement representing the current loop expression.
     * @param context The JavaContext for reporting issues.
     */
    private fun checkNestedLoop(loopExpression: UElement, context: JavaContext) {
        var parent = loopExpression.uastParent
        while (parent != null) {
            if (parent is UForExpression || parent is UWhileExpression || parent is UDoWhileExpression
                || parent is UForEachExpression || isForEachCall(parent)
            ) {
                LoopsRulesHandler.handleNestedLoopRule(loopExpression, context)
                break
            }
            parent = parent.uastParent
        }
    }


    /**
     * Checks if the given UElement represents a call to the `forEach` method.
     *
     * @param element The UElement to check.
     * @return `true` if the element is a UCallExpression with the method name "forEach", otherwise `false`.
     */
    private fun isForEachCall(element: UElement): Boolean {
        return element is UCallExpression && element.methodName == "forEach"
    }
}