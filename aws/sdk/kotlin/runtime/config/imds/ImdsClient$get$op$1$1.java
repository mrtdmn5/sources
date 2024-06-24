package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.http.operation.HttpDeserialize;

/* compiled from: ImdsClient.kt */
/* loaded from: classes.dex */
public final class ImdsClient$get$op$1$1 implements HttpDeserialize<String> {
    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpDeserialize
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deserialize(aws.smithy.kotlin.runtime.operation.ExecutionContext r4, aws.smithy.kotlin.runtime.http.response.HttpResponse r5, kotlin.coroutines.Continuation<? super java.lang.String> r6) {
        /*
            r3 = this;
            boolean r4 = r6 instanceof aws.sdk.kotlin.runtime.config.imds.ImdsClient$get$op$1$1$deserialize$1
            if (r4 == 0) goto L13
            r4 = r6
            aws.sdk.kotlin.runtime.config.imds.ImdsClient$get$op$1$1$deserialize$1 r4 = (aws.sdk.kotlin.runtime.config.imds.ImdsClient$get$op$1$1$deserialize$1) r4
            int r0 = r4.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r4.label = r0
            goto L18
        L13:
            aws.sdk.kotlin.runtime.config.imds.ImdsClient$get$op$1$1$deserialize$1 r4 = new aws.sdk.kotlin.runtime.config.imds.ImdsClient$get$op$1$1$deserialize$1
            r4.<init>(r3, r6)
        L18:
            java.lang.Object r6 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            aws.smithy.kotlin.runtime.http.response.HttpResponse r5 = r4.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L49
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            aws.smithy.kotlin.runtime.http.HttpStatusCode r6 = r5.status
            boolean r6 = aws.smithy.kotlin.runtime.http.HttpStatusCodeKt.isSuccess(r6)
            if (r6 == 0) goto L5e
            r4.L$0 = r5
            r4.label = r2
            aws.smithy.kotlin.runtime.http.HttpBody r6 = r5.body
            java.io.Serializable r6 = aws.smithy.kotlin.runtime.http.HttpBodyKt.readAll(r6, r4)
            if (r6 != r0) goto L49
            return r0
        L49:
            byte[] r6 = (byte[]) r6
            if (r6 == 0) goto L52
            java.lang.String r4 = kotlin.text.StringsKt__StringsJVMKt.decodeToString(r6)
            return r4
        L52:
            aws.sdk.kotlin.runtime.config.imds.EC2MetadataError r4 = new aws.sdk.kotlin.runtime.config.imds.EC2MetadataError
            aws.smithy.kotlin.runtime.http.HttpStatusCode r5 = r5.status
            int r5 = r5.value
            java.lang.String r6 = "no metadata payload"
            r4.<init>(r5, r6)
            throw r4
        L5e:
            aws.sdk.kotlin.runtime.config.imds.EC2MetadataError r4 = new aws.sdk.kotlin.runtime.config.imds.EC2MetadataError
            aws.smithy.kotlin.runtime.http.HttpStatusCode r5 = r5.status
            int r5 = r5.value
            java.lang.String r6 = "error retrieving instance metadata"
            r4.<init>(r5, r6)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.sdk.kotlin.runtime.config.imds.ImdsClient$get$op$1$1.deserialize(aws.smithy.kotlin.runtime.operation.ExecutionContext, aws.smithy.kotlin.runtime.http.response.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
