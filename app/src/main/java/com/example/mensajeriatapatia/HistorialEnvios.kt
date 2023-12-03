package com.example.mensajeriatapatia

class HistorialEnvios {
    //var idHistorial : String = ""
    var mensajes : Array<Mensaje> = Array(50) {Mensaje()}
    var paquete : Array<Paquete> = Array(50) { Paquete() }
    var numMensaje : Int = 0
    var numPaquete : Int = 0
    //var fechaEntrega : String = ""
    //var estado : String = ""
    fun agregarMensaje (contenido : String, Fecha : String, Emisor : String, Receptor : String,
                        mensajero : String, direccion : String){
        mensajes [numMensaje].idMensaje = numMensaje.toString()
        mensajes [numMensaje].contenido = contenido
        mensajes [numMensaje].Fecha = Fecha
        mensajes [numMensaje].emisor = Emisor
        mensajes [numMensaje].receptor = Receptor
        mensajes [numMensaje].mensajero = mensajero
        mensajes [numMensaje].direccion = direccion
        numMensaje ++
    }
    fun agregarPaquete (contenido : String, fecha : String, emisor : String,receptor : String,
                        mensajero : String, direccion: String, dimensiones : String, peso : Double){
        paquete [numPaquete].idMensaje = numPaquete.toString()
        paquete [numPaquete].contenido = contenido
        paquete [numPaquete].Fecha = fecha
        paquete [numPaquete].emisor = emisor
        paquete [numPaquete].receptor = receptor
        paquete [numPaquete].mensajero = mensajero
        paquete [numPaquete].direccion = direccion
        paquete [numPaquete].dimensiones = dimensiones
        paquete [numPaquete].peso = peso
        numPaquete ++
    }
}