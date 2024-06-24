package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public abstract class JobNode extends CompletionHandlerBase implements DisposableHandle, Incomplete {
    public JobSupport job;

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode, kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        boolean z;
        JobSupport job = getJob();
        do {
            Object state$kotlinx_coroutines_core = job.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof JobNode) {
                if (state$kotlinx_coroutines_core == this) {
                    Empty empty = JobSupportKt.EMPTY_ACTIVE;
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport._state$FU;
                        if (atomicReferenceFieldUpdater.compareAndSet(job, state$kotlinx_coroutines_core, empty)) {
                            z = true;
                            break;
                        } else if (atomicReferenceFieldUpdater.get(job) != state$kotlinx_coroutines_core) {
                            z = false;
                            break;
                        }
                    }
                } else {
                    return;
                }
            } else {
                if ((state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).getList() != null) {
                    remove$1();
                    return;
                }
                return;
            }
        } while (!z);
    }

    public final JobSupport getJob() {
        JobSupport jobSupport = this.job;
        if (jobSupport != null) {
            return jobSupport;
        }
        Intrinsics.throwUninitializedPropertyAccessException("job");
        throw null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList getList() {
        return null;
    }

    public Job getParent() {
        return getJob();
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final String toString() {
        return getClass().getSimpleName() + '@' + DebugStringsKt.getHexAddress(this) + "[job@" + DebugStringsKt.getHexAddress(getJob()) + ']';
    }
}
