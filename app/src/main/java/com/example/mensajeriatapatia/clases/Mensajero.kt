package com.example.mensajeriatapatia.clases

import android.content.Context

class Mensajero {
    var idMensajero: String = ""
    var empresa: String = ""
    var vehiculo: String = ""
    var valoraciones: Double = 0.00

    // Constructor
    constructor(idMensajero: String, empresa: String, vehiculo: String, valoraciones: Double) {
        this.idMensajero = idMensajero
        this.empresa = empresa
        this.vehiculo = vehiculo
        this.valoraciones = valoraciones
    }
}

