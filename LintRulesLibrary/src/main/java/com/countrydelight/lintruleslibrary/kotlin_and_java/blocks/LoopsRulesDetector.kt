package com.countrydelight.lintruleslibrary.kotlin_and_java.blocks

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
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
        }
    }

    private fun checkNestedLoop(loopExpression: UElement, context: JavaContext) {
        var parent = loopExpression.uastParent
        while (parent != null) {
            if (parent is UForExpression || parent is UWhileExpression || parent is UDoWhileExpression || parent is UForEachExpression) {
                LoopsRulesHandler.handleNestedLoopRule(loopExpression, context)
                break
            }
            parent = parent.uastParent
        }
    }
}