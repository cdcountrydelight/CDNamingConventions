package com.countrydelight.lintruleslibrary.classes

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement

class ClassNameRuleDetector : Detector(), Detector.UastScanner {
    override fun getApplicableUastTypes(): List<Class<out UElement>> {
        return listOf(UClass::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {
            override fun visitClass(node: UClass) {
                val className = node.name
                if (className != null) {
                    val superClassList = node.supers
                    if (node.isInterface) {
                        ClassNameRuleHandler.handleInterfaceNameRule(node, context)
                    } else if (node.isEnum) {
                        ClassNameRuleHandler.handleEnumNameRule(node, context)
                    } else if (node.annotations.any { it.text.endsWith("Entity") }) {
                        ClassNameRuleHandler.handleEntityNameRule(node, context)
                    } else if (superClassList.isNotEmpty()) {
                        superClassList.forEach { superClass ->
                            val superClassName = superClass.name ?: return
                            if (superClassName.endsWith("Activity")) {
                                ClassNameRuleHandler.handleActivityNameRule(node, context)
                            } else if (superClassName.endsWith("Application")) {
                                ClassNameRuleHandler.handleApplicationNameRule(node, context)
                            } else if (superClassName.endsWith("Fragment")) {
                                ClassNameRuleHandler.handleFragmentNameRule(node, context)
                            } else if (superClassName.endsWith("BroadcastReceiver")) {
                                ClassNameRuleHandler.handleBroadcastReceiverNameRule(node, context)
                            } else if (superClassName.endsWith("ViewModel")) {
                                ClassNameRuleHandler.handleViewModelNameRule(node, context)
                            } else if (superClassName.endsWith("RoomDatabase")) {
                                ClassNameRuleHandler.handleDatabaseNameRule(node, context)
                            } else if (superClass.isInterface && superClassName.startsWith("I")) {
                                ClassNameRuleHandler.handleInterfaceImplementationNameRule(
                                    node,
                                    context,
                                    node.supers
                                )
                            } else if (superClassName.endsWith("Service")) {
                                ClassNameRuleHandler.handleServiceNameRule(node, context)
                            } else if (superClassName.endsWith("Worker")) {
                                ClassNameRuleHandler.handleWorkerNameRule(node, context)
                            }
                        }
                    }
                }
            }
        }
    }
}