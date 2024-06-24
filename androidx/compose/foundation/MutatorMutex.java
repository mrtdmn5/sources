package androidx.compose.foundation;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: MutatorMutex.kt */
/* loaded from: classes.dex */
public final class MutatorMutex {
    public final AtomicReference<Mutator> currentMutator = new AtomicReference<>(null);
    public final MutexImpl mutex = MutexKt.Mutex$default();

    /* compiled from: MutatorMutex.kt */
    /* loaded from: classes.dex */
    public static final class Mutator {
        public final Job job;
        public final MutatePriority priority;

        public Mutator(MutatePriority priority, Job job) {
            Intrinsics.checkNotNullParameter(priority, "priority");
            this.priority = priority;
            this.job = job;
        }
    }

    public static final void access$tryMutateOrCancel(MutatorMutex mutatorMutex, Mutator mutator) {
        Mutator mutator2;
        boolean z;
        boolean z2;
        do {
            AtomicReference<Mutator> atomicReference = mutatorMutex.currentMutator;
            mutator2 = atomicReference.get();
            z = false;
            if (mutator2 != null) {
                if (mutator.priority.compareTo(mutator2.priority) >= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    throw new CancellationException("Current mutation had a higher priority");
                }
            }
            while (true) {
                if (atomicReference.compareAndSet(mutator2, mutator)) {
                    z = true;
                    break;
                } else if (atomicReference.get() != mutator2) {
                    break;
                }
            }
        } while (!z);
        if (mutator2 != null) {
            mutator2.job.cancel(new MutationInterruptedException());
        }
    }
}
