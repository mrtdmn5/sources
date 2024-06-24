package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public class JobImpl extends JobSupport implements CompletableJob {
    public final boolean handlesException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobImpl(Job job) {
        super(true);
        ChildHandleNode childHandleNode;
        ChildHandleNode childHandleNode2;
        boolean z = true;
        initParentJob(job);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport._parentHandle$FU;
        ChildHandle childHandle = (ChildHandle) atomicReferenceFieldUpdater.get(this);
        if (childHandle instanceof ChildHandleNode) {
            childHandleNode = (ChildHandleNode) childHandle;
        } else {
            childHandleNode = null;
        }
        if (childHandleNode != null) {
            JobSupport job2 = childHandleNode.getJob();
            while (!job2.getHandlesException$kotlinx_coroutines_core()) {
                ChildHandle childHandle2 = (ChildHandle) atomicReferenceFieldUpdater.get(job2);
                if (childHandle2 instanceof ChildHandleNode) {
                    childHandleNode2 = (ChildHandleNode) childHandle2;
                } else {
                    childHandleNode2 = null;
                }
                if (childHandleNode2 != null) {
                    job2 = childHandleNode2.getJob();
                }
            }
            this.handlesException = z;
        }
        z = false;
        this.handlesException = z;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public final boolean complete() {
        return makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
    }

    @Override // kotlinx.coroutines.CompletableJob
    public final boolean completeExceptionally(Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(th, false));
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean getHandlesException$kotlinx_coroutines_core() {
        return this.handlesException;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}
