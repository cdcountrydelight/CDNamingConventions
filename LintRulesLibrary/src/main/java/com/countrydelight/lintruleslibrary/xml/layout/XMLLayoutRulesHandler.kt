package com.countrydelight.lintruleslibrary.xml.layout

import com.android.tools.lint.detector.api.XmlContext
import com.countrydelight.lintruleslibrary.xml.layout.XMLLayoutIssueUtils.LAYOUT_FILE_NAME_ISSUE_TEXT
import org.w3c.dom.Attr
import org.w3c.dom.Element

object XMLLayoutRulesHandler {


    /**
     * Handles the naming rule for IDs in XML attributes.
     *
     * @param context the XML context
     * @param attribute the XML attribute to be checked
     */
    fun handleIdNameRule(context: XmlContext, attribute: Attr) {
        val attributeValue = attribute.value ?: return
        val parentElementName = attribute.ownerElement.nodeName.substringAfterLast(".")
        val shortNameForElement = getShortNameForElement(parentElementName)
        val shorNameForElementWithUnderscore = "_$shortNameForElement"
        if (shortNameForElement.isNotBlank() && !attributeValue.endsWith(
                shorNameForElementWithUnderscore
            )
        ) {
            context.report(
                issue = XMLLayoutIssueUtils.IdNameIssue,
                scope = attribute,
                location = context.getValueLocation(attribute),
                message = "Id for $parentElementName must end with $shorNameForElementWithUnderscore"
            )
        }
    }


    fun handleLayoutFileNameRule(context: XmlContext, element: Element) {
        val fileName = context.file.name
        if (!fileName.startsWith("item_") && !fileName.startsWith("activity_") && !fileName.startsWith(
                "fragment_"
            ) && !fileName.startsWith("layout_")
        ) {
            context.report(
                issue = XMLLayoutIssueUtils.LayoutFileNameRule,
                scope = element,
                location = context.getElementLocation(element),
                message = LAYOUT_FILE_NAME_ISSUE_TEXT
            )
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
        return shortName
    }
}