package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzc {
    public final zzf zza;
    public zzg zzb;
    public final zzab zzc;
    public final zzz zzd;

    public zzc() {
        zzf zzfVar = new zzf();
        this.zza = zzfVar;
        this.zzb = zzfVar.zzb.zza();
        this.zzc = new zzab();
        this.zzd = new zzz();
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.measurement.zza
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzv(zzc.this.zzd);
            }
        };
        zzj zzjVar = zzfVar.zzd;
        zzjVar.zza.put("internal.registerCallback", callable);
        zzjVar.zza.put("internal.eventLogger", new Callable() { // from class: com.google.android.gms.internal.measurement.zzb
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzk(zzc.this.zzc);
            }
        });
    }

    public final void zzc(zzgt zzgtVar) throws zzd {
        zzai zzaiVar;
        zzf zzfVar = this.zza;
        try {
            this.zzb = zzfVar.zzb.zza();
            if (!(zzfVar.zza(this.zzb, (zzgy[]) zzgtVar.zzc().toArray(new zzgy[0])) instanceof zzag)) {
                for (zzgr zzgrVar : zzgtVar.zza().zzd()) {
                    zzkm zzc = zzgrVar.zzc();
                    String zzb = zzgrVar.zzb();
                    Iterator it = zzc.iterator();
                    while (it.hasNext()) {
                        zzap zza = zzfVar.zza(this.zzb, (zzgy) it.next());
                        if (zza instanceof zzam) {
                            zzg zzgVar = this.zzb;
                            if (!zzgVar.zzh(zzb)) {
                                zzaiVar = null;
                            } else {
                                zzap zzd = zzgVar.zzd(zzb);
                                if (zzd instanceof zzai) {
                                    zzaiVar = (zzai) zzd;
                                } else {
                                    throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(zzb)));
                                }
                            }
                            if (zzaiVar != null) {
                                zzaiVar.zza(this.zzb, Collections.singletonList(zza));
                            } else {
                                throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(zzb)));
                            }
                        } else {
                            throw new IllegalArgumentException("Invalid rule definition");
                        }
                    }
                }
                return;
            }
            throw new IllegalStateException("Program loading failed");
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final boolean zze(zzaa zzaaVar) throws zzd {
        zzab zzabVar = this.zzc;
        try {
            zzabVar.zza = zzaaVar;
            zzabVar.zzb = zzaaVar.clone();
            zzabVar.zzc.clear();
            this.zza.zzc.zzg("runtime.counter", new zzah(Double.valueOf(0.0d)));
            this.zzd.zzb(this.zzb.zza(), zzabVar);
            if (!(!zzabVar.zzb.equals(zzabVar.zza))) {
                if (!(!zzabVar.zzc.isEmpty())) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }
}
