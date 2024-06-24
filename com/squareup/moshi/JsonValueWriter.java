package com.squareup.moshi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class JsonValueWriter extends JsonWriter {
    public String deferredName;
    public Object[] stack = new Object[32];

    public JsonValueWriter() {
        pushScope(6);
    }

    public final void add(Object obj) {
        String str;
        Object put;
        int peekScope = peekScope();
        int r1 = this.stackSize;
        if (r1 == 1) {
            if (peekScope == 6) {
                this.scopes[r1 - 1] = 7;
                this.stack[r1 - 1] = obj;
                return;
            }
            throw new IllegalStateException("JSON must have only one top-level value.");
        }
        if (peekScope == 3 && (str = this.deferredName) != null) {
            if ((obj == null && !this.serializeNulls) || (put = ((Map) this.stack[r1 - 1]).put(str, obj)) == null) {
                this.deferredName = null;
                return;
            }
            throw new IllegalArgumentException("Map key '" + this.deferredName + "' has multiple values at path " + getPath() + ": " + put + " and " + obj);
        }
        if (peekScope == 1) {
            ((List) this.stack[r1 - 1]).add(obj);
            return;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter beginArray() throws IOException {
        if (!this.promoteValueToName) {
            int r0 = this.stackSize;
            int r1 = this.flattenStackSize;
            if (r0 == r1 && this.scopes[r0 - 1] == 1) {
                this.flattenStackSize = ~r1;
                return this;
            }
            checkStack();
            ArrayList arrayList = new ArrayList();
            add(arrayList);
            Object[] objArr = this.stack;
            int r3 = this.stackSize;
            objArr[r3] = arrayList;
            this.pathIndices[r3] = 0;
            pushScope(1);
            return this;
        }
        throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter beginObject() throws IOException {
        if (!this.promoteValueToName) {
            int r0 = this.stackSize;
            int r1 = this.flattenStackSize;
            if (r0 == r1 && this.scopes[r0 - 1] == 3) {
                this.flattenStackSize = ~r1;
                return this;
            }
            checkStack();
            LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
            add(linkedHashTreeMap);
            this.stack[this.stackSize] = linkedHashTreeMap;
            pushScope(3);
            return this;
        }
        throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int r0 = this.stackSize;
        if (r0 <= 1 && (r0 != 1 || this.scopes[r0 - 1] == 7)) {
            this.stackSize = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter endArray() throws IOException {
        if (peekScope() == 1) {
            int r0 = this.stackSize;
            int r2 = this.flattenStackSize;
            if (r0 == (~r2)) {
                this.flattenStackSize = ~r2;
                return this;
            }
            int r02 = r0 - 1;
            this.stackSize = r02;
            this.stack[r02] = null;
            int[] r22 = this.pathIndices;
            int r03 = r02 - 1;
            r22[r03] = r22[r03] + 1;
            return this;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter endObject() throws IOException {
        if (peekScope() == 3) {
            if (this.deferredName == null) {
                int r0 = this.stackSize;
                int r1 = this.flattenStackSize;
                if (r0 == (~r1)) {
                    this.flattenStackSize = ~r1;
                    return this;
                }
                this.promoteValueToName = false;
                int r02 = r0 - 1;
                this.stackSize = r02;
                this.stack[r02] = null;
                this.pathNames[r02] = null;
                int[] r12 = this.pathIndices;
                int r03 = r02 - 1;
                r12[r03] = r12[r03] + 1;
                return this;
            }
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
        throw new IllegalStateException("Nesting problem.");
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        if (this.stackSize != 0) {
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter name(String str) throws IOException {
        if (str != null) {
            if (this.stackSize != 0) {
                if (peekScope() == 3 && this.deferredName == null) {
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
            add(null);
            int[] r0 = this.pathIndices;
            int r1 = this.stackSize - 1;
            r0[r1] = r0[r1] + 1;
            return this;
        }
        throw new IllegalStateException("null cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter value(String str) throws IOException {
        if (this.promoteValueToName) {
            name(str);
            return this;
        }
        add(str);
        int[] r3 = this.pathIndices;
        int r0 = this.stackSize - 1;
        r3[r0] = r3[r0] + 1;
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter value(boolean z) throws IOException {
        if (!this.promoteValueToName) {
            add(Boolean.valueOf(z));
            int[] r3 = this.pathIndices;
            int r0 = this.stackSize - 1;
            r3[r0] = r3[r0] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter value(double d) throws IOException {
        if (!this.lenient && (Double.isNaN(d) || d == Double.NEGATIVE_INFINITY || d == Double.POSITIVE_INFINITY)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
        if (this.promoteValueToName) {
            name(Double.toString(d));
            return this;
        }
        add(Double.valueOf(d));
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
        add(Long.valueOf(j));
        int[] r2 = this.pathIndices;
        int r3 = this.stackSize - 1;
        r2[r3] = r2[r3] + 1;
        return this;
    }

    @Override // com.squareup.moshi.JsonWriter
    public final JsonWriter value(Number number) throws IOException {
        BigDecimal bigDecimal;
        if (!(number instanceof Byte) && !(number instanceof Short) && !(number instanceof Integer) && !(number instanceof Long)) {
            if ((number instanceof Float) || (number instanceof Double)) {
                value(number.doubleValue());
                return this;
            }
            if (number == null) {
                nullValue();
                return this;
            }
            if (number instanceof BigDecimal) {
                bigDecimal = (BigDecimal) number;
            } else {
                bigDecimal = new BigDecimal(number.toString());
            }
            if (this.promoteValueToName) {
                name(bigDecimal.toString());
                return this;
            }
            add(bigDecimal);
            int[] r3 = this.pathIndices;
            int r0 = this.stackSize - 1;
            r3[r0] = r3[r0] + 1;
            return this;
        }
        value(number.longValue());
        return this;
    }
}
