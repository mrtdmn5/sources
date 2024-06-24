package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerEvent.kt */
/* loaded from: classes.dex */
public final class PointerEventKt {
    public static final boolean changedToDownIgnoreConsumed(PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        if (!pointerInputChange.previousPressed && pointerInputChange.pressed) {
            return true;
        }
        return false;
    }

    public static final boolean changedToUp(PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        if (!pointerInputChange.isConsumed() && pointerInputChange.previousPressed && !pointerInputChange.pressed) {
            return true;
        }
        return false;
    }

    public static final boolean changedToUpIgnoreConsumed(PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        if (pointerInputChange.previousPressed && !pointerInputChange.pressed) {
            return true;
        }
        return false;
    }

    /* renamed from: isOutOfBounds-O0kMr_c, reason: not valid java name */
    public static final boolean m411isOutOfBoundsO0kMr_c(PointerInputChange pointerInputChange, long j) {
        long j2 = pointerInputChange.position;
        float m259getXimpl = Offset.m259getXimpl(j2);
        float m260getYimpl = Offset.m260getYimpl(j2);
        int r1 = (int) (j >> 32);
        int m593getHeightimpl = IntSize.m593getHeightimpl(j);
        if (m259getXimpl >= 0.0f && m259getXimpl <= r1 && m260getYimpl >= 0.0f && m260getYimpl <= m593getHeightimpl) {
            return false;
        }
        return true;
    }

    /* renamed from: isOutOfBounds-jwHxaWs, reason: not valid java name */
    public static final boolean m412isOutOfBoundsjwHxaWs(PointerInputChange pointerInputChange, long j, long j2) {
        boolean z;
        if (pointerInputChange.type == 1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return m411isOutOfBoundsO0kMr_c(pointerInputChange, j);
        }
        long j3 = pointerInputChange.position;
        float m259getXimpl = Offset.m259getXimpl(j3);
        float m260getYimpl = Offset.m260getYimpl(j3);
        float f = -Size.m276getWidthimpl(j2);
        float m276getWidthimpl = Size.m276getWidthimpl(j2) + ((int) (j >> 32));
        float f2 = -Size.m274getHeightimpl(j2);
        float m274getHeightimpl = Size.m274getHeightimpl(j2) + IntSize.m593getHeightimpl(j);
        if (m259getXimpl >= f && m259getXimpl <= m276getWidthimpl && m260getYimpl >= f2 && m260getYimpl <= m274getHeightimpl) {
            return false;
        }
        return true;
    }

    public static final long positionChangeInternal(PointerInputChange pointerInputChange, boolean z) {
        long m261minusMKHz9U = Offset.m261minusMKHz9U(pointerInputChange.position, pointerInputChange.previousPosition);
        if (!z && pointerInputChange.isConsumed()) {
            int r4 = Offset.$r8$clinit;
            return Offset.Zero;
        }
        return m261minusMKHz9U;
    }
}
