package aws.smithy.kotlin.runtime.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: LazyAsyncValue.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl", f = "LazyAsyncValue.kt", l = {57, 44}, m = "get")
/* loaded from: classes.dex */
public final class LazyAsyncValueImpl$get$1 extends ContinuationImpl {
    public LazyAsyncValueImpl L$0;
    public Mutex L$1;
    public LazyAsyncValueImpl L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ LazyAsyncValueImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyAsyncValueImpl$get$1(LazyAsyncValueImpl<? extends T> lazyAsyncValueImpl, Continuation<? super LazyAsyncValueImpl$get$1> continuation) {
        super(continuation);
        this.this$0 = lazyAsyncValueImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.get(this);
    }
}
