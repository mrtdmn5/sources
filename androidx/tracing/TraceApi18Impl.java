package androidx.tracing;

import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.InternalPointerEvent;
import androidx.compose.ui.input.pointer.PointerEvent;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class TraceApi18Impl {
    /* renamed from: toMotionEventScope-ubNVwUQ, reason: not valid java name */
    public static final void m612toMotionEventScopeubNVwUQ(PointerEvent pointerEvent, long j, Function1 function1, boolean z) {
        MotionEvent motionEvent;
        InternalPointerEvent internalPointerEvent = pointerEvent.internalPointerEvent;
        if (internalPointerEvent != null) {
            motionEvent = internalPointerEvent.pointerInputEvent.motionEvent;
        } else {
            motionEvent = null;
        }
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if (z) {
                motionEvent.setAction(3);
            }
            motionEvent.offsetLocation(-Offset.m259getXimpl(j), -Offset.m260getYimpl(j));
            function1.invoke(motionEvent);
            motionEvent.offsetLocation(Offset.m259getXimpl(j), Offset.m260getYimpl(j));
            motionEvent.setAction(action);
            return;
        }
        throw new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.".toString());
    }
}
