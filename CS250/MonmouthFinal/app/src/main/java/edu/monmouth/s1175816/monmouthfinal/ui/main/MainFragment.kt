package edu.monmouth.s1175816.monmouthfinal.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import edu.monmouth.s1175816.monmouthfinal.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private var muLogoUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmk0fbschedulesg7lec3.kinstacdn.com%2Fwp-content%2Fuploads%2F2017%2F10%2Fmonmouth-hawks.png&f=1&nofb=1"

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("BRADLEY", "MainFragment.onActivityCreated: begin")
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        // change title
        (activity as AppCompatActivity).actionBar?.title = "Home"
        
        // load logo with Glide
        Glide.with(requireContext()).load(muLogoUrl).into(imageViewLogo)

        // navigate to fragment
        findNavController().navigate(R.id.athleticsFragment)
    }

}
