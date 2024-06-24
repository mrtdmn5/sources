package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Transition.kt */
/* loaded from: classes.dex */
public final class EnterExitTransitionKt$createModifier$$inlined$animateValue$1 extends Lambda implements Function3<Transition.Segment<EnterExitState>, Composer, Integer, SpringSpec<TransformOrigin>> {
    public static final EnterExitTransitionKt$createModifier$$inlined$animateValue$1 INSTANCE = new EnterExitTransitionKt$createModifier$$inlined$animateValue$1();

    public EnterExitTransitionKt$createModifier$$inlined$animateValue$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public final SpringSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment, Composer composer, Integer num) {
        Composer composer2 = composer;
        num.intValue();
        Intrinsics.checkNotNullParameter(segment, "$this$null");
        composer2.startReplaceableGroup(-895531546);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        SpringSpec<TransformOrigin> spring$default = AnimationSpecKt.spring$default(0.0f, null, 7);
        composer2.endReplaceableGroup();
        return spring$default;
    }
}
