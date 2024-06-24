package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzf extends zza {
    public final IBinder zze;
    public final /* synthetic */ BaseGmsClient zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(BaseGmsClient baseGmsClient, int r2, IBinder iBinder, Bundle bundle) {
        super(baseGmsClient, r2, bundle);
        this.zzf = baseGmsClient;
        this.zze = iBinder;
    }

    @Override // com.google.android.gms.common.internal.zza
    public final void zzb(ConnectionResult connectionResult) {
        BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener = this.zzf.zzx;
        if (baseOnConnectionFailedListener != null) {
            baseOnConnectionFailedListener.onConnectionFailed(connectionResult);
        }
        System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.internal.zza
    public final boolean zzd() {
        IBinder iBinder = this.zze;
        try {
            Preconditions.checkNotNull(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            BaseGmsClient baseGmsClient = this.zzf;
            if (!baseGmsClient.getServiceDescriptor().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + baseGmsClient.getServiceDescriptor() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface createServiceInterface = baseGmsClient.createServiceInterface(iBinder);
            if (createServiceInterface == null || (!BaseGmsClient.zzn(baseGmsClient, 2, 4, createServiceInterface) && !BaseGmsClient.zzn(baseGmsClient, 3, 4, createServiceInterface))) {
                return false;
            }
            baseGmsClient.zzB = null;
            BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks = baseGmsClient.zzw;
            if (baseConnectionCallbacks != null) {
                baseConnectionCallbacks.onConnected();
                return true;
            }
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
