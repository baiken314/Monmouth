package edu.monmouth.s1175816.monmouthfinal.ui.main.map

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import edu.monmouth.s1175816.monmouthfinal.R
import kotlinx.android.synthetic.main.maps_activity.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    private val LOCATION_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("BRADLEY", "MapsActivity.onCreate: begin")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.maps_activity)

        supportActionBar?.title = "Map"
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        buttonDirections.setOnClickListener { launchDirections() }
    }

    private fun requestPermission(permissionType: String, requestCode: Int) {
        ActivityCompat.requestPermissions(this, arrayOf(permissionType), requestCode)
    }

    // go to google maps
    fun launchDirections() {
        Log.d("BRADLEY", "MapsActivity.launchDirections: begin")
        val gmapQuery = "google.navigation:q=" + 40.281825.toString() + "," + (-74.004858).toString()
        println (gmapQuery)
        val gmmIntentUri = Uri.parse(gmapQuery)
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    override fun onMapReady(googleMap: GoogleMap) {

        Log.d("BRADLEY", "MapsActivity.onMapReady: begin")

        map = googleMap

        val mapSettings = map.uiSettings
        mapSettings.isZoomControlsEnabled = true
        mapSettings.isCompassEnabled = true
        mapSettings.isMapToolbarEnabled = true

        Log.d("BRADLEY", "MapsActivity: getting location of user")

        val permission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
        if (permission == PackageManager.PERMISSION_GRANTED) {
            map.isMyLocationEnabled = true
            Log.d("BRADLEY", "MapsActivity: location enabled")
        }
        else {
            requestPermission(android.Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_REQUEST_CODE)
            Log.d("BRADLEY", "MapsActivitiy: location requested")
        }

        Log.d("BRADLEY", "MapsActivity: User location enabled: ${map.isMyLocationEnabled}")

        // add marker in monmouth and move camera
        val monmouthUniversity = LatLng(40.281825, -74.004858)
        map.addMarker(MarkerOptions()
            .position(monmouthUniversity)
            .title("Monmouth University")
            .snippet("Go hawks!")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.mu_icon_30)))

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(monmouthUniversity, 12.5f))

    }

}