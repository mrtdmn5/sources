package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhe extends ContentObserver {
    public final /* synthetic */ zzhf zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhe(zzhf zzhfVar) {
        super(null);
        this.zza = zzhfVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzhf zzhfVar = this.zza;
        synchronized (zzhfVar.zzg) {
            zzhfVar.zzh = null;
            zzhfVar.zze.run();
        }
        synchronized (zzhfVar) {
            Iterator it = zzhfVar.zzi.iterator();
            while (it.hasNext()) {
                ((zzhg) it.next()).zza();
            }
        }
    }
}
