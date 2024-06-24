package com.airbnb.lottie.parser.moshi;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class JsonReader implements Closeable {
    public static final String[] REPLACEMENT_CHARS = new String[128];
    public int stackSize;
    public int[] scopes = new int[32];
    public String[] pathNames = new String[32];
    public int[] pathIndices = new int[32];

    /* loaded from: classes.dex */
    public static final class Options {
        public final okio.Options doubleQuoteSuffix;
        public final String[] strings;

        public Options(String[] strArr, okio.Options options) {
            this.strings = strArr;
            this.doubleQuoteSuffix = options;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x003a A[Catch: IOException -> 0x0069, TryCatch #0 {IOException -> 0x0069, blocks: (B:2:0x0000, B:3:0x000a, B:5:0x000d, B:7:0x001e, B:9:0x0026, B:13:0x0042, B:15:0x003a, B:16:0x003d, B:27:0x0047, B:29:0x004a, B:32:0x0059), top: B:1:0x0000 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static com.airbnb.lottie.parser.moshi.JsonReader.Options of(java.lang.String... r12) {
            /*
                int r0 = r12.length     // Catch: java.io.IOException -> L69
                okio.ByteString[] r0 = new okio.ByteString[r0]     // Catch: java.io.IOException -> L69
                okio.Buffer r1 = new okio.Buffer     // Catch: java.io.IOException -> L69
                r1.<init>()     // Catch: java.io.IOException -> L69
                r2 = 0
                r3 = r2
            La:
                int r4 = r12.length     // Catch: java.io.IOException -> L69
                if (r3 >= r4) goto L59
                r4 = r12[r3]     // Catch: java.io.IOException -> L69
                java.lang.String[] r5 = com.airbnb.lottie.parser.moshi.JsonReader.REPLACEMENT_CHARS     // Catch: java.io.IOException -> L69
                r6 = 34
                r1.m1734writeByte(r6)     // Catch: java.io.IOException -> L69
                int r7 = r4.length()     // Catch: java.io.IOException -> L69
                r8 = r2
                r9 = r8
            L1c:
                if (r8 >= r7) goto L45
                char r10 = r4.charAt(r8)     // Catch: java.io.IOException -> L69
                r11 = 128(0x80, float:1.8E-43)
                if (r10 >= r11) goto L2b
                r10 = r5[r10]     // Catch: java.io.IOException -> L69
                if (r10 != 0) goto L38
                goto L42
            L2b:
                r11 = 8232(0x2028, float:1.1535E-41)
                if (r10 != r11) goto L32
                java.lang.String r10 = "\\u2028"
                goto L38
            L32:
                r11 = 8233(0x2029, float:1.1537E-41)
                if (r10 != r11) goto L42
                java.lang.String r10 = "\\u2029"
            L38:
                if (r9 >= r8) goto L3d
                r1.m1737writeUtf8(r9, r8, r4)     // Catch: java.io.IOException -> L69
            L3d:
                r1.m1738writeUtf8(r10)     // Catch: java.io.IOException -> L69
                int r9 = r8 + 1
            L42:
                int r8 = r8 + 1
                goto L1c
            L45:
                if (r9 >= r7) goto L4a
                r1.m1737writeUtf8(r9, r7, r4)     // Catch: java.io.IOException -> L69
            L4a:
                r1.m1734writeByte(r6)     // Catch: java.io.IOException -> L69
                r1.readByte()     // Catch: java.io.IOException -> L69
                okio.ByteString r4 = r1.readByteString()     // Catch: java.io.IOException -> L69
                r0[r3] = r4     // Catch: java.io.IOException -> L69
                int r3 = r3 + 1
                goto La
            L59:
                com.airbnb.lottie.parser.moshi.JsonReader$Options r1 = new com.airbnb.lottie.parser.moshi.JsonReader$Options     // Catch: java.io.IOException -> L69
                java.lang.Object r12 = r12.clone()     // Catch: java.io.IOException -> L69
                java.lang.String[] r12 = (java.lang.String[]) r12     // Catch: java.io.IOException -> L69
                okio.Options r0 = okio.Options.Companion.of(r0)     // Catch: java.io.IOException -> L69
                r1.<init>(r12, r0)     // Catch: java.io.IOException -> L69
                return r1
            L69:
                r12 = move-exception
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>(r12)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonReader.Options.of(java.lang.String[]):com.airbnb.lottie.parser.moshi.JsonReader$Options");
        }
    }

    /* loaded from: classes.dex */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int r0 = 0; r0 <= 31; r0++) {
            REPLACEMENT_CHARS[r0] = String.format("\\u%04x", Integer.valueOf(r0));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public abstract void beginArray() throws IOException;

    public abstract void beginObject() throws IOException;

    public abstract void endArray() throws IOException;

    public abstract void endObject() throws IOException;

    public final String getPath() {
        int r0 = this.stackSize;
        int[] r1 = this.scopes;
        String[] strArr = this.pathNames;
        int[] r3 = this.pathIndices;
        StringBuilder sb = new StringBuilder("$");
        for (int r5 = 0; r5 < r0; r5++) {
            int r6 = r1[r5];
            if (r6 != 1 && r6 != 2) {
                if (r6 == 3 || r6 == 4 || r6 == 5) {
                    sb.append('.');
                    String str = strArr[r5];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            } else {
                sb.append('[');
                sb.append(r3[r5]);
                sb.append(']');
            }
        }
        return sb.toString();
    }

    public abstract boolean hasNext() throws IOException;

    public abstract boolean nextBoolean() throws IOException;

    public abstract double nextDouble() throws IOException;

    public abstract int nextInt() throws IOException;

    public abstract String nextString() throws IOException;

    public abstract Token peek() throws IOException;

    public final void pushScope(int r4) {
        int r0 = this.stackSize;
        int[] r1 = this.scopes;
        if (r0 == r1.length) {
            if (r0 != 256) {
                this.scopes = Arrays.copyOf(r1, r1.length * 2);
                String[] strArr = this.pathNames;
                this.pathNames = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] r02 = this.pathIndices;
                this.pathIndices = Arrays.copyOf(r02, r02.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] r03 = this.scopes;
        int r12 = this.stackSize;
        this.stackSize = r12 + 1;
        r03[r12] = r4;
    }

    public abstract int selectName(Options options) throws IOException;

    public abstract void skipName() throws IOException;

    public abstract void skipValue() throws IOException;

    public final void syntaxError(String str) throws JsonEncodingException {
        StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(str, " at path ");
        m.append(getPath());
        throw new JsonEncodingException(m.toString());
    }
}
