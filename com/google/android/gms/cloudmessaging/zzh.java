package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzh implements Runnable {
    public final /* synthetic */ zzm zza;

    public /* synthetic */ zzh(zzm zzmVar) {
        this.zza = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final zzm zzmVar = this.zza;
        while (true) {
            synchronized (zzmVar) {
                if (zzmVar.zza != 2) {
                    return;
                }
                if (zzmVar.zzd.isEmpty()) {
                    zzmVar.zzf();
                    return;
                }
                final zzp<?> zzpVar = (zzp) zzmVar.zzd.poll();
                zzmVar.zze.put(zzpVar.zza, zzpVar);
                zzmVar.zzf.zzc.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzk
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzm zzmVar2 = zzm.this;
                        int r1 = zzpVar.zza;
                        synchronized (zzmVar2) {
                            zzp<?> zzpVar2 = zzmVar2.zze.get(r1);
                            if (zzpVar2 != null) {
                                StringBuilder sb = new StringBuilder(31);
                                sb.append("Timing out request: ");
                                sb.append(r1);
                                Log.w("MessengerIpcClient", sb.toString());
                                zzmVar2.zze.remove(r1);
                                zzpVar2.zzc(new zzq("Timed out waiting for response", null));
                                zzmVar2.zzf();
                            }
                        }
                    }
                }, 30L, TimeUnit.SECONDS);
                if (Log.isLoggable("MessengerIpcClient", 3)) {
                    String valueOf = String.valueOf(zzpVar);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 8);
                    sb.append("Sending ");
                    sb.append(valueOf);
                    Log.d("MessengerIpcClient", sb.toString());
                }
                Context context = zzmVar.zzf.zzb;
                Messenger messenger = zzmVar.zzb;
                Message obtain = Message.obtain();
                obtain.what = zzpVar.zzc;
                obtain.arg1 = zzpVar.zza;
                obtain.replyTo = messenger;
                Bundle bundle = new Bundle();
                bundle.putBoolean("oneWay", zzpVar.zzb());
                bundle.putString("pkg", context.getPackageName());
                bundle.putBundle("data", zzpVar.zzd);
                obtain.setData(bundle);
                try {
                    zzn zznVar = zzmVar.zzc;
                    Messenger messenger2 = zznVar.zza;
                    if (messenger2 != null) {
                        messenger2.send(obtain);
                    } else {
                        zzd zzdVar = zznVar.zzb;
                        if (zzdVar != null) {
                            Messenger messenger3 = zzdVar.zza;
                            messenger3.getClass();
                            messenger3.send(obtain);
                        } else {
                            throw new IllegalStateException("Both messengers are null");
                            break;
                        }
                    }
                } catch (RemoteException e) {
                    zzmVar.zza(2, e.getMessage());
                }
            }
        }
    }
}
