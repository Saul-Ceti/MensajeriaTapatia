package com.example.mensajeriatapatia

class HistorialEnvios {
    var idHistorial : String = ""
    var mensajes : Array<Mensaje> = Array(50) {Mensaje()}
    var paquete : Array<Paquete> = Array(50) { Paquete() }
    var numMensaje : Int = 0
    var numPaquete : Int = 0
    var fechaEntrega : String = ""
    var estado : String = ""
    fun agregarMensaje (contenido : String, Fecha : String, Emisor : String, Receptor : String,mensajero : String){
        mensajes [numMensaje].idMensaje = numMensaje.toString()
        mensajes [numMensaje].contenido = contenido
        mensajes [numMensaje].Fecha = Fecha
        mensajes [numMensaje].Emisor = Emisor
        mensajes [numMensaje].Receptor = Receptor
        mensajes [numMensaje].Mensajero = mensajero
        numMensaje ++
    }
    fun agregarPaquete (contenido : String, peso : Double, dimensiones : String, fragil : Boolean,
                        idDireccion: String, calle : String, ciudad : String, codigoPostal : String, pais : String){
        paquete [numPaquete].idPaquete = numPaquete.toString()
        paquete [numPaquete].contenido = contenido
        paquete [numPaquete].peso = peso
        paquete [numPaquete].Fragil = fragil
        paquete [numPaquete].setDireccion(idDireccion,calle, ciudad, codigoPostal, pais)
        numPaquete ++
    }
}