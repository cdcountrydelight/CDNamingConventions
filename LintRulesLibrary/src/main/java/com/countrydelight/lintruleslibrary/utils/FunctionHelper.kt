package com.countrydelight.lintruleslibrary.utils

object FunctionHelper {


    /**
     * Provides a list of valid prefixes for naming Boolean variables and functions.
     * @return A list of valid prefixes for Boolean variables and function names.
     */
    fun getValidStartingNamesOfBooleanVariablesAndFunctions(): List<String> {
        return listOf("is", "has", "should", "can", "whether", "was", "need", "are")
    }
}