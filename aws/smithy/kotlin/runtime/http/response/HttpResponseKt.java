package aws.smithy.kotlin.runtime.http.response;

/* compiled from: HttpResponse.kt */
/* loaded from: classes.dex */
public final class HttpResponseKt {
    /* JADX WARN: Removed duplicated region for block: B:12:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.io.Serializable dumpResponse(aws.smithy.kotlin.runtime.http.response.HttpResponse r8, boolean r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof aws.smithy.kotlin.runtime.http.response.HttpResponseKt$dumpResponse$1
            if (r0 == 0) goto L13
            r0 = r10
            aws.smithy.kotlin.runtime.http.response.HttpResponseKt$dumpResponse$1 r0 = (aws.smithy.kotlin.runtime.http.response.HttpResponseKt$dumpResponse$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.http.response.HttpResponseKt$dumpResponse$1 r0 = new aws.smithy.kotlin.runtime.http.response.HttpResponseKt$dumpResponse$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            aws.smithy.kotlin.runtime.http.response.HttpResponse r8 = r0.L$2
            aws.smithy.kotlin.runtime.io.SdkBuffer r9 = r0.L$1
            aws.smithy.kotlin.runtime.http.response.HttpResponse r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L93
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r10)
            aws.smithy.kotlin.runtime.io.SdkBuffer r10 = new aws.smithy.kotlin.runtime.io.SdkBuffer
            r10.<init>()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "HTTP "
            r2.<init>(r5)
            aws.smithy.kotlin.runtime.http.HttpStatusCode r5 = r8.status
            r2.append(r5)
            java.lang.String r5 = "\r\n"
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            aws.smithy.kotlin.runtime.io.SdkBufferedSink.DefaultImpls.writeUtf8$default(r10, r2)
            aws.smithy.kotlin.runtime.http.response.HttpResponseKt$dumpResponse$2 r2 = new aws.smithy.kotlin.runtime.http.response.HttpResponseKt$dumpResponse$2
            r2.<init>()
            aws.smithy.kotlin.runtime.http.Headers r6 = r8.headers
            r6.forEach(r2)
            r2 = 2
            r10.writeUtf8(r3, r2, r5)
            if (r9 == 0) goto Lbc
            aws.smithy.kotlin.runtime.http.HttpBody r9 = r8.body
            boolean r2 = r9 instanceof aws.smithy.kotlin.runtime.http.HttpBody.Bytes
            if (r2 == 0) goto L76
            aws.smithy.kotlin.runtime.http.HttpBody$Bytes r9 = (aws.smithy.kotlin.runtime.http.HttpBody.Bytes) r9
            byte[] r9 = r9.bytes()
            aws.smithy.kotlin.runtime.io.SdkBufferedSink.DefaultImpls.write$default(r10, r9)
            goto Lbc
        L76:
            boolean r2 = r9 instanceof aws.smithy.kotlin.runtime.http.HttpBody.ChannelContent
            if (r2 == 0) goto L7c
            r2 = r4
            goto L7e
        L7c:
            boolean r2 = r9 instanceof aws.smithy.kotlin.runtime.http.HttpBody.SourceContent
        L7e:
            if (r2 == 0) goto Lba
            r0.L$0 = r8
            r0.L$1 = r10
            r0.L$2 = r8
            r0.label = r4
            java.io.Serializable r9 = aws.smithy.kotlin.runtime.http.HttpBodyKt.readAll(r9, r0)
            if (r9 != r1) goto L8f
            return r1
        L8f:
            r0 = r8
            r7 = r10
            r10 = r9
            r9 = r7
        L93:
            byte[] r10 = (byte[]) r10
            if (r10 == 0) goto Lb8
            int r8 = r10.length
            int r8 = r8 - r3
            r9.write(r10, r3, r8)
            aws.smithy.kotlin.runtime.http.content.ByteArrayContent r8 = new aws.smithy.kotlin.runtime.http.content.ByteArrayContent
            r8.<init>(r10)
            aws.smithy.kotlin.runtime.http.HttpStatusCode r10 = r0.status
            java.lang.String r1 = "status"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            java.lang.String r1 = "headers"
            aws.smithy.kotlin.runtime.http.Headers r0 = r0.headers
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            aws.smithy.kotlin.runtime.http.response.HttpResponse r1 = new aws.smithy.kotlin.runtime.http.response.HttpResponse
            r1.<init>(r10, r0, r8)
            r10 = r9
            r8 = r1
            goto Lbc
        Lb8:
            r10 = r9
            goto Lbc
        Lba:
            boolean r9 = r9 instanceof aws.smithy.kotlin.runtime.http.HttpBody.Empty
        Lbc:
            okio.Buffer r9 = r10.inner
            java.lang.String r9 = r9.readUtf8()
            kotlin.Pair r10 = new kotlin.Pair
            r10.<init>(r8, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.response.HttpResponseKt.dumpResponse(aws.smithy.kotlin.runtime.http.response.HttpResponse, boolean, kotlin.coroutines.Continuation):java.io.Serializable");
    }
}
