package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new zan();
    public final int zaa;
    public final int zab;
    public final int zac;
    public final long zad;
    public final long zae;
    public final String zaf;
    public final String zag;
    public final int zah;
    public final int zai;

    public MethodInvocation(int r1, int r2, int r3, long j, long j2, String str, String str2, int r10, int r11) {
        this.zaa = r1;
        this.zab = r2;
        this.zac = r3;
        this.zad = j;
        this.zae = j2;
        this.zaf = str;
        this.zag = str2;
        this.zah = r10;
        this.zai = r11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, this.zaa);
        OnTimeoutKt.writeInt(parcel, 2, this.zab);
        OnTimeoutKt.writeInt(parcel, 3, this.zac);
        OnTimeoutKt.writeLong(parcel, 4, this.zad);
        OnTimeoutKt.writeLong(parcel, 5, this.zae);
        OnTimeoutKt.writeString(parcel, 6, this.zaf);
        OnTimeoutKt.writeString(parcel, 7, this.zag);
        OnTimeoutKt.writeInt(parcel, 8, this.zah);
        OnTimeoutKt.writeInt(parcel, 9, this.zai);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
