package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbm;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzdv extends zzbm implements zzdx {
    public zzdv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final String zzd(zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        Parcel zzb = zzb(zza, 11);
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzf(String str, String str2, zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        Parcel zzb = zzb(zza, 16);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzac.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzg(String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(null);
        zza.writeString(str2);
        zza.writeString(str3);
        Parcel zzb = zzb(zza, 17);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzac.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzh(String str, String str2, boolean z, zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.zzbo.zza;
        zza.writeInt(z ? 1 : 0);
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        Parcel zzb = zzb(zza, 14);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzkw.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzi(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(null);
        zza.writeString(str2);
        zza.writeString(str3);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.zzbo.zza;
        zza.writeInt(z ? 1 : 0);
        Parcel zzb = zzb(zza, 15);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(zzkw.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzj(zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(zza, 4);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzk(zzaw zzawVar, zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzawVar);
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(zza, 1);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzm(zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(zza, 18);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzn(zzac zzacVar, zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzacVar);
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(zza, 12);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzp(zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(zza, 20);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzq(long j, String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzc(zza, 10);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzr(Bundle bundle, zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, bundle);
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(zza, 19);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzs(zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(zza, 6);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzt(zzkw zzkwVar, zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzkwVar);
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzqVar);
        zzc(zza, 2);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final byte[] zzu(zzaw zzawVar, String str) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbo.zze(zza, zzawVar);
        zza.writeString(str);
        Parcel zzb = zzb(zza, 9);
        byte[] createByteArray = zzb.createByteArray();
        zzb.recycle();
        return createByteArray;
    }
}
