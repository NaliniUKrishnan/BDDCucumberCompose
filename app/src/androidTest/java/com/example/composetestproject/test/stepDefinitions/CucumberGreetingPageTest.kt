package com.example.composetestproject.test.stepDefinitions

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performKeyPress
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.printToLog
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.composetestproject.test.CommonHelpers.ActivityScenarioHolder
import com.example.composetestproject.test.CommonHelpers.ComposeRuleHolder
import com.example.composetestproject.test.pageObjects.CucumberGreetingPage
import cucumber.api.PendingException
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CucumberGreetingPageTest(val composeRuleHolder: ComposeRuleHolder,
                               val scenarioHolder: ActivityScenarioHolder
): SemanticsNodeInteractionsProvider by composeRuleHolder.composeRule{

    @When("I tap Greet Cucumber button")
    fun i_tap_Greet_Cucumber_button() {
        onNode(CucumberGreetingPage.greetCucumberButton).assertIsDisplayed()
        onNode(CucumberGreetingPage.greetCucumberButton).performClick()
    }

    @Then("I see Cucumber greeting")
    fun i_see_Cucumber_greeting() {
        onNode(CucumberGreetingPage.greetingCucumberTestTag).assert(CucumberGreetingPage.greetingMessageText1)
    }

    @When("the name {string} is entered in textfield")
    fun the_name_is_entered_in_textfield(name: String) {
        //onNode(CucumberGreetingPage.customGreetingTestTag, useUnmergedTree = false).performTextInput(name)
        onNode(CucumberGreetingPage.customGreetingTestTag, useUnmergedTree = false).performTextInput(name)
        onNode(CucumberGreetingPage.customGreetingTestTag, useUnmergedTree = false).performClick()
    }

    @When("I tap the Done button")
    fun i_tap_the_Done_button() {
        onNode(CucumberGreetingPage.doneButton).performClick()
        onNode(CucumberGreetingPage.doneButton).performClick()
    }

    @Then("I see {string} custom greeting")
    fun i_see_custom_greeting(greetingtext: String) {
        onNode(CucumberGreetingPage.greetingCucumberTestTag).assert(hasText(greetingtext))
    }


}



