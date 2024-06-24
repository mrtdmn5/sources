package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.google.common.base.Objects;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public final class EnterExitTransitionKt {
    public static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec;
    public static final SpringSpec<IntSize> DefaultSizeAnimationSpec;
    public static final TwoWayConverterImpl TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(new Function1<TransformOrigin, AnimationVector2D>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$1
        @Override // kotlin.jvm.functions.Function1
        public final AnimationVector2D invoke(TransformOrigin transformOrigin) {
            long j = transformOrigin.packedValue;
            return new AnimationVector2D(Float.intBitsToFloat((int) (j >> 32)), TransformOrigin.m345getPivotFractionYimpl(j));
        }
    }, new Function1<AnimationVector2D, TransformOrigin>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$2
        @Override // kotlin.jvm.functions.Function1
        public final TransformOrigin invoke(AnimationVector2D animationVector2D) {
            AnimationVector2D it = animationVector2D;
            Intrinsics.checkNotNullParameter(it, "it");
            return new TransformOrigin(TransformOriginKt.TransformOrigin(it.v1, it.v2));
        }
    });
    public static final ParcelableSnapshotMutableFloatState DefaultAlpha = Objects.mutableFloatStateOf(1.0f);
    public static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(400.0f, null, 5);

    /* compiled from: EnterExitTransition.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[EnterExitState.values().length];
            try {
                r0[EnterExitState.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[EnterExitState.PreEnter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[EnterExitState.PostExit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        int r0 = IntOffset.$r8$clinit;
        DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(400.0f, new IntOffset(IntOffsetKt.IntOffset(1, 1)), 1);
        DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(400.0f, new IntSize(IntSizeKt.IntSize(1, 1)), 1);
    }

    public static final EnterTransitionImpl expandIn(FiniteAnimationSpec animationSpec, Alignment expandFrom, Function1 initialSize, boolean z) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(expandFrom, "expandFrom");
        Intrinsics.checkNotNullParameter(initialSize, "initialSize");
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(animationSpec, expandFrom, initialSize, z), null, 11));
    }

    public static EnterTransitionImpl expandIn$default() {
        Map<TwoWayConverter<?, ?>, Float> map = VisibilityThresholdsKt.visibilityThresholdMap;
        return expandIn(AnimationSpecKt.spring$default(400.0f, new IntSize(IntSizeKt.IntSize(1, 1)), 1), Alignment.Companion.BottomEnd, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandIn$1
            @Override // kotlin.jvm.functions.Function1
            public final IntSize invoke(IntSize intSize) {
                long j = intSize.packedValue;
                return new IntSize(IntSizeKt.IntSize(0, 0));
            }
        }, true);
    }

    public static EnterTransitionImpl expandVertically$default() {
        BiasAlignment biasAlignment;
        Map<TwoWayConverter<?, ?>, Float> map = VisibilityThresholdsKt.visibilityThresholdMap;
        SpringSpec spring$default = AnimationSpecKt.spring$default(400.0f, new IntSize(IntSizeKt.IntSize(1, 1)), 1);
        BiasAlignment.Vertical vertical = Alignment.Companion.Bottom;
        final EnterExitTransitionKt$expandVertically$1 initialHeight = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$1
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(Integer num) {
                num.intValue();
                return 0;
            }
        };
        Intrinsics.checkNotNullParameter(initialHeight, "initialHeight");
        if (Intrinsics.areEqual(vertical, Alignment.Companion.Top)) {
            biasAlignment = Alignment.Companion.TopCenter;
        } else if (Intrinsics.areEqual(vertical, vertical)) {
            biasAlignment = Alignment.Companion.BottomCenter;
        } else {
            biasAlignment = Alignment.Companion.Center;
        }
        return expandIn(spring$default, biasAlignment, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final IntSize invoke(IntSize intSize) {
                long j = intSize.packedValue;
                return new IntSize(IntSizeKt.IntSize((int) (j >> 32), initialHeight.invoke(Integer.valueOf(IntSize.m593getHeightimpl(j))).intValue()));
            }
        }, true);
    }

    public static EnterTransitionImpl fadeIn$default(TweenSpec tweenSpec, int r8) {
        FiniteAnimationSpec animationSpec = tweenSpec;
        if ((r8 & 1) != 0) {
            animationSpec = AnimationSpecKt.spring$default(400.0f, null, 5);
        }
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(new Fade(0.0f, animationSpec), null, null, null, 14));
    }

    public static ExitTransitionImpl fadeOut$default(TweenSpec tweenSpec, int r8) {
        FiniteAnimationSpec animationSpec = tweenSpec;
        if ((r8 & 1) != 0) {
            animationSpec = AnimationSpecKt.spring$default(400.0f, null, 5);
        }
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(new Fade(0.0f, animationSpec), null, null, null, 14));
    }

    /* renamed from: scaleIn-L8ZKh-E$default, reason: not valid java name */
    public static EnterTransitionImpl m6scaleInL8ZKhE$default(TweenSpec tweenSpec) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(0.92f, TransformOrigin.Center, tweenSpec), 7));
    }

    public static final ExitTransitionImpl shrinkOut(FiniteAnimationSpec animationSpec, Alignment shrinkTowards, Function1 targetSize, boolean z) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shrinkTowards, "shrinkTowards");
        Intrinsics.checkNotNullParameter(targetSize, "targetSize");
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(animationSpec, shrinkTowards, targetSize, z), null, 11));
    }

    public static ExitTransitionImpl shrinkOut$default() {
        Map<TwoWayConverter<?, ?>, Float> map = VisibilityThresholdsKt.visibilityThresholdMap;
        return shrinkOut(AnimationSpecKt.spring$default(400.0f, new IntSize(IntSizeKt.IntSize(1, 1)), 1), Alignment.Companion.BottomEnd, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkOut$1
            @Override // kotlin.jvm.functions.Function1
            public final IntSize invoke(IntSize intSize) {
                long j = intSize.packedValue;
                return new IntSize(IntSizeKt.IntSize(0, 0));
            }
        }, true);
    }

    public static ExitTransitionImpl shrinkVertically$default() {
        BiasAlignment biasAlignment;
        Map<TwoWayConverter<?, ?>, Float> map = VisibilityThresholdsKt.visibilityThresholdMap;
        SpringSpec spring$default = AnimationSpecKt.spring$default(400.0f, new IntSize(IntSizeKt.IntSize(1, 1)), 1);
        BiasAlignment.Vertical vertical = Alignment.Companion.Bottom;
        final EnterExitTransitionKt$shrinkVertically$1 targetHeight = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$1
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(Integer num) {
                num.intValue();
                return 0;
            }
        };
        Intrinsics.checkNotNullParameter(targetHeight, "targetHeight");
        if (Intrinsics.areEqual(vertical, Alignment.Companion.Top)) {
            biasAlignment = Alignment.Companion.TopCenter;
        } else if (Intrinsics.areEqual(vertical, vertical)) {
            biasAlignment = Alignment.Companion.BottomCenter;
        } else {
            biasAlignment = Alignment.Companion.Center;
        }
        return shrinkOut(spring$default, biasAlignment, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final IntSize invoke(IntSize intSize) {
                long j = intSize.packedValue;
                return new IntSize(IntSizeKt.IntSize((int) (j >> 32), targetHeight.invoke(Integer.valueOf(IntSize.m593getHeightimpl(j))).intValue()));
            }
        }, true);
    }

    public static final EnterTransitionImpl slideInHorizontally(TweenSpec tweenSpec, final Function1 function1) {
        return new EnterTransitionImpl(new TransitionData(null, new Slide(tweenSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final IntOffset invoke(IntSize intSize) {
                return new IntOffset(IntOffsetKt.IntOffset(function1.invoke(Integer.valueOf((int) (intSize.packedValue >> 32))).intValue(), 0));
            }
        }), null, null, 13));
    }

    public static final ExitTransitionImpl slideOutHorizontally(TweenSpec tweenSpec, final Function1 function1) {
        return new ExitTransitionImpl(new TransitionData(null, new Slide(tweenSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final IntOffset invoke(IntSize intSize) {
                return new IntOffset(IntOffsetKt.IntOffset(function1.invoke(Integer.valueOf((int) (intSize.packedValue >> 32))).intValue(), 0));
            }
        }), null, null, 13));
    }
}
