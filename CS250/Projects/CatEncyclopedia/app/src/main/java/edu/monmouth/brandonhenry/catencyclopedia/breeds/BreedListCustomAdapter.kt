package edu.monmouth.brandonhenry.catencyclopedia.breeds

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.monmouth.s1175816.catencyclopedia.R

class BreedListCustomAdapter(val context: Context) : RecyclerView.Adapter<BreedItemViewHolder>() {

    private var breeds = ArrayList<Breed>()

    init {
        breeds = Breed.getBreedsFromJson("breeds.json", context)
    }

    override fun getItemCount(): Int {
        return breeds.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedItemViewHolder {
        val schoolItemLayout = LayoutInflater.from(parent.context)
        val schoolItemView = schoolItemLayout.inflate(
            R.layout.breed_item_view, parent, false)
        return BreedItemViewHolder(schoolItemView)
    }

    override fun onBindViewHolder(holder: BreedItemViewHolder, position: Int) {
        val school = breeds[position]
        holder.bind(school, context)
    }
}