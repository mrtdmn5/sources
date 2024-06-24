package okhttp3.internal;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;

/* compiled from: -HeadersCommon.kt */
/* loaded from: classes4.dex */
public final class _HeadersCommonKt {
    public static final void commonAddLenient(Headers.Builder builder, String name, String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        ArrayList arrayList = builder.namesAndValues;
        arrayList.add(name);
        arrayList.add(StringsKt__StringsKt.trim(value).toString());
    }

    public static final void headersCheckName(String name) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(name, "name");
        if (name.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int length = name.length();
            for (int r3 = 0; r3 < length; r3++) {
                char charAt = name.charAt(r3);
                if ('!' <= charAt && charAt < 127) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    StringBuilder sb = new StringBuilder("Unexpected char 0x");
                    CharsKt__CharKt.checkRadix(16);
                    String num = Integer.toString(charAt, 16);
                    Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                    if (num.length() < 2) {
                        num = "0".concat(num);
                    }
                    sb.append(num);
                    sb.append(" at ");
                    sb.append(r3);
                    sb.append(" in header name: ");
                    sb.append(name);
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("name is empty".toString());
    }

    public static final void headersCheckValue(String value, String name) {
        String concat;
        boolean z;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(name, "name");
        int length = value.length();
        for (int r2 = 0; r2 < length; r2++) {
            char charAt = value.charAt(r2);
            boolean z2 = true;
            if (charAt != '\t') {
                if (' ' <= charAt && charAt < 127) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    z2 = false;
                }
            }
            if (!z2) {
                StringBuilder sb = new StringBuilder("Unexpected char 0x");
                CharsKt__CharKt.checkRadix(16);
                String num = Integer.toString(charAt, 16);
                Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                if (num.length() < 2) {
                    num = "0".concat(num);
                }
                sb.append(num);
                sb.append(" at ");
                sb.append(r2);
                sb.append(" in ");
                sb.append(name);
                sb.append(" value");
                if (_UtilCommonKt.isSensitiveHeader(name)) {
                    concat = "";
                } else {
                    concat = ": ".concat(value);
                }
                sb.append(concat);
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }
}
