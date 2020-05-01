package edu.monmouth.s1175816.monmouthfinal.ui.main.athletics

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.monmouth.s1175816.monmouthfinal.R

class AthleticsFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = AthleticsFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("BRADLEY", "AthleticsFragment.onCreate: begin")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.athletics_fragment, container, false)
        var buttonTickets = view.findViewById<Button>(R.id.buttonTickets)
        var buttonTeams = view.findViewById<Button>(R.id.buttonTeams)
        buttonTickets.setOnClickListener(this)
        buttonTeams.setOnClickListener(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("BRADLEY", "AthleticsFragment.onViewCreated: begin")
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Athletics"
        Log.d("BRADLEY", "AthleticsFragment.onViewCreated: return")
    }

    fun launchTeamActivity() {
        Log.d("BRADLEY", "AthleticsFragment.launchTeamActivity: begin")
        val detailIntent = TeamActivity.newIntent(requireContext())
        startActivity(detailIntent)
    }

    fun launchTicketWebActivity() {
        Log.d("BRADLEY", "AthleticsFragment.launchTicketWebActivity: begin")
        val detailIntent = TicketWebActivity.newIntent(requireContext())
        startActivity(detailIntent)
    }

    override fun onClick(view: View?) {
        Log.d("BRADLEY", "AthleticsFragment.onClick: begin")
        when (view?.id) {
            R.id.buttonTickets -> {
                Log.d("BRADLEY", "AthleticsFragment.onClick: buttonTickets")
                launchTicketWebActivity()
            }
            R.id.buttonTeams -> {
                Log.d("BRADLEY", "AthleticsFragment.onClick: buttonTeams")
                launchTeamActivity()
            }
        }
    }

}
