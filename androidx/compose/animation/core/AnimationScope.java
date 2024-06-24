package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import com.google.android.gms.common.zzy;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationState.kt */
/* loaded from: classes.dex */
public final class AnimationScope<T, V extends AnimationVector> {
    public long finishedTimeNanos;
    public final ParcelableSnapshotMutableState isRunning$delegate;
    public long lastFrameTimeNanos;
    public final Function0<Unit> onCancel;
    public final long startTimeNanos;
    public final T targetValue;
    public final TwoWayConverter<T, V> typeConverter;
    public final ParcelableSnapshotMutableState value$delegate;
    public V velocityVector;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimationScope(Object obj, TwoWayConverter typeConverter, AnimationVector initialVelocityVector, long j, Object obj2, long j2, Function0 function0) {
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(initialVelocityVector, "initialVelocityVector");
        this.typeConverter = typeConverter;
        this.targetValue = obj2;
        this.startTimeNanos = j2;
        this.onCancel = function0;
        this.value$delegate = Platform.mutableStateOf$default(obj);
        this.velocityVector = (V) zzy.copy(initialVelocityVector);
        this.lastFrameTimeNanos = j;
        this.finishedTimeNanos = Long.MIN_VALUE;
        this.isRunning$delegate = Platform.mutableStateOf$default(Boolean.TRUE);
    }

    public final void cancelAnimation() {
        this.isRunning$delegate.setValue(Boolean.FALSE);
        this.onCancel.invoke();
    }

    public final T getValue() {
        return this.value$delegate.getValue();
    }
}
