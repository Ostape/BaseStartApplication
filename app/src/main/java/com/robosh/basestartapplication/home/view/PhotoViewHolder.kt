package com.robosh.basestartapplication.home.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.robosh.basestartapplication.R
import com.robosh.basestartapplication.databinding.ViewHolderPhotoBinding
import com.robosh.basestartapplication.model.Photo
import com.squareup.picasso.Picasso

class PhotoViewHolder private constructor(
    view: View,
    private val clickListener: PhotoClickListenerFactory?
) : RecyclerView.ViewHolder(view) {

    companion object {
        fun create(
            parent: ViewGroup,
            clickListener: PhotoClickListenerFactory?
        ): PhotoViewHolder {
            return PhotoViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_photo, parent, false),
                clickListener
            )
        }
    }

    private val binding: ViewHolderPhotoBinding = ViewHolderPhotoBinding.bind(view)

    fun bind(photo: Photo) {
        with(binding) {
            Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(photoId)
//            photoId.setOnClickListener(clickListener.createOnClickListener(photo))
        }
    }
}