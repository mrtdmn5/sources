package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
/* loaded from: classes3.dex */
public final class zzm implements ServiceConnection {
    public zzn zzc;
    public final /* synthetic */ zzs zzf;
    public int zza = 0;
    public final Messenger zzb = new Messenger(new com.google.android.gms.internal.cloudmessaging.zzf(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.gms.cloudmessaging.zzf
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            zzm zzmVar = zzm.this;
            int r1 = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                StringBuilder sb = new StringBuilder(41);
                sb.append("Received response to request: ");
                sb.append(r1);
                Log.d("MessengerIpcClient", sb.toString());
            }
            synchronized (zzmVar) {
                zzp<?> zzpVar = zzmVar.zze.get(r1);
                if (zzpVar == null) {
                    StringBuilder sb2 = new StringBuilder(50);
                    sb2.append("Received response for unknown request: ");
                    sb2.append(r1);
                    Log.w("MessengerIpcClient", sb2.toString());
                    return true;
                }
                zzmVar.zze.remove(r1);
                zzmVar.zzf();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    zzpVar.zzc(new zzq("Not supported by GmsCore", null));
                    return true;
                }
                zzpVar.zza(data);
                return true;
            }
        }
    }));
    public final ArrayDeque zzd = new ArrayDeque();
    public final SparseArray<zzp<?>> zze = new SparseArray<>();

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.zzf.zzc.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzj
            @Override // java.lang.Runnable
            public final void run() {
                zzm zzmVar = zzm.this;
                IBinder iBinder2 = iBinder;
                synchronized (zzmVar) {
                    try {
                        if (iBinder2 == null) {
                            zzmVar.zza(0, "Null service connection");
                            return;
                        }
                        try {
                            zzmVar.zzc = new zzn(iBinder2);
                            zzmVar.zza = 2;
                            zzmVar.zzf.zzc.execute(new zzh(zzmVar));
                        } catch (RemoteException e) {
                            zzmVar.zza(0, e.getMessage());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.zzf.zzc.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzg
            @Override // java.lang.Runnable
            public final void run() {
                zzm.this.zza(2, "Service disconnected");
            }
        });
    }

    public final synchronized void zza(int r2, String str) {
        zzb(r2, str, null);
    }

    public final synchronized void zzb(int r5, String str, SecurityException securityException) {
        String str2;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Disconnected: ".concat(valueOf);
            } else {
                str2 = new String("Disconnected: ");
            }
            Log.d("MessengerIpcClient", str2);
        }
        int r52 = this.zza;
        if (r52 != 0) {
            if (r52 != 1 && r52 != 2) {
                if (r52 != 3) {
                    return;
                }
                this.zza = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.zza = 4;
            ConnectionTracker.getInstance().unbindService(this.zzf.zzb, this);
            zzq zzqVar = new zzq(str, securityException);
            Iterator it = this.zzd.iterator();
            while (it.hasNext()) {
                ((zzp) it.next()).zzc(zzqVar);
            }
            this.zzd.clear();
            for (int r6 = 0; r6 < this.zze.size(); r6++) {
                this.zze.valueAt(r6).zzc(zzqVar);
            }
            this.zze.clear();
            return;
        }
        throw new IllegalStateException();
    }

    public final synchronized void zzf() {
        if (this.zza == 2 && this.zzd.isEmpty() && this.zze.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.zza = 3;
            ConnectionTracker.getInstance().unbindService(this.zzf.zzb, this);
        }
    }

    public final synchronized boolean zzg(zzp<?> zzpVar) {
        boolean z;
        int r0 = this.zza;
        if (r0 != 0) {
            if (r0 != 1) {
                if (r0 != 2) {
                    return false;
                }
                this.zzd.add(zzpVar);
                this.zzf.zzc.execute(new zzh(this));
                return true;
            }
            this.zzd.add(zzpVar);
            return true;
        }
        this.zzd.add(zzpVar);
        if (this.zza == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.zza = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            try {
                if (!ConnectionTracker.getInstance().bindService(this.zzf.zzb, intent, this, 1)) {
                    zza(0, "Unable to bind to service");
                } else {
                    this.zzf.zzc.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzi
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzm zzmVar = zzm.this;
                            synchronized (zzmVar) {
                                if (zzmVar.zza == 1) {
                                    zzmVar.zza(1, "Timed out while binding");
                                }
                            }
                        }
                    }, 30L, TimeUnit.SECONDS);
                }
            } catch (SecurityException e) {
                zzb(0, "Unable to bind to service", e);
            }
            return true;
        }
        throw new IllegalStateException();
    }
}
