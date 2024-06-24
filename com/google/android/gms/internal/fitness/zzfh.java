package com.google.android.gms.internal.fitness;

import com.animaconnected.firebase.AnalyticsConstants;
import com.google.common.base.Objects;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public abstract class zzfh extends zzft implements ListIterator {
    public final int zza;
    public int zzb;

    public zzfh(int r3, int r4) {
        if (r4 >= 0 && r4 <= r3) {
            this.zza = r3;
            this.zzb = r4;
            return;
        }
        throw new IndexOutOfBoundsException(Objects.zzd(r4, r3, AnalyticsConstants.KEY_INDEX));
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        add$com$google$android$gms$internal$fitness$zzfu(obj);
        throw null;
    }

    @Deprecated
    public final void add$com$google$android$gms$internal$fitness$zzfu(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        if (this.zzb < this.zza) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.zzb > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (hasNext()) {
            int r0 = this.zzb;
            this.zzb = r0 + 1;
            return zza(r0);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzb;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int r0 = this.zzb - 1;
            this.zzb = r0;
            return zza(r0);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzb - 1;
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        set$com$google$android$gms$internal$fitness$zzfu(obj);
        throw null;
    }

    @Deprecated
    public final void set$com$google$android$gms$internal$fitness$zzfu(Object obj) {
        throw new UnsupportedOperationException();
    }

    public abstract Object zza(int r1);
}
