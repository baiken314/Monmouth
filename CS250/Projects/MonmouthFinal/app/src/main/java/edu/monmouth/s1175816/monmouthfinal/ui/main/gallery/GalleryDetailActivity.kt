package edu.monmouth.s1175816.monmouthfinal.ui.main.gallery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import edu.monmouth.s1175816.monmouthfinal.R
import kotlinx.android.synthetic.main.gallery_detail_view.*

class GalleryDetailActivity : AppCompatActivity() {

    companion object {

        lateinit var context: Context
        lateinit var photo: Photo

        fun newIntent(context: Context, photo: Photo): Intent {
            Log.d("BRADLEY", "GalleryDetailActivity.newIntent: begin")
            val detailIntent = Intent(context, GalleryDetailActivity::class.java)
            this.context = context
            this.photo = photo
            Log.d("BRADLEY", "GalleryDetailActivity.newIntent: return")
            return detailIntent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("BRADLEY", "GalleryDetailActivity.onCreate: begin")
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Gallery"
        setContentView(R.layout.gallery_detail_view)
        textViewName.text = photo.name
        textViewDescription.text = photo.description
        Glide.with(context).load(photo.url).into(imageViewPhoto)
        Log.d("BRADLEY", "GalleryDetailActivity.onCreate: return")
    }

}