package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.amazonaws.services.s3.internal.Constants;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.RealBufferedSource;

/* loaded from: classes.dex */
public final class JsonUtf8Reader extends JsonReader {
    public static final ByteString DOUBLE_QUOTE_OR_SLASH;
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
        ByteString.Companion.encodeUtf8("\n\r");
        ByteString.Companion.encodeUtf8("*/");
    }

    public JsonUtf8Reader(RealBufferedSource realBufferedSource) {
        this.source = realBufferedSource;
        this.buffer = realBufferedSource.bufferField;
        pushScope(6);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
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

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
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

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01bf, code lost:            if (r4 != 7) goto L413;     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01c1, code lost:            r17.peekedNumberLength = r3;        r8 = 17;        r17.peeked = 17;     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0194, code lost:            if (isLiteral(r1) != false) goto L413;     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0196, code lost:            if (r4 != 2) goto L390;     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0198, code lost:            if (r6 == false) goto L390;     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x019e, code lost:            if (r10 != Long.MIN_VALUE) goto L383;     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01a0, code lost:            if (r7 == false) goto L390;     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01a6, code lost:            if (r10 != 0) goto L386;     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01a8, code lost:            if (r7 != false) goto L390;     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01aa, code lost:            if (r7 == false) goto L388;     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01ad, code lost:            r10 = -r10;     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01ae, code lost:            r17.peekedLong = r10;        r5.skip(r3);        r8 = 16;        r17.peeked = 16;     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01b9, code lost:            if (r4 == 2) goto L395;     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01bc, code lost:            if (r4 == 4) goto L395;     */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0113 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int doPeek() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 683
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonUtf8Reader.doPeek():int");
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
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

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
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

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
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
            throw null;
        }
        return false;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final boolean nextBoolean() throws IOException {
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
        throw new JsonDataException("Expected a boolean but was " + peek() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
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
            if (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble)) {
                this.peekedString = null;
                this.peeked = 0;
                int[] r2 = this.pathIndices;
                int r3 = this.stackSize - 1;
                r2[r3] = r2[r3] + 1;
                return parseDouble;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.peekedString + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
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

    public final int nextNonWhitespace(boolean z) throws IOException {
        int r0 = 0;
        while (true) {
            int r1 = r0 + 1;
            BufferedSource bufferedSource = this.source;
            if (bufferedSource.request(r1)) {
                long j = r0;
                Buffer buffer = this.buffer;
                byte b = buffer.getByte(j);
                if (b != 10 && b != 32 && b != 13 && b != 9) {
                    buffer.skip(r1 - 1);
                    if (b == 47) {
                        if (!bufferedSource.request(2L)) {
                            return b;
                        }
                        checkLenient();
                        throw null;
                    }
                    if (b != 35) {
                        return b;
                    }
                    checkLenient();
                    throw null;
                }
                r0 = r1;
            } else {
                if (!z) {
                    return -1;
                }
                throw new EOFException("End of input");
            }
        }
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

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
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

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
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
                                if (readByte == 117) {
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
                                syntaxError("Invalid escape sequence: \\" + ((char) readByte));
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
            return (char) readByte;
        }
        syntaxError("Unterminated escape sequence");
        throw null;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
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

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final void skipName() throws IOException {
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

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final void skipValue() throws IOException {
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
                    r1--;
                    if (r1 >= 0) {
                        this.stackSize--;
                    } else {
                        throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                    }
                } else if (r2 == 2) {
                    r1--;
                    if (r1 >= 0) {
                        this.stackSize--;
                    } else {
                        throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
                    }
                } else {
                    Buffer buffer = this.buffer;
                    if (r2 != 14 && r2 != 10) {
                        if (r2 != 9 && r2 != 13) {
                            if (r2 != 8 && r2 != 12) {
                                if (r2 == 17) {
                                    buffer.skip(this.peekedNumberLength);
                                } else if (r2 == 18) {
                                    throw new JsonDataException("Expected a value but was " + peek() + " at path " + getPath());
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
                }
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
    }

    public final String toString() {
        return "JsonReader(" + this.source + ")";
    }
}
