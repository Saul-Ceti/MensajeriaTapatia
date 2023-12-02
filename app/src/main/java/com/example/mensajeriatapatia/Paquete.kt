package com.example.mensajeriatapatia

class Paquete {
    var idPaquete : String = ""
    var contenido : String =  ""
    var peso : Double = 0.00
    var dimensiones : String = "0x0x0"
    var Fragil : Boolean = false
    lateinit var Direccion : Direccion

    fun setDireccion(idDireccion: String, calle : String, ciudad : String, codigoPostal : String, pais : String){
        Direccion = Direccion(idDireccion,calle,ciudad,codigoPostal,pais)
    }
}