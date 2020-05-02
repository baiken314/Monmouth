package edu.monmouth.s1175816.monmouthfinal.ui.main.athletics

import android.content.Context
import android.util.Log
import org.json.JSONObject

class Team {

    lateinit var name: String
    lateinit var gender: String

    companion object {

        // parse team information from json
        fun getTeamsFromJson(fileName: String, context: Context):
                ArrayList<Team> {

            Log.d("BRADLEY", "Team.getTeamsFromJson: begin")

            val teams = ArrayList<Team>()

            try {
                val jsonString: String? = loadJson(fileName, context)
                Log.d("BRADLEY", "Team.getTeamsFromJson: jsonString not null")
                if (jsonString != null) {
                    val json = JSONObject(jsonString)
                    val jsonMaleTeamArray = json.getJSONArray("male")
                    for (i in 0 until jsonMaleTeamArray.length()) {
                        var newTeam = Team()
                        newTeam.gender = "male"
                        newTeam.name = jsonMaleTeamArray.getString(i)
                        teams.add(newTeam)
                    }
                    val jsonFemaleTeamArray = json.getJSONArray("female")
                    for (i in 0 until jsonFemaleTeamArray.length()) {
                        var newTeam = Team()
                        newTeam.gender = "female"
                        newTeam.name = jsonFemaleTeamArray.getString(i)
                        teams.add(newTeam)
                    }
                }
            }
            catch (e: Exception) {
                Log.d("BRADLEY", "Team.getTeamsFromJson: exception")
                e.printStackTrace()
            }

            Log.d("BRADLEY", "Team.getTeamsFromJson: return")

            return teams

        }

        // load in json file
        private fun loadJson(fileName: String, context: Context): String? {
            Log.d("BRADLEY", "Team.loadJson: begin")
            try {
                val inputSteam = context.assets.open(fileName)
                val size = inputSteam.available()
                val buffer = ByteArray(size)
                inputSteam.read(buffer)
                inputSteam.close()
                val charset = Charsets.UTF_8
                Log.d("BRADLEY", "Team.loadJson: return")
                return buffer.toString(charset)
            }
            catch (e: Exception) {
                Log.d("BRADLEY", "Team.loadJson: exception")
                e.printStackTrace()
                return null
            }
        }

    }

}