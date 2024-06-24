package com.google.android.gms.stats;

import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.stats.zzb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Dns$Companion$DnsSystem;

/* compiled from: com.google.android.gms:play-services-stats@@17.0.1 */
/* loaded from: classes3.dex */
public final class WakeLock {
    public static final long zzb = TimeUnit.DAYS.toMillis(366);
    public static volatile ScheduledExecutorService zzc = null;
    public static final Object zzd = new Object();
    public zzb zza;
    public final Object zzf;
    public final PowerManager.WakeLock zzg;
    public int zzh;
    public ScheduledFuture zzi;
    public long zzj;
    public final HashSet zzk;
    public boolean zzl;
    public final Dns$Companion$DnsSystem zzn;
    public final String zzp;
    public final HashMap zzs;
    public final AtomicInteger zzt;
    public final ScheduledExecutorService zzu;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public WakeLock(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.<init>(android.content.Context):void");
    }

    public final void acquire(long j) {
        this.zzt.incrementAndGet();
        long j2 = Long.MAX_VALUE;
        long max = Math.max(Math.min(Long.MAX_VALUE, zzb), 1L);
        if (j > 0) {
            max = Math.min(j, max);
        }
        synchronized (this.zzf) {
            try {
                if (!isHeld()) {
                    this.zza = zzb.zza;
                    this.zzg.acquire();
                    this.zzn.getClass();
                    SystemClock.elapsedRealtime();
                }
                this.zzh++;
                if (this.zzl) {
                    TextUtils.isEmpty(null);
                }
                zzc zzcVar = (zzc) this.zzs.get(null);
                if (zzcVar == null) {
                    zzcVar = new zzc(0);
                    this.zzs.put(null, zzcVar);
                }
                zzcVar.zza++;
                this.zzn.getClass();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (Long.MAX_VALUE - elapsedRealtime > max) {
                    j2 = elapsedRealtime + max;
                }
                if (j2 > this.zzj) {
                    this.zzj = j2;
                    ScheduledFuture scheduledFuture = this.zzi;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.zzi = this.zzu.schedule(new Runnable() { // from class: com.google.android.gms.stats.zza
                        @Override // java.lang.Runnable
                        public final void run() {
                            WakeLock wakeLock = WakeLock.this;
                            synchronized (wakeLock.zzf) {
                                if (wakeLock.isHeld()) {
                                    Log.e("WakeLock", String.valueOf(wakeLock.zzp).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                                    wakeLock.zzc();
                                    if (wakeLock.isHeld()) {
                                        wakeLock.zzh = 1;
                                        wakeLock.zzd();
                                    }
                                }
                            }
                        }
                    }, max, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isHeld() {
        boolean z;
        synchronized (this.zzf) {
            if (this.zzh > 0) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final void release() {
        if (this.zzt.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.zzp).concat(" release without a matched acquire!"));
        }
        synchronized (this.zzf) {
            try {
                if (this.zzl) {
                    TextUtils.isEmpty(null);
                }
                if (this.zzs.containsKey(null)) {
                    zzc zzcVar = (zzc) this.zzs.get(null);
                    if (zzcVar != null) {
                        int r3 = zzcVar.zza - 1;
                        zzcVar.zza = r3;
                        if (r3 == 0) {
                            this.zzs.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.zzp).concat(" counter does not exist"));
                }
                zzd();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc() {
        HashSet hashSet = this.zzk;
        if (hashSet.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        hashSet.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        throw null;
    }

    public final void zzd() {
        synchronized (this.zzf) {
            if (!isHeld()) {
                return;
            }
            if (this.zzl) {
                int r1 = this.zzh - 1;
                this.zzh = r1;
                if (r1 > 0) {
                    return;
                }
            } else {
                this.zzh = 0;
            }
            zzc();
            Iterator it = this.zzs.values().iterator();
            while (it.hasNext()) {
                ((zzc) it.next()).zza = 0;
            }
            this.zzs.clear();
            ScheduledFuture scheduledFuture = this.zzi;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                this.zzi = null;
                this.zzj = 0L;
            }
            try {
                if (this.zzg.isHeld()) {
                    try {
                        this.zzg.release();
                        if (this.zza != null) {
                            this.zza = null;
                        }
                    } catch (RuntimeException e) {
                        if (e.getClass().equals(RuntimeException.class)) {
                            Log.e("WakeLock", String.valueOf(this.zzp).concat(" failed to release!"), e);
                            if (this.zza != null) {
                                this.zza = null;
                            }
                        } else {
                            throw e;
                        }
                    }
                } else {
                    Log.e("WakeLock", String.valueOf(this.zzp).concat(" should be held!"));
                }
            } catch (Throwable th) {
                if (this.zza != null) {
                    this.zza = null;
                }
                throw th;
            }
        }
    }
}
