package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzca extends zzbm implements zzcc {
    public zzca(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(zza, 23);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zze(zza, bundle);
        zzc(zza, 9);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void clearMeasurementEnabled(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(zza, 43);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zzc(zza, 24);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void generateEventId(zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzf(zza, zzcfVar);
        zzc(zza, 22);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void getCachedAppInstanceId(zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzf(zza, zzcfVar);
        zzc(zza, 19);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void getConditionalUserProperties(String str, String str2, zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zzf(zza, zzcfVar);
        zzc(zza, 10);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void getCurrentScreenClass(zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzf(zza, zzcfVar);
        zzc(zza, 17);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void getCurrentScreenName(zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzf(zza, zzcfVar);
        zzc(zza, 16);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void getGmpAppId(zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzf(zza, zzcfVar);
        zzc(zza, 21);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void getMaxUserProperties(String str, zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbo.zzf(zza, zzcfVar);
        zzc(zza, 6);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void getUserProperties(String str, String str2, boolean z, zzcf zzcfVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        ClassLoader classLoader = zzbo.zza;
        zza.writeInt(z ? 1 : 0);
        zzbo.zzf(zza, zzcfVar);
        zzc(zza, 5);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void initialize(IObjectWrapper iObjectWrapper, zzcl zzclVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzf(zza, iObjectWrapper);
        zzbo.zze(zza, zzclVar);
        zza.writeLong(j);
        zzc(zza, 1);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zze(zza, bundle);
        zza.writeInt(z ? 1 : 0);
        zza.writeInt(z2 ? 1 : 0);
        zza.writeLong(j);
        zzc(zza, 2);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void logHealthData(int r2, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(5);
        zza.writeString(str);
        zzbo.zzf(zza, iObjectWrapper);
        zzbo.zzf(zza, iObjectWrapper2);
        zzbo.zzf(zza, iObjectWrapper3);
        zzc(zza, 33);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzf(zza, iObjectWrapper);
        zzbo.zze(zza, bundle);
        zza.writeLong(j);
        zzc(zza, 27);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzf(zza, iObjectWrapper);
        zza.writeLong(j);
        zzc(zza, 28);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzf(zza, iObjectWrapper);
        zza.writeLong(j);
        zzc(zza, 29);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzf(zza, iObjectWrapper);
        zza.writeLong(j);
        zzc(zza, 30);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcf zzcfVar, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzf(zza, iObjectWrapper);
        zzbo.zzf(zza, zzcfVar);
        zza.writeLong(j);
        zzc(zza, 31);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzf(zza, iObjectWrapper);
        zza.writeLong(j);
        zzc(zza, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzf(zza, iObjectWrapper);
        zza.writeLong(j);
        zzc(zza, 26);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void registerOnMeasurementEventListener(zzci zzciVar) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzf(zza, zzciVar);
        zzc(zza, 35);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, bundle);
        zza.writeLong(j);
        zzc(zza, 8);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeLong(j);
        zzc(zza, 15);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        ClassLoader classLoader = zzbo.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(zza, 39);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        ClassLoader classLoader = zzbo.zza;
        zza.writeInt(z ? 1 : 0);
        zza.writeLong(j);
        zzc(zza, 11);
    }

    @Override // com.google.android.gms.internal.measurement.zzcc
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zzf(zza, iObjectWrapper);
        zza.writeInt(z ? 1 : 0);
        zza.writeLong(j);
        zzc(zza, 4);
    }
}
