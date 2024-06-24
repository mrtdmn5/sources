package aws.smithy.kotlin.runtime.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CachedValue.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.util.CachedValue", f = "CachedValue.kt", l = {98, 80}, m = "getOrLoad")
/* loaded from: classes.dex */
public final class CachedValue$getOrLoad$1 extends ContinuationImpl {
    public CachedValue L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ CachedValue<Object> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachedValue$getOrLoad$1(CachedValue<Object> cachedValue, Continuation<? super CachedValue$getOrLoad$1> continuation) {
        super(continuation);
        this.this$0 = cachedValue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getOrLoad(null, this);
    }
}
