package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.SdkHttpClient;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.util.AttributeKey;
import aws.smithy.kotlin.runtime.util.AttributesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SdkHttpOperation.kt */
/* loaded from: classes.dex */
public final class SdkHttpOperationKt {
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object cleanup(aws.smithy.kotlin.runtime.operation.ExecutionContext r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt$cleanup$1
            if (r0 == 0) goto L13
            r0 = r6
            aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt$cleanup$1 r0 = (aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt$cleanup$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt$cleanup$1 r0 = new aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt$cleanup$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L87
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            java.util.Iterator r5 = r0.L$1
            aws.smithy.kotlin.runtime.operation.ExecutionContext r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4f
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            aws.smithy.kotlin.runtime.util.AttributeKey<java.util.List<aws.smithy.kotlin.runtime.http.response.HttpCall>> r6 = aws.smithy.kotlin.runtime.http.operation.HttpOperationContext.HttpCallList
            java.lang.Object r6 = r5.getOrNull(r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L69
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            r2 = r5
            r5 = r6
        L4f:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L68
            java.lang.Object r6 = r5.next()
            aws.smithy.kotlin.runtime.http.response.HttpCall r6 = (aws.smithy.kotlin.runtime.http.response.HttpCall) r6
            r0.L$0 = r2
            r0.L$1 = r5
            r0.label = r4
            java.lang.Object r6 = aws.smithy.kotlin.runtime.http.response.HttpCallKt.complete(r6, r0)
            if (r6 != r1) goto L4f
            return r1
        L68:
            r5 = r2
        L69:
            kotlinx.coroutines.JobImpl r5 = r5.coroutineContext
            kotlinx.coroutines.Job r5 = kotlinx.coroutines.JobKt.getJob(r5)
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            r5.cancel(r6)
            java.lang.Object r5 = r5.join(r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r5 != r6) goto L82
            goto L84
        L82:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
        L84:
            if (r5 != r1) goto L87
            return r1
        L87:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt.cleanup(aws.smithy.kotlin.runtime.operation.ExecutionContext, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0138 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object execute(aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation r16, aws.smithy.kotlin.runtime.http.SdkHttpClient r17, java.lang.Object r18, aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt$roundTrip$2 r19, kotlin.coroutines.Continuation r20) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt.execute(aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation, aws.smithy.kotlin.runtime.http.SdkHttpClient, java.lang.Object, aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt$roundTrip$2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final String getSdkRequestId(ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(executionContext, "<this>");
        AttributeKey<Integer> attributeKey = HttpOperationContext.ExpectedHttpStatus;
        return (String) AttributesKt.get(HttpOperationContext.SdkRequestId, executionContext);
    }

    public static final Object roundTrip(SdkHttpOperation sdkHttpOperation, SdkHttpClient sdkHttpClient, Object obj, Continuation continuation) {
        return execute(sdkHttpOperation, sdkHttpClient, obj, new SdkHttpOperationKt$roundTrip$2(null), continuation);
    }
}
