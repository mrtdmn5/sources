package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public class zzgk implements zzgm {
    public final zzfr zzt;

    public zzgk(zzfr zzfrVar) {
        Preconditions.checkNotNull(zzfrVar);
        this.zzt = zzfrVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    @Pure
    public final Context zzau() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    @Pure
    public final Clock zzav() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    @Pure
    public final zzab zzaw() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    @Pure
    public final zzeh zzay() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    @Pure
    public final zzfo zzaz() {
        throw null;
    }

    public void zzg() {
        zzfo zzfoVar = this.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
    }
}
