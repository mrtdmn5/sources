package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zzd;
import com.google.android.gms.internal.location.zzdj;
import java.util.Arrays;
import kotlinx.coroutines.selects.OnTimeoutKt;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzx();
    public final int zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final int zzf;
    public final float zzg;
    public final boolean zzh;
    public final long zzi;
    public final int zzj;
    public final int zzk;
    public final String zzl;
    public final boolean zzm;
    public final WorkSource zzn;
    public final zzd zzo;

    /* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
    /* loaded from: classes3.dex */
    public static final class Builder {
        public int zza;
        public final long zzb;
        public final long zzc;
        public final long zzd;
        public final long zze;
        public final int zzf;
        public final float zzg;
        public boolean zzh;
        public long zzi;
        public int zzj;
        public int zzk;
        public String zzl;
        public boolean zzm;
        public WorkSource zzn;
        public final zzd zzo;

        public Builder(long j) {
            Preconditions.checkArgument("intervalMillis must be greater than or equal to 0", j >= 0);
            this.zzb = j;
            this.zza = 102;
            this.zzc = -1L;
            this.zzd = 0L;
            this.zze = Long.MAX_VALUE;
            this.zzf = Integer.MAX_VALUE;
            this.zzg = 0.0f;
            this.zzh = true;
            this.zzi = -1L;
            this.zzj = 0;
            this.zzk = 0;
            this.zzl = null;
            this.zzm = false;
            this.zzn = null;
            this.zzo = null;
        }

        public final LocationRequest build() {
            long j;
            int r2 = this.zza;
            long j2 = this.zzb;
            long j3 = this.zzc;
            if (j3 == -1) {
                j3 = j2;
            } else if (r2 != 105) {
                j3 = Math.min(j3, j2);
            }
            long j4 = this.zzd;
            long j5 = this.zzb;
            long max = Math.max(j4, j5);
            long j6 = this.zze;
            int r15 = this.zzf;
            float f = this.zzg;
            boolean z = this.zzh;
            long j7 = this.zzi;
            if (j7 == -1) {
                j = j5;
            } else {
                j = j7;
            }
            return new LocationRequest(r2, j2, j3, max, Long.MAX_VALUE, j6, r15, f, z, j, this.zzj, this.zzk, this.zzl, this.zzm, new WorkSource(this.zzn), this.zzo);
        }

        public final void setPriority(int r4) {
            int r0;
            boolean z = true;
            if (r4 != 100 && r4 != 102 && r4 != 104) {
                r0 = 105;
                if (r4 != 105) {
                    z = false;
                }
                Preconditions.checkArgument(z, "priority %d must be a Priority.PRIORITY_* constant", Integer.valueOf(r0));
                this.zza = r4;
            }
            r0 = r4;
            Preconditions.checkArgument(z, "priority %d must be a Priority.PRIORITY_* constant", Integer.valueOf(r0));
            this.zza = r4;
        }

        public Builder(LocationRequest locationRequest) {
            this.zza = locationRequest.zza;
            this.zzb = locationRequest.zzb;
            this.zzc = locationRequest.zzc;
            this.zzd = locationRequest.zzd;
            this.zze = locationRequest.zze;
            this.zzf = locationRequest.zzf;
            this.zzg = locationRequest.zzg;
            this.zzh = locationRequest.zzh;
            this.zzi = locationRequest.zzi;
            this.zzj = locationRequest.zzj;
            this.zzk = locationRequest.zzk;
            this.zzl = locationRequest.zzl;
            this.zzm = locationRequest.zzm;
            this.zzn = locationRequest.zzn;
            this.zzo = locationRequest.zzo;
        }
    }

    @Deprecated
    public LocationRequest() {
        this(102, 3600000L, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, 0.0f, true, 3600000L, 0, 0, null, false, new WorkSource(), null);
    }

    public static String zzf(long j) {
        String sb;
        if (j == Long.MAX_VALUE) {
            return "∞";
        }
        StringBuilder sb2 = zzdj.zzc;
        synchronized (sb2) {
            sb2.setLength(0);
            zzdj.zzb(j, sb2);
            sb = sb2.toString();
        }
        return sb;
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            int r0 = locationRequest.zza;
            int r2 = this.zza;
            if (r2 == r0) {
                if (r2 == 105) {
                    z = true;
                } else {
                    z = false;
                }
                if ((z || this.zzb == locationRequest.zzb) && this.zzc == locationRequest.zzc && isBatched() == locationRequest.isBatched() && ((!isBatched() || this.zzd == locationRequest.zzd) && this.zze == locationRequest.zze && this.zzf == locationRequest.zzf && this.zzg == locationRequest.zzg && this.zzh == locationRequest.zzh && this.zzj == locationRequest.zzj && this.zzk == locationRequest.zzk && this.zzm == locationRequest.zzm && this.zzn.equals(locationRequest.zzn) && Objects.equal(this.zzl, locationRequest.zzl) && Objects.equal(this.zzo, locationRequest.zzo))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Long.valueOf(this.zzb), Long.valueOf(this.zzc), this.zzn});
    }

    @Pure
    public final boolean isBatched() {
        long j = this.zzd;
        if (j > 0 && (j >> 1) >= this.zzb) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.LocationRequest.toString():java.lang.String");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r6) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, this.zza);
        OnTimeoutKt.writeLong(parcel, 2, this.zzb);
        OnTimeoutKt.writeLong(parcel, 3, this.zzc);
        OnTimeoutKt.writeInt(parcel, 6, this.zzf);
        OnTimeoutKt.writeFloat(parcel, 7, this.zzg);
        OnTimeoutKt.writeLong(parcel, 8, this.zzd);
        OnTimeoutKt.writeBoolean(parcel, 9, this.zzh);
        OnTimeoutKt.writeLong(parcel, 10, this.zze);
        OnTimeoutKt.writeLong(parcel, 11, this.zzi);
        OnTimeoutKt.writeInt(parcel, 12, this.zzj);
        OnTimeoutKt.writeInt(parcel, 13, this.zzk);
        OnTimeoutKt.writeString(parcel, 14, this.zzl);
        OnTimeoutKt.writeBoolean(parcel, 15, this.zzm);
        OnTimeoutKt.writeParcelable(parcel, 16, this.zzn, r6);
        OnTimeoutKt.writeParcelable(parcel, 17, this.zzo, r6);
        OnTimeoutKt.zzb(parcel, zza);
    }

    public LocationRequest(int r8, long j, long j2, long j3, long j4, long j5, int r19, float f, boolean z, long j6, int r24, int r25, String str, boolean z2, WorkSource workSource, zzd zzdVar) {
        this.zza = r8;
        long j7 = j;
        this.zzb = j7;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = j4 == Long.MAX_VALUE ? j5 : Math.min(Math.max(1L, j4 - SystemClock.elapsedRealtime()), j5);
        this.zzf = r19;
        this.zzg = f;
        this.zzh = z;
        this.zzi = j6 != -1 ? j6 : j7;
        this.zzj = r24;
        this.zzk = r25;
        this.zzl = str;
        this.zzm = z2;
        this.zzn = workSource;
        this.zzo = zzdVar;
    }
}
