package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zziv extends zzix {
    public final /* synthetic */ zzje zza;
    public int zzb = 0;
    public final int zzc;

    public zziv(zzje zzjeVar) {
        this.zza = zzjeVar;
        this.zzc = zzjeVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zzb < this.zzc) {
            return true;
        }
        return false;
    }
}
