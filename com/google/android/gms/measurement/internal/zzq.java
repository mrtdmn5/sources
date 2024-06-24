package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final long zze;
    public final long zzf;
    public final String zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final long zzj;
    public final String zzk;

    @Deprecated
    public final long zzl;
    public final long zzm;
    public final int zzn;
    public final boolean zzo;
    public final boolean zzp;
    public final String zzq;
    public final Boolean zzr;
    public final long zzs;
    public final List zzt;
    public final String zzu;
    public final String zzv;
    public final String zzw;
    public final String zzx;

    public zzq(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, int r21, boolean z3, boolean z4, String str7, Boolean bool, long j5, List list, String str8, String str9, String str10) {
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = true != TextUtils.isEmpty(str2) ? str2 : null;
        this.zzc = str3;
        this.zzj = j;
        this.zzd = str4;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzl = 0L;
        this.zzm = j4;
        this.zzn = r21;
        this.zzo = z3;
        this.zzp = z4;
        this.zzq = str7;
        this.zzr = bool;
        this.zzs = j5;
        this.zzt = list;
        this.zzu = null;
        this.zzv = str8;
        this.zzw = str9;
        this.zzx = str10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeString(parcel, 2, this.zza);
        OnTimeoutKt.writeString(parcel, 3, this.zzb);
        OnTimeoutKt.writeString(parcel, 4, this.zzc);
        OnTimeoutKt.writeString(parcel, 5, this.zzd);
        OnTimeoutKt.writeLong(parcel, 6, this.zze);
        OnTimeoutKt.writeLong(parcel, 7, this.zzf);
        OnTimeoutKt.writeString(parcel, 8, this.zzg);
        OnTimeoutKt.writeBoolean(parcel, 9, this.zzh);
        OnTimeoutKt.writeBoolean(parcel, 10, this.zzi);
        OnTimeoutKt.writeLong(parcel, 11, this.zzj);
        OnTimeoutKt.writeString(parcel, 12, this.zzk);
        OnTimeoutKt.writeLong(parcel, 13, this.zzl);
        OnTimeoutKt.writeLong(parcel, 14, this.zzm);
        OnTimeoutKt.writeInt(parcel, 15, this.zzn);
        OnTimeoutKt.writeBoolean(parcel, 16, this.zzo);
        OnTimeoutKt.writeBoolean(parcel, 18, this.zzp);
        OnTimeoutKt.writeString(parcel, 19, this.zzq);
        Boolean bool = this.zzr;
        if (bool != null) {
            parcel.writeInt(262165);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        OnTimeoutKt.writeLong(parcel, 22, this.zzs);
        List<String> list = this.zzt;
        if (list != null) {
            int zza2 = OnTimeoutKt.zza(parcel, 23);
            parcel.writeStringList(list);
            OnTimeoutKt.zzb(parcel, zza2);
        }
        OnTimeoutKt.writeString(parcel, 24, this.zzu);
        OnTimeoutKt.writeString(parcel, 25, this.zzv);
        OnTimeoutKt.writeString(parcel, 26, this.zzw);
        OnTimeoutKt.writeString(parcel, 27, this.zzx);
        OnTimeoutKt.zzb(parcel, zza);
    }

    public zzq(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int r22, boolean z3, boolean z4, String str7, Boolean bool, long j6, ArrayList arrayList, String str8, String str9, String str10, String str11) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzj = j3;
        this.zzd = str4;
        this.zze = j;
        this.zzf = j2;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzl = j4;
        this.zzm = j5;
        this.zzn = r22;
        this.zzo = z3;
        this.zzp = z4;
        this.zzq = str7;
        this.zzr = bool;
        this.zzs = j6;
        this.zzt = arrayList;
        this.zzu = str8;
        this.zzv = str9;
        this.zzw = str10;
        this.zzx = str11;
    }
}
