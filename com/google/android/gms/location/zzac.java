package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@Deprecated
/* loaded from: classes3.dex */
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new zzad();
    public final int zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;

    public zzac(int r1, int r2, long j, long j2) {
        this.zza = r1;
        this.zzb = r2;
        this.zzc = j;
        this.zzd = j2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzac) {
            zzac zzacVar = (zzac) obj;
            if (this.zza == zzacVar.zza && this.zzb == zzacVar.zzb && this.zzc == zzacVar.zzc && this.zzd == zzacVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), Integer.valueOf(this.zza), Long.valueOf(this.zzd), Long.valueOf(this.zzc)});
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.zza + " Cell status: " + this.zzb + " elapsed time NS: " + this.zzd + " system time ms: " + this.zzc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, this.zza);
        OnTimeoutKt.writeInt(parcel, 2, this.zzb);
        OnTimeoutKt.writeLong(parcel, 3, this.zzc);
        OnTimeoutKt.writeLong(parcel, 4, this.zzd);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
