package androidx.lifecycle;

import java.util.ArrayDeque;

/* compiled from: DispatchQueue.kt */
/* loaded from: classes.dex */
public final class DispatchQueue {
    public boolean finished;
    public boolean isDraining;
    public boolean paused = true;
    public final ArrayDeque queue = new ArrayDeque();

    /* JADX WARN: Removed duplicated region for block: B:18:0x0021 A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:7:0x0007, B:9:0x000b, B:11:0x0012, B:13:0x0016, B:18:0x0021, B:21:0x0029), top: B:6:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0020 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void drainQueue() {
        /*
            r4 = this;
            boolean r0 = r4.isDraining
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r1 = 0
            r4.isDraining = r0     // Catch: java.lang.Throwable -> L30
        L9:
            java.util.ArrayDeque r2 = r4.queue
            boolean r3 = r2.isEmpty()     // Catch: java.lang.Throwable -> L30
            r3 = r3 ^ r0
            if (r3 == 0) goto L2d
            boolean r3 = r4.finished     // Catch: java.lang.Throwable -> L30
            if (r3 != 0) goto L1d
            boolean r3 = r4.paused     // Catch: java.lang.Throwable -> L30
            if (r3 != 0) goto L1b
            goto L1d
        L1b:
            r3 = r1
            goto L1e
        L1d:
            r3 = r0
        L1e:
            if (r3 != 0) goto L21
            goto L2d
        L21:
            java.lang.Object r2 = r2.poll()     // Catch: java.lang.Throwable -> L30
            java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch: java.lang.Throwable -> L30
            if (r2 == 0) goto L9
            r2.run()     // Catch: java.lang.Throwable -> L30
            goto L9
        L2d:
            r4.isDraining = r1
            return
        L30:
            r0 = move-exception
            r4.isDraining = r1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.DispatchQueue.drainQueue():void");
    }
}
