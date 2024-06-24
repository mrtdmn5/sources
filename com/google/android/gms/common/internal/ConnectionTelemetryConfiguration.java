package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new zzl();
    public final RootTelemetryConfiguration zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int[] zzd;
    public final int zze;
    public final int[] zzf;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z, boolean z2, int[] r4, int r5, int[] r6) {
        this.zza = rootTelemetryConfiguration;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = r4;
        this.zze = r5;
        this.zzf = r6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeParcelable(parcel, 1, this.zza, r5);
        OnTimeoutKt.writeBoolean(parcel, 2, this.zzb);
        OnTimeoutKt.writeBoolean(parcel, 3, this.zzc);
        OnTimeoutKt.writeIntArray(parcel, 4, this.zzd);
        OnTimeoutKt.writeInt(parcel, 5, this.zze);
        OnTimeoutKt.writeIntArray(parcel, 6, this.zzf);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
