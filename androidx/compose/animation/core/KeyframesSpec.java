package androidx.compose.animation.core;

import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationSpec.kt */
/* loaded from: classes.dex */
public final class KeyframesSpec<T> implements DurationBasedAnimationSpec<T> {
    public final KeyframesSpecConfig<T> config;

    /* compiled from: AnimationSpec.kt */
    /* loaded from: classes.dex */
    public static final class KeyframeEntity<T> {
        public Easing easing;
        public final T value;

        public KeyframeEntity() {
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public KeyframeEntity(Float f) {
            EasingKt$LinearEasing$1 easing = EasingKt.LinearEasing;
            Intrinsics.checkNotNullParameter(easing, "easing");
            this.value = f;
            this.easing = easing;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof KeyframeEntity) {
                KeyframeEntity keyframeEntity = (KeyframeEntity) obj;
                if (Intrinsics.areEqual(keyframeEntity.value, this.value) && Intrinsics.areEqual(keyframeEntity.easing, this.easing)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            int r0;
            T t = this.value;
            if (t != null) {
                r0 = t.hashCode();
            } else {
                r0 = 0;
            }
            return this.easing.hashCode() + (r0 * 31);
        }
    }

    /* compiled from: AnimationSpec.kt */
    /* loaded from: classes.dex */
    public static final class KeyframesSpecConfig<T> {
        public int durationMillis = TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY;
        public final LinkedHashMap keyframes = new LinkedHashMap();

        public final KeyframeEntity at(int r2, Float f) {
            KeyframeEntity keyframeEntity = new KeyframeEntity(f);
            this.keyframes.put(Integer.valueOf(r2), keyframeEntity);
            return keyframeEntity;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof KeyframesSpecConfig) {
                KeyframesSpecConfig keyframesSpecConfig = (KeyframesSpecConfig) obj;
                keyframesSpecConfig.getClass();
                if (this.durationMillis == keyframesSpecConfig.durationMillis && Intrinsics.areEqual(this.keyframes, keyframesSpecConfig.keyframes)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.keyframes.hashCode() + (((this.durationMillis * 31) + 0) * 31);
        }
    }

    public KeyframesSpec(KeyframesSpecConfig<T> keyframesSpecConfig) {
        this.config = keyframesSpecConfig;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof KeyframesSpec) {
            if (Intrinsics.areEqual(this.config, ((KeyframesSpec) obj).config)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.config.hashCode();
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public final <V extends AnimationVector> VectorizedKeyframesSpec<V> vectorize(TwoWayConverter<T, V> converter) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        KeyframesSpecConfig<T> keyframesSpecConfig = this.config;
        LinkedHashMap linkedHashMap = keyframesSpecConfig.keyframes;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            KeyframeEntity keyframeEntity = (KeyframeEntity) entry.getValue();
            Function1<T, V> convertToVector = converter.getConvertToVector();
            keyframeEntity.getClass();
            Intrinsics.checkNotNullParameter(convertToVector, "convertToVector");
            linkedHashMap2.put(key, new Pair(convertToVector.invoke(keyframeEntity.value), keyframeEntity.easing));
        }
        return new VectorizedKeyframesSpec<>(linkedHashMap2, keyframesSpecConfig.durationMillis);
    }
}
