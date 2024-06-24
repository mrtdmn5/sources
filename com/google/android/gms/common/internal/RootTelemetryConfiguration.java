package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new zzai();
    public final int zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int zzd;
    public final int zze;

    public RootTelemetryConfiguration(int r1, int r2, int r3, boolean z, boolean z2) {
        this.zza = r1;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = r2;
        this.zze = r3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, this.zza);
        OnTimeoutKt.writeBoolean(parcel, 2, this.zzb);
        OnTimeoutKt.writeBoolean(parcel, 3, this.zzc);
        OnTimeoutKt.writeInt(parcel, 4, this.zzd);
        OnTimeoutKt.writeInt(parcel, 5, this.zze);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
