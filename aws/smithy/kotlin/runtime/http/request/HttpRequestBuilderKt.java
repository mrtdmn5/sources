package aws.smithy.kotlin.runtime.http.request;

import aws.smithy.kotlin.runtime.net.UrlBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequestBuilder.kt */
/* loaded from: classes.dex */
public final class HttpRequestBuilderKt {
    /* JADX WARN: Removed duplicated region for block: B:12:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object dumpRequest(aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder r17, boolean r18, kotlin.coroutines.Continuation<? super java.lang.String> r19) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt.dumpRequest(aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static HttpRequestBuilderView immutableView$default(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return new HttpRequestBuilderView(httpRequestBuilder, false);
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, Function1<? super UrlBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(httpRequestBuilder.url);
    }
}
