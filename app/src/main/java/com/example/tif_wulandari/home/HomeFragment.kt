package com.example.tif_wulandari.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.tif_wulandari.AuthActivity
import com.example.tif_wulandari.databinding.FragmentHomeBinding
import com.example.tif_wulandari.home.Pertemuan_11.EleventhActivity
import com.example.tif_wulandari.home.Pertemuan_2.SecondActivity
import com.example.tif_wulandari.home.Pertemuan_3.ThirdActivity
//import com.example.tif_wulandari.home.Pertemuan_4.FourthActivity
import com.example.tif_wulandari.home.Pertemuan_6.SharedPreferenceActivity
import com.example.tif_wulandari.home.Pertemuan_7.SevenActivity
import com.example.tif_wulandari.home.pertemuan_10.TenthActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)

        // Pertemuan 2
        binding.btnPertemuan2.setOnClickListener {
            startActivity(Intent(requireActivity(), SecondActivity::class.java))
        }

        // Pertemuan 3
        binding.btnPertemuan3.setOnClickListener {
            startActivity(Intent(requireActivity(), ThirdActivity::class.java))
        }

//        // Pertemuan 4
//        binding.btnPertemuan4.setOnClickListener {
//            startActivity(Intent(requireActivity(), FourthActivity::class.java))
//        }

        // Pertemuan 6
        binding.btnPertemuan6.setOnClickListener {
            startActivity(Intent(requireActivity(), SharedPreferenceActivity::class.java))
        }

        // Pertemuan 7
        binding.btnSeven.setOnClickListener {
            startActivity(Intent(requireActivity(), SevenActivity::class.java))
        }

        // Pertemuan 10
        binding.btnTenth.setOnClickListener {
            startActivity(Intent(requireActivity(), TenthActivity::class.java))
        }

        // Pertemuan 11
        binding.btnEleventh.setOnClickListener {
            startActivity(Intent(requireActivity(), EleventhActivity::class.java))
        }

        // Tombol Logout sesuai Poin 3 Modul SharedPreferences
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireActivity())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()

                    val intent = Intent(requireActivity(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}