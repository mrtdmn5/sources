package aws.smithy.kotlin.runtime.http.interceptors;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InterceptorExecutor.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor", f = "InterceptorExecutor.kt", l = {236}, m = "modifyBeforeDeserialization")
/* loaded from: classes.dex */
public final class InterceptorExecutor$modifyBeforeDeserialization$1 extends ContinuationImpl {
    public HttpProtocolResponseInterceptorContext L$0;
    public Iterator L$1;
    public HttpProtocolResponseInterceptorContext L$2;
    public HttpProtocolResponseInterceptorContext L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ InterceptorExecutor<I, O> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterceptorExecutor$modifyBeforeDeserialization$1(InterceptorExecutor<I, O> interceptorExecutor, Continuation<? super InterceptorExecutor$modifyBeforeDeserialization$1> continuation) {
        super(continuation);
        this.this$0 = interceptorExecutor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.modifyBeforeDeserialization(null, this);
    }
}
