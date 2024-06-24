package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class Value extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Value> CREATOR = new zzak();
    public final int zza;
    public boolean zzb;
    public float zzc;
    public final String zzd;
    public final ArrayMap zze;
    public final int[] zzf;
    public final float[] zzg;
    public final byte[] zzh;

    public Value(int r1, boolean z, float f, String str, Bundle bundle, int[] r6, float[] fArr, byte[] bArr) {
        ArrayMap arrayMap;
        this.zza = r1;
        this.zzb = z;
        this.zzc = f;
        this.zzd = str;
        if (bundle == null) {
            arrayMap = null;
        } else {
            ClassLoader classLoader = MapValue.class.getClassLoader();
            Preconditions.checkNotNull(classLoader);
            bundle.setClassLoader(classLoader);
            arrayMap = new ArrayMap(bundle.size());
            for (String str2 : bundle.keySet()) {
                MapValue mapValue = (MapValue) bundle.getParcelable(str2);
                Preconditions.checkNotNull(mapValue);
                arrayMap.put(str2, mapValue);
            }
        }
        this.zze = arrayMap;
        this.zzf = r6;
        this.zzg = fArr;
        this.zzh = bArr;
    }

    public final int asInt() {
        boolean z = true;
        if (this.zza != 1) {
            z = false;
        }
        Preconditions.checkState("Value is not in int format", z);
        return Float.floatToRawIntBits(this.zzc);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value)) {
            return false;
        }
        Value value = (Value) obj;
        int r1 = value.zza;
        int r3 = this.zza;
        if (r3 == r1 && this.zzb == value.zzb) {
            if (r3 != 1) {
                if (r3 != 3) {
                    if (r3 != 4) {
                        if (r3 != 5) {
                            if (r3 != 6) {
                                if (r3 != 7) {
                                    if (this.zzc == value.zzc) {
                                        return true;
                                    }
                                    return false;
                                }
                                return Arrays.equals(this.zzh, value.zzh);
                            }
                            return Arrays.equals(this.zzg, value.zzg);
                        }
                        return Arrays.equals(this.zzf, value.zzf);
                    }
                    return Objects.equal(this.zze, value.zze);
                }
                return Objects.equal(this.zzd, value.zzd);
            }
            if (asInt() == value.asInt()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.zzc), this.zzd, this.zze, this.zzf, this.zzg, this.zzh});
    }

    public final String toString() {
        String str;
        if (!this.zzb) {
            return "unset";
        }
        switch (this.zza) {
            case 1:
                return Integer.toString(asInt());
            case 2:
                return Float.toString(this.zzc);
            case 3:
                String str2 = this.zzd;
                if (str2 == null) {
                    return "";
                }
                return str2;
            case 4:
                ArrayMap arrayMap = this.zze;
                if (arrayMap == null) {
                    return "";
                }
                return new TreeMap(arrayMap).toString();
            case 5:
                return Arrays.toString(this.zzf);
            case 6:
                return Arrays.toString(this.zzg);
            case 7:
                byte[] bArr = this.zzh;
                if (bArr == null) {
                    return "";
                }
                int length = bArr.length;
                int length2 = bArr.length;
                if (length2 != 0 && length > 0 && length + 0 <= length2) {
                    StringBuilder sb = new StringBuilder(((length + 15) / 16) * 57);
                    int r6 = length;
                    int r7 = 0;
                    int r8 = 0;
                    while (r6 > 0) {
                        if (r7 == 0) {
                            if (length < 65536) {
                                sb.append(String.format("%04X:", Integer.valueOf(r8)));
                            } else {
                                sb.append(String.format("%08X:", Integer.valueOf(r8)));
                            }
                        } else if (r7 == 8) {
                            sb.append(" -");
                        }
                        sb.append(String.format(" %02X", Integer.valueOf(bArr[r8] & 255)));
                        r6--;
                        r7++;
                        if (r7 == 16 || r6 == 0) {
                            sb.append('\n');
                            r7 = 0;
                        }
                        r8++;
                    }
                    str = sb.toString();
                } else {
                    str = null;
                }
                if (str == null) {
                    return "";
                }
                return str;
            default:
                return "unknown";
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r6) {
        Bundle bundle;
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, this.zza);
        OnTimeoutKt.writeBoolean(parcel, 2, this.zzb);
        OnTimeoutKt.writeFloat(parcel, 3, this.zzc);
        OnTimeoutKt.writeString(parcel, 4, this.zzd);
        ArrayMap arrayMap = this.zze;
        if (arrayMap == null) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle(arrayMap.mSize);
            Iterator it = ((MapCollections.EntrySet) arrayMap.entrySet()).iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                bundle2.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
            }
            bundle = bundle2;
        }
        OnTimeoutKt.writeBundle(parcel, 5, bundle);
        OnTimeoutKt.writeIntArray(parcel, 6, this.zzf);
        float[] fArr = this.zzg;
        if (fArr != null) {
            int zza2 = OnTimeoutKt.zza(parcel, 7);
            parcel.writeFloatArray(fArr);
            OnTimeoutKt.zzb(parcel, zza2);
        }
        byte[] bArr = this.zzh;
        if (bArr != null) {
            int zza3 = OnTimeoutKt.zza(parcel, 8);
            parcel.writeByteArray(bArr);
            OnTimeoutKt.zzb(parcel, zza3);
        }
        OnTimeoutKt.zzb(parcel, zza);
    }
}
