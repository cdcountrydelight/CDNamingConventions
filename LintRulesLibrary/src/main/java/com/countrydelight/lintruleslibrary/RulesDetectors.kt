package com.countrydelight.lintruleslibrary

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import com.countrydelight.lintruleslibrary.rules_handlers.ClassNameRuleHandler.handleActivityNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.ClassNameRuleHandler.handleApplicationNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.ClassNameRuleHandler.handleBroadcastReceiverNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.ClassNameRuleHandler.handleDatabaseNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.ClassNameRuleHandler.handleEntityNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.ClassNameRuleHandler.handleEnumNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.ClassNameRuleHandler.handleFragmentNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.ClassNameRuleHandler.handleInterfaceImplementationNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.ClassNameRuleHandler.handleInterfaceNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.ClassNameRuleHandler.handleServiceNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.ClassNameRuleHandler.handleViewModelNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.ClassNameRuleHandler.handleWorkerNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.FileNameRuleHandler.handlePackageNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.VariableNameRuleHandler.handleListNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.VariableNameRuleHandler.handleMapNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.VariableNameRuleHandler.handleStateFlowNameRule
import com.countrydelight.lintruleslibrary.rules_handlers.VariableNameRuleHandler.handleStateNameRule
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UFile
import org.jetbrains.uast.UVariable

class RulesDetectors : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes(): List<Class<out UElement>> {
        return listOf(
            UClass::class.java,
            UVariable::class.java,
            UFile::class.java
        )
    }

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {

            override fun visitFile(node: UFile) {
                handlePackageNameRule(node, context)
            }

            override fun visitClass(node: UClass) {
                val className = node.name
                if (className != null) {
                    val superClassList = node.supers
                    if (node.isInterface) {
                        handleInterfaceNameRule(node, context)
                    } else if (node.isEnum) {
                        handleEnumNameRule(node, context)
                    } else if (node.annotations.any { it.text.endsWith("Entity") }) {
                        handleEntityNameRule(node, context)
                    } else if (superClassList.isNotEmpty()) {
                        superClassList.forEach { superClass ->
                            val superClassName = superClass.name ?: return
                            if (superClassName.endsWith("Activity")) {
                                handleActivityNameRule(node, context)
                            } else if (superClassName.endsWith("Application")) {
                                handleApplicationNameRule(node, context)
                            } else if (superClassName.endsWith("Fragment")) {
                                handleFragmentNameRule(node, context)
                            } else if (superClassName.endsWith("BroadcastReceiver")) {
                                handleBroadcastReceiverNameRule(node, context)
                            } else if (superClassName.endsWith("ViewModel")) {
                                handleViewModelNameRule(node, context)
                            } else if (superClassName.endsWith("RoomDatabase")) {
                                handleDatabaseNameRule(node, context)
                            } else if (superClass.isInterface && superClassName.startsWith("I")) {
                                handleInterfaceImplementationNameRule(node, context)
                            } else if (superClassName.endsWith("Service")) {
                                handleServiceNameRule(node, context)
                            } else if (superClassName.endsWith("Worker")) {
                                handleWorkerNameRule(node, context)
                            }
                        }
                    }
                }
            }

            override fun visitVariable(node: UVariable) {
                val variableType = node.type
                if (!node.text.contains("fun") && !node.isStatic) {
                    if (variableType.canonicalText.contains("StateFlow") && node.isPhysical) {
                        handleStateFlowNameRule(node, context)
                    } else if (variableType.canonicalText.contains("State") && node.isPhysical) {
                        handleStateNameRule(node, context)
                    } else if (variableType.canonicalText.contains("List") && node.isPhysical) {
                        handleListNameRule(node, context)
                    } else if (variableType.canonicalText.contains("Map") && node.isPhysical) {
                        handleMapNameRule(node, context)
                    }
                }
            }
        }
    }

}