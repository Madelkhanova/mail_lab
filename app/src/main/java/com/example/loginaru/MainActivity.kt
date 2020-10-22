package com.example.loginaru

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.main_container, MailListFragment())
            .commit()
    }
    override fun onBackPressed() {
        val count = getFragmentManager().backStackEntryCount
        if (count == 0) {
            super.onBackPressed()
            //additional code
        } else {
            getFragmentManager().popBackStack()
        }
    }
}
