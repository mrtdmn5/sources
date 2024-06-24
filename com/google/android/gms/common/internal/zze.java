package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zze implements ServiceConnection {
    public final /* synthetic */ BaseGmsClient zza;
    public final int zzb;

    public zze(BaseGmsClient baseGmsClient, int r2) {
        this.zza = baseGmsClient;
        this.zzb = r2;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IGmsServiceBroker zzacVar;
        int r5;
        int r52;
        BaseGmsClient baseGmsClient = this.zza;
        if (iBinder == null) {
            synchronized (baseGmsClient.zzp) {
                r5 = baseGmsClient.zzv;
            }
            if (r5 == 3) {
                baseGmsClient.zzC = true;
                r52 = 5;
            } else {
                r52 = 4;
            }
            zzb zzbVar = baseGmsClient.zzb;
            zzbVar.sendMessage(zzbVar.obtainMessage(r52, baseGmsClient.zzd.get(), 16));
            return;
        }
        synchronized (baseGmsClient.zzq) {
            BaseGmsClient baseGmsClient2 = this.zza;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IGmsServiceBroker)) {
                zzacVar = (IGmsServiceBroker) queryLocalInterface;
            } else {
                zzacVar = new zzac(iBinder);
            }
            baseGmsClient2.zzr = zzacVar;
        }
        BaseGmsClient baseGmsClient3 = this.zza;
        int r53 = this.zzb;
        baseGmsClient3.getClass();
        zzg zzgVar = new zzg(baseGmsClient3, 0);
        zzb zzbVar2 = baseGmsClient3.zzb;
        zzbVar2.sendMessage(zzbVar2.obtainMessage(7, r53, -1, zzgVar));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        BaseGmsClient baseGmsClient;
        synchronized (this.zza.zzq) {
            baseGmsClient = this.zza;
            baseGmsClient.zzr = null;
        }
        zzb zzbVar = baseGmsClient.zzb;
        zzbVar.sendMessage(zzbVar.obtainMessage(6, this.zzb, 1));
    }
}
