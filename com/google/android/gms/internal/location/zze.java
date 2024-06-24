package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zze implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzdq zzdqVar = zzds.zza;
        List list = zzdt.zza;
        int r5 = 0;
        int r6 = 0;
        int r10 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        zzd zzdVar = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    r5 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 2:
                    r6 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 5:
                    r10 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 6:
                    str3 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 7:
                    zzdVar = (zzd) SafeParcelReader.createParcelable(parcel, readInt, zzd.CREATOR);
                    break;
                case '\b':
                    list = SafeParcelReader.createTypedList(parcel, readInt, Feature.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzd(r5, r6, str, str2, str3, r10, list, zzdVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new zzd[r1];
    }
}
