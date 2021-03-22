package com.robosh.basestartapplication.home.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.robosh.basestartapplication.net.model.PokemonListResponse

class PhotoAdapter(
    private val clickListener: PhotoClickListenerFactory?
) : RecyclerView.Adapter<PhotoViewHolder>() {

    private val photos = ArrayList<PokemonListResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder.create(parent, clickListener)
    }

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
//        holder.bind(photos[position])
    }

    fun setData(list: List<PokemonListResponse>) {
        photos.clear()
        photos.addAll(list)
        notifyDataSetChanged()
    }
}