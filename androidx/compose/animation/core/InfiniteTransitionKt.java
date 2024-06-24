package androidx.compose.animation.core;

import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InfiniteTransition.kt */
/* loaded from: classes.dex */
public final class InfiniteTransitionKt {
    public static final InfiniteTransition.TransitionAnimationState animateFloat(InfiniteTransition infiniteTransition, float f, InfiniteRepeatableSpec infiniteRepeatableSpec, String str, Composer composer, int r13, int r14) {
        composer.startReplaceableGroup(-644770905);
        if ((r14 & 8) != 0) {
            str = "FloatAnimation";
        }
        String str2 = str;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        InfiniteTransition.TransitionAnimationState animateValue = animateValue(infiniteTransition, Float.valueOf(0.0f), Float.valueOf(f), VectorConvertersKt.FloatToVector, infiniteRepeatableSpec, str2, composer, 0);
        composer.endReplaceableGroup();
        return animateValue;
    }

    public static final InfiniteTransition.TransitionAnimationState animateValue(final InfiniteTransition infiniteTransition, final Number number, final Number number2, TwoWayConverterImpl typeConverter, final InfiniteRepeatableSpec infiniteRepeatableSpec, String str, Composer composer, int r14) {
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        composer.startReplaceableGroup(-1062847727);
        if ((r14 & 16) != 0) {
            str = "ValueAnimation";
        }
        String str2 = str;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.Empty) {
            rememberedValue = new InfiniteTransition.TransitionAnimationState(infiniteTransition, number, number2, typeConverter, infiniteRepeatableSpec, str2);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final InfiniteTransition.TransitionAnimationState transitionAnimationState = (InfiniteTransition.TransitionAnimationState) rememberedValue;
        EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r3v0, types: [T, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                InfiniteTransition.TransitionAnimationState<Object, Object> transitionAnimationState2 = transitionAnimationState;
                Object obj = transitionAnimationState2.initialValue;
                ?? r2 = number;
                boolean areEqual = Intrinsics.areEqual((Object) r2, obj);
                ?? r3 = number2;
                if (!areEqual || !Intrinsics.areEqual((Object) r3, transitionAnimationState2.targetValue)) {
                    InfiniteRepeatableSpec<Object> animationSpec = infiniteRepeatableSpec;
                    Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
                    transitionAnimationState2.initialValue = r2;
                    transitionAnimationState2.targetValue = r3;
                    transitionAnimationState2.animationSpec = animationSpec;
                    transitionAnimationState2.animation = new TargetBasedAnimation<>(animationSpec, transitionAnimationState2.typeConverter, r2, r3);
                    transitionAnimationState2.this$0.refreshChildNeeded$delegate.setValue(Boolean.TRUE);
                    transitionAnimationState2.isFinished = false;
                    transitionAnimationState2.startOnTheNextFrame = true;
                }
                return Unit.INSTANCE;
            }
        }, composer);
        EffectsKt.DisposableEffect(transitionAnimationState, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                DisposableEffectScope DisposableEffect = disposableEffectScope;
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final InfiniteTransition infiniteTransition2 = InfiniteTransition.this;
                infiniteTransition2.getClass();
                final InfiniteTransition.TransitionAnimationState<Object, Object> animation = transitionAnimationState;
                Intrinsics.checkNotNullParameter(animation, "animation");
                infiniteTransition2._animations.add(animation);
                infiniteTransition2.refreshChildNeeded$delegate.setValue(Boolean.TRUE);
                return new DisposableEffectResult() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public final void dispose() {
                        InfiniteTransition infiniteTransition3 = InfiniteTransition.this;
                        infiniteTransition3.getClass();
                        InfiniteTransition.TransitionAnimationState<?, ?> animation2 = animation;
                        Intrinsics.checkNotNullParameter(animation2, "animation");
                        infiniteTransition3._animations.remove(animation2);
                    }
                };
            }
        }, composer);
        composer.endReplaceableGroup();
        return transitionAnimationState;
    }

    public static final InfiniteTransition rememberInfiniteTransition(String str, Composer composer, int r3) {
        composer.startReplaceableGroup(1013651573);
        if ((r3 & 1) != 0) {
            str = "InfiniteTransition";
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.Empty) {
            rememberedValue = new InfiniteTransition(str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        InfiniteTransition infiniteTransition = (InfiniteTransition) rememberedValue;
        infiniteTransition.run$animation_core_release(composer, 8);
        composer.endReplaceableGroup();
        return infiniteTransition;
    }
}
