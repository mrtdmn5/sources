package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;

/* compiled from: PointerEvent.android.kt */
/* loaded from: classes.dex */
public final class PointerEvent {
    public final List<PointerInputChange> changes;
    public final InternalPointerEvent internalPointerEvent;
    public int type;

    public PointerEvent(List<PointerInputChange> list, InternalPointerEvent internalPointerEvent) {
        this.changes = list;
        this.internalPointerEvent = internalPointerEvent;
        MotionEvent motionEvent = internalPointerEvent != null ? internalPointerEvent.pointerInputEvent.motionEvent : null;
        int r2 = 0;
        if (motionEvent != null) {
            motionEvent.getButtonState();
        }
        MotionEvent motionEvent2 = internalPointerEvent != null ? internalPointerEvent.pointerInputEvent.motionEvent : null;
        if (motionEvent2 != null) {
            motionEvent2.getMetaState();
        }
        MotionEvent motionEvent3 = internalPointerEvent != null ? internalPointerEvent.pointerInputEvent.motionEvent : null;
        int r8 = 1;
        if (motionEvent3 != null) {
            int actionMasked = motionEvent3.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        switch (actionMasked) {
                            case 8:
                                r2 = 6;
                                break;
                            case 9:
                                r2 = 4;
                                break;
                            case 10:
                                r2 = 5;
                                break;
                        }
                        r8 = r2;
                    }
                    r2 = 3;
                    r8 = r2;
                }
                r2 = 2;
                r8 = r2;
            }
            r2 = 1;
            r8 = r2;
        } else {
            int size = list.size();
            while (true) {
                if (r2 >= size) {
                    r8 = 3;
                    break;
                }
                PointerInputChange pointerInputChange = list.get(r2);
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    r8 = 2;
                    break;
                } else if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
                    break;
                } else {
                    r2++;
                }
            }
        }
        this.type = r8;
    }

    public PointerEvent(List<PointerInputChange> list) {
        this(list, null);
    }
}
