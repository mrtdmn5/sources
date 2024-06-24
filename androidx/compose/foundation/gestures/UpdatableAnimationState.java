package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedSpringSpec;

/* compiled from: UpdatableAnimationState.kt */
/* loaded from: classes.dex */
public final class UpdatableAnimationState {
    public boolean isRunning;
    public long lastFrameTime = Long.MIN_VALUE;
    public AnimationVector1D lastVelocity = ZeroVector;
    public float value;
    public static final AnimationVector1D ZeroVector = new AnimationVector1D(0.0f);
    public static final VectorizedSpringSpec<AnimationVector1D> RebasableAnimationSpec = AnimationSpecKt.spring$default(0.0f, null, 7).vectorize((TwoWayConverter) VectorConvertersKt.FloatToVector);

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ba, code lost:            if (r13 == false) goto L31;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Type inference failed for: r12v6, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r13v15, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00ad -> B:29:0x00b0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object animateToZero(androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1.AnonymousClass1.C00041 r18, androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1.AnonymousClass1.AnonymousClass2 r19, kotlin.coroutines.Continuation r20) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.UpdatableAnimationState.animateToZero(androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1$1, androidx.compose.foundation.gestures.ContentInViewModifier$launchAnimation$1$1$2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
