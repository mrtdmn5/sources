package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzaw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaw> CREATOR = new zzax();
    public final String zza;
    public final zzau zzb;
    public final String zzc;
    public final long zzd;

    public zzaw(zzaw zzawVar, long j) {
        Preconditions.checkNotNull(zzawVar);
        this.zza = zzawVar.zza;
        this.zzb = zzawVar.zzb;
        this.zzc = zzawVar.zzc;
        this.zzd = j;
    }

    public final String toString() {
        return "origin=" + this.zzc + ",name=" + this.zza + ",params=" + String.valueOf(this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r2) {
        zzax.zza(this, parcel, r2);
    }

    public zzaw(String str, zzau zzauVar, String str2, long j) {
        this.zza = str;
        this.zzb = zzauVar;
        this.zzc = str2;
        this.zzd = j;
    }
}
