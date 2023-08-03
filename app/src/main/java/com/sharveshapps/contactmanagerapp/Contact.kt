package com.sharveshapps.contactmanagerapp
class Contact(val name: String, val phoneNumber: String, val email: String) {
    override fun toString(): String {
        return "Name: $name, Phone Number: $phoneNumber, Email: $email"
    }
}