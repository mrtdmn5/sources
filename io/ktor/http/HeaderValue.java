package io.ktor.http;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpHeaderValueParser.kt */
/* loaded from: classes3.dex */
public final class HeaderValue {
    public final List<HeaderValueParam> params;
    public final double quality;
    public final String value;

    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HeaderValue(java.lang.String r8, java.util.List<io.ktor.http.HeaderValueParam> r9) {
        /*
            r7 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r7.<init>()
            r7.value = r8
            r7.params = r9
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r8 = r9.iterator()
        L17:
            boolean r9 = r8.hasNext()
            r0 = 0
            if (r9 == 0) goto L30
            java.lang.Object r9 = r8.next()
            r1 = r9
            io.ktor.http.HeaderValueParam r1 = (io.ktor.http.HeaderValueParam) r1
            java.lang.String r1 = r1.name
            java.lang.String r2 = "q"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L17
            goto L31
        L30:
            r9 = r0
        L31:
            io.ktor.http.HeaderValueParam r9 = (io.ktor.http.HeaderValueParam) r9
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r9 == 0) goto L69
            java.lang.String r8 = r9.value
            if (r8 == 0) goto L69
            kotlin.text.Regex r9 = kotlin.text.ScreenFloatValueRegEx.value     // Catch: java.lang.NumberFormatException -> L4c
            boolean r9 = r9.matches(r8)     // Catch: java.lang.NumberFormatException -> L4c
            if (r9 == 0) goto L4c
            double r8 = java.lang.Double.parseDouble(r8)     // Catch: java.lang.NumberFormatException -> L4c
            java.lang.Double r8 = java.lang.Double.valueOf(r8)     // Catch: java.lang.NumberFormatException -> L4c
            goto L4d
        L4c:
            r8 = r0
        L4d:
            if (r8 == 0) goto L69
            double r3 = r8.doubleValue()
            r5 = 0
            int r9 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r9 > 0) goto L5f
            int r9 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r9 > 0) goto L5f
            r9 = 1
            goto L60
        L5f:
            r9 = 0
        L60:
            if (r9 == 0) goto L63
            r0 = r8
        L63:
            if (r0 == 0) goto L69
            double r1 = r0.doubleValue()
        L69:
            r7.quality = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HeaderValue.<init>(java.lang.String, java.util.List):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderValue)) {
            return false;
        }
        HeaderValue headerValue = (HeaderValue) obj;
        if (Intrinsics.areEqual(this.value, headerValue.value) && Intrinsics.areEqual(this.params, headerValue.params)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.params.hashCode() + (this.value.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HeaderValue(value=");
        sb.append(this.value);
        sb.append(", params=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.params, ')');
    }
}
