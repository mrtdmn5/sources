package kotlinx.coroutines.internal;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;

/* compiled from: LimitedDispatcher.kt */
/* loaded from: classes4.dex */
public final class LimitedDispatcherKt {
    public static final void checkParallelism(int r1) {
        boolean z = true;
        if (r1 < 1) {
            z = false;
        }
        if (z) {
        } else {
            throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Expected positive parallelism level, but got ", r1).toString());
        }
    }
}
