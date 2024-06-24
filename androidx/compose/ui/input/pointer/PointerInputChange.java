package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerEvent.kt */
/* loaded from: classes.dex */
public final class PointerInputChange {
    public final List<HistoricalChange> _historical;
    public ConsumedData consumed;
    public final long id;
    public final long position;
    public final boolean pressed;
    public final float pressure;
    public final long previousPosition;
    public final boolean previousPressed;
    public final long previousUptimeMillis;
    public final long scrollDelta;
    public final int type;
    public final long uptimeMillis;

    public PointerInputChange() {
        throw null;
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, int r34, List historical, long j6) {
        this(j, j2, j3, z, f, j4, j5, z2, false, r34, j6);
        Intrinsics.checkNotNullParameter(historical, "historical");
        this._historical = historical;
    }

    public final void consume() {
        ConsumedData consumedData = this.consumed;
        consumedData.downChange = true;
        consumedData.positionChange = true;
    }

    public final boolean isConsumed() {
        ConsumedData consumedData = this.consumed;
        if (!consumedData.downChange && !consumedData.positionChange) {
            return false;
        }
        return true;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("PointerInputChange(id=");
        sb.append((Object) PointerId.m414toStringimpl(this.id));
        sb.append(", uptimeMillis=");
        sb.append(this.uptimeMillis);
        sb.append(", position=");
        sb.append((Object) Offset.m264toStringimpl(this.position));
        sb.append(", pressed=");
        sb.append(this.pressed);
        sb.append(", pressure=");
        sb.append(this.pressure);
        sb.append(", previousUptimeMillis=");
        sb.append(this.previousUptimeMillis);
        sb.append(", previousPosition=");
        sb.append((Object) Offset.m264toStringimpl(this.previousPosition));
        sb.append(", previousPressed=");
        sb.append(this.previousPressed);
        sb.append(", isConsumed=");
        sb.append(isConsumed());
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
        sb.append(", historical=");
        Object obj = this._historical;
        if (obj == null) {
            obj = EmptyList.INSTANCE;
        }
        sb.append(obj);
        sb.append(",scrollDelta=");
        sb.append((Object) Offset.m264toStringimpl(this.scrollDelta));
        sb.append(')');
        return sb.toString();
    }

    public PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int r18, long j6) {
        this.id = j;
        this.uptimeMillis = j2;
        this.position = j3;
        this.pressed = z;
        this.pressure = f;
        this.previousUptimeMillis = j4;
        this.previousPosition = j5;
        this.previousPressed = z2;
        this.type = r18;
        this.scrollDelta = j6;
        this.consumed = new ConsumedData(z3, z3);
    }
}
