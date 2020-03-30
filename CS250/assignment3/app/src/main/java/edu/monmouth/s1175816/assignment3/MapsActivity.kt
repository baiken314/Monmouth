package edu.monmouth.s1175816.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    private lateinit var schools: MutableList<School>

    override fun onCreate(savedInstanceState: Bundle?) {

        println("APP START")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        schools = SchoolJsonReader.getSchoolsFromJson("njschools.json", this)

    }

    override fun onMapReady(googleMap: GoogleMap) {

        map = googleMap

        val mapSettings = map.uiSettings
        mapSettings.isZoomControlsEnabled = true
        mapSettings.isCompassEnabled = true

        // Add a marker in Sydney and move the camera
        val monmouthUniversity = LatLng(40.281825, -74.004858)
        map.addMarker(MarkerOptions()
            .position(monmouthUniversity)
            .title("Monmouth University")
            .snippet("Go hawks!")
            .icon(BitmapDescriptorFactory
                .fromResource(R.drawable.mu_icon_30))
            )
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(monmouthUniversity, 15f))

    }

}