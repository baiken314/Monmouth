import java.io.File
import 

fun main() {

    var json_string = File("njschools.json").readLines().toString()

    var json = JSONArray(json_string)

}