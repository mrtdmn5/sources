package kotlin.text;

import java.util.Collection;
import java.util.Comparator;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: StringsJVM.kt */
/* loaded from: classes.dex */
public class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public static final String concatToString(char[] cArr, int r2, int r3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r2, r3, cArr.length);
        return new String(cArr, r2, r3 - r2);
    }

    public static final String decodeToString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new String(bArr, Charsets.UTF_8);
    }

    public static String decodeToString$default(byte[] bArr, int r2, int r3, int r4) {
        if ((r4 & 1) != 0) {
            r2 = 0;
        }
        if ((r4 & 2) != 0) {
            r3 = bArr.length;
        }
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r2, r3, bArr.length);
        return new String(bArr, r2, r3 - r2, Charsets.UTF_8);
    }

    public static final byte[] encodeToByteArray(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public static final boolean endsWith(String str, String suffix, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!z) {
            return str.endsWith(suffix);
        }
        return regionMatches(str.length() - suffix.length(), 0, suffix.length(), str, suffix, true);
    }

    public static final boolean equals(String str, String str2) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static final Comparator getCASE_INSENSITIVE_ORDER() {
        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    public static final boolean isBlank(CharSequence charSequence) {
        boolean z;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return true;
        }
        Iterable intRange = new IntRange(0, charSequence.length() - 1);
        if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
            ?? it = intRange.iterator();
            while (it.hasNext) {
                if (!CharsKt__CharKt.isWhitespace(charSequence.charAt(it.nextInt()))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            return true;
        }
        return false;
    }

    public static final boolean regionMatches(int r6, int r7, int r8, String str, String other, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!z) {
            return str.regionMatches(r6, other, r7, r8);
        }
        return str.regionMatches(z, r6, other, r7, r8);
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [kotlin.ranges.IntProgressionIterator] */
    public static final String repeat(int r3, String str) {
        boolean z;
        if (r3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r3 != 0) {
                if (r3 != 1) {
                    int length = str.length();
                    if (length != 0) {
                        if (length != 1) {
                            StringBuilder sb = new StringBuilder(str.length() * r3);
                            ?? it = new IntRange(1, r3).iterator();
                            while (it.hasNext) {
                                it.nextInt();
                                sb.append((CharSequence) str);
                            }
                            String sb2 = sb.toString();
                            Intrinsics.checkNotNull(sb2);
                            return sb2;
                        }
                        char charAt = str.charAt(0);
                        char[] cArr = new char[r3];
                        for (int r0 = 0; r0 < r3; r0++) {
                            cArr[r0] = charAt;
                        }
                        return new String(cArr);
                    }
                } else {
                    return str.toString();
                }
            }
            return "";
        }
        throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + r3 + '.').toString());
    }

    public static String replace$default(String str, String str2, String newValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int indexOf = StringsKt__StringsKt.indexOf(0, str, str2, false);
        if (indexOf >= 0) {
            int length = str2.length();
            int r3 = 1;
            if (length >= 1) {
                r3 = length;
            }
            int length2 = newValue.length() + (str.length() - length);
            if (length2 >= 0) {
                StringBuilder sb = new StringBuilder(length2);
                int r5 = 0;
                do {
                    sb.append((CharSequence) str, r5, indexOf);
                    sb.append(newValue);
                    r5 = indexOf + length;
                    if (indexOf >= str.length()) {
                        break;
                    }
                    indexOf = StringsKt__StringsKt.indexOf(indexOf + r3, str, str2, false);
                } while (indexOf > 0);
                sb.append((CharSequence) str, r5, str.length());
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                return sb2;
            }
            throw new OutOfMemoryError();
        }
        return str;
    }

    public static final boolean startsWith(String str, String prefix, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!z) {
            return str.startsWith(prefix);
        }
        return regionMatches(0, 0, prefix.length(), str, prefix, z);
    }

    public static final boolean startsWith(String str, int r7, String prefix, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!z) {
            return str.startsWith(prefix, r7);
        }
        return regionMatches(r7, 0, prefix.length(), str, prefix, z);
    }
}
