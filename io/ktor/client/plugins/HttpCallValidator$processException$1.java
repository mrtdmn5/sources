package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequest;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpCallValidator.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator", f = "HttpCallValidator.kt", l = {58, 59}, m = "processException")
/* loaded from: classes3.dex */
public final class HttpCallValidator$processException$1 extends ContinuationImpl {
    public Throwable L$0;
    public HttpRequest L$1;
    public Iterator L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HttpCallValidator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$processException$1(HttpCallValidator httpCallValidator, Continuation<? super HttpCallValidator$processException$1> continuation) {
        super(continuation);
        this.this$0 = httpCallValidator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpCallValidator.access$processException(this.this$0, null, null, this);
    }
}
