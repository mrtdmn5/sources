package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* compiled from: Job.kt */
/* loaded from: classes4.dex */
public interface Job extends CoroutineContext.Element {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* compiled from: Job.kt */
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean z, Function1 function1, int r5) {
            boolean z2 = false;
            if ((r5 & 1) != 0) {
                z = false;
            }
            if ((r5 & 2) != 0) {
                z2 = true;
            }
            return job.invokeOnCompletion(z, z2, function1);
        }
    }

    /* compiled from: Job.kt */
    /* loaded from: classes4.dex */
    public static final class Key implements CoroutineContext.Key<Job> {
        public static final /* synthetic */ Key $$INSTANCE = new Key();
    }

    ChildHandle attachChild(JobSupport jobSupport);

    void cancel(CancellationException cancellationException);

    CancellationException getCancellationException();

    Job getParent();

    DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1);

    DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1<? super Throwable, Unit> function1);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    Object join(Continuation<? super Unit> continuation);

    boolean start();
}
