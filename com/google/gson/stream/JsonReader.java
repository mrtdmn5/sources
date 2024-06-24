package com.google.gson.stream;

import androidx.compose.foundation.text.ValidatingOffsetMapping$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.net.IpAddr;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes3.dex */
public class JsonReader implements Closeable {
    public final Reader in;
    public int[] pathIndices;
    public String[] pathNames;
    public long peekedLong;
    public int peekedNumberLength;
    public String peekedString;
    public int[] stack;
    public boolean lenient = false;
    public final char[] buffer = new char[1024];
    public int pos = 0;
    public int limit = 0;
    public int lineNumber = 0;
    public int lineStart = 0;
    public int peeked = 0;
    public int stackSize = 0 + 1;

    /* renamed from: com.google.gson.stream.JsonReader$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends IpAddr {
    }

    static {
        IpAddr.INSTANCE = new AnonymousClass1();
    }

    public JsonReader(Reader reader) {
        int[] r2 = new int[32];
        this.stack = r2;
        r2[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.in = reader;
    }

    public void beginArray() throws IOException {
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
        }
    }

    public void beginObject() throws IOException {
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 1) {
            push(3);
            this.peeked = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
        }
    }

    public final void checkLenient() throws IOException {
        if (this.lenient) {
            return;
        }
        syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0208, code lost:            if (isLiteral(r1) != false) goto L207;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x020a, code lost:            r1 = 2;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x020b, code lost:            if (r5 != 2) goto L182;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x020d, code lost:            if (r13 == false) goto L181;     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0213, code lost:            if (r7 != Long.MIN_VALUE) goto L174;     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0215, code lost:            if (r12 == 0) goto L181;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x021b, code lost:            if (r7 != 0) goto L177;     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x021d, code lost:            if (r12 != 0) goto L181;     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x021f, code lost:            if (r12 == 0) goto L179;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0222, code lost:            r7 = -r7;     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0223, code lost:            r19.peekedLong = r7;        r19.pos += r11;        r7 = 15;        r19.peeked = 15;     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x022f, code lost:            r1 = 2;     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0230, code lost:            if (r5 == r1) goto L187;     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0233, code lost:            if (r5 == 4) goto L187;     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0236, code lost:            if (r5 != 7) goto L207;     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0238, code lost:            r19.peekedNumberLength = r11;        r7 = 16;        r19.peeked = 16;     */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0179 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0272 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int doPeek() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 805
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.doPeek():int");
    }

    public void endArray() throws IOException {
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 4) {
            int r02 = this.stackSize - 1;
            this.stackSize = r02;
            int[] r1 = this.pathIndices;
            int r03 = r02 - 1;
            r1[r03] = r1[r03] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
    }

    public void endObject() throws IOException {
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 2) {
            int r02 = this.stackSize - 1;
            this.stackSize = r02;
            this.pathNames[r02] = null;
            int[] r1 = this.pathIndices;
            int r03 = r02 - 1;
            r1[r03] = r1[r03] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
    }

    public final boolean fillBuffer(int r8) throws IOException {
        int r1;
        int r0;
        int r02 = this.lineStart;
        int r12 = this.pos;
        this.lineStart = r02 - r12;
        int r03 = this.limit;
        char[] cArr = this.buffer;
        if (r03 != r12) {
            int r04 = r03 - r12;
            this.limit = r04;
            System.arraycopy(cArr, r12, cArr, 0, r04);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int r05 = this.limit;
            int read = this.in.read(cArr, r05, cArr.length - r05);
            if (read == -1) {
                return false;
            }
            r1 = this.limit + read;
            this.limit = r1;
            if (this.lineNumber == 0 && (r0 = this.lineStart) == 0 && r1 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = r0 + 1;
                r8++;
            }
        } while (r1 < r8);
        return true;
    }

    public final String getPath(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        int r1 = 0;
        while (true) {
            int r2 = this.stackSize;
            if (r1 < r2) {
                int r3 = this.stack[r1];
                if (r3 == 1 || r3 == 2) {
                    int r32 = this.pathIndices[r1];
                    if (z && r32 > 0 && r1 == r2 - 1) {
                        r32--;
                    }
                    sb.append('[');
                    sb.append(r32);
                    sb.append(']');
                } else if (r3 == 3 || r3 == 4 || r3 == 5) {
                    sb.append('.');
                    String str = this.pathNames[r1];
                    if (str != null) {
                        sb.append(str);
                    }
                }
                r1++;
            } else {
                return sb.toString();
            }
        }
    }

    public String getPreviousPath() {
        return getPath(true);
    }

    public boolean hasNext() throws IOException {
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 != 2 && r0 != 4 && r0 != 17) {
            return true;
        }
        return false;
    }

    public final boolean isLiteral(char c) throws IOException {
        if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
            if (c != '#') {
                if (c != ',') {
                    if (c != '/' && c != '=') {
                        if (c != '{' && c != '}' && c != ':') {
                            if (c != ';') {
                                switch (c) {
                                    case '[':
                                    case ']':
                                        return false;
                                    case '\\':
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            checkLenient();
            return false;
        }
        return false;
    }

    public final String locationString() {
        StringBuilder m = ValidatingOffsetMapping$$ExternalSyntheticOutline0.m(" at line ", this.lineNumber + 1, " column ", (this.pos - this.lineStart) + 1, " path ");
        m.append(getPath());
        return m.toString();
    }

    public boolean nextBoolean() throws IOException {
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 5) {
            this.peeked = 0;
            int[] r02 = this.pathIndices;
            int r1 = this.stackSize - 1;
            r02[r1] = r02[r1] + 1;
            return true;
        }
        if (r0 == 6) {
            this.peeked = 0;
            int[] r03 = this.pathIndices;
            int r12 = this.stackSize - 1;
            r03[r12] = r03[r12] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
    }

    public double nextDouble() throws IOException {
        char c;
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 15) {
            this.peeked = 0;
            int[] r02 = this.pathIndices;
            int r1 = this.stackSize - 1;
            r02[r1] = r02[r1] + 1;
            return this.peekedLong;
        }
        if (r0 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (r0 != 8 && r0 != 9) {
            if (r0 == 10) {
                this.peekedString = nextUnquotedValue();
            } else if (r0 != 11) {
                throw new IllegalStateException("Expected a double but was " + peek() + locationString());
            }
        } else {
            if (r0 == 8) {
                c = '\'';
            } else {
                c = '\"';
            }
            this.peekedString = nextQuotedValue(c);
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] r2 = this.pathIndices;
        int r3 = this.stackSize - 1;
        r2[r3] = r2[r3] + 1;
        return parseDouble;
    }

    public int nextInt() throws IOException {
        char c;
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 15) {
            long j = this.peekedLong;
            int r4 = (int) j;
            if (j == r4) {
                this.peeked = 0;
                int[] r02 = this.pathIndices;
                int r1 = this.stackSize - 1;
                r02[r1] = r02[r1] + 1;
                return r4;
            }
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
        }
        if (r0 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (r0 != 8 && r0 != 9 && r0 != 10) {
                throw new IllegalStateException("Expected an int but was " + peek() + locationString());
            }
            if (r0 == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                if (r0 == 8) {
                    c = '\'';
                } else {
                    c = '\"';
                }
                this.peekedString = nextQuotedValue(c);
            }
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] r12 = this.pathIndices;
                int r42 = this.stackSize - 1;
                r12[r42] = r12[r42] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int r43 = (int) parseDouble;
        if (r43 == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] r03 = this.pathIndices;
            int r13 = this.stackSize - 1;
            r03[r13] = r03[r13] + 1;
            return r43;
        }
        throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
    }

    public long nextLong() throws IOException {
        char c;
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 15) {
            this.peeked = 0;
            int[] r02 = this.pathIndices;
            int r1 = this.stackSize - 1;
            r02[r1] = r02[r1] + 1;
            return this.peekedLong;
        }
        if (r0 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (r0 != 8 && r0 != 9 && r0 != 10) {
                throw new IllegalStateException("Expected a long but was " + peek() + locationString());
            }
            if (r0 == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                if (r0 == 8) {
                    c = '\'';
                } else {
                    c = '\"';
                }
                this.peekedString = nextQuotedValue(c);
            }
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] r4 = this.pathIndices;
                int r5 = this.stackSize - 1;
                r4[r5] = r4[r5] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] r03 = this.pathIndices;
            int r12 = this.stackSize - 1;
            r03[r12] = r03[r12] + 1;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
    }

    public String nextName() throws IOException {
        String nextQuotedValue;
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 14) {
            nextQuotedValue = nextUnquotedValue();
        } else if (r0 == 12) {
            nextQuotedValue = nextQuotedValue('\'');
        } else if (r0 == 13) {
            nextQuotedValue = nextQuotedValue('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + peek() + locationString());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = nextQuotedValue;
        return nextQuotedValue;
    }

    public final int nextNonWhitespace(boolean z) throws IOException {
        int r0 = this.pos;
        int r1 = this.limit;
        while (true) {
            boolean z2 = true;
            if (r0 == r1) {
                this.pos = r0;
                if (!fillBuffer(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + locationString());
                }
                r0 = this.pos;
                r1 = this.limit;
            }
            int r3 = r0 + 1;
            char[] cArr = this.buffer;
            char c = cArr[r0];
            if (c == '\n') {
                this.lineNumber++;
                this.lineStart = r3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.pos = r3;
                    if (r3 == r1) {
                        this.pos = r3 - 1;
                        boolean fillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!fillBuffer) {
                            return c;
                        }
                    }
                    checkLenient();
                    int r12 = this.pos;
                    char c2 = cArr[r12];
                    if (c2 != '*') {
                        if (c2 != '/') {
                            return c;
                        }
                        this.pos = r12 + 1;
                        skipToEndOfLine();
                        r0 = this.pos;
                        r1 = this.limit;
                    } else {
                        this.pos = r12 + 1;
                        while (true) {
                            if (this.pos + 2 > this.limit && !fillBuffer(2)) {
                                z2 = false;
                                break;
                            }
                            int r02 = this.pos;
                            if (cArr[r02] == '\n') {
                                this.lineNumber++;
                                this.lineStart = r02 + 1;
                            } else {
                                for (int r32 = 0; r32 < 2; r32++) {
                                    if (cArr[this.pos + r32] != "*/".charAt(r32)) {
                                        break;
                                    }
                                }
                                break;
                            }
                            this.pos++;
                        }
                        if (z2) {
                            r0 = this.pos + 2;
                            r1 = this.limit;
                        } else {
                            syntaxError("Unterminated comment");
                            throw null;
                        }
                    }
                } else if (c == '#') {
                    this.pos = r3;
                    checkLenient();
                    skipToEndOfLine();
                    r0 = this.pos;
                    r1 = this.limit;
                } else {
                    this.pos = r3;
                    return c;
                }
            }
            r0 = r3;
        }
    }

    public void nextNull() throws IOException {
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 7) {
            this.peeked = 0;
            int[] r02 = this.pathIndices;
            int r1 = this.stackSize - 1;
            r02[r1] = r02[r1] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:            r10.pos = r8;        r8 = (r8 - r2) - 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            if (r1 != null) goto L37;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:            r1 = new java.lang.StringBuilder(java.lang.Math.max((r8 + 1) * 2, 16));     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:            if (r1 != null) goto L27;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005e, code lost:            r1 = new java.lang.StringBuilder(java.lang.Math.max((r4 - r2) * 2, 16));     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006c, code lost:            r1.append(r7, r2, r4 - r2);        r10.pos = r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String nextQuotedValue(char r11) throws java.io.IOException {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r10.pos
            int r3 = r10.limit
        L6:
            r4 = r2
        L7:
            r5 = 1
            r6 = 16
            char[] r7 = r10.buffer
            if (r4 >= r3) goto L5c
            int r8 = r4 + 1
            char r4 = r7[r4]
            if (r4 != r11) goto L28
            r10.pos = r8
            int r8 = r8 - r2
            int r8 = r8 - r5
            if (r1 != 0) goto L20
            java.lang.String r11 = new java.lang.String
            r11.<init>(r7, r2, r8)
            return r11
        L20:
            r1.append(r7, r2, r8)
            java.lang.String r11 = r1.toString()
            return r11
        L28:
            r9 = 92
            if (r4 != r9) goto L4f
            r10.pos = r8
            int r8 = r8 - r2
            int r8 = r8 - r5
            if (r1 != 0) goto L40
            int r1 = r8 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r6)
            r3.<init>(r1)
            r1 = r3
        L40:
            r1.append(r7, r2, r8)
            char r2 = r10.readEscapeCharacter()
            r1.append(r2)
            int r2 = r10.pos
            int r3 = r10.limit
            goto L6
        L4f:
            r6 = 10
            if (r4 != r6) goto L5a
            int r4 = r10.lineNumber
            int r4 = r4 + r5
            r10.lineNumber = r4
            r10.lineStart = r8
        L5a:
            r4 = r8
            goto L7
        L5c:
            if (r1 != 0) goto L6c
            int r1 = r4 - r2
            int r1 = r1 * 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r6)
            r3.<init>(r1)
            r1 = r3
        L6c:
            int r3 = r4 - r2
            r1.append(r7, r2, r3)
            r10.pos = r4
            boolean r2 = r10.fillBuffer(r5)
            if (r2 == 0) goto L7a
            goto L2
        L7a:
            java.lang.String r11 = "Unterminated string"
            r10.syntaxError(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextQuotedValue(char):java.lang.String");
    }

    public String nextString() throws IOException {
        String str;
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 10) {
            str = nextUnquotedValue();
        } else if (r0 == 8) {
            str = nextQuotedValue('\'');
        } else if (r0 == 9) {
            str = nextQuotedValue('\"');
        } else if (r0 == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (r0 == 15) {
            str = Long.toString(this.peekedLong);
        } else if (r0 == 16) {
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            throw new IllegalStateException("Expected a string but was " + peek() + locationString());
        }
        this.peeked = 0;
        int[] r1 = this.pathIndices;
        int r2 = this.stackSize - 1;
        r1[r2] = r1[r2] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004a, code lost:            checkLenient();     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String nextUnquotedValue() throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r7.pos
            int r4 = r3 + r2
            int r5 = r7.limit
            char[] r6 = r7.buffer
            if (r4 >= r5) goto L4e
            int r3 = r3 + r2
            char r3 = r6[r3]
            r4 = 9
            if (r3 == r4) goto L5a
            r4 = 10
            if (r3 == r4) goto L5a
            r4 = 12
            if (r3 == r4) goto L5a
            r4 = 13
            if (r3 == r4) goto L5a
            r4 = 32
            if (r3 == r4) goto L5a
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5a
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5a
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5a
            r4 = 58
            if (r3 == r4) goto L5a
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5a;
                case 92: goto L4a;
                case 93: goto L5a;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r7.checkLenient()
            goto L5a
        L4e:
            int r3 = r6.length
            if (r2 >= r3) goto L5c
            int r3 = r2 + 1
            boolean r3 = r7.fillBuffer(r3)
            if (r3 == 0) goto L5a
            goto L3
        L5a:
            r1 = r2
            goto L7a
        L5c:
            if (r0 != 0) goto L69
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L69:
            int r3 = r7.pos
            r0.append(r6, r3, r2)
            int r3 = r7.pos
            int r3 = r3 + r2
            r7.pos = r3
            r2 = 1
            boolean r2 = r7.fillBuffer(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r0 != 0) goto L84
            java.lang.String r0 = new java.lang.String
            int r2 = r7.pos
            r0.<init>(r6, r2, r1)
            goto L8d
        L84:
            int r2 = r7.pos
            r0.append(r6, r2, r1)
            java.lang.String r0 = r0.toString()
        L8d:
            int r2 = r7.pos
            int r2 = r2 + r1
            r7.pos = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextUnquotedValue():java.lang.String");
    }

    public JsonToken peek() throws IOException {
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        switch (r0) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void push(int r4) {
        int r0 = this.stackSize;
        int[] r1 = this.stack;
        if (r0 == r1.length) {
            int r02 = r0 * 2;
            this.stack = Arrays.copyOf(r1, r02);
            this.pathIndices = Arrays.copyOf(this.pathIndices, r02);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, r02);
        }
        int[] r03 = this.stack;
        int r12 = this.stackSize;
        this.stackSize = r12 + 1;
        r03[r12] = r4;
    }

    public final char readEscapeCharacter() throws IOException {
        int r7;
        int r72;
        if (this.pos == this.limit && !fillBuffer(1)) {
            syntaxError("Unterminated escape sequence");
            throw null;
        }
        int r0 = this.pos;
        int r1 = r0 + 1;
        this.pos = r1;
        char[] cArr = this.buffer;
        char c = cArr[r0];
        if (c != '\n') {
            if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
                if (c != 'b') {
                    if (c != 'f') {
                        if (c == 'n') {
                            return '\n';
                        }
                        if (c != 'r') {
                            if (c != 't') {
                                if (c == 'u') {
                                    if (r1 + 4 > this.limit && !fillBuffer(4)) {
                                        syntaxError("Unterminated escape sequence");
                                        throw null;
                                    }
                                    int r12 = this.pos;
                                    int r2 = r12 + 4;
                                    char c2 = 0;
                                    while (r12 < r2) {
                                        char c3 = cArr[r12];
                                        char c4 = (char) (c2 << 4);
                                        if (c3 >= '0' && c3 <= '9') {
                                            r72 = c3 - '0';
                                        } else {
                                            if (c3 >= 'a' && c3 <= 'f') {
                                                r7 = c3 - 'a';
                                            } else if (c3 >= 'A' && c3 <= 'F') {
                                                r7 = c3 - 'A';
                                            } else {
                                                throw new NumberFormatException("\\u".concat(new String(cArr, this.pos, 4)));
                                            }
                                            r72 = r7 + 10;
                                        }
                                        c2 = (char) (r72 + c4);
                                        r12++;
                                    }
                                    this.pos += 4;
                                    return c2;
                                }
                                syntaxError("Invalid escape sequence");
                                throw null;
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\f';
                }
                return '\b';
            }
        } else {
            this.lineNumber++;
            this.lineStart = r1;
        }
        return c;
    }

    public final void skipQuotedValue(char c) throws IOException {
        do {
            int r0 = this.pos;
            int r1 = this.limit;
            while (r0 < r1) {
                int r3 = r0 + 1;
                char c2 = this.buffer[r0];
                if (c2 == c) {
                    this.pos = r3;
                    return;
                }
                if (c2 == '\\') {
                    this.pos = r3;
                    readEscapeCharacter();
                    r0 = this.pos;
                    r1 = this.limit;
                } else {
                    if (c2 == '\n') {
                        this.lineNumber++;
                        this.lineStart = r3;
                    }
                    r0 = r3;
                }
            }
            this.pos = r0;
        } while (fillBuffer(1));
        syntaxError("Unterminated string");
        throw null;
    }

    public final void skipToEndOfLine() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || fillBuffer(1)) {
                int r0 = this.pos;
                int r1 = r0 + 1;
                this.pos = r1;
                c = this.buffer[r0];
                if (c == '\n') {
                    this.lineNumber++;
                    this.lineStart = r1;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:242)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public final void skipUnquotedValue() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.pos
            int r2 = r1 + r0
            int r3 = r4.limit
            if (r2 >= r3) goto L51
            char[] r2 = r4.buffer
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.checkLenient()
        L4b:
            int r1 = r4.pos
            int r1 = r1 + r0
            r4.pos = r1
            return
        L51:
            int r1 = r1 + r0
            r4.pos = r1
            r0 = 1
            boolean r0 = r4.fillBuffer(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.skipUnquotedValue():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0011. Please report as an issue. */
    public void skipValue() throws IOException {
        int r1 = 0;
        do {
            int r2 = this.peeked;
            if (r2 == 0) {
                r2 = doPeek();
            }
            switch (r2) {
                case 1:
                    push(3);
                    r1++;
                    this.peeked = 0;
                    break;
                case 2:
                    if (r1 == 0) {
                        this.pathNames[this.stackSize - 1] = null;
                    }
                    this.stackSize--;
                    r1--;
                    this.peeked = 0;
                    break;
                case 3:
                    push(1);
                    r1++;
                    this.peeked = 0;
                    break;
                case 4:
                    this.stackSize--;
                    r1--;
                    this.peeked = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.peeked = 0;
                    break;
                case 8:
                    skipQuotedValue('\'');
                    this.peeked = 0;
                    break;
                case 9:
                    skipQuotedValue('\"');
                    this.peeked = 0;
                    break;
                case 10:
                    skipUnquotedValue();
                    this.peeked = 0;
                    break;
                case 12:
                    skipQuotedValue('\'');
                    if (r1 == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                    }
                    this.peeked = 0;
                    break;
                case 13:
                    skipQuotedValue('\"');
                    if (r1 == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                    }
                    this.peeked = 0;
                    break;
                case 14:
                    skipUnquotedValue();
                    if (r1 == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                    }
                    this.peeked = 0;
                    break;
                case 16:
                    this.pos += this.peekedNumberLength;
                    this.peeked = 0;
                    break;
                case 17:
                    return;
            }
        } while (r1 > 0);
        int[] r0 = this.pathIndices;
        int r12 = this.stackSize - 1;
        r0[r12] = r0[r12] + 1;
    }

    public final void syntaxError(String str) throws IOException {
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str);
        m.append(locationString());
        throw new MalformedJsonException(m.toString());
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }

    public String getPath() {
        return getPath(false);
    }
}
