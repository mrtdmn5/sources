package io.ktor.client.plugins.logging;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpClientCallLogger.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.HttpClientCallLogger", f = "HttpClientCallLogger.kt", l = {29}, m = "logResponseException")
/* loaded from: classes3.dex */
public final class HttpClientCallLogger$logResponseException$1 extends ContinuationImpl {
    public HttpClientCallLogger L$0;
    public String L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HttpClientCallLogger this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientCallLogger$logResponseException$1(HttpClientCallLogger httpClientCallLogger, Continuation<? super HttpClientCallLogger$logResponseException$1> continuation) {
        super(continuation);
        this.this$0 = httpClientCallLogger;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.logResponseException(null, this);
    }
}
