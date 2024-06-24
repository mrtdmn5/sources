package kotlin.collections;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.serde.json.JsonLexer$unexpectedToken$formatted$1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__AppendableKt;

/* compiled from: _Arrays.kt */
/* loaded from: classes.dex */
public class ArraysKt___ArraysKt extends ArraysKt___ArraysJvmKt {
    public static final <T> boolean contains(T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return indexOf(tArr, t) >= 0;
    }

    public static final ArrayList filterNotNull(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final Integer firstOrNull(int[] r2) {
        boolean z;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        return Integer.valueOf(r2[0]);
    }

    public static final Object getOrNull(int r1, Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        if (r1 >= 0 && r1 <= objArr.length - 1) {
            return objArr[r1];
        }
        return null;
    }

    public static final <T> int indexOf(T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int r0 = 0;
        if (t == null) {
            int length = tArr.length;
            while (r0 < length) {
                if (tArr[r0] == null) {
                    return r0;
                }
                r0++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (r0 < length2) {
            if (Intrinsics.areEqual(t, tArr[r0])) {
                return r0;
            }
            r0++;
        }
        return -1;
    }

    public static final void joinTo(Object[] objArr, StringBuilder sb, CharSequence separator, CharSequence prefix, CharSequence postfix, int r9, CharSequence truncated, Function1 function1) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        sb.append(prefix);
        int r1 = 0;
        for (Object obj : objArr) {
            r1++;
            if (r1 > 1) {
                sb.append(separator);
            }
            if (r9 >= 0 && r1 > r9) {
                break;
            }
            StringsKt__AppendableKt.appendElement(sb, obj, function1);
        }
        if (r9 >= 0 && r1 > r9) {
            sb.append(truncated);
        }
        sb.append(postfix);
    }

    public static String joinToString$default(int[] r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int r5 = 0;
        for (int r6 : r8) {
            r5++;
            if (r5 > 1) {
                sb.append((CharSequence) ", ");
            }
            sb.append((CharSequence) String.valueOf(r6));
        }
        sb.append((CharSequence) "");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final char single(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length == 1) {
                return cArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int[] sliceArray(int[] r2, IntRange indices) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        if (indices.isEmpty()) {
            return new int[0];
        }
        int intValue = indices.getStart().intValue();
        int intValue2 = indices.getEndInclusive().intValue() + 1;
        ArraysKt__ArraysKt.copyOfRangeToIndexCheck(intValue2, r2.length);
        int[] copyOfRange = Arrays.copyOfRange(r2, intValue, intValue2);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static final float sum(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        float f = 0.0f;
        for (float f2 : fArr) {
            f += f2;
        }
        return f;
    }

    public static final List take(int r6, byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (r6 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r6 == 0) {
                return EmptyList.INSTANCE;
            }
            if (r6 >= bArr.length) {
                return toList(bArr);
            }
            if (r6 == 1) {
                return CollectionsKt__CollectionsKt.listOf(Byte.valueOf(bArr[0]));
            }
            ArrayList arrayList = new ArrayList(r6);
            int r4 = 0;
            for (byte b : bArr) {
                arrayList.add(Byte.valueOf(b));
                r4++;
                if (r4 == r6) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Requested element count ", r6, " is less than zero.").toString());
    }

    public static final <T> List<T> toList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return EmptyList.INSTANCE;
        }
        if (length != 1) {
            return toMutableList(tArr);
        }
        return CollectionsKt__CollectionsKt.listOf(tArr[0]);
    }

    public static final ArrayList toMutableList(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        return new ArrayList(new ArrayAsCollection(objArr, false));
    }

    public static final <T> Set<T> toSet(T[] tArr) {
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(tArr.length));
                for (T t : tArr) {
                    linkedHashSet.add(t);
                }
                return linkedHashSet;
            }
            return SetsKt__SetsKt.setOf(tArr[0]);
        }
        return EmptySet.INSTANCE;
    }

    public static final boolean contains(char[] cArr, char c) {
        int length = cArr.length;
        int r2 = 0;
        while (true) {
            if (r2 >= length) {
                r2 = -1;
                break;
            }
            if (c == cArr[r2]) {
                break;
            }
            r2++;
        }
        return r2 >= 0;
    }

    public static final List<Byte> toList(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            return EmptyList.INSTANCE;
        }
        if (length != 1) {
            ArrayList arrayList = new ArrayList(bArr.length);
            for (byte b : bArr) {
                arrayList.add(Byte.valueOf(b));
            }
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.listOf(Byte.valueOf(bArr[0]));
    }

    public static String joinToString$default(Object[] objArr, String str, JsonLexer$unexpectedToken$formatted$1 jsonLexer$unexpectedToken$formatted$1, int r11) {
        if ((r11 & 1) != 0) {
            str = ", ";
        }
        String separator = str;
        CharSequence prefix = (r11 & 2) != 0 ? "" : null;
        CharSequence postfix = (r11 & 4) != 0 ? "" : null;
        int r5 = (r11 & 8) != 0 ? -1 : 0;
        CharSequence truncated = (r11 & 16) != 0 ? "..." : null;
        JsonLexer$unexpectedToken$formatted$1 jsonLexer$unexpectedToken$formatted$12 = (r11 & 32) != 0 ? null : jsonLexer$unexpectedToken$formatted$1;
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        joinTo(objArr, sb, separator, prefix, postfix, r5, truncated, jsonLexer$unexpectedToken$formatted$12);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
