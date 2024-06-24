package io.ktor.http;

import io.ktor.http.Parameters;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: Query.kt */
/* loaded from: classes3.dex */
public final class QueryKt {
    public static final void appendParam(ParametersBuilderImpl parametersBuilderImpl, String str, int r6, int r7, int r8, boolean z) {
        String substring;
        String substring2;
        String substring3;
        if (r7 == -1) {
            while (r6 < r8 && CharsKt__CharKt.isWhitespace(str.charAt(r6))) {
                r6++;
            }
            int trimEnd = trimEnd(r6, r8, str);
            if (trimEnd > r6) {
                if (z) {
                    substring3 = CodecsKt.decodeURLQueryComponent$default(str, r6, trimEnd, false, 12);
                } else {
                    substring3 = str.substring(r6, trimEnd);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                parametersBuilderImpl.appendAll(substring3, EmptyList.INSTANCE);
                return;
            }
            return;
        }
        while (r6 < r7 && CharsKt__CharKt.isWhitespace(str.charAt(r6))) {
            r6++;
        }
        int trimEnd2 = trimEnd(r6, r7, str);
        if (trimEnd2 > r6) {
            if (z) {
                substring = CodecsKt.decodeURLQueryComponent$default(str, r6, trimEnd2, false, 12);
            } else {
                substring = str.substring(r6, trimEnd2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            int r72 = r7 + 1;
            while (r72 < r8 && CharsKt__CharKt.isWhitespace(str.charAt(r72))) {
                r72++;
            }
            int trimEnd3 = trimEnd(r72, r8, str);
            if (z) {
                substring2 = CodecsKt.decodeURLQueryComponent$default(str, r72, trimEnd3, true, 8);
            } else {
                substring2 = str.substring(r72, trimEnd3);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            parametersBuilderImpl.append(substring, substring2);
        }
    }

    public static Parameters parseQueryString$default(String query) {
        int r2;
        int r3;
        Intrinsics.checkNotNullParameter(query, "query");
        if (StringsKt__StringsKt.getLastIndex(query) < 0) {
            Parameters.Companion.getClass();
            return EmptyParameters.INSTANCE;
        }
        Parameters.Companion companion = Parameters.Companion;
        ParametersBuilderImpl ParametersBuilder$default = ParametersKt.ParametersBuilder$default();
        int lastIndex = StringsKt__StringsKt.getLastIndex(query);
        int r0 = 0;
        if (lastIndex >= 0) {
            r2 = 0;
            int r11 = 0;
            int r12 = 0;
            r3 = -1;
            while (r11 != 1000) {
                char charAt = query.charAt(r12);
                if (charAt == '&') {
                    appendParam(ParametersBuilder$default, query, r2, r3, r12, false);
                    r2 = r12 + 1;
                    r11++;
                    r3 = -1;
                } else if (charAt == '=' && r3 == -1) {
                    r3 = r12;
                }
                if (r12 != lastIndex) {
                    r12++;
                } else {
                    r0 = r11;
                }
            }
            return new ParametersImpl(ParametersBuilder$default.values);
        }
        r2 = 0;
        r3 = -1;
        if (r0 != 1000) {
            appendParam(ParametersBuilder$default, query, r2, r3, query.length(), false);
        }
        return new ParametersImpl(ParametersBuilder$default.values);
    }

    public static final int trimEnd(int r1, int r2, CharSequence charSequence) {
        while (r2 > r1 && CharsKt__CharKt.isWhitespace(charSequence.charAt(r2 - 1))) {
            r2--;
        }
        return r2;
    }
}
