package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.mType = versionedParcel.readInt(iconCompat.mType, 1);
        byte[] bArr = iconCompat.mData;
        if (versionedParcel.readField(2)) {
            bArr = versionedParcel.readByteArray();
        }
        iconCompat.mData = bArr;
        Parcelable parcelable = iconCompat.mParcelable;
        if (versionedParcel.readField(3)) {
            parcelable = versionedParcel.readParcelable();
        }
        iconCompat.mParcelable = parcelable;
        iconCompat.mInt1 = versionedParcel.readInt(iconCompat.mInt1, 4);
        iconCompat.mInt2 = versionedParcel.readInt(iconCompat.mInt2, 5);
        Parcelable parcelable2 = iconCompat.mTintList;
        if (versionedParcel.readField(6)) {
            parcelable2 = versionedParcel.readParcelable();
        }
        iconCompat.mTintList = (ColorStateList) parcelable2;
        String str = iconCompat.mTintModeStr;
        if (versionedParcel.readField(7)) {
            str = versionedParcel.readString();
        }
        iconCompat.mTintModeStr = str;
        String str2 = iconCompat.mString1;
        if (versionedParcel.readField(8)) {
            str2 = versionedParcel.readString();
        }
        iconCompat.mString1 = str2;
        iconCompat.mTintMode = PorterDuff.Mode.valueOf(iconCompat.mTintModeStr);
        switch (iconCompat.mType) {
            case -1:
                Parcelable parcelable3 = iconCompat.mParcelable;
                if (parcelable3 != null) {
                    iconCompat.mObj1 = parcelable3;
                    return iconCompat;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable4 = iconCompat.mParcelable;
                if (parcelable4 != null) {
                    iconCompat.mObj1 = parcelable4;
                } else {
                    byte[] bArr2 = iconCompat.mData;
                    iconCompat.mObj1 = bArr2;
                    iconCompat.mType = 3;
                    iconCompat.mInt1 = 0;
                    iconCompat.mInt2 = bArr2.length;
                }
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.mData, Charset.forName("UTF-16"));
                iconCompat.mObj1 = str3;
                if (iconCompat.mType == 2 && iconCompat.mString1 == null) {
                    iconCompat.mString1 = str3.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.mObj1 = iconCompat.mData;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.getClass();
        iconCompat.mTintModeStr = iconCompat.mTintMode.name();
        switch (iconCompat.mType) {
            case -1:
                iconCompat.mParcelable = (Parcelable) iconCompat.mObj1;
                break;
            case 1:
            case 5:
                iconCompat.mParcelable = (Parcelable) iconCompat.mObj1;
                break;
            case 2:
                iconCompat.mData = ((String) iconCompat.mObj1).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.mData = (byte[]) iconCompat.mObj1;
                break;
            case 4:
            case 6:
                iconCompat.mData = iconCompat.mObj1.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int r0 = iconCompat.mType;
        if (-1 != r0) {
            versionedParcel.writeInt(r0, 1);
        }
        byte[] bArr = iconCompat.mData;
        if (bArr != null) {
            versionedParcel.setOutputField(2);
            versionedParcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.mParcelable;
        if (parcelable != null) {
            versionedParcel.setOutputField(3);
            versionedParcel.writeParcelable(parcelable);
        }
        int r02 = iconCompat.mInt1;
        if (r02 != 0) {
            versionedParcel.writeInt(r02, 4);
        }
        int r03 = iconCompat.mInt2;
        if (r03 != 0) {
            versionedParcel.writeInt(r03, 5);
        }
        ColorStateList colorStateList = iconCompat.mTintList;
        if (colorStateList != null) {
            versionedParcel.setOutputField(6);
            versionedParcel.writeParcelable(colorStateList);
        }
        String str = iconCompat.mTintModeStr;
        if (str != null) {
            versionedParcel.setOutputField(7);
            versionedParcel.writeString(str);
        }
        String str2 = iconCompat.mString1;
        if (str2 != null) {
            versionedParcel.setOutputField(8);
            versionedParcel.writeString(str2);
        }
    }
}
