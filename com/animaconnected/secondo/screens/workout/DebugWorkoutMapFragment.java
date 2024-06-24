package com.animaconnected.secondo.screens.workout;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.cloud.amazon.AWSLambda$$ExternalSyntheticLambda2;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.workout.utils.GoogleMapsGeneratorKt;
import com.animaconnected.secondo.screens.workout.utils.LocationMapUtilsKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.zzj;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;

/* compiled from: DebugWorkoutMapFragment.kt */
/* loaded from: classes3.dex */
public final class DebugWorkoutMapFragment extends BaseFragment {
    private LatLngBounds latLngBounds;
    private LatLng latLngLocation;
    private GoogleMap map;
    private ArrayList<MarkerOptions> markerOptions;
    private final String name = "DebugWorkoutMapFragment";
    private PolylineOptions polylineOptions;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DebugWorkoutMapFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DebugWorkoutMapFragment newInstance$default(Companion companion, PolylineOptions polylineOptions, LatLng latLng, LatLngBounds latLngBounds, ArrayList arrayList, int r5, Object obj) {
            if ((r5 & 8) != 0) {
                arrayList = null;
            }
            return companion.newInstance(polylineOptions, latLng, latLngBounds, arrayList);
        }

        public final DebugWorkoutMapFragment newInstance(PolylineOptions polylineOptions, LatLng latLng, LatLngBounds latLngBounds, ArrayList<? extends MarkerOptions> arrayList) {
            Intrinsics.checkNotNullParameter(latLngBounds, "latLngBounds");
            DebugWorkoutMapFragment debugWorkoutMapFragment = new DebugWorkoutMapFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("polylineOptions", polylineOptions);
            bundle.putParcelable("locationOptions", latLng);
            bundle.putParcelable("latLanBounds", latLngBounds);
            bundle.putParcelableArrayList("markerBounds", arrayList);
            debugWorkoutMapFragment.setArguments(bundle);
            return debugWorkoutMapFragment;
        }

        private Companion() {
        }
    }

    public static final void onCreateView$lambda$4$lambda$3(DebugWorkoutMapFragment this$0, View view, GoogleMap it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.map = it;
        try {
            it.zza.setMapStyle(MapStyleOptions.loadRawResourceStyle(view.getContext()));
            GoogleMap googleMap = this$0.map;
            if (googleMap != null) {
                UiSettings uiSettings = googleMap.getUiSettings();
                uiSettings.getClass();
                try {
                    uiSettings.zza.setMyLocationButtonEnabled();
                    GoogleMap googleMap2 = this$0.map;
                    if (googleMap2 != null) {
                        try {
                            googleMap2.zza.setMyLocationEnabled(false);
                            GoogleMap googleMap3 = this$0.map;
                            if (googleMap3 != null) {
                                AWSLambda$$ExternalSyntheticLambda2 aWSLambda$$ExternalSyntheticLambda2 = new AWSLambda$$ExternalSyntheticLambda2(this$0);
                                try {
                                    googleMap3.zza.setOnMapLoadedCallback(new zzj(aWSLambda$$ExternalSyntheticLambda2));
                                    LatLngBounds latLngBounds = this$0.latLngBounds;
                                    if (latLngBounds != null) {
                                        GoogleMap googleMap4 = this$0.map;
                                        if (googleMap4 != null) {
                                            LatLng latLng = latLngBounds.southwest;
                                            double d = latLng.latitude;
                                            LatLng latLng2 = latLngBounds.northeast;
                                            double d2 = (d + latLng2.latitude) / 2.0d;
                                            double d3 = latLng.longitude;
                                            double d4 = latLng2.longitude;
                                            if (d3 > d4) {
                                                d4 += 360.0d;
                                            }
                                            LatLng latLng3 = new LatLng(d2, (d4 + d3) / 2.0d);
                                            try {
                                                ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate = MagicApiIntrinsics.zza;
                                                Preconditions.checkNotNull(iCameraUpdateFactoryDelegate, "CameraUpdateFactory is not initialized");
                                                IObjectWrapper newLatLng = iCameraUpdateFactoryDelegate.newLatLng(latLng3);
                                                Preconditions.checkNotNull(newLatLng);
                                                try {
                                                    googleMap4.zza.moveCamera(newLatLng);
                                                    return;
                                                } catch (RemoteException e) {
                                                    throw new RuntimeRemoteException(e);
                                                }
                                            } catch (RemoteException e2) {
                                                throw new RuntimeRemoteException(e2);
                                            }
                                        }
                                        Intrinsics.throwUninitializedPropertyAccessException("map");
                                        throw null;
                                    }
                                    return;
                                } catch (RemoteException e3) {
                                    throw new RuntimeRemoteException(e3);
                                }
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("map");
                            throw null;
                        } catch (RemoteException e4) {
                            throw new RuntimeRemoteException(e4);
                        }
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("map");
                    throw null;
                } catch (RemoteException e5) {
                    throw new RuntimeRemoteException(e5);
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException("map");
            throw null;
        } catch (RemoteException e6) {
            throw new RuntimeRemoteException(e6);
        }
    }

    public static final void onCreateView$lambda$4$lambda$3$lambda$1(DebugWorkoutMapFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onMapLoaded();
    }

    private final void onMapLoaded() {
        PolylineOptions polylineOptions = this.polylineOptions;
        if (polylineOptions != null) {
            GoogleMap googleMap = this.map;
            if (googleMap != null) {
                try {
                    Preconditions.checkNotNull(googleMap.zza.addPolyline(polylineOptions));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("map");
                throw null;
            }
        }
        GoogleMap googleMap2 = this.map;
        if (googleMap2 != null) {
            LocationMapUtilsKt.addLocation(googleMap2, this.latLngLocation, GoogleMapsGeneratorKt.getPathColor());
            ArrayList<MarkerOptions> arrayList = this.markerOptions;
            if (arrayList != null) {
                for (MarkerOptions markerOptions : arrayList) {
                    GoogleMap googleMap3 = this.map;
                    if (googleMap3 != null) {
                        try {
                            Preconditions.checkNotNull(markerOptions, "MarkerOptions must not be null.");
                            googleMap3.zza.addMarker(markerOptions);
                        } catch (RemoteException e2) {
                            throw new RuntimeRemoteException(e2);
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("map");
                        throw null;
                    }
                }
            }
            GoogleMap googleMap4 = this.map;
            if (googleMap4 != null) {
                LatLng latLng = this.latLngLocation;
                LatLngBounds latLngBounds = this.latLngBounds;
                Intrinsics.checkNotNull(latLngBounds);
                LocationMapUtilsKt.repositionCamera(googleMap4, true, latLng, latLngBounds, 16.0f, 48);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("map");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("map");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Parcelable parcelable;
        Parcelable parcelable2;
        Parcelable parcelable3;
        Object parcelable4;
        Object parcelable5;
        Object parcelable6;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int r0 = Build.VERSION.SDK_INT;
            Parcelable parcelable7 = null;
            if (r0 >= 33) {
                parcelable6 = arguments.getParcelable("polylineOptions", PolylineOptions.class);
                parcelable = (Parcelable) parcelable6;
            } else {
                Parcelable parcelable8 = arguments.getParcelable("polylineOptions");
                if (!(parcelable8 instanceof PolylineOptions)) {
                    parcelable8 = null;
                }
                parcelable = (PolylineOptions) parcelable8;
            }
            this.polylineOptions = (PolylineOptions) parcelable;
            if (r0 >= 33) {
                parcelable5 = arguments.getParcelable("latLanBounds", LatLngBounds.class);
                parcelable2 = (Parcelable) parcelable5;
            } else {
                Parcelable parcelable9 = arguments.getParcelable("latLanBounds");
                if (!(parcelable9 instanceof LatLngBounds)) {
                    parcelable9 = null;
                }
                parcelable2 = (LatLngBounds) parcelable9;
            }
            this.latLngBounds = (LatLngBounds) parcelable2;
            if (r0 >= 33) {
                parcelable4 = arguments.getParcelable("locationOptions", LatLng.class);
                parcelable3 = (Parcelable) parcelable4;
            } else {
                Parcelable parcelable10 = arguments.getParcelable("locationOptions");
                if (parcelable10 instanceof LatLng) {
                    parcelable7 = parcelable10;
                }
                parcelable3 = (LatLng) parcelable7;
            }
            this.latLngLocation = (LatLng) parcelable3;
            this.markerOptions = arguments.getParcelableArrayList("markerBounds");
        }
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"MissingPermission", "SetTextI18n"})
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final View inflate = inflater.inflate(R.layout.fragment_debug_workout_map, viewGroup, false);
        Fragment findFragmentById = getChildFragmentManager().findFragmentById(R.id.map);
        Intrinsics.checkNotNull(findFragmentById, "null cannot be cast to non-null type com.google.android.gms.maps.SupportMapFragment");
        ((SupportMapFragment) findFragmentById).getMapAsync(new OnMapReadyCallback() { // from class: com.animaconnected.secondo.screens.workout.DebugWorkoutMapFragment$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.maps.OnMapReadyCallback
            public final void onMapReady(GoogleMap googleMap) {
                DebugWorkoutMapFragment.onCreateView$lambda$4$lambda$3(DebugWorkoutMapFragment.this, inflate, googleMap);
            }
        });
        return inflate;
    }
}
