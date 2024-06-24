package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.fitness.zzcn;
import com.google.android.gms.internal.fitness.zzco;
import com.google.android.gms.internal.fitness.zzcp;
import com.google.android.gms.internal.fitness.zzes;
import java.util.Arrays;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzl();
    public final DataSet zza;
    public final zzcp zzb;
    public final boolean zzc;

    public zzk(DataSet dataSet, IBinder iBinder, boolean z) {
        zzcp zzcnVar;
        this.zza = dataSet;
        if (iBinder == null) {
            zzcnVar = null;
        } else {
            int r2 = zzco.$r8$clinit;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IStatusCallback");
            zzcnVar = queryLocalInterface instanceof zzcp ? (zzcp) queryLocalInterface : new zzcn(iBinder);
        }
        this.zzb = zzcnVar;
        this.zzc = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzk)) {
            return false;
        }
        if (Objects.equal(this.zza, ((zzk) obj).zza)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelper = new Objects.ToStringHelper(this);
        toStringHelper.add(this.zza, "dataSet");
        return toStringHelper.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        IBinder asBinder;
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeParcelable(parcel, 1, this.zza, r5);
        zzcp zzcpVar = this.zzb;
        if (zzcpVar == null) {
            asBinder = null;
        } else {
            asBinder = zzcpVar.asBinder();
        }
        OnTimeoutKt.writeIBinder(parcel, 2, asBinder);
        OnTimeoutKt.writeBoolean(parcel, 4, this.zzc);
        OnTimeoutKt.zzb(parcel, zza);
    }

    public zzk(DataSet dataSet, zzes zzesVar) {
        this.zza = dataSet;
        this.zzb = zzesVar;
        this.zzc = false;
    }
}
