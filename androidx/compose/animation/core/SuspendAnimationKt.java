package androidx.compose.animation.core;

import androidx.compose.ui.MotionDurationScale;
import com.google.android.gms.common.zzy;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SuspendAnimation.kt */
/* loaded from: classes.dex */
public final class SuspendAnimationKt {
    /* JADX WARN: Removed duplicated region for block: B:20:0x00eb A[Catch: CancellationException -> 0x0045, TryCatch #2 {CancellationException -> 0x0045, blocks: (B:15:0x003f, B:18:0x00d6, B:20:0x00eb, B:22:0x0114, B:28:0x0119), top: B:14:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0125 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, androidx.compose.animation.core.AnimationScope] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T, V extends androidx.compose.animation.core.AnimationVector> java.lang.Object animate(final androidx.compose.animation.core.AnimationState<T, V> r24, final androidx.compose.animation.core.Animation<T, V> r25, long r26, final kotlin.jvm.functions.Function1<? super androidx.compose.animation.core.AnimationScope<T, V>, kotlin.Unit> r28, kotlin.coroutines.Continuation<? super kotlin.Unit> r29) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SuspendAnimationKt.animate(androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.Animation, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final <T, V extends AnimationVector> Object animateDecay(AnimationState<T, V> animationState, DecayAnimationSpec<T> decayAnimationSpec, boolean z, Function1<? super AnimationScope<T, V>, Unit> function1, Continuation<? super Unit> continuation) {
        long j;
        DecayAnimation decayAnimation = new DecayAnimation(decayAnimationSpec, animationState.typeConverter, animationState.getValue(), animationState.velocityVector);
        if (z) {
            j = animationState.lastFrameTimeNanos;
        } else {
            j = Long.MIN_VALUE;
        }
        Object animate = animate(animationState, decayAnimation, j, function1, continuation);
        if (animate == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return animate;
        }
        return Unit.INSTANCE;
    }

    public static final Object animateTo(AnimationState animationState, Float f, AnimationSpec animationSpec, boolean z, Function1 function1, ContinuationImpl continuationImpl) {
        long j;
        TargetBasedAnimation targetBasedAnimation = new TargetBasedAnimation(animationSpec, animationState.typeConverter, animationState.getValue(), f, animationState.velocityVector);
        if (z) {
            j = animationState.lastFrameTimeNanos;
        } else {
            j = Long.MIN_VALUE;
        }
        Object animate = animate(animationState, targetBasedAnimation, j, function1, continuationImpl);
        if (animate == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return animate;
        }
        return Unit.INSTANCE;
    }

    public static final <T, V extends AnimationVector> void doAnimationFrameWithScale(AnimationScope<T, V> animationScope, long j, float f, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        boolean z;
        long j2;
        if (f == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            j2 = animation.getDurationNanos();
        } else {
            j2 = ((float) (j - animationScope.startTimeNanos)) / f;
        }
        animationScope.lastFrameTimeNanos = j;
        animationScope.value$delegate.setValue(animation.getValueFromNanos(j2));
        V velocityVectorFromNanos = animation.getVelocityVectorFromNanos(j2);
        Intrinsics.checkNotNullParameter(velocityVectorFromNanos, "<set-?>");
        animationScope.velocityVector = velocityVectorFromNanos;
        if (animation.isFinishedFromNanos(j2)) {
            animationScope.finishedTimeNanos = animationScope.lastFrameTimeNanos;
            animationScope.isRunning$delegate.setValue(Boolean.FALSE);
        }
        updateState(animationScope, animationState);
        function1.invoke(animationScope);
    }

    public static final float getDurationScale(CoroutineContext coroutineContext) {
        float f;
        boolean z;
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        int r0 = MotionDurationScale.$r8$clinit;
        MotionDurationScale motionDurationScale = (MotionDurationScale) coroutineContext.get(MotionDurationScale.Key.$$INSTANCE);
        if (motionDurationScale != null) {
            f = motionDurationScale.getScaleFactor();
        } else {
            f = 1.0f;
        }
        if (f >= 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return f;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final <T, V extends AnimationVector> void updateState(AnimationScope<T, V> animationScope, AnimationState<T, V> state) {
        Intrinsics.checkNotNullParameter(animationScope, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        state.value$delegate.setValue(animationScope.getValue());
        V v = state.velocityVector;
        V source = animationScope.velocityVector;
        Intrinsics.checkNotNullParameter(v, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int size$animation_core_release = v.getSize$animation_core_release();
        for (int r3 = 0; r3 < size$animation_core_release; r3++) {
            v.set$animation_core_release(source.get$animation_core_release(r3), r3);
        }
        state.finishedTimeNanos = animationScope.finishedTimeNanos;
        state.lastFrameTimeNanos = animationScope.lastFrameTimeNanos;
        state.isRunning = ((Boolean) animationScope.isRunning$delegate.getValue()).booleanValue();
    }

    public static final Object animate(float f, float f2, float f3, AnimationSpec<Float> animationSpec, final Function2<? super Float, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        final TwoWayConverterImpl twoWayConverterImpl = VectorConvertersKt.FloatToVector;
        Float f4 = new Float(f);
        Float f5 = new Float(f2);
        AnimationVector animationVector = (AnimationVector) twoWayConverterImpl.convertToVector.invoke(new Float(f3));
        if (animationVector == null) {
            animationVector = zzy.newInstance((AnimationVector) twoWayConverterImpl.convertToVector.invoke(f4));
        }
        AnimationVector animationVector2 = animationVector;
        Object animate = animate(new AnimationState(twoWayConverterImpl, f4, animationVector2, 56), new TargetBasedAnimation(animationSpec, twoWayConverterImpl, f4, f5, animationVector2), Long.MIN_VALUE, new Function1<AnimationScope<Object, Object>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(AnimationScope<Object, Object> animationScope) {
                AnimationScope<Object, Object> animate2 = animationScope;
                Intrinsics.checkNotNullParameter(animate2, "$this$animate");
                Function2.this.invoke(animate2.getValue(), twoWayConverterImpl.getConvertFromVector().invoke(animate2.velocityVector));
                return Unit.INSTANCE;
            }
        }, continuation);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (animate != coroutineSingletons) {
            animate = Unit.INSTANCE;
        }
        return animate == coroutineSingletons ? animate : Unit.INSTANCE;
    }
}
