package edu.monmouth.s1175816.monmouthfinal.ui.main.gallery

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import edu.monmouth.s1175816.monmouthfinal.R
import kotlinx.android.synthetic.main.gallery_fragment.*

class GalleryFragment : Fragment(), OnItemClickListener {

    private lateinit var customAdapter: GalleryListCustomAdapter

    companion object {
        fun newInstance() = GalleryFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("BRADLEY", "GalleryFragment.onCreate: begin")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.gallery_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("BRADLEY", "GalleryFragmet.onViewCreated: begin")
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Gallery"

        recyclerViewGallery.layoutManager = GridLayoutManager(context, 2)
        customAdapter = GalleryListCustomAdapter(requireContext(), this)
        recyclerViewGallery.adapter = customAdapter
        Log.d("BRADLEY", "GalleryFragmet.onViewCreated: return")
    }

    override fun onViewItemClicked(photo: Photo) {
        Log.d("BRADLEY", "GalleryFragment.onViewItemClicked: begin")
        val detailIntent = GalleryDetailActivity.newIntent(requireContext(), photo)
        startActivity(detailIntent)
        Log.d("BRADLEY", "GalleryFragment.onViewItemClicked: startActivity() finished")
    }

}
