package androidx.compose.material;

/* compiled from: AnchoredDraggable.kt */
/* loaded from: classes.dex */
public final class AnchoredDraggableState$anchoredDragScope$1 implements AnchoredDragScope {
    public final /* synthetic */ AnchoredDraggableState<T> this$0;

    public AnchoredDraggableState$anchoredDragScope$1(AnchoredDraggableState<T> anchoredDraggableState) {
        this.this$0 = anchoredDraggableState;
    }

    @Override // androidx.compose.material.AnchoredDragScope
    public final void dragTo(float f, float f2) {
        AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
        anchoredDraggableState.offset$delegate.setValue(Float.valueOf(f));
        anchoredDraggableState.lastVelocity$delegate.setFloatValue(f2);
    }
}
