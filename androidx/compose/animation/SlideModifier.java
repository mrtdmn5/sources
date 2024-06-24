package androidx.compose.animation;

import androidx.compose.animation.SlideModifier;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public final class SlideModifier extends LayoutModifierWithPassThroughIntrinsics {
    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> lazyAnimation;
    public final State<Slide> slideIn;
    public final State<Slide> slideOut;
    public final SlideModifier$transitionSpec$1 transitionSpec;

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

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.animation.SlideModifier$transitionSpec$1] */
    public SlideModifier(Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> lazyAnimation, State<Slide> slideIn, State<Slide> slideOut) {
        Intrinsics.checkNotNullParameter(lazyAnimation, "lazyAnimation");
        Intrinsics.checkNotNullParameter(slideIn, "slideIn");
        Intrinsics.checkNotNullParameter(slideOut, "slideOut");
        this.lazyAnimation = lazyAnimation;
        this.slideIn = slideIn;
        this.slideOut = slideOut;
        this.transitionSpec = new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>>() { // from class: androidx.compose.animation.SlideModifier$transitionSpec$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<IntOffset> invoke(Transition.Segment<EnterExitState> segment) {
                FiniteAnimationSpec<IntOffset> finiteAnimationSpec;
                FiniteAnimationSpec<IntOffset> finiteAnimationSpec2;
                Transition.Segment<EnterExitState> segment2 = segment;
                Intrinsics.checkNotNullParameter(segment2, "$this$null");
                EnterExitState enterExitState = EnterExitState.PreEnter;
                EnterExitState enterExitState2 = EnterExitState.Visible;
                boolean isTransitioningTo = segment2.isTransitioningTo(enterExitState, enterExitState2);
                SlideModifier slideModifier = SlideModifier.this;
                if (isTransitioningTo) {
                    Slide value = slideModifier.slideIn.getValue();
                    if (value == null || (finiteAnimationSpec2 = value.animationSpec) == null) {
                        return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                    }
                    return finiteAnimationSpec2;
                }
                if (segment2.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                    Slide value2 = slideModifier.slideOut.getValue();
                    if (value2 == null || (finiteAnimationSpec = value2.animationSpec) == null) {
                        return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
                    }
                    return finiteAnimationSpec;
                }
                return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
            }
        };
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo5measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(j);
        final long IntSize = IntSizeKt.IntSize(mo421measureBRTryo0.width, mo421measureBRTryo0.height);
        return measure.layout(mo421measureBRTryo0.width, mo421measureBRTryo0.height, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SlideModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                final SlideModifier slideModifier = SlideModifier.this;
                Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation = slideModifier.lazyAnimation;
                final long j2 = IntSize;
                Placeable.PlacementScope.m436placeWithLayeraW9wM$default(layout, mo421measureBRTryo0, ((IntOffset) deferredAnimation.animate(slideModifier.transitionSpec, new Function1<EnterExitState, IntOffset>() { // from class: androidx.compose.animation.SlideModifier$measure$1$slideOffset$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final IntOffset invoke(EnterExitState enterExitState) {
                        long j3;
                        long j4;
                        Function1<IntSize, IntOffset> function1;
                        Function1<IntSize, IntOffset> function12;
                        EnterExitState it = enterExitState;
                        Intrinsics.checkNotNullParameter(it, "it");
                        SlideModifier slideModifier2 = SlideModifier.this;
                        slideModifier2.getClass();
                        Slide value = slideModifier2.slideIn.getValue();
                        long j5 = j2;
                        if (value != null && (function12 = value.slideOffset) != null) {
                            j3 = function12.invoke(new IntSize(j5)).packedValue;
                        } else {
                            j3 = IntOffset.Zero;
                        }
                        Slide value2 = slideModifier2.slideOut.getValue();
                        if (value2 != null && (function1 = value2.slideOffset) != null) {
                            j4 = function1.invoke(new IntSize(j5)).packedValue;
                        } else {
                            j4 = IntOffset.Zero;
                        }
                        int r7 = SlideModifier.WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
                        if (r7 != 1) {
                            if (r7 != 2) {
                                if (r7 == 3) {
                                    j3 = j4;
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                        } else {
                            j3 = IntOffset.Zero;
                        }
                        return new IntOffset(j3);
                    }
                }).getValue()).packedValue);
                return Unit.INSTANCE;
            }
        });
    }
}
