package com.example.tif_wulandari.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.tif_wulandari.AuthActivity
import com.example.tif_wulandari.R
import com.example.tif_wulandari.databinding.FragmentHomeBinding
import com.example.tif_wulandari.home.Pertemuan_4.FourthActivity
import com.example.tif_wulandari.home.Pertemuan_7.SevenActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /** Ganti menjadi versi binding */
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // 1. Perbaikan pemanggilan getSharedPreferences di Fragment
        val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)

// 2. Pada tombol logout saat ingin menutup halaman:
        requireActivity().finish()
        // Tombol Pertemuan 4
        binding.btnPertemuan4.setOnClickListener {
            val intent = Intent(requireActivity(), FourthActivity::class.java)
            startActivity(intent)
        }

        // Tombol Logout sesuai Poin 3 Modul SharedPreferences
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireActivity())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->

                    // 1. Hapus data SharedPreferences sesuai instruksi modul
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()

                    // 2. Berpindah kembali ke AuthActivity lalu tutup MainActivity
                    val intent = Intent(requireActivity(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        binding.btnSeven.setOnClickListener {
            val intent = Intent(requireActivity(), SevenActivity::class.java)
            startActivity(intent)
        }
        binding.btnTenth.setOnClickListener {
            val intent = Intent(requireActivity(), SevenActivity::class.java)
            startActivity(intent)
        }
    }
}