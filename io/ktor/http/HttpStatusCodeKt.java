package io.ktor.http;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpStatusCode.kt */
/* loaded from: classes3.dex */
public final class HttpStatusCodeKt {
    public static final boolean isSuccess(HttpStatusCode httpStatusCode) {
        Intrinsics.checkNotNullParameter(httpStatusCode, "<this>");
        int r2 = httpStatusCode.value;
        if (200 > r2 || r2 >= 300) {
            return false;
        }
        return true;
    }
}
