package com.example.gopariapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment

private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    when (item.itemId) {
        R.id.navigation_home -> {
            replaceFragment(HomeFragment())
            return@OnNavigationItemSelectedListener true
        }
        R.id.navigation_akun -> {
            replaceFragment(AkunFragment())
            return@OnNavigationItemSelectedListener true
        }
        R.id.navigation_lainnya -> {
            replaceFragment(LainnyaFragment())
            return@OnNavigationItemSelectedListener true
        }
    }
    false
}


override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(com.example.belajaronlineapplication.R.layout.activity_main)
    nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    replaceFragment(HomeFragment())
    FirebaseMessaging.getInstance().isAutoInitEnabled = true
}

private fun replaceFragment(fragment: Fragment) {
    val fragmentTransaction = supportFragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.fragmentContainer, fragment)
    fragmentTransaction.commit()
}