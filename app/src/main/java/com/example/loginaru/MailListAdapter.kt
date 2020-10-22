package com.example.loginaru

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MailListAdapter(
    val maillist: ArrayList<Mail>,
    val context: Context,
    val listener: ItemClickListener
) :
    RecyclerView.Adapter<MailListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val mail = maillist.get(position)
        holder.authorText.text = mail.author
        holder.messageText.text = mail.message
        holder.titleText.text = mail.title
        holder.dateText.text = mail.date
        holder.itemView.setOnClickListener {
            listener.itemClick(
                position,
                mail
            )
        }
    }

    override fun getItemCount(): Int {
        return maillist.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var messageText: TextView = view.findViewById(R.id.message)
        var authorText: TextView = view.findViewById(R.id.author)
        var titleText: TextView = view.findViewById(R.id.title)
        var dateText: TextView = view.findViewById(R.id.date)

    }

    interface ItemClickListener {
        fun itemClick(position: Int, item: Mail?)
    }
}