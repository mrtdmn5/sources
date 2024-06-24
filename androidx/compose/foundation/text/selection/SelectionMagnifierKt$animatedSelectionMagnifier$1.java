package androidx.compose.foundation.text.selection;

import androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* compiled from: SelectionMagnifier.kt */
/* loaded from: classes.dex */
public final class SelectionMagnifierKt$animatedSelectionMagnifier$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    public final /* synthetic */ Function0<Offset> $magnifierCenter;
    public final /* synthetic */ Function1<Function0<Offset>, Modifier> $platformMagnifier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionMagnifierKt$animatedSelectionMagnifier$1(Function1 function1, Function0 function0) {
        super(3);
        this.$magnifierCenter = function0;
        this.$platformMagnifier = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public final Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        Composer composer2 = composer;
        EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0.m(num, modifier, "$this$composed", composer2, 759876635);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer2.startReplaceableGroup(-1589795249);
        composer2.startReplaceableGroup(-492369756);
        Object rememberedValue = composer2.rememberedValue();
        Object obj = Composer.Companion.Empty;
        if (rememberedValue == obj) {
            rememberedValue = Platform.derivedStateOf(this.$magnifierCenter);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer2.endReplaceableGroup();
        State state = (State) rememberedValue;
        composer2.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer2.rememberedValue();
        if (rememberedValue2 == obj) {
            rememberedValue2 = new Animatable(new Offset(((Offset) state.getValue()).packedValue), SelectionMagnifierKt.UnspecifiedSafeOffsetVectorConverter, new Offset(SelectionMagnifierKt.OffsetDisplacementThreshold), 8);
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer2.endReplaceableGroup();
        Animatable animatable = (Animatable) rememberedValue2;
        EffectsKt.LaunchedEffect(Unit.INSTANCE, new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1(state, animatable, null), composer2);
        final AnimationState<T, V> animationState = animatable.internalState;
        composer2.endReplaceableGroup();
        composer2.startReplaceableGroup(1157296644);
        boolean changed = composer2.changed(animationState);
        Object rememberedValue3 = composer2.rememberedValue();
        if (changed || rememberedValue3 == obj) {
            rememberedValue3 = new Function0<Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionMagnifierKt$animatedSelectionMagnifier$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Offset invoke() {
                    return new Offset(animationState.getValue().packedValue);
                }
            };
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer2.endReplaceableGroup();
        Modifier modifier2 = (Modifier) this.$platformMagnifier.invoke(rememberedValue3);
        composer2.endReplaceableGroup();
        return modifier2;
    }
}
