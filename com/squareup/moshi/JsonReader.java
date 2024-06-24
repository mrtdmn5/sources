package com.squareup.moshi;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.ByteString;
import okio.Options;

/* loaded from: classes3.dex */
public abstract class JsonReader implements Closeable {
    public boolean failOnUnknown;
    public boolean lenient;
    public int stackSize;
    public int[] scopes = new int[32];
    public String[] pathNames = new String[32];
    public int[] pathIndices = new int[32];

    /* loaded from: classes3.dex */
    public static final class Options {
        public final okio.Options doubleQuoteSuffix;
        public final String[] strings;

        public Options(String[] strArr, okio.Options options) {
            this.strings = strArr;
            this.doubleQuoteSuffix = options;
        }

        public static Options of(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int r2 = 0; r2 < strArr.length; r2++) {
                    JsonUtf8Writer.string(buffer, strArr[r2]);
                    buffer.readByte();
                    byteStringArr[r2] = buffer.readByteString();
                }
                return new Options((String[]) strArr.clone(), Options.Companion.of(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    public abstract void beginArray() throws IOException;

    public abstract void beginObject() throws IOException;

    public abstract void endArray() throws IOException;

    public abstract void endObject() throws IOException;

    public final String getPath() {
        return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
    }

    public abstract boolean hasNext() throws IOException;

    public abstract double nextDouble() throws IOException;

    public abstract int nextInt() throws IOException;

    public abstract void nextNull() throws IOException;

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
