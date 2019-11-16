package com.example.gopariapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //Jika tvSignIn di click, maka SignInActivity akan terbuka
        tvSignIn.setOnClickListener {
            val signInIntent = Intent(
                    this@SignUpActivity,
                    SignInActivity::class.java
            )
            startActivity(signInIntent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        //Jika button signup di click maka method perform register akan dijalankan
        btSignUp.setOnClickListener {
            performRegister()
        }

    }

    var selectedPhotoUri: Uri? = null

    //Untuk menyembunyikan keyboard
    private fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    private fun Activity.hideKeyboard() {
        hideKeyboard(if (currentFocus == null) View(this) else currentFocus)
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    //fungsi untuk register
    private fun performRegister() {
        val password = etPasswordSignUp.text.toString()
        val email = etEmail.text.toString()
        val nama = etFullName.text.toString()

        Log.d("SignUpActivity", "Email adalah" + email)
        Log.d("SignUpActivity", "Password adalah $password")
        Log.d("SignUpActivity", "Nama adalah" + nama)

        //Untuk Mengecek apakah email, password dan nama tidak kosong.
        if (email.isEmpty() || password.isEmpty() || nama.isEmpty()) {
            Toast.makeText(this, "Masukkan email, password, dan nama", Toast.LENGTH_SHORT).show()
            return
        }

        window.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
//        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        hideKeyboard()
        rlProgressSignUp.visibility = View.VISIBLE

        //Untuk membuat akun aplikasi dari user berdasarkan email dan password yang sudah di input
        //menggunakan firebase authentication
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener
                    rlProgressSignUp.visibility = View.GONE
                    val Intent = Intent(
                            this@SignUpActivity,
                            MainActivity::class.java
                    )
                    startActivity(Intent)
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                    Log.d("SignUpActivity", "Successfully created user with uid: ${it.result?.user?.uid}")
                }.addOnFailureListener {
                    Log.d("SignUpActivity", "Failed to create user: ${it.message}")
                    rlProgressSignUp.visibility = View.GONE
                    window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                    Toast.makeText(this, "Failed to create user: ${it.message}", Toast.LENGTH_SHORT).show()
                }
    }
}
