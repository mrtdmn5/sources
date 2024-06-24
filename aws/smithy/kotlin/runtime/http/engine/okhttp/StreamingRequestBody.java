package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.http.HttpBody;
import java.io.IOException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* compiled from: StreamingRequestBody.kt */
/* loaded from: classes.dex */
public final class StreamingRequestBody extends RequestBody implements CoroutineScope {
    public final HttpBody body;
    public final CoroutineContext coroutineContext;
    public final JobImpl producerJob;

    public StreamingRequestBody(HttpBody body, CoroutineContext coroutineContext) {
        boolean z;
        CoroutineContext coroutineName;
        String str;
        Intrinsics.checkNotNullParameter(body, "body");
        this.body = body;
        if (!(body instanceof HttpBody.ChannelContent) && !(body instanceof HttpBody.SourceContent)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            JobImpl jobImpl = new JobImpl((Job) coroutineContext.get(Job.Key.$$INSTANCE));
            this.producerJob = jobImpl;
            CoroutineContext plus = coroutineContext.plus(jobImpl);
            CoroutineName coroutineName2 = (CoroutineName) coroutineContext.get(CoroutineName.Key);
            if (coroutineName2 != null && (str = coroutineName2.name) != null) {
                coroutineName = new CoroutineName(str.concat(":send-request-body"));
            } else {
                coroutineName = new CoroutineName("send-request-body");
            }
            this.coroutineContext = plus.plus(coroutineName).plus(Dispatchers.IO);
            return;
        }
        throw new IllegalArgumentException(("Invalid streaming body " + body).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$transferBody(aws.smithy.kotlin.runtime.http.engine.okhttp.StreamingRequestBody r7, kotlin.coroutines.Continuation r8, okio.BufferedSink r9) {
        /*
            aws.smithy.kotlin.runtime.http.HttpBody r0 = r7.body
            java.lang.String r1 = "unexpected HttpBody type "
            boolean r2 = r8 instanceof aws.smithy.kotlin.runtime.http.engine.okhttp.StreamingRequestBody$transferBody$1
            if (r2 == 0) goto L18
            r2 = r8
            aws.smithy.kotlin.runtime.http.engine.okhttp.StreamingRequestBody$transferBody$1 r2 = (aws.smithy.kotlin.runtime.http.engine.okhttp.StreamingRequestBody$transferBody$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
            goto L1d
        L18:
            aws.smithy.kotlin.runtime.http.engine.okhttp.StreamingRequestBody$transferBody$1 r2 = new aws.smithy.kotlin.runtime.http.engine.okhttp.StreamingRequestBody$transferBody$1
            r2.<init>(r7, r8)
        L1d:
            java.lang.Object r8 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L36
            if (r4 != r5) goto L2e
            kotlinx.coroutines.JobImpl r7 = r2.L$0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            goto L6c
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.JobImpl r7 = r7.producerJob
            boolean r8 = r0 instanceof aws.smithy.kotlin.runtime.http.HttpBody.ChannelContent     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            java.lang.String r4 = "<this>"
            r6 = 0
            if (r8 == 0) goto L77
            aws.smithy.kotlin.runtime.http.HttpBody$ChannelContent r0 = (aws.smithy.kotlin.runtime.http.HttpBody.ChannelContent) r0     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            aws.smithy.kotlin.runtime.io.SdkByteReadChannel r8 = r0.readFrom()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r4)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            boolean r0 = r9 instanceof aws.smithy.kotlin.runtime.io.internal.OkioSink     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            if (r0 == 0) goto L54
            aws.smithy.kotlin.runtime.io.internal.OkioSink r9 = (aws.smithy.kotlin.runtime.io.internal.OkioSink) r9     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            aws.smithy.kotlin.runtime.io.SdkSink r9 = r9.delegate     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            goto L5a
        L54:
            aws.smithy.kotlin.runtime.io.internal.OkioSdkSink r0 = new aws.smithy.kotlin.runtime.io.internal.OkioSdkSink     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r0.<init>(r9)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r9 = r0
        L5a:
            r2.L$0 = r7     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r2.label = r5     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            kotlinx.coroutines.scheduling.DefaultIoScheduler r0 = aws.smithy.kotlin.runtime.io.internal.SdkDispatchers.IO     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readAll$2 r1 = new aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readAll$2     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r1.<init>(r8, r9, r6)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r0, r1, r2)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            if (r8 != r3) goto L6c
            goto La3
        L6c:
            java.lang.Number r8 = (java.lang.Number) r8     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            long r8 = r8.longValue()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            goto L9b
        L73:
            r8 = move-exception
            goto Lc5
        L75:
            r8 = move-exception
            goto Lc1
        L77:
            boolean r8 = r0 instanceof aws.smithy.kotlin.runtime.http.HttpBody.SourceContent     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            if (r8 == 0) goto Lab
            aws.smithy.kotlin.runtime.http.HttpBody$SourceContent r0 = (aws.smithy.kotlin.runtime.http.HttpBody.SourceContent) r0     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            aws.smithy.kotlin.runtime.io.SdkSource r8 = r0.readFrom()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r4)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            boolean r0 = r8 instanceof aws.smithy.kotlin.runtime.io.internal.OkioSdkSource     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            if (r0 == 0) goto L8d
            aws.smithy.kotlin.runtime.io.internal.OkioSdkSource r8 = (aws.smithy.kotlin.runtime.io.internal.OkioSdkSource) r8     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            okio.Source r8 = r8.delegate     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            goto L93
        L8d:
            aws.smithy.kotlin.runtime.io.internal.OkioSource r0 = new aws.smithy.kotlin.runtime.io.internal.OkioSource     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r0.<init>(r8)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r8 = r0
        L93:
            long r0 = r9.writeAll(r8)     // Catch: java.lang.Throwable -> La4
            kotlin.io.CloseableKt.closeFinally(r8, r6)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r8 = r0
        L9b:
            java.lang.Long r3 = new java.lang.Long     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r3.<init>(r8)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r7.complete()
        La3:
            return r3
        La4:
            r9 = move-exception
            throw r9     // Catch: java.lang.Throwable -> La6
        La6:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r9)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            throw r0     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
        Lab:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r9.<init>(r1)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r9.append(r0)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            throw r8     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
        Lc1:
            r7.completeExceptionally(r8)     // Catch: java.lang.Throwable -> L73
            throw r8     // Catch: java.lang.Throwable -> L73
        Lc5:
            r7.complete()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.engine.okhttp.StreamingRequestBody.access$transferBody(aws.smithy.kotlin.runtime.http.engine.okhttp.StreamingRequestBody, kotlin.coroutines.Continuation, okio.BufferedSink):java.lang.Object");
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        Long contentLength = this.body.getContentLength();
        if (contentLength != null) {
            return contentLength.longValue();
        }
        return -1L;
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // okhttp3.RequestBody
    public final void isDuplex() {
        this.body.getClass();
    }

    @Override // okhttp3.RequestBody
    public final boolean isOneShot() {
        return this.body.isOneShot();
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink bufferedSink) {
        try {
            isDuplex();
            BuildersKt.runBlocking(this.coroutineContext.minusKey(CoroutineDispatcher.Key), new StreamingRequestBody$doWriteTo$2(this, null, bufferedSink));
        } catch (Exception e) {
            if (e instanceof IOException) {
                throw e;
            }
            throw new IOException(e);
        }
    }
}
