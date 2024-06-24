package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final long zzf;
    public final zzac[] zzg;

    static {
        new LocationAvailability(0, 1, 1, 0L, null);
        new LocationAvailability(1000, 1, 1, 0L, null);
        CREATOR = new zzw();
    }

    public LocationAvailability(int r2, int r3, int r4, long j, zzac[] zzacVarArr) {
        this.zzc = r2 < 1000 ? 0 : 1000;
        this.zzd = r3;
        this.zze = r4;
        this.zzf = j;
        this.zzg = zzacVarArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.zzd == locationAvailability.zzd && this.zze == locationAvailability.zze && this.zzf == locationAvailability.zzf && this.zzc == locationAvailability.zzc && Arrays.equals(this.zzg, locationAvailability.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzc)});
    }

    public final String toString() {
        boolean z;
        if (this.zzc < 1000) {
            z = true;
        } else {
            z = false;
        }
        return "LocationAvailability[" + z + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r7) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        boolean z = true;
        OnTimeoutKt.writeInt(parcel, 1, this.zzd);
        OnTimeoutKt.writeInt(parcel, 2, this.zze);
        OnTimeoutKt.writeLong(parcel, 3, this.zzf);
        int r3 = this.zzc;
        OnTimeoutKt.writeInt(parcel, 4, r3);
        OnTimeoutKt.writeTypedArray(parcel, 5, this.zzg, r7);
        if (r3 >= 1000) {
            z = false;
        }
        OnTimeoutKt.writeBoolean(parcel, 6, z);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
