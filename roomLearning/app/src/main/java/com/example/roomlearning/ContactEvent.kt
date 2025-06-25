package com.example.roomlearning

sealed interface ContactEvent {
    object saveContact: ContactEvent
    data class setFirstName(val firstName: String): ContactEvent
    data class setLastName(val lastName: String): ContactEvent
    data class setPhoneNumber(val phoneNumber: String): ContactEvent
    object showDialog: ContactEvent
    object hideDialog: ContactEvent
    data class sortContacts(val sortType: ShortType): ContactEvent
    data class deleteContact(val contact: Contact): ContactEvent

}