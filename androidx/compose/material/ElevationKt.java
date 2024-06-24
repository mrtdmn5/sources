package androidx.compose.material;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.ui.unit.Dp;
import com.animaconnected.secondo.R;

/* compiled from: Elevation.kt */
/* loaded from: classes.dex */
public final class ElevationKt {
    public static final TweenSpec<Dp> DefaultIncomingSpec = new TweenSpec<>(120, 0, EasingKt.FastOutSlowInEasing, 2);
    public static final TweenSpec<Dp> DefaultOutgoingSpec = new TweenSpec<>(R.styleable.AppTheme_stepsHistoryHintRoundnessDetail, 0, new CubicBezierEasing(0.4f, 0.6f), 2);
    public static final TweenSpec<Dp> HoveredOutgoingSpec = new TweenSpec<>(120, 0, new CubicBezierEasing(0.4f, 0.6f), 2);

    /* JADX WARN: Code restructure failed: missing block: B:34:0x002d, code lost:            if ((r8 instanceof androidx.compose.foundation.interaction.FocusInteraction$Focus) != false) goto L27;     */
    /* renamed from: animateElevation-rAjV9yQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m183animateElevationrAjV9yQ(androidx.compose.animation.core.Animatable<androidx.compose.ui.unit.Dp, ?> r6, float r7, androidx.compose.foundation.interaction.Interaction r8, androidx.compose.foundation.interaction.Interaction r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            if (r9 == 0) goto L18
            boolean r8 = r9 instanceof androidx.compose.foundation.interaction.PressInteraction$Press
            if (r8 == 0) goto L7
            goto L15
        L7:
            boolean r8 = r9 instanceof androidx.compose.foundation.interaction.DragInteraction$Start
            if (r8 == 0) goto Lc
            goto L15
        Lc:
            boolean r8 = r9 instanceof androidx.compose.foundation.interaction.HoverInteraction$Enter
            if (r8 == 0) goto L11
            goto L15
        L11:
            boolean r8 = r9 instanceof androidx.compose.foundation.interaction.FocusInteraction$Focus
            if (r8 == 0) goto L32
        L15:
            androidx.compose.animation.core.TweenSpec<androidx.compose.ui.unit.Dp> r8 = androidx.compose.material.ElevationKt.DefaultIncomingSpec
            goto L33
        L18:
            if (r8 == 0) goto L32
            boolean r9 = r8 instanceof androidx.compose.foundation.interaction.PressInteraction$Press
            if (r9 == 0) goto L1f
            goto L2f
        L1f:
            boolean r9 = r8 instanceof androidx.compose.foundation.interaction.DragInteraction$Start
            if (r9 == 0) goto L24
            goto L2f
        L24:
            boolean r9 = r8 instanceof androidx.compose.foundation.interaction.HoverInteraction$Enter
            if (r9 == 0) goto L2b
            androidx.compose.animation.core.TweenSpec<androidx.compose.ui.unit.Dp> r8 = androidx.compose.material.ElevationKt.HoveredOutgoingSpec
            goto L33
        L2b:
            boolean r8 = r8 instanceof androidx.compose.foundation.interaction.FocusInteraction$Focus
            if (r8 == 0) goto L32
        L2f:
            androidx.compose.animation.core.TweenSpec<androidx.compose.ui.unit.Dp> r8 = androidx.compose.material.ElevationKt.DefaultOutgoingSpec
            goto L33
        L32:
            r8 = 0
        L33:
            r2 = r8
            if (r2 == 0) goto L4c
            androidx.compose.ui.unit.Dp r1 = new androidx.compose.ui.unit.Dp
            r1.<init>(r7)
            r3 = 0
            r5 = 12
            r0 = r6
            r4 = r10
            java.lang.Object r6 = androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, r3, r4, r5)
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r6 != r7) goto L49
            return r6
        L49:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L4c:
            androidx.compose.ui.unit.Dp r8 = new androidx.compose.ui.unit.Dp
            r8.<init>(r7)
            java.lang.Object r6 = r6.snapTo(r8, r10)
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r6 != r7) goto L5a
            return r6
        L5a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ElevationKt.m183animateElevationrAjV9yQ(androidx.compose.animation.core.Animatable, float, androidx.compose.foundation.interaction.Interaction, androidx.compose.foundation.interaction.Interaction, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
