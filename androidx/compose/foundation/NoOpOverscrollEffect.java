package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ScrollingLogic$dispatchScroll$performScroll$1;
import androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* compiled from: Overscroll.kt */
/* loaded from: classes.dex */
public final class NoOpOverscrollEffect implements OverscrollEffect {
    public static final NoOpOverscrollEffect INSTANCE = new NoOpOverscrollEffect();

    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToFling-BMRW4eQ */
    public final Object mo15applyToFlingBMRW4eQ(long j, ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1, Continuation continuation) {
        Object invoke = scrollingLogic$onDragStopped$performFling$1.invoke(new Velocity(j), continuation);
        if (invoke == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return invoke;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToScroll-Rhakbz0 */
    public final long mo16applyToScrollRhakbz0(long j, int r3, ScrollingLogic$dispatchScroll$performScroll$1 scrollingLogic$dispatchScroll$performScroll$1) {
        return ((Offset) scrollingLogic$dispatchScroll$performScroll$1.invoke(new Offset(j))).packedValue;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public final Modifier getEffectModifier() {
        int r0 = Modifier.$r8$clinit;
        return Modifier.Companion.$$INSTANCE;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public final boolean isInProgress() {
        return false;
    }
}
