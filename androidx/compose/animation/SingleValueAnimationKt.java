package androidx.compose.animation;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;

/* compiled from: SingleValueAnimation.kt */
/* loaded from: classes.dex */
public final class SingleValueAnimationKt {
    public static final SpringSpec<Color> colorDefaultSpring = AnimationSpecKt.spring$default(0.0f, null, 7);

    /* renamed from: animateColorAsState-euL9pac, reason: not valid java name */
    public static final State m7animateColorAsStateeuL9pac(long j, TweenSpec tweenSpec, Composer composer, int r13, int r14) {
        String str;
        composer.startReplaceableGroup(-451899108);
        FiniteAnimationSpec finiteAnimationSpec = tweenSpec;
        if ((r14 & 2) != 0) {
            finiteAnimationSpec = colorDefaultSpring;
        }
        FiniteAnimationSpec finiteAnimationSpec2 = finiteAnimationSpec;
        if ((r14 & 4) != 0) {
            str = "ColorAnimation";
        } else {
            str = null;
        }
        String str2 = str;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ColorSpace m320getColorSpaceimpl = Color.m320getColorSpaceimpl(j);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(m320getColorSpaceimpl);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.Empty) {
            rememberedValue = (TwoWayConverter) ColorVectorConverterKt.ColorToVector.invoke(Color.m320getColorSpaceimpl(j));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        int r10 = r13 << 6;
        State animateValueAsState = AnimateAsStateKt.animateValueAsState(new Color(j), (TwoWayConverter) rememberedValue, finiteAnimationSpec2, null, str2, null, composer, (r10 & 458752) | (r13 & 14) | 576 | (57344 & r10), 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }
}
