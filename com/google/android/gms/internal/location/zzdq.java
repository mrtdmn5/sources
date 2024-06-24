package com.google.android.gms.internal.location;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzdq extends zzdo {
    public final zzds zza;

    public zzdq(zzds zzdsVar, int r3) {
        super(zzdsVar.size(), r3);
        this.zza = zzdsVar;
    }

    @Override // com.google.android.gms.internal.location.zzdo
    public final Object zza(int r2) {
        return this.zza.get(r2);
    }
}
