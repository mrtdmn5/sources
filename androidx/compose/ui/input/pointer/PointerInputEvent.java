package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerInputEvent.android.kt */
/* loaded from: classes.dex */
public final class PointerInputEvent {
    public final MotionEvent motionEvent;
    public final List<PointerInputEventData> pointers;

    public PointerInputEvent(ArrayList pointers, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(pointers, "pointers");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        this.pointers = pointers;
        this.motionEvent = motionEvent;
    }
}
