package edu.monmouth.brandonhenry.catencyclopedia.breeds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import edu.monmouth.brandonhenry.catencyclopedia.breeds.BreedListCustomAdapter
import edu.monmouth.s1175816.catencyclopedia.R
import kotlinx.android.synthetic.main.fragment_breeds.*

class BreedsFragment : Fragment() {

    private lateinit var customAdapter: BreedListCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breeds, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewBreeds.layoutManager = LinearLayoutManager(context)
        customAdapter = BreedListCustomAdapter(requireContext())
        recyclerViewBreeds.adapter = customAdapter
    }

}
