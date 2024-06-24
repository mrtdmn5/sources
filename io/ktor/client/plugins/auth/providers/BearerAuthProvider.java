package io.ktor.client.plugins.auth.providers;

import io.ktor.client.plugins.auth.AuthKt;
import io.ktor.client.plugins.auth.AuthProvider;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HeaderValueParam;
import io.ktor.http.auth.HttpAuthHeader;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BearerAuthProvider.kt */
/* loaded from: classes3.dex */
public final class BearerAuthProvider implements AuthProvider {
    public final String realm;
    public final Function2<RefreshTokensParams, Continuation<? super BearerTokens>, Object> refreshTokens;
    public final Function1<HttpRequestBuilder, Boolean> sendWithoutRequestCallback;
    public final AuthTokenHolder<BearerTokens> tokensHolder;

    public BearerAuthProvider(Function2 refreshTokens, BearerAuthConfig$_loadTokens$1 loadTokens, BearerAuthConfig$_sendWithoutRequest$1 sendWithoutRequestCallback) {
        Intrinsics.checkNotNullParameter(refreshTokens, "refreshTokens");
        Intrinsics.checkNotNullParameter(loadTokens, "loadTokens");
        Intrinsics.checkNotNullParameter(sendWithoutRequestCallback, "sendWithoutRequestCallback");
        this.refreshTokens = refreshTokens;
        this.sendWithoutRequestCallback = sendWithoutRequestCallback;
        this.realm = null;
        this.tokensHolder = new AuthTokenHolder<>(loadTokens);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // io.ktor.client.plugins.auth.AuthProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object addRequestHeaders(io.ktor.client.request.HttpRequestBuilder r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.auth.providers.BearerAuthProvider$addRequestHeaders$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.plugins.auth.providers.BearerAuthProvider$addRequestHeaders$1 r0 = (io.ktor.client.plugins.auth.providers.BearerAuthProvider$addRequestHeaders$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.auth.providers.BearerAuthProvider$addRequestHeaders$1 r0 = new io.ktor.client.plugins.auth.providers.BearerAuthProvider$addRequestHeaders$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.client.request.HttpRequestBuilder r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L41
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r3
            io.ktor.client.plugins.auth.providers.AuthTokenHolder<io.ktor.client.plugins.auth.providers.BearerTokens> r6 = r4.tokensHolder
            java.lang.Object r6 = r6.loadToken$ktor_client_auth(r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            io.ktor.client.plugins.auth.providers.BearerTokens r6 = (io.ktor.client.plugins.auth.providers.BearerTokens) r6
            if (r6 != 0) goto L48
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L48:
            io.ktor.client.plugins.auth.providers.BearerAuthProvider$addRequestHeaders$2 r0 = new io.ktor.client.plugins.auth.providers.BearerAuthProvider$addRequestHeaders$2
            r0.<init>()
            io.ktor.client.request.HttpRequestKt.headers(r5, r0)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.auth.providers.BearerAuthProvider.addRequestHeaders(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.client.plugins.auth.AuthProvider
    public final boolean isApplicable(HttpAuthHeader auth) {
        String str;
        Object obj;
        Intrinsics.checkNotNullParameter(auth, "auth");
        boolean z = false;
        if (!Intrinsics.areEqual(auth.authScheme, "Bearer")) {
            AuthKt.LOGGER.trace("Bearer Auth Provider is not applicable for " + auth);
            return false;
        }
        String str2 = this.realm;
        if (str2 == null) {
            z = true;
        } else if (auth instanceof HttpAuthHeader.Parameterized) {
            Iterator<T> it = ((HttpAuthHeader.Parameterized) auth).parameters.iterator();
            while (true) {
                str = null;
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((HeaderValueParam) obj).name, "realm")) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            HeaderValueParam headerValueParam = (HeaderValueParam) obj;
            if (headerValueParam != null) {
                str = headerValueParam.value;
            }
            z = Intrinsics.areEqual(str, str2);
        }
        if (!z) {
            AuthKt.LOGGER.trace("Bearer Auth Provider is not applicable for this realm");
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // io.ktor.client.plugins.auth.AuthProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object refreshToken(io.ktor.client.statement.HttpResponse r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.auth.providers.BearerAuthProvider$refreshToken$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.plugins.auth.providers.BearerAuthProvider$refreshToken$1 r0 = (io.ktor.client.plugins.auth.providers.BearerAuthProvider$refreshToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.auth.providers.BearerAuthProvider$refreshToken$1 r0 = new io.ktor.client.plugins.auth.providers.BearerAuthProvider$refreshToken$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r6)
            goto L43
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.client.plugins.auth.providers.BearerAuthProvider$refreshToken$newToken$1 r6 = new io.ktor.client.plugins.auth.providers.BearerAuthProvider$refreshToken$newToken$1
            r2 = 0
            r6.<init>(r4, r5, r2)
            r0.label = r3
            io.ktor.client.plugins.auth.providers.AuthTokenHolder<io.ktor.client.plugins.auth.providers.BearerTokens> r5 = r4.tokensHolder
            java.lang.Object r6 = r5.setToken$ktor_client_auth(r6, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            io.ktor.client.plugins.auth.providers.BearerTokens r6 = (io.ktor.client.plugins.auth.providers.BearerTokens) r6
            if (r6 == 0) goto L48
            goto L49
        L48:
            r3 = 0
        L49:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.auth.providers.BearerAuthProvider.refreshToken(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.client.plugins.auth.AuthProvider
    public final boolean sendWithoutRequest(HttpRequestBuilder request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.sendWithoutRequestCallback.invoke(request).booleanValue();
    }
}
