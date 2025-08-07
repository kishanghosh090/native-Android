package com.vedabits.composemusicapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _currentScreen: MutableState<Screens> =
        mutableStateOf(
            Screens.DrawerScreens.AddAccount
        )

    val currentScreen: MutableState<Screens> = _currentScreen
    fun setCurrentScreen(screen: Screens){
        _currentScreen.value = screen
    }

}