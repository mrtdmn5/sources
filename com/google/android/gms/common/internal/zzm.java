package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzm implements Parcelable.Creator {
    public static void zza(GetServiceRequest getServiceRequest, Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, getServiceRequest.zzc);
        OnTimeoutKt.writeInt(parcel, 2, getServiceRequest.zzd);
        OnTimeoutKt.writeInt(parcel, 3, getServiceRequest.zze);
        OnTimeoutKt.writeString(parcel, 4, getServiceRequest.zzf);
        OnTimeoutKt.writeIBinder(parcel, 5, getServiceRequest.zzg);
        OnTimeoutKt.writeTypedArray(parcel, 6, getServiceRequest.zzh, r5);
        OnTimeoutKt.writeBundle(parcel, 7, getServiceRequest.zzi);
        OnTimeoutKt.writeParcelable(parcel, 8, getServiceRequest.zzj, r5);
        OnTimeoutKt.writeTypedArray(parcel, 10, getServiceRequest.zzk, r5);
        OnTimeoutKt.writeTypedArray(parcel, 11, getServiceRequest.zzl, r5);
        OnTimeoutKt.writeBoolean(parcel, 12, getServiceRequest.zzm);
        OnTimeoutKt.writeInt(parcel, 13, getServiceRequest.zzn);
        OnTimeoutKt.writeBoolean(parcel, 14, getServiceRequest.zzo);
        OnTimeoutKt.writeString(parcel, 15, getServiceRequest.zzp);
        OnTimeoutKt.zzb(parcel, zza);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Scope[] scopeArr = GetServiceRequest.zza;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.zzb;
        Feature[] featureArr2 = featureArr;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        boolean z = false;
        int r19 = 0;
        boolean z2 = false;
        String str = null;
        IBinder iBinder = null;
        Account account = null;
        String str2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    r8 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 2:
                    r9 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 3:
                    r10 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 5:
                    iBinder = SafeParcelReader.readIBinder(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.createTypedArray(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.createBundle(parcel, readInt);
                    break;
                case '\b':
                    account = (Account) SafeParcelReader.createParcelable(parcel, readInt, Account.CREATOR);
                    break;
                case '\t':
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
                case '\n':
                    featureArr = (Feature[]) SafeParcelReader.createTypedArray(parcel, readInt, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.createTypedArray(parcel, readInt, Feature.CREATOR);
                    break;
                case '\f':
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case '\r':
                    r19 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 14:
                    z2 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 15:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new GetServiceRequest(r8, r9, r10, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z, r19, z2, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new GetServiceRequest[r1];
    }
}
