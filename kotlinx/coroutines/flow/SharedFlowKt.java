package kotlinx.coroutines.flow;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: SharedFlow.kt */
/* loaded from: classes4.dex */
public final class SharedFlowKt {
    public static final Symbol NO_VALUE = new Symbol("NO_VALUE");

    public static final SharedFlowImpl MutableSharedFlow(int r3, int r4, BufferOverflow bufferOverflow) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (r3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r4 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (r3 <= 0 && r4 <= 0 && bufferOverflow != BufferOverflow.SUSPEND) {
                    z3 = false;
                }
                if (z3) {
                    int r42 = r4 + r3;
                    if (r42 < 0) {
                        r42 = Integer.MAX_VALUE;
                    }
                    return new SharedFlowImpl(r3, r42, bufferOverflow);
                }
                throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + bufferOverflow).toString());
            }
            throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("extraBufferCapacity cannot be negative, but was ", r4).toString());
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("replay cannot be negative, but was ", r3).toString());
    }

    public static /* synthetic */ SharedFlowImpl MutableSharedFlow$default(int r2, int r3, BufferOverflow bufferOverflow, int r5) {
        if ((r5 & 1) != 0) {
            r2 = 0;
        }
        if ((r5 & 2) != 0) {
            r3 = 0;
        }
        if ((r5 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return MutableSharedFlow(r2, r3, bufferOverflow);
    }
}
