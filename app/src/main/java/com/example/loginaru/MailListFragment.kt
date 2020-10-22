package com.example.loginaru

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 * A simple [Fragment] subclass.
 */
class MailListFragment : Fragment() {
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var viewAdapter: MailListAdapter
    private lateinit var viewManager: LinearLayoutManager
    private var listener: MailListAdapter.ItemClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_main_list, container, false)

        val mailList = ArrayList<Mail>()
        for (i in 1..100) {
            mailList.add(
                Mail(
                    "Author" + i,
                    "Title"+i,
                    "01 January 2020",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." + i
                )
            )
        }
        myRecyclerView = rootView.findViewById(R.id.myRecyclerView)
        viewManager = LinearLayoutManager(context)
        myRecyclerView.layoutManager = viewManager

        listener = object : MailListAdapter.ItemClickListener {
            override fun itemClick(position: Int, item: Mail?) {
                val fragment = MailDetailFragment(item)
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.main_container, fragment)
                    ?.addToBackStack( "tag" )
                    ?.commit()
            }
        }
        viewAdapter = context?.let { MailListAdapter(mailList, it,
            listener as MailListAdapter.ItemClickListener
        ) }!!
        myRecyclerView.adapter = viewAdapter

        return rootView

    }
}
