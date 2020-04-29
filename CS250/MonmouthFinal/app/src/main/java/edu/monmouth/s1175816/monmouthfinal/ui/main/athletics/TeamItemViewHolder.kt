package edu.monmouth.s1175816.monmouthfinal.ui.main.athletics

import android.content.Context
import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.team_item_view.view.*

class TeamItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // access the views in activity adapter
    var view: View
    var textViewName = view.textViewName
    var textViewGender = view.textViewGender

    init { this.view = view }

    // change text values for each team
    fun bind(team: Team, context: Context) {
        textViewName.text = team.name
        textViewName.setTextColor(when (team.gender) {
            "male" -> Color.BLUE
            "female" -> Color.RED
            else -> Color.BLACK
        })
        textViewGender.text = team.gender
    }

}