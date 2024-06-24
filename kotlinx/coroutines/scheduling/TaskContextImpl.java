package kotlinx.coroutines.scheduling;

/* compiled from: Tasks.kt */
/* loaded from: classes4.dex */
public final class TaskContextImpl implements TaskContext {
    public final int taskMode;

    public TaskContextImpl(int r1) {
        this.taskMode = r1;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public final int getTaskMode() {
        return this.taskMode;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public final void afterTask() {
    }
}
