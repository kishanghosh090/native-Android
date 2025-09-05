package com.example.roomlearning.ui.theme

import com.example.roomlearning.Contact
import com.example.roomlearning.ShortType

data class ContactState (
    val contacts: List<Contact> = emptyList(),
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val isAddingContact: Boolean = false,
    val sortType: ShortType = ShortType.FIRST_NAME
)