package com.google.gson.stream;

import com.amazonaws.services.s3.internal.Constants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class JsonWriter implements Closeable, Flushable {
    public static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    public String deferredName;
    public boolean htmlSafe;
    public boolean lenient;
    public final Writer out;
    public String separator;
    public boolean serializeNulls;
    public int[] stack;
    public int stackSize;
    public static final Pattern VALID_JSON_NUMBER_PATTERN = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    public static final String[] REPLACEMENT_CHARS = new String[128];

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
        String[] strArr2 = (String[]) strArr.clone();
        HTML_SAFE_REPLACEMENT_CHARS = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        int[] r0 = new int[32];
        this.stack = r0;
        this.stackSize = 0;
        if (r0.length == 0) {
            this.stack = Arrays.copyOf(r0, 0 * 2);
        }
        int[] r02 = this.stack;
        int r1 = this.stackSize;
        this.stackSize = r1 + 1;
        r02[r1] = 6;
        this.separator = ":";
        this.serializeNulls = true;
        Objects.requireNonNull(writer, "out == null");
        this.out = writer;
    }

    public final void beforeValue() throws IOException {
        int peek = peek();
        if (peek != 1) {
            Writer writer = this.out;
            if (peek != 2) {
                if (peek != 4) {
                    if (peek != 6) {
                        if (peek == 7) {
                            if (!this.lenient) {
                                throw new IllegalStateException("JSON must have only one top-level value.");
                            }
                        } else {
                            throw new IllegalStateException("Nesting problem.");
                        }
                    }
                    this.stack[this.stackSize - 1] = 7;
                    return;
                }
                writer.append((CharSequence) this.separator);
                this.stack[this.stackSize - 1] = 5;
                return;
            }
            writer.append(',');
            newline();
            return;
        }
        this.stack[this.stackSize - 1] = 2;
        newline();
    }

    public void beginArray() throws IOException {
        writeDeferredName();
        beforeValue();
        int r0 = this.stackSize;
        int[] r1 = this.stack;
        if (r0 == r1.length) {
            this.stack = Arrays.copyOf(r1, r0 * 2);
        }
        int[] r02 = this.stack;
        int r12 = this.stackSize;
        this.stackSize = r12 + 1;
        r02[r12] = 1;
        this.out.write(91);
    }

    public void beginObject() throws IOException {
        writeDeferredName();
        beforeValue();
        int r0 = this.stackSize;
        int[] r1 = this.stack;
        if (r0 == r1.length) {
            this.stack = Arrays.copyOf(r1, r0 * 2);
        }
        int[] r02 = this.stack;
        int r12 = this.stackSize;
        this.stackSize = r12 + 1;
        r02[r12] = 3;
        this.out.write(123);
    }

    public final void close(int r2, int r3, char c) throws IOException {
        int peek = peek();
        if (peek != r3 && peek != r2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.deferredName == null) {
            this.stackSize--;
            if (peek == r3) {
                newline();
            }
            this.out.write(c);
            return;
        }
        throw new IllegalStateException("Dangling name: " + this.deferredName);
    }

    public void endArray() throws IOException {
        close(1, 2, ']');
    }

    public void endObject() throws IOException {
        close(3, 5, '}');
    }

    public void flush() throws IOException {
        if (this.stackSize != 0) {
            this.out.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public void name(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.deferredName == null) {
            if (this.stackSize != 0) {
                this.deferredName = str;
                return;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new IllegalStateException();
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) {
            if (this.serializeNulls) {
                writeDeferredName();
            } else {
                this.deferredName = null;
                return this;
            }
        }
        beforeValue();
        this.out.write(Constants.NULL_VERSION_ID);
        return this;
    }

    public final int peek() {
        int r0 = this.stackSize;
        if (r0 != 0) {
            return this.stack[r0 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void string(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.htmlSafe
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.google.gson.stream.JsonWriter.HTML_SAFE_REPLACEMENT_CHARS
            goto L9
        L7:
            java.lang.String[] r0 = com.google.gson.stream.JsonWriter.REPLACEMENT_CHARS
        L9:
            java.io.Writer r1 = r8.out
            r2 = 34
            r1.write(r2)
            int r3 = r9.length()
            r4 = 0
            r5 = r4
        L16:
            if (r4 >= r3) goto L41
            char r6 = r9.charAt(r4)
            r7 = 128(0x80, float:1.8E-43)
            if (r6 >= r7) goto L25
            r6 = r0[r6]
            if (r6 != 0) goto L32
            goto L3e
        L25:
            r7 = 8232(0x2028, float:1.1535E-41)
            if (r6 != r7) goto L2c
            java.lang.String r6 = "\\u2028"
            goto L32
        L2c:
            r7 = 8233(0x2029, float:1.1537E-41)
            if (r6 != r7) goto L3e
            java.lang.String r6 = "\\u2029"
        L32:
            if (r5 >= r4) goto L39
            int r7 = r4 - r5
            r1.write(r9, r5, r7)
        L39:
            r1.write(r6)
            int r5 = r4 + 1
        L3e:
            int r4 = r4 + 1
            goto L16
        L41:
            if (r5 >= r3) goto L47
            int r3 = r3 - r5
            r1.write(r9, r5, r3)
        L47:
            r1.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonWriter.string(java.lang.String):void");
    }

    public void value(String str) throws IOException {
        if (str == null) {
            nullValue();
            return;
        }
        writeDeferredName();
        beforeValue();
        string(str);
    }

    public final void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            int peek = peek();
            if (peek == 5) {
                this.out.write(44);
            } else if (peek != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            newline();
            this.stack[this.stackSize - 1] = 4;
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public void value(boolean z) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(z ? "true" : "false");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int r0 = this.stackSize;
        if (r0 <= 1 && (r0 != 1 || this.stack[r0 - 1] == 7)) {
            this.stackSize = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public void value(Boolean bool) throws IOException {
        if (bool == null) {
            nullValue();
            return;
        }
        writeDeferredName();
        beforeValue();
        this.out.write(bool.booleanValue() ? "true" : "false");
    }

    public void value(double d) throws IOException {
        writeDeferredName();
        if (!this.lenient && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
        beforeValue();
        this.out.append((CharSequence) Double.toString(d));
    }

    public final void newline() throws IOException {
    }

    public void value(long j) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(j));
    }

    public void value(Number number) throws IOException {
        if (number == null) {
            nullValue();
            return;
        }
        writeDeferredName();
        String obj = number.toString();
        if (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!(cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class) && !VALID_JSON_NUMBER_PATTERN.matcher(obj).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + obj);
            }
        } else if (!this.lenient) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(obj));
        }
        beforeValue();
        this.out.append((CharSequence) obj);
    }
}
