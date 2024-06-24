package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzdb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdb> CREATOR = new zzdc();
    public final int zza;
    public final IBinder zzb;
    public final IBinder zzc;
    public final PendingIntent zzd;
    public final String zze;
    public final String zzf;

    public zzdb(int r1, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, String str, String str2) {
        this.zza = r1;
        this.zzb = iBinder;
        this.zzc = iBinder2;
        this.zzd = pendingIntent;
        this.zze = Build.VERSION.SDK_INT >= 30 ? null : str;
        this.zzf = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, this.zza);
        OnTimeoutKt.writeIBinder(parcel, 2, this.zzb);
        OnTimeoutKt.writeIBinder(parcel, 3, this.zzc);
        OnTimeoutKt.writeParcelable(parcel, 4, this.zzd, r5);
        OnTimeoutKt.writeString(parcel, 5, this.zze);
        OnTimeoutKt.writeString(parcel, 6, this.zzf);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
