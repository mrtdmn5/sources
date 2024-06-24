package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Select.kt */
@DebugMetadata(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", l = {431, 434}, m = "doSelectSuspend")
/* loaded from: classes4.dex */
public final class SelectImplementation$doSelectSuspend$1 extends ContinuationImpl {
    public SelectImplementation L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ SelectImplementation<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectImplementation$doSelectSuspend$1(SelectImplementation<R> selectImplementation, Continuation<? super SelectImplementation$doSelectSuspend$1> continuation) {
        super(continuation);
        this.this$0 = selectImplementation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = SelectImplementation.state$FU;
        return this.this$0.doSelectSuspend(this);
    }
}
