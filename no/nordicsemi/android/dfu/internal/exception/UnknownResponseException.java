package no.nordicsemi.android.dfu.internal.exception;

import java.util.Locale;

/* loaded from: classes4.dex */
public class UnknownResponseException extends Exception {
    private static final char[] HEX_ARRAY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final long serialVersionUID = -8716125467309979289L;
    private final int mExpectedOpCode;
    private final int mExpectedReturnCode;
    private final byte[] mResponse;

    public UnknownResponseException(String str, byte[] bArr, int r3, int r4) {
        super(str);
        this.mResponse = bArr == null ? new byte[0] : bArr;
        this.mExpectedReturnCode = r3;
        this.mExpectedOpCode = r4;
    }

    public static String bytesToHex(byte[] bArr, int r7, int r8) {
        if (bArr != null && bArr.length > r7 && r8 > 0) {
            int min = Math.min(r8, bArr.length - r7);
            char[] cArr = new char[min * 2];
            for (int r1 = 0; r1 < min; r1++) {
                int r2 = bArr[r7 + r1] & 255;
                int r3 = r1 * 2;
                char[] cArr2 = HEX_ARRAY;
                cArr[r3] = cArr2[r2 >>> 4];
                cArr[r3 + 1] = cArr2[r2 & 15];
            }
            return "0x".concat(new String(cArr));
        }
        return "";
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Locale locale = Locale.US;
        String message = super.getMessage();
        byte[] bArr = this.mResponse;
        return String.format(locale, "%s (response: %s, expected: 0x%02X%02X..)", message, bytesToHex(bArr, 0, bArr.length), Integer.valueOf(this.mExpectedReturnCode), Integer.valueOf(this.mExpectedOpCode));
    }
}
