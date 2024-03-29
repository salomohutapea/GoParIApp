package com.example.gopariapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
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
                val Intent = Intent(
                        this@MainActivity,
                        PayActivity::class.java
                )
                startActivity(Intent)
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