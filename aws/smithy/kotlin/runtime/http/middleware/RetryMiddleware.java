package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.io.Handler;
import aws.smithy.kotlin.runtime.io.middleware.Middleware;
import aws.smithy.kotlin.runtime.retries.RetryStrategy;
import aws.smithy.kotlin.runtime.retries.policy.RetryPolicy;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RetryMiddleware.kt */
/* loaded from: classes.dex */
public final class RetryMiddleware<I, O> implements Middleware<OperationRequest<HttpRequestBuilder>, O> {
    public final InterceptorExecutor<I, O> interceptors;
    public final RetryPolicy<O> policy;
    public final RetryStrategy strategy;

    /* JADX WARN: Multi-variable type inference failed */
    public RetryMiddleware(RetryStrategy strategy, RetryPolicy<? super O> policy, InterceptorExecutor<I, O> interceptorExecutor) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(policy, "policy");
        this.strategy = strategy;
        this.policy = policy;
        this.interceptors = interceptorExecutor;
    }

    /* JADX WARN: Code restructure failed: missing block: B:96:0x00cc, code lost:            if (r0 == r4) goto L83;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* renamed from: access$tryAttempt-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m619access$tryAttemptBWLJW6A(aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware r15, aws.smithy.kotlin.runtime.http.operation.OperationRequest r16, aws.smithy.kotlin.runtime.io.Handler r17, int r18, kotlin.coroutines.Continuation r19) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware.m619access$tryAttemptBWLJW6A(aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware, aws.smithy.kotlin.runtime.http.operation.OperationRequest, aws.smithy.kotlin.runtime.io.Handler, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // aws.smithy.kotlin.runtime.io.middleware.Middleware
    public final /* bridge */ /* synthetic */ Object handle(OperationRequest<HttpRequestBuilder> operationRequest, Handler handler, Continuation continuation) {
        return handle2(operationRequest, (OperationRequest<HttpRequestBuilder>) handler, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Type inference failed for: r0v21, types: [aws.smithy.kotlin.runtime.io.Handler] */
    /* renamed from: handle, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <H extends aws.smithy.kotlin.runtime.io.Handler<? super aws.smithy.kotlin.runtime.http.operation.OperationRequest<aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder>, ? extends O>> java.lang.Object handle2(aws.smithy.kotlin.runtime.http.operation.OperationRequest<aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder> r17, H r18, kotlin.coroutines.Continuation<? super O> r19) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware.handle2(aws.smithy.kotlin.runtime.http.operation.OperationRequest, aws.smithy.kotlin.runtime.io.Handler, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
