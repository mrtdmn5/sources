package io.ktor.http;

import com.amplifyframework.core.model.ModelIdentifier;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeaderValueWithParameters.kt */
/* loaded from: classes3.dex */
public final class HeaderValueWithParametersKt {
    public static final Set<Character> HeaderFieldValueSeparators = SetsKt__SetsKt.setOf((Object[]) new Character[]{'(', ')', '<', '>', '@', ',', ';', ':', '\\', '\"', '/', '[', ']', '?', '=', '{', '}', ' ', '\t', '\n', '\r'});

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean needQuotes(java.lang.String r8) {
        /*
            int r0 = r8.length()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto La
            r0 = r2
            goto Lb
        La:
            r0 = r1
        Lb:
            if (r0 == 0) goto Le
            return r2
        Le:
            int r0 = r8.length()
            r3 = 2
            if (r0 >= r3) goto L16
            goto L51
        L16:
            char r0 = kotlin.text.StringsKt___StringsKt.first(r8)
            r3 = 34
            if (r0 != r3) goto L51
            char r0 = kotlin.text.StringsKt___StringsKt.last(r8)
            if (r0 == r3) goto L25
            goto L51
        L25:
            r0 = r2
        L26:
            r4 = 4
            int r0 = kotlin.text.StringsKt__StringsKt.indexOf$default(r8, r3, r0, r1, r4)
            int r4 = kotlin.text.StringsKt__StringsKt.getLastIndex(r8)
            if (r0 != r4) goto L32
            goto L4f
        L32:
            int r4 = r0 + (-1)
            r5 = r1
        L35:
            char r6 = r8.charAt(r4)
            r7 = 92
            if (r6 != r7) goto L42
            int r5 = r5 + 1
            int r4 = r4 + (-1)
            goto L35
        L42:
            int r5 = r5 % 2
            if (r5 != 0) goto L47
            goto L51
        L47:
            int r0 = r0 + 1
            int r4 = r8.length()
            if (r0 < r4) goto L26
        L4f:
            r0 = r2
            goto L52
        L51:
            r0 = r1
        L52:
            if (r0 == 0) goto L55
            return r1
        L55:
            int r0 = r8.length()
            r3 = r1
        L5a:
            if (r3 >= r0) goto L70
            char r4 = r8.charAt(r3)
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            java.util.Set<java.lang.Character> r5 = io.ktor.http.HeaderValueWithParametersKt.HeaderFieldValueSeparators
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L6d
            return r2
        L6d:
            int r3 = r3 + 1
            goto L5a
        L70:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HeaderValueWithParametersKt.needQuotes(java.lang.String):boolean");
    }

    public static final String quote(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR);
        int length = str.length();
        for (int r3 = 0; r3 < length; r3++) {
            char charAt = str.charAt(r3);
            if (charAt == '\\') {
                sb.append("\\\\");
            } else if (charAt == '\n') {
                sb.append("\\n");
            } else if (charAt == '\r') {
                sb.append("\\r");
            } else if (charAt == '\t') {
                sb.append("\\t");
            } else if (charAt == '\"') {
                sb.append("\\\"");
            } else {
                sb.append(charAt);
            }
        }
        sb.append(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
