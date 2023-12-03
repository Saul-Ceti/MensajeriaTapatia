package com.example.mensajeriatapatia.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mensajeriatapatia.R
import com.example.mensajeriatapatia.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
  private var _binding: FragmentHomeBinding? = null
  private val binding get() = _binding!!
  private val PREF_NAME = "UserData"

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val sharedPreferences = requireActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    val username = sharedPreferences.getString("name", "default")

    // Texto de otro color
    val signinTextView = root.findViewById<TextView>(R.id.txtSaludo)

    // Configurar el texto en el TextView
    signinTextView.text = "Bienvenido $username"

    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}