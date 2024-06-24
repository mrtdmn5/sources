package okio;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Timeout.kt */
/* loaded from: classes4.dex */
public final class Timeout$Companion$NONE$1 extends Timeout {
    @Override // okio.Timeout
    public final Timeout timeout(long j, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this;
    }

    @Override // okio.Timeout
    public final void throwIfReached() {
    }

    @Override // okio.Timeout
    public final Timeout deadlineNanoTime(long j) {
        return this;
    }
}
