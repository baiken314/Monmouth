package edu.monmouth.s1175816.monmouthfinal.ui.main.gallery

import android.content.Context
import android.util.Log
import org.json.JSONObject

class Photo {

    lateinit var name: String
    lateinit var url: String
    lateinit var description: String

    companion object {

        // parse photo information from json
        fun getPhotosFromJson(fileName: String, context: Context):
                ArrayList<Photo> {

            Log.d("BRADLEY", "Photo.getPhotosFromJson: begin")

            val photos = ArrayList<Photo>()

            try {
                val jsonString: String? = loadJson(fileName, context)
                Log.d("BRADLEY", "Photo.getPhotosFromJson: jsonString not null")
                if (jsonString != null) {
                    val json = JSONObject(jsonString)
                    val jsonPhotoArray = json.getJSONArray("photos")
                    for (i in 0 until jsonPhotoArray.length()) {
                        val jsonCurrentPhoto = jsonPhotoArray.getJSONObject(i)
                        var photo = Photo()
                        photo.name = jsonCurrentPhoto.getString("name")
                        photo.url = jsonCurrentPhoto.getString("url")
                        photo.description = jsonCurrentPhoto.getString("description")
                        photos.add(photo)
                    }
                }
            }
            catch (e: Exception) {
                Log.d("BRADLEY", "Photo.getPhotosFromJson: exception")
                e.printStackTrace()
            }

            Log.d("BRADLEY", "Photo.getPhotosFromJson: return")

            return photos

        }

        // load in json file
        private fun loadJson(fileName: String, context: Context): String? {
            Log.d("BRADLEY", "Photo.loadJson: begin")
            try {
                val inputSteam = context.assets.open(fileName)
                val size = inputSteam.available()
                val buffer = ByteArray(size)
                inputSteam.read(buffer)
                inputSteam.close()
                val charset = Charsets.UTF_8
                Log.d("BRADLEY", "Photo.loadJson: return")
                return buffer.toString(charset)
            }
            catch (e: Exception) {
                Log.d("BRADLEY", "Photo.loadJson: exception")
                e.printStackTrace()
                return null
            }
        }

    }

}