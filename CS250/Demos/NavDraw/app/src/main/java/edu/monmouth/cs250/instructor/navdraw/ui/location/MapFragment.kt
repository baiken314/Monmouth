package edu.monmouth.cs250.instructor.navdraw.ui.location


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import edu.monmouth.cs250.instructor.navdraw.R
import kotlinx.android.synthetic.main.fragment_map.*


class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var zoomLevel = 10f
    private val LOCATION_REQUEST_CODE = 101
    private val wlb = LatLng(40.2790893, -74.005459) // Monmouth U location

    companion object {
        fun newInstance() = MapFragment()
    }

    private lateinit var mapViewModel: MapViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mapViewModel =
            ViewModelProvider(this).get(MapViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_map, container, false)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this) // permission granted. We can get the map now

        return root

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in WLB and move the camera

        var muMarker = mMap.addMarker(
            MarkerOptions().position(wlb).title("Marker in MU").snippet("400 Cedar Ave"))
        muMarker.tag = 0

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(wlb, zoomLevel))

        val mapSettings = mMap.uiSettings
        mapSettings.isZoomControlsEnabled = true
        mapSettings.isCompassEnabled = true
        mapSettings.isMapToolbarEnabled  = true

    }

}
