

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.monmouth.cs250.instructor.navdraw.R


import kotlinx.android.synthetic.main.studentphoto_customview.*
import kotlinx.android.synthetic.main.studentphoto_customview.view.*

class StudentPhotoCustomViewAdapter (private val context: Context, val photoviewListener: OnPhotoClickListener) : RecyclerView.Adapter<CustomPhotoHolder> (){


    private var studentsList = ArrayList<Student> ()

    // intializer method - get the data from Recipe model class
    // Note - we are invoking the companion object using class reference Recipe.getRecipesFromFrom(...)

    init {
        studentsList = Student.getStudentsFromFile("cs250students.json", context)
    }

    // number of items in RecyclerView

    override fun getItemCount(): Int {
        // return students.count()
        return studentsList.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomPhotoHolder {
        val studentPhotoLayout = LayoutInflater.from(parent.context)
        val studentPhotoView =  studentPhotoLayout.inflate (R.layout.studentphoto_customview, parent, false)
        return CustomPhotoHolder(studentPhotoView)
    }

    override fun onBindViewHolder(holder: CustomPhotoHolder, position: Int) {


        val student = studentsList.get(position)
        holder.bind(student, context, photoviewListener)

    }

}

class CustomPhotoHolder (photoView: View): RecyclerView.ViewHolder (photoView) {

    var studentPhoto: ImageView = photoView.studentPhotoView

    fun bind (student: Student, context: Context, photoviewListner: OnPhotoClickListener) {
        val imgURL = student.photoURL
        println ("******** $imgURL *******")

        Glide.with(context).load(imgURL).into(studentPhoto)

        studentPhoto.setOnClickListener {
            print ("******* ${student.studentName} *******")
            photoviewListner.onPhotoitemClicked(student)
        }
    }
}


interface OnPhotoClickListener {
    fun onPhotoitemClicked (student: Student)
}