package edu.monmouth.s1175816.monmouthfinal.ui.main.academics

import android.content.Context
import android.util.Log
import org.json.JSONObject

class School {

    // school information
    lateinit var name: String
    lateinit var about: String
    lateinit var departments: ArrayList<String>

    companion object {

        // parse school information from json
        fun getSchoolsFromJson(fileName: String, context: Context):
            ArrayList<School> {

            Log.d("BRADLEY", "School.getSchoolsFromJson: begin")

            val schools = ArrayList<School>()

            try {
                val jsonString: String? = loadJson(fileName, context)
                Log.d("BRADLEY", "School.getSchoolsFromJson: jsonString not null")
                if (jsonString != null) {
                    val json = JSONObject(jsonString)
                    val jsonSchoolArray = json.getJSONArray("schools")
                    for (i in 0 until jsonSchoolArray.length()) {
                        var newSchool = School()
                        val currentSchool = jsonSchoolArray.getJSONObject(i)
                        newSchool.name = currentSchool.getString("name")
                        newSchool.about = currentSchool.getString("about")
                        newSchool.departments = ArrayList()
                        val currentSchoolDepartments =
                            currentSchool.getJSONArray("departments")
                        for (j in 0 until currentSchoolDepartments.length()) {
                            newSchool.departments.add(currentSchoolDepartments.getString(j))
                        }
                        schools.add(newSchool)
                    }
                }
            }
            catch (e: Exception) {
                Log.d("BRADLEY", "School.getSchoolsFromJson: exception")
                e.printStackTrace()
            }

            Log.d("BRADLEY", "School.getSchoolsFromJson: return")

            return schools

        }

        // load in json file
        private fun loadJson(fileName: String, context: Context): String? {
            Log.d("BRADLEY", "School.loadJson: begin")
            try {
                val inputSteam = context.assets.open(fileName)
                val size = inputSteam.available()
                val buffer = ByteArray(size)
                inputSteam.read(buffer)
                inputSteam.close()
                val charset = Charsets.UTF_8
                Log.d("BRADLEY", "School.loadJson: return")
                return buffer.toString(charset)
            }
            catch (e: Exception) {
                Log.d("BRADLEY", "School.loadJson: exception")
                e.printStackTrace()
                return null
            }
        }

    }

}