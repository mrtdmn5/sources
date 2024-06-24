package androidx.compose.animation;

import androidx.compose.animation.ExpandShrinkModifier;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public final class ExpandShrinkModifier extends LayoutModifierWithPassThroughIntrinsics {
    public final State<Alignment> alignment;
    public Alignment currentAlignment;
    public final State<ChangeSize> expand;
    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation;
    public final State<ChangeSize> shrink;
    public final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
    public final ExpandShrinkModifier$sizeTransitionSpec$1 sizeTransitionSpec;

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

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.animation.ExpandShrinkModifier$sizeTransitionSpec$1] */
    public ExpandShrinkModifier(Transition.DeferredAnimation sizeAnimation, Transition.DeferredAnimation offsetAnimation, State expand, State shrink, MutableState mutableState) {
        Intrinsics.checkNotNullParameter(sizeAnimation, "sizeAnimation");
        Intrinsics.checkNotNullParameter(offsetAnimation, "offsetAnimation");
        Intrinsics.checkNotNullParameter(expand, "expand");
        Intrinsics.checkNotNullParameter(shrink, "shrink");
        this.sizeAnimation = sizeAnimation;
        this.offsetAnimation = offsetAnimation;
        this.expand = expand;
        this.shrink = shrink;
        this.alignment = mutableState;
        this.sizeTransitionSpec = new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.animation.ExpandShrinkModifier$sizeTransitionSpec$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<IntSize> invoke(Transition.Segment<EnterExitState> segment) {
                FiniteAnimationSpec<IntSize> finiteAnimationSpec;
                Transition.Segment<EnterExitState> segment2 = segment;
                Intrinsics.checkNotNullParameter(segment2, "$this$null");
                EnterExitState enterExitState = EnterExitState.PreEnter;
                EnterExitState enterExitState2 = EnterExitState.Visible;
                boolean isTransitioningTo = segment2.isTransitioningTo(enterExitState, enterExitState2);
                ExpandShrinkModifier expandShrinkModifier = ExpandShrinkModifier.this;
                if (isTransitioningTo) {
                    ChangeSize value = expandShrinkModifier.expand.getValue();
                    if (value != null) {
                        finiteAnimationSpec = value.animationSpec;
                    }
                    finiteAnimationSpec = null;
                } else if (segment2.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                    ChangeSize value2 = expandShrinkModifier.shrink.getValue();
                    if (value2 != null) {
                        finiteAnimationSpec = value2.animationSpec;
                    }
                    finiteAnimationSpec = null;
                } else {
                    finiteAnimationSpec = EnterExitTransitionKt.DefaultSizeAnimationSpec;
                }
                if (finiteAnimationSpec == null) {
                    return EnterExitTransitionKt.DefaultSizeAnimationSpec;
                }
                return finiteAnimationSpec;
            }
        };
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo5measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        long j2;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(j);
        final long IntSize = IntSizeKt.IntSize(mo421measureBRTryo0.width, mo421measureBRTryo0.height);
        long j3 = ((IntSize) this.sizeAnimation.animate(this.sizeTransitionSpec, new Function1<EnterExitState, IntSize>() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$currentSize$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final IntSize invoke(EnterExitState enterExitState) {
                long j4;
                long j5;
                EnterExitState it = enterExitState;
                Intrinsics.checkNotNullParameter(it, "it");
                ExpandShrinkModifier expandShrinkModifier = ExpandShrinkModifier.this;
                expandShrinkModifier.getClass();
                ChangeSize value = expandShrinkModifier.expand.getValue();
                long j6 = IntSize;
                if (value != null) {
                    j4 = value.size.invoke(new IntSize(j6)).packedValue;
                } else {
                    j4 = j6;
                }
                ChangeSize value2 = expandShrinkModifier.shrink.getValue();
                if (value2 != null) {
                    j5 = value2.size.invoke(new IntSize(j6)).packedValue;
                } else {
                    j5 = j6;
                }
                int r8 = ExpandShrinkModifier.WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
                if (r8 != 1) {
                    if (r8 != 2) {
                        if (r8 == 3) {
                            j6 = j5;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        j6 = j4;
                    }
                }
                return new IntSize(j6);
            }
        }).getValue()).packedValue;
        final long j4 = ((IntOffset) this.offsetAnimation.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntOffset>>() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$offsetDelta$1
            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<IntOffset> invoke(Transition.Segment<EnterExitState> segment) {
                Transition.Segment<EnterExitState> animate = segment;
                Intrinsics.checkNotNullParameter(animate, "$this$animate");
                return EnterExitTransitionKt.DefaultOffsetAnimationSpec;
            }
        }, new Function1<EnterExitState, IntOffset>() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$offsetDelta$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final IntOffset invoke(EnterExitState enterExitState) {
                long j5;
                EnterExitState it = enterExitState;
                Intrinsics.checkNotNullParameter(it, "it");
                long j6 = IntSize;
                ExpandShrinkModifier expandShrinkModifier = ExpandShrinkModifier.this;
                expandShrinkModifier.getClass();
                if (expandShrinkModifier.currentAlignment == null) {
                    j5 = IntOffset.Zero;
                } else {
                    State<Alignment> state = expandShrinkModifier.alignment;
                    if (state.getValue() == null) {
                        j5 = IntOffset.Zero;
                    } else if (Intrinsics.areEqual(expandShrinkModifier.currentAlignment, state.getValue())) {
                        j5 = IntOffset.Zero;
                    } else {
                        int r14 = ExpandShrinkModifier.WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
                        if (r14 != 1) {
                            if (r14 != 2) {
                                if (r14 == 3) {
                                    ChangeSize value = expandShrinkModifier.shrink.getValue();
                                    if (value != null) {
                                        long j7 = value.size.invoke(new IntSize(j6)).packedValue;
                                        Alignment value2 = state.getValue();
                                        Intrinsics.checkNotNull(value2);
                                        Alignment alignment = value2;
                                        LayoutDirection layoutDirection = LayoutDirection.Ltr;
                                        long mo229alignKFBX0sM = alignment.mo229alignKFBX0sM(j6, j7, layoutDirection);
                                        Alignment alignment2 = expandShrinkModifier.currentAlignment;
                                        Intrinsics.checkNotNull(alignment2);
                                        long mo229alignKFBX0sM2 = alignment2.mo229alignKFBX0sM(j6, j7, layoutDirection);
                                        j5 = IntOffsetKt.IntOffset(((int) (mo229alignKFBX0sM >> 32)) - ((int) (mo229alignKFBX0sM2 >> 32)), IntOffset.m590getYimpl(mo229alignKFBX0sM) - IntOffset.m590getYimpl(mo229alignKFBX0sM2));
                                    } else {
                                        j5 = IntOffset.Zero;
                                    }
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                j5 = IntOffset.Zero;
                            }
                        } else {
                            j5 = IntOffset.Zero;
                        }
                    }
                }
                return new IntOffset(j5);
            }
        }).getValue()).packedValue;
        Alignment alignment = this.currentAlignment;
        if (alignment != null) {
            j2 = alignment.mo229alignKFBX0sM(IntSize, j3, LayoutDirection.Ltr);
        } else {
            j2 = IntOffset.Zero;
        }
        final long j5 = j2;
        return measure.layout((int) (j3 >> 32), IntSize.m593getHeightimpl(j3), EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                int r8 = IntOffset.$r8$clinit;
                long j6 = j5;
                long j7 = j4;
                Placeable.PlacementScope.place(Placeable.this, ((int) (j7 >> 32)) + ((int) (j6 >> 32)), IntOffset.m590getYimpl(j7) + IntOffset.m590getYimpl(j6), 0.0f);
                return Unit.INSTANCE;
            }
        });
    }
}
