package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class JsonTreeReader extends JsonReader {
    public static final Object SENTINEL_CLOSED;
    public int[] pathIndices;
    public String[] pathNames;
    public Object[] stack;
    public int stackSize;

    /* renamed from: com.google.gson.internal.bind.JsonTreeReader$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] r0 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r0;
            try {
                r0[JsonToken.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        new Reader() { // from class: com.google.gson.internal.bind.JsonTreeReader.1
            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                throw new AssertionError();
            }

            @Override // java.io.Reader
            public final int read(char[] cArr, int r2, int r3) {
                throw new AssertionError();
            }
        };
        SENTINEL_CLOSED = new Object();
    }

    private String getPath(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        int r1 = 0;
        while (true) {
            int r2 = this.stackSize;
            if (r1 < r2) {
                Object[] objArr = this.stack;
                Object obj = objArr[r1];
                if (obj instanceof JsonArray) {
                    r1++;
                    if (r1 < r2 && (objArr[r1] instanceof Iterator)) {
                        int r3 = this.pathIndices[r1];
                        if (z && r3 > 0 && (r1 == r2 - 1 || r1 == r2 - 2)) {
                            r3--;
                        }
                        sb.append('[');
                        sb.append(r3);
                        sb.append(']');
                    }
                } else if ((obj instanceof JsonObject) && (r1 = r1 + 1) < r2 && (objArr[r1] instanceof Iterator)) {
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

    private String locationString() {
        return " at path " + getPath(false);
    }

    @Override // com.google.gson.stream.JsonReader
    public final void beginArray() throws IOException {
        expect(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) peekStack()).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public final void beginObject() throws IOException {
        expect(JsonToken.BEGIN_OBJECT);
        push(new LinkedTreeMap.EntrySet.AnonymousClass1((LinkedTreeMap.EntrySet) ((JsonObject) peekStack()).members.entrySet()));
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.stack = new Object[]{SENTINEL_CLOSED};
        this.stackSize = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public final void endArray() throws IOException {
        expect(JsonToken.END_ARRAY);
        popStack();
        popStack();
        int r0 = this.stackSize;
        if (r0 > 0) {
            int[] r1 = this.pathIndices;
            int r02 = r0 - 1;
            r1[r02] = r1[r02] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public final void endObject() throws IOException {
        expect(JsonToken.END_OBJECT);
        this.pathNames[this.stackSize - 1] = null;
        popStack();
        popStack();
        int r0 = this.stackSize;
        if (r0 > 0) {
            int[] r1 = this.pathIndices;
            int r02 = r0 - 1;
            r1[r02] = r1[r02] + 1;
        }
    }

    public final void expect(JsonToken jsonToken) throws IOException {
        if (peek() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public final String getPreviousPath() {
        return getPath(true);
    }

    @Override // com.google.gson.stream.JsonReader
    public final boolean hasNext() throws IOException {
        JsonToken peek = peek();
        if (peek != JsonToken.END_OBJECT && peek != JsonToken.END_ARRAY && peek != JsonToken.END_DOCUMENT) {
            return true;
        }
        return false;
    }

    @Override // com.google.gson.stream.JsonReader
    public final boolean nextBoolean() throws IOException {
        expect(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) popStack()).getAsBoolean();
        int r1 = this.stackSize;
        if (r1 > 0) {
            int[] r2 = this.pathIndices;
            int r12 = r1 - 1;
            r2[r12] = r2[r12] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.JsonReader
    public final double nextDouble() throws IOException {
        double parseDouble;
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) peekStack();
        if (jsonPrimitive.value instanceof Number) {
            parseDouble = jsonPrimitive.getAsNumber().doubleValue();
        } else {
            parseDouble = Double.parseDouble(jsonPrimitive.getAsString());
        }
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble);
        }
        popStack();
        int r2 = this.stackSize;
        if (r2 > 0) {
            int[] r3 = this.pathIndices;
            int r22 = r2 - 1;
            r3[r22] = r3[r22] + 1;
        }
        return parseDouble;
    }

    @Override // com.google.gson.stream.JsonReader
    public final int nextInt() throws IOException {
        int parseInt;
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) peekStack();
        if (jsonPrimitive.value instanceof Number) {
            parseInt = jsonPrimitive.getAsNumber().intValue();
        } else {
            parseInt = Integer.parseInt(jsonPrimitive.getAsString());
        }
        popStack();
        int r1 = this.stackSize;
        if (r1 > 0) {
            int[] r2 = this.pathIndices;
            int r12 = r1 - 1;
            r2[r12] = r2[r12] + 1;
        }
        return parseInt;
    }

    @Override // com.google.gson.stream.JsonReader
    public final long nextLong() throws IOException {
        long parseLong;
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek != jsonToken && peek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) peekStack();
        if (jsonPrimitive.value instanceof Number) {
            parseLong = jsonPrimitive.getAsNumber().longValue();
        } else {
            parseLong = Long.parseLong(jsonPrimitive.getAsString());
        }
        popStack();
        int r2 = this.stackSize;
        if (r2 > 0) {
            int[] r3 = this.pathIndices;
            int r22 = r2 - 1;
            r3[r22] = r3[r22] + 1;
        }
        return parseLong;
    }

    public final String nextName(boolean z) throws IOException {
        expect(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) peekStack()).next();
        String str = (String) entry.getKey();
        this.pathNames[this.stackSize - 1] = z ? "<skipped>" : str;
        push(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.JsonReader
    public final void nextNull() throws IOException {
        expect(JsonToken.NULL);
        popStack();
        int r0 = this.stackSize;
        if (r0 > 0) {
            int[] r1 = this.pathIndices;
            int r02 = r0 - 1;
            r1[r02] = r1[r02] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public final String nextString() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.STRING;
        if (peek != jsonToken && peek != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + locationString());
        }
        String asString = ((JsonPrimitive) popStack()).getAsString();
        int r1 = this.stackSize;
        if (r1 > 0) {
            int[] r2 = this.pathIndices;
            int r12 = r1 - 1;
            r2[r12] = r2[r12] + 1;
        }
        return asString;
    }

    @Override // com.google.gson.stream.JsonReader
    public final JsonToken peek() throws IOException {
        if (this.stackSize == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object peekStack = peekStack();
        if (peekStack instanceof Iterator) {
            boolean z = this.stack[this.stackSize - 2] instanceof JsonObject;
            Iterator it = (Iterator) peekStack;
            if (it.hasNext()) {
                if (z) {
                    return JsonToken.NAME;
                }
                push(it.next());
                return peek();
            }
            if (z) {
                return JsonToken.END_OBJECT;
            }
            return JsonToken.END_ARRAY;
        }
        if (peekStack instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (peekStack instanceof JsonArray) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (peekStack instanceof JsonPrimitive) {
            Serializable serializable = ((JsonPrimitive) peekStack).value;
            if (serializable instanceof String) {
                return JsonToken.STRING;
            }
            if (serializable instanceof Boolean) {
                return JsonToken.BOOLEAN;
            }
            if (serializable instanceof Number) {
                return JsonToken.NUMBER;
            }
            throw new AssertionError();
        }
        if (peekStack instanceof JsonNull) {
            return JsonToken.NULL;
        }
        if (peekStack == SENTINEL_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new MalformedJsonException("Custom JsonElement subclass " + peekStack.getClass().getName() + " is not supported");
    }

    public final Object peekStack() {
        return this.stack[this.stackSize - 1];
    }

    public final Object popStack() {
        Object[] objArr = this.stack;
        int r1 = this.stackSize - 1;
        this.stackSize = r1;
        Object obj = objArr[r1];
        objArr[r1] = null;
        return obj;
    }

    public final void push(Object obj) {
        int r0 = this.stackSize;
        Object[] objArr = this.stack;
        if (r0 == objArr.length) {
            int r02 = r0 * 2;
            this.stack = Arrays.copyOf(objArr, r02);
            this.pathIndices = Arrays.copyOf(this.pathIndices, r02);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, r02);
        }
        Object[] objArr2 = this.stack;
        int r1 = this.stackSize;
        this.stackSize = r1 + 1;
        objArr2[r1] = obj;
    }

    @Override // com.google.gson.stream.JsonReader
    public final void skipValue() throws IOException {
        int r0 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[peek().ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 != 3) {
                    if (r0 != 4) {
                        popStack();
                        int r02 = this.stackSize;
                        if (r02 > 0) {
                            int[] r2 = this.pathIndices;
                            int r03 = r02 - 1;
                            r2[r03] = r2[r03] + 1;
                            return;
                        }
                        return;
                    }
                    return;
                }
                endObject();
                return;
            }
            endArray();
            return;
        }
        nextName(true);
    }

    @Override // com.google.gson.stream.JsonReader
    public final String toString() {
        return "JsonTreeReader" + locationString();
    }

    @Override // com.google.gson.stream.JsonReader
    public final String nextName() throws IOException {
        return nextName(false);
    }

    @Override // com.google.gson.stream.JsonReader
    public final String getPath() {
        return getPath(false);
    }
}
