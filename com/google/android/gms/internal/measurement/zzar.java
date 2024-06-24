package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzar implements Iterator {
    public final /* synthetic */ zzat zza;
    public int zzb = 0;

    public zzar(zzat zzatVar) {
        this.zza = zzatVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zzb < this.zza.zza.length()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int r0 = this.zzb;
        if (r0 < this.zza.zza.length()) {
            this.zzb = r0 + 1;
            return new zzat(String.valueOf(r0));
        }
        throw new NoSuchElementException();
    }
}
