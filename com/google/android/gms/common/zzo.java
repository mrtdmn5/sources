package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final Context zzd;
    public final boolean zze;

    public zzo(String str, boolean z, boolean z2, IBinder iBinder, boolean z3) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = (Context) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zze = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeString(parcel, 1, this.zza);
        OnTimeoutKt.writeBoolean(parcel, 2, this.zzb);
        OnTimeoutKt.writeBoolean(parcel, 3, this.zzc);
        OnTimeoutKt.writeIBinder(parcel, 4, new ObjectWrapper(this.zzd));
        OnTimeoutKt.writeBoolean(parcel, 5, this.zze);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
