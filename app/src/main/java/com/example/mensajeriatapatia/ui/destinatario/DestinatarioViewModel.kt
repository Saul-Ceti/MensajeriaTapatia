package com.example.mensajeriatapatia.ui.destinatario

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class DestinatarioViewModel : ViewModel() {
    private val _listaDestinatarios = MutableLiveData<MutableList<Destinatario>>(mutableListOf())
    val listaDestinatarios: LiveData<MutableList<Destinatario>> = _listaDestinatarios

    fun agregarDestinatario(destinatario: Destinatario) {
        val currentList = _listaDestinatarios.value ?: mutableListOf()
        currentList.add(destinatario)
        _listaDestinatarios.value = currentList
    }

}

data class Destinatario(val nombre: String, val direccion: String)
