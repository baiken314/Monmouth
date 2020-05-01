package edu.monmouth.s1175816.studentlist

import android.content.Context
import org.json.JSONObject
import java.lang.Exception

class Student {

    // student information
    var name = ""
    var classTitle = ""
    var advisor = ""
    var email = ""
    var imageUrl = ""

    companion object {

        // parse information from json file
        fun getStudentsFromJson(fileName: String, context: Context): ArrayList<Student> {

            val studentList = ArrayList<Student>() // store created students

            try {
                val jsonString: String? = loadJson(fileName, context)
                if (jsonString != null) {
                    val json = JSONObject(jsonString)
                    val jsonStudentArray = json.getJSONArray("cs250students")
                    for (i in 0 until jsonStudentArray.length()) {
                        var newStudent = Student()
                        val currentJson = jsonStudentArray.getJSONObject(i)
                        newStudent.name = currentJson.getString("Student Name")
                        newStudent.advisor = currentJson.getString("Advisor")
                        newStudent.email = currentJson.getString("Email")
                        newStudent.imageUrl = currentJson.getString("photoURL")
                        newStudent.classTitle = when(currentJson.getInt("Class")) {
                            4 -> "Senior"
                            3 -> "Junior"
                            2 -> "Sophomore"
                            else -> "Freshman"
                        }
                        studentList.add(newStudent)
                    }
                }
            }
            catch(e: Exception) { e.printStackTrace() }

            return studentList

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
            catch(e: Exception) { e.printStackTrace(); return null }
        }

    }

}