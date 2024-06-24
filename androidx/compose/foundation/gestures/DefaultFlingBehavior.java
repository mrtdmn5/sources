package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.MotionDurationScale;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: Scrollable.kt */
/* loaded from: classes.dex */
public final class DefaultFlingBehavior implements FlingBehavior {
    public final DecayAnimationSpec<Float> flingDecay;
    public final MotionDurationScale motionDurationScale;

    public DefaultFlingBehavior() {
        throw null;
    }

    public DefaultFlingBehavior(DecayAnimationSpec flingDecay) {
        ScrollableKt$DefaultScrollMotionDurationScale$1 motionDurationScale = ScrollableKt.DefaultScrollMotionDurationScale;
        Intrinsics.checkNotNullParameter(flingDecay, "flingDecay");
        Intrinsics.checkNotNullParameter(motionDurationScale, "motionDurationScale");
        this.flingDecay = flingDecay;
        this.motionDurationScale = motionDurationScale;
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public final Object performFling(ScrollingLogic$doFlingAnimation$2$scope$1 scrollingLogic$doFlingAnimation$2$scope$1, float f, Continuation continuation) {
        return BuildersKt.withContext(this.motionDurationScale, new DefaultFlingBehavior$performFling$2(f, this, scrollingLogic$doFlingAnimation$2$scope$1, null), continuation);
    }
}
