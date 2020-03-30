package edu.monmouth.s1175816.assignment3

import android.content.Context
import org.json.JSONArray

data class School(
    val name: String,
    val lat: Float,
    val lon: Float,
    val category: String
)

class SchoolJsonReader {

    companion object {

        fun getSchoolsFromJson(filename: String, context: Context): MutableList<School> {

            var schools = mutableListOf<School>()

            try {

                val jsonString = loadJsonFromAsset(filename, context)

                if (jsonString != null) {

                    val json = JSONArray(jsonString)

                    println("TEST **************************************************")
                    println("Length is ${json.length()}")

                }

            }
            catch (e: Exception) {
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