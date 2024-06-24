package io.ktor.client.engine;

import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.request.HttpRequestData;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpClientEngine.kt */
@DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$DefaultImpls", f = "HttpClientEngine.kt", l = {91, 100}, m = "executeWithinCallContext")
/* loaded from: classes3.dex */
public final class HttpClientEngine$executeWithinCallContext$1 extends ContinuationImpl {
    public HttpClientEngine L$0;
    public HttpRequestData L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpClientEngine.DefaultImpls.access$executeWithinCallContext(null, null, this);
    }
}
