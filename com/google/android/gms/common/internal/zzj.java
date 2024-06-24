package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();
    public final Bundle zza;
    public final Feature[] zzb;
    public final int zzc;
    public final ConnectionTelemetryConfiguration zzd;

    public zzj(Bundle bundle, Feature[] featureArr, int r3, ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.zza = bundle;
        this.zzb = featureArr;
        this.zzc = r3;
        this.zzd = connectionTelemetryConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeBundle(parcel, 1, this.zza);
        OnTimeoutKt.writeTypedArray(parcel, 2, this.zzb, r5);
        OnTimeoutKt.writeInt(parcel, 3, this.zzc);
        OnTimeoutKt.writeParcelable(parcel, 4, this.zzd, r5);
        OnTimeoutKt.zzb(parcel, zza);
    }

    public zzj() {
    }
}
