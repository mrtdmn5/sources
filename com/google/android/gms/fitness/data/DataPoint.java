package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class DataPoint extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DataPoint> CREATOR = new zzg();
    public final DataSource zza;
    public long zzb;
    public long zzc;
    public final Value[] zzd;
    public final DataSource zze;
    public final long zzf;

    public DataPoint(DataSource dataSource) {
        if (dataSource != null) {
            this.zza = dataSource;
            List list = dataSource.zzc.zzu;
            this.zzd = new Value[list.size()];
            Iterator it = list.iterator();
            int r0 = 0;
            while (it.hasNext()) {
                this.zzd[r0] = new Value(((Field) it.next()).zzB, false, 0.0f, null, null, null, null, null);
                r0++;
            }
            this.zzf = 0L;
            return;
        }
        throw new NullPointerException("Data source cannot be null");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataPoint)) {
            return false;
        }
        DataPoint dataPoint = (DataPoint) obj;
        DataSource dataSource = dataPoint.zza;
        DataSource dataSource2 = this.zza;
        if (Objects.equal(dataSource2, dataSource) && this.zzb == dataPoint.zzb && this.zzc == dataPoint.zzc && Arrays.equals(this.zzd, dataPoint.zzd)) {
            DataSource dataSource3 = this.zze;
            if (dataSource3 != null) {
                dataSource2 = dataSource3;
            }
            DataSource dataSource4 = dataPoint.zze;
            if (dataSource4 == null) {
                dataSource4 = dataPoint.zza;
            }
            if (Objects.equal(dataSource2, dataSource4)) {
                return true;
            }
        }
        return false;
    }

    public final Value getValue(Field field) {
        boolean z;
        DataType dataType = this.zza.zzc;
        int indexOf = dataType.zzu.indexOf(field);
        if (indexOf >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "%s not a field of %s", field, dataType);
        return this.zzd[indexOf];
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Long.valueOf(this.zzb), Long.valueOf(this.zzc)});
    }

    public final String toString() {
        String str;
        Object[] objArr = new Object[6];
        objArr[0] = Arrays.toString(this.zzd);
        objArr[1] = Long.valueOf(this.zzc);
        objArr[2] = Long.valueOf(this.zzb);
        objArr[3] = Long.valueOf(this.zzf);
        objArr[4] = this.zza.zzb();
        DataSource dataSource = this.zze;
        if (dataSource != null) {
            str = dataSource.zzb();
        } else {
            str = "N/A";
        }
        objArr[5] = str;
        return String.format("DataPoint{%s@[%s, %s,raw=%s](%s %s)}", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r6) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeParcelable(parcel, 1, this.zza, r6);
        OnTimeoutKt.writeLong(parcel, 3, this.zzb);
        OnTimeoutKt.writeLong(parcel, 4, this.zzc);
        OnTimeoutKt.writeTypedArray(parcel, 5, this.zzd, r6);
        OnTimeoutKt.writeParcelable(parcel, 6, this.zze, r6);
        OnTimeoutKt.writeLong(parcel, 7, this.zzf);
        OnTimeoutKt.zzb(parcel, zza);
    }

    public final Value zzc(int r4) {
        DataType dataType = this.zza.zzc;
        boolean z = false;
        if (r4 >= 0 && r4 < dataType.zzu.size()) {
            z = true;
        }
        Preconditions.checkArgument(z, "fieldIndex %s is out of range for %s", Integer.valueOf(r4), dataType);
        return this.zzd[r4];
    }

    public DataPoint(DataSource dataSource, long j, long j2, Value[] valueArr, DataSource dataSource2, long j3) {
        this.zza = dataSource;
        this.zze = dataSource2;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = valueArr;
        this.zzf = j3;
    }
}
