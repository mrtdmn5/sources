package io.ktor.client.plugins.auth.providers;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: BearerAuthProvider.kt */
/* loaded from: classes3.dex */
public final class BearerAuthConfig$_sendWithoutRequest$1 extends Lambda implements Function1<HttpRequestBuilder, Boolean> {
    public static final BearerAuthConfig$_sendWithoutRequest$1 INSTANCE = new BearerAuthConfig$_sendWithoutRequest$1();

    public BearerAuthConfig$_sendWithoutRequest$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(HttpRequestBuilder httpRequestBuilder) {
        HttpRequestBuilder it = httpRequestBuilder;
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.TRUE;
    }
}
