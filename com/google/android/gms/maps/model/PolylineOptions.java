package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.animaconnected.watch.image.Kolors;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class PolylineOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new zzm();
    public final List zza;
    public float zzb;
    public int zzc;
    public final float zzd;
    public final boolean zze;
    public final boolean zzf;
    public boolean zzg;
    public final Cap zzh;
    public final Cap zzi;
    public final int zzj;
    public final List zzk;
    public final List zzl;

    public PolylineOptions() {
        this.zzb = 10.0f;
        this.zzc = Kolors.black;
        this.zzd = 0.0f;
        this.zze = true;
        this.zzf = false;
        this.zzg = false;
        this.zzh = new ButtCap();
        this.zzi = new ButtCap();
        this.zzj = 0;
        this.zzk = null;
        this.zzl = new ArrayList();
        this.zza = new ArrayList();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r15) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeTypedList(parcel, 2, this.zza);
        OnTimeoutKt.writeFloat(parcel, 3, this.zzb);
        OnTimeoutKt.writeInt(parcel, 4, this.zzc);
        OnTimeoutKt.writeFloat(parcel, 5, this.zzd);
        OnTimeoutKt.writeBoolean(parcel, 6, this.zze);
        OnTimeoutKt.writeBoolean(parcel, 7, this.zzf);
        OnTimeoutKt.writeBoolean(parcel, 8, this.zzg);
        OnTimeoutKt.writeParcelable(parcel, 9, this.zzh.zza(), r15);
        OnTimeoutKt.writeParcelable(parcel, 10, this.zzi.zza(), r15);
        OnTimeoutKt.writeInt(parcel, 11, this.zzj);
        OnTimeoutKt.writeTypedList(parcel, 12, this.zzk);
        List<StyleSpan> list = this.zzl;
        ArrayList arrayList = new ArrayList(list.size());
        for (StyleSpan styleSpan : list) {
            StrokeStyle strokeStyle = styleSpan.zza;
            float f = strokeStyle.zza;
            Pair pair = new Pair(Integer.valueOf(strokeStyle.zzb), Integer.valueOf(strokeStyle.zzc));
            arrayList.add(new StyleSpan(new StrokeStyle(this.zzb, ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), this.zze, strokeStyle.zze), styleSpan.zzb));
        }
        OnTimeoutKt.writeTypedList(parcel, 13, arrayList);
        OnTimeoutKt.zzb(parcel, zza);
    }

    public PolylineOptions(ArrayList arrayList, float f, int r5, float f2, boolean z, boolean z2, boolean z3, Cap cap, Cap cap2, int r12, ArrayList arrayList2, ArrayList arrayList3) {
        this.zzb = 10.0f;
        this.zzc = Kolors.black;
        this.zzd = 0.0f;
        this.zze = true;
        this.zzf = false;
        this.zzg = false;
        this.zzh = new ButtCap();
        this.zzi = new ButtCap();
        this.zzj = 0;
        this.zzk = null;
        this.zzl = new ArrayList();
        this.zza = arrayList;
        this.zzb = f;
        this.zzc = r5;
        this.zzd = f2;
        this.zze = z;
        this.zzf = z2;
        this.zzg = z3;
        if (cap != null) {
            this.zzh = cap;
        }
        if (cap2 != null) {
            this.zzi = cap2;
        }
        this.zzj = r12;
        this.zzk = arrayList2;
        if (arrayList3 != null) {
            this.zzl = arrayList3;
        }
    }
}
