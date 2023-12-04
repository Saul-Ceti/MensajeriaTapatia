package com.example.mensajeriatapatia.clases

class Destinatario {
    var idDestinatario : String = ""
    var nombre : String = ""
    var direccion : String = ""

    // Constructor
    constructor(idDestinatario: String, nombre: String, direccion: String) {
        this.idDestinatario = idDestinatario
        this.nombre = nombre
        this.direccion = direccion
    }
}