package edu.monmouth.s1175816.studentlist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.student_detail.*

class StudentDetailActivity : AppCompatActivity() {

    companion object {

        // used for editing views in activity
        lateinit var context: Context
        lateinit var student: Student

        // create new intent, initialize variables
        fun newIntent(context: Context, student: Student): Intent {
            val detailIntent = Intent(context, StudentDetailActivity::class.java)
            this.context = context
            this.student = student
            return detailIntent
        }

    }

    // set title and views
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.student_detail)
        title = student.name
        textViewStudentDetailName.text = student.name
        textViewStudentDetailEmail.text = student.email
        // set switch on if junior/senior
        switchStudentDetailClassStatus.isChecked =
            student.classTitle.matches("(^[Ss]e.*)|(^[Jj].*)".toRegex())
        Glide.with(context).load(student.imageUrl).into(imageViewStudentDetail)
    }

}