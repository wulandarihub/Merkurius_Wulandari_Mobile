package com.example.tif_wulandari.Pertemuan_6

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tif_wulandari.MainActivity
import com.example.tif_wulandari.R

class SplashActivity : AppCompatActivity() {

    // 1. Deklarasi variabel SharedPreferences
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 2. Inisialisasi SharedPreferences dengan nama file "UserPref" (mode private)
        sharedPreferences = getSharedPreferences("UserPref", Context.MODE_PRIVATE)

        // 3. Memberikan jeda waktu (delay 3000 ms = 3 detik) menggunakan Handler
        Handler(Looper.getMainLooper()).postDelayed({
            // Cek apakah key "isLoggedIn" bernilai true (default false jika belum tersimpan)
            val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

            if (isLoggedIn) {
                // Jika sudah login, langsung diarahkan ke MainActivity
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Jika belum login, diarahkan ke MainActivity (atau nanti ke LoginActivity setelah dibuat)
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
            }

            // 4. Tutup SplashActivity agar pengguna tidak kembali ke splash saat menekan tombol back
            finish()
        }, 3000)
    }
}