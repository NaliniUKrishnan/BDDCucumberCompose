package com.example.composetestproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {
    fun sayHello(){
        System.out.println("Test")
    }
}