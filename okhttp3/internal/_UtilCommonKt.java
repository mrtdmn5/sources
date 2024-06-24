package okhttp3.internal;

import com.amazonaws.http.HttpHeader;
import com.animaconnected.secondo.R;
import io.ktor.http.ContentTypesKt;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

/* compiled from: -UtilCommon.kt */
/* loaded from: classes4.dex */
public final class _UtilCommonKt {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers commonEmptyHeaders;
    public static final _ResponseBodyCommonKt$commonAsResponseBody$1 commonEmptyResponse;

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        ByteString byteString = ByteString.EMPTY;
        Options.Companion.of(ByteString.Companion.decodeHex("efbbbf"), ByteString.Companion.decodeHex("feff"), ByteString.Companion.decodeHex("fffe"), ByteString.Companion.decodeHex("0000ffff"), ByteString.Companion.decodeHex("ffff0000"));
        commonEmptyHeaders = Headers.Companion.of(new String[0]);
        long j = 0;
        checkOffsetAndCount(j, j, j);
        new _RequestBodyCommonKt$commonToRequestBody$1(null, bArr, 0, 0);
        Buffer buffer = new Buffer();
        buffer.m1733write(bArr, 0, 0);
        commonEmptyResponse = new _ResponseBodyCommonKt$commonAsResponseBody$1(null, j, buffer);
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) >= 0 && j2 <= j && j - j2 >= j3) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("length=" + j + ", offset=" + j2 + ", count=" + j2);
    }

    public static final void closeQuietly(Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final int delimiterOffset(int r1, int r2, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        while (r1 < r2) {
            if (StringsKt__StringsKt.contains$default(str2, str.charAt(r1))) {
                return r1;
            }
            r1++;
        }
        return r2;
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        if (strArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z && strArr2 != null) {
            if (strArr2.length == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                for (String str : strArr) {
                    ArrayIterator it = ContentTypesKt.iterator(strArr2);
                    while (it.hasNext()) {
                        if (comparator.compare(str, (String) it.next()) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        int length = str.length();
        for (int r1 = 0; r1 < length; r1++) {
            char charAt = str.charAt(r1);
            if (Intrinsics.compare(charAt, 31) <= 0 || Intrinsics.compare(charAt, R.styleable.AppTheme_statusTextH5) >= 0) {
                return r1;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(int r4, int r5, String str) {
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(str, "<this>");
        while (r4 < r5) {
            char charAt = str.charAt(r4);
            boolean z4 = false;
            if (charAt == '\t' || charAt == '\n') {
                z = true;
            } else {
                z = false;
            }
            if (z || charAt == '\f') {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 || charAt == '\r') {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 || charAt == ' ') {
                z4 = true;
            }
            if (!z4) {
                return r4;
            }
            r4++;
        }
        return r5;
    }

    public static final int indexOfLastNonAsciiWhitespace(int r4, int r5, String str) {
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int r52 = r5 - 1;
        if (r4 <= r52) {
            while (true) {
                char charAt = str.charAt(r52);
                boolean z4 = false;
                if (charAt == '\t' || charAt == '\n') {
                    z = true;
                } else {
                    z = false;
                }
                if (z || charAt == '\f') {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 || charAt == '\r') {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3 || charAt == ' ') {
                    z4 = true;
                }
                if (!z4) {
                    return r52 + 1;
                }
                if (r52 == r4) {
                    break;
                }
                r52--;
            }
        }
        return r4;
    }

    public static final String[] intersect(String[] strArr, String[] other, Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter(other, "other");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = other.length;
            int r6 = 0;
            while (true) {
                if (r6 >= length) {
                    break;
                }
                if (comparator.compare(str, other[r6]) == 0) {
                    arrayList.add(str);
                    break;
                }
                r6++;
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    public static final boolean isSensitiveHeader(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!StringsKt__StringsJVMKt.equals(name, HttpHeader.AUTHORIZATION) && !StringsKt__StringsJVMKt.equals(name, "Cookie") && !StringsKt__StringsJVMKt.equals(name, "Proxy-Authorization") && !StringsKt__StringsJVMKt.equals(name, "Set-Cookie")) {
            return false;
        }
        return true;
    }

    public static final MatcherMatchResult matchAtPolyfill(Regex regex, CharSequence input, int r4) {
        MatcherMatchResult matcherMatchResult;
        Intrinsics.checkNotNullParameter(regex, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = regex.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        if (!matcher.find(r4)) {
            matcherMatchResult = null;
        } else {
            matcherMatchResult = new MatcherMatchResult(matcher, input);
        }
        if (matcherMatchResult == null || matcherMatchResult.getRange().first != r4) {
            return null;
        }
        return matcherMatchResult;
    }

    public static final int parseHexDigit(char c) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if ('0' <= c && c < ':') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return c - '0';
        }
        char c2 = 'a';
        if ('a' <= c && c < 'g') {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            c2 = 'A';
            if ('A' > c || c >= 'G') {
                z3 = false;
            }
            if (!z3) {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    public static final int readMedium(BufferedSource bufferedSource) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    public static final int skipAll(Buffer buffer, byte b) {
        int r0 = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b) {
            r0++;
            buffer.readByte();
        }
        return r0;
    }

    public static final int toNonNegativeInt(int r2, String str) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
                return r2;
            }
        }
        return r2;
    }

    public static final String trimSubstring(int r0, int r1, String str) {
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(r0, r1, str);
        String substring = str.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(indexOfFirstNonAsciiWhitespace, r1, str));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final int delimiterOffset(char c, int r2, int r3, String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        while (r2 < r3) {
            if (str.charAt(r2) == c) {
                return r2;
            }
            r2++;
        }
        return r3;
    }
}
