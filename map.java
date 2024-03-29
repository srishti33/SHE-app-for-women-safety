package com.example.shiva.she;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng DVC1 = new LatLng(16.524837, 80.473236);
        mMap.addMarker(new MarkerOptions().position(DVC1).title(" DVC(Thullur)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DVC1,15));

        LatLng DVC2= new LatLng(16.569625, 80.359771);
        mMap.addMarker(new MarkerOptions().position(DVC2).title(" DVC(Amaravathi)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DVC2,15));


        LatLng DVC3= new LatLng(16.510983, 80.635191);
        mMap.addMarker(new MarkerOptions().position(DVC3).title(" DVC(Vijaywada)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DVC3,15));

        LatLng DVC4= new LatLng(16.501106, 80.640202);
        mMap.addMarker(new MarkerOptions().position(DVC4).title("DVC(Labipet)"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DVC4,15));


        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //  ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                       int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }
}
