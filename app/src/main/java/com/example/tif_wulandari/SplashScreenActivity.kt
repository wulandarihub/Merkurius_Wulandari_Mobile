package com.example.tif_wulandari

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)

        // lifecycleScope.launch dengan delay(2000)
        lifecycleScope.launch {
            delay(2000) // splash selama 2 detik

            // Pengecekan isLogin
            val isLogin = sharedPref.getBoolean("isLogin", false)

            if (isLogin) {
                // Jika isLogin bernilai true -> arahkan ke MainActivity
                val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Jika isLogin bernilai false -> arahkan ke AuthActivity
                val intent = Intent(this@SplashScreenActivity, AuthActivity::class.java)
                startActivity(intent)
            }

            // Tutup SplashScreenActivity agar tidak bisa kembali saat menekan tombol back
            finish()
        }
    }
}