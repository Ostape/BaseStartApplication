package com.robosh.basestartapplication.home.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.robosh.basestartapplication.model.Movie

class MovieAdapter(
    private val clickListener: MovieClickListenerFactory
) : RecyclerView.Adapter<MovieViewHolder>() {

    private val photos = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.create(parent, clickListener)
    }

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    fun setData(list: List<Movie>) {
        photos.clear()
        photos.addAll(list)
        notifyDataSetChanged()
    }
}