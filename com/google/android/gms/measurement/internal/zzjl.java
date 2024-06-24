package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjl implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    public final /* synthetic */ zzjm zza;
    public volatile boolean zzb;
    public volatile zzed zzc;

    public zzjl(zzjm zzjmVar) {
        this.zza = zzjmVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected() {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.zzc);
                zzdx zzdxVar = (zzdx) this.zzc.getService();
                zzfo zzfoVar = this.zza.zzt.zzn;
                zzfr.zzR(zzfoVar);
                zzfoVar.zzp(new zzji(this, zzdxVar));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzeh zzehVar = this.zza.zzt.zzm;
        if (zzehVar == null || !((zzgl) zzehVar).zza) {
            zzehVar = null;
        }
        if (zzehVar != null) {
            zzehVar.zzg.zzb(connectionResult, "Service connection failed");
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        zzfo zzfoVar = this.zza.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzjk(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int r3) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        zzjm zzjmVar = this.zza;
        zzeh zzehVar = zzjmVar.zzt.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzk.zza("Service connection suspended");
        zzfo zzfoVar = zzjmVar.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzjj(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzdx zzdvVar;
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.zzb = false;
                zzeh zzehVar = this.zza.zzt.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zza("Service connected with null binder");
                return;
            }
            zzdx zzdxVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdvVar = (zzdx) queryLocalInterface;
                    } else {
                        zzdvVar = new zzdv(iBinder);
                    }
                    zzdxVar = zzdvVar;
                    zzeh zzehVar2 = this.zza.zzt.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzl.zza("Bound to IMeasurementService interface");
                } else {
                    zzeh zzehVar3 = this.zza.zzt.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zzb(interfaceDescriptor, "Got binder with a wrong descriptor");
                }
            } catch (RemoteException unused) {
                zzeh zzehVar4 = this.zza.zzt.zzm;
                zzfr.zzR(zzehVar4);
                zzehVar4.zzd.zza("Service connect failed to get IMeasurementService");
            }
            if (zzdxVar == null) {
                this.zzb = false;
                try {
                    ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                    zzjm zzjmVar = this.zza;
                    connectionTracker.unbindService(zzjmVar.zzt.zze, zzjmVar.zza);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                zzfo zzfoVar = this.zza.zzt.zzn;
                zzfr.zzR(zzfoVar);
                zzfoVar.zzp(new zzjg(this, zzdxVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        zzjm zzjmVar = this.zza;
        zzeh zzehVar = zzjmVar.zzt.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzk.zza("Service disconnected");
        zzfo zzfoVar = zzjmVar.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new zzjh(this, componentName));
    }
}
