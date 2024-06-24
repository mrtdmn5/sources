package okhttp3.internal.http;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpMethod.kt */
/* loaded from: classes4.dex */
public final class HttpMethod {
    public static final boolean permitsRequestBody(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (!Intrinsics.areEqual(method, "GET") && !Intrinsics.areEqual(method, "HEAD")) {
            return true;
        }
        return false;
    }
}
