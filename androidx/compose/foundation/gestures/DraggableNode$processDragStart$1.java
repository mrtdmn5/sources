package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Draggable.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode", f = "Draggable.kt", l = {433, 436, 438}, m = "processDragStart")
/* loaded from: classes.dex */
public final class DraggableNode$processDragStart$1 extends ContinuationImpl {
    public DraggableNode L$0;
    public CoroutineScope L$1;
    public DragEvent.DragStarted L$2;
    public DragInteraction$Start L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DraggableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableNode$processDragStart$1(DraggableNode draggableNode, Continuation<? super DraggableNode$processDragStart$1> continuation) {
        super(continuation);
        this.this$0 = draggableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DraggableNode.access$processDragStart(this.this$0, null, null, this);
    }
}
