package com.google.firebase.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class SequentialExecutor implements Executor {
    public static final Logger log = Logger.getLogger(SequentialExecutor.class.getName());
    public final Executor executor;
    public final ArrayDeque queue = new ArrayDeque();
    public WorkerRunningState workerRunningState = WorkerRunningState.IDLE;
    public long workerRunCount = 0;
    public final QueueWorker worker = new QueueWorker();

    /* loaded from: classes3.dex */
    public final class QueueWorker implements Runnable {
        public Runnable task;

        public QueueWorker() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                workOnQueue();
            } catch (Error e) {
                synchronized (SequentialExecutor.this.queue) {
                    SequentialExecutor.this.workerRunningState = WorkerRunningState.IDLE;
                    throw e;
                }
            }
        }

        public final String toString() {
            Runnable runnable = this.task;
            if (runnable != null) {
                return "SequentialExecutorWorker{running=" + runnable + "}";
            }
            return "SequentialExecutorWorker{state=" + SequentialExecutor.this.workerRunningState + "}";
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x004a, code lost:            r1 = r1 | java.lang.Thread.interrupted();     */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:            r9.task.run();     */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:            r0 = move-exception;     */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0072, code lost:            r9.task = null;     */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:            throw r0;     */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:            r3 = move-exception;     */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:            com.google.firebase.concurrent.SequentialExecutor.log.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r9.task, (java.lang.Throwable) r3);     */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:            return;     */
        /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:            return;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void workOnQueue() {
            /*
                r9 = this;
                r0 = 0
                r1 = r0
            L2:
                com.google.firebase.concurrent.SequentialExecutor r2 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L78
                java.util.ArrayDeque r2 = r2.queue     // Catch: java.lang.Throwable -> L78
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L78
                if (r0 != 0) goto L26
                com.google.firebase.concurrent.SequentialExecutor r0 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L75
                com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r3 = r0.workerRunningState     // Catch: java.lang.Throwable -> L75
                com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r4 = com.google.firebase.concurrent.SequentialExecutor.WorkerRunningState.RUNNING     // Catch: java.lang.Throwable -> L75
                if (r3 != r4) goto L1c
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L75
                if (r1 == 0) goto L1b
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L1b:
                return
            L1c:
                long r5 = r0.workerRunCount     // Catch: java.lang.Throwable -> L75
                r7 = 1
                long r5 = r5 + r7
                r0.workerRunCount = r5     // Catch: java.lang.Throwable -> L75
                r0.workerRunningState = r4     // Catch: java.lang.Throwable -> L75
                r0 = 1
            L26:
                com.google.firebase.concurrent.SequentialExecutor r3 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L75
                java.util.ArrayDeque r3 = r3.queue     // Catch: java.lang.Throwable -> L75
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L75
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L75
                r9.task = r3     // Catch: java.lang.Throwable -> L75
                if (r3 != 0) goto L45
                com.google.firebase.concurrent.SequentialExecutor r0 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L75
                com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.firebase.concurrent.SequentialExecutor.WorkerRunningState.IDLE     // Catch: java.lang.Throwable -> L75
                r0.workerRunningState = r3     // Catch: java.lang.Throwable -> L75
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L75
                if (r1 == 0) goto L44
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L44:
                return
            L45:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L75
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L78
                r1 = r1 | r2
                r2 = 0
                java.lang.Runnable r3 = r9.task     // Catch: java.lang.Throwable -> L52 java.lang.RuntimeException -> L54
                r3.run()     // Catch: java.lang.Throwable -> L52 java.lang.RuntimeException -> L54
                goto L6f
            L52:
                r0 = move-exception
                goto L72
            L54:
                r3 = move-exception
                java.util.logging.Logger r4 = com.google.firebase.concurrent.SequentialExecutor.log     // Catch: java.lang.Throwable -> L52
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L52
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
                r6.<init>()     // Catch: java.lang.Throwable -> L52
                java.lang.String r7 = "Exception while executing runnable "
                r6.append(r7)     // Catch: java.lang.Throwable -> L52
                java.lang.Runnable r7 = r9.task     // Catch: java.lang.Throwable -> L52
                r6.append(r7)     // Catch: java.lang.Throwable -> L52
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L52
                r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L52
            L6f:
                r9.task = r2     // Catch: java.lang.Throwable -> L78
                goto L2
            L72:
                r9.task = r2     // Catch: java.lang.Throwable -> L78
                throw r0     // Catch: java.lang.Throwable -> L78
            L75:
                r0 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L75
                throw r0     // Catch: java.lang.Throwable -> L78
            L78:
                r0 = move-exception
                if (r1 == 0) goto L82
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L82:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.concurrent.SequentialExecutor.QueueWorker.workOnQueue():void");
        }
    }

    /* loaded from: classes3.dex */
    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    public SequentialExecutor(Executor executor) {
        Preconditions.checkNotNull(executor);
        this.executor = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(final Runnable runnable) {
        WorkerRunningState workerRunningState;
        Preconditions.checkNotNull(runnable);
        synchronized (this.queue) {
            WorkerRunningState workerRunningState2 = this.workerRunningState;
            if (workerRunningState2 != WorkerRunningState.RUNNING && workerRunningState2 != (workerRunningState = WorkerRunningState.QUEUED)) {
                long j = this.workerRunCount;
                Runnable runnable2 = new Runnable() { // from class: com.google.firebase.concurrent.SequentialExecutor.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        runnable.run();
                    }

                    public final String toString() {
                        return runnable.toString();
                    }
                };
                this.queue.add(runnable2);
                WorkerRunningState workerRunningState3 = WorkerRunningState.QUEUING;
                this.workerRunningState = workerRunningState3;
                boolean z = true;
                try {
                    this.executor.execute(this.worker);
                    if (this.workerRunningState == workerRunningState3) {
                        z = false;
                    }
                    if (z) {
                        return;
                    }
                    synchronized (this.queue) {
                        if (this.workerRunCount == j && this.workerRunningState == workerRunningState3) {
                            this.workerRunningState = workerRunningState;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e) {
                    synchronized (this.queue) {
                        WorkerRunningState workerRunningState4 = this.workerRunningState;
                        if ((workerRunningState4 != WorkerRunningState.IDLE && workerRunningState4 != WorkerRunningState.QUEUING) || !this.queue.removeLastOccurrence(runnable2)) {
                            z = false;
                        }
                        if (!(e instanceof RejectedExecutionException) || z) {
                            throw e;
                        }
                    }
                    return;
                }
            }
            this.queue.add(runnable);
        }
    }

    public final String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.executor + "}";
    }
}
