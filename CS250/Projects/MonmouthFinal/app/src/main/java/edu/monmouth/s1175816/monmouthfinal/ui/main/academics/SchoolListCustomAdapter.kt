package edu.monmouth.s1175816.monmouthfinal.ui.main.academics

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.monmouth.s1175816.monmouthfinal.R

class SchoolListCustomAdapter(val context: Context,
                              val onItemClickListener: OnItemClickListener
                              ) : RecyclerView.Adapter<SchoolItemViewHolder>() {

    private var schools = ArrayList<School>()

    init {
        Log.d("BRADLEY", "SchoolListCustomAdapter.init: begin")
        schools = School.getSchoolsFromJson("schools.json", context)
    }

    override fun getItemCount(): Int {
        return schools.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolItemViewHolder {
        val schoolItemLayout = LayoutInflater.from(parent.context)
        val schoolItemView = schoolItemLayout.inflate(
            R.layout.school_item_view, parent, false)
        return SchoolItemViewHolder(schoolItemView)
    }

    override fun onBindViewHolder(holder: SchoolItemViewHolder, position: Int) {
        val school = schools[position]
        holder.bind(school, context, onItemClickListener)
    }

}