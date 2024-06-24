package okhttp3.internal.concurrent;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.Constants;
import com.google.common.collect.Hashing;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* compiled from: TaskRunner.kt */
/* loaded from: classes4.dex */
public final class TaskRunner {
    public static final TaskRunner INSTANCE;
    public static final Logger logger;
    public final Backend backend;
    public final ArrayList busyQueues;
    public boolean coordinatorWaiting;
    public long coordinatorWakeUpAt;
    public final Logger logger$1;
    public int nextQueueName;
    public final ArrayList readyQueues;
    public final TaskRunner$runnable$1 runnable;

    /* compiled from: TaskRunner.kt */
    /* loaded from: classes4.dex */
    public interface Backend {
        void coordinatorNotify(TaskRunner taskRunner);

        void coordinatorWait(TaskRunner taskRunner, long j);

        BlockingQueue decorate(LinkedBlockingDeque linkedBlockingDeque);

        void execute(TaskRunner taskRunner, Runnable runnable);

        long nanoTime();
    }

    static {
        Logger logger2 = Logger.getLogger(TaskRunner.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger2, "getLogger(TaskRunner::class.java.name)");
        logger = logger2;
        String name = _UtilJvmKt.okHttpName + " TaskRunner";
        Intrinsics.checkNotNullParameter(name, "name");
        INSTANCE = new TaskRunner(new RealBackend(new _UtilJvmKt$$ExternalSyntheticLambda0(name, true)));
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [okhttp3.internal.concurrent.TaskRunner$runnable$1] */
    public TaskRunner(RealBackend realBackend) {
        Logger logger2 = logger;
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.backend = realBackend;
        this.logger$1 = logger2;
        this.nextQueueName = Constants.MAXIMUM_UPLOAD_PARTS;
        this.busyQueues = new ArrayList();
        this.readyQueues = new ArrayList();
        this.runnable = new Runnable() { // from class: okhttp3.internal.concurrent.TaskRunner$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                Task awaitTaskToRun;
                long j;
                while (true) {
                    TaskRunner taskRunner = TaskRunner.this;
                    synchronized (taskRunner) {
                        awaitTaskToRun = taskRunner.awaitTaskToRun();
                    }
                    if (awaitTaskToRun == null) {
                        return;
                    }
                    Logger logger3 = TaskRunner.this.logger$1;
                    TaskQueue taskQueue = awaitTaskToRun.queue;
                    Intrinsics.checkNotNull(taskQueue);
                    TaskRunner taskRunner2 = TaskRunner.this;
                    boolean isLoggable = logger3.isLoggable(Level.FINE);
                    if (isLoggable) {
                        j = taskQueue.taskRunner.backend.nanoTime();
                        Hashing.access$log(logger3, awaitTaskToRun, taskQueue, "starting");
                    } else {
                        j = -1;
                    }
                    try {
                        try {
                            TaskRunner.access$runTask(taskRunner2, awaitTaskToRun);
                            Unit unit = Unit.INSTANCE;
                            if (isLoggable) {
                                Hashing.access$log(logger3, awaitTaskToRun, taskQueue, "finished run in ".concat(Hashing.formatDuration(taskQueue.taskRunner.backend.nanoTime() - j)));
                            }
                        } catch (Throwable th) {
                            synchronized (taskRunner2) {
                                taskRunner2.backend.execute(taskRunner2, this);
                                Unit unit2 = Unit.INSTANCE;
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        if (isLoggable) {
                            Hashing.access$log(logger3, awaitTaskToRun, taskQueue, "failed a run in ".concat(Hashing.formatDuration(taskQueue.taskRunner.backend.nanoTime() - j)));
                        }
                        throw th2;
                    }
                }
            }
        };
    }

    public static final void access$runTask(TaskRunner taskRunner, Task task) {
        taskRunner.getClass();
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        currentThread.setName(task.name);
        try {
            long runOnce = task.runOnce();
            synchronized (taskRunner) {
                taskRunner.afterRun(task, runOnce);
                Unit unit = Unit.INSTANCE;
            }
            currentThread.setName(name);
        } catch (Throwable th) {
            synchronized (taskRunner) {
                taskRunner.afterRun(task, -1L);
                Unit unit2 = Unit.INSTANCE;
                currentThread.setName(name);
                throw th;
            }
        }
    }

    public final void afterRun(Task task, long j) {
        boolean z;
        Headers headers = _UtilJvmKt.EMPTY_HEADERS;
        TaskQueue taskQueue = task.queue;
        Intrinsics.checkNotNull(taskQueue);
        if (taskQueue.activeTask == task) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            boolean z2 = taskQueue.cancelActiveTask;
            taskQueue.cancelActiveTask = false;
            taskQueue.activeTask = null;
            this.busyQueues.remove(taskQueue);
            if (j != -1 && !z2 && !taskQueue.shutdown) {
                taskQueue.scheduleAndDecide$okhttp(task, j, true);
            }
            if (!taskQueue.futureTasks.isEmpty()) {
                this.readyQueues.add(taskQueue);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final Task awaitTaskToRun() {
        long j;
        boolean z;
        Headers headers = _UtilJvmKt.EMPTY_HEADERS;
        while (true) {
            ArrayList arrayList = this.readyQueues;
            if (arrayList.isEmpty()) {
                return null;
            }
            Backend backend = this.backend;
            long nanoTime = backend.nanoTime();
            Iterator it = arrayList.iterator();
            long j2 = Long.MAX_VALUE;
            Task task = null;
            while (true) {
                if (it.hasNext()) {
                    Task task2 = (Task) ((TaskQueue) it.next()).futureTasks.get(0);
                    j = nanoTime;
                    long max = Math.max(0L, task2.nextExecuteNanoTime - nanoTime);
                    if (max > 0) {
                        j2 = Math.min(max, j2);
                    } else {
                        if (task != null) {
                            z = true;
                            break;
                        }
                        task = task2;
                    }
                    nanoTime = j;
                } else {
                    j = nanoTime;
                    z = false;
                    break;
                }
            }
            if (task != null) {
                Headers headers2 = _UtilJvmKt.EMPTY_HEADERS;
                task.nextExecuteNanoTime = -1L;
                TaskQueue taskQueue = task.queue;
                Intrinsics.checkNotNull(taskQueue);
                taskQueue.futureTasks.remove(task);
                arrayList.remove(taskQueue);
                taskQueue.activeTask = task;
                this.busyQueues.add(taskQueue);
                if (z || (!this.coordinatorWaiting && (!arrayList.isEmpty()))) {
                    backend.execute(this, this.runnable);
                }
                return task;
            }
            if (this.coordinatorWaiting) {
                if (j2 < this.coordinatorWakeUpAt - j) {
                    backend.coordinatorNotify(this);
                    return null;
                }
                return null;
            }
            this.coordinatorWaiting = true;
            this.coordinatorWakeUpAt = j + j2;
            try {
                try {
                    backend.coordinatorWait(this, j2);
                } catch (InterruptedException unused) {
                    cancelAll();
                }
            } finally {
                this.coordinatorWaiting = false;
            }
        }
    }

    public final void cancelAll() {
        Headers headers = _UtilJvmKt.EMPTY_HEADERS;
        ArrayList arrayList = this.busyQueues;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            ((TaskQueue) arrayList.get(size)).cancelAllAndDecide$okhttp();
        }
        ArrayList arrayList2 = this.readyQueues;
        for (int size2 = arrayList2.size() - 1; -1 < size2; size2--) {
            TaskQueue taskQueue = (TaskQueue) arrayList2.get(size2);
            taskQueue.cancelAllAndDecide$okhttp();
            if (taskQueue.futureTasks.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
    }

    public final void kickCoordinator$okhttp(TaskQueue taskQueue) {
        Intrinsics.checkNotNullParameter(taskQueue, "taskQueue");
        Headers headers = _UtilJvmKt.EMPTY_HEADERS;
        if (taskQueue.activeTask == null) {
            boolean z = !taskQueue.futureTasks.isEmpty();
            ArrayList arrayList = this.readyQueues;
            if (z) {
                byte[] bArr = _UtilCommonKt.EMPTY_BYTE_ARRAY;
                Intrinsics.checkNotNullParameter(arrayList, "<this>");
                if (!arrayList.contains(taskQueue)) {
                    arrayList.add(taskQueue);
                }
            } else {
                arrayList.remove(taskQueue);
            }
        }
        boolean z2 = this.coordinatorWaiting;
        Backend backend = this.backend;
        if (z2) {
            backend.coordinatorNotify(this);
        } else {
            backend.execute(this, this.runnable);
        }
    }

    public final TaskQueue newQueue() {
        int r0;
        synchronized (this) {
            r0 = this.nextQueueName;
            this.nextQueueName = r0 + 1;
        }
        return new TaskQueue(this, SubMenuBuilder$$ExternalSyntheticOutline0.m("Q", r0));
    }

    /* compiled from: TaskRunner.kt */
    /* loaded from: classes4.dex */
    public static final class RealBackend implements Backend {
        public final ThreadPoolExecutor executor;

        public RealBackend(_UtilJvmKt$$ExternalSyntheticLambda0 _utiljvmkt__externalsyntheticlambda0) {
            this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), _utiljvmkt__externalsyntheticlambda0);
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public final void coordinatorNotify(TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public final void coordinatorWait(TaskRunner taskRunner, long j) throws InterruptedException {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            long j2 = j / 1000000;
            long j3 = j - (1000000 * j2);
            if (j2 > 0 || j > 0) {
                taskRunner.wait(j2, (int) j3);
            }
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public final void execute(TaskRunner taskRunner, Runnable runnable) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.executor.execute(runnable);
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public final long nanoTime() {
            return System.nanoTime();
        }

        @Override // okhttp3.internal.concurrent.TaskRunner.Backend
        public final BlockingQueue decorate(LinkedBlockingDeque linkedBlockingDeque) {
            return linkedBlockingDeque;
        }
    }
}
