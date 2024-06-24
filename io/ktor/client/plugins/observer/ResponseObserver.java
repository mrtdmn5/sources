package io.ktor.client.plugins.observer;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseObserver.kt */
/* loaded from: classes3.dex */
public final class ResponseObserver {
    public final Function1<HttpClientCall, Boolean> filter;
    public final Function2<HttpResponse, Continuation<? super Unit>, Object> responseHandler;

    static {
        new AttributeKey("BodyInterceptor");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResponseObserver(Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> responseHandler, Function1<? super HttpClientCall, Boolean> function1) {
        Intrinsics.checkNotNullParameter(responseHandler, "responseHandler");
        this.responseHandler = responseHandler;
        this.filter = function1;
    }
}
