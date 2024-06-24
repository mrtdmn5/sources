package io.ktor.http;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: URLParser.kt */
/* loaded from: classes3.dex */
public final class URLParserKt {
    public static final List<String> ROOT_PATH = CollectionsKt__CollectionsKt.listOf("");

    public static final int indexOfColonInHostPort(int r4, int r5, String str) {
        boolean z = false;
        while (r4 < r5) {
            char charAt = str.charAt(r4);
            if (charAt == '[') {
                z = true;
            } else if (charAt == ']') {
                z = false;
            } else if (charAt == ':' && !z) {
                return r4;
            }
            r4++;
        }
        return -1;
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, String urlString) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        if (StringsKt__StringsJVMKt.isBlank(urlString)) {
            return uRLBuilder;
        }
        try {
            takeFromUnsafe(uRLBuilder, urlString);
            return uRLBuilder;
        } catch (Throwable th) {
            throw new URLParserException(urlString, th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0134 A[ADDED_TO_REGION, EDGE_INSN: B:234:0x0134->B:101:0x0134 BREAK  A[LOOP:5: B:95:0x0127->B:99:0x0131], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void takeFromUnsafe(final io.ktor.http.URLBuilder r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 893
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.URLParserKt.takeFromUnsafe(io.ktor.http.URLBuilder, java.lang.String):void");
    }
}
