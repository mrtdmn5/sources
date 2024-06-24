package com.animaconnected.secondo.behaviour.rememberthisspot.location;

import android.content.Intent;
import android.net.Uri;
import com.animaconnected.watch.location.Spot;
import java.util.Locale;

/* loaded from: classes3.dex */
public class LocationIntentCreator {
    private static final String MAPS_FORMAT = "geo:0,0?q=%f,%f(%s)";

    private LocationIntentCreator() {
    }

    public static Intent createMapsIntent(Spot spot) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format(Locale.US, MAPS_FORMAT, Double.valueOf(spot.latitude), Double.valueOf(spot.longitude), spot.addressLine)));
        intent.setPackage("com.google.android.apps.maps");
        return intent;
    }
}
