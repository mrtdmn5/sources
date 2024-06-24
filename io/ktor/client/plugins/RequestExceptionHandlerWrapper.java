package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequest;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;

/* compiled from: HttpCallValidator.kt */
/* loaded from: classes3.dex */
public final class RequestExceptionHandlerWrapper implements HandlerWrapper {
    public final Function3<Throwable, HttpRequest, Continuation<? super Unit>, Object> handler;

    /* JADX WARN: Multi-variable type inference failed */
    public RequestExceptionHandlerWrapper(Function3<? super Throwable, ? super HttpRequest, ? super Continuation<? super Unit>, ? extends Object> function3) {
        this.handler = function3;
    }
}
