package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import com.google.common.collect.Platform;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* compiled from: AnimateAsState.kt */
/* loaded from: classes.dex */
public final class AnimateAsStateKt {
    public static final SpringSpec<Float> defaultAnimation = AnimationSpecKt.spring$default(0.0f, null, 7);

    static {
        Map<TwoWayConverter<?, ?>, Float> map = VisibilityThresholdsKt.visibilityThresholdMap;
        AnimationSpecKt.spring$default(0.0f, new Dp(0.1f), 3);
        int r0 = Size.$r8$clinit;
        SizeKt.Size(0.5f, 0.5f);
        int r1 = Offset.$r8$clinit;
        OffsetKt.Offset(0.5f, 0.5f);
        int r02 = IntOffset.$r8$clinit;
        IntOffsetKt.IntOffset(1, 1);
    }

    /* renamed from: animateDpAsState-AjpBEmI, reason: not valid java name */
    public static final State m9animateDpAsStateAjpBEmI(float f, TweenSpec tweenSpec, Composer composer) {
        composer.startReplaceableGroup(-1407150062);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        State animateValueAsState = animateValueAsState(new Dp(f), VectorConvertersKt.DpToVector, tweenSpec, null, "DpAnimation", null, composer, 384, 8);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.compose.animation.core.AnimationSpec] */
    public static final State animateFloatAsState(float f, TweenSpec tweenSpec, String str, Function1 function1, Composer composer, int r16, int r17) {
        FiniteAnimationSpec finiteAnimationSpec;
        float f2;
        String str2;
        Function1 function12;
        FiniteAnimationSpec finiteAnimationSpec2;
        composer.startReplaceableGroup(668842840);
        int r0 = r17 & 2;
        FiniteAnimationSpec finiteAnimationSpec3 = defaultAnimation;
        if (r0 != 0) {
            finiteAnimationSpec = finiteAnimationSpec3;
        } else {
            finiteAnimationSpec = tweenSpec;
        }
        if ((r17 & 4) != 0) {
            f2 = 0.01f;
        } else {
            f2 = 0.0f;
        }
        if ((r17 & 8) != 0) {
            str2 = "FloatAnimation";
        } else {
            str2 = str;
        }
        if ((r17 & 16) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(841393662);
        if (finiteAnimationSpec == finiteAnimationSpec3) {
            Float valueOf = Float.valueOf(f2);
            composer.startReplaceableGroup(1157296644);
            boolean changed = composer.changed(valueOf);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.Empty) {
                rememberedValue = AnimationSpecKt.spring$default(0.0f, Float.valueOf(f2), 3);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            finiteAnimationSpec2 = (AnimationSpec) rememberedValue;
        } else {
            finiteAnimationSpec2 = finiteAnimationSpec;
        }
        composer.endReplaceableGroup();
        int r6 = r16 << 3;
        State animateValueAsState = animateValueAsState(Float.valueOf(f), VectorConvertersKt.FloatToVector, finiteAnimationSpec2, Float.valueOf(f2), str2, function12, composer, (r16 & 14) | (r6 & 7168) | (57344 & r6) | (r6 & 458752), 0);
        composer.endReplaceableGroup();
        return animateValueAsState;
    }

    public static final State animateValueAsState(final Object obj, TwoWayConverter typeConverter, AnimationSpec animationSpec, Float f, String str, Function1 function1, Composer composer, int r19, int r20) {
        AnimationSpec animationSpec2;
        Float f2;
        String str2;
        Function1 function12;
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        composer.startReplaceableGroup(-1994373980);
        int r3 = r20 & 4;
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (r3 != 0) {
            composer.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == composer$Companion$Empty$1) {
                rememberedValue = AnimationSpecKt.spring$default(0.0f, null, 7);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            animationSpec2 = (AnimationSpec) rememberedValue;
        } else {
            animationSpec2 = animationSpec;
        }
        if ((r20 & 8) != 0) {
            f2 = null;
        } else {
            f2 = f;
        }
        if ((r20 & 16) != 0) {
            str2 = "ValueAnimation";
        } else {
            str2 = str;
        }
        if ((r20 & 32) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == composer$Companion$Empty$1) {
            rememberedValue2 = Platform.mutableStateOf$default(null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue2;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == composer$Companion$Empty$1) {
            rememberedValue3 = new Animatable((Float) obj, (TwoWayConverter<Float, V>) typeConverter, f2, str2);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        Animatable animatable = (Animatable) rememberedValue3;
        MutableState rememberUpdatedState = Platform.rememberUpdatedState(function12, composer);
        if (f2 != null && (animationSpec2 instanceof SpringSpec)) {
            SpringSpec springSpec = (SpringSpec) animationSpec2;
            if (!Intrinsics.areEqual(springSpec.visibilityThreshold, f2)) {
                animationSpec2 = new SpringSpec(springSpec.dampingRatio, springSpec.stiffness, f2);
            }
        }
        MutableState rememberUpdatedState2 = Platform.rememberUpdatedState(animationSpec2, composer);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == composer$Companion$Empty$1) {
            rememberedValue4 = ChannelKt.Channel$default(-1, null, 6);
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceableGroup();
        final Channel channel = (Channel) rememberedValue4;
        EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                channel.mo1701trySendJP2dKIU(obj);
                return Unit.INSTANCE;
            }
        }, composer);
        EffectsKt.LaunchedEffect(channel, new AnimateAsStateKt$animateValueAsState$3(channel, animatable, rememberUpdatedState2, rememberUpdatedState, null), composer);
        State state = (State) mutableState.getValue();
        if (state == null) {
            state = animatable.internalState;
        }
        composer.endReplaceableGroup();
        return state;
    }
}
