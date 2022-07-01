package com.example.recyclerviewretrofitcoroutines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val list :List<JsonApiResponse>):RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {


  inner  class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
      val title=itemView.findViewById<TextView>(R.id.txt_title)
      val description=itemView.findViewById<TextView>(R.id.txt_description)
      val id=itemView.findViewById<TextView>(R.id.txt_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text=list[position].title
        holder.description.text=list[position].body
        holder.id.text=list[position].id.toString()
    }

    override fun getItemCount(): Int {
      return list.size
    }
}