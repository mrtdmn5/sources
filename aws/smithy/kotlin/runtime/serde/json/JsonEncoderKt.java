package aws.smithy.kotlin.runtime.serde.json;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: JsonEncoder.kt */
/* loaded from: classes.dex */
public final class JsonEncoderKt {
    public static final String escape(String str) {
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int r1 = 0;
        while (true) {
            if (r1 < str.length()) {
                char charAt = str.charAt(r1);
                if (charAt != '\"' && charAt != '\\' && (charAt < 0 || charAt >= ' ')) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    z = true;
                    break;
                }
                r1++;
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + 1);
        for (int r12 = 0; r12 < str.length(); r12++) {
            char charAt2 = str.charAt(r12);
            if (charAt2 == '\"') {
                sb.append("\\\"");
            } else if (charAt2 == '\\') {
                sb.append("\\\\");
            } else if (charAt2 == '\n') {
                sb.append("\\n");
            } else if (charAt2 == '\r') {
                sb.append("\\r");
            } else if (charAt2 == '\t') {
                sb.append("\\t");
            } else if (charAt2 == '\b') {
                sb.append("\\b");
            } else if (charAt2 == '\f') {
                sb.append("\\f");
            } else {
                if (charAt2 >= 0 && charAt2 < ' ') {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    CharsKt__CharKt.checkRadix(16);
                    String num = Integer.toString(charAt2, 16);
                    Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                    sb.append("\\u");
                    sb.append(StringsKt__StringsKt.padStart(num, 4, '0'));
                } else {
                    sb.append(charAt2);
                }
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }
}
