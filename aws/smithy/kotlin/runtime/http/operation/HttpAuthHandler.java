package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.auth.HttpSigner;
import aws.smithy.kotlin.runtime.http.auth.HttpSigner$Companion$Anonymous$1;
import aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.io.Handler;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SdkOperationExecution.kt */
/* loaded from: classes.dex */
public final class HttpAuthHandler<Input, Output> implements Handler<OperationRequest<HttpRequestBuilder>, Output> {
    public final Handler<OperationRequest<HttpRequestBuilder>, Output> inner;
    public final InterceptorExecutor<Input, Output> interceptors;
    public final HttpSigner signer;

    public HttpAuthHandler(DeserializeHandler deserializeHandler, HttpSigner$Companion$Anonymous$1 signer, InterceptorExecutor interceptorExecutor) {
        Intrinsics.checkNotNullParameter(signer, "signer");
        this.inner = deserializeHandler;
        this.signer = signer;
        this.interceptors = interceptorExecutor;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // aws.smithy.kotlin.runtime.io.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object call(aws.smithy.kotlin.runtime.http.operation.OperationRequest<aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder> r11, kotlin.coroutines.Continuation<? super Output> r12) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.operation.HttpAuthHandler.call(aws.smithy.kotlin.runtime.http.operation.OperationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
