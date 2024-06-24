package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ScrollingLogic$dispatchScroll$performScroll$1;
import androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1;
import androidx.compose.ui.Modifier;
import kotlin.coroutines.Continuation;

/* compiled from: Overscroll.kt */
/* loaded from: classes.dex */
public interface OverscrollEffect {
    /* renamed from: applyToFling-BMRW4eQ */
    Object mo15applyToFlingBMRW4eQ(long j, ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1, Continuation continuation);

    /* renamed from: applyToScroll-Rhakbz0 */
    long mo16applyToScrollRhakbz0(long j, int r3, ScrollingLogic$dispatchScroll$performScroll$1 scrollingLogic$dispatchScroll$performScroll$1);

    Modifier getEffectModifier();

    boolean isInProgress();
}
