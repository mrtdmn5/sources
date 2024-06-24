package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringOps.kt */
/* loaded from: classes4.dex */
public final class StringOpsKt {
    public static final byte[] ESCAPE_MARKERS;
    public static final String[] ESCAPE_STRINGS;

    static {
        String[] strArr = new String[93];
        for (int r3 = 0; r3 < 32; r3++) {
            strArr[r3] = "\\u" + toHexChar(r3 >> 12) + toHexChar(r3 >> 8) + toHexChar(r3 >> 4) + toHexChar(r3);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        ESCAPE_STRINGS = strArr;
        byte[] bArr = new byte[93];
        for (int r2 = 0; r2 < 32; r2++) {
            bArr[r2] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        ESCAPE_MARKERS = bArr;
    }

    public static final void printQuoted(String value, StringBuilder sb) {
        Intrinsics.checkNotNullParameter(value, "value");
        sb.append('\"');
        int length = value.length();
        int r3 = 0;
        for (int r2 = 0; r2 < length; r2++) {
            char charAt = value.charAt(r2);
            String[] strArr = ESCAPE_STRINGS;
            if (charAt < strArr.length && strArr[charAt] != null) {
                sb.append((CharSequence) value, r3, r2);
                sb.append(strArr[charAt]);
                r3 = r2 + 1;
            }
        }
        if (r3 != 0) {
            sb.append((CharSequence) value, r3, value.length());
        } else {
            sb.append(value);
        }
        sb.append('\"');
    }

    public static final char toHexChar(int r1) {
        int r12;
        int r13 = r1 & 15;
        if (r13 < 10) {
            r12 = r13 + 48;
        } else {
            r12 = (r13 - 10) + 97;
        }
        return (char) r12;
    }
}
