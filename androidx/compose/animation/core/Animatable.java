package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.material.SwipeableState$animateInternalToOffset$2;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: Animatable.kt */
/* loaded from: classes.dex */
public final class Animatable<T, V extends AnimationVector> {
    public final SpringSpec<T> defaultSpringSpec;
    public final AnimationState<T, V> internalState;
    public final ParcelableSnapshotMutableState isRunning$delegate;
    public final V lowerBoundVector;
    public final MutatorMutex mutatorMutex;
    public final V negativeInfinityBounds;
    public final V positiveInfinityBounds;
    public final ParcelableSnapshotMutableState targetValue$delegate;
    public final TwoWayConverter<T, V> typeConverter;
    public final V upperBoundVector;
    public final T visibilityThreshold;

    public Animatable(T t, TwoWayConverter<T, V> typeConverter, T t2, String label) {
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(label, "label");
        this.typeConverter = typeConverter;
        this.visibilityThreshold = t2;
        this.internalState = new AnimationState<>(typeConverter, t, null, 60);
        this.isRunning$delegate = Platform.mutableStateOf$default(Boolean.FALSE);
        this.targetValue$delegate = Platform.mutableStateOf$default(t);
        this.mutatorMutex = new MutatorMutex();
        this.defaultSpringSpec = new SpringSpec<>(t2, 3);
        V invoke = typeConverter.getConvertToVector().invoke(t);
        int size$animation_core_release = invoke.getSize$animation_core_release();
        for (int r0 = 0; r0 < size$animation_core_release; r0++) {
            invoke.set$animation_core_release(Float.NEGATIVE_INFINITY, r0);
        }
        this.negativeInfinityBounds = invoke;
        V invoke2 = this.typeConverter.getConvertToVector().invoke(t);
        int size$animation_core_release2 = invoke2.getSize$animation_core_release();
        for (int r6 = 0; r6 < size$animation_core_release2; r6++) {
            invoke2.set$animation_core_release(Float.POSITIVE_INFINITY, r6);
        }
        this.positiveInfinityBounds = invoke2;
        this.lowerBoundVector = invoke;
        this.upperBoundVector = invoke2;
    }

    public static final Object access$clampToBounds(Animatable animatable, Object obj) {
        V v = animatable.negativeInfinityBounds;
        V v2 = animatable.lowerBoundVector;
        boolean areEqual = Intrinsics.areEqual(v2, v);
        V v3 = animatable.upperBoundVector;
        if (!areEqual || !Intrinsics.areEqual(v3, animatable.positiveInfinityBounds)) {
            TwoWayConverter<T, V> twoWayConverter = animatable.typeConverter;
            V invoke = twoWayConverter.getConvertToVector().invoke(obj);
            int size$animation_core_release = invoke.getSize$animation_core_release();
            boolean z = false;
            for (int r4 = 0; r4 < size$animation_core_release; r4++) {
                if (invoke.get$animation_core_release(r4) < v2.get$animation_core_release(r4) || invoke.get$animation_core_release(r4) > v3.get$animation_core_release(r4)) {
                    invoke.set$animation_core_release(RangesKt___RangesKt.coerceIn(invoke.get$animation_core_release(r4), v2.get$animation_core_release(r4), v3.get$animation_core_release(r4)), r4);
                    z = true;
                }
            }
            if (z) {
                return twoWayConverter.getConvertFromVector().invoke(invoke);
            }
            return obj;
        }
        return obj;
    }

    public static Object animateTo$default(Animatable animatable, Object obj, AnimationSpec animationSpec, SwipeableState$animateInternalToOffset$2.AnonymousClass1 anonymousClass1, Continuation continuation, int r11) {
        T t;
        SwipeableState$animateInternalToOffset$2.AnonymousClass1 anonymousClass12;
        if ((r11 & 2) != 0) {
            animationSpec = animatable.defaultSpringSpec;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((r11 & 4) != 0) {
            t = animatable.typeConverter.getConvertFromVector().invoke(animatable.internalState.velocityVector);
        } else {
            t = null;
        }
        if ((r11 & 8) != 0) {
            anonymousClass12 = null;
        } else {
            anonymousClass12 = anonymousClass1;
        }
        return animatable.animateTo(obj, animationSpec2, t, anonymousClass12, continuation);
    }

    public final Object animateTo(T t, AnimationSpec<T> animationSpec, T t2, Function1<? super Animatable<T, V>, Unit> function1, Continuation<? super AnimationResult<T, V>> continuation) {
        T value = getValue();
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        TwoWayConverter<T, V> typeConverter = this.typeConverter;
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Animatable$runAnimation$2 animatable$runAnimation$2 = new Animatable$runAnimation$2(this, t2, new TargetBasedAnimation(animationSpec, typeConverter, value, t, typeConverter.getConvertToVector().invoke(t2)), this.internalState.lastFrameTimeNanos, function1, null);
        MutatePriority mutatePriority = MutatePriority.Default;
        MutatorMutex mutatorMutex = this.mutatorMutex;
        mutatorMutex.getClass();
        return CoroutineScopeKt.coroutineScope(new MutatorMutex$mutate$2(mutatePriority, mutatorMutex, animatable$runAnimation$2, null), continuation);
    }

    public final T getValue() {
        return this.internalState.getValue();
    }

    public final Object snapTo(T t, Continuation<? super Unit> continuation) {
        Animatable$snapTo$2 animatable$snapTo$2 = new Animatable$snapTo$2(this, t, null);
        MutatePriority mutatePriority = MutatePriority.Default;
        MutatorMutex mutatorMutex = this.mutatorMutex;
        mutatorMutex.getClass();
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new MutatorMutex$mutate$2(mutatePriority, mutatorMutex, animatable$snapTo$2, null), continuation);
        if (coroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ Animatable(Object obj, TwoWayConverterImpl twoWayConverterImpl, Object obj2, int r6) {
        this(obj, twoWayConverterImpl, (r6 & 4) != 0 ? null : obj2, (r6 & 8) != 0 ? "Animatable" : null);
    }
}
