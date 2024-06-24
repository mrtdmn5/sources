package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class Device extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Device> CREATOR = new zzn();
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;

    public Device(int r1, int r2, String str, String str2, String str3) {
        Preconditions.checkNotNull(str);
        this.zza = str;
        Preconditions.checkNotNull(str2);
        this.zzb = str2;
        if (str3 != null) {
            this.zzc = str3;
            this.zzd = r1;
            this.zze = r2;
            return;
        }
        throw new IllegalStateException("Device UID is null.");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        if (Objects.equal(this.zza, device.zza) && Objects.equal(this.zzb, device.zzb) && Objects.equal(this.zzc, device.zzc) && this.zzd == device.zzd && this.zze == device.zze) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, Integer.valueOf(this.zzd)});
    }

    public final String toString() {
        return String.format("Device{%s:%s:%s}", String.format("%s:%s:%s", this.zza, this.zzb, this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeString(parcel, 1, this.zza);
        OnTimeoutKt.writeString(parcel, 2, this.zzb);
        OnTimeoutKt.writeString(parcel, 4, this.zzc);
        OnTimeoutKt.writeInt(parcel, 5, this.zzd);
        OnTimeoutKt.writeInt(parcel, 6, this.zze);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
