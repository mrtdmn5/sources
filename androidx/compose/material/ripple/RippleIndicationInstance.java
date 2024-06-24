package androidx.compose.material.ripple;

import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Ripple.kt */
/* loaded from: classes.dex */
public abstract class RippleIndicationInstance implements IndicationInstance {
    public final StateLayer stateLayer;

    public RippleIndicationInstance(MutableState mutableState, boolean z) {
        this.stateLayer = new StateLayer(mutableState, z);
    }

    public abstract void addRipple(PressInteraction$Press pressInteraction$Press, CoroutineScope coroutineScope);

    /* renamed from: drawStateLayer-H2RKhps, reason: not valid java name */
    public final void m225drawStateLayerH2RKhps(DrawScope drawStateLayer, float f, long j) {
        float mo49toPx0680j_4;
        long Color;
        Intrinsics.checkNotNullParameter(drawStateLayer, "$this$drawStateLayer");
        StateLayer stateLayer = this.stateLayer;
        stateLayer.getClass();
        boolean isNaN = Float.isNaN(f);
        boolean z = stateLayer.bounded;
        if (isNaN) {
            mo49toPx0680j_4 = RippleAnimationKt.m221getRippleEndRadiuscSwnlzA(drawStateLayer, z, drawStateLayer.mo391getSizeNHjbRc());
        } else {
            mo49toPx0680j_4 = drawStateLayer.mo49toPx0680j_4(f);
        }
        float f2 = mo49toPx0680j_4;
        float floatValue = stateLayer.animatedAlpha.getValue().floatValue();
        if (floatValue > 0.0f) {
            Color = ColorKt.Color(Color.m322getRedimpl(j), Color.m321getGreenimpl(j), Color.m319getBlueimpl(j), floatValue, Color.m320getColorSpaceimpl(j));
            if (z) {
                float m276getWidthimpl = Size.m276getWidthimpl(drawStateLayer.mo391getSizeNHjbRc());
                float m274getHeightimpl = Size.m274getHeightimpl(drawStateLayer.mo391getSizeNHjbRc());
                CanvasDrawScope$drawContext$1 drawContext = drawStateLayer.getDrawContext();
                long mo370getSizeNHjbRc = drawContext.mo370getSizeNHjbRc();
                drawContext.getCanvas().save();
                drawContext.transform.m373clipRectN_I0leg(0.0f, 0.0f, m276getWidthimpl, m274getHeightimpl, 1);
                DrawScope.m378drawCircleVaOC9Bg$default(drawStateLayer, Color, f2, 0L, null, 124);
                drawContext.getCanvas().restore();
                drawContext.mo371setSizeuvyYCjk(mo370getSizeNHjbRc);
                return;
            }
            DrawScope.m378drawCircleVaOC9Bg$default(drawStateLayer, Color, f2, 0L, null, 124);
        }
    }

    public abstract void removeRipple(PressInteraction$Press pressInteraction$Press);
}
