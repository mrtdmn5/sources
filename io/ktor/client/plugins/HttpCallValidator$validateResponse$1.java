package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpCallValidator.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator", f = "HttpCallValidator.kt", l = {51}, m = "validateResponse")
/* loaded from: classes3.dex */
public final class HttpCallValidator$validateResponse$1 extends ContinuationImpl {
    public HttpResponse L$0;
    public Iterator L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HttpCallValidator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$validateResponse$1(HttpCallValidator httpCallValidator, Continuation<? super HttpCallValidator$validateResponse$1> continuation) {
        super(continuation);
        this.this$0 = httpCallValidator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpCallValidator.access$validateResponse(this.this$0, null, this);
    }
}
