package edu.monmouth.cs250.instructor.names

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import android.widget.AdapterView.OnItemClickListener

class MainActivity : AppCompatActivity() {

    var students = arrayOf("Adam", "Amy", "Bill", "Bob", "Cyril", "David",
        "Erik", "Frank", "Gail", "Jill", "Kathy", "Kirk", "Mack", "Mary",
        "Zack")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter (this, R.layout.listview_item, students)

        val studentListView: ListView = findViewById(R.id.namesList)
        studentListView.adapter = adapter

        studentListView.onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // value of item that is clicked
                val itemValue = studentListView.getItemAtPosition(position) as String

                // Toast the values
                Toast.makeText(applicationContext, "Position :$position\nItem Value : $itemValue", Toast.LENGTH_SHORT).show()
            }
        }

    }

}
