package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.AttributeKey;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpSend.kt */
/* loaded from: classes3.dex */
public final class HttpSend {
    public static final Plugin Plugin = new Plugin();
    public static final AttributeKey<HttpSend> key = new AttributeKey<>("HttpSend");
    public final int maxSendCount = 20;
    public final ArrayList interceptors = new ArrayList();

    /* compiled from: HttpSend.kt */
    /* loaded from: classes3.dex */
    public static final class Config {
    }

    /* compiled from: HttpSend.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultSender implements Sender {
        public final HttpClient client;
        public HttpClientCall currentCall;
        public final int maxSendCount;
        public int sentCount;

        public DefaultSender(int r2, HttpClient client) {
            Intrinsics.checkNotNullParameter(client, "client");
            this.maxSendCount = r2;
            this.client = client;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        @Override // io.ktor.client.plugins.Sender
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object execute(io.ktor.client.request.HttpRequestBuilder r6, kotlin.coroutines.Continuation<? super io.ktor.client.call.HttpClientCall> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof io.ktor.client.plugins.HttpSend$DefaultSender$execute$1
                if (r0 == 0) goto L13
                r0 = r7
                io.ktor.client.plugins.HttpSend$DefaultSender$execute$1 r0 = (io.ktor.client.plugins.HttpSend$DefaultSender$execute$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                io.ktor.client.plugins.HttpSend$DefaultSender$execute$1 r0 = new io.ktor.client.plugins.HttpSend$DefaultSender$execute$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L32
                if (r2 != r4) goto L2a
                io.ktor.client.plugins.HttpSend$DefaultSender r6 = r0.L$0
                kotlin.ResultKt.throwOnFailure(r7)
                goto L57
            L2a:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L32:
                kotlin.ResultKt.throwOnFailure(r7)
                io.ktor.client.call.HttpClientCall r7 = r5.currentCall
                if (r7 == 0) goto L3c
                kotlinx.coroutines.CoroutineScopeKt.cancel(r7, r3)
            L3c:
                int r7 = r5.sentCount
                int r2 = r5.maxSendCount
                if (r7 >= r2) goto L7b
                int r7 = r7 + r4
                r5.sentCount = r7
                io.ktor.client.HttpClient r7 = r5.client
                io.ktor.client.request.HttpSendPipeline r7 = r7.sendPipeline
                java.lang.Object r2 = r6.body
                r0.L$0 = r5
                r0.label = r4
                java.lang.Object r7 = r7.execute(r6, r2, r0)
                if (r7 != r1) goto L56
                return r1
            L56:
                r6 = r5
            L57:
                boolean r0 = r7 instanceof io.ktor.client.call.HttpClientCall
                if (r0 == 0) goto L5e
                r3 = r7
                io.ktor.client.call.HttpClientCall r3 = (io.ktor.client.call.HttpClientCall) r3
            L5e:
                if (r3 == 0) goto L63
                r6.currentCall = r3
                return r3
            L63:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r0 = "Failed to execute send pipeline. Expected [HttpClientCall], but received "
                r6.<init>(r0)
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r6 = r6.toString()
                r7.<init>(r6)
                throw r7
            L7b:
                io.ktor.client.plugins.SendCountExceedException r6 = new io.ktor.client.plugins.SendCountExceedException
                java.lang.String r7 = "Max send count "
                java.lang.String r0 = " exceeded. Consider increasing the property maxSendCount if more is required."
                java.lang.String r7 = androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m(r7, r2, r0)
                r6.<init>(r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpSend.DefaultSender.execute(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* compiled from: HttpSend.kt */
    /* loaded from: classes3.dex */
    public static final class InterceptedSender implements Sender {
        public final Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> interceptor;
        public final Sender nextSender;

        /* JADX WARN: Multi-variable type inference failed */
        public InterceptedSender(Function3<? super Sender, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object> interceptor, Sender nextSender) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            Intrinsics.checkNotNullParameter(nextSender, "nextSender");
            this.interceptor = interceptor;
            this.nextSender = nextSender;
        }

        @Override // io.ktor.client.plugins.Sender
        public final Object execute(HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
            return this.interceptor.invoke(this.nextSender, httpRequestBuilder, continuation);
        }
    }

    /* compiled from: HttpSend.kt */
    /* loaded from: classes3.dex */
    public static final class Plugin implements HttpClientPlugin<Config, HttpSend> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey<HttpSend> getKey() {
            return HttpSend.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void install(HttpClient scope, Object obj) {
            HttpSend plugin = (HttpSend) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.requestPipeline.intercept(HttpRequestPipeline.Send, new HttpSend$Plugin$install$1(plugin, scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final HttpSend prepare(Function1<? super Config, Unit> function1) {
            function1.invoke(new Config());
            return new HttpSend();
        }
    }
}
