package com.airbnb.lottie.compose;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.MutatorMutex$mutate$2;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import com.airbnb.lottie.LottieComposition;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: LottieAnimatable.kt */
/* loaded from: classes.dex */
public final class LottieAnimatableImpl implements LottieAnimatable {
    public final MutatorMutex mutex;
    public final ParcelableSnapshotMutableState isPlaying$delegate = Platform.mutableStateOf$default(Boolean.FALSE);
    public final ParcelableSnapshotMutableState progress$delegate = Platform.mutableStateOf$default(Float.valueOf(0.0f));
    public final ParcelableSnapshotMutableState iteration$delegate = Platform.mutableStateOf$default(1);
    public final ParcelableSnapshotMutableState iterations$delegate = Platform.mutableStateOf$default(1);
    public final ParcelableSnapshotMutableState clipSpec$delegate = Platform.mutableStateOf$default(null);
    public final ParcelableSnapshotMutableState speed$delegate = Platform.mutableStateOf$default(Float.valueOf(1.0f));
    public final ParcelableSnapshotMutableState composition$delegate = Platform.mutableStateOf$default(null);
    public final ParcelableSnapshotMutableState lastFrameNanos$delegate = Platform.mutableStateOf$default(Long.MIN_VALUE);
    public final DerivedSnapshotState endProgress$delegate = Platform.derivedStateOf(new Function0<Float>() { // from class: com.airbnb.lottie.compose.LottieAnimatableImpl$endProgress$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Float invoke() {
            LottieAnimatableImpl lottieAnimatableImpl = LottieAnimatableImpl.this;
            LottieComposition composition = lottieAnimatableImpl.getComposition();
            float f = 0.0f;
            if (composition != null) {
                if (lottieAnimatableImpl.getSpeed() < 0.0f) {
                    LottieClipSpec clipSpec = lottieAnimatableImpl.getClipSpec();
                    if (clipSpec != null) {
                        f = clipSpec.getMinProgress$lottie_compose_release(composition);
                    }
                } else {
                    LottieClipSpec clipSpec2 = lottieAnimatableImpl.getClipSpec();
                    f = clipSpec2 == null ? 1.0f : clipSpec2.getMaxProgress$lottie_compose_release(composition);
                }
            }
            return Float.valueOf(f);
        }
    });

    public LottieAnimatableImpl() {
        Platform.derivedStateOf(new Function0<Boolean>() { // from class: com.airbnb.lottie.compose.LottieAnimatableImpl$isAtEnd$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                LottieAnimatableImpl lottieAnimatableImpl = LottieAnimatableImpl.this;
                boolean z2 = false;
                if (lottieAnimatableImpl.getIteration() == lottieAnimatableImpl.getIterations()) {
                    if (lottieAnimatableImpl.getProgress() == lottieAnimatableImpl.getEndProgress()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        z2 = true;
                    }
                }
                return Boolean.valueOf(z2);
            }
        });
        this.mutex = new MutatorMutex();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean access$onFrame(LottieAnimatableImpl lottieAnimatableImpl, int r8, long j) {
        long longValue;
        float minProgress$lottie_compose_release;
        float maxProgress$lottie_compose_release;
        float progress;
        float f;
        LottieComposition composition = lottieAnimatableImpl.getComposition();
        if (composition == null) {
            return true;
        }
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = lottieAnimatableImpl.lastFrameNanos$delegate;
        if (((Number) parcelableSnapshotMutableState.getValue()).longValue() == Long.MIN_VALUE) {
            longValue = 0;
        } else {
            longValue = j - ((Number) parcelableSnapshotMutableState.getValue()).longValue();
        }
        parcelableSnapshotMutableState.setValue(Long.valueOf(j));
        LottieClipSpec clipSpec = lottieAnimatableImpl.getClipSpec();
        if (clipSpec == null) {
            minProgress$lottie_compose_release = 0.0f;
        } else {
            minProgress$lottie_compose_release = clipSpec.getMinProgress$lottie_compose_release(composition);
        }
        LottieClipSpec clipSpec2 = lottieAnimatableImpl.getClipSpec();
        if (clipSpec2 == null) {
            maxProgress$lottie_compose_release = 1.0f;
        } else {
            maxProgress$lottie_compose_release = clipSpec2.getMaxProgress$lottie_compose_release(composition);
        }
        float speed = lottieAnimatableImpl.getSpeed() * (((float) (longValue / 1000000)) / composition.getDuration());
        if (lottieAnimatableImpl.getSpeed() < 0.0f) {
            progress = minProgress$lottie_compose_release - (lottieAnimatableImpl.getProgress() + speed);
        } else {
            progress = (lottieAnimatableImpl.getProgress() + speed) - maxProgress$lottie_compose_release;
        }
        if (progress < 0.0f) {
            lottieAnimatableImpl.setProgress(RangesKt___RangesKt.coerceIn(lottieAnimatableImpl.getProgress(), minProgress$lottie_compose_release, maxProgress$lottie_compose_release) + speed);
            return true;
        }
        float f2 = maxProgress$lottie_compose_release - minProgress$lottie_compose_release;
        int r4 = ((int) (progress / f2)) + 1;
        if (lottieAnimatableImpl.getIteration() + r4 > r8) {
            lottieAnimatableImpl.setProgress(lottieAnimatableImpl.getEndProgress());
            lottieAnimatableImpl.setIteration(r8);
            return false;
        }
        lottieAnimatableImpl.setIteration(lottieAnimatableImpl.getIteration() + r4);
        float f3 = progress - ((r4 - 1) * f2);
        if (lottieAnimatableImpl.getSpeed() < 0.0f) {
            f = maxProgress$lottie_compose_release - f3;
        } else {
            f = minProgress$lottie_compose_release + f3;
        }
        lottieAnimatableImpl.setProgress(f);
        return true;
    }

    @Override // com.airbnb.lottie.compose.LottieAnimatable
    public final Object animate(LottieComposition lottieComposition, int r14, int r15, float f, LottieClipSpec lottieClipSpec, float f2, boolean z, LottieCancellationBehavior lottieCancellationBehavior, Continuation continuation) {
        LottieAnimatableImpl$animate$2 lottieAnimatableImpl$animate$2 = new LottieAnimatableImpl$animate$2(this, r14, r15, f, lottieClipSpec, lottieComposition, f2, z, lottieCancellationBehavior, null);
        MutatePriority mutatePriority = MutatePriority.Default;
        MutatorMutex mutatorMutex = this.mutex;
        mutatorMutex.getClass();
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new MutatorMutex$mutate$2(mutatePriority, mutatorMutex, lottieAnimatableImpl$animate$2, null), continuation);
        if (coroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public final LottieClipSpec getClipSpec() {
        return (LottieClipSpec) this.clipSpec$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public final LottieComposition getComposition() {
        return (LottieComposition) this.composition$delegate.getValue();
    }

    public final float getEndProgress() {
        return ((Number) this.endProgress$delegate.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public final int getIteration() {
        return ((Number) this.iteration$delegate.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getIterations() {
        return ((Number) this.iterations$delegate.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public final float getSpeed() {
        return ((Number) this.speed$delegate.getValue()).floatValue();
    }

    @Override // androidx.compose.runtime.State
    public final Float getValue() {
        return Float.valueOf(getProgress());
    }

    public final void setIteration(int r2) {
        this.iteration$delegate.setValue(Integer.valueOf(r2));
    }

    public final void setProgress(float f) {
        this.progress$delegate.setValue(Float.valueOf(f));
    }

    @Override // com.airbnb.lottie.compose.LottieAnimatable
    public final Object snapTo(LottieComposition lottieComposition, float f, int r11, boolean z, Continuation<? super Unit> continuation) {
        LottieAnimatableImpl$snapTo$2 lottieAnimatableImpl$snapTo$2 = new LottieAnimatableImpl$snapTo$2(this, lottieComposition, f, r11, z, null);
        MutatePriority mutatePriority = MutatePriority.Default;
        MutatorMutex mutatorMutex = this.mutex;
        mutatorMutex.getClass();
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new MutatorMutex$mutate$2(mutatePriority, mutatorMutex, lottieAnimatableImpl$snapTo$2, null), continuation);
        if (coroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }
}
