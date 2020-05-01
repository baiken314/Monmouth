package edu.monmouth.s1175816.studentlist

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.student_item_view.view.*

class StudentItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // access the views in activity adapter
    var view: View
    var textViewStudentName = view.textViewStudentName
    var textViewStudentAdvisor = view.textViewStudentAdvisor
    var textViewStudentClassTitle = view.textViewStudentClassTitle
    var imageViewStudent: ImageView = view.imageViewStudent

    init { this.view = view }

    fun bind(student: Student, context: Context, onItemClickListener: OnItemClickListener) {
        textViewStudentName.text = student.name
        textViewStudentAdvisor.text = student.advisor
        textViewStudentClassTitle.text = student.classTitle
        Glide.with(context).load(student.imageUrl).into(imageViewStudent)

        view.setOnClickListener {
            onItemClickListener.onViewItemClicked(student)
        }
    }

}