package com.example.mensajeriatapatia.clases

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mensajeriatapatia.R

class MensajeAdapter(private val mensajes: List<Mensaje>) : RecyclerView.Adapter<MensajeAdapter.MensajeViewHolder>() {

    class MensajeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idTextView: TextView = itemView.findViewById(R.id.textId)
        val contenidoTextView: TextView = itemView.findViewById(R.id.textContenido)
        val fechaTextView: TextView = itemView.findViewById(R.id.textFecha)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensajeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_mensaje, parent, false)
        return MensajeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MensajeViewHolder, position: Int) {
        val mensaje = mensajes[position]
        holder.idTextView.text = mensaje.idMensaje
        holder.contenidoTextView.text = mensaje.contenido
        holder.fechaTextView.text = mensaje.Fecha
    }

    override fun getItemCount(): Int {
        return mensajes.size
    }
}
