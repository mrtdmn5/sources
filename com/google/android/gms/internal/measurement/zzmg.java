package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzmg implements Iterator {
    public final /* synthetic */ zzmk zza;
    public int zzb = -1;
    public boolean zzc;
    public Iterator zzd;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int r0 = this.zzb + 1;
        zzmk zzmkVar = this.zza;
        if (r0 < zzmkVar.zzb.size()) {
            return true;
        }
        if (!zzmkVar.zzc.isEmpty() && zza().hasNext()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int r1 = this.zzb + 1;
        this.zzb = r1;
        zzmk zzmkVar = this.zza;
        if (r1 < zzmkVar.zzb.size()) {
            return (Map.Entry) zzmkVar.zzb.get(this.zzb);
        }
        return (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            int r0 = zzmk.$r8$clinit;
            zzmk zzmkVar = this.zza;
            zzmkVar.zzn();
            if (this.zzb < zzmkVar.zzb.size()) {
                int r1 = this.zzb;
                this.zzb = r1 - 1;
                zzmkVar.zzl(r1);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    public final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }
}
