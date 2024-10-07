package com.example.composetestproject.test.CommonHelpers

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.composetestproject.MainActivity
import io.cucumber.java.en.Given
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppIntializerTest(val composeRuleHolder: ComposeRuleHolder, val scenarioHolder: ActivityScenarioHolder) : SemanticsNodeInteractionsProvider by composeRuleHolder.composeRule {

    @Given("I open the app")
    fun i_open_the_app() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        scenarioHolder.launch(MainActivity.create(instrumentation.targetContext, null))
    }
}