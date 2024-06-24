package io.ktor.client.engine.android;

/* compiled from: AndroidURLConnectionUtils.kt */
/* loaded from: classes3.dex */
public final class AndroidURLConnectionUtilsKt {
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:            if (r6 != false) goto L32;     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object timeoutAwareConnection(java.net.HttpURLConnection r4, io.ktor.client.request.HttpRequestData r5, io.ktor.client.engine.android.AndroidClientEngine$execute$2 r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.client.engine.android.AndroidURLConnectionUtilsKt$timeoutAwareConnection$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.client.engine.android.AndroidURLConnectionUtilsKt$timeoutAwareConnection$1 r0 = (io.ktor.client.engine.android.AndroidURLConnectionUtilsKt$timeoutAwareConnection$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.engine.android.AndroidURLConnectionUtilsKt$timeoutAwareConnection$1 r0 = new io.ktor.client.engine.android.AndroidURLConnectionUtilsKt$timeoutAwareConnection$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Throwable r4 = r0.L$1
            io.ktor.client.request.HttpRequestData r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L49
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r4 = r6.invoke(r4)     // Catch: java.lang.Throwable -> L3b
            return r4
        L3b:
            r4 = move-exception
            r0.L$0 = r5
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.YieldKt.yield(r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            boolean r6 = r4 instanceof java.net.SocketTimeoutException
            if (r6 != 0) goto L64
            boolean r6 = r4 instanceof java.net.ConnectException
            r7 = 0
            if (r6 == 0) goto L63
            java.lang.String r6 = r4.getMessage()
            if (r6 == 0) goto L5f
            java.lang.String r0 = "timed out"
            boolean r6 = kotlin.text.StringsKt__StringsKt.contains(r6, r0, r7)
            goto L60
        L5f:
            r6 = r7
        L60:
            if (r6 == 0) goto L63
            goto L64
        L63:
            r3 = r7
        L64:
            if (r3 == 0) goto La0
            org.slf4j.Logger r6 = io.ktor.client.plugins.HttpTimeoutKt.LOGGER
            java.lang.String r6 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            io.ktor.client.network.sockets.ConnectTimeoutException r6 = new io.ktor.client.network.sockets.ConnectTimeoutException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Connect timeout has expired [url="
            r7.<init>(r0)
            io.ktor.http.Url r0 = r5.url
            r7.append(r0)
            java.lang.String r0 = ", connect_timeout="
            r7.append(r0)
            io.ktor.client.plugins.HttpTimeout$Plugin r0 = io.ktor.client.plugins.HttpTimeout.Plugin
            java.lang.Object r5 = r5.getCapabilityOrNull()
            io.ktor.client.plugins.HttpTimeout$HttpTimeoutCapabilityConfiguration r5 = (io.ktor.client.plugins.HttpTimeout.HttpTimeoutCapabilityConfiguration) r5
            if (r5 == 0) goto L8e
            java.lang.Long r5 = r5._connectTimeoutMillis
            if (r5 != 0) goto L90
        L8e:
            java.lang.String r5 = "unknown"
        L90:
            r7.append(r5)
            java.lang.String r5 = " ms]"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5, r4)
            r4 = r6
        La0:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.android.AndroidURLConnectionUtilsKt.timeoutAwareConnection(java.net.HttpURLConnection, io.ktor.client.request.HttpRequestData, io.ktor.client.engine.android.AndroidClientEngine$execute$2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
