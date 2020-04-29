package edu.monmouth.s1175816.monmouthfinal.ui.main.athletics

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import edu.monmouth.s1175816.monmouthfinal.R
import kotlinx.android.synthetic.main.academics_fragment.*
import kotlinx.android.synthetic.main.team_activity.*

class TeamActivity : AppCompatActivity() {

    private lateinit var customAdapter: TeamListCustomAdapter

    companion object {
        fun newIntent(context: Context): Intent {
            val detailIntent = Intent(context, TeamActivity::class.java)
            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("BRADLEY", "TeamActivity.onCreate: begin")
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Teams"
        setContentView(R.layout.team_activity)

        recyclerViewTeams.layoutManager = LinearLayoutManager(this)
        customAdapter = TeamListCustomAdapter(this)
        recyclerViewTeams.adapter = customAdapter
        Log.d("BRADLEY", "TeamActivity.onCreate: return")
    }

}