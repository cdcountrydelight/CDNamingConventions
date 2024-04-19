package com.countrydelight.lintruleslibrary.xml.layout

import com.android.resources.ResourceFolderType
import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.ResourceXmlDetector
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import com.android.tools.lint.detector.api.XmlContext
import com.countrydelight.lintruleslibrary.xml.layout.XMLLayoutRulesHandler.handleIdNameRule
import org.w3c.dom.Attr

class XMLLayoutRulesDetector : ResourceXmlDetector() {

    companion object {

    }

    override fun appliesTo(folderType: ResourceFolderType): Boolean {
        return folderType == ResourceFolderType.LAYOUT
    }

    override fun getApplicableAttributes(): Collection<String> {
        return listOf("id")
    }


    override fun visitAttribute(context: XmlContext, attribute: Attr) {
        handleIdNameRule(context, attribute)

    }


}