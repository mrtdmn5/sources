package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KtorCallContexts.kt */
/* loaded from: classes3.dex */
public final class ResponseHook implements ClientHook<Function3<? super OnResponseContext, ? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object>> {
    public static final ResponseHook INSTANCE = new ResponseHook();

    @Override // io.ktor.client.plugins.api.ClientHook
    public final void install(HttpClient client, Function3<? super OnResponseContext, ? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Function3<? super OnResponseContext, ? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> handler = function3;
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(handler, "handler");
        client.receivePipeline.intercept(HttpReceivePipeline.State, new ResponseHook$install$1(handler, null));
    }
}
