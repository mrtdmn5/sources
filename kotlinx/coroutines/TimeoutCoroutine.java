package kotlinx.coroutines;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* compiled from: Timeout.kt */
/* loaded from: classes4.dex */
public final class TimeoutCoroutine<U, T extends U> extends ScopeCoroutine<T> implements Runnable {
    public final long time;

    public TimeoutCoroutine(long j, Continuation<? super U> continuation) {
        super(continuation, continuation.getContext());
        this.time = j;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.JobSupport
    public final String nameString$kotlinx_coroutines_core() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.nameString$kotlinx_coroutines_core());
        sb.append("(timeMillis=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.time, ')');
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:            if (r0 == null) goto L10;     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r4 = this;
            kotlin.coroutines.CoroutineContext r0 = r4.context
            kotlinx.coroutines.Delay r0 = kotlinx.coroutines.DelayKt.getDelay(r0)
            boolean r1 = r0 instanceof kotlinx.coroutines.DelayWithTimeoutDiagnostics
            if (r1 == 0) goto Ld
            kotlinx.coroutines.DelayWithTimeoutDiagnostics r0 = (kotlinx.coroutines.DelayWithTimeoutDiagnostics) r0
            goto Le
        Ld:
            r0 = 0
        Le:
            long r1 = r4.time
            if (r0 == 0) goto L1f
            int r3 = kotlin.time.Duration.$r8$clinit
            kotlin.time.DurationUnit r3 = kotlin.time.DurationUnit.MILLISECONDS
            kotlin.time.DurationKt.toDuration(r1, r3)
            java.lang.String r0 = r0.m1696timeoutMessageLRDsOJo()
            if (r0 != 0) goto L32
        L1f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Timed out waiting for "
            r0.<init>(r3)
            r0.append(r1)
            java.lang.String r1 = " ms"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L32:
            kotlinx.coroutines.TimeoutCancellationException r1 = new kotlinx.coroutines.TimeoutCancellationException
            r1.<init>(r0, r4)
            r4.cancelImpl$kotlinx_coroutines_core(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutCoroutine.run():void");
    }
}
