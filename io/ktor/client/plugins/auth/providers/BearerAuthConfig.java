package io.ktor.client.plugins.auth.providers;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* compiled from: BearerAuthProvider.kt */
/* loaded from: classes3.dex */
public final class BearerAuthConfig {
    public Function2<? super RefreshTokensParams, ? super Continuation<? super BearerTokens>, ? extends Object> _refreshTokens = new BearerAuthConfig$_refreshTokens$1(null);
    public final BearerAuthConfig$_loadTokens$1 _loadTokens = new BearerAuthConfig$_loadTokens$1(null);
    public final BearerAuthConfig$_sendWithoutRequest$1 _sendWithoutRequest = BearerAuthConfig$_sendWithoutRequest$1.INSTANCE;
}
