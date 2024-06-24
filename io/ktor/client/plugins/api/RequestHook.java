package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KtorCallContexts.kt */
/* loaded from: classes3.dex */
public final class RequestHook implements ClientHook<Function4<? super OnRequestContext, ? super HttpRequestBuilder, ? super Object, ? super Continuation<? super Unit>, ? extends Object>> {
    public static final RequestHook INSTANCE = new RequestHook();

    @Override // io.ktor.client.plugins.api.ClientHook
    public final void install(HttpClient client, Function4<? super OnRequestContext, ? super HttpRequestBuilder, ? super Object, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Function4<? super OnRequestContext, ? super HttpRequestBuilder, ? super Object, ? super Continuation<? super Unit>, ? extends Object> handler = function4;
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(handler, "handler");
        client.requestPipeline.intercept(HttpRequestPipeline.State, new RequestHook$install$1(handler, null));
    }
}
