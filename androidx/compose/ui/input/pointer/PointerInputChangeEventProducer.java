package androidx.compose.ui.input.pointer;

import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerInputEventProcessor.kt */
/* loaded from: classes.dex */
public final class PointerInputChangeEventProducer {
    public final LinkedHashMap previousPointerInputData = new LinkedHashMap();

    /* compiled from: PointerInputEventProcessor.kt */
    /* loaded from: classes.dex */
    public static final class PointerInputData {
        public final boolean down;
        public final long positionOnScreen;
        public final long uptime;

        public PointerInputData(long j, long j2, boolean z) {
            this.uptime = j;
            this.positionOnScreen = j2;
            this.down = z;
        }
    }

    public final InternalPointerEvent produce(PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator) {
        boolean z;
        long j;
        long j2;
        int r17;
        Intrinsics.checkNotNullParameter(positionCalculator, "positionCalculator");
        List<PointerInputEventData> list = pointerInputEvent.pointers;
        LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
        int size = list.size();
        int r6 = 0;
        while (r6 < size) {
            PointerInputEventData pointerInputEventData = list.get(r6);
            LinkedHashMap linkedHashMap2 = this.previousPointerInputData;
            PointerInputData pointerInputData = (PointerInputData) linkedHashMap2.get(new PointerId(pointerInputEventData.id));
            if (pointerInputData == null) {
                j2 = pointerInputEventData.uptime;
                j = pointerInputEventData.position;
                z = false;
            } else {
                long mo419screenToLocalMKHz9U = positionCalculator.mo419screenToLocalMKHz9U(pointerInputData.positionOnScreen);
                long j3 = pointerInputData.uptime;
                z = pointerInputData.down;
                j = mo419screenToLocalMKHz9U;
                j2 = j3;
            }
            long j4 = pointerInputEventData.id;
            linkedHashMap.put(new PointerId(j4), new PointerInputChange(j4, pointerInputEventData.uptime, pointerInputEventData.position, pointerInputEventData.down, pointerInputEventData.pressure, j2, j, z, pointerInputEventData.type, pointerInputEventData.historical, pointerInputEventData.scrollDelta));
            boolean z2 = pointerInputEventData.down;
            long j5 = pointerInputEventData.id;
            if (z2) {
                r17 = r6;
                linkedHashMap2.put(new PointerId(j5), new PointerInputData(pointerInputEventData.uptime, pointerInputEventData.positionOnScreen, z2));
            } else {
                r17 = r6;
                linkedHashMap2.remove(new PointerId(j5));
            }
            r6 = r17 + 1;
        }
        return new InternalPointerEvent(linkedHashMap, pointerInputEvent);
    }
}
