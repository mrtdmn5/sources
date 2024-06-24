package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzab {
    public zzaa zza;
    public zzaa zzb;
    public final ArrayList zzc;

    public zzab() {
        this.zza = new zzaa(null, "", 0L);
        this.zzb = new zzaa(null, "", 0L);
        this.zzc = new ArrayList();
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzab zzabVar = new zzab(this.zza.clone());
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzabVar.zzc.add(((zzaa) it.next()).clone());
        }
        return zzabVar;
    }

    public zzab(zzaa zzaaVar) {
        this.zza = zzaaVar;
        this.zzb = zzaaVar.clone();
        this.zzc = new ArrayList();
    }
}
