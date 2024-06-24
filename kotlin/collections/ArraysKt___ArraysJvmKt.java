package kotlin.collections;

import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: _ArraysJvm.kt */
/* loaded from: classes.dex */
public class ArraysKt___ArraysJvmKt extends ArraysKt__ArraysKt {
    public static final <T> List<T> asList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        List<T> asList = Arrays.asList(tArr);
        Intrinsics.checkNotNullExpressionValue(asList, "asList(...)");
        return asList;
    }

    public static final void copyInto(int r1, int r2, int r3, Object[] objArr, Object[] destination) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(objArr, r2, destination, r1, r3 - r2);
    }

    public static /* synthetic */ void copyInto$default(Object[] objArr, Object[] objArr2, int r4, int r5, int r6) {
        if ((r6 & 4) != 0) {
            r4 = 0;
        }
        if ((r6 & 8) != 0) {
            r5 = objArr.length;
        }
        copyInto(0, r4, r5, objArr, objArr2);
    }

    public static final byte[] copyOfRange(byte[] bArr, int r2, int r3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ArraysKt__ArraysKt.copyOfRangeToIndexCheck(r3, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, r2, r3);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static final void fill(int r1, int r2, Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Arrays.fill(objArr, r1, r2, (Object) null);
    }

    public static void fill$default(Object[] objArr, Symbol symbol) {
        int length = objArr.length;
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Arrays.fill(objArr, 0, length, symbol);
    }

    public static final <T> T[] plus(T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + 1);
        tArr2[length] = t;
        return tArr2;
    }

    public static final void copyInto(int r1, byte[] bArr, int r3, byte[] destination, int r5) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(bArr, r3, destination, r1, r5 - r3);
    }

    public static /* synthetic */ void copyInto$default(int[] r2, int[] r3, int r4, int r5, int r6) {
        if ((r6 & 2) != 0) {
            r4 = 0;
        }
        if ((r6 & 8) != 0) {
            r5 = r2.length;
        }
        copyInto(r4, 0, r2, r3, r5);
    }

    public static final ArraysKt___ArraysJvmKt$asList$1 asList(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new ArraysKt___ArraysJvmKt$asList$1(bArr);
    }

    public static final void copyInto(int r1, int r2, int[] r3, int[] destination, int r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(r3, r2, destination, r1, r5 - r2);
    }

    public static final void copyInto(char[] cArr, char[] destination, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(cArr, r4, destination, r3, r5 - r4);
    }

    public static final <T> T[] plus(T[] tArr, T[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = tArr.length;
        int length2 = elements.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(elements, 0, tArr2, length, length2);
        Intrinsics.checkNotNull(tArr2);
        return tArr2;
    }

    public static final byte[] plus(byte[] bArr, byte[] elements) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        int length = bArr.length;
        int length2 = elements.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(elements, 0, copyOf, length, length2);
        Intrinsics.checkNotNull(copyOf);
        return copyOf;
    }
}
