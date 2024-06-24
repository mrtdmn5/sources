package com.google.android.gms.internal.measurement;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzad implements Iterator {
    public final /* synthetic */ zzae zza;
    public int zzb = 0;

    public zzad(zzae zzaeVar) {
        this.zza = zzaeVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zzb < this.zza.zzc()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int r0 = this.zzb;
        zzae zzaeVar = this.zza;
        if (r0 < zzaeVar.zzc()) {
            int r02 = this.zzb;
            this.zzb = r02 + 1;
            return zzaeVar.zze(r02);
        }
        throw new NoSuchElementException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Out of bounds index: ", this.zzb));
    }
}
