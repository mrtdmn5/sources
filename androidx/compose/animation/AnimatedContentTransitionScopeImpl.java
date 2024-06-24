package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.common.collect.Platform;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedContent.kt */
/* loaded from: classes.dex */
public final class AnimatedContentTransitionScopeImpl<S> implements AnimatedContentTransitionScope<S> {
    public State<IntSize> animatedSize;
    public Alignment contentAlignment;
    public final ParcelableSnapshotMutableState measuredSize$delegate;
    public final LinkedHashMap targetSizeMap;
    public final Transition<S> transition;

    /* compiled from: AnimatedContent.kt */
    /* loaded from: classes.dex */
    public static final class ChildData implements ParentDataModifier {
        public boolean isTarget;

        public ChildData(boolean z) {
            this.isTarget = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof ChildData) && this.isTarget == ((ChildData) obj).isTarget) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            boolean z = this.isTarget;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        @Override // androidx.compose.ui.layout.ParentDataModifier
        public final ChildData modifyParentData(Density density) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            return this;
        }

        public final String toString() {
            return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(new StringBuilder("ChildData(isTarget="), this.isTarget, ')');
        }
    }

    /* compiled from: AnimatedContent.kt */
    /* loaded from: classes.dex */
    public final class SizeModifier extends LayoutModifierWithPassThroughIntrinsics {
        public final Transition<S>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
        public final State<SizeTransform> sizeTransform;
        public final /* synthetic */ AnimatedContentTransitionScopeImpl<S> this$0;

        public SizeModifier(AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl, Transition.DeferredAnimation sizeAnimation, MutableState mutableState) {
            Intrinsics.checkNotNullParameter(sizeAnimation, "sizeAnimation");
            this.this$0 = animatedContentTransitionScopeImpl;
            this.sizeAnimation = sizeAnimation;
            this.sizeTransform = mutableState;
        }

        @Override // androidx.compose.ui.layout.LayoutModifier
        /* renamed from: measure-3p2s80s, reason: not valid java name */
        public final MeasureResult mo5measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
            Intrinsics.checkNotNullParameter(measure, "$this$measure");
            final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(j);
            final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl = this.this$0;
            Transition.DeferredAnimation.DeferredAnimationData animate = this.sizeAnimation.animate(new Function1<Transition.Segment<S>, FiniteAnimationSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifier$measure$size$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final FiniteAnimationSpec<IntSize> invoke(Object obj) {
                    long j2;
                    FiniteAnimationSpec<IntSize> mo8createAnimationSpecTemP2vQ;
                    Transition.Segment animate2 = (Transition.Segment) obj;
                    Intrinsics.checkNotNullParameter(animate2, "$this$animate");
                    AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl;
                    State state = (State) animatedContentTransitionScopeImpl2.targetSizeMap.get(animate2.getInitialState());
                    long j3 = 0;
                    if (state != null) {
                        j2 = ((IntSize) state.getValue()).packedValue;
                    } else {
                        j2 = 0;
                    }
                    State state2 = (State) animatedContentTransitionScopeImpl2.targetSizeMap.get(animate2.getTargetState());
                    if (state2 != null) {
                        j3 = ((IntSize) state2.getValue()).packedValue;
                    }
                    SizeTransform value = this.sizeTransform.getValue();
                    if (value == null || (mo8createAnimationSpecTemP2vQ = value.mo8createAnimationSpecTemP2vQ(j2, j3)) == null) {
                        return AnimationSpecKt.spring$default(0.0f, null, 7);
                    }
                    return mo8createAnimationSpecTemP2vQ;
                }
            }, new Function1<S, IntSize>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifier$measure$size$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final IntSize invoke(Object obj) {
                    long j2;
                    State state = (State) animatedContentTransitionScopeImpl.targetSizeMap.get(obj);
                    if (state != null) {
                        j2 = ((IntSize) state.getValue()).packedValue;
                    } else {
                        j2 = 0;
                    }
                    return new IntSize(j2);
                }
            });
            animatedContentTransitionScopeImpl.animatedSize = animate;
            final long mo229alignKFBX0sM = animatedContentTransitionScopeImpl.contentAlignment.mo229alignKFBX0sM(IntSizeKt.IntSize(mo421measureBRTryo0.width, mo421measureBRTryo0.height), ((IntSize) animate.getValue()).packedValue, LayoutDirection.Ltr);
            return measure.layout((int) (((IntSize) animate.getValue()).packedValue >> 32), IntSize.m593getHeightimpl(((IntSize) animate.getValue()).packedValue), EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifier$measure$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope layout = placementScope;
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    Placeable.PlacementScope.m432place70tqf50(Placeable.this, mo229alignKFBX0sM, 0.0f);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public AnimatedContentTransitionScopeImpl(Transition<S> transition, Alignment contentAlignment, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        Intrinsics.checkNotNullParameter(contentAlignment, "contentAlignment");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.transition = transition;
        this.contentAlignment = contentAlignment;
        this.measuredSize$delegate = Platform.mutableStateOf$default(new IntSize(0L));
        this.targetSizeMap = new LinkedHashMap();
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public final S getInitialState() {
        return this.transition.getSegment().getInitialState();
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public final S getTargetState() {
        return this.transition.getSegment().getTargetState();
    }
}
