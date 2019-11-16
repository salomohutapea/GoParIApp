package com.example.gopariapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navBarHome -> {
                replaceFragment(FragmentHome())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navBarProfile -> {
                replaceFragment(FragmentProfile())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navbarPay -> {
                replaceFragment(Fragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navBarFeeds -> {
                replaceFragment(FragmentFeeds())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navBarHistory -> {
                replaceFragment(FragmentHistory())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        replaceFragment(FragmentHome())
    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}