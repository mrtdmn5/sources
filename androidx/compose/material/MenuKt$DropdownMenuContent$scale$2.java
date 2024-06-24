package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Menu.kt */
/* loaded from: classes.dex */
public final class MenuKt$DropdownMenuContent$scale$2 extends Lambda implements Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>> {
    public static final MenuKt$DropdownMenuContent$scale$2 INSTANCE = new MenuKt$DropdownMenuContent$scale$2();

    public MenuKt$DropdownMenuContent$scale$2() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer, Integer num) {
        TweenSpec tween$default;
        Transition.Segment<Boolean> animateFloat = segment;
        Composer composer2 = composer;
        num.intValue();
        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
        composer2.startReplaceableGroup(-800950068);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (animateFloat.isTransitioningTo(Boolean.FALSE, Boolean.TRUE)) {
            tween$default = AnimationSpecKt.tween$default(120, 0, EasingKt.LinearOutSlowInEasing, 2);
        } else {
            tween$default = AnimationSpecKt.tween$default(1, 74, null, 4);
        }
        composer2.endReplaceableGroup();
        return tween$default;
    }
}
