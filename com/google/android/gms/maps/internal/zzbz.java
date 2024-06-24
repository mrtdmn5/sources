package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzbz extends zza implements IUiSettingsDelegate {
    public zzbz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IUiSettingsDelegate");
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setCompassEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int r1 = zzc.$r8$clinit;
        zza.writeInt(z ? 1 : 0);
        zzc(zza, 2);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setMapToolbarEnabled() throws RemoteException {
        Parcel zza = zza();
        int r1 = zzc.$r8$clinit;
        zza.writeInt(0);
        zzc(zza, 18);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setMyLocationButtonEnabled() throws RemoteException {
        Parcel zza = zza();
        int r1 = zzc.$r8$clinit;
        zza.writeInt(0);
        zzc(zza, 3);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setRotateGesturesEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int r1 = zzc.$r8$clinit;
        zza.writeInt(z ? 1 : 0);
        zzc(zza, 7);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setScrollGesturesEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int r1 = zzc.$r8$clinit;
        zza.writeInt(z ? 1 : 0);
        zzc(zza, 4);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void setZoomGesturesEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int r1 = zzc.$r8$clinit;
        zza.writeInt(z ? 1 : 0);
        zzc(zza, 5);
    }
}
