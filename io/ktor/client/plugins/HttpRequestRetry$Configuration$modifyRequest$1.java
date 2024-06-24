package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: HttpRequestRetry.kt */
/* loaded from: classes3.dex */
public final class HttpRequestRetry$Configuration$modifyRequest$1 extends Lambda implements Function2<HttpRequestRetry.ModifyRequestContext, HttpRequestBuilder, Unit> {
    public static final HttpRequestRetry$Configuration$modifyRequest$1 INSTANCE = new HttpRequestRetry$Configuration$modifyRequest$1();

    public HttpRequestRetry$Configuration$modifyRequest$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(HttpRequestRetry.ModifyRequestContext modifyRequestContext, HttpRequestBuilder httpRequestBuilder) {
        HttpRequestBuilder it = httpRequestBuilder;
        Intrinsics.checkNotNullParameter(modifyRequestContext, "$this$null");
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
