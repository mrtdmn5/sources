package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.ValidatingOffsetMapping$$ExternalSyntheticOutline0;
import com.animaconnected.watch.image.Kolors;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class SafeParcelReader {

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    /* loaded from: classes3.dex */
    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static Bundle createBundle(Parcel parcel, int r3) {
        int readSize = readSize(parcel, r3);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + readSize);
        return readBundle;
    }

    public static int[] createIntArray(Parcel parcel, int r3) {
        int readSize = readSize(parcel, r3);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + readSize);
        return createIntArray;
    }

    public static <T extends Parcelable> T createParcelable(Parcel parcel, int r2, Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, r2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + readSize);
        return createFromParcel;
    }

    public static String createString(Parcel parcel, int r3) {
        int readSize = readSize(parcel, r3);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + readSize);
        return readString;
    }

    public static <T> T[] createTypedArray(Parcel parcel, int r2, Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, r2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + readSize);
        return tArr;
    }

    public static <T> ArrayList<T> createTypedList(Parcel parcel, int r2, Parcelable.Creator<T> creator) {
        int readSize = readSize(parcel, r2);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + readSize);
        return createTypedArrayList;
    }

    public static void ensureAtEnd(Parcel parcel, int r3) {
        if (parcel.dataPosition() == r3) {
        } else {
            throw new ParseException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Overread allowed size end=", r3), parcel);
        }
    }

    public static boolean readBoolean(Parcel parcel, int r2) {
        zzb(parcel, r2, 4);
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    public static byte readByte(Parcel parcel, int r2) {
        zzb(parcel, r2, 4);
        return (byte) parcel.readInt();
    }

    public static float readFloat(Parcel parcel, int r2) {
        zzb(parcel, r2, 4);
        return parcel.readFloat();
    }

    public static Float readFloatObject(Parcel parcel, int r2) {
        int readSize = readSize(parcel, r2);
        if (readSize == 0) {
            return null;
        }
        zza(parcel, readSize, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static IBinder readIBinder(Parcel parcel, int r3) {
        int readSize = readSize(parcel, r3);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + readSize);
        return readStrongBinder;
    }

    public static int readInt(Parcel parcel, int r2) {
        zzb(parcel, r2, 4);
        return parcel.readInt();
    }

    public static long readLong(Parcel parcel, int r2) {
        zzb(parcel, r2, 8);
        return parcel.readLong();
    }

    public static int readSize(Parcel parcel, int r3) {
        if ((r3 & Kolors.red) != -65536) {
            return (char) (r3 >> 16);
        }
        return parcel.readInt();
    }

    public static void skipUnknownField(Parcel parcel, int r2) {
        parcel.setDataPosition(parcel.dataPosition() + readSize(parcel, r2));
    }

    public static int validateObjectHeader(Parcel parcel) {
        int readInt = parcel.readInt();
        int readSize = readSize(parcel, readInt);
        int dataPosition = parcel.dataPosition();
        if (((char) readInt) == 20293) {
            int r1 = readSize + dataPosition;
            if (r1 >= dataPosition && r1 <= parcel.dataSize()) {
                return r1;
            }
            throw new ParseException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Size read is invalid start=", dataPosition, " end=", r1), parcel);
        }
        throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(readInt))), parcel);
    }

    public static void zza(Parcel parcel, int r6, int r7) {
        if (r6 == r7) {
            return;
        }
        throw new ParseException(ComponentActivity$2$$ExternalSyntheticOutline0.m(ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("Expected size ", r7, " got ", r6, " (0x"), Integer.toHexString(r6), ")"), parcel);
    }

    public static void zzb(Parcel parcel, int r6, int r7) {
        int readSize = readSize(parcel, r6);
        if (readSize == r7) {
            return;
        }
        throw new ParseException(ComponentActivity$2$$ExternalSyntheticOutline0.m(ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("Expected size ", r7, " got ", readSize, " (0x"), Integer.toHexString(readSize), ")"), parcel);
    }
}
