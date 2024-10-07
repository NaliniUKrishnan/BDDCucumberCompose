package com.example.composetestproject.test.stepDefinitions

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.composetestproject.test.CommonHelpers.ActivityScenarioHolder
import com.example.composetestproject.test.CommonHelpers.ComposeRuleHolder
import com.example.composetestproject.test.pageObjects.CucumberGreetingPage
import com.example.composetestproject.test.pageObjects.EspressoGreetingPage
import cucumber.api.PendingException
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EspressoGreetingPageTest(val composeRuleHolder: ComposeRuleHolder, val scenarioHolder: ActivityScenarioHolder) : SemanticsNodeInteractionsProvider by composeRuleHolder.composeRule {

    @When("I tap Greet Espresso button")
    fun i_tap_Greet_Espresso_button() {
        onNode(CucumberGreetingPage.greetEspressoButton).assertIsDisplayed().performClick()
        //Thread.sleep(10000)
    }

    @Then("I see Espresso greeting in Espresso page")
    fun i_see_Espresso_greeting_in_Espresso_page() {
        onNode(EspressoGreetingPage.greetingEspressoTestTag).assert(EspressoGreetingPage.greetingMessageText)
    }

    @When("I tap Greet Cucumber button on Espresso page")
    fun i_tap_Greet_Cucumber_button_on_Espresso_page() {
        onNode(EspressoGreetingPage.greetCucumberButton).assertIsDisplayed().performClick()

    }
    @Then("I am on Greet CucumberCompose Page")
    fun i_am_on_Greet_CucumberCompose_Page() {
        onNode(CucumberGreetingPage.greetingCucumberTestTag).assert(CucumberGreetingPage.greetingMessageText2)

    }

}