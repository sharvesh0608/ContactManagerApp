// ContactAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sharveshapps.contactmanagerapp.Contact
import com.sharveshapps.contactmanagerapp.R

class ContactAdapter(private var contacts: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_contact, parent, false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = contacts[position]
        holder.tvContactName.text = currentContact.name
        holder.tvContactPhoneNumber.text = currentContact.phoneNumber
        holder.tvContactEmail.text = currentContact.email
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    fun updateContacts(newContacts: List<Contact>) {
        contacts = newContacts
        notifyDataSetChanged()
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvContactName: TextView = itemView.findViewById(R.id.tvContactName)
        val tvContactPhoneNumber: TextView = itemView.findViewById(R.id.tvContactPhoneNumber)
        val tvContactEmail: TextView = itemView.findViewById(R.id.tvContactEmail)
    }
}