package edu.monmouth.s1175816.monmouthfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("BRADLEY", "MainActivity.onCreate: begin")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        configureTabLayout()
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
            R.id.menu_map ->
                findNavController(navHostFragment).navigate(R.id.mapsActivity)
        }
        return true
    }

    private fun configureTabLayout() {
        tabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                Log.d("BRADLEY", "MainActivity.tabLayout.onTabSelected: ${tab.position}")
                when (tab.position) {
                    0 -> findNavController(navHostFragment).navigate(R.id.mainFragment)
                    1 -> findNavController(navHostFragment).navigate(R.id.academicsFragment)
                    2 -> findNavController(navHostFragment).navigate(R.id.athleticsFragment)
                    3 -> findNavController(navHostFragment).navigate(R.id.galleryFragment)
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

}