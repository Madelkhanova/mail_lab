package com.example.loginaru

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 */
class MailDetailFragment(val item: Mail?) : Fragment() {
    private lateinit var title: TextView
    private lateinit var date: TextView
    private lateinit var message: TextView
    private lateinit var author: TextView
    private lateinit var toolbar: Toolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview = inflater.inflate(R.layout.fragment_main_detail, container, false)
        title = rootview.findViewById(R.id.title)
        date = rootview.findViewById(R.id.date)
        author = rootview.findViewById(R.id.author)
        message = rootview.findViewById(R.id.message)
        title.text = item?.title
        date.text = item?.date
        author.text = item?.author
        message.text = item?.message
        return rootview
    }
}
