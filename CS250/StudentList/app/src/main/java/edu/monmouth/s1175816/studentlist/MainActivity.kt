package edu.monmouth.s1175816.studentlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var customAdapter: StudentListCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        // instantiate main activity
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // instantiate recycler view with linear layout
        recyclerViewStudents.layoutManager = LinearLayoutManager(this)
        customAdapter = StudentListCustomAdapter(this, this)
        recyclerViewStudents.adapter = customAdapter

    }

    override fun onViewItemClicked(student: Student) {
        val detailIntent = StudentDetailActivity.newIntent(this, student)
        startActivity(detailIntent)
    }

}
