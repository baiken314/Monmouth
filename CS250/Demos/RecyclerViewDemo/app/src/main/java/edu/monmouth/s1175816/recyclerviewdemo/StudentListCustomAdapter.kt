package edu.monmouth.s1175816.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_view.view.*

class StudentListCustomAdapter : RecyclerView.Adapter<CustomViewHolder>() {

    var cs250Students = arrayOf("Bradley", "Brandon", "Jason", "Kiyoko", "Makuo", "Sembrandt", "Antonio", "Mbake", "Weissmann", "Faedriel")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val studentRow = LayoutInflater.from(parent.context)
        val studentRowView = studentRow.inflate(R.layout.list_item_view, parent, false)
        return CustomViewHolder(studentRowView)
    }

    override fun getItemCount(): Int {
        return cs250Students.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.itemView.recyclerViewStudentName.text = cs250Students.get(position)
    }

}

class CustomViewHolder(view: View): RecyclerView.ViewHolder(view) {
    // no need to construct because we have a TextView
}