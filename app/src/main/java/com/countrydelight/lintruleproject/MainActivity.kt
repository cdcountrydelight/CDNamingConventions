package com.countrydelight.lintruleproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.countrydelight.lintruleproject.ui.theme.LintRuleProjectTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LintRuleProjectTheme {
            }
        }
    }

}
