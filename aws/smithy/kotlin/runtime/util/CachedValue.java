package aws.smithy.kotlin.runtime.util;

import aws.smithy.kotlin.runtime.time.Clock;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.sync.SemaphoreImpl;
import kotlinx.coroutines.sync.SemaphoreKt;

/* compiled from: CachedValue.kt */
/* loaded from: classes.dex */
public final class CachedValue<T> implements Closeable {
    public static final /* synthetic */ AtomicReferenceFieldUpdater _ref$FU = AtomicReferenceFieldUpdater.newUpdater(CachedValue.class, Object.class, "_ref");
    public static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(CachedValue.class, "closed");
    public volatile /* synthetic */ Object _ref;
    public final long bufferTime;
    public final Clock clock;
    public volatile /* synthetic */ int closed;
    public final SemaphoreImpl gate;

    public CachedValue() {
        throw null;
    }

    public CachedValue(long j, Clock clock) {
        this.bufferTime = j;
        this.clock = clock;
        int r1 = SemaphoreKt.MAX_SPIN_CYCLES;
        this.gate = new SemaphoreImpl(1, 0);
        this._ref = null;
        this.closed = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean z;
        if (!closed$FU.compareAndSet(this, 0, 1)) {
            return;
        }
        do {
            Object obj = this._ref;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _ref$FU;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                    z = true;
                    break;
                } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                    z = false;
                    break;
                }
            }
        } while (!z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c5 A[Catch: all -> 0x0039, TryCatch #1 {all -> 0x0039, blocks: (B:12:0x0034, B:13:0x00ba, B:17:0x00c5, B:18:0x00c7, B:24:0x00d7, B:28:0x00dd, B:29:0x00e9, B:20:0x00cf, B:33:0x00ea, B:34:0x00f3), top: B:11:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ea A[Catch: all -> 0x0039, TryCatch #1 {all -> 0x0039, blocks: (B:12:0x0034, B:13:0x00ba, B:17:0x00c5, B:18:0x00c7, B:24:0x00d7, B:28:0x00dd, B:29:0x00e9, B:20:0x00cf, B:33:0x00ea, B:34:0x00f3), top: B:11:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0072 A[Catch: all -> 0x00a5, TryCatch #0 {all -> 0x00a5, blocks: (B:44:0x0069, B:48:0x0072, B:50:0x0078, B:54:0x009f, B:58:0x00a7, B:62:0x00f6, B:63:0x00ff), top: B:43:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f6 A[Catch: all -> 0x00a5, TRY_ENTER, TryCatch #0 {all -> 0x00a5, blocks: (B:44:0x0069, B:48:0x0072, B:50:0x0078, B:54:0x009f, B:58:0x00a7, B:62:0x00f6, B:63:0x00ff), top: B:43:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Type inference failed for: r13v14, types: [kotlinx.coroutines.sync.Semaphore] */
    /* JADX WARN: Type inference failed for: r1v4, types: [kotlinx.coroutines.sync.Semaphore] */
    /* JADX WARN: Type inference failed for: r2v14, types: [kotlin.jvm.functions.Function1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getOrLoad(aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$modifyRequest$token$1 r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.util.CachedValue.getOrLoad(aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$modifyRequest$token$1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
