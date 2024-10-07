package com.example.composetestproject.test.pageObjects

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText

object EspressoGreetingPage {


    val greetingEspressoTestTag = hasTestTag("greet_espresso")
    val greetingMessageText = hasText("Hello Espresso")
    val greetCucumberButton = hasText("Greet Cucumber")

}