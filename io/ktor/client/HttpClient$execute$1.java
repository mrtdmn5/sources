package io.ktor.client;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpClient.kt */
@DebugMetadata(c = "io.ktor.client.HttpClient", f = "HttpClient.kt", l = {191}, m = "execute$ktor_client_core")
/* loaded from: classes3.dex */
public final class HttpClient$execute$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HttpClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClient$execute$1(HttpClient httpClient, Continuation<? super HttpClient$execute$1> continuation) {
        super(continuation);
        this.this$0 = httpClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute$ktor_client_core(null, this);
    }
}
