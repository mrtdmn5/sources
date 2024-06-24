package aws.smithy.kotlin.runtime.http.interceptors;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InterceptorExecutor.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor", f = "InterceptorExecutor.kt", l = {133}, m = "modifyBeforeSerialization")
/* loaded from: classes.dex */
public final class InterceptorExecutor$modifyBeforeSerialization$1 extends ContinuationImpl {
    public InterceptorExecutor L$0;
    public HttpInputInterceptorContext L$1;
    public Iterator L$2;
    public HttpInputInterceptorContext L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ InterceptorExecutor<I, O> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterceptorExecutor$modifyBeforeSerialization$1(InterceptorExecutor<I, O> interceptorExecutor, Continuation<? super InterceptorExecutor$modifyBeforeSerialization$1> continuation) {
        super(continuation);
        this.this$0 = interceptorExecutor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.modifyBeforeSerialization(null, this);
    }
}
