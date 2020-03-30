package edu.monmouth.cs250.instructor.demomap

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import edu.monmouth.cs250.instructor.mymaps.Park

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private lateinit var mMap: GoogleMap

    // WLB location

    private val muCampus = LatLng(40.2790893, -74.005459)

    private val LOCATION_REQUEST_CODE = 101  //code for location permission request response

    private var njParks = mutableListOf<Park>()   // variable to hold park data
    private var locationAccess = false
    private var zoomLevel = 10.0f



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        val mapFragment = supportFragmentManager
//                .findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this)

        // GET PERMISSION from manifest. If not granted, go thru requesting permission.
        val permission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        if (permission == PackageManager.PERMISSION_GRANTED) {
            locationAccess = true
            showMapFragment()
        }
        else {
            requestPermission( Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_REQUEST_CODE)
        }

        njParks = Park.getParksFromFile ("njparks.json", this)

    }

    // do menu presentation and selection methods

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menustandard -> mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
            R.id.menusatellite -> mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
            R.id.menuzoom10, R.id.menuzoom15 -> {
                when (item.itemId) {
                    R.id.menuzoom10 -> zoomLevel = 10.0f
                    R.id.menuzoom15 -> zoomLevel = 15.0f
                    else -> zoomLevel = 10.0f
                }
                item.isChecked = true
                mMap.animateCamera(CameraUpdateFactory.zoomTo(zoomLevel))
            }
          else -> println ("nothing else")
        }

        return true
    }
    // present the map

    private fun showMapFragment() {
        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this) // permission granted. We can get the map now
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.setOnInfoWindowClickListener (this)
        val mapSettings = mMap.uiSettings
        mapSettings.isZoomControlsEnabled  = true
        mapSettings.isMapToolbarEnabled = true
        mapSettings.isCompassEnabled = true

        if (locationAccess) { mMap.isMyLocationEnabled = true}

        // Add a marker in WLB and move the camera

        var muMarker = mMap.addMarker(MarkerOptions().position(muCampus).title("Marker in Monmouth U").snippet("Go Hawks!!").icon(BitmapDescriptorFactory.fromResource(R.drawable.mu_icon_30)))
        muMarker.tag = 0
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(muCampus, zoomLevel))

        showParks(mMap)

    }

    // request permission

    private fun requestPermission(permissionType: String, requestCode: Int) {
        ActivityCompat.requestPermissions(this,
            arrayOf(permissionType), requestCode )
    }

    // permission response

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {

        when (requestCode) {
            LOCATION_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(
                        this,
                        "Unable to show location - permission required",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    locationAccess = true
                    showMapFragment()
                }
            }
        }
    }

    // show parks


    private fun showParks (mMap: GoogleMap) {
        for (park in njParks) {

            val parkLatLng = LatLng(park.lat, park.long)

            var parkMarker = mMap.addMarker(MarkerOptions().position(parkLatLng).title(park.name).snippet(park.township)
                .icon(BitmapDescriptorFactory
                    .defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
            parkMarker.tag = park.parkID
        }

    }


    // Deal with Info Window (Annotation) selection

    override fun onInfoWindowClick(p0: Marker?) {
        val tag = p0?.tag

        if (tag == 0) {
            showMUlogo()

        } else {
            val loc = p0?.position
            val lat = loc?.latitude
            val lng = loc?.longitude
            val gmapQuery = "google.navigation:q=" + lat.toString() + "," + lng.toString()
            println (gmapQuery)
            val gmmIntentUri = Uri.parse(gmapQuery)
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)

        }

    }

    fun showMUlogo () {
        val fm = supportFragmentManager
        val popup = PopupAlert()
        popup.show(fm, "logo popup")
    }
}
