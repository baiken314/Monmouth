package edu.monmouth.s1175816.assignment3

import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.jar.Manifest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    private lateinit var schools: MutableList<School>

    private val LOCATION_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("BRADLEY", "STARTED")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        Log.d("BRADLEY", "Starting json...")

        schools = SchoolJsonReader.getSchoolsFromJson("njschools.json", this)

        Log.d("BRADLEY", "Ended json...")

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        item.isChecked = true
        when (item.itemId) {
            R.id.menupublic -> createMarkers(map, "Public");
            R.id.menucharter -> createMarkers(map, "Charter")
            R.id.menuprivate -> createMarkers(map, "Non-public")
            else -> createMarkers(map, "All")
        }
        return true
    }


    private fun requestPermission(permissionType: String, requestCode: Int) {
        ActivityCompat.requestPermissions(this, arrayOf(permissionType), requestCode)
    }

    private fun createMarkers(map: GoogleMap, category: String = "All") {

        map.clear()

        Log.d("BRADLEY", "creating $category markers")

        for (i in 0 until schools.size) {
            val school = schools[i]
            val latLng = LatLng(school.lat, school.lng)
            if (category == "All" || category == school.category) {
                map.addMarker(MarkerOptions()
                    .position(latLng)
                    .title(school.name)
                    .snippet(school.category)
                    .icon(BitmapDescriptorFactory
                        .defaultMarker(when (school.category) {
                            "Charter" -> BitmapDescriptorFactory.HUE_CYAN
                            "Public" -> BitmapDescriptorFactory.HUE_GREEN
                            "Non-public" -> BitmapDescriptorFactory.HUE_RED
                            else -> BitmapDescriptorFactory.HUE_RED
                        })
                    )
                )
            }
        }

        Log.d("BRADLEY", "$category markers created")

    }

    override fun onMapReady(googleMap: GoogleMap) {

        map = googleMap

        val mapSettings = map.uiSettings
        mapSettings.isZoomControlsEnabled = true
        mapSettings.isCompassEnabled = true
        mapSettings.isMapToolbarEnabled = true

        Log.d("BRADLEY", "getting location of user")

        val permission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
        if (permission == PackageManager.PERMISSION_GRANTED) {
            map.isMyLocationEnabled = true
            Log.d("BRADLEY", "location enabled")
        }
        else {
            requestPermission(android.Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_REQUEST_CODE)
            Log.d("BRADLEY", "location requested")
        }

        Log.d("BRADLEY", "User location enabled: ${map.isMyLocationEnabled}")

        // Add a marker in Sydney and move the camera
        val monmouthUniversity = LatLng(40.281825, -74.004858)
        map.addMarker(MarkerOptions()
            .position(monmouthUniversity)
            .title("Monmouth University")
            .snippet("Go hawks!")
            .icon(BitmapDescriptorFactory
                .fromResource(R.drawable.mu_icon_30))
            )

        Log.d("BRADLEY", "creating ${schools.size} school markers...")

        createMarkers(map, "All")

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(monmouthUniversity, 12.5f))

    }

}