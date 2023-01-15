package com.sourcey.materiallogindemo.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sourcey.materiallogindemo.databinding.ItemSourceBinding
import com.sourcey.materiallogindemo.model.source.Source

class SourceAdapter(var listSource : List<Source>):RecyclerView.Adapter<SourceAdapter.ViewHolder>() {

    var onClick : ((Source) -> Unit)? = null


    class ViewHolder(var binding : ItemSourceBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemSourceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var source = listSource[position]
        holder.binding.nameSource.text = source.name
        holder.binding.itemSource.setOnClickListener {
            onClick?.invoke(source)
        }
    }

    override fun getItemCount(): Int {
         return  listSource.size
    }
}