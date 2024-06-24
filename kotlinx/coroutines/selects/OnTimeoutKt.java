package kotlinx.coroutines.selects;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.ui.graphics.AndroidPath;
import com.animaconnected.watch.image.Kolors;
import java.util.List;

/* compiled from: OnTimeout.kt */
/* loaded from: classes4.dex */
public final class OnTimeoutKt {
    public static final AndroidPath Path() {
        return new AndroidPath(0);
    }

    public static void writeBoolean(Parcel parcel, int r2, boolean z) {
        parcel.writeInt(r2 | 262144);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void writeBundle(Parcel parcel, int r1, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int zza = zza(parcel, r1);
        parcel.writeBundle(bundle);
        zzb(parcel, zza);
    }

    public static void writeByte(Parcel parcel, int r2, byte b) {
        parcel.writeInt(r2 | 262144);
        parcel.writeInt(b);
    }

    public static void writeFloat(Parcel parcel, int r2, float f) {
        parcel.writeInt(r2 | 262144);
        parcel.writeFloat(f);
    }

    public static void writeFloatObject(Parcel parcel, int r2, Float f) {
        if (f == null) {
            return;
        }
        parcel.writeInt(r2 | 262144);
        parcel.writeFloat(f.floatValue());
    }

    public static void writeIBinder(Parcel parcel, int r1, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int zza = zza(parcel, r1);
        parcel.writeStrongBinder(iBinder);
        zzb(parcel, zza);
    }

    public static void writeInt(Parcel parcel, int r2, int r3) {
        parcel.writeInt(r2 | 262144);
        parcel.writeInt(r3);
    }

    public static void writeIntArray(Parcel parcel, int r1, int[] r2) {
        if (r2 == null) {
            return;
        }
        int zza = zza(parcel, r1);
        parcel.writeIntArray(r2);
        zzb(parcel, zza);
    }

    public static void writeLong(Parcel parcel, int r2, long j) {
        parcel.writeInt(r2 | 524288);
        parcel.writeLong(j);
    }

    public static void writeParcelable(Parcel parcel, int r1, Parcelable parcelable, int r3) {
        if (parcelable == null) {
            return;
        }
        int zza = zza(parcel, r1);
        parcelable.writeToParcel(parcel, r3);
        zzb(parcel, zza);
    }

    public static void writeString(Parcel parcel, int r1, String str) {
        if (str == null) {
            return;
        }
        int zza = zza(parcel, r1);
        parcel.writeString(str);
        zzb(parcel, zza);
    }

    public static void writeTypedArray(Parcel parcel, int r5, Parcelable[] parcelableArr, int r7) {
        if (parcelableArr == null) {
            return;
        }
        int zza = zza(parcel, r5);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, parcelable, r7);
            }
        }
        zzb(parcel, zza);
    }

    public static void writeTypedList(Parcel parcel, int r5, List list) {
        if (list == null) {
            return;
        }
        int zza = zza(parcel, r5);
        int size = list.size();
        parcel.writeInt(size);
        for (int r2 = 0; r2 < size; r2++) {
            Parcelable parcelable = (Parcelable) list.get(r2);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, parcelable, 0);
            }
        }
        zzb(parcel, zza);
    }

    public static int zza(Parcel parcel, int r2) {
        parcel.writeInt(r2 | Kolors.red);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void zzb(Parcel parcel, int r3) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(r3 - 4);
        parcel.writeInt(dataPosition - r3);
        parcel.setDataPosition(dataPosition);
    }

    public static void zzd(Parcel parcel, Parcelable parcelable, int r4) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, r4);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
