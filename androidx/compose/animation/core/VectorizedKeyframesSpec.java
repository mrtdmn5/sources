package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import com.google.android.gms.common.zzy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: VectorizedAnimationSpec.kt */
/* loaded from: classes.dex */
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public final int delayMillis = 0;
    public final int durationMillis;
    public final Map<Integer, Pair<V, Easing>> keyframes;
    public V valueVector;
    public V velocityVector;

    public VectorizedKeyframesSpec(LinkedHashMap linkedHashMap, int r2) {
        this.keyframes = linkedHashMap;
        this.durationMillis = r2;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public final int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public final int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final V getValueFromNanos(long j, V initialValue, V targetValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        int coerceIn = (int) RangesKt___RangesKt.coerceIn((j / 1000000) - getDelayMillis(), 0L, getDurationMillis());
        Integer valueOf = Integer.valueOf(coerceIn);
        Map<Integer, Pair<V, Easing>> map = this.keyframes;
        if (map.containsKey(valueOf)) {
            return (V) ((Pair) MapsKt__MapsKt.getValue(Integer.valueOf(coerceIn), map)).first;
        }
        int r10 = this.durationMillis;
        if (coerceIn >= r10) {
            return targetValue;
        }
        if (coerceIn <= 0) {
            return initialValue;
        }
        Easing easing = EasingKt.LinearEasing;
        V v = initialValue;
        int r2 = 0;
        for (Map.Entry<Integer, Pair<V, Easing>> entry : map.entrySet()) {
            int intValue = entry.getKey().intValue();
            Pair<V, Easing> value = entry.getValue();
            if (coerceIn > intValue && intValue >= r2) {
                v = value.first;
                easing = value.second;
                r2 = intValue;
            } else if (coerceIn < intValue && intValue <= r10) {
                targetValue = value.first;
                r10 = intValue;
            }
        }
        float transform = easing.transform((coerceIn - r2) / (r10 - r2));
        if (this.valueVector == null) {
            this.valueVector = (V) zzy.newInstance(initialValue);
            this.velocityVector = (V) zzy.newInstance(initialValue);
        }
        int size$animation_core_release = v.getSize$animation_core_release();
        for (int r1 = 0; r1 < size$animation_core_release; r1++) {
            V v2 = this.valueVector;
            if (v2 != null) {
                float f = v.get$animation_core_release(r1);
                float f2 = targetValue.get$animation_core_release(r1);
                TwoWayConverterImpl twoWayConverterImpl = VectorConvertersKt.FloatToVector;
                v2.set$animation_core_release((f2 * transform) + ((1 - transform) * f), r1);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                throw null;
            }
        }
        V v3 = this.valueVector;
        if (v3 != null) {
            return v3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        throw null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public final V getVelocityFromNanos(long j, V initialValue, V targetValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        long coerceIn = RangesKt___RangesKt.coerceIn((j / 1000000) - getDelayMillis(), 0L, getDurationMillis());
        if (coerceIn <= 0) {
            return initialVelocity;
        }
        AnimationVector valueFromMillis = MessageFormatter.getValueFromMillis(this, coerceIn - 1, initialValue, targetValue, initialVelocity);
        AnimationVector valueFromMillis2 = MessageFormatter.getValueFromMillis(this, coerceIn, initialValue, targetValue, initialVelocity);
        if (this.valueVector == null) {
            this.valueVector = (V) zzy.newInstance(initialValue);
            this.velocityVector = (V) zzy.newInstance(initialValue);
        }
        int size$animation_core_release = valueFromMillis.getSize$animation_core_release();
        for (int r2 = 0; r2 < size$animation_core_release; r2++) {
            V v = this.velocityVector;
            if (v != null) {
                v.set$animation_core_release((valueFromMillis.get$animation_core_release(r2) - valueFromMillis2.get$animation_core_release(r2)) * 1000.0f, r2);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                throw null;
            }
        }
        V v2 = this.velocityVector;
        if (v2 != null) {
            return v2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        throw null;
    }
}
