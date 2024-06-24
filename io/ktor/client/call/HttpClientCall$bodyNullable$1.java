package io.ktor.client.call;

import io.ktor.util.reflect.TypeInfo;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpClientCall.kt */
@DebugMetadata(c = "io.ktor.client.call.HttpClientCall", f = "HttpClientCall.kt", l = {85, 88}, m = "bodyNullable")
/* loaded from: classes3.dex */
public final class HttpClientCall$bodyNullable$1 extends ContinuationImpl {
    public HttpClientCall L$0;
    public TypeInfo L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HttpClientCall this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientCall$bodyNullable$1(HttpClientCall httpClientCall, Continuation<? super HttpClientCall$bodyNullable$1> continuation) {
        super(continuation);
        this.this$0 = httpClientCall;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.bodyNullable(null, this);
    }
}
