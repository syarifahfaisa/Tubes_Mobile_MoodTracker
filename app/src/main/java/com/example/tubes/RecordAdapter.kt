package com.example.tubes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.record_layout.view.*


class RecordAdapter(var list: ArrayList<Record>): RecyclerView.Adapter<RecordAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var date=itemView.dateview
        var mood=itemView.moodview
        var event=itemView.eventview
        var desc=itemView.descview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.record_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date.text=list[position].date
        holder.mood.text=list[position].mood
        holder.event.text=list[position].event
        holder.desc.text=list[position].desc
    }

}