package com.example.masterkotlin.coroutines

// asynchronous Flow
// Asynchronous Flows in Kotlin are a way to handle streams of data asynchronously using kotlin Flow
// callback flow
// callback flow is a way to handle streams of data asynchronously using kotlin Flow

class LocationProvider{
    private var listener: ((String)-> Unit)? = null
    fun startLocationUpdates(listener: (String)-> Unit){
        this.listener = listener
        listener("Location 1")
        listener("Location 2")
        listener("Location 3")
    }
    fun setOnLocationChangedListener(callback: (String)-> Unit){}
}
