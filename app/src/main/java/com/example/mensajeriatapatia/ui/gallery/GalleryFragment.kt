package com.example.mensajeriatapatia.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mensajeriatapatia.databinding.FragmentMensajeBinding

class GalleryFragment : Fragment() {

private var _binding: FragmentMensajeBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

    _binding = FragmentMensajeBinding.inflate(inflater, container, false)
    val root: View = binding.root

    galleryViewModel.text.observe(viewLifecycleOwner) {

    }
      Toast.makeText(requireContext(), "El fragment se ha activado", Toast.LENGTH_SHORT).show()
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}