package edu.monmouth.cs250.instructor.navdraw.ui.gallery

import OnPhotoClickListener
import Student
import StudentPhotoCustomViewAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.studentphoto_customview.view.*

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



import edu.monmouth.cs250.instructor.navdraw.R
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment(), OnPhotoClickListener {

    private lateinit var galleryViewModel: GalleryViewModel
    private lateinit var customAdapter: StudentPhotoCustomViewAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)

        return root
    }

    override fun onStart() {
        super.onStart()
        recyclerview_studentPhotos.layoutManager = GridLayoutManager (this.context, 3 )
        customAdapter = StudentPhotoCustomViewAdapter (this.getContext()!!, this)
        recyclerview_studentPhotos.adapter = customAdapter
    }

    override fun onPhotoitemClicked(student: Student) {
        println (student.studentName)
    }


    companion object {
        @JvmStatic
        fun newInstance (): GalleryFragment {
            return GalleryFragment()
        }
    }
}
