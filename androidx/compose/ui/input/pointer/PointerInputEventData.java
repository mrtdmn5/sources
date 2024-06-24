package androidx.compose.ui.input.pointer;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InternalPointerInput.kt */
/* loaded from: classes.dex */
public final class PointerInputEventData {
    public final boolean down;
    public final List<HistoricalChange> historical;
    public final long id;
    public final boolean issuesEnterExit;
    public final long position;
    public final long positionOnScreen;
    public final float pressure;
    public final long scrollDelta;
    public final int type;
    public final long uptime;

    public PointerInputEventData() {
        throw null;
    }

    public PointerInputEventData(long j, long j2, long j3, long j4, boolean z, float f, int r11, boolean z2, ArrayList arrayList, long j5) {
        this.id = j;
        this.uptime = j2;
        this.positionOnScreen = j3;
        this.position = j4;
        this.down = z;
        this.pressure = f;
        this.type = r11;
        this.issuesEnterExit = z2;
        this.historical = arrayList;
        this.scrollDelta = j5;
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointerInputEventData)) {
            return false;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        if (!PointerId.m413equalsimpl0(this.id, pointerInputEventData.id) || this.uptime != pointerInputEventData.uptime || !Offset.m257equalsimpl0(this.positionOnScreen, pointerInputEventData.positionOnScreen) || !Offset.m257equalsimpl0(this.position, pointerInputEventData.position) || this.down != pointerInputEventData.down || Float.compare(this.pressure, pointerInputEventData.pressure) != 0) {
            return false;
        }
        if (this.type == pointerInputEventData.type) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.issuesEnterExit == pointerInputEventData.issuesEnterExit && Intrinsics.areEqual(this.historical, pointerInputEventData.historical) && Offset.m257equalsimpl0(this.scrollDelta, pointerInputEventData.scrollDelta)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m = Scale$$ExternalSyntheticOutline0.m(this.uptime, Long.hashCode(this.id) * 31, 31);
        int r1 = Offset.$r8$clinit;
        int m2 = Scale$$ExternalSyntheticOutline0.m(this.position, Scale$$ExternalSyntheticOutline0.m(this.positionOnScreen, m, 31), 31);
        int r12 = 1;
        boolean z = this.down;
        int r2 = z;
        if (z != 0) {
            r2 = 1;
        }
        int m3 = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.type, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.pressure, (m2 + r2) * 31, 31), 31);
        boolean z2 = this.issuesEnterExit;
        if (!z2) {
            r12 = z2 ? 1 : 0;
        }
        return Long.hashCode(this.scrollDelta) + VectorGroup$$ExternalSyntheticOutline0.m(this.historical, (m3 + r12) * 31, 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("PointerInputEventData(id=");
        sb.append((Object) PointerId.m414toStringimpl(this.id));
        sb.append(", uptime=");
        sb.append(this.uptime);
        sb.append(", positionOnScreen=");
        sb.append((Object) Offset.m264toStringimpl(this.positionOnScreen));
        sb.append(", position=");
        sb.append((Object) Offset.m264toStringimpl(this.position));
        sb.append(", down=");
        sb.append(this.down);
        sb.append(", pressure=");
        sb.append(this.pressure);
        sb.append(", type=");
        int r2 = this.type;
        if (r2 != 1) {
            if (r2 != 2) {
                if (r2 != 3) {
                    if (r2 != 4) {
                        str = "Unknown";
                    } else {
                        str = "Eraser";
                    }
                } else {
                    str = "Stylus";
                }
            } else {
                str = "Mouse";
            }
        } else {
            str = "Touch";
        }
        sb.append((Object) str);
        sb.append(", issuesEnterExit=");
        sb.append(this.issuesEnterExit);
        sb.append(", historical=");
        sb.append(this.historical);
        sb.append(", scrollDelta=");
        sb.append((Object) Offset.m264toStringimpl(this.scrollDelta));
        sb.append(')');
        return sb.toString();
    }
}
