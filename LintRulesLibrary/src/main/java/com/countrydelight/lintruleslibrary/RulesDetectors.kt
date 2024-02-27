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
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.DaoNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.DaoNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.DatabaseNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.DatabaseNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.EntityIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.EntityNameIssue
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
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.MapNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.MapNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.PackageNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.PackageNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.ServiceNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.ServiceNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.StateFlowNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.StateFlowNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.StateNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.StateNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.ViewModelNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.ViewModelNameIssueText
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.WorkerNameIssue
import com.countrydelight.lintruleslibrary.utils.IssuesUtils.WorkerNameIssueText
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


    /**
     * Handles the rule for class names ending with "Worker".
     * @param node The UClass node to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    private fun handleWorkerNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Worker")) {
            context.report(
                WorkerNameIssue,
                node,
                context.getLocation(node as UElement),
                WorkerNameIssueText
            )
        }
    }


    /**
     * Handles the rule for class names ending with "Service".
     * @param node The UClass node to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    private fun handleServiceNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Service")) {
            context.report(
                ServiceNameIssue,
                node,
                context.getLocation(node as UElement),
                ServiceNameIssueText
            )
        }
    }


    /**
     * Handles the rule for package names adhering to snake case convention.
     * @param node The UFile node representing the package to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    private fun handlePackageNameRule(node: UFile, context: JavaContext) {
        val packageName = node.packageName.substringAfterLast(".")
        if (!isValidSnakeCase(packageName)) {
            context.report(
                PackageNameIssue,
                node,
                context.getLocation(node),
                PackageNameIssueText
            )
        }
    }


    /**
     * Handles the rule for class names ending with "Database".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
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

    /**
     * Checks if a string adheres to snake case convention.
     * @param name The string to check.
     * @return True if the string is in snake case format, false otherwise.
     */
    private fun isValidSnakeCase(name: String): Boolean {
        return name.matches(Regex("^[a-z][a-z0-9_]*$"))
    }

    /**
     * Handles the rule for variable names ending with "Map".
     * @param node The UVariable node representing the variable to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    private fun handleMapNameRule(node: UVariable, context: JavaContext) {
        if (node.name?.endsWith("Map") == false) {
            context.report(
                MapNameIssue,
                node as UElement,
                context.getLocation(node as UElement),
                MapNameIssueText
            )
        }
    }


    /**
     * Handles the rule for variable names ending with "List".
     * @param node The UVariable node representing the variable to inspect.
     * @param context The JavaContext providing the inspection context.
     */
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


    /**
     * Handles the rule for variable names ending with "State".
     * @param node The UVariable node representing the variable to inspect.
     * @param context The JavaContext providing the inspection context.
     */
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


    /**
     * Handles the rule for variable names ending with "StateFlow".
     * @param node The UVariable node representing the variable to inspect.
     * @param context The JavaContext providing the inspection context.
     */
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


    /**
     * Handles the rule for class names ending with "Impl".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
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

    /**
     * Handles the rule for class names ending with "Entity".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    private fun handleEntityNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        if (className != null && !className.endsWith("Entity")) {
            context.report(
                EntityNameIssue,
                node,
                context.getLocation(node as UElement),
                EntityIssueText
            )
        }
    }


    /**
     * Handles the rule for class names ending with "Enum".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
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


    /**
     * Handles the rule for class names ending with "BroadcastReceiver".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
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

    /**
     * Handles the rule for class names ending with "ViewModel".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
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


    /**
     * Handles the rule for class names ending with "Fragment".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
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

    /**
     * Handles the rule for class names ending with "Application".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
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


    /**
     * Handles the rule for class names ending with "Activity".
     * @param node The UClass node representing the class to inspect.
     * @param context The JavaContext providing the inspection context.
     */
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

    /**
     * Handles the rule for class names of type interface.
     * @param node The UClass node to inspect.
     * @param context The JavaContext providing the inspection context.
     */
    private fun handleInterfaceNameRule(node: UClass, context: JavaContext) {
        val className = node.name
        val isDao = node.annotations.any { it.text.contains("Dao") }
        if (className == null) return
        if (isDao) {
            if (!className.endsWith("Dao")) {
                context.report(
                    DaoNameIssue,
                    node,
                    context.getLocation(node as UElement),
                    DaoNameIssueText
                )
            }
        }
        //because annotation are internally treated as interface class
        else if (className.first() != 'I' && !node.text.contains("annotation")) {
            context.report(
                InterfaceNameIssue,
                node,
                context.getLocation(node as UElement),
                InterfaceNameIssueText
            )
        }
    }
}