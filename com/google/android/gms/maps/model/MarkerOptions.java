package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class MarkerOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new zzi();
    public final LatLng zza;
    public final String zzb;
    public final String zzc;
    public final BitmapDescriptor zzd;
    public final float zze;
    public final float zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final float zzj;
    public final float zzk;
    public final float zzl;
    public final float zzm;
    public final float zzn;

    public MarkerOptions() {
        this.zze = 0.5f;
        this.zzf = 1.0f;
        this.zzh = true;
        this.zzi = false;
        this.zzj = 0.0f;
        this.zzk = 0.5f;
        this.zzl = 0.0f;
        this.zzm = 1.0f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        IBinder asBinder;
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeParcelable(parcel, 2, this.zza, r5);
        OnTimeoutKt.writeString(parcel, 3, this.zzb);
        OnTimeoutKt.writeString(parcel, 4, this.zzc);
        BitmapDescriptor bitmapDescriptor = this.zzd;
        if (bitmapDescriptor == null) {
            asBinder = null;
        } else {
            asBinder = bitmapDescriptor.zza.asBinder();
        }
        OnTimeoutKt.writeIBinder(parcel, 5, asBinder);
        OnTimeoutKt.writeFloat(parcel, 6, this.zze);
        OnTimeoutKt.writeFloat(parcel, 7, this.zzf);
        OnTimeoutKt.writeBoolean(parcel, 8, this.zzg);
        OnTimeoutKt.writeBoolean(parcel, 9, this.zzh);
        OnTimeoutKt.writeBoolean(parcel, 10, this.zzi);
        OnTimeoutKt.writeFloat(parcel, 11, this.zzj);
        OnTimeoutKt.writeFloat(parcel, 12, this.zzk);
        OnTimeoutKt.writeFloat(parcel, 13, this.zzl);
        OnTimeoutKt.writeFloat(parcel, 14, this.zzm);
        OnTimeoutKt.writeFloat(parcel, 15, this.zzn);
        OnTimeoutKt.zzb(parcel, zza);
    }

    public MarkerOptions(LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6, float f7) {
        this.zze = 0.5f;
        this.zzf = 1.0f;
        this.zzh = true;
        this.zzi = false;
        this.zzj = 0.0f;
        this.zzk = 0.5f;
        this.zzl = 0.0f;
        this.zzm = 1.0f;
        this.zza = latLng;
        this.zzb = str;
        this.zzc = str2;
        if (iBinder == null) {
            this.zzd = null;
        } else {
            this.zzd = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder));
        }
        this.zze = f;
        this.zzf = f2;
        this.zzg = z;
        this.zzh = z2;
        this.zzi = z3;
        this.zzj = f3;
        this.zzk = f4;
        this.zzl = f5;
        this.zzm = f6;
        this.zzn = f7;
    }
}
