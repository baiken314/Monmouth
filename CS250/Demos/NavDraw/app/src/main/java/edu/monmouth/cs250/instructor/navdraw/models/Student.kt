
import android.content.Context
import org.json.JSONException
import org.json.JSONObject

    class Student ( val studentName: String, val id:String, val email: String, val major: String,
                    val classLevel: Int, val advisor: String, val credits: Int, val photoURL: String)
    {
        companion object {

            fun getStudentsFromFile(filename: String, context: Context): ArrayList<Student> {
                val studentList = ArrayList<Student>()

                try {
                    // Load data
                    val jsonString = loadJsonFromAsset(filename, context)
                    if (jsonString != null) {
                        val json = JSONObject(jsonString)  // decode JSON Sting to an key-value pair map
                        val students = json.getJSONArray("cs250students")

                        // Get Student objects from data
                        (0 until students.length()).mapTo(studentList) {
                            Student(
                                students.getJSONObject(it).getString("Student Name"),
                                students.getJSONObject(it).getString("ID"),
                                students.getJSONObject(it).getString("Email"),
                                students.getJSONObject(it).getString("Major"),
                                students.getJSONObject(it).getInt("Class"),
                                students.getJSONObject(it).getString("Advisor"),
                                students.getJSONObject(it).getInt("Credits"),
                                students.getJSONObject(it).getString("photoURL")
                            )
                        }
//                        for (s in studentList) {
//                            println(" ${s.id} ${s.photoURL} ")
//                        }
                    } else {
                        println("not a valid JSON string")
                    }


                } catch (e: JSONException) {
                    e.printStackTrace()
                }

                return studentList
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