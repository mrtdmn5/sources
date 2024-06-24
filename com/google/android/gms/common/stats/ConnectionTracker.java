package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class ConnectionTracker {
    public static final Object zzb = new Object();
    public static volatile ConnectionTracker zzc;
    public final ConcurrentHashMap zza = new ConcurrentHashMap();

    public static ConnectionTracker getInstance() {
        if (zzc == null) {
            synchronized (zzb) {
                if (zzc == null) {
                    zzc = new ConnectionTracker();
                }
            }
        }
        ConnectionTracker connectionTracker = zzc;
        Preconditions.checkNotNull(connectionTracker);
        return connectionTracker;
    }

    public final boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int r12) {
        return zzc(context, context.getClass().getName(), intent, serviceConnection, r12, null);
    }

    public final void unbindService(Context context, ServiceConnection serviceConnection) {
        if (!(serviceConnection instanceof zzs)) {
            ConcurrentHashMap concurrentHashMap = this.zza;
            if (concurrentHashMap.containsKey(serviceConnection)) {
                try {
                    try {
                        context.unbindService((ServiceConnection) concurrentHashMap.get(serviceConnection));
                    } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
                    }
                    return;
                } finally {
                    concurrentHashMap.remove(serviceConnection);
                }
            }
        }
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused2) {
        }
    }

    public final boolean zzc(Context context, String str, Intent intent, ServiceConnection serviceConnection, int r11, Executor executor) {
        boolean bindService;
        boolean bindService2;
        ComponentName component = intent.getComponent();
        boolean z = false;
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((Wrappers.packageManager(context).getApplicationInfo(0, packageName).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        boolean z2 = true;
        if (!(serviceConnection instanceof zzs)) {
            ConcurrentHashMap concurrentHashMap = this.zza;
            ServiceConnection serviceConnection2 = (ServiceConnection) concurrentHashMap.putIfAbsent(serviceConnection, serviceConnection);
            if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
                Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
            }
            try {
                if (Build.VERSION.SDK_INT < 29) {
                    z2 = false;
                }
                if (z2 && executor != null) {
                    bindService2 = context.bindService(intent, r11, executor, serviceConnection);
                } else {
                    bindService2 = context.bindService(intent, serviceConnection, r11);
                }
                if (!bindService2) {
                    concurrentHashMap.remove(serviceConnection, serviceConnection);
                    return false;
                }
                return bindService2;
            } catch (Throwable th) {
                concurrentHashMap.remove(serviceConnection, serviceConnection);
                throw th;
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            z = true;
        }
        if (z && executor != null) {
            bindService = context.bindService(intent, r11, executor, serviceConnection);
            return bindService;
        }
        return context.bindService(intent, serviceConnection, r11);
    }
}
