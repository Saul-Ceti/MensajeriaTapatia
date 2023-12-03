package com.example.mensajeriatapatia

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class fragment_mensajero : Fragment() {
    private lateinit var empresaEditText: EditText
    private lateinit var vehiculoEditText: EditText
    private lateinit var entregasEditText: EditText
    private lateinit var valoracionRatingBar: RatingBar

    private var param1: String? = null
    private var param2: String? = null

    // Instancia de Mensajero
    private var mensajero: Mensajero? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            Log.d("TAG", "Entrando en onCreateView de fragment_mensajero")
            Toast.makeText(requireContext(), "onCreate llamado", Toast.LENGTH_SHORT).show()
            Toast.makeText(activity?.applicationContext, "Mensaje", Toast.LENGTH_SHORT).show()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(requireContext(), "Fragmento inflado correctamente", Toast.LENGTH_SHORT).show()
        Toast.makeText(activity?.applicationContext, "Mensaje", Toast.LENGTH_SHORT).show()

        val view = inflater.inflate(R.layout.fragment_mensajero, container, false)

        // Inicializar vistas
        empresaEditText = view.findViewById(R.id.edtEmpresa)
        vehiculoEditText = view.findViewById(R.id.edtVehiculo)
        entregasEditText = view.findViewById(R.id.edtEntregas)
        valoracionRatingBar = view.findViewById(R.id.rbValoracion)

        // Configurar evento de clic para algún botón o acción
        // Puedes llamar a la función para crear una instancia de Mensajero
        view.findViewById<Button>(R.id.btnEntra2).setOnClickListener {
            Log.d("TAG", "Botón Entra2 clickeado")
            if (validarCampos()) {
                crearInstanciaMensajero()
                Toast.makeText(requireContext(), "Mensajero creado correctamente", Toast.LENGTH_SHORT).show()
            } else {
                // Mostrar un mensaje de error al usuario
                Toast.makeText(requireContext(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar el listener para el RatingBar
        valoracionRatingBar.setOnRatingBarChangeListener { _, rating, fromUser ->
            // "rating" contiene el valor seleccionado por el usuario
            // "fromUser" indica si el cambio provino del usuario (true) o fue programático (false)
            // Puedes realizar acciones aquí según la calificación seleccionada
            Toast.makeText(requireContext(), "Calificación: $rating", Toast.LENGTH_SHORT).show()
            Log.d("TAG", "Calificación cambiada a: $rating")
        }

        return view
    }

    // Función para validar que los campos estén completos
    private fun validarCampos(): Boolean {
        val camposCompletos = empresaEditText.text.isNotBlank() &&
                vehiculoEditText.text.isNotBlank() &&
                entregasEditText.text.isNotBlank()

        if (!camposCompletos) {
            Log.d("TAG", "Campos incompletos")
        }

        return camposCompletos
    }

    // Función para crear una instancia de Mensajero
    private fun crearInstanciaMensajero() {
        mensajero = Mensajero().apply {
            empresa = empresaEditText.text.toString()
            vehiculo = vehiculoEditText.text.toString()

            // Manejo de posibles errores al convertir el texto a Int
            entregas = entregasEditText.text.toString().toIntOrNull() ?: 0

            valoraciones = valoracionRatingBar.rating.toDouble()
        }

        // Agregar el mensajero a la lista en el repositorio
        mensajero?.let {
            MensajeroRepository.agregarMensajero(it)
            // Puedes realizar otras acciones o enviar 'mensajero' a donde sea necesario
            Log.d("TAG", "Mensajero agregado a la lista en el repositorio")
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TAG", "onDestroyView llamado")

    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "Fragmento Mensajero onResume")
    }

}
