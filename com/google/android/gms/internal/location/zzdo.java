package com.google.android.gms.internal.location;

import androidx.compose.ui.graphics.ShadowKt;
import com.animaconnected.firebase.AnalyticsConstants;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public abstract class zzdo extends zzdv {
    public final int zza;
    public int zzb;

    public zzdo(int r3, int r4) {
        if (r4 >= 0 && r4 <= r3) {
            this.zza = r3;
            this.zzb = r4;
            return;
        }
        throw new IndexOutOfBoundsException(ShadowKt.zzd(r4, r3, AnalyticsConstants.KEY_INDEX));
    }

    @Override // java.util.ListIterator, java.util.Iterator
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

    @Override // java.util.ListIterator, java.util.Iterator
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

    public abstract Object zza(int r1);
}
