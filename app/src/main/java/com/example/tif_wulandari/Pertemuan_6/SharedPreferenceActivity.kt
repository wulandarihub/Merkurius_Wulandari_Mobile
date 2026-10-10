package com.example.tif_wulandari.Pertemuan_6

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tif_wulandari.R

class SharedPreferenceActivity : AppCompatActivity() {

    // 1. Deklarasi SharedPreferences
    private lateinit var sharedPreferences: SharedPreferences

    // 2. Kunci (Key) untuk SharedPreferences
    private val PREF_NAME = "UserPref"
    private val KEY_USERNAME = "KEY_USERNAME"
    private val KEY_EMAIL = "KEY_EMAIL"
    private val KEY_IS_LOGGED_IN = "isLoggedIn"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shared_preference)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 3. Inisialisasi SharedPreferences (Mode Private)
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        // Inisialisasi View dari layout
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        // 4. Membaca data yang sudah tersimpan saat pertama kali dibuka
        val savedUsername = sharedPreferences.getString(KEY_USERNAME, null)
        val savedEmail = sharedPreferences.getString(KEY_EMAIL, null)
        val isLoggedIn = sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)

        if (isLoggedIn && savedUsername != null) {
            tvStatus.text = "Data Tersimpan:\nNama: $savedUsername\nEmail: $savedEmail"
            etUsername.setText(savedUsername)
            etEmail.setText(savedEmail)
        }

        // 5. Logika Simpan Data (Save)
        btnSave.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()

            if (username.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Harap isi semua kolom!", Toast.LENGTH_SHORT).show()
            } else {
                val editor = sharedPreferences.edit()
                editor.putString(KEY_USERNAME, username)
                editor.putString(KEY_EMAIL, email)
                editor.putBoolean(KEY_IS_LOGGED_IN, true)
                editor.apply() // Menyimpan data secara asinkron

                tvStatus.text = "Data Tersimpan:\nNama: $username\nEmail: $email"
                Toast.makeText(this, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()
            }
        }

        // 6. Logika Hapus Data (Clear / Logout)
        btnClear.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear() // Menghapus seluruh data di UserPref
            editor.apply()

            etUsername.text.clear()
            etEmail.text.clear()
            tvStatus.text = "Belum ada data tersimpan"
            Toast.makeText(this, "Data berhasil dihapus!", Toast.LENGTH_SHORT).show()
        }
    }
}