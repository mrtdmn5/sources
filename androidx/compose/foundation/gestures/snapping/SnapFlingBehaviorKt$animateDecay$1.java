package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationState;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref$FloatRef;

/* compiled from: SnapFlingBehavior.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", l = {362}, m = "animateDecay")
/* loaded from: classes.dex */
public final class SnapFlingBehaviorKt$animateDecay$1 extends ContinuationImpl {
    public float F$0;
    public AnimationState L$0;
    public Ref$FloatRef L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SnapFlingBehaviorKt.access$animateDecay(null, 0.0f, null, null, null, this);
    }
}
