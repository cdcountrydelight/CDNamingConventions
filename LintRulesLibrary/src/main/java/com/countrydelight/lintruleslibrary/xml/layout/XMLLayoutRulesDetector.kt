package com.countrydelight.lintruleslibrary.xml.layout

import com.android.resources.ResourceFolderType
import com.android.tools.lint.detector.api.ResourceXmlDetector
import com.android.tools.lint.detector.api.XmlContext
import com.android.tools.lint.detector.api.XmlScannerConstants
import com.countrydelight.lintruleslibrary.xml.layout.XMLLayoutRulesHandler.handleIdNameRule
import com.countrydelight.lintruleslibrary.xml.layout.XMLLayoutRulesHandler.handleLayoutFileNameRule
import org.w3c.dom.Attr
import org.w3c.dom.Element

class XMLLayoutRulesDetector : ResourceXmlDetector() {

    companion object {

    }

    override fun appliesTo(folderType: ResourceFolderType): Boolean {
        return folderType == ResourceFolderType.LAYOUT
    }

    override fun getApplicableAttributes(): Collection<String> {
        return listOf("id")
    }


    override fun getApplicableElements(): Collection<String>? {
        return XmlScannerConstants.ALL
    }


    override fun visitAttribute(context: XmlContext, attribute: Attr) {
        handleIdNameRule(context, attribute)
    }

    override fun visitElement(context: XmlContext, element: Element) {
        handleLayoutFileNameRule(context, element)
    }


}