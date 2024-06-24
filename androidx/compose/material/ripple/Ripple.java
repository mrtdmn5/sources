package androidx.compose.material.ripple;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import com.google.common.collect.Platform;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Ripple.kt */
/* loaded from: classes.dex */
public abstract class Ripple implements Indication {
    public final boolean bounded;
    public final State<Color> color;
    public final float radius;

    public Ripple() {
        throw null;
    }

    public Ripple(boolean z, float f, MutableState mutableState) {
        this.bounded = z;
        this.radius = f;
        this.color = mutableState;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ripple)) {
            return false;
        }
        Ripple ripple = (Ripple) obj;
        if (this.bounded == ripple.bounded && Dp.m579equalsimpl0(this.radius, ripple.radius) && Intrinsics.areEqual(this.color, ripple.color)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.color.hashCode() + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.radius, Boolean.hashCode(this.bounded) * 31, 31);
    }

    @Override // androidx.compose.foundation.Indication
    public final IndicationInstance rememberUpdatedInstance(InteractionSource interactionSource, Composer composer) {
        boolean z;
        long mo189defaultColorWaAFU9c;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(988743187);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        RippleTheme rippleTheme = (RippleTheme) composer.consume(RippleThemeKt.LocalRippleTheme);
        composer.startReplaceableGroup(-1524341038);
        State<Color> state = this.color;
        if (state.getValue().value != Color.Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            mo189defaultColorWaAFU9c = state.getValue().value;
        } else {
            mo189defaultColorWaAFU9c = rippleTheme.mo189defaultColorWaAFU9c(composer);
        }
        composer.endReplaceableGroup();
        RippleIndicationInstance mo220rememberUpdatedRippleInstance942rkJo = mo220rememberUpdatedRippleInstance942rkJo(interactionSource, this.bounded, this.radius, Platform.rememberUpdatedState(new Color(mo189defaultColorWaAFU9c), composer), Platform.rememberUpdatedState(rippleTheme.rippleAlpha(composer), composer), composer);
        EffectsKt.LaunchedEffect(mo220rememberUpdatedRippleInstance942rkJo, interactionSource, new Ripple$rememberUpdatedInstance$1(interactionSource, mo220rememberUpdatedRippleInstance942rkJo, null), composer);
        composer.endReplaceableGroup();
        return mo220rememberUpdatedRippleInstance942rkJo;
    }

    /* renamed from: rememberUpdatedRippleInstance-942rkJo */
    public abstract RippleIndicationInstance mo220rememberUpdatedRippleInstance942rkJo(InteractionSource interactionSource, boolean z, float f, MutableState mutableState, MutableState mutableState2, Composer composer);
}
