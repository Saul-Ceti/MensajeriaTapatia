package com.example.mensajeriatapatia.clases

open class Mensaje {
    var idMensaje : String = ""
    var emisor : String = ""
    var destinatario : String = ""
    var mensajero : String = ""
    var contenido : String = ""
    var Fecha : String = ""

    // Constructor
    constructor(idMensaje: String, emisor: String, destinatario: String, mensajero: String, contenido: String, Fecha: String) {
        this.idMensaje = idMensaje
        this.emisor = emisor
        this.destinatario = destinatario
        this.mensajero = mensajero
        this.contenido = contenido
        this.Fecha = Fecha
    }
}
