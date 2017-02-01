package geolocator.recycler;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapView extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    DatabaseHelper databaseHelper;
    Double userLat , userlong;
    int type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Intent i = getIntent();
        Bundle b = i.getExtras();
        userLat=b.getDouble("lat");
        userlong=b.getDouble("long");
        type=b.getInt("type");



        databaseHelper = new DatabaseHelper(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(new LatLng(userLat,userlong));
        circleOptions.radius(3000);
        circleOptions.clickable(true);
        circleOptions.fillColor(Color.TRANSPARENT);
        circleOptions.strokeWidth(5);
        circleOptions.strokeColor(Color.parseColor("#2196F3"));
        googleMap.addCircle(circleOptions);

        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setCompassEnabled(true);
        uiSettings.setMapToolbarEnabled(true);
        uiSettings.setZoomControlsEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        googleMap.setMyLocationEnabled(true);

        LatLngBounds INDIA = new LatLngBounds(
                new LatLng(userLat, userlong), new LatLng(userLat, userlong));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(INDIA.getCenter(), 10));


        String query = "SELECT * from locations where type=?";
        Cursor cursor = databaseHelper.getReadableDatabase().rawQuery(query, new String[]{String.valueOf(type)});
        if (cursor.moveToFirst()) {
            do {


                Double latitude = cursor.getDouble(cursor.getColumnIndex("latitude"));
                Double longitude = cursor.getDouble(cursor.getColumnIndex("longitude"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String details = cursor.getString(cursor.getColumnIndex("details"));
                String cost = cursor.getString(cursor.getColumnIndex("cost"));


                Location location1=new Location("locationA");
                location1.setLatitude(userLat);
                location1.setLongitude(userlong);

                Location location2=new Location("locationA");
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);

                double distance=location1.distanceTo(location2);
                Log.d("distance",distance+"");

                if (distance<3000){

                    googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(latitude, longitude))
                            .title(name))

                            .setSnippet(details + "\nPer kg cost: " + cost);

                }






            } while (cursor.moveToNext());
        }
        cursor.close();
        databaseHelper.close();


        googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                LinearLayout info = new LinearLayout(MapView.this);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(MapView.this);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(MapView.this);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }
        });


    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
