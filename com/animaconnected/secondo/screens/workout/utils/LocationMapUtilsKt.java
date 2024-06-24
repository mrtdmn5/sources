package com.animaconnected.secondo.screens.workout.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.core.graphics.ColorUtils;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.watch.display.DpUtilsKt;
import com.animaconnected.watch.fitness.Bounds;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.watch.fitness.LocationUtilsKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.Collections;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;

/* compiled from: LocationMapUtils.kt */
/* loaded from: classes3.dex */
public final class LocationMapUtilsKt {
    public static final void addLocation(GoogleMap googleMap, LatLng latLng, int r6) {
        Intrinsics.checkNotNullParameter(googleMap, "<this>");
        if (latLng == null) {
            return;
        }
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.zzb = 100.0d;
        circleOptions.zza = latLng;
        circleOptions.zze = ColorUtils.setAlphaComponent(r6, 51);
        circleOptions.zzc = 0.0f;
        googleMap.addCircle(circleOptions);
        CircleOptions circleOptions2 = new CircleOptions();
        circleOptions2.zzb = 20.0d;
        circleOptions2.zza = latLng;
        circleOptions2.zze = r6;
        circleOptions2.zzc = 0.0f;
        googleMap.addCircle(circleOptions2);
    }

    /* renamed from: calculateAdjustedPixelCoordinates-CJJAR-o */
    public static final long m1035calculateAdjustedPixelCoordinatesCJJARo(long j, LocationEntry targetLocation, LocationEntry mapCenterLocation, int r6) {
        Intrinsics.checkNotNullParameter(targetLocation, "targetLocation");
        Intrinsics.checkNotNullParameter(mapCenterLocation, "mapCenterLocation");
        Pair<Integer, Integer> pixels = toPixels(targetLocation, r6);
        int intValue = pixels.first.intValue();
        int intValue2 = pixels.second.intValue();
        Pair<Integer, Integer> pixels2 = toPixels(mapCenterLocation, r6);
        return OffsetKt.Offset((((int) (j >> 32)) * 0.5f) + (intValue - pixels2.first.intValue()), (IntSize.m593getHeightimpl(j) * 0.5f) + (intValue2 - pixels2.second.intValue()));
    }

    public static final int circleRadiusInPixels(int r4, double d, double d2) {
        return DpUtilsKt.toPxInt(DpUtilsKt.toDpInt((float) (d2 / ((Math.cos((d * 3.141592653589793d) / 180) * 156543.03392d) / Math.pow(2.0d, r4)))));
    }

    @SuppressLint({"MissingPermission"})
    public static final void configure(GoogleMap googleMap) {
        Intrinsics.checkNotNullParameter(googleMap, "<this>");
        Context context = KronabyApplication.Companion.getContext();
        boolean z = MapsInitializer.zzb;
        synchronized (MapsInitializer.class) {
            MapsInitializer.initialize(context);
        }
        try {
            googleMap.zza.setMapType();
            try {
                googleMap.zza.setMapStyle(MapStyleOptions.loadRawResourceStyle(context));
                UiSettings uiSettings = googleMap.getUiSettings();
                uiSettings.getClass();
                try {
                    uiSettings.zza.setMyLocationButtonEnabled();
                    UiSettings uiSettings2 = googleMap.getUiSettings();
                    uiSettings2.getClass();
                    try {
                        uiSettings2.zza.setMapToolbarEnabled();
                        try {
                            googleMap.zza.setMyLocationEnabled(false);
                        } catch (RemoteException e) {
                            throw new RuntimeRemoteException(e);
                        }
                    } catch (RemoteException e2) {
                        throw new RuntimeRemoteException(e2);
                    }
                } catch (RemoteException e3) {
                    throw new RuntimeRemoteException(e3);
                }
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        } catch (RemoteException e5) {
            throw new RuntimeRemoteException(e5);
        }
    }

    public static final PolylineOptions createPolyline(List<LocationEntry> list, int r5) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() <= 1) {
            return null;
        }
        final PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.zzb = 7.0f;
        polylineOptions.zzc = r5;
        CollectionsKt___CollectionsKt.windowed$default(list, 2, 0, new Function1<List<? extends LocationEntry>, PolylineOptions>() { // from class: com.animaconnected.secondo.screens.workout.utils.LocationMapUtilsKt$createPolyline$1$1
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final PolylineOptions invoke2(List<LocationEntry> list2) {
                Intrinsics.checkNotNullParameter(list2, "<name for destructuring parameter 0>");
                LocationEntry locationEntry = list2.get(0);
                LocationEntry locationEntry2 = list2.get(1);
                PolylineOptions polylineOptions2 = PolylineOptions.this;
                LatLng[] latLngArr = {new LatLng(locationEntry.getLat(), locationEntry.getLong()), new LatLng(locationEntry2.getLat(), locationEntry2.getLong())};
                polylineOptions2.getClass();
                Collections.addAll(polylineOptions2.zza, latLngArr);
                return polylineOptions2;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ PolylineOptions invoke(List<? extends LocationEntry> list2) {
                return invoke2((List<LocationEntry>) list2);
            }
        }, 6);
        polylineOptions.zzg = false;
        return polylineOptions;
    }

    public static final void disableMapInteraction(GoogleMap googleMap) {
        Intrinsics.checkNotNullParameter(googleMap, "<this>");
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.getClass();
        try {
            uiSettings.zza.setScrollGesturesEnabled(false);
            UiSettings uiSettings2 = googleMap.getUiSettings();
            uiSettings2.getClass();
            try {
                uiSettings2.zza.setZoomGesturesEnabled(false);
                UiSettings uiSettings3 = googleMap.getUiSettings();
                uiSettings3.getClass();
                try {
                    uiSettings3.zza.setRotateGesturesEnabled(false);
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static final void enableMapInteraction(GoogleMap googleMap) {
        Intrinsics.checkNotNullParameter(googleMap, "<this>");
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.getClass();
        try {
            uiSettings.zza.setScrollGesturesEnabled(true);
            UiSettings uiSettings2 = googleMap.getUiSettings();
            uiSettings2.getClass();
            try {
                uiSettings2.zza.setZoomGesturesEnabled(true);
                UiSettings uiSettings3 = googleMap.getUiSettings();
                uiSettings3.getClass();
                try {
                    uiSettings3.zza.setRotateGesturesEnabled(true);
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        } catch (RemoteException e3) {
            throw new RuntimeRemoteException(e3);
        }
    }

    public static final LatLng getPoint(List<LocationEntry> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() != 1) {
            return null;
        }
        return new LatLng(list.get(0).getLat(), list.get(0).getLong());
    }

    public static final LatLngBounds latLangBounds(List<LocationEntry> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Bounds bounds = LocationUtilsKt.getBounds(list);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(new LatLng(bounds.getNorthEastLat(), bounds.getNorthEastLong()));
        builder.include(new LatLng(bounds.getSouthWestLat(), bounds.getSouthWestLong()));
        Preconditions.checkState("no included points", !Double.isNaN(builder.zzc));
        return new LatLngBounds(new LatLng(builder.zza, builder.zzc), new LatLng(builder.zzb, builder.zzd));
    }

    public static final void moveGoogleMapLogo(MapView mapView, int r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(mapView, "<this>");
        View findViewWithTag = mapView.findViewWithTag("GoogleWatermark");
        if (findViewWithTag != null) {
            ViewGroup.LayoutParams layoutParams = findViewWithTag.getLayoutParams();
            if (layoutParams != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(20, -1);
                layoutParams2.addRule(10, -1);
                layoutParams2.addRule(21, 0);
                layoutParams2.addRule(12, 0);
                layoutParams2.setMargins(r4, r5, r6, r7);
                findViewWithTag.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
    }

    public static /* synthetic */ void moveGoogleMapLogo$default(MapView mapView, int r2, int r3, int r4, int r5, int r6, Object obj) {
        if ((r6 & 1) != 0) {
            r2 = 0;
        }
        if ((r6 & 2) != 0) {
            r3 = 0;
        }
        if ((r6 & 4) != 0) {
            r4 = 0;
        }
        if ((r6 & 8) != 0) {
            r5 = 0;
        }
        moveGoogleMapLogo(mapView, r2, r3, r4, r5);
    }

    public static final void repositionCamera(GoogleMap googleMap, boolean z, LatLng latLng, LatLngBounds bounds, float f, int r6) {
        Intrinsics.checkNotNullParameter(googleMap, "<this>");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (latLng != null) {
            if (z) {
                googleMap.animateCamera(MagicApiIntrinsics.newLatLngZoom(latLng, f));
                return;
            } else {
                googleMap.moveCamera(MagicApiIntrinsics.newLatLngZoom(latLng, f));
                return;
            }
        }
        IGoogleMapDelegate iGoogleMapDelegate = googleMap.zza;
        if (z) {
            try {
                ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate = MagicApiIntrinsics.zza;
                Preconditions.checkNotNull(iCameraUpdateFactoryDelegate, "CameraUpdateFactory is not initialized");
                IObjectWrapper newLatLngBounds = iCameraUpdateFactoryDelegate.newLatLngBounds(bounds, r6);
                Preconditions.checkNotNull(newLatLngBounds);
                try {
                    iGoogleMapDelegate.animateCamera(newLatLngBounds);
                    return;
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
        try {
            ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate2 = MagicApiIntrinsics.zza;
            Preconditions.checkNotNull(iCameraUpdateFactoryDelegate2, "CameraUpdateFactory is not initialized");
            IObjectWrapper newLatLngBounds2 = iCameraUpdateFactoryDelegate2.newLatLngBounds(bounds, r6);
            Preconditions.checkNotNull(newLatLngBounds2);
            try {
                iGoogleMapDelegate.moveCamera(newLatLngBounds2);
            } catch (RemoteException e3) {
                throw new RuntimeRemoteException(e3);
            }
        } catch (RemoteException e4) {
            throw new RuntimeRemoteException(e4);
        }
    }

    public static /* synthetic */ void repositionCamera$default(GoogleMap googleMap, boolean z, LatLng latLng, LatLngBounds latLngBounds, float f, int r11, int r12, Object obj) {
        if ((r12 & 8) != 0) {
            f = 15.0f;
        }
        float f2 = f;
        if ((r12 & 16) != 0) {
            r11 = 48;
        }
        repositionCamera(googleMap, z, latLng, latLngBounds, f2, r11);
    }

    public static final void setNewCameraPosition(GoogleMap googleMap, LatLng latLng, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(googleMap, "<this>");
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        CameraPosition cameraPosition = new CameraPosition(latLng, f, f2, f3);
        try {
            ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate = MagicApiIntrinsics.zza;
            Preconditions.checkNotNull(iCameraUpdateFactoryDelegate, "CameraUpdateFactory is not initialized");
            IObjectWrapper newCameraPosition = iCameraUpdateFactoryDelegate.newCameraPosition(cameraPosition);
            Preconditions.checkNotNull(newCameraPosition);
            try {
                googleMap.zza.moveCamera(newCameraPosition);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    private static final Pair<Integer, Integer> toPixels(LocationEntry locationEntry, int r12) {
        double d = 1 << r12;
        double d2 = ((locationEntry.getLong() + 180) / 360.0d) * 256.0d * d;
        double radians = Math.toRadians(locationEntry.getLat());
        double d3 = 1;
        return new Pair<>(Integer.valueOf((int) d2), Integer.valueOf((int) (((d3 - (Math.log((d3 / Math.cos(radians)) + Math.tan(radians)) / 3.141592653589793d)) / 2) * 256.0d * d)));
    }
}
