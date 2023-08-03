package com.sharveshapps.contactmanagerapp
import ContactAdapter
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var contactManager: ContactManager
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactManager = ContactManager()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewContacts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ContactAdapter(emptyList())
        recyclerView.adapter = adapter

        val btnAddContact: Button = findViewById(R.id.btnAddContact)
        val btnSearchContact: Button = findViewById(R.id.btnSearchContact)
        val btnDisplayContacts: Button = findViewById(R.id.btnDisplayContacts)
        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextPhoneNumber: EditText = findViewById(R.id.editTextPhoneNumber)
        val editTextEmail: EditText = findViewById(R.id.editTextEmail)
        val tvSearchResult: TextView = findViewById(R.id.tvSearchResult)

        btnAddContact.setOnClickListener {
            val name = editTextName.text.toString()
            val phoneNumber = editTextPhoneNumber.text.toString()
            val email = editTextEmail.text.toString()

            if (name.isNotEmpty() && phoneNumber.isNotEmpty() && email.isNotEmpty()) {
                val contact = Contact(name, phoneNumber, email)
                contactManager.addContact(contact)
                Toast.makeText(this, "Contact added successfully!", Toast.LENGTH_SHORT).show()
                clearInputFields()
            } else {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            }
        }

        btnSearchContact.setOnClickListener {
            val searchName = editTextName.text.toString()
            val foundContact = contactManager.searchContactByName(searchName)
            if (foundContact != null) {
                tvSearchResult.text = "Contact found: ${foundContact.phoneNumber}, ${foundContact.email}"
            } else {
                Toast.makeText(this," Contact not Found",Toast.LENGTH_SHORT).show()
            }
        }

        btnDisplayContacts.setOnClickListener {
            val allContacts = contactManager.getAllContacts()
            adapter.updateContacts(allContacts)
            tvSearchResult.text = ""
        }
    }

    private fun clearInputFields() {
        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextPhoneNumber: EditText = findViewById(R.id.editTextPhoneNumber)
        val editTextEmail: EditText = findViewById(R.id.editTextEmail)

        editTextName.text.clear()
        editTextPhoneNumber.text.clear()
        editTextEmail.text.clear()
    }
}