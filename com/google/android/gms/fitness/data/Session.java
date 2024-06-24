package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import com.animaconnected.watch.fitness.FitnessDataKt;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class Session extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Session> CREATOR = new zzac();
    public final long zza;
    public final long zzb;
    public final String zzc;
    public final String zzd;
    public final String zze;
    public final int zzf;
    public final zzb zzg;
    public final Long zzh;

    public Session(long j, long j2, String str, String str2, String str3, int r8, zzb zzbVar, Long l) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = str;
        this.zzd = str2;
        this.zze = str3;
        this.zzf = r8;
        this.zzg = zzbVar;
        this.zzh = l;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Session)) {
            return false;
        }
        Session session = (Session) obj;
        if (this.zza == session.zza && this.zzb == session.zzb && Objects.equal(this.zzc, session.zzc) && Objects.equal(this.zzd, session.zzd) && Objects.equal(this.zze, session.zze) && Objects.equal(this.zzg, session.zzg) && this.zzf == session.zzf) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), Long.valueOf(this.zzb), this.zzd});
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelper = new Objects.ToStringHelper(this);
        toStringHelper.add(Long.valueOf(this.zza), "startTime");
        toStringHelper.add(Long.valueOf(this.zzb), "endTime");
        toStringHelper.add(this.zzc, "name");
        toStringHelper.add(this.zzd, FitnessDataKt.oldJsonNameForHistoryDeviceId);
        toStringHelper.add(this.zze, DetailBottomDialog.keyDescription);
        toStringHelper.add(Integer.valueOf(this.zzf), "activity");
        toStringHelper.add(this.zzg, "application");
        return toStringHelper.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r6) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeLong(parcel, 1, this.zza);
        OnTimeoutKt.writeLong(parcel, 2, this.zzb);
        OnTimeoutKt.writeString(parcel, 3, this.zzc);
        OnTimeoutKt.writeString(parcel, 4, this.zzd);
        OnTimeoutKt.writeString(parcel, 5, this.zze);
        OnTimeoutKt.writeInt(parcel, 7, this.zzf);
        OnTimeoutKt.writeParcelable(parcel, 8, this.zzg, r6);
        Long l = this.zzh;
        if (l != null) {
            parcel.writeInt(524297);
            parcel.writeLong(l.longValue());
        }
        OnTimeoutKt.zzb(parcel, zza);
    }
}
