package com.google.android.gms.location;

import android.location.Location;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public final List zzb;
    public static final List zza = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new zzy();

    public LocationResult(List list) {
        this.zzb = list;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        int r0 = Build.VERSION.SDK_INT;
        List<Location> list = this.zzb;
        if (r0 >= 31) {
            return list.equals(locationResult.zzb);
        }
        if (list.size() != locationResult.zzb.size()) {
            return false;
        }
        Iterator it = locationResult.zzb.iterator();
        for (Location location : list) {
            Location location2 = (Location) it.next();
            if (Double.compare(location.getLatitude(), location2.getLatitude()) != 0 || Double.compare(location.getLongitude(), location2.getLongitude()) != 0 || location.getTime() != location2.getTime() || location.getElapsedRealtimeNanos() != location2.getElapsedRealtimeNanos() || !Objects.equal(location.getProvider(), location2.getProvider())) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb});
    }

    public final String toString() {
        return "LocationResult".concat(String.valueOf(this.zzb));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        int zza2 = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeTypedList(parcel, 1, this.zzb);
        OnTimeoutKt.zzb(parcel, zza2);
    }
}
