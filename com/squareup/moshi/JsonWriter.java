package com.squareup.moshi;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class JsonWriter implements Closeable, Flushable {
    public boolean lenient;
    public boolean promoteValueToName;
    public boolean serializeNulls;
    public int stackSize = 0;
    public int[] scopes = new int[32];
    public String[] pathNames = new String[32];
    public int[] pathIndices = new int[32];
    public int flattenStackSize = -1;

    public abstract JsonWriter beginArray() throws IOException;

    public abstract JsonWriter beginObject() throws IOException;

    public final void checkStack() {
        int r0 = this.stackSize;
        int[] r1 = this.scopes;
        if (r0 != r1.length) {
            return;
        }
        if (r0 != 256) {
            this.scopes = Arrays.copyOf(r1, r1.length * 2);
            String[] strArr = this.pathNames;
            this.pathNames = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] r02 = this.pathIndices;
            this.pathIndices = Arrays.copyOf(r02, r02.length * 2);
            if (this instanceof JsonValueWriter) {
                JsonValueWriter jsonValueWriter = (JsonValueWriter) this;
                Object[] objArr = jsonValueWriter.stack;
                jsonValueWriter.stack = Arrays.copyOf(objArr, objArr.length * 2);
                return;
            }
            return;
        }
        throw new JsonDataException("Nesting too deep at " + getPath() + ": circular reference?");
    }

    public abstract JsonWriter endArray() throws IOException;

    public abstract JsonWriter endObject() throws IOException;

    public final String getPath() {
        return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
    }

    public abstract JsonWriter name(String str) throws IOException;

    public abstract JsonWriter nullValue() throws IOException;

    public final int peekScope() {
        int r0 = this.stackSize;
        if (r0 != 0) {
            return this.scopes[r0 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void pushScope(int r4) {
        int[] r0 = this.scopes;
        int r1 = this.stackSize;
        this.stackSize = r1 + 1;
        r0[r1] = r4;
    }

    public abstract JsonWriter value(double d) throws IOException;

    public abstract JsonWriter value(long j) throws IOException;

    public abstract JsonWriter value(Number number) throws IOException;

    public abstract JsonWriter value(String str) throws IOException;

    public abstract JsonWriter value(boolean z) throws IOException;
}
