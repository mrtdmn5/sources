package androidx.compose.foundation.gestures;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Draggable.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode", f = "Draggable.kt", l = {451, 454}, m = "processDragCancel")
/* loaded from: classes.dex */
public final class DraggableNode$processDragCancel$1 extends ContinuationImpl {
    public DraggableNode L$0;
    public CoroutineScope L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DraggableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableNode$processDragCancel$1(DraggableNode draggableNode, Continuation<? super DraggableNode$processDragCancel$1> continuation) {
        super(continuation);
        this.this$0 = draggableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DraggableNode.access$processDragCancel(this.this$0, this, null);
    }
}
