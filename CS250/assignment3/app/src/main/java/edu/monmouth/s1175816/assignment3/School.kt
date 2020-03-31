package edu.monmouth.s1175816.assignment3

import android.content.Context
import android.util.Log
import org.json.JSONObject

data class School(
    val name: String,
    val lat: Double,
    val lng: Double,
    val category: String
)

class SchoolJsonReader {

    companion object {

        fun getSchoolsFromJson(filename: String, context: Context): MutableList<School> {

            var schools = mutableListOf<School>()

            Log.d("BRADLEY", "getSchoolsFromJson()")

            try {

                val jsonString = loadJsonFromAsset(filename, context)

                if (jsonString != null) {

                    Log.d("BRADLEY", "Json is not null")

                    val json = JSONObject(jsonString)
                    val features = json.getJSONArray("features") // schools

                    for (i in 0 until features.length()) {

                        val feature = features.getJSONObject(i)

                        val properties = feature.getJSONObject("properties")

                        val name = properties.getString("SCHOOLNAME")
                        val category = properties.getString("CATEGORY")

                        val geometry = feature.getJSONObject("geometry")
                        val coordinates = geometry.getJSONArray("coordinates")

                        val lng = coordinates.getDouble(0)
                        val lat = coordinates.getDouble(1)

                        schools.add(School(name, lat, lng, category))

                    }

                    Log.d("BRADLEY", "School length is ${schools.size}")

                }

            }
            catch (e: Exception) {
                Log.d("BRADLEY", "ERROR")
                e.printStackTrace()
            }

            return schools

        }

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