package androidx.compose.animation.core;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import com.google.android.gms.common.zzw;
import com.google.android.gms.common.zzy;
import com.google.common.collect.Platform;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationState.kt */
/* loaded from: classes.dex */
public final class AnimationState<T, V extends AnimationVector> implements State<T> {
    public long finishedTimeNanos;
    public boolean isRunning;
    public long lastFrameTimeNanos;
    public final TwoWayConverter<T, V> typeConverter;
    public final ParcelableSnapshotMutableState value$delegate;
    public V velocityVector;

    public /* synthetic */ AnimationState(TwoWayConverter twoWayConverter, Object obj, AnimationVector animationVector, int r13) {
        this(twoWayConverter, obj, (r13 & 4) != 0 ? null : animationVector, (r13 & 8) != 0 ? Long.MIN_VALUE : 0L, (r13 & 16) != 0 ? Long.MIN_VALUE : 0L, false);
    }

    @Override // androidx.compose.runtime.State
    public final T getValue() {
        return this.value$delegate.getValue();
    }

    public final T getVelocity() {
        return this.typeConverter.getConvertFromVector().invoke(this.velocityVector);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AnimationState(value=");
        sb.append(getValue());
        sb.append(", velocity=");
        sb.append(getVelocity());
        sb.append(", isRunning=");
        sb.append(this.isRunning);
        sb.append(", lastFrameTimeNanos=");
        sb.append(this.lastFrameTimeNanos);
        sb.append(", finishedTimeNanos=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.finishedTimeNanos, ')');
    }

    public AnimationState(TwoWayConverter<T, V> typeConverter, T t, V v, long j, long j2, boolean z) {
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        this.typeConverter = typeConverter;
        this.value$delegate = Platform.mutableStateOf$default(t);
        this.velocityVector = v != null ? (V) zzy.copy(v) : (V) zzw.createZeroVectorFrom(typeConverter, t);
        this.lastFrameTimeNanos = j;
        this.finishedTimeNanos = j2;
        this.isRunning = z;
    }
}
