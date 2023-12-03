package com.example.mensajeriatapatia

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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class BusquedaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño para este fragment
        return inflater.inflate(R.layout.fragment_busqueda, container, false)
    }
}

class DestinatarioFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño para este fragment
        return inflater.inflate(R.layout.fragment_destinatario, container, false)
    }
}

class MensajeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño para este fragment
        return inflater.inflate(R.layout.fragment_mensaje, container, false)
    }
}

class HistorialFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño para este fragment
        return inflater.inflate(R.layout.fragment_historial, container, false)
    }
}

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño para este fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}

class GalleryFragment : Fragment() {
    private lateinit var destinatario : EditText
    private lateinit var mensajero : EditText
    private lateinit var rbMensaje : RadioButton
    private lateinit var rbPaquete : RadioButton
    private lateinit var mensaje : EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var enviar : Button
    private lateinit var dimensiones : EditText
    private lateinit var peso : EditText
    var HistorialEnvios : HistorialEnvios = HistorialEnvios()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño para este fragment
        return inflater.inflate(R.layout.fragment_mensaje, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        destinatario = view.findViewById(R.id.edtDestinatario)
        mensajero = view.findViewById(R.id.edtMensajero)
        dimensiones = view.findViewById(R.id.edtDimensiones)
        peso = view.findViewById(R.id.edtPeso)
        radioGroup = view.findViewById(R.id.rgTipoM)
        rbMensaje = view.findViewById(R.id.rbMensaje)
        rbPaquete = view.findViewById(R.id.rbPaquete)
        mensaje = view.findViewById(R.id.edtTexto)
        enviar = view.findViewById(R.id.btnEntra)

        rbPaquete.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                dimensiones.visibility = EditText.VISIBLE
                peso.visibility = EditText.VISIBLE
            }
            else{
                dimensiones.visibility = EditText.INVISIBLE
                peso.visibility = EditText.INVISIBLE
            }
        }

        enviar.setOnClickListener(){
            if(destinatario.text.isNotEmpty() && destinatario.text.isNotBlank()
                && mensajero.text.isNotEmpty() && mensajero.text.isNotBlank()
                && mensaje.text.isNotEmpty() && mensaje.text.isNotBlank()
                && (rbMensaje.isChecked || rbPaquete.isChecked)){
                var fecha = LocalDateTime.now()
                val format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                val date : String = fecha.format(format)
                if(rbPaquete.isChecked && dimensiones.text.isNotEmpty() && dimensiones.text.isNotBlank()
                    && peso.text.isNotEmpty() && peso.text.isNotBlank()){
                    HistorialEnvios.agregarPaquete(mensaje.text.toString(),date,"0",destinatario.text.toString(),
                        mensajero.text.toString(),"Alguna casa",dimensiones.text.toString(),peso.text.toString().toDouble())
                    Toast.makeText(requireContext(),"Se prepara paquete para envio", Toast.LENGTH_SHORT).show()
                }
                if(rbMensaje.isChecked){
                    HistorialEnvios.agregarMensaje(mensaje.text.toString(),date,"0",destinatario.text.toString(),
                        mensajero.text.toString(),"Alguna casa")
                    Toast.makeText(requireContext(), "Mensaje enviado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

class MensajeroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño para este fragment
        return inflater.inflate(R.layout.fragment_mensajero, container, false)
    }
}
