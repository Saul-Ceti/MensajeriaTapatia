package com.example.mensajeriatapatia.ui.destinatario

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DestinatarioViewModel : ViewModel() {
    private val _destinatarios = MutableLiveData<List<Destinatario>>()
    val destinatarios: LiveData<List<Destinatario>> = _destinatarios

    private val listaDestinatarios = mutableListOf<Destinatario>()

    init {
        _destinatarios.value = listaDestinatarios
    }

    fun agregarDestinatario(destinatario: Destinatario) {
        listaDestinatarios.add(destinatario)
        _destinatarios.value = listaDestinatarios
    }
}
