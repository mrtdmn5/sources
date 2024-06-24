package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$LongRef;

/* compiled from: Draggable.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt", f = "Draggable.kt", l = {592}, m = "onDragOrUp-Axegvzg")
/* loaded from: classes.dex */
public final class DraggableKt$onDragOrUp$1 extends ContinuationImpl {
    public Function1 L$0;
    public Function1 L$1;
    public AwaitPointerEventScope L$2;
    public AwaitPointerEventScope L$3;
    public Ref$LongRef L$4;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DraggableKt.m43onDragOrUpAxegvzg(null, null, 0L, null, this);
    }
}
