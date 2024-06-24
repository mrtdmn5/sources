package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.animaconnected.watch.image.Kolors;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class CircleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CircleOptions> CREATOR = new zzc();
    public LatLng zza;
    public double zzb;
    public float zzc;
    public int zzd;
    public int zze;
    public final float zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final List zzi;

    public CircleOptions() {
        this.zza = null;
        this.zzb = 0.0d;
        this.zzc = 10.0f;
        this.zzd = Kolors.black;
        this.zze = 0;
        this.zzf = 0.0f;
        this.zzg = true;
        this.zzh = false;
        this.zzi = null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeParcelable(parcel, 2, this.zza, r5);
        double d = this.zzb;
        parcel.writeInt(524291);
        parcel.writeDouble(d);
        OnTimeoutKt.writeFloat(parcel, 4, this.zzc);
        OnTimeoutKt.writeInt(parcel, 5, this.zzd);
        OnTimeoutKt.writeInt(parcel, 6, this.zze);
        OnTimeoutKt.writeFloat(parcel, 7, this.zzf);
        OnTimeoutKt.writeBoolean(parcel, 8, this.zzg);
        OnTimeoutKt.writeBoolean(parcel, 9, this.zzh);
        OnTimeoutKt.writeTypedList(parcel, 10, this.zzi);
        OnTimeoutKt.zzb(parcel, zza);
    }

    public CircleOptions(LatLng latLng, double d, float f, int r5, int r6, float f2, boolean z, boolean z2, ArrayList arrayList) {
        this.zza = latLng;
        this.zzb = d;
        this.zzc = f;
        this.zzd = r5;
        this.zze = r6;
        this.zzf = f2;
        this.zzg = z;
        this.zzh = z2;
        this.zzi = arrayList;
    }
}
