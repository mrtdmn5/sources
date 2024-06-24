package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

/* compiled from: CancellableReusableContinuation.kt */
/* loaded from: classes3.dex */
public final class CancellableReusableContinuation<T> implements Continuation<T> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableReusableContinuation.class, Object.class, "state");
    public static final /* synthetic */ AtomicReferenceFieldUpdater jobCancellationHandler$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableReusableContinuation.class, Object.class, "jobCancellationHandler");
    private volatile /* synthetic */ Object state = null;
    private volatile /* synthetic */ Object jobCancellationHandler = null;

    /* compiled from: CancellableReusableContinuation.kt */
    /* loaded from: classes3.dex */
    public final class JobRelation implements Function1<Throwable, Unit> {
        public DisposableHandle handler;
        public final Job job;

        public JobRelation(Job job) {
            this.job = job;
            DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, this, 2);
            if (job.isActive()) {
                this.handler = invokeOnCompletion$default;
            }
        }

        public final void dispose() {
            DisposableHandle disposableHandle = this.handler;
            if (disposableHandle != null) {
                this.handler = null;
                disposableHandle.dispose();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            Throwable th2 = th;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = CancellableReusableContinuation.state$FU;
            CancellableReusableContinuation<T> cancellableReusableContinuation = CancellableReusableContinuation.this;
            cancellableReusableContinuation.getClass();
            do {
                atomicReferenceFieldUpdater = CancellableReusableContinuation.jobCancellationHandler$FU;
                if (atomicReferenceFieldUpdater.compareAndSet(cancellableReusableContinuation, this, null)) {
                    break;
                }
            } while (atomicReferenceFieldUpdater.get(cancellableReusableContinuation) == this);
            dispose();
            if (th2 != null) {
                CancellableReusableContinuation.access$resumeWithExceptionContinuationOnly(cancellableReusableContinuation, this.job, th2);
            }
            return Unit.INSTANCE;
        }
    }

    public static final void access$resumeWithExceptionContinuationOnly(CancellableReusableContinuation cancellableReusableContinuation, Job job, Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = cancellableReusableContinuation.state;
            if ((obj instanceof Continuation) && ((Continuation) obj).getContext().get(Job.Key.$$INSTANCE) == job) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(cancellableReusableContinuation, obj, null)) {
                        z = true;
                        break;
                    } else if (atomicReferenceFieldUpdater.get(cancellableReusableContinuation) != obj) {
                        z = false;
                        break;
                    }
                }
            } else {
                return;
            }
        } while (!z);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.coroutines.Continuation<T of io.ktor.utils.io.internal.CancellableReusableContinuation>");
        ((Continuation) obj).resumeWith(ResultKt.createFailure(th));
    }

    public final void close(Throwable cause) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        resumeWith(ResultKt.createFailure(cause));
        JobRelation jobRelation = (JobRelation) jobCancellationHandler$FU.getAndSet(this, null);
        if (jobRelation != null) {
            jobRelation.dispose();
        }
    }

    public final Object completeSuspendBlock(Continuation<? super T> continuation) {
        boolean z;
        Job job;
        boolean z2;
        while (true) {
            Object obj = this.state;
            boolean z3 = false;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, null, continuation)) {
                        z = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != null) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    Job job2 = (Job) continuation.getContext().get(Job.Key.$$INSTANCE);
                    JobRelation jobRelation = (JobRelation) this.jobCancellationHandler;
                    if (jobRelation != null) {
                        job = jobRelation.job;
                    } else {
                        job = null;
                    }
                    if (job != job2) {
                        if (job2 == null) {
                            JobRelation jobRelation2 = (JobRelation) jobCancellationHandler$FU.getAndSet(this, null);
                            if (jobRelation2 != null) {
                                jobRelation2.dispose();
                            }
                        } else {
                            JobRelation jobRelation3 = new JobRelation(job2);
                            while (true) {
                                Object obj2 = this.jobCancellationHandler;
                                JobRelation jobRelation4 = (JobRelation) obj2;
                                if (jobRelation4 != null && jobRelation4.job == job2) {
                                    jobRelation3.dispose();
                                    break;
                                }
                                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = jobCancellationHandler$FU;
                                while (true) {
                                    if (atomicReferenceFieldUpdater2.compareAndSet(this, obj2, jobRelation3)) {
                                        z2 = true;
                                        break;
                                    }
                                    if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                                        z2 = false;
                                        break;
                                    }
                                }
                                if (z2) {
                                    if (jobRelation4 != null) {
                                        jobRelation4.dispose();
                                    }
                                }
                            }
                        }
                    }
                    return CoroutineSingletons.COROUTINE_SUSPENDED;
                }
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = state$FU;
                while (true) {
                    if (atomicReferenceFieldUpdater3.compareAndSet(this, obj, null)) {
                        z3 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater3.get(this) != obj) {
                        break;
                    }
                }
                if (z3) {
                    if (!(obj instanceof Throwable)) {
                        return obj;
                    }
                    throw ((Throwable) obj);
                }
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        Continuation continuation;
        CoroutineContext context;
        Object obj = this.state;
        if (obj instanceof Continuation) {
            continuation = (Continuation) obj;
        } else {
            continuation = null;
        }
        if (continuation == null || (context = continuation.getContext()) == null) {
            return EmptyCoroutineContext.INSTANCE;
        }
        return context;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object obj2;
        Object obj3;
        boolean z;
        do {
            obj2 = this.state;
            if (obj2 == null) {
                obj3 = Result.m1661exceptionOrNullimpl(obj);
                if (obj3 == null) {
                    ResultKt.throwOnFailure(obj);
                    obj3 = obj;
                }
            } else if (obj2 instanceof Continuation) {
                obj3 = null;
            } else {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, obj3)) {
                    z = true;
                    break;
                } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    z = false;
                    break;
                }
            }
        } while (!z);
        if (obj2 instanceof Continuation) {
            ((Continuation) obj2).resumeWith(obj);
        }
    }
}
