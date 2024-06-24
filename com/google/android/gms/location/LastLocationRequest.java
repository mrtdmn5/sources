package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zzd;
import com.google.android.gms.internal.location.zzdj;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.util.Arrays;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class LastLocationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LastLocationRequest> CREATOR = new zzv();
    public final long zza;
    public final int zzb;
    public final boolean zzc;
    public final String zzd;
    public final zzd zze;

    public LastLocationRequest(long j, int r3, boolean z, String str, zzd zzdVar) {
        this.zza = j;
        this.zzb = r3;
        this.zzc = z;
        this.zzd = str;
        this.zze = zzdVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LastLocationRequest)) {
            return false;
        }
        LastLocationRequest lastLocationRequest = (LastLocationRequest) obj;
        if (this.zza != lastLocationRequest.zza || this.zzb != lastLocationRequest.zzb || this.zzc != lastLocationRequest.zzc || !Objects.equal(this.zzd, lastLocationRequest.zzd) || !Objects.equal(this.zze, lastLocationRequest.zze)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), Integer.valueOf(this.zzb), Boolean.valueOf(this.zzc)});
    }

    public final String toString() {
        String str;
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m("LastLocationRequest[");
        long j = this.zza;
        if (j != Long.MAX_VALUE) {
            m.append("maxAge=");
            zzdj.zzb(j, m);
        }
        int r1 = this.zzb;
        if (r1 != 0) {
            m.append(", ");
            if (r1 != 0) {
                if (r1 != 1) {
                    if (r1 == 2) {
                        str = "GRANULARITY_FINE";
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    str = "GRANULARITY_COARSE";
                }
            } else {
                str = "GRANULARITY_PERMISSION_LEVEL";
            }
            m.append(str);
        }
        if (this.zzc) {
            m.append(", bypass");
        }
        String str2 = this.zzd;
        if (str2 != null) {
            m.append(", moduleId=");
            m.append(str2);
        }
        zzd zzdVar = this.zze;
        if (zzdVar != null) {
            m.append(", impersonation=");
            m.append(zzdVar);
        }
        m.append(']');
        return m.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r6) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeLong(parcel, 1, this.zza);
        OnTimeoutKt.writeInt(parcel, 2, this.zzb);
        OnTimeoutKt.writeBoolean(parcel, 3, this.zzc);
        OnTimeoutKt.writeString(parcel, 4, this.zzd);
        OnTimeoutKt.writeParcelable(parcel, 5, this.zze, r6);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
