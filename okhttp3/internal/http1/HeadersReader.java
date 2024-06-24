package okhttp3.internal.http1;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import okhttp3.internal._HeadersCommonKt;
import okio.BufferedSource;

/* compiled from: HeadersReader.kt */
/* loaded from: classes4.dex */
public final class HeadersReader {
    public long headerLimit = 262144;
    public final BufferedSource source;

    public HeadersReader(BufferedSource bufferedSource) {
        this.source = bufferedSource;
    }

    public final Headers readHeaders() {
        boolean z;
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readUtf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
            this.headerLimit -= readUtf8LineStrict.length();
            if (readUtf8LineStrict.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) readUtf8LineStrict, ':', 1, false, 4);
                if (indexOf$default != -1) {
                    String substring = readUtf8LineStrict.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    String substring2 = readUtf8LineStrict.substring(indexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    _HeadersCommonKt.commonAddLenient(builder, substring, substring2);
                } else if (readUtf8LineStrict.charAt(0) == ':') {
                    String substring3 = readUtf8LineStrict.substring(1);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                    _HeadersCommonKt.commonAddLenient(builder, "", substring3);
                } else {
                    _HeadersCommonKt.commonAddLenient(builder, "", readUtf8LineStrict);
                }
            } else {
                return builder.build();
            }
        }
    }
}
