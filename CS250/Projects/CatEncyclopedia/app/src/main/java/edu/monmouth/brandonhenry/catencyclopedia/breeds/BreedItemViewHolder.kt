package edu.monmouth.brandonhenry.catencyclopedia.breeds

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.monmouth.brandonhenry.catencyclopedia.breeds.Breed
import kotlinx.android.synthetic.main.breed_item_view.view.*

class BreedItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // access the views in adapter
    var view: View
    var textViewBreed = view.textViewBreed
    var textViewOrigin = view.textViewOrigin
    var textViewIndoor = view.textViewIndoor
    var textViewDescription = view.textViewDescription

    init { this.view = view }

    // change text values for each school
    fun bind(breed: Breed, context: Context) {
        textViewBreed.text = breed.name
        textViewOrigin.text = breed.origin
        textViewIndoor.text = breed.indoor
        textViewDescription.text = breed.description
    }

}