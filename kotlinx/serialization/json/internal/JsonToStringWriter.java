package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JsonToStringWriter.kt */
/* loaded from: classes4.dex */
public final class JsonToStringWriter implements JsonWriter {
    public char[] array;
    public int size;

    public JsonToStringWriter() {
        char[] cArr;
        char[] removeLast;
        CharArrayPool charArrayPool = CharArrayPool.INSTANCE;
        synchronized (charArrayPool) {
            ArrayDeque<char[]> arrayDeque = charArrayPool.arrays;
            cArr = null;
            if (arrayDeque.isEmpty()) {
                removeLast = null;
            } else {
                removeLast = arrayDeque.removeLast();
            }
            char[] cArr2 = removeLast;
            if (cArr2 != null) {
                charArrayPool.charsTotal -= cArr2.length;
                cArr = cArr2;
            }
        }
        this.array = cArr == null ? new char[128] : cArr;
    }

    public final void ensureTotalCapacity(int r3, int r4) {
        int r42 = r4 + r3;
        char[] cArr = this.array;
        if (cArr.length <= r42) {
            int r32 = r3 * 2;
            if (r42 < r32) {
                r42 = r32;
            }
            char[] copyOf = Arrays.copyOf(cArr, r42);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.array = copyOf;
        }
    }

    public final void release() {
        CharArrayPool charArrayPool = CharArrayPool.INSTANCE;
        char[] array = this.array;
        charArrayPool.getClass();
        Intrinsics.checkNotNullParameter(array, "array");
        synchronized (charArrayPool) {
            int r2 = charArrayPool.charsTotal;
            if (array.length + r2 < ArrayPoolsKt.MAX_CHARS_IN_POOL) {
                charArrayPool.charsTotal = r2 + array.length;
                charArrayPool.arrays.addLast(array);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final String toString() {
        return new String(this.array, 0, this.size);
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public final void write(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        ensureTotalCapacity(this.size, length);
        text.getChars(0, text.length(), this.array, this.size);
        this.size += length;
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public final void writeChar(char c) {
        ensureTotalCapacity(this.size, 1);
        char[] cArr = this.array;
        int r1 = this.size;
        this.size = r1 + 1;
        cArr[r1] = c;
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public final void writeLong(long j) {
        write(String.valueOf(j));
    }

    @Override // kotlinx.serialization.json.internal.JsonWriter
    public final void writeQuoted(String text) {
        int r8;
        Intrinsics.checkNotNullParameter(text, "text");
        ensureTotalCapacity(this.size, text.length() + 2);
        char[] cArr = this.array;
        int r2 = this.size;
        int r3 = r2 + 1;
        cArr[r2] = '\"';
        int length = text.length();
        text.getChars(0, length, cArr, r3);
        int r22 = length + r3;
        int r6 = r3;
        while (r6 < r22) {
            char c = cArr[r6];
            byte[] bArr = StringOpsKt.ESCAPE_MARKERS;
            if (c < bArr.length && bArr[c] != 0) {
                int length2 = text.length();
                for (int r0 = r6 - r3; r0 < length2; r0++) {
                    ensureTotalCapacity(r6, 2);
                    char charAt = text.charAt(r0);
                    byte[] bArr2 = StringOpsKt.ESCAPE_MARKERS;
                    if (charAt < bArr2.length) {
                        byte b = bArr2[charAt];
                        if (b == 0) {
                            r8 = r6 + 1;
                            this.array[r6] = charAt;
                        } else {
                            if (b == 1) {
                                String str = StringOpsKt.ESCAPE_STRINGS[charAt];
                                Intrinsics.checkNotNull(str);
                                ensureTotalCapacity(r6, str.length());
                                str.getChars(0, str.length(), this.array, r6);
                                int length3 = str.length() + r6;
                                this.size = length3;
                                r6 = length3;
                            } else {
                                char[] cArr2 = this.array;
                                cArr2[r6] = '\\';
                                cArr2[r6 + 1] = (char) b;
                                r6 += 2;
                                this.size = r6;
                            }
                        }
                    } else {
                        r8 = r6 + 1;
                        this.array[r6] = charAt;
                    }
                    r6 = r8;
                }
                ensureTotalCapacity(r6, 1);
                this.array[r6] = '\"';
                this.size = r6 + 1;
                return;
            }
            r6++;
        }
        cArr[r22] = '\"';
        this.size = r22 + 1;
    }
}
