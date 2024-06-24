package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
/* loaded from: classes3.dex */
public final class zzs {
    public static zzs zza;
    public final Context zzb;
    public final ScheduledExecutorService zzc;
    public zzm zzd = new zzm(this);
    public int zze = 1;

    public zzs(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = scheduledExecutorService;
        this.zzb = context.getApplicationContext();
    }

    public static synchronized zzs zzb(Context context) {
        zzs zzsVar;
        synchronized (zzs.class) {
            if (zza == null) {
                zza = new zzs(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
            }
            zzsVar = zza;
        }
        return zzsVar;
    }

    public final synchronized com.google.android.gms.tasks.zzw zzg(zzp zzpVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(zzpVar);
            StringBuilder sb = new StringBuilder(valueOf.length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.zzd.zzg(zzpVar)) {
            zzm zzmVar = new zzm(this);
            this.zzd = zzmVar;
            zzmVar.zzg(zzpVar);
        }
        return zzpVar.zzb.zza;
    }
}
