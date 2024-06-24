package com.squareup.moshi;

import com.amazonaws.services.s3.internal.Constants;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;

/* loaded from: classes3.dex */
public final class JsonUtf8Writer extends JsonWriter {
    public static final String[] REPLACEMENT_CHARS = new String[128];
    public String deferredName;
    public final BufferedSink sink;

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

    public JsonUtf8Writer(Buffer buffer) {
        this.sink = buffer;
        pushScope(6);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void string(okio.BufferedSink r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = com.squareup.moshi.JsonUtf8Writer.REPLACEMENT_CHARS
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.writeUtf8(r4, r3, r8)
        L2e:
            r7.writeUtf8(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.writeUtf8(r4, r2, r8)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.JsonUtf8Writer.string(okio.BufferedSink, java.lang.String):void");
    }

    public final void beforeValue() throws IOException {
        int peekScope = peekScope();
        if (peekScope != 1) {
            BufferedSink bufferedSink = this.sink;
            if (peekScope != 2) {
                if (peekScope != 4) {
                    if (peekScope != 6) {
                        if (peekScope == 7) {
                            if (!this.lenient) {
                                throw new IllegalStateException("JSON must have only one top-level value.");
                            }
                        } else {
                            throw new IllegalStateException("Nesting problem.");
                        }
                    }
                    this.scopes[this.stackSize - 1] = 7;
                    return;
                }
                bufferedSink.writeUtf8(":");
                this.scopes[this.stackSize - 1] = 5;
                return;
            }
            bufferedSink.writeByte(44);
            return;
        }
        this.scopes[this.stackSize - 1] = 2;
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter beginArray() throws IOException {
        if (!this.promoteValueToName) {
            writeDeferredName();
            open(1, 2, "[");
            return this;
        }
        throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter beginObject() throws IOException {
        if (!this.promoteValueToName) {
            writeDeferredName();
            open(3, 5, "{");
            return this;
        }
        throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + getPath());
    }

    public final void close(int r2, int r3, String str) throws IOException {
        int peekScope = peekScope();
        if (peekScope != r3 && peekScope != r2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.deferredName == null) {
            int r22 = this.stackSize;
            int r32 = ~this.flattenStackSize;
            if (r22 == r32) {
                this.flattenStackSize = r32;
                return;
            }
            int r23 = r22 - 1;
            this.stackSize = r23;
            this.pathNames[r23] = null;
            int[] r33 = this.pathIndices;
            int r24 = r23 - 1;
            r33[r24] = r33[r24] + 1;
            this.sink.writeUtf8(str);
            return;
        }
        throw new IllegalStateException("Dangling name: " + this.deferredName);
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter endArray() throws IOException {
        close(1, 2, "]");
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter endObject() throws IOException {
        this.promoteValueToName = false;
        close(3, 5, "}");
        return this;
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        if (this.stackSize != 0) {
            this.sink.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter name(String str) throws IOException {
        if (str != null) {
            if (this.stackSize != 0) {
                int peekScope = peekScope();
                if ((peekScope == 3 || peekScope == 5) && this.deferredName == null) {
                    this.deferredName = str;
                    this.pathNames[this.stackSize - 1] = str;
                    this.promoteValueToName = false;
                    return this;
                }
                throw new IllegalStateException("Nesting problem.");
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new NullPointerException("name == null");
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter nullValue() throws IOException {
        if (!this.promoteValueToName) {
            if (this.deferredName != null) {
                if (this.serializeNulls) {
                    writeDeferredName();
                } else {
                    this.deferredName = null;
                    return this;
                }
            }
            beforeValue();
            this.sink.writeUtf8(Constants.NULL_VERSION_ID);
            int[] r0 = this.pathIndices;
            int r1 = this.stackSize - 1;
            r0[r1] = r0[r1] + 1;
            return this;
        }
        throw new IllegalStateException("null cannot be used as a map key in JSON at path " + getPath());
    }

    public final void open(int r4, int r5, String str) throws IOException {
        int r0;
        int r02 = this.stackSize;
        int r1 = this.flattenStackSize;
        if (r02 == r1 && ((r0 = this.scopes[r02 - 1]) == r4 || r0 == r5)) {
            this.flattenStackSize = ~r1;
            return;
        }
        beforeValue();
        checkStack();
        pushScope(r4);
        this.pathIndices[this.stackSize - 1] = 0;
        this.sink.writeUtf8(str);
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter value(String str) throws IOException {
        if (str == null) {
            nullValue();
            return this;
        }
        if (this.promoteValueToName) {
            name(str);
            return this;
        }
        writeDeferredName();
        beforeValue();
        string(this.sink, str);
        int[] r3 = this.pathIndices;
        int r0 = this.stackSize - 1;
        r3[r0] = r3[r0] + 1;
        return this;
    }

    public final void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            int peekScope = peekScope();
            BufferedSink bufferedSink = this.sink;
            if (peekScope == 5) {
                bufferedSink.writeByte(44);
            } else if (peekScope != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            this.scopes[this.stackSize - 1] = 4;
            string(bufferedSink, this.deferredName);
            this.deferredName = null;
        }
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter value(boolean z) throws IOException {
        if (!this.promoteValueToName) {
            writeDeferredName();
            beforeValue();
            this.sink.writeUtf8(z ? "true" : "false");
            int[] r3 = this.pathIndices;
            int r0 = this.stackSize - 1;
            r3[r0] = r3[r0] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.sink.close();
        int r0 = this.stackSize;
        if (r0 <= 1 && (r0 != 1 || this.scopes[r0 - 1] == 7)) {
            this.stackSize = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter value(double d) throws IOException {
        if (!this.lenient && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
        if (this.promoteValueToName) {
            name(Double.toString(d));
            return this;
        }
        writeDeferredName();
        beforeValue();
        this.sink.writeUtf8(Double.toString(d));
        int[] r4 = this.pathIndices;
        int r5 = this.stackSize - 1;
        r4[r5] = r4[r5] + 1;
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter value(long j) throws IOException {
        if (this.promoteValueToName) {
            name(Long.toString(j));
            return this;
        }
        writeDeferredName();
        beforeValue();
        this.sink.writeUtf8(Long.toString(j));
        int[] r2 = this.pathIndices;
        int r3 = this.stackSize - 1;
        r2[r3] = r2[r3] + 1;
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter value(Number number) throws IOException {
        if (number == null) {
            nullValue();
            return this;
        }
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        if (this.promoteValueToName) {
            name(obj);
            return this;
        }
        writeDeferredName();
        beforeValue();
        this.sink.writeUtf8(obj);
        int[] r4 = this.pathIndices;
        int r0 = this.stackSize - 1;
        r4[r0] = r4[r0] + 1;
        return this;
    }
}
