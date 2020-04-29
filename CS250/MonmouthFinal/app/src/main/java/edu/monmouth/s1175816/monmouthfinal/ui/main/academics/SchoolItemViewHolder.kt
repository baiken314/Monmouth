package edu.monmouth.s1175816.monmouthfinal.ui.main.academics

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.school_item_view.view.*

class SchoolItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // access the views in activity adapter
    var view: View
    var textViewName = view.textViewName
    var textViewDepartments = view.textViewDepartments

    init { this.view = view }

    // change text values for each school
    fun bind(school: School, context: Context, onItemClickListener: OnItemClickListener) {
        textViewName.text = school.name
        textViewDepartments.text = school.departments.joinToString(", ")
        view.setOnClickListener {
            onItemClickListener.onViewItemClicked(school)
        }
    }

}