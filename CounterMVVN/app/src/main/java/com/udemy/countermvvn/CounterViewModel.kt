package com.udemy.countermvvn

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel(): ViewModel() {
    private val repository: CounterRepository = CounterRepository()
    private val _count = mutableStateOf(repository.getCount())


    val count: MutableState<Int> = _count

    fun increment() {
        repository.increment()
        _count.value = repository.getCount()
    }

    fun decrement() {
        repository.decrement()
        _count.value = repository.getCount()

    }


}