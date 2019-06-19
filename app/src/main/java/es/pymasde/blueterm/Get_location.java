package es.pymasde.blueterm;

import android.annotation.SuppressLint;
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

import java.util.ArrayList;
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
    }

    public void getLocation() {
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


    public void send_message_to(double latitude, double longitude, ArrayList<String> lists, String msg) {
        // lists.add("+919078162515");
        /*lists.add("+917038350781");
        lists.add("+917204789088");
        lists.add("+919999291265");
        lists.add("+919535349545");
        lists.add("+919945056180");*/

        msg = msg + "   Help is needed, please reach this location " + "https://maps.google.com/?q=" + latitude + "," + longitude;
        System.out.println("numbers are");
        System.out.println(lists);
        System.out.println(msg);
        SmsManager sms = SmsManager.getDefault();

        if (lists != null) {
            switch (lists.size()) {
                case 1:
                    if (lists.get(0) != null) {
                        sms.sendTextMessage(lists.get(0), null, msg, null, null);
                    }
                    break;

                case 2:
                    if (lists.get(0) != null) {
                        sms.sendTextMessage(lists.get(0), null, msg, null, null);
                    }
                    if (lists.get(1) != null) {
                        sms.sendTextMessage(lists.get(1), null, msg, null, null);
                    }
                    break;

                case 3:
                    if (lists.get(0) != null) {
                        sms.sendTextMessage(lists.get(0), null, msg, null, null);
                    }
                    if (lists.get(1) != null) {
                        sms.sendTextMessage(lists.get(1), null, msg, null, null);
                    }
                    if (lists.get(2) != null) {
                        sms.sendTextMessage(lists.get(2), null, msg,
                                null, null);
                    }
                    break;
                case 4:
                    if (lists.get(0) != null) {
                        sms.sendTextMessage(lists.get(0), null, msg, null, null);
                    }
                    if (lists.get(1) != null) {
                        sms.sendTextMessage(lists.get(1), null, msg, null, null);
                    }
                    if (lists.get(2) != null) {
                        sms.sendTextMessage(lists.get(2), null, msg, null, null);
                    }
                    if (lists.get(3) != null) {
                        sms.sendTextMessage(lists.get(3), null, msg, null, null);
                    }
                    break;

                case 5:
                    if (lists.get(0) != null) {
                        sms.sendTextMessage(lists.get(0), null, msg, null, null);
                    }
                    if (lists.get(1) != null) {
                        sms.sendTextMessage(lists.get(1), null, msg, null, null);
                    }
                    if (lists.get(2) != null) {
                        sms.sendTextMessage(lists.get(2), null, msg, null, null);
                    }
                    if (lists.get(3) != null) {
                        sms.sendTextMessage(lists.get(3), null, msg, null, null);
                    }
                    if (lists.get(4) != null) {
                        sms.sendTextMessage(lists.get(4), null, msg, null, null);
                    }
                    break;
            }
        }
    }
}
