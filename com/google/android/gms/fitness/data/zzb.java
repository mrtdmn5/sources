package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzb extends AbstractSafeParcelable {
    public final String zzb;
    public static final zzb zza = new zzb("com.google.android.gms");
    public static final Parcelable.Creator<zzb> CREATOR = new zzc();

    public zzb(String str) {
        Preconditions.checkNotNull(str);
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzb)) {
            return false;
        }
        return this.zzb.equals(((zzb) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return String.format("Application{%s}", this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        int zza2 = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeString(parcel, 1, this.zzb);
        OnTimeoutKt.zzb(parcel, zza2);
    }
}
