package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.state.ToggleableState;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Checkbox.kt */
/* loaded from: classes.dex */
public final class CheckboxKt$CheckboxImpl$checkDrawFraction$2 extends Lambda implements Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>> {
    public static final CheckboxKt$CheckboxImpl$checkDrawFraction$2 INSTANCE = new CheckboxKt$CheckboxImpl$checkDrawFraction$2();

    public CheckboxKt$CheckboxImpl$checkDrawFraction$2() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer, Integer num) {
        FiniteAnimationSpec<Float> spring$default;
        Transition.Segment<ToggleableState> animateFloat = segment;
        Composer composer2 = composer;
        num.intValue();
        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
        composer2.startReplaceableGroup(-1707702900);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ToggleableState initialState = animateFloat.getInitialState();
        ToggleableState toggleableState = ToggleableState.Off;
        if (initialState == toggleableState) {
            spring$default = AnimationSpecKt.tween$default(100, 0, null, 6);
        } else if (animateFloat.getTargetState() == toggleableState) {
            spring$default = new SnapSpec<>(100);
        } else {
            spring$default = AnimationSpecKt.spring$default(0.0f, null, 7);
        }
        composer2.endReplaceableGroup();
        return spring$default;
    }
}
