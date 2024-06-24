package kotlinx.serialization.json.internal;

/* compiled from: AbstractJsonLexer.kt */
/* loaded from: classes4.dex */
public final class CharMappings {
    public static final char[] ESCAPE_2_CHAR = new char[117];
    public static final byte[] CHAR_TO_TOKEN = new byte[126];

    static {
        int r1 = 0;
        for (int r2 = 0; r2 < 32; r2++) {
            initC2ESC('u', r2);
        }
        initC2ESC('b', 8);
        initC2ESC('t', 9);
        initC2ESC('n', 10);
        initC2ESC('f', 12);
        initC2ESC('r', 13);
        initC2ESC('/', 47);
        initC2ESC('\"', 34);
        initC2ESC('\\', 92);
        while (true) {
            byte[] bArr = CHAR_TO_TOKEN;
            if (r1 < 33) {
                bArr[r1] = Byte.MAX_VALUE;
                r1++;
            } else {
                bArr[9] = 3;
                bArr[10] = 3;
                bArr[13] = 3;
                bArr[32] = 3;
                bArr[44] = 4;
                bArr[58] = 5;
                bArr[123] = 6;
                bArr[125] = 7;
                bArr[91] = 8;
                bArr[93] = 9;
                bArr[34] = 1;
                bArr[92] = 2;
                return;
            }
        }
    }

    public static void initC2ESC(char c, int r2) {
        if (c != 'u') {
            ESCAPE_2_CHAR[c] = (char) r2;
        }
    }
}
