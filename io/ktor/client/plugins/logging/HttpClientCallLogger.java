package io.ktor.client.plugins.logging;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;

/* compiled from: HttpClientCallLogger.kt */
/* loaded from: classes3.dex */
public final class HttpClientCallLogger {
    public static final /* synthetic */ AtomicIntegerFieldUpdater requestLogged$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientCallLogger.class, "requestLogged");
    public static final /* synthetic */ AtomicIntegerFieldUpdater responseLogged$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientCallLogger.class, "responseLogged");
    public final Logger logger;
    public final StringBuilder requestLog;
    private volatile /* synthetic */ int requestLogged;
    public final JobImpl requestLoggedMonitor;
    public final JobImpl responseHeaderMonitor;
    public final StringBuilder responseLog;
    private volatile /* synthetic */ int responseLogged;

    public HttpClientCallLogger(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.requestLog = new StringBuilder();
        this.responseLog = new StringBuilder();
        this.requestLoggedMonitor = JobKt.Job$default();
        this.responseHeaderMonitor = JobKt.Job$default();
        this.requestLogged = 0;
        this.responseLogged = 0;
    }

    public final void closeRequestLog() {
        JobImpl jobImpl = this.requestLoggedMonitor;
        boolean z = false;
        if (!requestLogged$FU.compareAndSet(this, 0, 1)) {
            return;
        }
        try {
            String obj = StringsKt__StringsKt.trim(this.requestLog).toString();
            if (obj.length() > 0) {
                z = true;
            }
            if (z) {
                this.logger.log(obj);
            }
        } finally {
            jobImpl.complete();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object closeResponseLog(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.logging.HttpClientCallLogger$closeResponseLog$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.plugins.logging.HttpClientCallLogger$closeResponseLog$1 r0 = (io.ktor.client.plugins.logging.HttpClientCallLogger$closeResponseLog$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.logging.HttpClientCallLogger$closeResponseLog$1 r0 = new io.ktor.client.plugins.logging.HttpClientCallLogger$closeResponseLog$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            io.ktor.client.plugins.logging.HttpClientCallLogger r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4e
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = io.ktor.client.plugins.logging.HttpClientCallLogger.responseLogged$FU
            boolean r6 = r6.compareAndSet(r5, r3, r4)
            if (r6 != 0) goto L40
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L40:
            kotlinx.coroutines.JobImpl r6 = r5.requestLoggedMonitor
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.join(r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            r0 = r5
        L4e:
            java.lang.StringBuilder r6 = r0.responseLog
            java.lang.CharSequence r6 = kotlin.text.StringsKt__StringsKt.trim(r6)
            java.lang.String r6 = r6.toString()
            int r1 = r6.length()
            if (r1 <= 0) goto L5f
            r3 = r4
        L5f:
            if (r3 == 0) goto L66
            io.ktor.client.plugins.logging.Logger r0 = r0.logger
            r0.log(r6)
        L66:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.HttpClientCallLogger.closeResponseLog(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object logResponseBody(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseBody$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseBody$1 r0 = (io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseBody$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseBody$1 r0 = new io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseBody$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.String r5 = r0.L$1
            io.ktor.client.plugins.logging.HttpClientCallLogger r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.JobImpl r6 = r4.responseHeaderMonitor
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.join(r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            java.lang.StringBuilder r6 = r0.responseLog
            r6.append(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.HttpClientCallLogger.logResponseBody(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object logResponseException(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseException$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseException$1 r0 = (io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseException$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseException$1 r0 = new io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseException$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.String r5 = r0.L$1
            io.ktor.client.plugins.logging.HttpClientCallLogger r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.JobImpl r6 = r4.requestLoggedMonitor
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.join(r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            io.ktor.client.plugins.logging.Logger r6 = r0.logger
            java.lang.CharSequence r5 = kotlin.text.StringsKt__StringsKt.trim(r5)
            java.lang.String r5 = r5.toString()
            r6.log(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.HttpClientCallLogger.logResponseException(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void logResponseHeader(String str) {
        String obj = StringsKt__StringsKt.trim(str).toString();
        StringBuilder sb = this.responseLog;
        sb.append(obj);
        sb.append('\n');
        this.responseHeaderMonitor.complete();
    }
}
