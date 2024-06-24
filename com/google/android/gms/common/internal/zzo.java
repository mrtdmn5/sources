package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzo implements ServiceConnection, zzs {
    public final /* synthetic */ zzr zza;
    public final HashMap zzb = new HashMap();
    public int zzc = 2;
    public boolean zzd;
    public IBinder zze;
    public final zzn zzf;
    public ComponentName zzg;

    public zzo(zzr zzrVar, zzn zznVar) {
        this.zza = zzrVar;
        this.zzf = zznVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zza.zzb) {
            this.zza.zzd.removeMessages(1, this.zzf);
            this.zze = iBinder;
            this.zzg = componentName;
            Iterator it = this.zzb.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
            }
            this.zzc = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zza.zzb) {
            this.zza.zzd.removeMessages(1, this.zzf);
            this.zze = null;
            this.zzg = componentName;
            Iterator it = this.zzb.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
            }
            this.zzc = 2;
        }
    }

    public final void zze(String str, Executor executor) {
        boolean z;
        StrictMode.VmPolicy.Builder permitUnsafeIntentLaunch;
        this.zzc = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (Build.VERSION.SDK_INT >= 31) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            permitUnsafeIntentLaunch = new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch();
            StrictMode.setVmPolicy(permitUnsafeIntentLaunch.build());
        }
        try {
            zzr zzrVar = this.zza;
            ConnectionTracker connectionTracker = zzrVar.zzf;
            Context context = zzrVar.zzc;
            boolean zzc = connectionTracker.zzc(context, str, this.zzf.zzc(context), this, this.zzf.zze, executor);
            this.zzd = zzc;
            if (zzc) {
                this.zza.zzd.sendMessageDelayed(this.zza.zzd.obtainMessage(1, this.zzf), this.zza.zzh);
            } else {
                this.zzc = 2;
                try {
                    zzr zzrVar2 = this.zza;
                    zzrVar2.zzf.unbindService(zzrVar2.zzc, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }
}
