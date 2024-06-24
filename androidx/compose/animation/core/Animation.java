package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;

/* compiled from: Animation.kt */
/* loaded from: classes.dex */
public interface Animation<T, V extends AnimationVector> {
    long getDurationNanos();

    T getTargetValue();

    TwoWayConverter<T, V> getTypeConverter();

    T getValueFromNanos(long j);

    V getVelocityVectorFromNanos(long j);

    default boolean isFinishedFromNanos(long j) {
        if (j >= getDurationNanos()) {
            return true;
        }
        return false;
    }

    boolean isInfinite();
}
