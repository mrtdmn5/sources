package com.google.crypto.tink.subtle;

import com.animaconnected.secondo.R;

/* loaded from: classes3.dex */
public final class AesUtil {
    public static byte[] dbl(final byte[] value) {
        if (value.length == 16) {
            byte[] bArr = new byte[16];
            for (int r3 = 0; r3 < 16; r3++) {
                byte b = (byte) ((value[r3] << 1) & 254);
                bArr[r3] = b;
                if (r3 < 15) {
                    bArr[r3] = (byte) (((byte) ((value[r3 + 1] >> 7) & 1)) | b);
                }
            }
            bArr[15] = (byte) (((byte) ((value[0] >> 7) & R.styleable.AppTheme_stepsHistoryColumnColorActivity)) ^ bArr[15]);
            return bArr;
        }
        throw new IllegalArgumentException("value must be a block.");
    }
}
