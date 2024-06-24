package com.animaconnected.secondo.provider.location;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import androidx.concurrent.futures.AbstractResolvableFuture$$ExternalSyntheticOutline0;
import androidx.core.content.ContextCompat;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.watch.location.ErrorMissingPermission;
import com.animaconnected.watch.location.ErrorServiceDisabled;
import com.animaconnected.watch.location.LocationBackend;
import com.animaconnected.watch.location.LocationResult;
import com.animaconnected.watch.location.Spot;
import com.google.android.gms.internal.location.zzbp;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import no.nordicsemi.android.dfu.DfuServiceInitiator;

/* compiled from: AndroidLocationBackend.kt */
/* loaded from: classes3.dex */
public final class AndroidLocationBackend implements LocationBackend {
    public static final int $stable;
    public static final AndroidLocationBackend INSTANCE = new AndroidLocationBackend();
    private static final String TAG = "AndroidLocationBackend";
    private static final Context appContext;

    @SuppressLint({"StaticFieldLeak"})
    private static final FusedLocationProviderClient fusedLocationClient;
    private static LocationCallback locationCallback;
    private static final LocationManager locationManager;
    private static BroadcastReceiver serviceChangeCallback;

    /* compiled from: AndroidLocationBackend.kt */
    /* loaded from: classes3.dex */
    public static final class LocationCriteria extends Enum<LocationCriteria> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LocationCriteria[] $VALUES;
        private final float accuracyInMeter;
        private final long fetchTimeMs;
        private final long validTimeMin;
        public static final LocationCriteria LowAccuracy = new LocationCriteria("LowAccuracy", 0, 1440, 10000.0f, 40000);
        public static final LocationCriteria HighAccuracy = new LocationCriteria("HighAccuracy", 1, 1, 40.0f, 15000);

        private static final /* synthetic */ LocationCriteria[] $values() {
            return new LocationCriteria[]{LowAccuracy, HighAccuracy};
        }

        static {
            LocationCriteria[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private LocationCriteria(String str, int r2, long j, float f, long j2) {
            super(str, r2);
            this.validTimeMin = j;
            this.accuracyInMeter = f;
            this.fetchTimeMs = j2;
        }

        public static EnumEntries<LocationCriteria> getEntries() {
            return $ENTRIES;
        }

        public static LocationCriteria valueOf(String str) {
            return (LocationCriteria) Enum.valueOf(LocationCriteria.class, str);
        }

        public static LocationCriteria[] values() {
            return (LocationCriteria[]) $VALUES.clone();
        }

        public final float getAccuracyInMeter() {
            return this.accuracyInMeter;
        }

        public final long getFetchTimeMs() {
            return this.fetchTimeMs;
        }

        public final long getValidTimeMin() {
            return this.validTimeMin;
        }
    }

    /* compiled from: AndroidLocationBackend.kt */
    /* loaded from: classes3.dex */
    public static final class RestAddress {
        public static final int $stable = 0;

        @SerializedName("formatted_address")
        private final String formatted;

        public RestAddress(String str) {
            this.formatted = str;
        }

        public static /* synthetic */ RestAddress copy$default(RestAddress restAddress, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = restAddress.formatted;
            }
            return restAddress.copy(str);
        }

        public final String component1() {
            return this.formatted;
        }

        public final RestAddress copy(String str) {
            return new RestAddress(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof RestAddress) && Intrinsics.areEqual(this.formatted, ((RestAddress) obj).formatted)) {
                return true;
            }
            return false;
        }

        public final String getFormatted() {
            return this.formatted;
        }

        public int hashCode() {
            String str = this.formatted;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("RestAddress(formatted="), this.formatted, ')');
        }
    }

    /* compiled from: AndroidLocationBackend.kt */
    /* loaded from: classes3.dex */
    public static final class RestResult {
        public static final int $stable = 8;

        @SerializedName("results")
        private final List<RestAddress> addresses;

        public RestResult(List<RestAddress> list) {
            this.addresses = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RestResult copy$default(RestResult restResult, List list, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                list = restResult.addresses;
            }
            return restResult.copy(list);
        }

        public final List<RestAddress> component1() {
            return this.addresses;
        }

        public final RestResult copy(List<RestAddress> list) {
            return new RestResult(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof RestResult) && Intrinsics.areEqual(this.addresses, ((RestResult) obj).addresses)) {
                return true;
            }
            return false;
        }

        public final List<RestAddress> getAddresses() {
            return this.addresses;
        }

        public int hashCode() {
            List<RestAddress> list = this.addresses;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return LocaleList$$ExternalSyntheticOutline0.m(new StringBuilder("RestResult(addresses="), this.addresses, ')');
        }
    }

    static {
        Context context = KronabyApplication.Companion.getContext();
        appContext = context;
        int r1 = LocationServices.$r8$clinit;
        fusedLocationClient = new zzbp(context);
        Object systemService = context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        locationManager = (LocationManager) systemService;
        $stable = 8;
    }

    private AndroidLocationBackend() {
    }

    public static final void fetchLocation(LocationCriteria locationCriteria, Function1<? super LocationResult, Unit> listener) {
        Intrinsics.checkNotNullParameter(locationCriteria, "locationCriteria");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!isLocationEnabled()) {
            listener.invoke(ErrorServiceDisabled.INSTANCE);
        } else if (!hasForegroundLocationPermission()) {
            listener.invoke(ErrorMissingPermission.INSTANCE);
        } else {
            INSTANCE.getBestLocationAsync(listener, locationCriteria);
        }
    }

    private final String getAddressLine(List<? extends Address> list) {
        String str;
        Address address = (Address) CollectionsKt___CollectionsKt.firstOrNull((List) list);
        String str2 = null;
        if (address != null) {
            str = address.getAddressLine(0);
        } else {
            str = null;
        }
        Address address2 = (Address) CollectionsKt___CollectionsKt.firstOrNull((List) list);
        if (address2 != null) {
            str2 = address2.getLocality();
        }
        if (str != null && str2 != null) {
            return AbstractResolvableFuture$$ExternalSyntheticOutline0.m(str, ", ", str2);
        }
        if (str == null) {
            if (str2 == null) {
                return "No address available";
            }
            return str2;
        }
        return str;
    }

    private final String getAndroidGeoCodedAddress(Spot spot, Context context) {
        try {
            List<Address> fromLocation = new Geocoder(context, ProviderFactory.createConfigProvider().getUserLocale()).getFromLocation(spot.latitude, spot.longitude, 1);
            if (fromLocation == null) {
                return null;
            }
            return getAddressLine(CollectionsKt___CollectionsKt.filterNotNull(fromLocation));
        } catch (IOException e) {
            Log.e(TAG, "Failed to fetch address using Android GeoCoder.", e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0103 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getBestLocation(com.google.android.gms.location.FusedLocationProviderClient r20, com.google.android.gms.location.LocationRequest r21, android.os.Looper r22, com.animaconnected.secondo.provider.location.AndroidLocationBackend.LocationCriteria r23, kotlin.coroutines.Continuation<? super android.location.Location> r24) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.location.AndroidLocationBackend.getBestLocation(com.google.android.gms.location.FusedLocationProviderClient, com.google.android.gms.location.LocationRequest, android.os.Looper, com.animaconnected.secondo.provider.location.AndroidLocationBackend$LocationCriteria, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @SuppressLint({"MissingPermission"})
    private final Job getBestLocationAsync(Function1<? super LocationResult, Unit> function1, LocationCriteria locationCriteria) {
        CoroutineScope scope = KronabyApplication.Companion.getScope();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return BuildersKt.launch$default(scope, MainDispatcherLoader.dispatcher, null, new AndroidLocationBackend$getBestLocationAsync$1(locationCriteria, function1, null), 2);
    }

    public final <Location> Object getSuspendingOrNull(Task<Location> task, Continuation<? super Location> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        final Function1<Location, Unit> function1 = new Function1<Location, Unit>() { // from class: com.animaconnected.secondo.provider.location.AndroidLocationBackend$getSuspendingOrNull$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((AndroidLocationBackend$getSuspendingOrNull$2$1<Location>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Location location) {
                if (cancellableContinuationImpl.isActive()) {
                    cancellableContinuationImpl.resumeWith(location);
                }
            }
        };
        task.addOnSuccessListener(new OnSuccessListener(function1) { // from class: com.animaconnected.secondo.provider.location.AndroidLocationBackend$sam$com_google_android_gms_tasks_OnSuccessListener$0
            private final /* synthetic */ Function1 function;

            {
                Intrinsics.checkNotNullParameter(function1, "function");
                this.function = function1;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final /* synthetic */ void onSuccess(Object obj) {
                this.function.invoke(obj);
            }
        });
        task.addOnFailureListener(new OnFailureListener() { // from class: com.animaconnected.secondo.provider.location.AndroidLocationBackend$getSuspendingOrNull$2$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (cancellableContinuationImpl.isActive()) {
                    cancellableContinuationImpl.resumeWith(null);
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }

    private final boolean hasBackgroundLocationPermission() {
        if (Build.VERSION.SDK_INT < 29 || ContextCompat.checkSelfPermission(appContext, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    public static final boolean hasForegroundLocationPermission() {
        Context context = appContext;
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return false;
        }
        return true;
    }

    public static final boolean isLocationEnabled() {
        boolean z = true;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                z = locationManager.isLocationEnabled();
            } else if (Settings.Secure.getInt(appContext.getContentResolver(), "location_mode") == 0) {
                z = false;
            }
        } catch (Settings.SettingNotFoundException unused) {
            Log.w(TAG, "Failed to get location settings. Assuming that it's on.");
        }
        return z;
    }

    public final boolean isRecent(Location location, long j) {
        if (System.currentTimeMillis() - location.getTime() < TimeUnit.MINUTES.toMillis(j)) {
            return true;
        }
        return false;
    }

    public final Spot toSpot(Location location) {
        Float f;
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        long time = location.getTime();
        String str = location.getLatitude() + ", " + location.getLongitude();
        float accuracy = location.getAccuracy();
        if (location.hasSpeed()) {
            f = Float.valueOf(location.getSpeed());
        } else {
            f = null;
        }
        return new Spot(time, latitude, longitude, str, accuracy, (String) null, 0.0d, f, 96, (DefaultConstructorMarker) null);
    }

    public final String getCityName(LocationEntry locationEntry) {
        Intrinsics.checkNotNullParameter(locationEntry, "<this>");
        return getCityName(new Spot(locationEntry.getTimestamp(), locationEntry.getLat(), locationEntry.getLong(), "", locationEntry.getAccuracy(), "", 0.0d, (Float) null, 192, (DefaultConstructorMarker) null));
    }

    @Override // com.animaconnected.watch.location.LocationBackend
    public Object getGeoCodedAddress(Spot spot, Continuation<? super String> continuation) {
        return getAndroidGeoCodedAddress(spot, KronabyApplication.Companion.getContext());
    }

    @Override // com.animaconnected.watch.location.LocationBackend
    public boolean getHasLocationPermission() {
        if (isLocationEnabled() && hasForegroundLocationPermission() && hasBackgroundLocationPermission()) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.location.LocationBackend
    @SuppressLint({"MissingPermission"})
    public void startLocationUpdates(final Function1<? super LocationResult, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.location.AndroidLocationBackend$startLocationUpdates$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "startLocationUpdates";
            }
        }, 6, (Object) null);
        if (locationCallback != null || serviceChangeCallback != null) {
            LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.location.AndroidLocationBackend$startLocationUpdates$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Locations were already being fetched. Stop previous location fetching";
                }
            }, 6, (Object) null);
            stopUpdates();
        }
        if (!hasForegroundLocationPermission()) {
            listener.invoke(ErrorMissingPermission.INSTANCE);
            return;
        }
        if (!isLocationEnabled()) {
            listener.invoke(ErrorServiceDisabled.INSTANCE);
            return;
        }
        LocationRequest.Builder builder = new LocationRequest.Builder(DfuServiceInitiator.DEFAULT_SCAN_TIMEOUT);
        builder.setPriority(100);
        LocationRequest build = builder.build();
        LocationCallback locationCallback2 = new LocationCallback() { // from class: com.animaconnected.secondo.provider.location.AndroidLocationBackend$startLocationUpdates$callback$1
            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationResult(com.google.android.gms.location.LocationResult locationResult) {
                String str;
                Spot spot;
                Intrinsics.checkNotNullParameter(locationResult, "locationResult");
                str = AndroidLocationBackend.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                LogKt.debug$default((Object) this, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.location.AndroidLocationBackend$startLocationUpdates$callback$1$onLocationResult$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Location received";
                    }
                }, 6, (Object) null);
                List list = locationResult.zzb;
                Intrinsics.checkNotNullExpressionValue(list, "getLocations(...)");
                Location location = (Location) CollectionsKt___CollectionsKt.lastOrNull(list);
                if (location == null) {
                    return;
                }
                Function1<LocationResult, Unit> function1 = listener;
                spot = AndroidLocationBackend.INSTANCE.toSpot(location);
                function1.invoke(spot);
            }
        };
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.animaconnected.secondo.provider.location.AndroidLocationBackend$startLocationUpdates$serviceCallback$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (!AndroidLocationBackend.isLocationEnabled()) {
                    listener.invoke(ErrorServiceDisabled.INSTANCE);
                }
            }
        };
        locationCallback = locationCallback2;
        serviceChangeCallback = broadcastReceiver;
        LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.location.AndroidLocationBackend$startLocationUpdates$3
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "requesting updates";
            }
        }, 6, (Object) null);
        fusedLocationClient.requestLocationUpdates(build, locationCallback2, Looper.getMainLooper());
        appContext.registerReceiver(broadcastReceiver, new IntentFilter("android.location.PROVIDERS_CHANGED"));
    }

    @Override // com.animaconnected.watch.location.LocationBackend
    public void stopUpdates() {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.location.AndroidLocationBackend$stopUpdates$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "stopLocationUpdates";
            }
        }, 6, (Object) null);
        LocationCallback locationCallback2 = locationCallback;
        if (locationCallback2 != null) {
            fusedLocationClient.removeLocationUpdates(locationCallback2);
            locationCallback = null;
        }
        BroadcastReceiver broadcastReceiver = serviceChangeCallback;
        if (broadcastReceiver != null) {
            appContext.unregisterReceiver(broadcastReceiver);
            serviceChangeCallback = null;
        }
    }

    public final String getCityName(Spot spot) {
        Intrinsics.checkNotNullParameter(spot, "spot");
        try {
            List<Address> fromLocation = new Geocoder(KronabyApplication.Companion.getContext()).getFromLocation(spot.latitude, spot.longitude, 1);
            if (fromLocation != null) {
                String addressLine = ((Address) CollectionsKt___CollectionsKt.first((List) CollectionsKt___CollectionsKt.filterNotNull(fromLocation))).getAddressLine(0);
                Intrinsics.checkNotNull(addressLine);
                StringBuilder sb = new StringBuilder();
                CharSequence charSequence = (CharSequence) StringsKt__StringsKt.split$default(addressLine, new String[]{","}, 0, 6).get(1);
                for (int r0 = 0; r0 < charSequence.length(); r0++) {
                    char charAt = charSequence.charAt(r0);
                    if (Character.isLetter(charAt)) {
                        sb.append(charAt);
                    }
                }
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static /* synthetic */ void isLocationEnabled$annotations() {
    }
}
