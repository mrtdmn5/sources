package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class DataSet extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DataSet> CREATOR = new zzi();
    public final int zza;
    public final DataSource zzb;
    public final ArrayList zzc;
    public final List zzd;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.util.List] */
    public DataSet(int r11, DataSource dataSource, ArrayList arrayList, ArrayList arrayList2) {
        this.zza = r11;
        this.zzb = dataSource;
        this.zzc = new ArrayList(arrayList.size());
        this.zzd = r11 < 2 ? Collections.singletonList(dataSource) : arrayList2;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            RawDataPoint rawDataPoint = (RawDataPoint) it.next();
            ArrayList arrayList3 = this.zzc;
            List list = this.zzd;
            int r1 = rawDataPoint.zzd;
            DataSource dataSource2 = (r1 < 0 || r1 >= list.size()) ? null : (DataSource) list.get(r1);
            Preconditions.checkNotNull(dataSource2);
            int r3 = rawDataPoint.zze;
            arrayList3.add(new DataPoint(dataSource2, rawDataPoint.zza, rawDataPoint.zzb, rawDataPoint.zzc, (r3 < 0 || r3 >= list.size()) ? null : (DataSource) list.get(r3), rawDataPoint.zzf));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x055e, code lost:            r9 = "DataPoint out of range";     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0548, code lost:            if (r14 == 0.0d) goto L349;     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0590  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x05a8  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void add(com.google.android.gms.fitness.data.DataPoint r19) {
        /*
            Method dump skipped, instructions count: 1884
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.DataSet.add(com.google.android.gms.fitness.data.DataPoint):void");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataSet)) {
            return false;
        }
        DataSet dataSet = (DataSet) obj;
        if (Objects.equal(this.zzb, dataSet.zzb) && Objects.equal(this.zzc, dataSet.zzc)) {
            return true;
        }
        return false;
    }

    public final List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb});
    }

    public final String toString() {
        ArrayList zza = zza(this.zzd);
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = this.zzb.zzb();
        ArrayList arrayList = this.zzc;
        Object obj = zza;
        if (arrayList.size() >= 10) {
            obj = String.format(locale, "%d data points, first 5: %s", Integer.valueOf(arrayList.size()), zza.subList(0, 5));
        }
        objArr[1] = obj;
        return String.format(locale, "DataSet{%s %s}", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeParcelable(parcel, 1, this.zzb, r5);
        List list = this.zzd;
        ArrayList zza2 = zza(list);
        int zza3 = OnTimeoutKt.zza(parcel, 3);
        parcel.writeList(zza2);
        OnTimeoutKt.zzb(parcel, zza3);
        OnTimeoutKt.writeTypedList(parcel, 4, list);
        OnTimeoutKt.writeInt(parcel, 1000, this.zza);
        OnTimeoutKt.zzb(parcel, zza);
    }

    public final ArrayList zza(List list) {
        ArrayList arrayList = this.zzc;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new RawDataPoint((DataPoint) it.next(), list));
        }
        return arrayList2;
    }

    public DataSet(DataSource dataSource) {
        this.zza = 3;
        Preconditions.checkNotNull(dataSource);
        this.zzb = dataSource;
        this.zzc = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.zzd = arrayList;
        arrayList.add(dataSource);
    }
}
