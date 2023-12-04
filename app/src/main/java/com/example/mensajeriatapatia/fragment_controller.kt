package com.example.mensajeriatapatia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mensajeriatapatia.clases.Destinatario
import com.example.mensajeriatapatia.clases.Mensaje
import com.example.mensajeriatapatia.clases.MensajeAdapter
import com.example.mensajeriatapatia.clases.Mensajero
import com.example.mensajeriatapatia.clases.Paquete
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// Variables globales
var listaDestinatarios = mutableListOf<Destinatario>()
var listaMensajeros = mutableListOf<Mensajero>()
var listaPaquetes = mutableListOf<Paquete>()
var listaMensajes = mutableListOf<Mensaje>()

class BusquedaFragment : Fragment() {
    // Variables
    private lateinit var editTextId: EditText
    private lateinit var resultado: TextView
    private lateinit var buttonBuscar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño para este fragment
        val view = inflater.inflate(R.layout.fragment_busqueda, container, false)

        editTextId = view.findViewById(R.id.edtBusBusqueda)
        resultado = view.findViewById(R.id.txtBusResult)
        buttonBuscar = view.findViewById(R.id.btnBusBuscar)

        buttonBuscar.setOnClickListener {
            val idBusqueda = editTextId.text.toString().trim()

            if (idBusqueda.isEmpty()) {
                editTextId.error = "Ingresa un ID válido"
                return@setOnClickListener
            }

            // Buscar mensaje
            val mensajeEncontrado = listaMensajes.find { mensaje ->
                mensaje.idMensaje == idBusqueda
            }

            if (mensajeEncontrado != null) {
                // Buscar mensajero
                val mensajeroEncontrado = listaMensajeros.find { mensajero ->
                    mensajero.idMensajero == mensajeEncontrado.mensajero
                }

                // Buscar destinatario
                val destinatarioEncontrado = listaDestinatarios.find { destinatario ->
                    destinatario.idDestinatario == mensajeEncontrado.destinatario
                }

                // Mostrar información encontrada
                val mensajeInfo = """
                    Mensaje ID: ${mensajeEncontrado.idMensaje}
                    Contenido: ${mensajeEncontrado.contenido}
                    Fecha: ${mensajeEncontrado.Fecha}
                    
                    Mensajero ID: ${mensajeroEncontrado?.idMensajero}
                    Empresa: ${mensajeroEncontrado?.empresa}
                    Vehículo: ${mensajeroEncontrado?.vehiculo}
                    Valoraciones: ${mensajeroEncontrado?.valoraciones}
                    
                    Destinatario ID: ${destinatarioEncontrado?.idDestinatario}
                    Nombre: ${destinatarioEncontrado?.nombre}
                    Dirección: ${destinatarioEncontrado?.direccion}
                """.trimIndent()

                resultado.text = mensajeInfo
            } else {
                resultado.text = "Mensaje no encontrado"
            }
        }

        return view
    }
}

class DestinatarioFragment : Fragment() {
    private lateinit var editTextName: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var buttonAdd: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño para este fragment
        val view = inflater.inflate(R.layout.fragment_destinatario, container, false)

        editTextName = view.findViewById(R.id.editTextName)
        editTextAddress = view.findViewById(R.id.editTextAddress)
        buttonAdd = view.findViewById(R.id.buttonAdd)

        buttonAdd.setOnClickListener {
            val nombre = editTextName.text.toString().trim()
            val direccion = editTextAddress.text.toString().trim()

            if (nombre.isEmpty()) {
                editTextName.error = "Por favor, ingresa un nombre."
                return@setOnClickListener
            }

            if (direccion.isEmpty()) {
                editTextAddress.error = "Por favor, ingresa una dirección."
                return@setOnClickListener
            }

            // Generar idDestinatario secuencial
            val idDestinatario = if (listaDestinatarios.isEmpty()) {
                "1"
            } else {
                (listaDestinatarios.last().idDestinatario.toInt() + 1).toString()
            }

            // Agregar destinatario a la lista
            listaDestinatarios.add(Destinatario(idDestinatario,nombre, direccion))
            Toast.makeText(context, "Destinatario agregado con éxito", Toast.LENGTH_SHORT).show()

            editTextName.text.clear()
            editTextAddress.text.clear()
        }

        return view
    }
}

class HistorialFragment : Fragment() {
    // Variables
    private lateinit var historialRecicleView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño para este fragment
        var view = inflater.inflate(R.layout.fragment_historial, container, false)

        historialRecicleView = view.findViewById(R.id.rcvHis)
        historialRecicleView.layoutManager = LinearLayoutManager(context)

        val mensajeAdapter = MensajeAdapter(listaMensajes)
        historialRecicleView.adapter = mensajeAdapter

        return view
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
    // Variables
    private lateinit var destinatario: Spinner
    private lateinit var direccion: EditText
    private lateinit var mensajero: Spinner
    private lateinit var radioGroup: RadioGroup
    private lateinit var rbMensaje: RadioButton
    private lateinit var rbPaquete: RadioButton
    private lateinit var contenido: EditText
    private lateinit var enviar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mensaje, container, false)

        destinatario = view.findViewById(R.id.spnMenDestinatarios)
        direccion = view.findViewById(R.id.edtMenDireccion)
        mensajero = view.findViewById(R.id.spnMenMensajeros)
        radioGroup = view.findViewById(R.id.rgTipoM)
        rbMensaje = view.findViewById(R.id.rbMensaje)
        rbPaquete = view.findViewById(R.id.rbPaquete)
        contenido = view.findViewById(R.id.edtMenContenido)
        enviar = view.findViewById(R.id.btnMenEnviar)

        // El spinner de destinatarios contiene los nombres de los destinatarios de la lista
        val listaDestinatariosString = listaDestinatarios.map { dest ->
            dest.nombre
        }
        if (listaDestinatariosString.isEmpty()) {
            destinatario.isEnabled = false
            Toast.makeText(context, "No hay destinatarios registrados", Toast.LENGTH_SHORT).show()
        }
        destinatario.adapter = context?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, listaDestinatariosString) }

        // El texto de la dirección se actualiza cuando se selecciona un destinatario
        direccion.isEnabled = false
        destinatario.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                direccion.setText(listaDestinatarios[position].direccion)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                direccion.setText("")
            }
        }

        // El spinner de mensajeros contiene los nombres de los mensajeros de la lista
        val listaMensajerosString = listaMensajeros.map { mens ->
            mens.empresa
        }
        if (listaMensajerosString.isEmpty()) {
            mensajero.isEnabled = false
            Toast.makeText(context, "No hay mensajeros registrados", Toast.LENGTH_SHORT).show()
        }
        mensajero.adapter = context?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, listaMensajerosString) }

        enviar.setOnClickListener {
            val idMensaje = if (listaMensajes.isEmpty()) {
                "1"
            } else {
                (listaMensajes.last().idMensaje.toInt() + 1).toString()
            }

            val idDestinatario = listaDestinatarios[destinatario.selectedItemPosition].idDestinatario
            val idMensajero = listaMensajeros[mensajero.selectedItemPosition].idMensajero
            val tipo = if (rbMensaje.isChecked) {
                "Mensaje"
            } else {
                "Paquete"
            }
            val contenido = contenido.text.toString().trim()

            if (contenido.isEmpty()) {
                this.contenido.error = "Por favor, ingresa un contenido."
                return@setOnClickListener
            }

            val fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))

            // Agregar mensaje a la lista
            listaMensajes.add(Mensaje(idMensaje, idDestinatario, idMensajero, tipo, contenido, fecha))
            Toast.makeText(context, "Mensaje enviado con éxito", Toast.LENGTH_SHORT).show()

            // Limpiar campos
            this.contenido.text.clear()
        }

        return view
    }
}

class MensajeroFragment : Fragment() {
    // Variables
    private lateinit var editTextEmpresa: EditText
    private lateinit var editTextVehiculo: EditText
    private lateinit var ratingBar: RatingBar
    private lateinit var buttonAdd: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mensajero, container, false)

        editTextEmpresa = view.findViewById(R.id.edtMjrEmpresa)
        editTextVehiculo = view.findViewById(R.id.edtMjrVehiculo)
        ratingBar = view.findViewById(R.id.ratingBar)
        buttonAdd = view.findViewById(R.id.btnMjrAdd)

        buttonAdd.setOnClickListener {
            val empresa = editTextEmpresa.text.toString().trim()
            val vehiculo = editTextVehiculo.text.toString().trim()
            val valoraciones = ratingBar.rating.toDouble()

            if (empresa.isEmpty()) {
                editTextEmpresa.error = "Por favor, ingresa una empresa."
                return@setOnClickListener
            }

            if (vehiculo.isEmpty()) {
                editTextVehiculo.error = "Por favor, ingresa un vehículo."
                return@setOnClickListener
            }

            // Generar idMensajero secuencial
            val idMensajero = if (listaMensajeros.isEmpty()) {
                "1"
            } else {
                (listaMensajeros.last().idMensajero.toInt() + 1).toString()
            }

            // Agregar mensajero a la lista
            listaMensajeros.add(Mensajero(idMensajero, empresa, vehiculo, valoraciones))
            Toast.makeText(requireContext(), "Mensajero agregado con éxito", Toast.LENGTH_SHORT).show()

            editTextEmpresa.text.clear()
            editTextVehiculo.text.clear()
            ratingBar.rating = 0.0f
        }

        return view
    }
}

