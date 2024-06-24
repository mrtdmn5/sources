package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: BufferedChannel.kt */
/* loaded from: classes4.dex */
public final class ChannelSegment<E> extends Segment<ChannelSegment<E>> {
    public final BufferedChannel<E> _channel;
    public final AtomicReferenceArray data;

    public ChannelSegment(long j, ChannelSegment<E> channelSegment, BufferedChannel<E> bufferedChannel, int r5) {
        super(j, channelSegment, r5);
        this._channel = bufferedChannel;
        this.data = new AtomicReferenceArray(BufferedChannelKt.SEGMENT_SIZE * 2);
    }

    public final boolean casState$kotlinx_coroutines_core(Object obj, int r5, Object obj2) {
        AtomicReferenceArray atomicReferenceArray = this.data;
        int r52 = (r5 * 2) + 1;
        while (!atomicReferenceArray.compareAndSet(r52, obj, obj2)) {
            if (atomicReferenceArray.get(r52) != obj) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final int getNumberOfSlots() {
        return BufferedChannelKt.SEGMENT_SIZE;
    }

    public final Object getState$kotlinx_coroutines_core(int r2) {
        return this.data.get((r2 * 2) + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x005b, code lost:            setElementLazy(r7, null);     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x005e, code lost:            if (r1 == false) goto L134;     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0060, code lost:            kotlin.jvm.internal.Intrinsics.checkNotNull(r4);        r7 = r4.onUndeliveredElement;     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0065, code lost:            if (r7 == null) goto L135;     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0067, code lost:            kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(r7, r0, r8);     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x006a, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:            return;     */
    @Override // kotlinx.coroutines.internal.Segment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCancellation(int r7, kotlin.coroutines.CoroutineContext r8) {
        /*
            r6 = this;
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            if (r7 < r0) goto L6
            r1 = 1
            goto L7
        L6:
            r1 = 0
        L7:
            if (r1 == 0) goto La
            int r7 = r7 - r0
        La:
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r6.data
            int r2 = r7 * 2
            java.lang.Object r0 = r0.get(r2)
        L12:
            java.lang.Object r2 = r6.getState$kotlinx_coroutines_core(r7)
            boolean r3 = r2 instanceof kotlinx.coroutines.Waiter
            kotlinx.coroutines.channels.BufferedChannel<E> r4 = r6._channel
            r5 = 0
            if (r3 != 0) goto L6b
            boolean r3 = r2 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r3 == 0) goto L22
            goto L6b
        L22:
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND
            if (r2 == r3) goto L5b
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV
            if (r2 != r3) goto L2b
            goto L5b
        L2b:
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB
            if (r2 == r3) goto L12
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_RCV
            if (r2 != r3) goto L34
            goto L12
        L34:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV
            if (r2 == r7) goto L5a
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED
            if (r2 != r7) goto L3d
            goto L5a
        L3d:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.CHANNEL_CLOSED
            if (r2 != r7) goto L42
            return
        L42:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "unexpected state: "
            r8.<init>(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L5a:
            return
        L5b:
            r6.setElementLazy(r7, r5)
            if (r1 == 0) goto L6a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r7 = r4.onUndeliveredElement
            if (r7 == 0) goto L6a
            kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(r7, r0, r8)
        L6a:
            return
        L6b:
            if (r1 == 0) goto L70
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND
            goto L72
        L70:
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV
        L72:
            boolean r2 = r6.casState$kotlinx_coroutines_core(r2, r7, r3)
            if (r2 == 0) goto L12
            r6.setElementLazy(r7, r5)
            r2 = r1 ^ 1
            r6.onCancelledRequest(r7, r2)
            if (r1 == 0) goto L8c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r7 = r4.onUndeliveredElement
            if (r7 == 0) goto L8c
            kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(r7, r0, r8)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelSegment.onCancellation(int, kotlin.coroutines.CoroutineContext):void");
    }

    public final void onCancelledRequest(int r5, boolean z) {
        if (z) {
            BufferedChannel<E> bufferedChannel = this._channel;
            Intrinsics.checkNotNull(bufferedChannel);
            bufferedChannel.waitExpandBufferCompletion$kotlinx_coroutines_core((this.id * BufferedChannelKt.SEGMENT_SIZE) + r5);
        }
        onSlotCleaned();
    }

    public final void setElementLazy(int r2, Object obj) {
        this.data.lazySet(r2 * 2, obj);
    }

    public final void setState$kotlinx_coroutines_core(int r2, Symbol symbol) {
        this.data.set((r2 * 2) + 1, symbol);
    }
}
