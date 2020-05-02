package edu.monmouth.brandonhenry.catencyclopedia.breeds

import android.content.Context
import org.json.JSONObject

class Breed {

    lateinit var name: String
    lateinit var origin: String
    lateinit var indoor: String
    lateinit var description: String

    companion object {

        // parse team information from json
        fun getBreedsFromJson(fileName: String, context: Context):
                ArrayList<Breed> {

            val breeds = ArrayList<Breed>()

            try {
                val jsonString: String? = loadJson(fileName, context)
                if (jsonString != null) {
                    val json = JSONObject(jsonString)
                    val jsonBreedArray = json.getJSONArray("breeds")
                    for (i in 0 until jsonBreedArray.length()) {
                        val jsonCurrentBreed = jsonBreedArray.getJSONObject(i)
                        var breed = Breed()
                        breed.name = jsonCurrentBreed.getString("name")
                        breed.origin = jsonCurrentBreed.getString("origin")
                        breed.indoor = when (jsonCurrentBreed.getInt("indoor")) {
                            0 -> "Outdoor"
                            1 -> "Indoor"
                            else -> "Outdoor"
                        }
                        breed.description = jsonCurrentBreed.getString("description")
                        breeds.add(breed)
                    }
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
            }

            return breeds

        }

        // load in json file
        private fun loadJson(fileName: String, context: Context): String? {
            try {
                val inputSteam = context.assets.open(fileName)
                val size = inputSteam.available()
                val buffer = ByteArray(size)
                inputSteam.read(buffer)
                inputSteam.close()
                val charset = Charsets.UTF_8
                return buffer.toString(charset)
            }
            catch (e: Exception) {
                e.printStackTrace()
                return null
            }
        }

    }

}