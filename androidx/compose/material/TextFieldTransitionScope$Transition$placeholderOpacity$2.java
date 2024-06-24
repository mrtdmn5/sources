package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: TextFieldImpl.kt */
/* loaded from: classes.dex */
public final class TextFieldTransitionScope$Transition$placeholderOpacity$2 extends Lambda implements Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>> {
    public static final TextFieldTransitionScope$Transition$placeholderOpacity$2 INSTANCE = new TextFieldTransitionScope$Transition$placeholderOpacity$2();

    public TextFieldTransitionScope$Transition$placeholderOpacity$2() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
        FiniteAnimationSpec<Float> tween;
        Transition.Segment<InputPhase> animateFloat = segment;
        Composer composer2 = composer;
        num.intValue();
        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
        composer2.startReplaceableGroup(-1079955085);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        InputPhase inputPhase = InputPhase.Focused;
        InputPhase inputPhase2 = InputPhase.UnfocusedEmpty;
        if (animateFloat.isTransitioningTo(inputPhase, inputPhase2)) {
            tween = AnimationSpecKt.tween$default(67, 0, EasingKt.LinearEasing, 2);
        } else if (!animateFloat.isTransitioningTo(inputPhase2, inputPhase) && !animateFloat.isTransitioningTo(InputPhase.UnfocusedNotEmpty, inputPhase2)) {
            tween = AnimationSpecKt.spring$default(0.0f, null, 7);
        } else {
            tween = AnimationSpecKt.tween(83, 67, EasingKt.LinearEasing);
        }
        composer2.endReplaceableGroup();
        return tween;
    }
}
