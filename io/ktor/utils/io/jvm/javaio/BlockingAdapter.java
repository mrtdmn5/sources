package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import org.slf4j.Logger;

/* compiled from: Blocking.kt */
/* loaded from: classes3.dex */
public abstract class BlockingAdapter {
    public static final /* synthetic */ AtomicReferenceFieldUpdater state$FU = AtomicReferenceFieldUpdater.newUpdater(BlockingAdapter.class, Object.class, "state");
    public final DisposableHandle disposable;
    public final BlockingAdapter$end$1 end;
    public int length;
    public int offset;
    public final Job parent;
    volatile /* synthetic */ int result;
    volatile /* synthetic */ Object state;

    public BlockingAdapter() {
        this(null);
    }

    public abstract Object loop(Continuation<? super Unit> continuation);

    public final int submitAndAwait(byte[] buffer, int r8, int r9) {
        Object noWhenBranchMatchedException;
        boolean z;
        boolean z2;
        long j;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.offset = r8;
        this.length = r9;
        Thread thread = Thread.currentThread();
        Continuation continuation = null;
        do {
            Object obj = this.state;
            if (obj instanceof Continuation) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any>");
                continuation = (Continuation) obj;
                noWhenBranchMatchedException = thread;
            } else {
                if (obj instanceof Unit) {
                    return this.result;
                }
                if (!(obj instanceof Throwable)) {
                    if (!(obj instanceof Thread)) {
                        if (!Intrinsics.areEqual(obj, this)) {
                            noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                        } else {
                            throw new IllegalStateException("Not yet started");
                        }
                    } else {
                        throw new IllegalStateException("There is already thread owning adapter");
                    }
                } else {
                    throw ((Throwable) obj);
                }
            }
            Intrinsics.checkNotNullExpressionValue(noWhenBranchMatchedException, "when (value) {\n         …Exception()\n            }");
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
            while (true) {
                z = false;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, noWhenBranchMatchedException)) {
                    z2 = true;
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    z2 = false;
                    break;
                }
            }
        } while (!z2);
        Intrinsics.checkNotNull(continuation);
        continuation.resumeWith(buffer);
        Intrinsics.checkNotNullExpressionValue(thread, "thread");
        if (this.state == thread) {
            if (PollersKt.getParkingImpl() != ProhibitParking.INSTANCE) {
                z = true;
            }
            if (!z) {
                ((Logger) BlockingKt.ADAPTER_LOGGER$delegate.getValue()).warn("Blocking network thread detected. \nIt can possible lead to a performance decline or even a deadlock.\nPlease make sure you're using blocking IO primitives like InputStream and OutputStream only in \nthe context of Dispatchers.IO:\n```\nwithContext(Dispatchers.IO) {\n    myInputStream.read()\n}\n```");
            }
            while (true) {
                EventLoop eventLoop = ThreadLocalEventLoop.ref.get();
                if (eventLoop != null) {
                    j = eventLoop.processNextEvent();
                } else {
                    j = Long.MAX_VALUE;
                }
                if (this.state != thread) {
                    break;
                }
                if (j > 0) {
                    PollersKt.getParkingImpl().park(j);
                }
            }
        }
        Object obj2 = this.state;
        if (!(obj2 instanceof Throwable)) {
            return this.result;
        }
        throw ((Throwable) obj2);
    }

    public BlockingAdapter(Job job) {
        this.parent = job;
        BlockingAdapter$end$1 blockingAdapter$end$1 = new BlockingAdapter$end$1(this);
        this.end = blockingAdapter$end$1;
        this.state = this;
        this.result = 0;
        this.disposable = job != null ? job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.utils.io.jvm.javaio.BlockingAdapter$disposable$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Throwable th) {
                Throwable th2 = th;
                if (th2 != null) {
                    BlockingAdapter.this.end.resumeWith(ResultKt.createFailure(th2));
                }
                return Unit.INSTANCE;
            }
        }) : null;
        BlockingAdapter$block$1 blockingAdapter$block$1 = new BlockingAdapter$block$1(this, null);
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, blockingAdapter$block$1);
        blockingAdapter$block$1.invoke(blockingAdapter$end$1);
        if (!(this.state != this)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }
}
