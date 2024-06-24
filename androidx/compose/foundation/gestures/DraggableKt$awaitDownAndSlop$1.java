package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import java.io.Serializable;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Draggable.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt", f = "Draggable.kt", l = {472, 481, 600, 650}, m = "awaitDownAndSlop")
/* loaded from: classes.dex */
public final class DraggableKt$awaitDownAndSlop$1 extends ContinuationImpl {
    public float F$0;
    public float F$1;
    public float F$2;
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Serializable L$4;
    public PointerInputChange L$5;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DraggableKt.access$awaitDownAndSlop(null, null, null, null, null, this);
    }
}
