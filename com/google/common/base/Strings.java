package com.google.common.base;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import androidx.compose.ui.input.pointer.AndroidPointerIconType;
import com.amazonaws.services.s3.internal.Constants;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class Strings {
    public static final AndroidPointerIconType pointerIconDefault = new AndroidPointerIconType(1000);

    static {
        new AndroidPointerIconType(1007);
        new AndroidPointerIconType(1008);
        new AndroidPointerIconType(1002);
    }

    public static String lenientFormat(String str, Object... objArr) {
        int indexOf;
        String sb;
        int r0 = 0;
        for (int r1 = 0; r1 < objArr.length; r1++) {
            Object obj = objArr[r1];
            if (obj == null) {
                sb = Constants.NULL_VERSION_ID;
            } else {
                try {
                    sb = obj.toString();
                } catch (Exception e) {
                    String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str2, (Throwable) e);
                    StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("<", str2, " threw ");
                    m.append(e.getClass().getName());
                    m.append(">");
                    sb = m.toString();
                }
            }
            objArr[r1] = sb;
        }
        StringBuilder sb2 = new StringBuilder((objArr.length * 16) + str.length());
        int r2 = 0;
        while (r0 < objArr.length && (indexOf = str.indexOf("%s", r2)) != -1) {
            sb2.append((CharSequence) str, r2, indexOf);
            sb2.append(objArr[r0]);
            r2 = indexOf + 2;
            r0++;
        }
        sb2.append((CharSequence) str, r2, str.length());
        if (r0 < objArr.length) {
            sb2.append(" [");
            sb2.append(objArr[r0]);
            for (int r9 = r0 + 1; r9 < objArr.length; r9++) {
                sb2.append(", ");
                sb2.append(objArr[r9]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }

    public static final int updateChangedFlags(int r3) {
        int r0 = 306783378 & r3;
        int r1 = 613566756 & r3;
        return (r3 & (-920350135)) | (r1 >> 1) | r0 | ((r0 << 1) & r1);
    }
}
