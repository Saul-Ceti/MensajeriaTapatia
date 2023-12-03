package com.example.mensajeriatapatia

object MensajeroRepository {
    private val listaMensajeros: MutableList<Mensajero> = mutableListOf()

    fun agregarMensajero(mensajero: Mensajero) {
        listaMensajeros.add(mensajero)
    }

    fun obtenerMensajeros(): List<Mensajero> {
        return listaMensajeros.toList()
    }
}
