package edu.monmouth.s1175816.monmouthfinal.ui.main.academics

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.monmouth.s1175816.monmouthfinal.R
import kotlinx.android.synthetic.main.school_detail_view.*

class SchoolDetailActivity : AppCompatActivity() {

    companion object {

        // used for editing views in fragment
        lateinit var context: Context
        lateinit var school: School

        // create new intent, initialize variables
        fun newIntent(context: Context, school: School): Intent {
            Log.d("BRADLEY", "SchoolDetailActivity.newIntent: begin")
            val detailIntent = Intent(context, SchoolDetailActivity::class.java)
            this.context = context
            this.school = school
            Log.d("BRADLEY", "SchoolDetailActivity.newIntent: return")
            return detailIntent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("BRADLEY", "SchoolDetailActivity.onCreate: begin")
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "School"
        setContentView(R.layout.school_detail_view)
        textViewName.text = school.name
        textViewDepartments.text = school.departments.joinToString(", ")
        textViewAbout.text = school.about
        Log.d("BRADLEY", "SchoolDetailActivity.onCreate: return")
    }

}