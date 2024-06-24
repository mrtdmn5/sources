package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref$LongRef;

/* compiled from: DragGestureDetector.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", l = {876}, m = "awaitDragOrCancellation-rnUCldI")
/* loaded from: classes.dex */
public final class DragGestureDetectorKt$awaitDragOrCancellation$1 extends ContinuationImpl {
    public AwaitPointerEventScope L$0;
    public Ref$LongRef L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m35awaitDragOrCancellationrnUCldI(null, 0L, this);
    }
}
