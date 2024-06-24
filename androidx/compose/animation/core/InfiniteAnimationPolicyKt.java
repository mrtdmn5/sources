package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.platform.InfiniteAnimationPolicy;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;

/* compiled from: InfiniteAnimationPolicy.kt */
/* loaded from: classes.dex */
public final class InfiniteAnimationPolicyKt {
    public static final Object withInfiniteAnimationFrameNanos(Function1 function1, ContinuationImpl continuationImpl) {
        InfiniteAnimationPolicy infiniteAnimationPolicy = (InfiniteAnimationPolicy) continuationImpl.getContext().get(InfiniteAnimationPolicy.Key.$$INSTANCE);
        if (infiniteAnimationPolicy == null) {
            return MonotonicFrameClockKt.withFrameNanos(function1, continuationImpl);
        }
        new InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2(function1, null);
        return infiniteAnimationPolicy.onInfiniteOperation();
    }
}
