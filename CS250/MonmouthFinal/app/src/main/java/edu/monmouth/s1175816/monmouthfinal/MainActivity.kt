package edu.monmouth.s1175816.monmouthfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("BRADLEY", "MainActivity.onCreate: begin")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.d("BRADLEY", "MainActivity.onCreateOptionsMenu: begin")
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("BRADLEY", "MainActivity.onOptionsItemSelected: ${item.itemId}")
        when (item.itemId) {
            R.id.menu_home ->
                findNavController(navHostFragment).navigate(R.id.mainFragment)
            R.id.menu_academics ->
                findNavController(navHostFragment).navigate(R.id.academicsFragment)
            R.id.menu_athletics ->
                findNavController(navHostFragment).navigate(R.id.athleticsFragment)
            R.id.menu_gallery ->
                findNavController(navHostFragment).navigate(R.id.galleryFragment)
            R.id.menu_map ->
                findNavController(navHostFragment).navigate(R.id.mapsActivity)
        }
        return true
    }

}