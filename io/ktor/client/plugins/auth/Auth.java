package io.ktor.client.plugins.auth;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.plugins.HttpSend;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.collections.ConcurrentMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Auth.kt */
/* loaded from: classes3.dex */
public final class Auth {
    public final List<AuthProvider> providers;
    public static final Plugin Plugin = new Plugin();
    public static final AttributeKey<Unit> AuthCircuitBreaker = new AttributeKey<>("auth-request");
    public static final AttributeKey<Auth> key = new AttributeKey<>("DigestAuth");
    public static final ConcurrentMap<AuthProvider, AtomicCounter> tokenVersions = new ConcurrentMap<>();
    public static final AttributeKey<Map<AuthProvider, Integer>> tokenVersionsAttributeKey = new AttributeKey<>("ProviderVersionAttributeKey");

    /* compiled from: Auth.kt */
    /* loaded from: classes3.dex */
    public static final class Plugin implements HttpClientPlugin<Auth, Auth> {
        /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static final java.lang.Object access$executeWithNewToken(io.ktor.client.plugins.auth.Auth.Plugin r4, io.ktor.client.plugins.Sender r5, io.ktor.client.call.HttpClientCall r6, io.ktor.client.plugins.auth.AuthProvider r7, io.ktor.client.request.HttpRequestBuilder r8, io.ktor.http.auth.HttpAuthHeader r9, kotlin.coroutines.Continuation r10) {
            /*
                r4.getClass()
                boolean r9 = r10 instanceof io.ktor.client.plugins.auth.Auth$Plugin$executeWithNewToken$1
                if (r9 == 0) goto L16
                r9 = r10
                io.ktor.client.plugins.auth.Auth$Plugin$executeWithNewToken$1 r9 = (io.ktor.client.plugins.auth.Auth$Plugin$executeWithNewToken$1) r9
                int r0 = r9.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r0 & r1
                if (r2 == 0) goto L16
                int r0 = r0 - r1
                r9.label = r0
                goto L1b
            L16:
                io.ktor.client.plugins.auth.Auth$Plugin$executeWithNewToken$1 r9 = new io.ktor.client.plugins.auth.Auth$Plugin$executeWithNewToken$1
                r9.<init>(r4, r10)
            L1b:
                java.lang.Object r10 = r9.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r1 = r9.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L41
                if (r1 == r3) goto L35
                if (r1 != r2) goto L2d
                kotlin.ResultKt.throwOnFailure(r10)
                goto L98
            L2d:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L35:
                io.ktor.client.request.HttpRequestBuilder r4 = r9.L$3
                io.ktor.client.call.HttpClientCall r6 = r9.L$2
                io.ktor.client.plugins.Sender r5 = r9.L$1
                io.ktor.client.plugins.auth.Auth$Plugin r7 = r9.L$0
                kotlin.ResultKt.throwOnFailure(r10)
                goto L5f
            L41:
                kotlin.ResultKt.throwOnFailure(r10)
                io.ktor.client.request.HttpRequestBuilder r10 = new io.ktor.client.request.HttpRequestBuilder
                r10.<init>()
                r10.takeFromWithExecutionContext(r8)
                r9.L$0 = r4
                r9.L$1 = r5
                r9.L$2 = r6
                r9.L$3 = r10
                r9.label = r3
                java.lang.Object r7 = r7.addRequestHeaders(r10, r9)
                if (r7 != r0) goto L5d
                goto L99
            L5d:
                r7 = r4
                r4 = r10
            L5f:
                io.ktor.util.AttributesJvmBase r8 = r4.attributes
                r7.getClass()
                io.ktor.util.AttributeKey<kotlin.Unit> r7 = io.ktor.client.plugins.auth.Auth.AuthCircuitBreaker
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                r8.put(r7, r10)
                org.slf4j.Logger r7 = io.ktor.client.plugins.auth.AuthKt.LOGGER
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r10 = "Sending new request to "
                r8.<init>(r10)
                io.ktor.client.request.HttpRequest r6 = r6.getRequest()
                io.ktor.http.Url r6 = r6.getUrl()
                r8.append(r6)
                java.lang.String r6 = r8.toString()
                r7.trace(r6)
                r6 = 0
                r9.L$0 = r6
                r9.L$1 = r6
                r9.L$2 = r6
                r9.L$3 = r6
                r9.label = r2
                java.lang.Object r10 = r5.execute(r4, r9)
                if (r10 != r0) goto L98
                goto L99
            L98:
                r0 = r10
            L99:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.auth.Auth.Plugin.access$executeWithNewToken(io.ktor.client.plugins.auth.Auth$Plugin, io.ktor.client.plugins.Sender, io.ktor.client.call.HttpClientCall, io.ktor.client.plugins.auth.AuthProvider, io.ktor.client.request.HttpRequestBuilder, io.ktor.http.auth.HttpAuthHeader, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x00ba  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static final java.lang.Object access$refreshTokenIfNeeded(io.ktor.client.plugins.auth.Auth.Plugin r5, io.ktor.client.call.HttpClientCall r6, io.ktor.client.plugins.auth.AuthProvider r7, io.ktor.client.request.HttpRequestBuilder r8, kotlin.coroutines.Continuation r9) {
            /*
                Method dump skipped, instructions count: 233
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.auth.Auth.Plugin.access$refreshTokenIfNeeded(io.ktor.client.plugins.auth.Auth$Plugin, io.ktor.client.call.HttpClientCall, io.ktor.client.plugins.auth.AuthProvider, io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey<Auth> getKey() {
            return Auth.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void install(HttpClient scope, Object obj) {
            Auth plugin = (Auth) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.requestPipeline.intercept(HttpRequestPipeline.State, new Auth$Plugin$install$1(plugin, null));
            HttpSend.Plugin plugin2 = HttpSend.Plugin;
            HttpSend httpSend = (HttpSend) HttpClientPluginKt.plugin(scope);
            httpSend.interceptors.add(new Auth$Plugin$install$2(plugin, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Auth prepare(Function1<? super Auth, Unit> function1) {
            Auth auth = new Auth(0);
            function1.invoke(auth);
            return auth;
        }
    }

    public Auth() {
        throw null;
    }

    public Auth(int r1) {
        this.providers = new ArrayList();
    }
}
