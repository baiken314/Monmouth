package edu.monmouth.s1175816.monmouthfinal.ui.main.gallery

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.gallery_item_view.view.*

class GalleryItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // access views in adapter
    var view: View
    var textViewName = view.textViewName
    var imageViewIcon = view.imageViewIcon

    init { this.view = view }

    // change text values for each school
    fun bind(photo: Photo, context: Context, onItemClickListener: OnItemClickListener) {
        textViewName.text = photo.name
        Glide.with(context).load(photo.url).into(imageViewIcon)
        view.setOnClickListener {
            onItemClickListener.onViewItemClicked(photo)
        }
    }

}