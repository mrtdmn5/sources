package aws.smithy.kotlin.runtime.http.interceptors;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InterceptorExecutor.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor", f = "InterceptorExecutor.kt", l = {206}, m = "modifyBeforeSigning")
/* loaded from: classes.dex */
public final class InterceptorExecutor$modifyBeforeSigning$1 extends ContinuationImpl {
    public HttpProtocolRequestInterceptorContext L$0;
    public Iterator L$1;
    public HttpProtocolRequestInterceptorContext L$2;
    public HttpProtocolRequestInterceptorContext L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ InterceptorExecutor<Object, Object> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterceptorExecutor$modifyBeforeSigning$1(InterceptorExecutor<Object, Object> interceptorExecutor, Continuation<? super InterceptorExecutor$modifyBeforeSigning$1> continuation) {
        super(continuation);
        this.this$0 = interceptorExecutor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.modifyBeforeSigning(null, this);
    }
}
