package com.example.tif_wulandari.home.Pertemuan_4

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tif_wulandari.R

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fourth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBack: ImageButton = findViewById(R.id.btnBackP4)
        val etNama: EditText = findViewById(R.id.etNamaP4)
        val rgGender: RadioGroup = findViewById(R.id.rgGender)
        val spinnerProdi: Spinner = findViewById(R.id.spinnerProdi)
        val cbSetuju: CheckBox = findViewById(R.id.cbSetuju)
        val btnProses: Button = findViewById(R.id.btnProsesP4)
        val tvOutput: TextView = findViewById(R.id.tvOutputP4)

        val listProdi = listOf("D4 Teknik Informatika", "D4 Sistem Informasi", "D4 Teknologi Rekayasa Komputer")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listProdi)
        spinnerProdi.adapter = adapter

        btnProses.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val selectedId = rgGender.checkedRadioButtonId

            if (nama.isEmpty()) {
                etNama.error = "Nama wajib diisi"
                return@setOnClickListener
            }
            if (selectedId == -1) {
                Toast.makeText(this, "Pilih jenis kelamin terlebih dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!cbSetuju.isChecked) {
                Toast.makeText(this, "Centang persetujuan data terlebih dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gender = findViewById<RadioButton>(selectedId).text.toString()
            val prodi = spinnerProdi.selectedItem.toString()

            tvOutput.text = "Hasil Form:\nNama: $nama\nJenis Kelamin: $gender\nProdi: $prodi"
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}