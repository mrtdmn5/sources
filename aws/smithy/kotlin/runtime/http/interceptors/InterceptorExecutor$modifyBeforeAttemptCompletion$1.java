package aws.smithy.kotlin.runtime.http.interceptors;

import java.util.Iterator;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InterceptorExecutor.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor", f = "InterceptorExecutor.kt", l = {263}, m = "modifyBeforeAttemptCompletion-3t6e044")
/* loaded from: classes.dex */
public final class InterceptorExecutor$modifyBeforeAttemptCompletion$1 extends ContinuationImpl {
    public InterceptorExecutor L$0;
    public InterceptorExecutor L$1;
    public Iterator L$2;
    public HttpAttemptInterceptorContext L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ InterceptorExecutor<Object, Object> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterceptorExecutor$modifyBeforeAttemptCompletion$1(InterceptorExecutor<Object, Object> interceptorExecutor, Continuation<? super InterceptorExecutor$modifyBeforeAttemptCompletion$1> continuation) {
        super(continuation);
        this.this$0 = interceptorExecutor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m617modifyBeforeAttemptCompletion3t6e044 = this.this$0.m617modifyBeforeAttemptCompletion3t6e044(null, null, null, this);
        if (m617modifyBeforeAttemptCompletion3t6e044 == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return m617modifyBeforeAttemptCompletion3t6e044;
        }
        return new Result(m617modifyBeforeAttemptCompletion3t6e044);
    }
}
