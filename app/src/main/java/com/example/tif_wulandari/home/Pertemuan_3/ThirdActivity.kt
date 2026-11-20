package com.example.tif_wulandari.home.Pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tif_wulandari.R

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputNoTujuan: EditText = findViewById(R.id.inputNoTujuan)
        val btnKirim: Button = findViewById(R.id.btnKirim)
        val btnBack: Button = findViewById(R.id.btnBackThird)

        btnKirim.setOnClickListener {
            val nomor = inputNoTujuan.text.toString().trim()
            if (nomor.isEmpty()) {
                inputNoTujuan.error = "Nomor tujuan wajib diisi"
                return@setOnClickListener
            }

            Log.e("Klik btnKirim", "Tombol berhasil ditekan. Isi dari inputNoTujuan = $nomor")
            Toast.makeText(this, "Kode verifikasi dikirim ke $nomor", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ThirdResultActivity::class.java).apply {
                putExtra("EXTRA_NOMOR", nomor)
            }
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}