package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.network.sockets.ConnectTimeoutException;
import io.ktor.client.network.sockets.SocketTimeoutException;
import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.plugins.HttpSend;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.util.AttributeKey;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.slf4j.Logger;

/* compiled from: HttpRequestRetry.kt */
/* loaded from: classes3.dex */
public final class HttpRequestRetry {
    public final HttpRequestRetry$Configuration$delay$1 delay;
    public final Function2<DelayContext, Integer, Long> delayMillis;
    public final int maxRetries;
    public final HttpRequestRetry$Configuration$modifyRequest$1 modifyRequest;
    public final Function3<ShouldRetryContext, HttpRequest, HttpResponse, Boolean> shouldRetry;
    public final Function3<ShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> shouldRetryOnException;
    public static final Plugin Plugin = new Plugin();
    public static final AttributeKey<HttpRequestRetry> key = new AttributeKey<>("RetryFeature");
    public static final EventDefinition<RetryEventData> HttpRequestRetryEvent = new EventDefinition<>();

    /* compiled from: HttpRequestRetry.kt */
    /* loaded from: classes3.dex */
    public static final class Configuration {
        public Function2<? super DelayContext, ? super Integer, Long> delayMillis;
        public int maxRetries;
        public Function3<? super ShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> shouldRetry;
        public Function3<? super ShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> shouldRetryOnException;
        public final HttpRequestRetry$Configuration$modifyRequest$1 modifyRequest = HttpRequestRetry$Configuration$modifyRequest$1.INSTANCE;
        public final HttpRequestRetry$Configuration$delay$1 delay = new HttpRequestRetry$Configuration$delay$1(null);

        /* JADX WARN: Type inference failed for: r0v4, types: [io.ktor.client.plugins.HttpRequestRetry$Configuration$exponentialDelay$1] */
        public Configuration() {
            HttpRequestRetry$Configuration$retryOnServerErrors$1 block = HttpRequestRetry$Configuration$retryOnServerErrors$1.INSTANCE;
            Intrinsics.checkNotNullParameter(block, "block");
            this.maxRetries = 3;
            this.shouldRetry = block;
            final boolean z = false;
            Function3<ShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> function3 = new Function3<ShouldRetryContext, HttpRequestBuilder, Throwable, Boolean>() { // from class: io.ktor.client.plugins.HttpRequestRetry$Configuration$retryOnException$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Boolean invoke(HttpRequestRetry.ShouldRetryContext shouldRetryContext, HttpRequestBuilder httpRequestBuilder, Throwable th) {
                    boolean z2;
                    HttpRequestRetry.ShouldRetryContext retryOnExceptionIf = shouldRetryContext;
                    Throwable cause = th;
                    Intrinsics.checkNotNullParameter(retryOnExceptionIf, "$this$retryOnExceptionIf");
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(cause, "cause");
                    Logger logger = HttpRequestRetryKt.LOGGER;
                    Throwable unwrapCancellationException = AutoCloseableKt.unwrapCancellationException(cause);
                    boolean z3 = false;
                    if (!(unwrapCancellationException instanceof HttpRequestTimeoutException) && !(unwrapCancellationException instanceof ConnectTimeoutException) && !(unwrapCancellationException instanceof SocketTimeoutException)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        z3 = z;
                    } else if (!(cause instanceof CancellationException)) {
                        z3 = true;
                    }
                    return Boolean.valueOf(z3);
                }
            };
            this.maxRetries = 3;
            this.shouldRetryOnException = function3;
            final double d = 2.0d;
            final long j = 60000;
            final long j2 = 1000;
            final ?? r0 = new Function2<DelayContext, Integer, Long>() { // from class: io.ktor.client.plugins.HttpRequestRetry$Configuration$exponentialDelay$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Long invoke(HttpRequestRetry.DelayContext delayContext, Integer num) {
                    HttpRequestRetry.DelayContext delayMillis = delayContext;
                    int intValue = num.intValue();
                    Intrinsics.checkNotNullParameter(delayMillis, "$this$delayMillis");
                    long min = Math.min(((long) Math.pow(d, intValue)) * 1000, j);
                    this.getClass();
                    long j3 = j2;
                    long j4 = 0;
                    if (j3 != 0) {
                        j4 = Random.Default.nextLong(j3);
                    }
                    return Long.valueOf(min + j4);
                }
            };
            final boolean z2 = true;
            this.delayMillis = new Function2<DelayContext, Integer, Long>() { // from class: io.ktor.client.plugins.HttpRequestRetry$Configuration$delayMillis$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
                /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
                @Override // kotlin.jvm.functions.Function2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Long invoke(io.ktor.client.plugins.HttpRequestRetry.DelayContext r7, java.lang.Integer r8) {
                    /*
                        r6 = this;
                        io.ktor.client.plugins.HttpRequestRetry$DelayContext r7 = (io.ktor.client.plugins.HttpRequestRetry.DelayContext) r7
                        java.lang.Number r8 = (java.lang.Number) r8
                        int r8 = r8.intValue()
                        java.lang.String r0 = "$this$null"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                        boolean r0 = r1
                        kotlin.jvm.functions.Function2<io.ktor.client.plugins.HttpRequestRetry$DelayContext, java.lang.Integer, java.lang.Long> r1 = r2
                        if (r0 == 0) goto L57
                        io.ktor.client.statement.HttpResponse r0 = r7.response
                        if (r0 == 0) goto L3a
                        io.ktor.http.Headers r0 = r0.getHeaders()
                        if (r0 == 0) goto L3a
                        java.util.List<java.lang.String> r2 = io.ktor.http.HttpHeaders.UnsafeHeadersList
                        java.lang.String r2 = "Retry-After"
                        java.lang.String r0 = r0.get(r2)
                        if (r0 == 0) goto L3a
                        java.lang.Long r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0)
                        if (r0 == 0) goto L3a
                        long r2 = r0.longValue()
                        r0 = 1000(0x3e8, float:1.401E-42)
                        long r4 = (long) r0
                        long r2 = r2 * r4
                        java.lang.Long r0 = java.lang.Long.valueOf(r2)
                        goto L3b
                    L3a:
                        r0 = 0
                    L3b:
                        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
                        java.lang.Object r7 = r1.invoke(r7, r8)
                        java.lang.Number r7 = (java.lang.Number) r7
                        long r7 = r7.longValue()
                        if (r0 == 0) goto L50
                        long r0 = r0.longValue()
                        goto L52
                    L50:
                        r0 = 0
                    L52:
                        long r7 = java.lang.Math.max(r7, r0)
                        goto L65
                    L57:
                        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
                        java.lang.Object r7 = r1.invoke(r7, r8)
                        java.lang.Number r7 = (java.lang.Number) r7
                        long r7 = r7.longValue()
                    L65:
                        java.lang.Long r7 = java.lang.Long.valueOf(r7)
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestRetry$Configuration$delayMillis$1.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
                }
            };
        }
    }

    /* compiled from: HttpRequestRetry.kt */
    /* loaded from: classes3.dex */
    public static final class DelayContext {
        public final HttpResponse response;

        public DelayContext(HttpRequestBuilder request, HttpResponse httpResponse) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.response = httpResponse;
        }
    }

    /* compiled from: HttpRequestRetry.kt */
    /* loaded from: classes3.dex */
    public static final class ModifyRequestContext {
        public ModifyRequestContext(HttpRequestBuilder httpRequestBuilder) {
        }
    }

    /* compiled from: HttpRequestRetry.kt */
    /* loaded from: classes3.dex */
    public static final class Plugin implements HttpClientPlugin<Configuration, HttpRequestRetry> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey<HttpRequestRetry> getKey() {
            return HttpRequestRetry.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void install(HttpClient scope, Object obj) {
            HttpRequestRetry plugin = (HttpRequestRetry) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            HttpSend.Plugin plugin2 = HttpSend.Plugin;
            HttpSend httpSend = (HttpSend) HttpClientPluginKt.plugin(scope);
            httpSend.interceptors.add(new HttpRequestRetry$intercept$1(plugin, scope, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final HttpRequestRetry prepare(Function1<? super Configuration, Unit> function1) {
            Configuration configuration = new Configuration();
            function1.invoke(configuration);
            return new HttpRequestRetry(configuration);
        }
    }

    /* compiled from: HttpRequestRetry.kt */
    /* loaded from: classes3.dex */
    public static final class RetryEventData {
        public final HttpRequestBuilder request;
        public final HttpResponse response;

        public RetryEventData(int r1, HttpRequestBuilder request, HttpResponse httpResponse, Throwable th) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.request = request;
            this.response = httpResponse;
        }
    }

    /* compiled from: HttpRequestRetry.kt */
    /* loaded from: classes3.dex */
    public static final class ShouldRetryContext {
        public final int retryCount;

        public ShouldRetryContext(int r1) {
            this.retryCount = r1;
        }
    }

    public HttpRequestRetry(Configuration configuration) {
        Function3 function3 = configuration.shouldRetry;
        if (function3 != null) {
            this.shouldRetry = function3;
            Function3 function32 = configuration.shouldRetryOnException;
            if (function32 != null) {
                this.shouldRetryOnException = function32;
                Function2 function2 = configuration.delayMillis;
                if (function2 != null) {
                    this.delayMillis = function2;
                    this.delay = configuration.delay;
                    this.maxRetries = configuration.maxRetries;
                    this.modifyRequest = configuration.modifyRequest;
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("delayMillis");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("shouldRetryOnException");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shouldRetry");
        throw null;
    }
}
