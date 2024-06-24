package kotlinx.coroutines.sync;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: Semaphore.kt */
/* loaded from: classes4.dex */
public interface Semaphore {
    Object acquire(ContinuationImpl continuationImpl);

    void release();
}
