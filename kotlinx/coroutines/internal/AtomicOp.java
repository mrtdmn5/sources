package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: Atomic.kt */
/* loaded from: classes4.dex */
public abstract class AtomicOp<T> extends OpDescriptor {
    public static final AtomicReferenceFieldUpdater _consensus$FU = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    private volatile Object _consensus = AtomicKt.NO_DECISION;

    public abstract void complete(T t, Object obj);

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:            r1 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:            if (r1 == false) goto L15;     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:            r1 = r3;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:            r1 = r0.get(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001b, code lost:            r1 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:            if (r1 != r2) goto L16;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:            if (r0.compareAndSet(r4, r2, r3) == false) goto L10;     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:            if (r0.get(r4) == r2) goto L20;     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.OpDescriptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object perform(java.lang.Object r5) {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.internal.AtomicOp._consensus$FU
            java.lang.Object r1 = r0.get(r4)
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.internal.AtomicKt.NO_DECISION
            if (r1 != r2) goto L2c
            kotlinx.coroutines.internal.Symbol r3 = r4.prepare(r5)
            java.lang.Object r1 = r0.get(r4)
            if (r1 == r2) goto L15
            goto L2c
        L15:
            boolean r1 = r0.compareAndSet(r4, r2, r3)
            if (r1 == 0) goto L1d
            r1 = 1
            goto L24
        L1d:
            java.lang.Object r1 = r0.get(r4)
            if (r1 == r2) goto L15
            r1 = 0
        L24:
            if (r1 == 0) goto L28
            r1 = r3
            goto L2c
        L28:
            java.lang.Object r1 = r0.get(r4)
        L2c:
            r4.complete(r5, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.AtomicOp.perform(java.lang.Object):java.lang.Object");
    }

    public abstract Symbol prepare(Object obj);
}
