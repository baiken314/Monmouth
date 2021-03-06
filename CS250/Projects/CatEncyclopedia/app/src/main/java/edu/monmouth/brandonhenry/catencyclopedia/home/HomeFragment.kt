package edu.monmouth.brandonhenry.catencyclopedia.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import edu.monmouth.s1175816.catencyclopedia.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val catImageUrl = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.petmd.com%2Fsites%2Fdefault%2Ffiles%2Fcalm-cat-while-flying.jpg&f=1&nofb=1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(catImageUrl).into(imageViewCat)
    }

}
