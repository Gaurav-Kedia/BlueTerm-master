package es.pymasde.blueterm;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;

import java.util.List;
import java.util.Locale;

/**
 * Created by GAURAV on 06-06-2019.
 */

public class Get_location extends AppCompatActivity implements LocationListener {
    LocationManager locationManager;
    double latitude, longitude;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLocation();
    }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLocationChanged(Location location) {
        //locationText.setText("Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude());
        latitude = location.getLatitude();
        longitude = location.getLongitude();

        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            /*locationText.setText(locationText.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
                    addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));*/
        }catch(Exception ignored){}

    }

    @Override
    public void onProviderDisabled(String provider) {
       // Toast.makeText(this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }


    public void send_message_to(double latitude, double longitude) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+919078162515", null, "Help is needed, please reach this location " + "https://maps.google.com/?q=" + latitude + "," + longitude,
                null, null);

        smsManager.sendTextMessage("+919945056180", null, "Help is needed, please reach this location " + "https://maps.google.com/?q=" + latitude + "," + longitude,
                null, null);
    }
}
