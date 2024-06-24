package com.squareup.moshi;

import com.amazonaws.services.s3.internal.Constants;
import com.squareup.moshi.JsonReader;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: classes3.dex */
public final class JsonUtf8Reader extends JsonReader {
    public static final ByteString CLOSING_BLOCK_COMMENT;
    public static final ByteString DOUBLE_QUOTE_OR_SLASH;
    public static final ByteString LINEFEED_OR_CARRIAGE_RETURN;
    public static final ByteString SINGLE_QUOTE_OR_SLASH;
    public static final ByteString UNQUOTED_STRING_TERMINALS;
    public final Buffer buffer;
    public int peeked = 0;
    public long peekedLong;
    public int peekedNumberLength;
    public String peekedString;
    public final BufferedSource source;

    static {
        ByteString byteString = ByteString.EMPTY;
        SINGLE_QUOTE_OR_SLASH = ByteString.Companion.encodeUtf8("'\\");
        DOUBLE_QUOTE_OR_SLASH = ByteString.Companion.encodeUtf8("\"\\");
        UNQUOTED_STRING_TERMINALS = ByteString.Companion.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
        LINEFEED_OR_CARRIAGE_RETURN = ByteString.Companion.encodeUtf8("\n\r");
        CLOSING_BLOCK_COMMENT = ByteString.Companion.encodeUtf8("*/");
    }

    public JsonUtf8Reader(BufferedSource bufferedSource) {
        this.source = bufferedSource;
        this.buffer = bufferedSource.getBuffer();
        pushScope(6);
    }

    @Override // com.squareup.moshi.JsonReader
    public final void beginArray() throws IOException {
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 3) {
            pushScope(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + peek() + " at path " + getPath());
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public final void beginObject() throws IOException {
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 1) {
            pushScope(3);
            this.peeked = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_OBJECT but was " + peek() + " at path " + getPath());
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
    public final void close() throws IOException {
        this.peeked = 0;
        this.scopes[0] = 8;
        this.stackSize = 1;
        this.buffer.clear();
        this.source.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01d9, code lost:            if (r11 != 0) goto L152;     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01db, code lost:            if (r11 == 0) goto L150;     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01dd, code lost:            r2 = r16;     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01e3, code lost:            r19.peekedLong = r2;        r14 = r18;        r14.skip(r9);        r7 = 16;        r19.peeked = 16;     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01e0, code lost:            r2 = -r16;     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01f1, code lost:            r14 = r18;        r1 = 2;     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f7, code lost:            if (r6 == r1) goto L159;     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01fa, code lost:            if (r6 == 4) goto L159;     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01fd, code lost:            if (r6 != 7) goto L178;     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01ff, code lost:            r19.peekedNumberLength = r9;        r7 = 17;        r19.peeked = 17;     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01f5, code lost:            r14 = r18;     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0206, code lost:            r14 = r18;     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01be, code lost:            r18 = r8;     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c4, code lost:            if (isLiteral(r1) != false) goto L160;     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01c6, code lost:            r1 = 2;     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01c7, code lost:            if (r6 != 2) goto L153;     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01c9, code lost:            if (r10 == false) goto L152;     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01cf, code lost:            if (r16 != Long.MIN_VALUE) goto L145;     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01d1, code lost:            if (r11 == 0) goto L152;     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01d7, code lost:            if (r16 != 0) goto L148;     */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0128 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x023c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int doPeek() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 778
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.doPeek():int");
    }

    @Override // com.squareup.moshi.JsonReader
    public final void endArray() throws IOException {
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
        throw new JsonDataException("Expected END_ARRAY but was " + peek() + " at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonReader
    public final void endObject() throws IOException {
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
        throw new JsonDataException("Expected END_OBJECT but was " + peek() + " at path " + getPath());
    }

    public final int findName(String str, JsonReader.Options options) {
        int length = options.strings.length;
        for (int r2 = 0; r2 < length; r2++) {
            if (str.equals(options.strings[r2])) {
                this.peeked = 0;
                this.pathNames[this.stackSize - 1] = str;
                return r2;
            }
        }
        return -1;
    }

    public final int findString(String str, JsonReader.Options options) {
        int length = options.strings.length;
        for (int r2 = 0; r2 < length; r2++) {
            if (str.equals(options.strings[r2])) {
                this.peeked = 0;
                int[] r5 = this.pathIndices;
                int r6 = this.stackSize - 1;
                r5[r6] = r5[r6] + 1;
                return r2;
            }
        }
        return -1;
    }

    @Override // com.squareup.moshi.JsonReader
    public final boolean hasNext() throws IOException {
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 != 2 && r0 != 4 && r0 != 18) {
            return true;
        }
        return false;
    }

    public final boolean isLiteral(int r2) throws IOException {
        if (r2 != 9 && r2 != 10 && r2 != 12 && r2 != 13 && r2 != 32) {
            if (r2 != 35) {
                if (r2 != 44) {
                    if (r2 != 47 && r2 != 61) {
                        if (r2 != 123 && r2 != 125 && r2 != 58) {
                            if (r2 != 59) {
                                switch (r2) {
                                    case 91:
                                    case 93:
                                        return false;
                                    case 92:
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

    @Override // com.squareup.moshi.JsonReader
    public final double nextDouble() throws IOException {
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 16) {
            this.peeked = 0;
            int[] r02 = this.pathIndices;
            int r1 = this.stackSize - 1;
            r02[r1] = r02[r1] + 1;
            return this.peekedLong;
        }
        if (r0 == 17) {
            this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
        } else if (r0 == 9) {
            this.peekedString = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (r0 == 8) {
            this.peekedString = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (r0 == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (r0 != 11) {
            throw new JsonDataException("Expected a double but was " + peek() + " at path " + getPath());
        }
        this.peeked = 11;
        try {
            double parseDouble = Double.parseDouble(this.peekedString);
            if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
            }
            this.peekedString = null;
            this.peeked = 0;
            int[] r2 = this.pathIndices;
            int r3 = this.stackSize - 1;
            r2[r3] = r2[r3] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.peekedString + " at path " + getPath());
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public final int nextInt() throws IOException {
        String nextQuotedValue;
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 16) {
            long j = this.peekedLong;
            int r5 = (int) j;
            if (j == r5) {
                this.peeked = 0;
                int[] r02 = this.pathIndices;
                int r1 = this.stackSize - 1;
                r02[r1] = r02[r1] + 1;
                return r5;
            }
            throw new JsonDataException("Expected an int but was " + this.peekedLong + " at path " + getPath());
        }
        if (r0 == 17) {
            this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
        } else if (r0 != 9 && r0 != 8) {
            if (r0 != 11) {
                throw new JsonDataException("Expected an int but was " + peek() + " at path " + getPath());
            }
        } else {
            if (r0 == 9) {
                nextQuotedValue = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            } else {
                nextQuotedValue = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
            }
            this.peekedString = nextQuotedValue;
            try {
                int parseInt = Integer.parseInt(nextQuotedValue);
                this.peeked = 0;
                int[] r12 = this.pathIndices;
                int r6 = this.stackSize - 1;
                r12[r6] = r12[r6] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        try {
            double parseDouble = Double.parseDouble(this.peekedString);
            int r52 = (int) parseDouble;
            if (r52 == parseDouble) {
                this.peekedString = null;
                this.peeked = 0;
                int[] r03 = this.pathIndices;
                int r13 = this.stackSize - 1;
                r03[r13] = r03[r13] + 1;
                return r52;
            }
            throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.peekedString + " at path " + getPath());
        }
    }

    public final String nextName() throws IOException {
        String str;
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 14) {
            str = nextUnquotedValue();
        } else if (r0 == 13) {
            str = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (r0 == 12) {
            str = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (r0 == 15) {
            str = this.peekedString;
        } else {
            throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:            r1.skip(r2 - 1);        r2 = com.squareup.moshi.JsonUtf8Reader.LINEFEED_OR_CARRIAGE_RETURN;     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:            if (r3 != 47) goto L56;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008e, code lost:            if (r3 != 35) goto L60;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0090, code lost:            checkLenient();        r2 = r5.indexOfElement(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0099, code lost:            if (r2 == (-1)) goto L44;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009b, code lost:            r2 = r2 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x009f, code lost:            r1.skip(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009d, code lost:            r2 = r1.size;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a4, code lost:            return r3;     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003c, code lost:            if (r5.request(2) != false) goto L19;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003f, code lost:            checkLenient();        r10 = r1.getByte(1);     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0048, code lost:            if (r10 == 42) goto L53;     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:            r1.readByte();        r1.readByte();        r3 = r5.indexOf(com.squareup.moshi.JsonUtf8Reader.CLOSING_BLOCK_COMMENT);     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:            if (r3 == (-1)) goto L31;     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0073, code lost:            r0 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:            if (r0 == false) goto L33;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:            r3 = r3 + r2.data.length;     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007e, code lost:            r1.skip(r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0081, code lost:            if (r0 == false) goto L58;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0085, code lost:            syntaxError("Unterminated comment");     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008b, code lost:            throw null;     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007c, code lost:            r3 = r1.size;     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x004a, code lost:            if (r10 == 47) goto L23;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x004d, code lost:            r1.readByte();        r1.readByte();        r2 = r5.indexOfElement(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0059, code lost:            if (r2 == (-1)) goto L26;     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x005b, code lost:            r2 = r2 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x005f, code lost:            r1.skip(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x005d, code lost:            r2 = r1.size;     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x004c, code lost:            return r3;     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x003e, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int nextNonWhitespace(boolean r13) throws java.io.IOException {
        /*
            r12 = this;
        L0:
            r0 = 0
            r1 = r0
        L2:
            int r2 = r1 + 1
            long r3 = (long) r2
            okio.BufferedSource r5 = r12.source
            boolean r3 = r5.request(r3)
            if (r3 == 0) goto La8
            long r3 = (long) r1
            okio.Buffer r1 = r12.buffer
            byte r3 = r1.getByte(r3)
            r4 = 10
            if (r3 == r4) goto La5
            r4 = 32
            if (r3 == r4) goto La5
            r4 = 13
            if (r3 == r4) goto La5
            r4 = 9
            if (r3 != r4) goto L26
            goto La5
        L26:
            int r2 = r2 + (-1)
            long r6 = (long) r2
            r1.skip(r6)
            okio.ByteString r2 = com.squareup.moshi.JsonUtf8Reader.LINEFEED_OR_CARRIAGE_RETURN
            r6 = 1
            r8 = -1
            r4 = 47
            if (r3 != r4) goto L8c
            r10 = 2
            boolean r10 = r5.request(r10)
            if (r10 != 0) goto L3f
            return r3
        L3f:
            r12.checkLenient()
            byte r10 = r1.getByte(r6)
            r11 = 42
            if (r10 == r11) goto L63
            if (r10 == r4) goto L4d
            return r3
        L4d:
            r1.readByte()
            r1.readByte()
            long r2 = r5.indexOfElement(r2)
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 == 0) goto L5d
            long r2 = r2 + r6
            goto L5f
        L5d:
            long r2 = r1.size
        L5f:
            r1.skip(r2)
            goto L0
        L63:
            r1.readByte()
            r1.readByte()
            okio.ByteString r2 = com.squareup.moshi.JsonUtf8Reader.CLOSING_BLOCK_COMMENT
            long r3 = r5.indexOf(r2)
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 == 0) goto L74
            r0 = 1
        L74:
            if (r0 == 0) goto L7c
            byte[] r2 = r2.data
            int r2 = r2.length
            long r5 = (long) r2
            long r3 = r3 + r5
            goto L7e
        L7c:
            long r3 = r1.size
        L7e:
            r1.skip(r3)
            if (r0 == 0) goto L85
            goto L0
        L85:
            java.lang.String r13 = "Unterminated comment"
            r12.syntaxError(r13)
            r13 = 0
            throw r13
        L8c:
            r0 = 35
            if (r3 != r0) goto La4
            r12.checkLenient()
            long r2 = r5.indexOfElement(r2)
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 == 0) goto L9d
            long r2 = r2 + r6
            goto L9f
        L9d:
            long r2 = r1.size
        L9f:
            r1.skip(r2)
            goto L0
        La4:
            return r3
        La5:
            r1 = r2
            goto L2
        La8:
            if (r13 != 0) goto Lac
            r13 = -1
            return r13
        Lac:
            java.io.EOFException r13 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Reader.nextNonWhitespace(boolean):int");
    }

    @Override // com.squareup.moshi.JsonReader
    public final void nextNull() throws IOException {
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
        throw new JsonDataException("Expected null but was " + peek() + " at path " + getPath());
    }

    public final String nextQuotedValue(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement != -1) {
                Buffer buffer = this.buffer;
                if (buffer.getByte(indexOfElement) == 92) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(buffer.readUtf8(indexOfElement));
                    buffer.readByte();
                    sb.append(readEscapeCharacter());
                } else {
                    if (sb == null) {
                        String readUtf8 = buffer.readUtf8(indexOfElement);
                        buffer.readByte();
                        return readUtf8;
                    }
                    sb.append(buffer.readUtf8(indexOfElement));
                    buffer.readByte();
                    return sb.toString();
                }
            } else {
                syntaxError("Unterminated string");
                throw null;
            }
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public final String nextString() throws IOException {
        String readUtf8;
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 == 10) {
            readUtf8 = nextUnquotedValue();
        } else if (r0 == 9) {
            readUtf8 = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (r0 == 8) {
            readUtf8 = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (r0 == 11) {
            readUtf8 = this.peekedString;
            this.peekedString = null;
        } else if (r0 == 16) {
            readUtf8 = Long.toString(this.peekedLong);
        } else if (r0 == 17) {
            readUtf8 = this.buffer.readUtf8(this.peekedNumberLength);
        } else {
            throw new JsonDataException("Expected a string but was " + peek() + " at path " + getPath());
        }
        this.peeked = 0;
        int[] r1 = this.pathIndices;
        int r2 = this.stackSize - 1;
        r1[r2] = r1[r2] + 1;
        return readUtf8;
    }

    public final String nextUnquotedValue() throws IOException {
        long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        Buffer buffer = this.buffer;
        if (indexOfElement != -1) {
            return buffer.readUtf8(indexOfElement);
        }
        return buffer.readUtf8();
    }

    @Override // com.squareup.moshi.JsonReader
    public final JsonReader.Token peek() throws IOException {
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        switch (r0) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final char readEscapeCharacter() throws IOException {
        int r8;
        int r82;
        BufferedSource bufferedSource = this.source;
        if (bufferedSource.request(1L)) {
            Buffer buffer = this.buffer;
            byte readByte = buffer.readByte();
            if (readByte != 10 && readByte != 34 && readByte != 39 && readByte != 47 && readByte != 92) {
                if (readByte != 98) {
                    if (readByte != 102) {
                        if (readByte == 110) {
                            return '\n';
                        }
                        if (readByte != 114) {
                            if (readByte != 116) {
                                if (readByte != 117) {
                                    if (this.lenient) {
                                        return (char) readByte;
                                    }
                                    syntaxError("Invalid escape sequence: \\" + ((char) readByte));
                                    throw null;
                                }
                                if (bufferedSource.request(4L)) {
                                    char c = 0;
                                    for (int r0 = 0; r0 < 4; r0++) {
                                        byte b = buffer.getByte(r0);
                                        char c2 = (char) (c << 4);
                                        if (b >= 48 && b <= 57) {
                                            r82 = b - 48;
                                        } else {
                                            if (b >= 97 && b <= 102) {
                                                r8 = b - 97;
                                            } else {
                                                if (b < 65 || b > 70) {
                                                    syntaxError("\\u".concat(buffer.readUtf8(4L)));
                                                    throw null;
                                                }
                                                r8 = b - 65;
                                            }
                                            r82 = r8 + 10;
                                        }
                                        c = (char) (r82 + c2);
                                    }
                                    buffer.skip(4L);
                                    return c;
                                }
                                throw new EOFException("Unterminated escape sequence at path " + getPath());
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\f';
                }
                return '\b';
            }
            return (char) readByte;
        }
        syntaxError("Unterminated escape sequence");
        throw null;
    }

    @Override // com.squareup.moshi.JsonReader
    public final int selectName(JsonReader.Options options) throws IOException {
        int r0 = this.peeked;
        if (r0 == 0) {
            r0 = doPeek();
        }
        if (r0 < 12 || r0 > 15) {
            return -1;
        }
        if (r0 == 15) {
            return findName(this.peekedString, options);
        }
        int select = this.source.select(options.doubleQuoteSuffix);
        if (select != -1) {
            this.peeked = 0;
            this.pathNames[this.stackSize - 1] = options.strings[select];
            return select;
        }
        String str = this.pathNames[this.stackSize - 1];
        String nextName = nextName();
        int findName = findName(nextName, options);
        if (findName == -1) {
            this.peeked = 15;
            this.peekedString = nextName;
            this.pathNames[this.stackSize - 1] = str;
        }
        return findName;
    }

    @Override // com.squareup.moshi.JsonReader
    public final void skipName() throws IOException {
        if (!this.failOnUnknown) {
            int r0 = this.peeked;
            if (r0 == 0) {
                r0 = doPeek();
            }
            if (r0 == 14) {
                long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
                Buffer buffer = this.buffer;
                if (indexOfElement == -1) {
                    indexOfElement = buffer.size;
                }
                buffer.skip(indexOfElement);
            } else if (r0 == 13) {
                skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            } else if (r0 == 12) {
                skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
            } else if (r0 != 15) {
                throw new JsonDataException("Expected a name but was " + peek() + " at path " + getPath());
            }
            this.peeked = 0;
            this.pathNames[this.stackSize - 1] = Constants.NULL_VERSION_ID;
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
    }

    public final void skipQuotedValue(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement != -1) {
                Buffer buffer = this.buffer;
                if (buffer.getByte(indexOfElement) == 92) {
                    buffer.skip(indexOfElement + 1);
                    readEscapeCharacter();
                } else {
                    buffer.skip(indexOfElement + 1);
                    return;
                }
            } else {
                syntaxError("Unterminated string");
                throw null;
            }
        }
    }

    @Override // com.squareup.moshi.JsonReader
    public final void skipValue() throws IOException {
        if (!this.failOnUnknown) {
            int r1 = 0;
            do {
                int r2 = this.peeked;
                if (r2 == 0) {
                    r2 = doPeek();
                }
                if (r2 == 3) {
                    pushScope(1);
                } else if (r2 == 1) {
                    pushScope(3);
                } else {
                    if (r2 == 4) {
                        this.stackSize--;
                    } else if (r2 == 2) {
                        this.stackSize--;
                    } else {
                        Buffer buffer = this.buffer;
                        if (r2 != 14 && r2 != 10) {
                            if (r2 != 9 && r2 != 13) {
                                if (r2 != 8 && r2 != 12) {
                                    if (r2 == 17) {
                                        buffer.skip(this.peekedNumberLength);
                                    }
                                } else {
                                    skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
                                }
                            } else {
                                skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                            }
                        } else {
                            long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
                            if (indexOfElement == -1) {
                                indexOfElement = buffer.size;
                            }
                            buffer.skip(indexOfElement);
                        }
                        this.peeked = 0;
                    }
                    r1--;
                    this.peeked = 0;
                }
                r1++;
                this.peeked = 0;
            } while (r1 != 0);
            int[] r0 = this.pathIndices;
            int r12 = this.stackSize;
            int r22 = r12 - 1;
            r0[r22] = r0[r22] + 1;
            this.pathNames[r12 - 1] = Constants.NULL_VERSION_ID;
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + peek() + " at " + getPath());
    }

    public final String toString() {
        return "JsonReader(" + this.source + ")";
    }
}
