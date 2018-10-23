package com.nikolaenko.andrew.myapplication.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nikolaenko.andrew.myapplication.R
import com.nikolaenko.andrew.myapplication.model.ResponseModel
import org.jetbrains.anko.find

class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.MyViewHolder>(){

    private var list: MutableList<ResponseModel> = ArrayList()

    private var exampleListFull: List<ResponseModel>? = null

    fun setList(list: MutableList<ResponseModel>) {
        this.list = list
        exampleListFull = ArrayList(list)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var currencyName: TextView = view.find(R.id.currencyName)
        var currencyVolume: TextView = view.find(R.id.currencyVolume)
        var currencyAmount: TextView = view.find(R.id.currencyAmount)
        var item = view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_for_currency_list, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]

        holder.currencyName.text = item.name
        holder.currencyVolume.text = item.volume.toString()
        holder.currencyAmount.text = String.format( "%.2f", item.price?.amount)
    }

    override fun getItemCount(): Int = list.size
}
