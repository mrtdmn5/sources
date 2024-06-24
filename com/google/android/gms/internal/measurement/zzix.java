package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzix implements Iterator {
    @Override // java.util.Iterator
    public final Object next() {
        zziv zzivVar = (zziv) this;
        int r1 = zzivVar.zzb;
        if (r1 < zzivVar.zzc) {
            zzivVar.zzb = r1 + 1;
            return Byte.valueOf(zzivVar.zza.zzb(r1));
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
