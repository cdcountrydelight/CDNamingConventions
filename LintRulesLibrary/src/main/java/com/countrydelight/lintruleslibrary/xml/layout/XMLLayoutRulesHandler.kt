package com.countrydelight.lintruleslibrary.xml.layout

import com.android.tools.lint.detector.api.XmlContext
import org.w3c.dom.Attr

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
        val shortNameWithUnderScore = getShortNameForElementWithUnderScore(parentElementName)
        if (!attributeValue.endsWith(shortNameWithUnderScore)) {
            context.report(
                issue = XMLLayoutIssueUtils.IdNameIssue,
                scope = attribute,
                location = context.getValueLocation(attribute),
                message = "Id for $parentElementName must end with $shortNameWithUnderScore"
            )
        }
    }


    /**
     * Returns a short name for the element with underscores.
     *
     * @param elementName the name of the element
     * @return the short name with underscores
     */
    private fun getShortNameForElementWithUnderScore(elementName: String): String {
        var shortName = "_"
        elementName.forEach {
            if (it.isUpperCase()) {
                shortName += it.lowercase()
            }
        }
        return shortName
    }
}