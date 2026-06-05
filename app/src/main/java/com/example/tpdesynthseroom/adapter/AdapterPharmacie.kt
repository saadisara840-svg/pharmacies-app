package com.example.tpdesynthseroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tpdesynthseroom.model.Pharmacie
import com.example.tpdesynthseroom.R
class AdapterPharmacie (

    private val pharmaciers: List<Pharmacie>,
    private val onClick: (Pharmacie) -> Unit):

    RecyclerView.Adapter<AdapterPharmacie.PharmacieviewHolder>(){

    class PharmacieviewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val nom= itemView.findViewById<TextView>(R.id.etnom)!!
        val adrress = itemView.findViewById<TextView>(R.id.etadrress)!!
        val phone = itemView.findViewById<TextView>(R.id.etphone)!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacieviewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pharmacie,parent,false)
        return PharmacieviewHolder(view)
    }

    override fun getItemCount(): Int {
        return pharmaciers.size
    }

    override fun onBindViewHolder(holder: PharmacieviewHolder, position: Int) {

        val pharmacies = pharmaciers[position]

        holder.nom.text = pharmacies.name
        holder.adrress.text = pharmacies.address
        holder.phone.text = pharmacies.phone

        holder.itemView.setOnClickListener {
            onClick(pharmacies)
        }
    }
}