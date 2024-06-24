package okhttp3.internal.concurrent;

import com.google.common.collect.Hashing;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal._UtilJvmKt;

/* compiled from: TaskQueue.kt */
/* loaded from: classes4.dex */
public final class TaskQueue {
    public Task activeTask;
    public boolean cancelActiveTask;
    public final ArrayList futureTasks;
    public final String name;
    public boolean shutdown;
    public final TaskRunner taskRunner;

    public TaskQueue(TaskRunner taskRunner, String name) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(name, "name");
        this.taskRunner = taskRunner;
        this.name = name;
        this.futureTasks = new ArrayList();
    }

    public static void execute$default(TaskQueue taskQueue, String name, final Function0 block) {
        taskQueue.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        taskQueue.schedule(new Task(name, true) { // from class: okhttp3.internal.concurrent.TaskQueue$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public final long runOnce() {
                block.invoke();
                return -1L;
            }
        }, 0L);
    }

    public final void cancelAll() {
        Headers headers = _UtilJvmKt.EMPTY_HEADERS;
        synchronized (this.taskRunner) {
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null && task.cancelable) {
            this.cancelActiveTask = true;
        }
        ArrayList arrayList = this.futureTasks;
        boolean z = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((Task) arrayList.get(size)).cancelable) {
                Logger logger = this.taskRunner.logger$1;
                Task task2 = (Task) arrayList.get(size);
                if (logger.isLoggable(Level.FINE)) {
                    Hashing.access$log(logger, task2, this, "canceled");
                }
                arrayList.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final void schedule(Task task, long j) {
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.taskRunner) {
            if (this.shutdown) {
                if (task.cancelable) {
                    Logger logger = this.taskRunner.logger$1;
                    if (logger.isLoggable(Level.FINE)) {
                        Hashing.access$log(logger, task, this, "schedule canceled (queue is shutdown)");
                    }
                    return;
                } else {
                    Logger logger2 = this.taskRunner.logger$1;
                    if (logger2.isLoggable(Level.FINE)) {
                        Hashing.access$log(logger2, task, this, "schedule failed (queue is shutdown)");
                    }
                    throw new RejectedExecutionException();
                }
            }
            if (scheduleAndDecide$okhttp(task, j, false)) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean scheduleAndDecide$okhttp(Task task, long j, boolean z) {
        boolean z2;
        String concat;
        boolean z3;
        Intrinsics.checkNotNullParameter(task, "task");
        TaskQueue taskQueue = task.queue;
        if (taskQueue != this) {
            if (taskQueue == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                task.queue = this;
            } else {
                throw new IllegalStateException("task is in multiple queues".toString());
            }
        }
        TaskRunner taskRunner = this.taskRunner;
        long nanoTime = taskRunner.backend.nanoTime();
        long j2 = nanoTime + j;
        ArrayList arrayList = this.futureTasks;
        int indexOf = arrayList.indexOf(task);
        Logger logger = taskRunner.logger$1;
        if (indexOf != -1) {
            if (task.nextExecuteNanoTime <= j2) {
                if (logger.isLoggable(Level.FINE)) {
                    Hashing.access$log(logger, task, this, "already scheduled");
                }
                return false;
            }
            arrayList.remove(indexOf);
        }
        task.nextExecuteNanoTime = j2;
        if (logger.isLoggable(Level.FINE)) {
            if (z) {
                concat = "run again after ".concat(Hashing.formatDuration(j2 - nanoTime));
            } else {
                concat = "scheduled after ".concat(Hashing.formatDuration(j2 - nanoTime));
            }
            Hashing.access$log(logger, task, this, concat);
        }
        Iterator it = arrayList.iterator();
        int r7 = 0;
        while (true) {
            if (it.hasNext()) {
                if (((Task) it.next()).nextExecuteNanoTime - nanoTime > j) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    break;
                }
                r7++;
            } else {
                r7 = -1;
                break;
            }
        }
        if (r7 == -1) {
            r7 = arrayList.size();
        }
        arrayList.add(r7, task);
        if (r7 == 0) {
            return true;
        }
        return false;
    }

    public final void shutdown() {
        Headers headers = _UtilJvmKt.EMPTY_HEADERS;
        synchronized (this.taskRunner) {
            this.shutdown = true;
            if (cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final String toString() {
        return this.name;
    }
}
