package androidx.compose.animation.core;

import com.google.android.gms.common.zzy;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;

/* compiled from: Animatable.kt */
@DebugMetadata(c = "androidx.compose.animation.core.Animatable$runAnimation$2", f = "Animatable.kt", l = {305}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class Animatable$runAnimation$2 extends SuspendLambda implements Function1<Continuation<? super AnimationResult<Object, AnimationVector>>, Object> {
    public final /* synthetic */ Animation<Object, AnimationVector> $animation;
    public final /* synthetic */ Function1<Animatable<Object, AnimationVector>, Unit> $block;
    public final /* synthetic */ Object $initialVelocity;
    public final /* synthetic */ long $startTime;
    public AnimationState L$0;
    public Ref$BooleanRef L$1;
    public int label;
    public final /* synthetic */ Animatable<Object, AnimationVector> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Animatable$runAnimation$2(Animatable<Object, AnimationVector> animatable, Object obj, Animation<Object, AnimationVector> animation, long j, Function1<? super Animatable<Object, AnimationVector>, Unit> function1, Continuation<? super Animatable$runAnimation$2> continuation) {
        super(1, continuation);
        this.this$0 = animatable;
        this.$initialVelocity = obj;
        this.$animation = animation;
        this.$startTime = j;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Animatable$runAnimation$2(this.this$0, this.$initialVelocity, this.$animation, this.$startTime, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super AnimationResult<Object, AnimationVector>> continuation) {
        return ((Animatable$runAnimation$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref$BooleanRef ref$BooleanRef;
        AnimationState animationState;
        AnimationEndReason animationEndReason;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        final Animatable<Object, AnimationVector> animatable = this.this$0;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    ref$BooleanRef = this.L$1;
                    animationState = this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                AnimationState<Object, AnimationVector> animationState2 = animatable.internalState;
                V v = (V) animatable.typeConverter.getConvertToVector().invoke(this.$initialVelocity);
                animationState2.getClass();
                Intrinsics.checkNotNullParameter(v, "<set-?>");
                animationState2.velocityVector = v;
                animatable.targetValue$delegate.setValue(this.$animation.getTargetValue());
                animatable.isRunning$delegate.setValue(Boolean.TRUE);
                AnimationState<Object, AnimationVector> animationState3 = animatable.internalState;
                final AnimationState animationState4 = new AnimationState(animationState3.typeConverter, animationState3.getValue(), zzy.copy(animationState3.velocityVector), animationState3.lastFrameTimeNanos, Long.MIN_VALUE, animationState3.isRunning);
                final Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
                Animation<Object, AnimationVector> animation = this.$animation;
                long j = this.$startTime;
                final Function1<Animatable<Object, AnimationVector>, Unit> function1 = this.$block;
                Function1<AnimationScope<Object, AnimationVector>, Unit> function12 = new Function1<AnimationScope<Object, AnimationVector>, Unit>() { // from class: androidx.compose.animation.core.Animatable$runAnimation$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(AnimationScope<Object, AnimationVector> animationScope) {
                        AnimationScope<Object, AnimationVector> animate = animationScope;
                        Intrinsics.checkNotNullParameter(animate, "$this$animate");
                        Animatable<Object, AnimationVector> animatable2 = animatable;
                        SuspendAnimationKt.updateState(animate, animatable2.internalState);
                        Object access$clampToBounds = Animatable.access$clampToBounds(animatable2, animate.getValue());
                        boolean areEqual = Intrinsics.areEqual(access$clampToBounds, animate.getValue());
                        Function1<Animatable<Object, AnimationVector>, Unit> function13 = function1;
                        if (!areEqual) {
                            animatable2.internalState.value$delegate.setValue(access$clampToBounds);
                            animationState4.value$delegate.setValue(access$clampToBounds);
                            if (function13 != null) {
                                function13.invoke(animatable2);
                            }
                            animate.cancelAnimation();
                            ref$BooleanRef2.element = true;
                        } else if (function13 != null) {
                            function13.invoke(animatable2);
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.L$0 = animationState4;
                this.L$1 = ref$BooleanRef2;
                this.label = 1;
                if (SuspendAnimationKt.animate(animationState4, animation, j, function12, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                ref$BooleanRef = ref$BooleanRef2;
                animationState = animationState4;
            }
            if (ref$BooleanRef.element) {
                animationEndReason = AnimationEndReason.BoundReached;
            } else {
                animationEndReason = AnimationEndReason.Finished;
            }
            AnimationState<Object, AnimationVector> animationState5 = animatable.internalState;
            animationState5.velocityVector.reset$animation_core_release();
            animationState5.lastFrameTimeNanos = Long.MIN_VALUE;
            animatable.isRunning$delegate.setValue(Boolean.FALSE);
            return new AnimationResult(animationState, animationEndReason);
        } catch (CancellationException e) {
            AnimationState<Object, AnimationVector> animationState6 = animatable.internalState;
            animationState6.velocityVector.reset$animation_core_release();
            animationState6.lastFrameTimeNanos = Long.MIN_VALUE;
            animatable.isRunning$delegate.setValue(Boolean.FALSE);
            throw e;
        }
    }
}
