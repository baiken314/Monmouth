package edu.monmouth.s1175816.studentlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StudentListCustomAdapter(val context: Context, val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<StudentItemViewHolder>() {

    private var students = ArrayList<Student>()

    init {
        val studentList = Student.getStudentsFromJson("cs250students.json", context)
        for (i in 0 until studentList.size) {
            students.add(studentList[i])
        }
    }

    override fun getItemCount(): Int {
        return students.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentItemViewHolder {
        val studentItemLayout = LayoutInflater.from(parent.context)
        val studentItemView = studentItemLayout.inflate(
            R.layout.student_item_view, parent, false)
        return StudentItemViewHolder(studentItemView)
    }

    override fun onBindViewHolder(holder: StudentItemViewHolder, position: Int) {
        val student = students[position]
        holder.bind(student, context, onItemClickListener)
    }

}

