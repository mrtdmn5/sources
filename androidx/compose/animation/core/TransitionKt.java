package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import com.google.android.gms.common.zzw;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Transition.kt */
/* loaded from: classes.dex */
public final class TransitionKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Transition.DeferredAnimation createDeferredAnimation(final Transition transition, TwoWayConverterImpl typeConverter, String str, Composer composer, int r6) {
        Transition.DeferredAnimation.DeferredAnimationData deferredAnimationData;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        composer.startReplaceableGroup(-1714122528);
        if ((r6 & 2) != 0) {
            str = "DeferredAnimation";
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(transition);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.Empty) {
            rememberedValue = new Transition.DeferredAnimation(transition, typeConverter, str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final Transition.DeferredAnimation deferredAnimation = (Transition.DeferredAnimation) rememberedValue;
        EffectsKt.DisposableEffect(deferredAnimation, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                DisposableEffectScope DisposableEffect = disposableEffectScope;
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final Transition<Object> transition2 = transition;
                final Transition<Object>.DeferredAnimation<Object, Object> deferredAnimation2 = deferredAnimation;
                return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$invoke$$inlined$onDispose$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public final void dispose() {
                        State state;
                        Transition transition3 = Transition.this;
                        transition3.getClass();
                        Transition.DeferredAnimation deferredAnimation3 = deferredAnimation2;
                        Intrinsics.checkNotNullParameter(deferredAnimation3, "deferredAnimation");
                        Transition.DeferredAnimation.DeferredAnimationData deferredAnimationData2 = (Transition.DeferredAnimation.DeferredAnimationData) deferredAnimation3.data$delegate.getValue();
                        if (deferredAnimationData2 != null && (state = deferredAnimationData2.animation) != null) {
                            transition3._animations.remove(state);
                        }
                    }
                };
            }
        }, composer);
        if (transition.isSeeking() && (deferredAnimationData = (Transition.DeferredAnimation.DeferredAnimationData) deferredAnimation.data$delegate.getValue()) != null) {
            Function1<? super S, ? extends T> function1 = deferredAnimationData.targetValueByState;
            Transition<S> transition2 = deferredAnimation.this$0;
            deferredAnimationData.animation.updateInitialAndTargetValue$animation_core_release(function1.invoke(transition2.getSegment().getInitialState()), deferredAnimationData.targetValueByState.invoke(transition2.getSegment().getTargetState()), (FiniteAnimationSpec) deferredAnimationData.transitionSpec.invoke(transition2.getSegment()));
        }
        composer.endReplaceableGroup();
        return deferredAnimation;
    }

    public static final Transition.TransitionAnimationState createTransitionAnimation(final Transition transition, Object obj, Object obj2, FiniteAnimationSpec animationSpec, TwoWayConverter typeConverter, String label, Composer composer) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(label, "label");
        composer.startReplaceableGroup(-304821198);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(transition);
        Object rememberedValue = composer.rememberedValue();
        Object obj3 = Composer.Companion.Empty;
        if (changed || rememberedValue == obj3) {
            rememberedValue = new Transition.TransitionAnimationState(transition, obj, zzw.createZeroVectorFrom(typeConverter, obj2), typeConverter, label);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final Transition.TransitionAnimationState transitionAnimationState = (Transition.TransitionAnimationState) rememberedValue;
        if (transition.isSeeking()) {
            transitionAnimationState.updateInitialAndTargetValue$animation_core_release(obj, obj2, animationSpec);
        } else {
            transitionAnimationState.updateTargetValue$animation_core_release(obj2, animationSpec);
        }
        composer.startReplaceableGroup(511388516);
        boolean changed2 = composer.changed(transition) | composer.changed(transitionAnimationState);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == obj3) {
            rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    DisposableEffectScope DisposableEffect = disposableEffectScope;
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final Transition<Object> transition2 = transition;
                    transition2.getClass();
                    final Transition<Object>.TransitionAnimationState<?, ?> animation = transitionAnimationState;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    transition2._animations.add(animation);
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public final void dispose() {
                            Transition transition3 = Transition.this;
                            transition3.getClass();
                            Transition.TransitionAnimationState animation2 = animation;
                            Intrinsics.checkNotNullParameter(animation2, "animation");
                            transition3._animations.remove(animation2);
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(transitionAnimationState, (Function1) rememberedValue2, composer);
        composer.endReplaceableGroup();
        return transitionAnimationState;
    }

    public static final <T> Transition<T> updateTransition(T t, String str, Composer composer, int r5, int r6) {
        composer.startReplaceableGroup(2029166765);
        if ((r6 & 2) != 0) {
            str = null;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Object obj = Composer.Companion.Empty;
        if (rememberedValue == obj) {
            rememberedValue = new Transition(new MutableTransitionState(t), str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final Transition<T> transition = (Transition) rememberedValue;
        transition.animateTo$animation_core_release(t, composer, (r5 & 8) | 48 | (r5 & 14));
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(transition);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == obj) {
            rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    DisposableEffectScope DisposableEffect = disposableEffectScope;
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final Transition<T> transition2 = transition;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public final void dispose() {
                            Transition.this.onTransitionEnd$animation_core_release();
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(transition, (Function1) rememberedValue2, composer);
        composer.endReplaceableGroup();
        return transition;
    }
}
