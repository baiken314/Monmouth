package edu.monmouth.s1175816.monmouthfinal.ui.main.athletics

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.monmouth.s1175816.monmouthfinal.R

class TeamListCustomAdapter(val context: Context) : RecyclerView.Adapter<TeamItemViewHolder>() {

    private var teams = ArrayList<Team>()

    init {
        Log.d("BRADLEY", "TeamListCustomAdapter.init: begin")
        teams = Team.getTeamsFromJson("teams.json", context)
    }

    override fun getItemCount(): Int {
        return teams.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamItemViewHolder {
        val teamItemLayout = LayoutInflater.from(parent.context)
        val teamItemView = teamItemLayout.inflate(
            R.layout.team_item_view, parent, false)
        return TeamItemViewHolder(teamItemView)
    }

    override fun onBindViewHolder(holder: TeamItemViewHolder, position: Int) {
        val team = teams[position]
        holder.bind(team, context)
    }


}