package edu.monmouth.brandonhenry.catencyclopedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import edu.monmouth.s1175816.catencyclopedia.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            R.id.menu_home -> findNavController(nav_host_fragment).navigate(R.id.fragment_home)
            R.id.menu_breeds -> findNavController(nav_host_fragment).navigate(R.id.fragment_breeds)
            R.id.menu_about -> findNavController(nav_host_fragment).navigate(R.id.fragment_about)
            R.id.menu_adopt -> findNavController(nav_host_fragment).navigate(R.id.fragment_adopt)
        }
        return true
    }

}
