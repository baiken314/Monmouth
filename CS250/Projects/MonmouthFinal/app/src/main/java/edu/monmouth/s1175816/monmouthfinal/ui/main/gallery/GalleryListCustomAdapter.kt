package edu.monmouth.s1175816.monmouthfinal.ui.main.gallery

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.monmouth.s1175816.monmouthfinal.R

class GalleryListCustomAdapter(val context: Context,
                               val onItemClickListener: OnItemClickListener
                               ) : RecyclerView.Adapter<GalleryItemViewHolder>() {

    private var photos = ArrayList<Photo>()

    init {
        Log.d("BRADLEY", "GalleryListCustomAdapter.init: begin")
        photos = Photo.getPhotosFromJson("gallery.json", context)
    }

    override fun getItemCount(): Int {
        return photos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryItemViewHolder {
        val galleryItemLayout = LayoutInflater.from(parent.context)
        val galleryItemView = galleryItemLayout.inflate(
            R.layout.gallery_item_view, parent, false)
        return GalleryItemViewHolder(galleryItemView)
    }

    override fun onBindViewHolder(holder: GalleryItemViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo, context, onItemClickListener)
    }

}