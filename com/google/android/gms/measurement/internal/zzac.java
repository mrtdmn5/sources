package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new zzad();
    public String zza;
    public String zzb;
    public zzkw zzc;
    public long zzd;
    public boolean zze;
    public String zzf;
    public final zzaw zzg;
    public long zzh;
    public zzaw zzi;
    public final long zzj;
    public final zzaw zzk;

    public zzac(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        this.zza = zzacVar.zza;
        this.zzb = zzacVar.zzb;
        this.zzc = zzacVar.zzc;
        this.zzd = zzacVar.zzd;
        this.zze = zzacVar.zze;
        this.zzf = zzacVar.zzf;
        this.zzg = zzacVar.zzg;
        this.zzh = zzacVar.zzh;
        this.zzi = zzacVar.zzi;
        this.zzj = zzacVar.zzj;
        this.zzk = zzacVar.zzk;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r6) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeString(parcel, 2, this.zza);
        OnTimeoutKt.writeString(parcel, 3, this.zzb);
        OnTimeoutKt.writeParcelable(parcel, 4, this.zzc, r6);
        OnTimeoutKt.writeLong(parcel, 5, this.zzd);
        OnTimeoutKt.writeBoolean(parcel, 6, this.zze);
        OnTimeoutKt.writeString(parcel, 7, this.zzf);
        OnTimeoutKt.writeParcelable(parcel, 8, this.zzg, r6);
        OnTimeoutKt.writeLong(parcel, 9, this.zzh);
        OnTimeoutKt.writeParcelable(parcel, 10, this.zzi, r6);
        OnTimeoutKt.writeLong(parcel, 11, this.zzj);
        OnTimeoutKt.writeParcelable(parcel, 12, this.zzk, r6);
        OnTimeoutKt.zzb(parcel, zza);
    }

    public zzac(String str, String str2, zzkw zzkwVar, long j, boolean z, String str3, zzaw zzawVar, long j2, zzaw zzawVar2, long j3, zzaw zzawVar3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzkwVar;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzawVar;
        this.zzh = j2;
        this.zzi = zzawVar2;
        this.zzj = j3;
        this.zzk = zzawVar3;
    }
}
