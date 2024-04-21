package com.countrydelight.lintruleslibrary.xml.layout

import com.android.tools.lint.detector.api.XmlContext
import com.countrydelight.lintruleslibrary.xml.layout.LayoutIssueUtils.LAYOUT_FILE_NAME_ISSUE_TEXT
import org.w3c.dom.Attr
import org.w3c.dom.Element

object LayoutRulesHandler {


    /**
     * Handles the naming rule for IDs in XML attributes.
     *
     * @param context the XML context
     * @param attribute the XML attribute to be checked
     */
    fun handleIdNameRule(context: XmlContext, attribute: Attr) {
        val attributeValue = attribute.value ?: return
        val parentElementName = attribute.ownerElement.nodeName.substringAfterLast(".")
        if (parentElementName.isNotBlank()) {
            val shortNameForElement = getShortNameForElement(parentElementName)
            if (parentElementName.isNotBlank() && !attributeValue.endsWith(shortNameForElement)) {
                context.report(
                    issue = LayoutIssueUtils.IdNameIssue,
                    scope = attribute,
                    location = context.getValueLocation(attribute),
                    message = "Id for $parentElementName must end with $shortNameForElement"
                )
            }
        }
    }

    /**
     * Returns a short name for the element.
     *
     * @param elementName the name of the element
     * @return the short name with underscores
     */
    private fun getShortNameForElement(elementName: String): String {
        var shortName = ""
        elementName.forEach {
            if (it.isUpperCase()) {
                shortName += it.lowercase()
            }
        }
        if (shortName.isBlank()) {
            shortName += elementName[0]
        }
        shortName = "_$shortName"
        return shortName
    }


    /**
     * Handles the lint rule for XML layout file names.
     *
     * @param context the XML context
     * @param element the XML element to be checked
     */
    fun handleLayoutFileNameRule(context: XmlContext, element: Element) {
        val fileName = context.file.name
        if (!fileName.startsWith("item_") && !fileName.startsWith("activity_") && !fileName.startsWith(
                "fragment_"
            ) && !fileName.startsWith("layout_")
        ) {
            context.report(
                issue = LayoutIssueUtils.LayoutFileNameRule,
                scope = element,
                location = context.getElementLocation(element),
                message = LAYOUT_FILE_NAME_ISSUE_TEXT
            )
        }
    }

}