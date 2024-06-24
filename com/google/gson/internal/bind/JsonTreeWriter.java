package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class JsonTreeWriter extends JsonWriter {
    public String pendingName;
    public JsonElement product;
    public final ArrayList stack;
    public static final AnonymousClass1 UNWRITABLE_WRITER = new Writer() { // from class: com.google.gson.internal.bind.JsonTreeWriter.1
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int r2, int r3) {
            throw new AssertionError();
        }
    };
    public static final JsonPrimitive SENTINEL_CLOSED = new JsonPrimitive("closed");

    public JsonTreeWriter() {
        super(UNWRITABLE_WRITER);
        this.stack = new ArrayList();
        this.product = JsonNull.INSTANCE;
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void beginArray() throws IOException {
        JsonArray jsonArray = new JsonArray();
        put(jsonArray);
        this.stack.add(jsonArray);
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void beginObject() throws IOException {
        JsonObject jsonObject = new JsonObject();
        put(jsonObject);
        this.stack.add(jsonObject);
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ArrayList arrayList = this.stack;
        if (arrayList.isEmpty()) {
            arrayList.add(SENTINEL_CLOSED);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void endArray() throws IOException {
        ArrayList arrayList = this.stack;
        if (!arrayList.isEmpty() && this.pendingName == null) {
            if (peek() instanceof JsonArray) {
                arrayList.remove(arrayList.size() - 1);
                return;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void endObject() throws IOException {
        ArrayList arrayList = this.stack;
        if (!arrayList.isEmpty() && this.pendingName == null) {
            if (peek() instanceof JsonObject) {
                arrayList.remove(arrayList.size() - 1);
                return;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void name(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (!this.stack.isEmpty() && this.pendingName == null) {
            if (peek() instanceof JsonObject) {
                this.pendingName = str;
                return;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public final JsonWriter nullValue() throws IOException {
        put(JsonNull.INSTANCE);
        return this;
    }

    public final JsonElement peek() {
        return (JsonElement) this.stack.get(r0.size() - 1);
    }

    public final void put(JsonElement jsonElement) {
        if (this.pendingName != null) {
            jsonElement.getClass();
            if (!(jsonElement instanceof JsonNull) || this.serializeNulls) {
                JsonObject jsonObject = (JsonObject) peek();
                jsonObject.members.put(this.pendingName, jsonElement);
            }
            this.pendingName = null;
            return;
        }
        if (this.stack.isEmpty()) {
            this.product = jsonElement;
            return;
        }
        JsonElement peek = peek();
        if (peek instanceof JsonArray) {
            JsonArray jsonArray = (JsonArray) peek;
            if (jsonElement == null) {
                jsonArray.getClass();
                jsonElement = JsonNull.INSTANCE;
            }
            jsonArray.elements.add(jsonElement);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void value(Boolean bool) throws IOException {
        if (bool == null) {
            put(JsonNull.INSTANCE);
        } else {
            put(new JsonPrimitive(bool));
        }
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void value(Number number) throws IOException {
        if (number == null) {
            put(JsonNull.INSTANCE);
            return;
        }
        if (!this.lenient) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        put(new JsonPrimitive(number));
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void value(String str) throws IOException {
        if (str == null) {
            put(JsonNull.INSTANCE);
        } else {
            put(new JsonPrimitive(str));
        }
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void value(boolean z) throws IOException {
        put(new JsonPrimitive(Boolean.valueOf(z)));
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void value(long j) throws IOException {
        put(new JsonPrimitive(Long.valueOf(j)));
    }

    @Override // com.google.gson.stream.JsonWriter
    public final void value(double d) throws IOException {
        if (!this.lenient && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d);
        }
        put(new JsonPrimitive(Double.valueOf(d)));
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public final void flush() throws IOException {
    }
}
