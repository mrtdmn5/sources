package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Canvas;

/* compiled from: CanvasDrawScope.kt */
/* loaded from: classes.dex */
public final class CanvasDrawScopeKt$asDrawTransform$1 {
    public final /* synthetic */ DrawContext $this_asDrawTransform;

    public CanvasDrawScopeKt$asDrawTransform$1(DrawContext drawContext) {
        this.$this_asDrawTransform = drawContext;
    }

    /* renamed from: clipPath-mtrdD-E, reason: not valid java name */
    public final void m372clipPathmtrdDE(AndroidPath androidPath, int r3) {
        this.$this_asDrawTransform.getCanvas().mo282clipPathmtrdDE(androidPath, r3);
    }

    /* renamed from: clipRect-N_I0leg, reason: not valid java name */
    public final void m373clipRectN_I0leg(float f, float f2, float f3, float f4, int r12) {
        this.$this_asDrawTransform.getCanvas().mo283clipRectN_I0leg(f, f2, f3, f4, r12);
    }

    public final void inset(float f, float f2, float f3, float f4) {
        boolean z;
        DrawContext drawContext = this.$this_asDrawTransform;
        Canvas canvas = drawContext.getCanvas();
        long Size = SizeKt.Size(Size.m276getWidthimpl(drawContext.mo370getSizeNHjbRc()) - (f3 + f), Size.m274getHeightimpl(drawContext.mo370getSizeNHjbRc()) - (f4 + f2));
        if (Size.m276getWidthimpl(Size) >= 0.0f && Size.m274getHeightimpl(Size) >= 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            drawContext.mo371setSizeuvyYCjk(Size);
            canvas.translate(f, f2);
            return;
        }
        throw new IllegalArgumentException("Width and height must be greater than or equal to zero".toString());
    }

    /* renamed from: rotate-Uv8p0NA, reason: not valid java name */
    public final void m374rotateUv8p0NA(long j) {
        Canvas canvas = this.$this_asDrawTransform.getCanvas();
        canvas.translate(Offset.m259getXimpl(j), Offset.m260getYimpl(j));
        canvas.rotate();
        canvas.translate(-Offset.m259getXimpl(j), -Offset.m260getYimpl(j));
    }

    /* renamed from: scale-0AR0LA0, reason: not valid java name */
    public final void m375scale0AR0LA0(long j) {
        Canvas canvas = this.$this_asDrawTransform.getCanvas();
        canvas.translate(Offset.m259getXimpl(j), Offset.m260getYimpl(j));
        canvas.scale();
        canvas.translate(-Offset.m259getXimpl(j), -Offset.m260getYimpl(j));
    }

    /* renamed from: transform-58bKbWc, reason: not valid java name */
    public final void m376transform58bKbWc(float[] fArr) {
        this.$this_asDrawTransform.getCanvas().mo284concat58bKbWc(fArr);
    }

    public final void translate(float f, float f2) {
        this.$this_asDrawTransform.getCanvas().translate(f, f2);
    }
}
