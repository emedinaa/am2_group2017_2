package com.isil.am2template;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private final String TAG="CONSOLE";
    private static final int ZOOM =15;

    private GoogleMap map;
    private Marker marker;
    private boolean selected=false;
    private double userLat=0;
    private double userLng=0;

    private double defaultLat= -12.046363;
    private double defaultLng= -77.042052;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMap();
        buildGoogleApiClient();
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    private void initMap() {

        try {
            if (map == null)
            {
                // above API 11
                map = ((SupportMapFragment)
                        getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

                map.getUiSettings().setAllGesturesEnabled(true);
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                map.setMyLocationEnabled(true);
                map.getUiSettings().setZoomControlsEnabled(true);
                //map.getUiSettings().setZoomControlsEnabled(false);
                //map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(defaultLat, defaultLng), ZOOM));

               setDefaultLocation();

                //events
                map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng point)
                    {
                        selected=true;
                        if (marker != null) {
                            marker.remove();
                        }

                        marker = map.addMarker(new MarkerOptions()
                                .position(point)
                                .title("Mi ubicación")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                        marker.showInfoWindow();
                        userLat=point.latitude;
                        userLng = point.longitude;
                        Toast.makeText(MainActivity.this,"Lat & Lng "+userLat+" "+userLng,Toast.LENGTH_LONG).show();
                    }
                });

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //ISIL Latitud y longitud -12.0936177,-77.052195
    private void setDefaultLocation() {

        final int isilZoom= 17;
        final double isilLat= -12.0936177;
        final double isilLng= -77.052195;
        if (marker != null) {
            marker.remove();
        }

        marker = map.addMarker(new MarkerOptions()
                .position(new LatLng(isilLat, isilLng))
                .title("Isil San Isidro")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(isilLat, isilLng), isilZoom));
        //map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(isilLat, isilLng), ZOOM));
    }

    private void userMarker(double lat, double lng)
    {
        if (marker != null) {
            marker.remove();
        }
        marker = map.addMarker(new MarkerOptions()
                .position(new LatLng(lat, lng))
                .title("Mi Ubicación")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.i(TAG, "Location services connected.");
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null)
        {
            userLat=mLastLocation.getLatitude();
            userLng=mLastLocation.getLongitude();
            userMarker(userLat, userLng);
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(userLat,userLng), ZOOM));
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Location services suspended. Please reconnect.");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }
}
