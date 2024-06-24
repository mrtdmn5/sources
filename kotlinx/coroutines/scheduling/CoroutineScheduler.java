package kotlinx.coroutines.scheduling;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.random.Random;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: CoroutineScheduler.kt */
/* loaded from: classes4.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    private volatile int _isTerminated;
    private volatile long controlState;
    public final int corePoolSize;
    public final GlobalQueue globalBlockingQueue;
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    private volatile long parkedWorkersStack;
    public final String schedulerName;
    public final ResizableAtomicArray<Worker> workers;
    public static final AtomicLongFieldUpdater parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    public static final AtomicLongFieldUpdater controlState$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    public static final AtomicIntegerFieldUpdater _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK");

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[WorkerState.values().length];
            try {
                r0[WorkerState.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[WorkerState.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[WorkerState.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[WorkerState.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes4.dex */
    public final class Worker extends Thread {
        public static final AtomicIntegerFieldUpdater workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        private volatile int indexInArray;
        public final WorkQueue localQueue;
        public boolean mayHaveLocalTasks;
        public long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        public int rngState;
        public WorkerState state;
        public final Ref$ObjectRef<Task> stolenTask;
        public long terminationDeadline;
        private volatile int workerCtl;

        public Worker() {
            throw null;
        }

        public Worker(int r2) {
            setDaemon(true);
            this.localQueue = new WorkQueue();
            this.stolenTask = new Ref$ObjectRef<>();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            this.rngState = Random.Default.nextInt();
            setIndexInArray(r2);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00d0  */
        /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final kotlinx.coroutines.scheduling.Task findTask(boolean r11) {
            /*
                Method dump skipped, instructions count: 224
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.Worker.findTask(boolean):kotlinx.coroutines.scheduling.Task");
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final int nextInt(int r4) {
            int r0 = this.rngState;
            int r02 = r0 ^ (r0 << 13);
            int r03 = r02 ^ (r02 >> 17);
            int r04 = r03 ^ (r03 << 5);
            this.rngState = r04;
            int r1 = r4 - 1;
            if ((r1 & r4) == 0) {
                return r04 & r1;
            }
            return (r04 & Integer.MAX_VALUE) % r4;
        }

        public final Task pollGlobalQueues() {
            int nextInt = nextInt(2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            if (nextInt == 0) {
                Task removeFirstOrNull = coroutineScheduler.globalCpuQueue.removeFirstOrNull();
                if (removeFirstOrNull != null) {
                    return removeFirstOrNull;
                }
                return coroutineScheduler.globalBlockingQueue.removeFirstOrNull();
            }
            Task removeFirstOrNull2 = coroutineScheduler.globalBlockingQueue.removeFirstOrNull();
            if (removeFirstOrNull2 != null) {
                return removeFirstOrNull2;
            }
            return coroutineScheduler.globalCpuQueue.removeFirstOrNull();
        }

        /* JADX WARN: Code restructure failed: missing block: B:73:0x0004, code lost:            continue;     */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0004, code lost:            continue;     */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0004, code lost:            continue;     */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0004, code lost:            continue;     */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 428
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.Worker.run():void");
        }

        public final void setIndexInArray(int r3) {
            String valueOf;
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            if (r3 == 0) {
                valueOf = "TERMINATED";
            } else {
                valueOf = String.valueOf(r3);
            }
            sb.append(valueOf);
            setName(sb.toString());
            this.indexInArray = r3;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryReleaseCpu(WorkerState workerState) {
            boolean z;
            WorkerState workerState2 = this.state;
            if (workerState2 == WorkerState.CPU_ACQUIRED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z;
        }

        /* JADX WARN: Code restructure failed: missing block: B:57:0x0094, code lost:            r5 = -1;     */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0090, code lost:            r7 = -2;        r18 = r6;     */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v1, types: [T, kotlinx.coroutines.scheduling.Task, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v4 */
        /* JADX WARN: Type inference failed for: r9v5, types: [kotlinx.coroutines.scheduling.Task] */
        /* JADX WARN: Type inference failed for: r9v9, types: [kotlinx.coroutines.scheduling.Task] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final kotlinx.coroutines.scheduling.Task trySteal(int r21) {
            /*
                Method dump skipped, instructions count: 258
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.Worker.trySteal(int):kotlinx.coroutines.scheduling.Task");
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes4.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public CoroutineScheduler(long j, String str, int r7, int r8) {
        boolean z;
        boolean z2;
        boolean z3;
        this.corePoolSize = r7;
        this.maxPoolSize = r8;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (r7 >= 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r8 >= r7) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (r8 <= 2097150) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    if (j > 0) {
                        this.globalCpuQueue = new GlobalQueue();
                        this.globalBlockingQueue = new GlobalQueue();
                        this.workers = new ResizableAtomicArray<>((r7 + 1) * 2);
                        this.controlState = r7 << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
                }
                throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Max pool size ", r8, " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Max pool size ", r8, " should be greater than or equals to core pool size ", r7).toString());
        }
        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Core pool size ", r7, " should be at least 1").toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x008a, code lost:            if (r1 == null) goto L40;     */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.CoroutineScheduler._isTerminated$FU
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r9, r1, r2)
            if (r0 != 0) goto Lc
            goto Lb3
        Lc:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r3 = r0 instanceof kotlinx.coroutines.scheduling.CoroutineScheduler.Worker
            r4 = 0
            if (r3 == 0) goto L18
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r0 = (kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) r0
            goto L19
        L18:
            r0 = r4
        L19:
            if (r0 == 0) goto L24
            kotlinx.coroutines.scheduling.CoroutineScheduler r3 = kotlinx.coroutines.scheduling.CoroutineScheduler.this
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r9)
            if (r3 == 0) goto L24
            goto L25
        L24:
            r0 = r4
        L25:
            kotlinx.coroutines.internal.ResizableAtomicArray<kotlinx.coroutines.scheduling.CoroutineScheduler$Worker> r3 = r9.workers
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r5 = kotlinx.coroutines.scheduling.CoroutineScheduler.controlState$FU     // Catch: java.lang.Throwable -> Lc5
            long r5 = r5.get(r9)     // Catch: java.lang.Throwable -> Lc5
            r7 = 2097151(0x1fffff, double:1.0361303E-317)
            long r5 = r5 & r7
            int r5 = (int) r5
            monitor-exit(r3)
            if (r2 > r5) goto L7a
            r3 = r2
        L37:
            kotlinx.coroutines.internal.ResizableAtomicArray<kotlinx.coroutines.scheduling.CoroutineScheduler$Worker> r6 = r9.workers
            java.lang.Object r6 = r6.get(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r6 = (kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) r6
            if (r6 == r0) goto L75
        L44:
            boolean r7 = r6.isAlive()
            if (r7 == 0) goto L53
            java.util.concurrent.locks.LockSupport.unpark(r6)
            r7 = 10000(0x2710, double:4.9407E-320)
            r6.join(r7)
            goto L44
        L53:
            kotlinx.coroutines.scheduling.WorkQueue r6 = r6.localQueue
            kotlinx.coroutines.scheduling.GlobalQueue r7 = r9.globalBlockingQueue
            r6.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = kotlinx.coroutines.scheduling.WorkQueue.lastScheduledTask$FU
            java.lang.Object r8 = r8.getAndSet(r6, r4)
            kotlinx.coroutines.scheduling.Task r8 = (kotlinx.coroutines.scheduling.Task) r8
            if (r8 == 0) goto L67
            r7.addLast(r8)
        L67:
            kotlinx.coroutines.scheduling.Task r8 = r6.pollBuffer()
            if (r8 != 0) goto L6f
            r8 = r1
            goto L73
        L6f:
            r7.addLast(r8)
            r8 = r2
        L73:
            if (r8 != 0) goto L67
        L75:
            if (r3 == r5) goto L7a
            int r3 = r3 + 1
            goto L37
        L7a:
            kotlinx.coroutines.scheduling.GlobalQueue r1 = r9.globalBlockingQueue
            r1.close()
            kotlinx.coroutines.scheduling.GlobalQueue r1 = r9.globalCpuQueue
            r1.close()
        L84:
            if (r0 == 0) goto L8c
            kotlinx.coroutines.scheduling.Task r1 = r0.findTask(r2)
            if (r1 != 0) goto Lb4
        L8c:
            kotlinx.coroutines.scheduling.GlobalQueue r1 = r9.globalCpuQueue
            java.lang.Object r1 = r1.removeFirstOrNull()
            kotlinx.coroutines.scheduling.Task r1 = (kotlinx.coroutines.scheduling.Task) r1
            if (r1 != 0) goto Lb4
            kotlinx.coroutines.scheduling.GlobalQueue r1 = r9.globalBlockingQueue
            java.lang.Object r1 = r1.removeFirstOrNull()
            kotlinx.coroutines.scheduling.Task r1 = (kotlinx.coroutines.scheduling.Task) r1
            if (r1 != 0) goto Lb4
            if (r0 == 0) goto La7
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.tryReleaseCpu(r1)
        La7:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.parkedWorkersStack$FU
            r1 = 0
            r0.set(r9, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.controlState$FU
            r0.set(r9, r1)
        Lb3:
            return
        Lb4:
            r1.run()     // Catch: java.lang.Throwable -> Lb8
            goto L84
        Lb8:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L84
        Lc5:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.close():void");
    }

    public final int createNewWorker() {
        boolean z;
        boolean z2;
        synchronized (this.workers) {
            boolean z3 = false;
            if (_isTerminated$FU.get(this) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return -1;
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater = controlState$FU;
            long j = atomicLongFieldUpdater.get(this);
            int r8 = (int) (j & 2097151);
            int r4 = r8 - ((int) ((j & 4398044413952L) >> 21));
            if (r4 < 0) {
                r4 = 0;
            }
            if (r4 >= this.corePoolSize) {
                return 0;
            }
            if (r8 >= this.maxPoolSize) {
                return 0;
            }
            int r5 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
            if (r5 > 0 && this.workers.get(r5) == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                Worker worker = new Worker(r5);
                this.workers.setSynchronized(r5, worker);
                if (r5 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    z3 = true;
                }
                if (z3) {
                    int r42 = r4 + 1;
                    worker.start();
                    return r42;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final void dispatch(Runnable runnable, TaskContext taskContext, boolean z) {
        Task taskImpl;
        boolean z2;
        long j;
        Worker worker;
        boolean z3;
        boolean addLast;
        TasksKt.schedulerTimeSource.getClass();
        long nanoTime = System.nanoTime();
        if (runnable instanceof Task) {
            taskImpl = (Task) runnable;
            taskImpl.submissionTime = nanoTime;
            taskImpl.taskContext = taskContext;
        } else {
            taskImpl = new TaskImpl(runnable, nanoTime, taskContext);
        }
        boolean z4 = false;
        if (taskImpl.taskContext.getTaskMode() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = controlState$FU;
        if (z2) {
            j = atomicLongFieldUpdater.addAndGet(this, 2097152L);
        } else {
            j = 0;
        }
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof Worker) {
            worker = (Worker) currentThread;
        } else {
            worker = null;
        }
        if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            worker = null;
        }
        if (worker != null && worker.state != WorkerState.TERMINATED && (taskImpl.taskContext.getTaskMode() != 0 || worker.state != WorkerState.BLOCKING)) {
            worker.mayHaveLocalTasks = true;
            WorkQueue workQueue = worker.localQueue;
            if (z) {
                taskImpl = workQueue.addLast(taskImpl);
            } else {
                workQueue.getClass();
                Task task = (Task) WorkQueue.lastScheduledTask$FU.getAndSet(workQueue, taskImpl);
                if (task == null) {
                    taskImpl = null;
                } else {
                    taskImpl = workQueue.addLast(task);
                }
            }
        }
        if (taskImpl != null) {
            if (taskImpl.taskContext.getTaskMode() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                addLast = this.globalBlockingQueue.addLast(taskImpl);
            } else {
                addLast = this.globalCpuQueue.addLast(taskImpl);
            }
            if (!addLast) {
                throw new RejectedExecutionException(ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.schedulerName, " was terminated"));
            }
        }
        if (z && worker != null) {
            z4 = true;
        }
        if (z2) {
            if (!z4 && !tryUnpark() && !tryCreateWorker(j)) {
                tryUnpark();
                return;
            }
            return;
        }
        if (!z4 && !tryUnpark() && !tryCreateWorker(atomicLongFieldUpdater.get(this))) {
            tryUnpark();
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch(runnable, TasksKt.NonBlockingContext, false);
    }

    public final void parkedWorkersStackTopUpdate(Worker worker, int r10, int r11) {
        while (true) {
            long j = parkedWorkersStack$FU.get(this);
            int r0 = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (r0 == r10) {
                if (r11 == 0) {
                    Object nextParkedWorker = worker.getNextParkedWorker();
                    while (true) {
                        if (nextParkedWorker == NOT_IN_STACK) {
                            r0 = -1;
                            break;
                        }
                        if (nextParkedWorker == null) {
                            r0 = 0;
                            break;
                        }
                        Worker worker2 = (Worker) nextParkedWorker;
                        int indexInArray = worker2.getIndexInArray();
                        if (indexInArray != 0) {
                            r0 = indexInArray;
                            break;
                        }
                        nextParkedWorker = worker2.getNextParkedWorker();
                    }
                } else {
                    r0 = r11;
                }
            }
            if (r0 >= 0 && parkedWorkersStack$FU.compareAndSet(this, j, r0 | j2)) {
                return;
            }
        }
    }

    public final String toString() {
        int r12;
        ArrayList arrayList = new ArrayList();
        ResizableAtomicArray<Worker> resizableAtomicArray = this.workers;
        int currentLength = resizableAtomicArray.currentLength();
        int r3 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        for (int r9 = 1; r9 < currentLength; r9++) {
            Worker worker = resizableAtomicArray.get(r9);
            if (worker != null) {
                WorkQueue workQueue = worker.localQueue;
                workQueue.getClass();
                if (WorkQueue.lastScheduledTask$FU.get(workQueue) != null) {
                    r12 = (WorkQueue.producerIndex$FU.get(workQueue) - WorkQueue.consumerIndex$FU.get(workQueue)) + 1;
                } else {
                    r12 = WorkQueue.producerIndex$FU.get(workQueue) - WorkQueue.consumerIndex$FU.get(workQueue);
                }
                int r10 = WhenMappings.$EnumSwitchMapping$0[worker.state.ordinal()];
                if (r10 != 1) {
                    if (r10 != 2) {
                        if (r10 != 3) {
                            if (r10 != 4) {
                                if (r10 == 5) {
                                    r8++;
                                }
                            } else {
                                r7++;
                                if (r12 > 0) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(r12);
                                    sb.append('d');
                                    arrayList.add(sb.toString());
                                }
                            }
                        } else {
                            r3++;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(r12);
                            sb2.append('c');
                            arrayList.add(sb2.toString());
                        }
                    } else {
                        r5++;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(r12);
                        sb3.append('b');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    r6++;
                }
            }
        }
        long j = controlState$FU.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.schedulerName);
        sb4.append('@');
        sb4.append(DebugStringsKt.getHexAddress(this));
        sb4.append("[Pool Size {core = ");
        int r92 = this.corePoolSize;
        sb4.append(r92);
        sb4.append(", max = ");
        sb4.append(this.maxPoolSize);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(r3);
        sb4.append(", blocking = ");
        sb4.append(r5);
        sb4.append(", parked = ");
        sb4.append(r6);
        sb4.append(", dormant = ");
        sb4.append(r7);
        sb4.append(", terminated = ");
        sb4.append(r8);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.globalCpuQueue.getSize());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.globalBlockingQueue.getSize());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(r92 - ((int) ((j & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }

    public final boolean tryCreateWorker(long j) {
        int r0 = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (r0 < 0) {
            r0 = 0;
        }
        int r5 = this.corePoolSize;
        if (r0 < r5) {
            int createNewWorker = createNewWorker();
            if (createNewWorker == 1 && r5 > 1) {
                createNewWorker();
            }
            if (createNewWorker > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean tryUnpark() {
        Symbol symbol;
        int r10;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = parkedWorkersStack$FU;
            long j = atomicLongFieldUpdater.get(this);
            Worker worker = this.workers.get((int) (2097151 & j));
            if (worker == null) {
                worker = null;
            } else {
                long j2 = (2097152 + j) & (-2097152);
                Object nextParkedWorker = worker.getNextParkedWorker();
                while (true) {
                    symbol = NOT_IN_STACK;
                    if (nextParkedWorker == symbol) {
                        r10 = -1;
                        break;
                    }
                    if (nextParkedWorker == null) {
                        r10 = 0;
                        break;
                    }
                    Worker worker2 = (Worker) nextParkedWorker;
                    r10 = worker2.getIndexInArray();
                    if (r10 != 0) {
                        break;
                    }
                    nextParkedWorker = worker2.getNextParkedWorker();
                }
                if (r10 >= 0 && atomicLongFieldUpdater.compareAndSet(this, j, j2 | r10)) {
                    worker.setNextParkedWorker(symbol);
                }
            }
            if (worker == null) {
                return false;
            }
            if (Worker.workerCtl$FU.compareAndSet(worker, -1, 0)) {
                LockSupport.unpark(worker);
                return true;
            }
        }
    }
}
