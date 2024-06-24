package com.google.android.gms.internal.measurement;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhc extends zzhz {
    public final Context zza;
    public final zzii zzb;

    public zzhc(Context context, zzii zziiVar) {
        this.zza = context;
        this.zzb = zziiVar;
    }

    public final boolean equals(Object obj) {
        zzii zziiVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzhz) {
            zzhz zzhzVar = (zzhz) obj;
            if (this.zza.equals(zzhzVar.zza()) && ((zziiVar = this.zzb) != null ? zziiVar.equals(zzhzVar.zzb()) : zzhzVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzii zziiVar = this.zzb;
        if (zziiVar == null) {
            hashCode = 0;
        } else {
            hashCode = zziiVar.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public final String toString() {
        return "FlagsContext{context=" + this.zza.toString() + ", hermeticFileOverrides=" + String.valueOf(this.zzb) + "}";
    }

    @Override // com.google.android.gms.internal.measurement.zzhz
    public final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzhz
    public final zzii zzb() {
        return this.zzb;
    }
}
