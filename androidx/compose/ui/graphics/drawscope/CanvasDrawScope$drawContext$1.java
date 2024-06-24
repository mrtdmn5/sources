package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.Canvas;

/* compiled from: CanvasDrawScope.kt */
/* loaded from: classes.dex */
public final class CanvasDrawScope$drawContext$1 implements DrawContext {
    public final /* synthetic */ CanvasDrawScope this$0;
    public final CanvasDrawScopeKt$asDrawTransform$1 transform = new CanvasDrawScopeKt$asDrawTransform$1(this);

    public CanvasDrawScope$drawContext$1(CanvasDrawScope canvasDrawScope) {
        this.this$0 = canvasDrawScope;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawContext
    public final Canvas getCanvas() {
        return this.this$0.drawParams.canvas;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawContext
    /* renamed from: getSize-NH-jbRc */
    public final long mo370getSizeNHjbRc() {
        return this.this$0.drawParams.size;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawContext
    /* renamed from: setSize-uvyYCjk */
    public final void mo371setSizeuvyYCjk(long j) {
        this.this$0.drawParams.size = j;
    }
}
