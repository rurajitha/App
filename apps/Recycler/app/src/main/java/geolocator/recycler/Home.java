package geolocator.recycler;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Home extends AppCompatActivity implements LocationListener {

    DatabaseHelper databaseHelper;
    boolean isGPSEnabled = false;

    // flag for network status
    boolean isNetworkEnabled = false;

    boolean canGetLocation = false;

    Location location; // location
    double latitude; // latitude
    double longitude; // longitude

    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters

    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute

    // Declaring a Location Manager
    protected LocationManager locationManager;
    private TextView tv_youtLocation;
    private Button btn_yourLocation,btn_mulund,btn_bhandup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        databaseHelper=new DatabaseHelper(this);
        try {
            databaseHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tv_youtLocation= (TextView) findViewById(R.id.tv_youtLocation);

        getLocation();


        btn_yourLocation= (Button) findViewById(R.id.btn_yourLocation);
        btn_mulund= (Button) findViewById(R.id.btn_mulund);
        btn_bhandup= (Button) findViewById(R.id.btn_bhandup);





        btn_yourLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });

        btn_mulund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_youtLocation.setText("Your location: Mulund");
                latitude=19.172194;
                longitude=72.956492;

            }
        });

        btn_bhandup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_youtLocation.setText("Your location: Bhandup");
                latitude=19.142641;
                longitude=72.937741;
            }
        });



        LinearLayout ll_firstItem= (LinearLayout) findViewById(R.id.ll_firstItem);
        assert ll_firstItem != null;
        ll_firstItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,MapView.class);
                i.putExtra("lat",latitude);
                i.putExtra("long",longitude);
                i.putExtra("type",1);
                startActivity(i);
            }
        });

        LinearLayout ll_secondItem= (LinearLayout) findViewById(R.id.ll_secondItem);
        assert ll_secondItem != null;
        ll_secondItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,MapView.class);
                i.putExtra("lat",latitude);
                i.putExtra("long",longitude);
                i.putExtra("type",2);
                startActivity(i);
            }
        });

        LinearLayout ll_thirdItem= (LinearLayout) findViewById(R.id.ll_thirdItem);
        assert ll_thirdItem != null;
        ll_thirdItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,MapView.class);
                i.putExtra("lat",latitude);
                i.putExtra("long",longitude);
                i.putExtra("type",3);
                startActivity(i);
            }
        });

        LinearLayout ll_fourthItem= (LinearLayout) findViewById(R.id.ll_fourthItem);
        assert ll_fourthItem != null;
        ll_fourthItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,MapView.class);
                i.putExtra("lat",latitude);
                i.putExtra("long",longitude);
                i.putExtra("type",4);
                startActivity(i);
            }
        });







    }



    public void getLocation() {
        try {
            locationManager = (LocationManager) Home.this
                    .getSystemService(LOCATION_SERVICE);

            // getting GPS status
            isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);

            // getting network status
            isNetworkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) {
                // no network provider is enabled
            } else {
                this.canGetLocation = true;
                // First get location from Network Provider
                if (isNetworkEnabled) {
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
                    locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("Network", "Network");
                    if (locationManager != null) {
                        location = locationManager
                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                            Geocoder gcd = new Geocoder(this, Locale.getDefault());
                            List<Address> addresses = null;
                            try {
                                addresses = gcd.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if (addresses.size() > 0)
                                tv_youtLocation.setText("Your location: "+addresses.get(0).getLocality());

                        }
                    }
                }
                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled) {
                    if (location == null) {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (locationManager != null) {
                            location = locationManager
                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                                Geocoder gcd = new Geocoder(this, Locale.getDefault());
                                List<Address> addresses = null;
                                try {
                                    addresses = gcd.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                if (addresses.size() > 0)
                                    tv_youtLocation.setText("Your location: "+addresses.get(0).getLocality());

                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

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
