package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzfn extends Thread {
    public final /* synthetic */ zzfo zza;
    public final Object zzb;
    public final BlockingQueue zzc;
    public boolean zzd = false;

    public zzfn(zzfo zzfoVar, String str, BlockingQueue blockingQueue) {
        this.zza = zzfoVar;
        Preconditions.checkNotNull(blockingQueue);
        this.zzb = new Object();
        this.zzc = blockingQueue;
        setName(str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        int r3;
        boolean z = false;
        while (!z) {
            try {
                this.zza.zzi.acquire();
                z = true;
            } catch (InterruptedException e) {
                zzc(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzfm zzfmVar = (zzfm) this.zzc.poll();
                if (zzfmVar != null) {
                    if (true != zzfmVar.zza) {
                        r3 = 10;
                    } else {
                        r3 = threadPriority;
                    }
                    Process.setThreadPriority(r3);
                    zzfmVar.run();
                } else {
                    synchronized (this.zzb) {
                        try {
                            if (this.zzc.peek() == null) {
                                this.zza.getClass();
                                this.zzb.wait(30000L);
                            }
                        } catch (InterruptedException e2) {
                            zzc(e2);
                        } finally {
                        }
                    }
                    synchronized (this.zza.zzh) {
                        if (this.zzc.peek() == null) {
                            zzb();
                            return;
                        }
                    }
                }
            }
        } finally {
            zzb();
        }
    }

    public final void zzb() {
        synchronized (this.zza.zzh) {
            try {
                if (!this.zzd) {
                    this.zza.zzi.release();
                    this.zza.zzh.notifyAll();
                    zzfo zzfoVar = this.zza;
                    if (this == zzfoVar.zzb) {
                        zzfoVar.zzb = null;
                    } else if (this == zzfoVar.zzc) {
                        zzfoVar.zzc = null;
                    } else {
                        zzeh zzehVar = zzfoVar.zzt.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zza("Current scheduler thread is neither worker nor network");
                    }
                    this.zzd = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc(InterruptedException interruptedException) {
        zzeh zzehVar = this.zza.zzt.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzg.zzb(interruptedException, String.valueOf(getName()).concat(" was interrupted"));
    }
}
