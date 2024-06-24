package androidx.compose.ui.input.pointer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: InternalPointerEvent.android.kt */
/* loaded from: classes.dex */
public final class InternalPointerEvent {
    public final Map<PointerId, PointerInputChange> changes;
    public final PointerInputEvent pointerInputEvent;
    public boolean suppressMovementConsumption;

    public InternalPointerEvent(LinkedHashMap linkedHashMap, PointerInputEvent pointerInputEvent) {
        this.changes = linkedHashMap;
        this.pointerInputEvent = pointerInputEvent;
    }

    /* renamed from: issuesEnterExitEvent-0FcD4WY, reason: not valid java name */
    public final boolean m409issuesEnterExitEvent0FcD4WY(long j) {
        PointerInputEventData pointerInputEventData;
        List<PointerInputEventData> list = this.pointerInputEvent.pointers;
        int size = list.size();
        int r3 = 0;
        while (true) {
            if (r3 < size) {
                pointerInputEventData = list.get(r3);
                if (PointerId.m413equalsimpl0(pointerInputEventData.id, j)) {
                    break;
                }
                r3++;
            } else {
                pointerInputEventData = null;
                break;
            }
        }
        PointerInputEventData pointerInputEventData2 = pointerInputEventData;
        if (pointerInputEventData2 == null) {
            return false;
        }
        return pointerInputEventData2.issuesEnterExit;
    }
}
