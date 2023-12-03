package com.example.mensajeriatapatia

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mensajeriatapatia.ui.destinatario.Destinatario
import com.example.mensajeriatapatia.ui.destinatario.ManagerDestinatarios

class FragmentDestinatario : Fragment() {

    private lateinit var editTextName: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var buttonAdd: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destinatario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

            ManagerDestinatarios.listaDestinatarios.add(Destinatario(nombre, direccion))

            // Crear y mostrar un Toast con la lista de destinatarios
            val listaDestinatariosString = ManagerDestinatarios.listaDestinatarios.joinToString(separator = "\n") { dest ->
                "Nombre: ${dest.nombre}, Dirección: ${dest.direccion}"
            }
            Toast.makeText(context, "Destinatarios registrados:\n$listaDestinatariosString", Toast.LENGTH_LONG).show()

            editTextName.text.clear()
            editTextAddress.text.clear()

            val recyclerView: RecyclerView = view.findViewById(R.id.my_recycler_view)
            recyclerView.layoutManager = LinearLayoutManager(context)

        }
        }
    }

