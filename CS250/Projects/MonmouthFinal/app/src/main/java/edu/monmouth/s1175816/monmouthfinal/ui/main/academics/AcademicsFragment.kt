package edu.monmouth.s1175816.monmouthfinal.ui.main.academics

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import edu.monmouth.s1175816.monmouthfinal.R
import kotlinx.android.synthetic.main.academics_fragment.*

class AcademicsFragment : Fragment(), OnItemClickListener {

    private lateinit var customAdapter: SchoolListCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("BRADLEY", "AcademicsFragment.onCreate: begin")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.academics_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("BRADLEY", "AcademicsFragment.onCreate: begin")
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Academics"

        recyclerViewSchools.layoutManager = LinearLayoutManager(context)
        customAdapter = SchoolListCustomAdapter(requireContext(), this)
        recyclerViewSchools.adapter = customAdapter
        Log.d("BRADLEY", "AcademicsFragment.onCreate: return")
    }

    // navigation
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction (uri: Uri)
    }

    override fun onViewItemClicked(school: School) {
        Log.d("BRADLEY", "AcademicsFragment.onViewItemClicked: begin")
        val detailIntent = SchoolDetailActivity.newIntent(requireContext(), school)
        Log.d("BRADLEY", "AcademicsFragment.onViewItemClicked: detailIntent returned")
        startActivity(detailIntent)
        Log.d("BRADLEY", "AcademicsFragment.onViewItemClicked: startActivity() finished")
    }

}
