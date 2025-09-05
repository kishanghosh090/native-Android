package com.udemy.countermvvn

data class CounterModel(
    var count: Int
)
class CounterRepository{
    private val counter = CounterModel(0)
    fun increment() {
        counter.count++
    }
    fun decrement() {
        counter.count--
    }
    fun getCount() = counter.count
}
