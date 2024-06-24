package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.SelectInstance;

/* compiled from: BufferedChannel.kt */
/* loaded from: classes4.dex */
public /* synthetic */ class BufferedChannel$onReceiveCatching$1 extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, SelectInstance<?>, Object, Unit> {
    public static final BufferedChannel$onReceiveCatching$1 INSTANCE = new BufferedChannel$onReceiveCatching$1();

    public BufferedChannel$onReceiveCatching$1() {
        super(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:            return kotlin.Unit.INSTANCE;     */
    @Override // kotlin.jvm.functions.Function3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.Unit invoke(kotlinx.coroutines.channels.BufferedChannel<?> r10, kotlinx.coroutines.selects.SelectInstance<?> r11, java.lang.Object r12) {
        /*
            r9 = this;
            kotlinx.coroutines.channels.BufferedChannel r10 = (kotlinx.coroutines.channels.BufferedChannel) r10
            kotlinx.coroutines.selects.SelectInstance r11 = (kotlinx.coroutines.selects.SelectInstance) r11
            java.util.concurrent.atomic.AtomicLongFieldUpdater r12 = kotlinx.coroutines.channels.BufferedChannel.sendersAndCloseStatus$FU
            r10.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = kotlinx.coroutines.channels.BufferedChannel.receiveSegment$FU
            java.lang.Object r12 = r12.get(r10)
            kotlinx.coroutines.channels.ChannelSegment r12 = (kotlinx.coroutines.channels.ChannelSegment) r12
        L11:
            boolean r0 = r10.isClosedForReceive()
            if (r0 == 0) goto L1d
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.channels.BufferedChannelKt.CHANNEL_CLOSED
            r11.selectInRegistrationPhase(r10)
            goto L6e
        L1d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.channels.BufferedChannel.receivers$FU
            long r6 = r0.getAndIncrement(r10)
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r0 = (long) r0
            long r2 = r6 / r0
            long r0 = r6 % r0
            int r8 = (int) r0
            long r0 = r12.id
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L39
            kotlinx.coroutines.channels.ChannelSegment r0 = r10.findSegmentReceive(r2, r12)
            if (r0 != 0) goto L38
            goto L11
        L38:
            r12 = r0
        L39:
            r0 = r10
            r1 = r12
            r2 = r8
            r3 = r6
            r5 = r11
            java.lang.Object r0 = r0.updateCellReceive(r1, r2, r3, r5)
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND
            if (r0 != r1) goto L54
            boolean r10 = r11 instanceof kotlinx.coroutines.Waiter
            if (r10 == 0) goto L4d
            kotlinx.coroutines.Waiter r11 = (kotlinx.coroutines.Waiter) r11
            goto L4e
        L4d:
            r11 = 0
        L4e:
            if (r11 == 0) goto L6e
            r11.invokeOnCancellation(r12, r8)
            goto L6e
        L54:
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED
            if (r0 != r1) goto L64
            long r0 = r10.getSendersCounter$kotlinx_coroutines_core()
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 >= 0) goto L11
            r12.cleanPrev()
            goto L11
        L64:
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER
            if (r0 == r10) goto L71
            r12.cleanPrev()
            r11.selectInRegistrationPhase(r0)
        L6e:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L71:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "unexpected"
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel$onReceiveCatching$1.invoke(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
