package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.DebugStringsKt;

/* compiled from: Tasks.kt */
/* loaded from: classes4.dex */
public final class TaskImpl extends Task {
    public final Runnable block;

    public TaskImpl(Runnable runnable, long j, TaskContext taskContext) {
        super(j, taskContext);
        this.block = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.block.run();
        } finally {
            this.taskContext.afterTask();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.block;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(DebugStringsKt.getHexAddress(runnable));
        sb.append(", ");
        sb.append(this.submissionTime);
        sb.append(", ");
        sb.append(this.taskContext);
        sb.append(']');
        return sb.toString();
    }
}
