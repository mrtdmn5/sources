package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.fitness.zzcn;
import com.google.android.gms.internal.fitness.zzco;
import com.google.android.gms.internal.fitness.zzcp;
import com.google.android.gms.internal.fitness.zzes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class SessionInsertRequest extends AbstractSafeParcelable {
    public final Session zzb;
    public final List zzc;
    public final List zzd;
    public final zzcp zze;
    public static final TimeUnit zza = TimeUnit.MILLISECONDS;
    public static final Parcelable.Creator<SessionInsertRequest> CREATOR = new zzap();

    /* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
    /* loaded from: classes3.dex */
    public static class Builder {
        public Session zza;
        public final ArrayList zzb = new ArrayList();
        public final ArrayList zzc = new ArrayList();
        public final ArrayList zzd = new ArrayList();

        public final void addDataSet(DataSet dataSet) {
            boolean z;
            if (dataSet != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument("Must specify a valid data set.", z);
            DataSource dataSource = dataSet.zzb;
            ArrayList arrayList = this.zzd;
            Object[] objArr = {dataSource};
            if (!arrayList.contains(dataSource)) {
                Preconditions.checkArgument("No data points specified in the input data set.", true ^ dataSet.getDataPoints().isEmpty());
                arrayList.add(dataSource);
                this.zzb.add(dataSet);
                return;
            }
            throw new IllegalStateException(String.format("Data set for this data source %s is already added.", objArr));
        }

        public final SessionInsertRequest build() {
            boolean z;
            boolean z2 = true;
            if (this.zza != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState("Must specify a valid session.", z);
            Session session = this.zza;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (timeUnit.convert(session.zzb, timeUnit) == 0) {
                z2 = false;
            }
            Preconditions.checkState("Must specify a valid end time, cannot insert a continuing session.", z2);
            ArrayList arrayList = this.zzb;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                for (DataPoint dataPoint : ((DataSet) it.next()).getDataPoints()) {
                    zzb(dataPoint);
                    zza(dataPoint);
                }
            }
            ArrayList arrayList2 = this.zzc;
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                DataPoint dataPoint2 = (DataPoint) it2.next();
                zzb(dataPoint2);
                zza(dataPoint2);
            }
            return new SessionInsertRequest(this.zza, (List) arrayList, (List) arrayList2, (zzes) null);
        }

        public final void zza(DataPoint dataPoint) {
            boolean z;
            Session session = this.zza;
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long j = session.zza;
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            long convert = timeUnit.convert(j, timeUnit2);
            long convert2 = timeUnit.convert(this.zza.zzb, timeUnit2);
            long convert3 = timeUnit.convert(dataPoint.zzc, timeUnit);
            long convert4 = timeUnit.convert(dataPoint.zzb, timeUnit);
            if (convert3 != 0 && convert4 != 0) {
                if (convert4 > convert2) {
                    TimeUnit timeUnit3 = SessionInsertRequest.zza;
                    convert4 = timeUnit.convert(timeUnit3.convert(convert4, timeUnit), timeUnit3);
                }
                if (convert3 >= convert && convert4 <= convert2) {
                    z = true;
                } else {
                    z = false;
                }
                Object[] objArr = {dataPoint, Long.valueOf(convert), Long.valueOf(convert2)};
                if (z) {
                    if (convert4 != timeUnit.convert(dataPoint.zzb, timeUnit)) {
                        Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", Long.valueOf(timeUnit.convert(dataPoint.zzb, timeUnit)), Long.valueOf(convert4), SessionInsertRequest.zza));
                        dataPoint.zzc = timeUnit.toNanos(convert3);
                        dataPoint.zzb = timeUnit.toNanos(convert4);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException(String.format("Data point %s has start and end times outside session interval [%d, %d]", objArr));
            }
        }

        public final void zzb(DataPoint dataPoint) {
            boolean z;
            Session session = this.zza;
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long j = session.zza;
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            long convert = timeUnit.convert(j, timeUnit2);
            long convert2 = timeUnit.convert(this.zza.zzb, timeUnit2);
            long convert3 = timeUnit.convert(dataPoint.zzb, timeUnit);
            if (convert3 != 0) {
                if (convert3 < convert || convert3 > convert2) {
                    TimeUnit timeUnit3 = SessionInsertRequest.zza;
                    convert3 = timeUnit.convert(timeUnit3.convert(convert3, timeUnit), timeUnit3);
                }
                if (convert3 >= convert && convert3 <= convert2) {
                    z = true;
                } else {
                    z = false;
                }
                Object[] objArr = {dataPoint, Long.valueOf(convert), Long.valueOf(convert2)};
                if (z) {
                    if (timeUnit.convert(dataPoint.zzb, timeUnit) != convert3) {
                        Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", Long.valueOf(timeUnit.convert(dataPoint.zzb, timeUnit)), Long.valueOf(convert3), SessionInsertRequest.zza));
                        dataPoint.zzb = timeUnit.toNanos(convert3);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException(String.format("Data point %s has time stamp outside session interval [%d, %d]", objArr));
            }
        }
    }

    public SessionInsertRequest(Session session, ArrayList arrayList, ArrayList arrayList2, IBinder iBinder) {
        zzcp zzcnVar;
        this.zzb = session;
        this.zzc = Collections.unmodifiableList(arrayList);
        this.zzd = Collections.unmodifiableList(arrayList2);
        if (iBinder == null) {
            zzcnVar = null;
        } else {
            int r1 = zzco.$r8$clinit;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IStatusCallback");
            zzcnVar = queryLocalInterface instanceof zzcp ? (zzcp) queryLocalInterface : new zzcn(iBinder);
        }
        this.zze = zzcnVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SessionInsertRequest)) {
            return false;
        }
        SessionInsertRequest sessionInsertRequest = (SessionInsertRequest) obj;
        if (Objects.equal(this.zzb, sessionInsertRequest.zzb) && Objects.equal(this.zzc, sessionInsertRequest.zzc) && Objects.equal(this.zzd, sessionInsertRequest.zzd)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, this.zzc, this.zzd});
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelper = new Objects.ToStringHelper(this);
        toStringHelper.add(this.zzb, "session");
        toStringHelper.add(this.zzc, "dataSets");
        toStringHelper.add(this.zzd, "aggregateDataPoints");
        return toStringHelper.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        IBinder asBinder;
        int zza2 = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeParcelable(parcel, 1, this.zzb, r5);
        OnTimeoutKt.writeTypedList(parcel, 2, this.zzc);
        OnTimeoutKt.writeTypedList(parcel, 3, this.zzd);
        zzcp zzcpVar = this.zze;
        if (zzcpVar == null) {
            asBinder = null;
        } else {
            asBinder = zzcpVar.asBinder();
        }
        OnTimeoutKt.writeIBinder(parcel, 4, asBinder);
        OnTimeoutKt.zzb(parcel, zza2);
    }

    public SessionInsertRequest(Session session, List list, List list2, zzes zzesVar) {
        this.zzb = session;
        this.zzc = Collections.unmodifiableList(list);
        this.zzd = Collections.unmodifiableList(list2);
        this.zze = zzesVar;
    }
}
