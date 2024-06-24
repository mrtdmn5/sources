package androidx.compose.animation.core;

import androidx.compose.animation.core.KeyframesSpec;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationSpec.kt */
/* loaded from: classes.dex */
public final class AnimationSpecKt {
    /* renamed from: infiniteRepeatable-9IiC70o$default, reason: not valid java name */
    public static InfiniteRepeatableSpec m10infiniteRepeatable9IiC70o$default(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, int r4) {
        long j;
        if ((r4 & 2) != 0) {
            repeatMode = RepeatMode.Restart;
        }
        if ((r4 & 4) != 0) {
            j = 0;
        } else {
            j = 0;
        }
        Intrinsics.checkNotNullParameter(repeatMode, "repeatMode");
        return new InfiniteRepeatableSpec(durationBasedAnimationSpec, repeatMode, j);
    }

    public static final <T> KeyframesSpec<T> keyframes(Function1<? super KeyframesSpec.KeyframesSpecConfig<T>, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig = new KeyframesSpec.KeyframesSpecConfig();
        init.invoke(keyframesSpecConfig);
        return new KeyframesSpec<>(keyframesSpecConfig);
    }

    public static SpringSpec spring$default(float f, Object obj, int r4) {
        float f2;
        if ((r4 & 1) != 0) {
            f2 = 1.0f;
        } else {
            f2 = 0.0f;
        }
        if ((r4 & 2) != 0) {
            f = 1500.0f;
        }
        if ((r4 & 4) != 0) {
            obj = null;
        }
        return new SpringSpec(f2, f, obj);
    }

    public static final <T> TweenSpec<T> tween(int r1, int r2, Easing easing) {
        Intrinsics.checkNotNullParameter(easing, "easing");
        return new TweenSpec<>(r1, r2, easing);
    }

    public static TweenSpec tween$default(int r1, int r2, Easing easing, int r4) {
        if ((r4 & 1) != 0) {
            r1 = TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY;
        }
        if ((r4 & 2) != 0) {
            r2 = 0;
        }
        if ((r4 & 4) != 0) {
            easing = EasingKt.FastOutSlowInEasing;
        }
        return tween(r1, r2, easing);
    }
}
