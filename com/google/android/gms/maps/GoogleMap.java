package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class GoogleMap {
    public final IGoogleMapDelegate zza;
    public UiSettings zzc;

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes3.dex */
    public interface OnMapLoadedCallback {
    }

    public GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        new HashMap();
        Preconditions.checkNotNull(iGoogleMapDelegate);
        this.zza = iGoogleMapDelegate;
    }

    public final void addCircle(CircleOptions circleOptions) {
        try {
            Preconditions.checkNotNull(this.zza.addCircle(circleOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.zza.animateCamera(cameraUpdate.zza);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.zza.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.zzc == null) {
                this.zzc = new UiSettings(this.zza.getUiSettings());
            }
            return this.zzc;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.zza.moveCamera(cameraUpdate.zza);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
