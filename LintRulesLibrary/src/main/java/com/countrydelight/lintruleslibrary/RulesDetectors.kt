package com.countrydelight.lintruleslibrary

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.ActivityNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.ActivityNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.ApplicationNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.ApplicationNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.BroadcastReceiverNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.BroadcastReceiverNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.DatabaseNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.DatabaseNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.EnumNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.EnumNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.FragmentNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.FragmentNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.InterfaceImplementationNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.InterfaceImplementationNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.InterfaceNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.InterfaceNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.ListNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.ListNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.PackageNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.StateFlowNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.StateFlowNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.StateNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.StateNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.ViewModelNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.ViewModelNameIssueText
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UFile
import org.jetbrains.uast.UVariable

class RulesDetectors : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes(): List<Class<out UElement>> {
        return listOf(UClass::class.java, UVariable::class.java, UFile::class.java)
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
                    }
                }
            }


        }
    }


    private fun handlePackageNameRule(node: UFile, context: JavaContext) {
        val packageName = node.packageName.substringAfterLast(".")
        if (!isValidSnakeCase(packageName)) {
            context.report(
                PackageNameIssue,
                node,
                context.getLocation(node),
                packageName
            )
        }
    }

    private fun handleDatabaseNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Database")) {
            context.report(
                DatabaseNameIssue,
                node,
                context.getLocation(node as UElement),
                DatabaseNameIssueText
            )
        }
    }

    private fun isValidSnakeCase(name: String): Boolean {
        return name.matches(Regex("^[a-z][a-z0-9_]*$"))
    }


    private fun handleListNameRule(node: UVariable, context: JavaContext) {
        if (node.name?.endsWith("List") == false) {
            context.report(
                ListNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                ListNameIssueText
            )
        }
    }

    private fun handleStateNameRule(node: UVariable, context: JavaContext) {
        if (node.name?.endsWith("State") == false) {
            context.report(
                StateNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                StateNameIssueText
            )
        }
    }


    private fun handleStateFlowNameRule(node: UVariable, context: JavaContext) {
        if (node.name?.endsWith("StateFlow") == false) {
            context.report(
                StateFlowNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                StateFlowNameIssueText
            )
        }
    }

    private fun handleInterfaceImplementationNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Impl")) {
            context.report(
                InterfaceImplementationNameIssue,
                node,
                context.getLocation(node as UElement),
                InterfaceImplementationNameIssueText
            )
        }
    }

    private fun handleEnumNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Enum")) {
            context.report(
                EnumNameIssue,
                node,
                context.getLocation(node as UElement),
                EnumNameIssueText
            )
        }
    }


    private fun handleBroadcastReceiverNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Receiver")) {
            context.report(
                BroadcastReceiverNameIssue,
                node,
                context.getLocation(node as UElement),
                BroadcastReceiverNameIssueText
            )
        }
    }

    private fun handleViewModelNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("ViewModel")) {
            context.report(
                ViewModelNameIssue,
                node,
                context.getLocation(node as UElement),
                ViewModelNameIssueText
            )
        }
    }

    private fun handleFragmentNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Fragment")) {
            context.report(
                FragmentNameIssue,
                node,
                context.getLocation(node as UElement),
                FragmentNameIssueText
            )
        }
    }


    private fun handleApplicationNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Application")) {
            context.report(
                ApplicationNameIssue,
                node,
                context.getLocation(node as UElement),
                ApplicationNameIssueText
            )
        }
    }


    private fun handleActivityNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Activity")) {
            context.report(
                ActivityNameIssue,
                node,
                context.getLocation(node as UElement),
                ActivityNameIssueText
            )
        }
    }

    private fun handleInterfaceNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        //because annotation are internally treated as interface class
        if (className != null && className.first() != 'I' && !node.text.contains("annotation")) {
            context.report(
                InterfaceNameIssue,
                node,
                context.getLocation(node as UElement),
                InterfaceNameIssueText
            )
        }
    }
}