package aws.smithy.kotlin.runtime.http;

/* compiled from: HttpBody.kt */
/* loaded from: classes.dex */
public final class HttpBodyKt {
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Type inference failed for: r2v2, types: [byte[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r2v3, types: [byte[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [byte[], java.io.Serializable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.io.Serializable readAll(aws.smithy.kotlin.runtime.http.HttpBody r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof aws.smithy.kotlin.runtime.http.HttpBodyKt$readAll$1
            if (r0 == 0) goto L13
            r0 = r6
            aws.smithy.kotlin.runtime.http.HttpBodyKt$readAll$1 r0 = (aws.smithy.kotlin.runtime.http.HttpBodyKt$readAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.http.HttpBodyKt$readAll$1 r0 = new aws.smithy.kotlin.runtime.http.HttpBodyKt$readAll$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L7e
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5d
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5 instanceof aws.smithy.kotlin.runtime.http.HttpBody.Empty
            r2 = 0
            if (r6 == 0) goto L3f
            goto L81
        L3f:
            boolean r6 = r5 instanceof aws.smithy.kotlin.runtime.http.HttpBody.Bytes
            if (r6 == 0) goto L4a
            aws.smithy.kotlin.runtime.http.HttpBody$Bytes r5 = (aws.smithy.kotlin.runtime.http.HttpBody.Bytes) r5
            byte[] r2 = r5.bytes()
            goto L81
        L4a:
            boolean r6 = r5 instanceof aws.smithy.kotlin.runtime.http.HttpBody.ChannelContent
            if (r6 == 0) goto L64
            aws.smithy.kotlin.runtime.http.HttpBody$ChannelContent r5 = (aws.smithy.kotlin.runtime.http.HttpBody.ChannelContent) r5
            aws.smithy.kotlin.runtime.io.SdkByteReadChannel r5 = r5.readFrom()
            r0.label = r4
            java.lang.Object r6 = aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt.readToBuffer(r5, r0)
            if (r6 != r1) goto L5d
            return r1
        L5d:
            aws.smithy.kotlin.runtime.io.SdkBuffer r6 = (aws.smithy.kotlin.runtime.io.SdkBuffer) r6
            byte[] r2 = r6.readByteArray()
            goto L81
        L64:
            boolean r6 = r5 instanceof aws.smithy.kotlin.runtime.http.HttpBody.SourceContent
            if (r6 == 0) goto L82
            aws.smithy.kotlin.runtime.http.HttpBody$SourceContent r5 = (aws.smithy.kotlin.runtime.http.HttpBody.SourceContent) r5
            aws.smithy.kotlin.runtime.io.SdkSource r5 = r5.readFrom()
            r0.label = r3
            kotlinx.coroutines.scheduling.DefaultIoScheduler r6 = kotlinx.coroutines.Dispatchers.IO
            aws.smithy.kotlin.runtime.io.SdkSourceJVMKt$readToByteArray$2 r3 = new aws.smithy.kotlin.runtime.io.SdkSourceJVMKt$readToByteArray$2
            r3.<init>(r5, r2)
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r3, r0)
            if (r6 != r1) goto L7e
            return r1
        L7e:
            r2 = r6
            byte[] r2 = (byte[]) r2
        L81:
            return r2
        L82:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.HttpBodyKt.readAll(aws.smithy.kotlin.runtime.http.HttpBody, kotlin.coroutines.Continuation):java.io.Serializable");
    }
}
