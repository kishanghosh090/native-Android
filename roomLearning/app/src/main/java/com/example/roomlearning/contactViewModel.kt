package com.example.roomlearning

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomlearning.ui.theme.ContactState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class contactViewModel(
    private val dao: ContactDao
): ViewModel() {
    private val _sortType = MutableStateFlow(ShortType.FIRST_NAME)
    private val _contacts = _sortType
        .flatMapLatest { sortType ->
            when(sortType){
                ShortType.FIRST_NAME -> dao.getContactsOrderedByFirstName()
                ShortType.LAST_NAME -> dao.getContactsOrderedByLastName()
                ShortType.PHONE_NUMBER -> dao.getContactsOrderedByPhoneNumber()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(ContactState())

//    val state = _state.asStateFlow()

    fun onEvent(event: ContactEvent){
        when(event){
            is ContactEvent.deleteContact -> {
                viewModelScope.launch {
                    dao.deleteContact(event.contact)
                }
            }
            ContactEvent.hideDialog -> {
                _state.update { it.copy(
                    isAddingContact = false
                ) }
            }
            ContactEvent.saveContact -> {

            }
            is ContactEvent.setPhoneNumber -> {
                _state.update { it.copy(
                    phoneNumber = event.phoneNumber
                ) }
            }
            is ContactEvent.setFirstName -> {
                _state.update { it.copy(
                    firstName = event.firstName
                ) }
            }
            is ContactEvent.setLastName -> {
                _state.update { it.copy(
                    lastName = event.lastName
                ) }
        }
            ContactEvent.showDialog -> {
                _state.update { it.copy(
                    isAddingContact = true
                ) }
            }
            is ContactEvent.sortContacts -> {
                _sortType.value = event.sortType
            }
        }
    }
}