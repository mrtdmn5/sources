package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.response.HttpCall;
import aws.smithy.kotlin.runtime.io.Handler;
import aws.smithy.kotlin.runtime.io.middleware.Middleware;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;

/* compiled from: SdkOperationExecution.kt */
/* loaded from: classes.dex */
public final class HttpCallMiddleware implements Middleware<OperationRequest<HttpRequestBuilder>, HttpCall> {
    public final ArrayList callList = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Type inference failed for: r7v5, types: [aws.smithy.kotlin.runtime.io.Handler] */
    /* renamed from: handle, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <H extends aws.smithy.kotlin.runtime.io.Handler<? super aws.smithy.kotlin.runtime.http.operation.OperationRequest<aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder>, ? extends aws.smithy.kotlin.runtime.http.response.HttpCall>> java.lang.Object handle2(aws.smithy.kotlin.runtime.http.operation.OperationRequest<aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder> r6, H r7, kotlin.coroutines.Continuation<? super aws.smithy.kotlin.runtime.http.response.HttpCall> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof aws.smithy.kotlin.runtime.http.operation.HttpCallMiddleware$handle$1
            if (r0 == 0) goto L13
            r0 = r8
            aws.smithy.kotlin.runtime.http.operation.HttpCallMiddleware$handle$1 r0 = (aws.smithy.kotlin.runtime.http.operation.HttpCallMiddleware$handle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.http.operation.HttpCallMiddleware$handle$1 r0 = new aws.smithy.kotlin.runtime.http.operation.HttpCallMiddleware$handle$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            aws.smithy.kotlin.runtime.http.operation.OperationRequest r6 = r0.L$1
            aws.smithy.kotlin.runtime.http.operation.HttpCallMiddleware r7 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L75
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            aws.smithy.kotlin.runtime.io.Handler r7 = r0.L$2
            aws.smithy.kotlin.runtime.http.operation.OperationRequest r6 = r0.L$1
            aws.smithy.kotlin.runtime.http.operation.HttpCallMiddleware r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            r7 = r2
            goto L65
        L42:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.ArrayList r8 = r5.callList
            boolean r2 = r8.isEmpty()
            r2 = r2 ^ r4
            if (r2 == 0) goto L63
            java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.last(r8)
            aws.smithy.kotlin.runtime.http.response.HttpCall r8 = (aws.smithy.kotlin.runtime.http.response.HttpCall) r8
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r8 = aws.smithy.kotlin.runtime.http.response.HttpCallKt.complete(r8, r0)
            if (r8 != r1) goto L63
            return r1
        L63:
            r8 = r7
            r7 = r5
        L65:
            r0.L$0 = r7
            r0.L$1 = r6
            r2 = 0
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r8 = r8.call(r6, r0)
            if (r8 != r1) goto L75
            return r1
        L75:
            aws.smithy.kotlin.runtime.http.response.HttpCall r8 = (aws.smithy.kotlin.runtime.http.response.HttpCall) r8
            java.util.ArrayList r0 = r7.callList
            r0.add(r8)
            aws.smithy.kotlin.runtime.operation.ExecutionContext r6 = r6.context
            java.util.ArrayList r7 = r7.callList
            aws.smithy.kotlin.runtime.util.AttributeKey<java.util.List<aws.smithy.kotlin.runtime.http.response.HttpCall>> r0 = aws.smithy.kotlin.runtime.http.operation.HttpOperationContext.HttpCallList
            r6.set(r0, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.operation.HttpCallMiddleware.handle2(aws.smithy.kotlin.runtime.http.operation.OperationRequest, aws.smithy.kotlin.runtime.io.Handler, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // aws.smithy.kotlin.runtime.io.middleware.Middleware
    public final /* bridge */ /* synthetic */ Object handle(OperationRequest<HttpRequestBuilder> operationRequest, Handler handler, Continuation<? super HttpCall> continuation) {
        return handle2(operationRequest, (OperationRequest<HttpRequestBuilder>) handler, continuation);
    }
}
