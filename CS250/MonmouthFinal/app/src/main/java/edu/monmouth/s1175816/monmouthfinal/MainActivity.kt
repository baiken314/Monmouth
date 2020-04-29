package edu.monmouth.s1175816.monmouthfinal

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import edu.monmouth.s1175816.monmouthfinal.ui.main.academics.AcademicsFragment

class MainActivity : AppCompatActivity(),
                     AcademicsFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("BRADLEY", "MainActivity.onCreate: begin")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        /**if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }*/
    }

    override fun onFragmentInteraction(uri: Uri) {}

}