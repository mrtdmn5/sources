package androidx.compose.foundation;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Hoverable.kt */
@DebugMetadata(c = "androidx.compose.foundation.HoverableNode", f = "Hoverable.kt", l = {116}, m = "emitExit")
/* loaded from: classes.dex */
public final class HoverableNode$emitExit$1 extends ContinuationImpl {
    public HoverableNode L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HoverableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HoverableNode$emitExit$1(HoverableNode hoverableNode, Continuation<? super HoverableNode$emitExit$1> continuation) {
        super(continuation);
        this.this$0 = hoverableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emitExit(this);
    }
}
