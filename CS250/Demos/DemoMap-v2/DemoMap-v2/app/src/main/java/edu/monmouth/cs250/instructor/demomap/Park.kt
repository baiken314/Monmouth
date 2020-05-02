package edu.monmouth.cs250.instructor.mymaps

import android.content.Context
import org.json.JSONArray
import org.json.JSONException

class Park (val parkID: Int, val name: String, val township: String, val status: String, val lat: Double, val long: Double)

{
    companion object {
        fun getParksFromFile ( filename: String,  context: Context): MutableList<Park> {
            val parks = mutableListOf<Park>()

            try {
                // Load data
                val jsonString = loadJsonFromAsset(filename, context)
                if (jsonString != null) {
                    // val json = JSONObject(jsonString)  // decode JSON Sting to an key-value pair map
                    val gs = JSONArray(jsonString)

                    // Get Student objects from data
                    (0 until gs.length()).mapTo(parks) {
                        Park(
                            gs.getJSONObject(it).getInt("PARK_ID"),
                            gs.getJSONObject(it).getString("NAME"),
                            gs.getJSONObject(it).getString("TOWNSHIP"),
                            gs.getJSONObject(it).getString("STATUS"),
                            gs.getJSONObject(it).getDouble("LATITUDE"),
                            gs.getJSONObject(it).getDouble("LONGITUDE")
                        )
                    }
//                        for (g in gasStations) {
//                            println(" ${g.id} ${g.NAME} ")
//                        }
                } else {
                    println("not a valid JSON string")
                }


            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return parks
        }

        // open file and read all characters into a buffer. Convert buffer to String

        private fun loadJsonFromAsset(filename: String, context: Context): String? {
            var json: String?


            try {
                val inputStream = context.assets.open(filename)
                val size = inputStream.available()
                val buffer = ByteArray(size)

                inputStream.read(buffer)
                inputStream.close()
                val charset = Charsets.UTF_8

                json = buffer.toString(charset)


            } catch (ex: java.io.IOException) {
                ex.printStackTrace()
                return null
            }

            return json
        }
    }

}
