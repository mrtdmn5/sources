package com.google.android.gms.internal.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import java.util.Iterator;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@Deprecated
/* loaded from: classes3.dex */
public final class zzdd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdd> CREATOR = new zzde();
    public final LocationRequest zza;

    public zzdd(LocationRequest locationRequest, ArrayList arrayList, boolean z, boolean z2, String str, boolean z3, boolean z4, String str2, long j) {
        WorkSource workSource;
        LocationRequest.Builder builder = new LocationRequest.Builder(locationRequest);
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                workSource = null;
            } else {
                workSource = new WorkSource();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ClientIdentity clientIdentity = (ClientIdentity) it.next();
                    WorkSourceUtil.add(workSource, clientIdentity.uid, clientIdentity.packageName);
                }
            }
            builder.zzn = workSource;
        }
        boolean z5 = true;
        if (z) {
            builder.zzj = 1;
        }
        if (z2) {
            builder.zzk = 2;
        }
        if (str != null) {
            if (Build.VERSION.SDK_INT < 30) {
                builder.zzl = str;
            }
        } else if (str2 != null && Build.VERSION.SDK_INT < 30) {
            builder.zzl = str2;
        }
        if (z3) {
            builder.zzm = true;
        }
        if (z4) {
            builder.zzh = true;
        }
        if (j != Long.MAX_VALUE) {
            if (j != -1 && j < 0) {
                z5 = false;
            }
            Preconditions.checkArgument("maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE", z5);
            builder.zzi = j;
        }
        this.zza = builder.build();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzdd) {
            return Objects.equal(this.zza, ((zzdd) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeParcelable(parcel, 1, this.zza, r5);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
