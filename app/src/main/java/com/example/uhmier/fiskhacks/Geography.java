package com.example.uhmier.fiskhacks;
import android.location.Location;
import android.location.Geocoder;
import android.location.Address;
import java.util.List;
//import com.google.android.gms.vision.barcode.Barcode.GeoPoint;

/**
 * Created by Programmer on 3/19/16.
 */
public class Geography {

   /** public float getDistance(GeoPoint a, GeoPoint b) {
        Location loc1 = new Location("Location");
        loc1.setLatitude(a.getLatitudeE6() / 1E6);
        loc1.setLongitude(a.getLongitudeE6() / 1E6);
    }

    /**public float getDistance(Location a, Location b){



        Location loc2 = new Location("Location2");
        loc2.setLatitude(b.getLatitudeE6()/ 1E6);
        loc2.setLongitude(b.getLongitudeE6()/ 1E6);

        float distanceInmeters = loc1.distanceTo(loc2);
        return distanceInmeters;
    }

    public GeoPoint getLocationcood(String strAddress){
        Geocoder coder = new Geocoder(this);
        List<Address> address;
        GeoPoint p1 = null;
        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new GeoPoint((int) (location.getLatitude() * 1E6),
                    (int) (location.getLongitude() * 1E6));

            return p1;
        }
    }

    public GetGeolocation(String address){



    }**/

}

