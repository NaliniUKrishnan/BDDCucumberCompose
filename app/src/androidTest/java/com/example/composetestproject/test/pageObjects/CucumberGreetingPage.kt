package com.example.composetestproject.test.pageObjects


import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText



object CucumberGreetingPage {

    val greetCucumberButton = hasText("Greet Cucumber")
    val greetingCucumberTestTag = hasTestTag("greeting_test")
    val greetingMessageText1 = hasText("Hi Cucumber!")
    val greetEspressoButton = hasText("Greet Espresso")
    val greetingMessageText2 = hasText("Hi Compose Cucumber!")
    val customGreetingTestTag = hasTestTag("BDDTextTag")
    val doneButton = hasText("Done")
    //val customGreetingText = hasText("Hi Compose Cucumber!")


}