package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.snapshots.StateMapMutableEntriesIterator;
import androidx.compose.runtime.snapshots.StateMapMutableIterator;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.YieldKt;

/* compiled from: CommonRipple.kt */
/* loaded from: classes.dex */
public final class CommonRippleIndicationInstance extends RippleIndicationInstance implements RememberObserver {
    public final boolean bounded;
    public final State<Color> color;
    public final float radius;
    public final State<RippleAlpha> rippleAlpha;
    public final SnapshotStateMap<PressInteraction$Press, RippleAnimation> ripples;

    public CommonRippleIndicationInstance() {
        throw null;
    }

    public CommonRippleIndicationInstance(boolean z, float f, MutableState mutableState, MutableState mutableState2) {
        super(mutableState2, z);
        this.bounded = z;
        this.radius = f;
        this.color = mutableState;
        this.rippleAlpha = mutableState2;
        this.ripples = new SnapshotStateMap<>();
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public final void addRipple(PressInteraction$Press interaction, CoroutineScope scope) {
        Offset offset;
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(scope, "scope");
        SnapshotStateMap<PressInteraction$Press, RippleAnimation> snapshotStateMap = this.ripples;
        Iterator it = snapshotStateMap.entries.iterator();
        while (it.hasNext()) {
            RippleAnimation rippleAnimation = (RippleAnimation) ((Map.Entry) it.next()).getValue();
            rippleAnimation.finishRequested$delegate.setValue(Boolean.TRUE);
            rippleAnimation.finishSignalDeferred.makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
        }
        boolean z = this.bounded;
        if (z) {
            offset = new Offset(interaction.pressPosition);
        } else {
            offset = null;
        }
        RippleAnimation rippleAnimation2 = new RippleAnimation(offset, this.radius, z);
        snapshotStateMap.put(interaction, rippleAnimation2);
        BuildersKt.launch$default(scope, null, null, new CommonRippleIndicationInstance$addRipple$2(rippleAnimation2, this, interaction, null), 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.IndicationInstance
    public final void drawIndication(ContentDrawScope contentDrawScope) {
        boolean z;
        long Color;
        float floatValue;
        long Color2;
        long j;
        Float valueOf;
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        Intrinsics.checkNotNullParameter(contentDrawScope2, "<this>");
        long j2 = this.color.getValue().value;
        contentDrawScope.drawContent();
        m225drawStateLayerH2RKhps(contentDrawScope2, this.radius, j2);
        Object it = this.ripples.entries.iterator();
        while (((StateMapMutableIterator) it).hasNext()) {
            RippleAnimation rippleAnimation = (RippleAnimation) ((Map.Entry) ((StateMapMutableEntriesIterator) it).next()).getValue();
            float f = this.rippleAlpha.getValue().pressedAlpha;
            if (f == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                Color = ColorKt.Color(Color.m322getRedimpl(j2), Color.m321getGreenimpl(j2), Color.m319getBlueimpl(j2), f, Color.m320getColorSpaceimpl(j2));
                rippleAnimation.getClass();
                if (rippleAnimation.startRadius == null) {
                    long mo391getSizeNHjbRc = contentDrawScope.mo391getSizeNHjbRc();
                    float f2 = RippleAnimationKt.BoundedRippleExtraRadius;
                    rippleAnimation.startRadius = Float.valueOf(Math.max(Size.m276getWidthimpl(mo391getSizeNHjbRc), Size.m274getHeightimpl(mo391getSizeNHjbRc)) * 0.3f);
                }
                Float f3 = rippleAnimation.targetRadius;
                boolean z2 = rippleAnimation.bounded;
                if (f3 == null) {
                    float f4 = rippleAnimation.radius;
                    if (Float.isNaN(f4)) {
                        valueOf = Float.valueOf(RippleAnimationKt.m221getRippleEndRadiuscSwnlzA(contentDrawScope2, z2, contentDrawScope.mo391getSizeNHjbRc()));
                    } else {
                        valueOf = Float.valueOf(contentDrawScope2.mo49toPx0680j_4(f4));
                    }
                    rippleAnimation.targetRadius = valueOf;
                }
                if (rippleAnimation.origin == null) {
                    rippleAnimation.origin = new Offset(contentDrawScope.mo390getCenterF1C5BW0());
                }
                if (rippleAnimation.targetCenter == null) {
                    rippleAnimation.targetCenter = new Offset(OffsetKt.Offset(Size.m276getWidthimpl(contentDrawScope.mo391getSizeNHjbRc()) / 2.0f, Size.m274getHeightimpl(contentDrawScope.mo391getSizeNHjbRc()) / 2.0f));
                }
                if (((Boolean) rippleAnimation.finishRequested$delegate.getValue()).booleanValue() && !((Boolean) rippleAnimation.finishedFadingIn$delegate.getValue()).booleanValue()) {
                    floatValue = 1.0f;
                } else {
                    floatValue = rippleAnimation.animatedAlpha.getValue().floatValue();
                }
                Float f5 = rippleAnimation.startRadius;
                Intrinsics.checkNotNull(f5);
                float floatValue2 = f5.floatValue();
                Float f6 = rippleAnimation.targetRadius;
                Intrinsics.checkNotNull(f6);
                float lerp = YieldKt.lerp(floatValue2, f6.floatValue(), rippleAnimation.animatedRadiusPercent.getValue().floatValue());
                Offset offset = rippleAnimation.origin;
                Intrinsics.checkNotNull(offset);
                float m259getXimpl = Offset.m259getXimpl(offset.packedValue);
                Offset offset2 = rippleAnimation.targetCenter;
                Intrinsics.checkNotNull(offset2);
                float m259getXimpl2 = Offset.m259getXimpl(offset2.packedValue);
                Animatable<Float, AnimationVector1D> animatable = rippleAnimation.animatedCenterPercent;
                float lerp2 = YieldKt.lerp(m259getXimpl, m259getXimpl2, animatable.getValue().floatValue());
                Offset offset3 = rippleAnimation.origin;
                Intrinsics.checkNotNull(offset3);
                float m260getYimpl = Offset.m260getYimpl(offset3.packedValue);
                Offset offset4 = rippleAnimation.targetCenter;
                Intrinsics.checkNotNull(offset4);
                long Offset = OffsetKt.Offset(lerp2, YieldKt.lerp(m260getYimpl, Offset.m260getYimpl(offset4.packedValue), animatable.getValue().floatValue()));
                Color2 = ColorKt.Color(Color.m322getRedimpl(Color), Color.m321getGreenimpl(Color), Color.m319getBlueimpl(Color), Color.m318getAlphaimpl(Color) * floatValue, Color.m320getColorSpaceimpl(Color));
                if (z2) {
                    float m276getWidthimpl = Size.m276getWidthimpl(contentDrawScope.mo391getSizeNHjbRc());
                    float m274getHeightimpl = Size.m274getHeightimpl(contentDrawScope.mo391getSizeNHjbRc());
                    CanvasDrawScope$drawContext$1 drawContext = contentDrawScope.getDrawContext();
                    long mo370getSizeNHjbRc = drawContext.mo370getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    j = j2;
                    drawContext.transform.m373clipRectN_I0leg(0.0f, 0.0f, m276getWidthimpl, m274getHeightimpl, 1);
                    DrawScope.m378drawCircleVaOC9Bg$default(contentDrawScope, Color2, lerp, Offset, null, 120);
                    drawContext.getCanvas().restore();
                    drawContext.mo371setSizeuvyYCjk(mo370getSizeNHjbRc);
                } else {
                    j = j2;
                    DrawScope.m378drawCircleVaOC9Bg$default(contentDrawScope, Color2, lerp, Offset, null, 120);
                }
                contentDrawScope2 = contentDrawScope;
                j2 = j;
            } else {
                contentDrawScope2 = contentDrawScope;
            }
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        this.ripples.clear();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        this.ripples.clear();
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public final void removeRipple(PressInteraction$Press interaction) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        RippleAnimation rippleAnimation = this.ripples.get(interaction);
        if (rippleAnimation != null) {
            rippleAnimation.finishRequested$delegate.setValue(Boolean.TRUE);
            rippleAnimation.finishSignalDeferred.makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
    }
}
