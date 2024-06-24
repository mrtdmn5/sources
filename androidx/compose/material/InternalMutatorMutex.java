package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: InternalMutatorMutex.kt */
/* loaded from: classes.dex */
public final class InternalMutatorMutex {
    public final AtomicReference<Mutator> currentMutator = new AtomicReference<>(null);
    public final MutexImpl mutex = MutexKt.Mutex$default();

    /* compiled from: InternalMutatorMutex.kt */
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
}
