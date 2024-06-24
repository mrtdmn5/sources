package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzaa;
import com.google.android.gms.internal.maps.zzae;
import com.google.android.gms.internal.maps.zzaf;
import com.google.android.gms.internal.maps.zzag;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzj;
import com.google.android.gms.internal.maps.zzy;
import com.google.android.gms.internal.maps.zzz;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzg extends zza implements IGoogleMapDelegate {
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IGoogleMapDelegate");
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final com.google.android.gms.internal.maps.zzl addCircle(CircleOptions circleOptions) throws RemoteException {
        com.google.android.gms.internal.maps.zzl zzjVar;
        Parcel zza = zza();
        zzc.zze(zza, circleOptions);
        Parcel zzH = zzH(zza, 35);
        IBinder readStrongBinder = zzH.readStrongBinder();
        int r1 = com.google.android.gms.internal.maps.zzk.$r8$clinit;
        if (readStrongBinder == null) {
            zzjVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            if (queryLocalInterface instanceof com.google.android.gms.internal.maps.zzl) {
                zzjVar = (com.google.android.gms.internal.maps.zzl) queryLocalInterface;
            } else {
                zzjVar = new zzj(readStrongBinder);
            }
        }
        zzH.recycle();
        return zzjVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final zzaa addMarker(MarkerOptions markerOptions) throws RemoteException {
        zzaa zzyVar;
        Parcel zza = zza();
        zzc.zze(zza, markerOptions);
        Parcel zzH = zzH(zza, 11);
        IBinder readStrongBinder = zzH.readStrongBinder();
        int r1 = zzz.$r8$clinit;
        if (readStrongBinder == null) {
            zzyVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            if (queryLocalInterface instanceof zzaa) {
                zzyVar = (zzaa) queryLocalInterface;
            } else {
                zzyVar = new zzy(readStrongBinder);
            }
        }
        zzH.recycle();
        return zzyVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final zzag addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        zzag zzaeVar;
        Parcel zza = zza();
        zzc.zze(zza, polylineOptions);
        Parcel zzH = zzH(zza, 9);
        IBinder readStrongBinder = zzH.readStrongBinder();
        int r1 = zzaf.$r8$clinit;
        if (readStrongBinder == null) {
            zzaeVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            if (queryLocalInterface instanceof zzag) {
                zzaeVar = (zzag) queryLocalInterface;
            } else {
                zzaeVar = new zzae(readStrongBinder);
            }
        }
        zzH.recycle();
        return zzaeVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void animateCamera(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zzg(zza, iObjectWrapper);
        zzc(zza, 5);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final CameraPosition getCameraPosition() throws RemoteException {
        CameraPosition createFromParcel;
        Parcel zzH = zzH(zza(), 1);
        Parcelable.Creator<CameraPosition> creator = CameraPosition.CREATOR;
        int r2 = zzc.$r8$clinit;
        if (zzH.readInt() == 0) {
            createFromParcel = null;
        } else {
            createFromParcel = creator.createFromParcel(zzH);
        }
        CameraPosition cameraPosition = createFromParcel;
        zzH.recycle();
        return cameraPosition;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final IUiSettingsDelegate getUiSettings() throws RemoteException {
        IUiSettingsDelegate zzbzVar;
        Parcel zzH = zzH(zza(), 25);
        IBinder readStrongBinder = zzH.readStrongBinder();
        if (readStrongBinder == null) {
            zzbzVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            if (queryLocalInterface instanceof IUiSettingsDelegate) {
                zzbzVar = (IUiSettingsDelegate) queryLocalInterface;
            } else {
                zzbzVar = new zzbz(readStrongBinder);
            }
        }
        zzH.recycle();
        return zzbzVar;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void moveCamera(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zzg(zza, iObjectWrapper);
        zzc(zza, 4);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final boolean setMapStyle(MapStyleOptions mapStyleOptions) throws RemoteException {
        boolean z;
        Parcel zza = zza();
        zzc.zze(zza, mapStyleOptions);
        Parcel zzH = zzH(zza, 91);
        if (zzH.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        zzH.recycle();
        return z;
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setMapType() throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(1);
        zzc(zza, 16);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setMyLocationEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int r1 = zzc.$r8$clinit;
        zza.writeInt(z ? 1 : 0);
        zzc(zza, 22);
    }

    @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
    public final void setOnMapLoadedCallback(com.google.android.gms.maps.zzj zzjVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzg(zza, zzjVar);
        zzc(zza, 42);
    }
}
