package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new zaw();
    public final int zaa;
    public final IBinder zab;
    public final ConnectionResult zac;
    public final boolean zad;
    public final boolean zae;

    public zav(int r1, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.zaa = r1;
        this.zab = iBinder;
        this.zac = connectionResult;
        this.zad = z;
        this.zae = z2;
    }

    public final boolean equals(Object obj) {
        Object zzvVar;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zavVar = (zav) obj;
        if (this.zac.equals(zavVar.zac)) {
            Object obj2 = null;
            IBinder iBinder = this.zab;
            if (iBinder == null) {
                zzvVar = null;
            } else {
                int r5 = IAccountAccessor.Stub.$r8$clinit;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                if (queryLocalInterface instanceof IAccountAccessor) {
                    zzvVar = (IAccountAccessor) queryLocalInterface;
                } else {
                    zzvVar = new zzv(iBinder);
                }
            }
            IBinder iBinder2 = zavVar.zab;
            if (iBinder2 != null) {
                int r2 = IAccountAccessor.Stub.$r8$clinit;
                IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                if (queryLocalInterface2 instanceof IAccountAccessor) {
                    obj2 = (IAccountAccessor) queryLocalInterface2;
                } else {
                    obj2 = new zzv(iBinder2);
                }
            }
            if (Objects.equal(zzvVar, obj2)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, this.zaa);
        OnTimeoutKt.writeIBinder(parcel, 2, this.zab);
        OnTimeoutKt.writeParcelable(parcel, 3, this.zac, r5);
        OnTimeoutKt.writeBoolean(parcel, 4, this.zad);
        OnTimeoutKt.writeBoolean(parcel, 5, this.zae);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
