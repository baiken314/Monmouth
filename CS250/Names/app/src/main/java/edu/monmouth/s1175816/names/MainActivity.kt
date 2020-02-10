package edu.monmouth.s1175816.names

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var names = arrayOf("Bradley", "Brandon", "Jason", "Kevin", "Tyler", "Noah", "Tom", "Rob")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, R.layout.listview_item, names)

        val nameListView: ListView = findViewById(R.id.lstNames)
        nameListView.adapter = adapter

        nameListView.onItemClickListener = object: AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val itemValue = nameListView.getItemAtPosition(position) as String
                Toast.makeText(applicationContext, "Position: $position\nItem value: $itemValue", Toast.LENGTH_SHORT).show()
            }
        }

    }

}
