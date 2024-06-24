package kotlinx.coroutines.sync;

import androidx.core.content.res.CamUtils;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: Semaphore.kt */
/* loaded from: classes4.dex */
public final class SemaphoreKt {
    public static final int MAX_SPIN_CYCLES = CamUtils.systemProp$default("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12);
    public static final Symbol PERMIT = new Symbol("PERMIT");
    public static final Symbol TAKEN = new Symbol("TAKEN");
    public static final Symbol BROKEN = new Symbol("BROKEN");
    public static final Symbol CANCELLED = new Symbol("CANCELLED");
    public static final int SEGMENT_SIZE = CamUtils.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12);
}
