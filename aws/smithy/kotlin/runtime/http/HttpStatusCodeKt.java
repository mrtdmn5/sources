package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpStatusCode.kt */
/* loaded from: classes.dex */
public final class HttpStatusCodeKt {
    public static final boolean isSuccess(HttpStatusCode httpStatusCode) {
        Intrinsics.checkNotNullParameter(httpStatusCode, "<this>");
        return HttpStatusCode.Category.SUCCESS.contains(httpStatusCode.value);
    }
}
