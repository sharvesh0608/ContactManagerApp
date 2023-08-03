package com.sharveshapps.contactmanagerapp
class ContactManager {
    private val contacts = mutableListOf<Contact>()

    fun addContact(contact: Contact) {
        contacts.add(contact)
    }

    fun searchContactByName(name: String): Contact? {
        return contacts.find { it.name.equals(name, ignoreCase = true) }
    }

    fun getAllContacts(): List<Contact> {
        return contacts.toList()
    }
}
