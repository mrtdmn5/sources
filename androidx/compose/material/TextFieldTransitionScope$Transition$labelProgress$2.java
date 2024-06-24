package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import com.animaconnected.secondo.R;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: TextFieldImpl.kt */
/* loaded from: classes.dex */
public final class TextFieldTransitionScope$Transition$labelProgress$2 extends Lambda implements Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>> {
    public static final TextFieldTransitionScope$Transition$labelProgress$2 INSTANCE = new TextFieldTransitionScope$Transition$labelProgress$2();

    public TextFieldTransitionScope$Transition$labelProgress$2() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
        Transition.Segment<InputPhase> animateFloat = segment;
        Composer composer2 = composer;
        num.intValue();
        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
        composer2.startReplaceableGroup(-611722692);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        TweenSpec tween$default = AnimationSpecKt.tween$default(R.styleable.AppTheme_stepsHistoryHintRoundnessDetail, 0, null, 6);
        composer2.endReplaceableGroup();
        return tween$default;
    }
}
