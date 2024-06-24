package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
@KeepName
/* loaded from: classes3.dex */
public final class RawDataPoint extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RawDataPoint> CREATOR = new zzz();
    public final long zza;
    public final long zzb;
    public final Value[] zzc;
    public final int zzd;
    public final int zze;
    public final long zzf;

    public RawDataPoint(long j, long j2, Value[] valueArr, int r6, int r7, long j3) {
        this.zza = j;
        this.zzb = j2;
        this.zzd = r6;
        this.zze = r7;
        this.zzf = j3;
        this.zzc = valueArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RawDataPoint)) {
            return false;
        }
        RawDataPoint rawDataPoint = (RawDataPoint) obj;
        if (this.zza == rawDataPoint.zza && this.zzb == rawDataPoint.zzb && Arrays.equals(this.zzc, rawDataPoint.zzc) && this.zzd == rawDataPoint.zzd && this.zze == rawDataPoint.zze && this.zzf == rawDataPoint.zzf) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), Long.valueOf(this.zzb)});
    }

    public final String toString() {
        return String.format(Locale.US, "RawDataPoint{%s@[%s, %s](%d,%d)}", Arrays.toString(this.zzc), Long.valueOf(this.zzb), Long.valueOf(this.zza), Integer.valueOf(this.zzd), Integer.valueOf(this.zze));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r6) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeLong(parcel, 1, this.zza);
        OnTimeoutKt.writeLong(parcel, 2, this.zzb);
        OnTimeoutKt.writeTypedArray(parcel, 3, this.zzc, r6);
        OnTimeoutKt.writeInt(parcel, 4, this.zzd);
        OnTimeoutKt.writeInt(parcel, 5, this.zze);
        OnTimeoutKt.writeLong(parcel, 6, this.zzf);
        OnTimeoutKt.zzb(parcel, zza);
    }

    public RawDataPoint(DataPoint dataPoint, List list) {
        int indexOf;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        this.zza = timeUnit.convert(dataPoint.zzb, timeUnit);
        this.zzb = timeUnit.convert(dataPoint.zzc, timeUnit);
        this.zzc = dataPoint.zzd;
        int r0 = -1;
        DataSource dataSource = dataPoint.zza;
        if (dataSource == null) {
            indexOf = -1;
        } else {
            indexOf = list.indexOf(dataSource);
            if (indexOf < 0) {
                list.add(dataSource);
                indexOf = list.size() - 1;
            }
        }
        this.zzd = indexOf;
        DataSource dataSource2 = dataPoint.zze;
        if (dataSource2 != null) {
            int indexOf2 = list.indexOf(dataSource2);
            if (indexOf2 >= 0) {
                r0 = indexOf2;
            } else {
                list.add(dataSource2);
                r0 = (-1) + list.size();
            }
        }
        this.zze = r0;
        this.zzf = dataPoint.zzf;
    }
}
