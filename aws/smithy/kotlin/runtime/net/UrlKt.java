package aws.smithy.kotlin.runtime.net;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: Url.kt */
/* loaded from: classes.dex */
public final class UrlKt {
    public static final UserInfo UserInfo(String value) {
        String str;
        Intrinsics.checkNotNullParameter(value, "value");
        List split$default = StringsKt__StringsKt.split$default(value, new String[]{":"}, 0, 6);
        String urlDecodeComponent$default = aws.smithy.kotlin.runtime.util.text.TextKt.urlDecodeComponent$default((String) split$default.get(0));
        if (split$default.size() > 1) {
            str = aws.smithy.kotlin.runtime.util.text.TextKt.urlDecodeComponent$default((String) split$default.get(1));
        } else {
            str = "";
        }
        return new UserInfo(urlDecodeComponent$default, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x006a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String encodePath(java.lang.String r9, java.util.Set<? extends java.util.Map.Entry<java.lang.String, ? extends java.util.List<java.lang.String>>> r10, java.lang.String r11, boolean r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.net.UrlKt.encodePath(java.lang.String, java.util.Set, java.lang.String, boolean, boolean):java.lang.String");
    }
}
