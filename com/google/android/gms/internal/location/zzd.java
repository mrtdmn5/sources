package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.font.FontWeightKt;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.List;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    public final int zza;
    public final int zzb;
    public final String zzc;
    public final String zzd;
    public final int zze;
    public final String zzf;
    public final zzd zzg;
    public final zzds zzh;

    static {
        Process.myUid();
        Process.myPid();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zzd(int r1, int r2, String str, String str2, String str3, int r6, List list, zzd zzdVar) {
        zzdt zzdtVar;
        zzds zzdsVar;
        this.zza = r1;
        this.zzb = r2;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = str3;
        this.zze = r6;
        zzdq zzdqVar = zzds.zza;
        if (list instanceof zzdp) {
            zzdsVar = ((zzdp) list).zzd();
            if (zzdsVar.zzf()) {
                Object[] array = zzdsVar.toArray();
                int length = array.length;
                if (length == 0) {
                    zzdsVar = zzdt.zza;
                } else {
                    zzdtVar = new zzdt(length, array);
                    zzdsVar = zzdtVar;
                }
            }
            this.zzh = zzdsVar;
            this.zzg = zzdVar;
        }
        Object[] array2 = list.toArray();
        int length2 = array2.length;
        for (int r3 = 0; r3 < length2; r3++) {
            if (array2[r3] == null) {
                throw new NullPointerException(SubMenuBuilder$$ExternalSyntheticOutline0.m("at index ", r3));
            }
        }
        if (length2 == 0) {
            zzdsVar = zzdt.zza;
            this.zzh = zzdsVar;
            this.zzg = zzdVar;
        } else {
            zzdtVar = new zzdt(length2, array2);
            zzdsVar = zzdtVar;
            this.zzh = zzdsVar;
            this.zzg = zzdVar;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzd) {
            zzd zzdVar = (zzd) obj;
            if (this.zza == zzdVar.zza && this.zzb == zzdVar.zzb && this.zze == zzdVar.zze && this.zzc.equals(zzdVar.zzc) && FontWeightKt.zza(this.zzd, zzdVar.zzd) && FontWeightKt.zza(this.zzf, zzdVar.zzf) && FontWeightKt.zza(this.zzg, zzdVar.zzg) && this.zzh.equals(zzdVar.zzh)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), this.zzc, this.zzd, this.zzf});
    }

    public final String toString() {
        String str = this.zzc;
        int length = str.length() + 18;
        String str2 = this.zzd;
        if (str2 != null) {
            length += str2.length();
        }
        StringBuilder sb = new StringBuilder(length);
        sb.append(this.zza);
        sb.append("/");
        sb.append(str);
        if (str2 != null) {
            sb.append("[");
            if (str2.startsWith(str)) {
                sb.append((CharSequence) str2, str.length(), str2.length());
            } else {
                sb.append(str2);
            }
            sb.append("]");
        }
        String str3 = this.zzf;
        if (str3 != null) {
            sb.append("/");
            sb.append(Integer.toHexString(str3.hashCode()));
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, this.zza);
        OnTimeoutKt.writeInt(parcel, 2, this.zzb);
        OnTimeoutKt.writeString(parcel, 3, this.zzc);
        OnTimeoutKt.writeString(parcel, 4, this.zzd);
        OnTimeoutKt.writeInt(parcel, 5, this.zze);
        OnTimeoutKt.writeString(parcel, 6, this.zzf);
        OnTimeoutKt.writeParcelable(parcel, 7, this.zzg, r5);
        OnTimeoutKt.writeTypedList(parcel, 8, this.zzh);
        OnTimeoutKt.zzb(parcel, zza);
    }
}
