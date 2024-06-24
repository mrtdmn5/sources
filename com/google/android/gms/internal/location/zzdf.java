package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.zzq;
import com.google.android.gms.location.zzr;
import com.google.android.gms.location.zzs;
import com.google.android.gms.location.zzt;
import com.google.android.gms.location.zzu;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@Deprecated
/* loaded from: classes3.dex */
public final class zzdf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdf> CREATOR = new zzdg();
    public final int zza;
    public final zzdd zzb;
    public final zzu zzc;
    public final zzr zzd;
    public final PendingIntent zze;
    public final zzk zzf;
    public final String zzg;

    public zzdf(int r2, zzdd zzddVar, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, IBinder iBinder3, String str) {
        zzu zzuVar;
        zzr zzrVar;
        this.zza = r2;
        this.zzb = zzddVar;
        zzk zzkVar = null;
        if (iBinder != null) {
            int r3 = zzt.$r8$clinit;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            if (queryLocalInterface instanceof zzu) {
                zzuVar = (zzu) queryLocalInterface;
            } else {
                zzuVar = new zzs(iBinder);
            }
        } else {
            zzuVar = null;
        }
        this.zzc = zzuVar;
        this.zze = pendingIntent;
        if (iBinder2 != null) {
            int r32 = zzq.$r8$clinit;
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
            if (queryLocalInterface2 instanceof zzr) {
                zzrVar = (zzr) queryLocalInterface2;
            } else {
                zzrVar = new com.google.android.gms.location.zzp(iBinder2);
            }
        } else {
            zzrVar = null;
        }
        this.zzd = zzrVar;
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            if (queryLocalInterface3 instanceof zzk) {
                zzkVar = (zzk) queryLocalInterface3;
            } else {
                zzkVar = new zzi(iBinder3);
            }
        }
        this.zzf = zzkVar;
        this.zzg = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r6) {
        IBinder asBinder;
        IBinder asBinder2;
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, this.zza);
        OnTimeoutKt.writeParcelable(parcel, 2, this.zzb, r6);
        IBinder iBinder = null;
        zzu zzuVar = this.zzc;
        if (zzuVar == null) {
            asBinder = null;
        } else {
            asBinder = zzuVar.asBinder();
        }
        OnTimeoutKt.writeIBinder(parcel, 3, asBinder);
        OnTimeoutKt.writeParcelable(parcel, 4, this.zze, r6);
        zzr zzrVar = this.zzd;
        if (zzrVar == null) {
            asBinder2 = null;
        } else {
            asBinder2 = zzrVar.asBinder();
        }
        OnTimeoutKt.writeIBinder(parcel, 5, asBinder2);
        zzk zzkVar = this.zzf;
        if (zzkVar != null) {
            iBinder = zzkVar.asBinder();
        }
        OnTimeoutKt.writeIBinder(parcel, 6, iBinder);
        OnTimeoutKt.writeString(parcel, 8, this.zzg);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
