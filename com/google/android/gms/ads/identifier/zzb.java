package com.google.android.gms.ads.identifier;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
/* loaded from: classes3.dex */
public final class zzb extends Thread {
    public final CountDownLatch zza = new CountDownLatch(1);
    public boolean zzb = false;
    public final WeakReference<AdvertisingIdClient> zzc;
    public final long zzd;

    public zzb(AdvertisingIdClient advertisingIdClient, long j) {
        this.zzc = new WeakReference<>(advertisingIdClient);
        this.zzd = j;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        AdvertisingIdClient advertisingIdClient;
        WeakReference<AdvertisingIdClient> weakReference = this.zzc;
        try {
            if (!this.zza.await(this.zzd, TimeUnit.MILLISECONDS) && (advertisingIdClient = weakReference.get()) != null) {
                advertisingIdClient.zza();
                this.zzb = true;
            }
        } catch (InterruptedException unused) {
            AdvertisingIdClient advertisingIdClient2 = weakReference.get();
            if (advertisingIdClient2 != null) {
                advertisingIdClient2.zza();
                this.zzb = true;
            }
        }
    }
}
