package androidx.compose.animation;

import android.view.ViewConfiguration;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;

/* compiled from: SplineBasedFloatDecayAnimationSpec.android.kt */
/* loaded from: classes.dex */
public final class SplineBasedFloatDecayAnimationSpec_androidKt {
    public static final float platformFlingScrollFriction = ViewConfiguration.getScrollFriction();

    public static final DecayAnimationSpec rememberSplineBasedDecay(Composer composer) {
        composer.startReplaceableGroup(904445851);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Density density = (Density) composer.consume(CompositionLocalsKt.LocalDensity);
        Float valueOf = Float.valueOf(density.getDensity());
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(valueOf);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.Empty) {
            rememberedValue = new DecayAnimationSpecImpl(new SplineBasedFloatDecayAnimationSpec(density));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DecayAnimationSpec decayAnimationSpec = (DecayAnimationSpec) rememberedValue;
        composer.endReplaceableGroup();
        return decayAnimationSpec;
    }
}
