package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzax implements Parcelable.Creator {
    public static void zza(zzaw zzawVar, Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeString(parcel, 2, zzawVar.zza);
        OnTimeoutKt.writeParcelable(parcel, 3, zzawVar.zzb, r5);
        OnTimeoutKt.writeString(parcel, 4, zzawVar.zzc);
        OnTimeoutKt.writeLong(parcel, 5, zzawVar.zzd);
        OnTimeoutKt.zzb(parcel, zza);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        zzau zzauVar = null;
        String str2 = null;
        long j = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 2) {
                if (c != 3) {
                    if (c != 4) {
                        if (c != 5) {
                            SafeParcelReader.skipUnknownField(parcel, readInt);
                        } else {
                            j = SafeParcelReader.readLong(parcel, readInt);
                        }
                    } else {
                        str2 = SafeParcelReader.createString(parcel, readInt);
                    }
                } else {
                    zzauVar = (zzau) SafeParcelReader.createParcelable(parcel, readInt, zzau.CREATOR);
                }
            } else {
                str = SafeParcelReader.createString(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzaw(str, zzauVar, str2, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new zzaw[r1];
    }
}
