package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Locale;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class DataSource extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataSource> CREATOR;
    public static final String zza;
    public static final String zzb;
    public final DataType zzc;
    public final int zzd;
    public final Device zze;
    public final zzb zzf;
    public final String zzg;
    public final String zzh;

    static {
        Locale locale = Locale.ROOT;
        zza = "RAW".toLowerCase(locale);
        zzb = "DERIVED".toLowerCase(locale);
        CREATOR = new zzj();
    }

    public DataSource(DataType dataType, int r3, Device device, zzb zzbVar, String str) {
        String str2;
        this.zzc = dataType;
        this.zzd = r3;
        this.zze = device;
        this.zzf = zzbVar;
        this.zzg = str;
        StringBuilder sb = new StringBuilder();
        if (r3 != 0) {
            str2 = zzb;
        } else {
            str2 = zza;
        }
        sb.append(str2);
        sb.append(":");
        sb.append(dataType.zzt);
        if (zzbVar != null) {
            sb.append(":");
            sb.append(zzbVar.zzb);
        }
        if (device != null) {
            sb.append(":");
            sb.append(String.format("%s:%s:%s", device.zza, device.zzb, device.zzc));
        }
        if (str != null) {
            sb.append(":");
            sb.append(str);
        }
        this.zzh = sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataSource)) {
            return false;
        }
        return this.zzh.equals(((DataSource) obj).zzh);
    }

    public final int hashCode() {
        return this.zzh.hashCode();
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("DataSource{");
        if (this.zzd != 0) {
            str = zzb;
        } else {
            str = zza;
        }
        sb.append(str);
        zzb zzbVar = this.zzf;
        if (zzbVar != null) {
            sb.append(":");
            sb.append(zzbVar);
        }
        Device device = this.zze;
        if (device != null) {
            sb.append(":");
            sb.append(device);
        }
        String str2 = this.zzg;
        if (str2 != null) {
            sb.append(":");
            sb.append(str2);
        }
        sb.append(":");
        sb.append(this.zzc);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r5) {
        int zza2 = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeParcelable(parcel, 1, this.zzc, r5);
        OnTimeoutKt.writeInt(parcel, 3, this.zzd);
        OnTimeoutKt.writeParcelable(parcel, 4, this.zze, r5);
        OnTimeoutKt.writeParcelable(parcel, 5, this.zzf, r5);
        OnTimeoutKt.writeString(parcel, 6, this.zzg);
        OnTimeoutKt.zzb(parcel, zza2);
    }

    public final String zzb() {
        String str;
        String concat;
        String str2;
        int r0 = this.zzd;
        if (r0 != 0) {
            if (r0 != 1) {
                str = "?";
            } else {
                str = DateTimeFormattersKt.dayInMonthFormat;
            }
        } else {
            str = "r";
        }
        String str3 = this.zzc.zzt;
        if (str3.startsWith("com.google.")) {
            str3 = str3.substring(11);
        }
        zzb zzbVar = this.zzf;
        String str4 = "";
        if (zzbVar == null) {
            concat = "";
        } else if (zzbVar.equals(zzb.zza)) {
            concat = ":gms";
        } else {
            concat = ":".concat(String.valueOf(zzbVar.zzb));
        }
        Device device = this.zze;
        if (device == null) {
            str2 = "";
        } else {
            str2 = ":" + device.zzb + ":" + device.zzc;
        }
        String str5 = this.zzg;
        if (str5 != null) {
            str4 = ":".concat(str5);
        }
        return str + ":" + str3 + concat + str2 + str4;
    }
}
