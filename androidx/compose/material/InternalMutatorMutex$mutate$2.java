package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.material.InternalMutatorMutex;
import com.animaconnected.secondo.R;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: InternalMutatorMutex.kt */
@DebugMetadata(c = "androidx.compose.material.InternalMutatorMutex$mutate$2", f = "InternalMutatorMutex.kt", l = {R.styleable.AppTheme_topPusherDropZoneNotSelected, 99}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class InternalMutatorMutex$mutate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
    public final /* synthetic */ Function1<Continuation<Object>, Object> $block;
    public final /* synthetic */ MutatePriority $priority;
    public /* synthetic */ Object L$0;
    public Mutex L$1;
    public Object L$2;
    public InternalMutatorMutex L$3;
    public int label;
    public final /* synthetic */ InternalMutatorMutex this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InternalMutatorMutex$mutate$2(MutatePriority mutatePriority, InternalMutatorMutex internalMutatorMutex, Function1<? super Continuation<Object>, ? extends Object> function1, Continuation<? super InternalMutatorMutex$mutate$2> continuation) {
        super(2, continuation);
        this.$priority = mutatePriority;
        this.this$0 = internalMutatorMutex;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InternalMutatorMutex$mutate$2 internalMutatorMutex$mutate$2 = new InternalMutatorMutex$mutate$2(this.$priority, this.this$0, this.$block, continuation);
        internalMutatorMutex$mutate$2.L$0 = obj;
        return internalMutatorMutex$mutate$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((InternalMutatorMutex$mutate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.sync.Mutex] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InternalMutatorMutex internalMutatorMutex;
        InternalMutatorMutex.Mutator mutator;
        boolean z;
        Mutex mutex;
        Function1<Continuation<Object>, Object> function1;
        InternalMutatorMutex.Mutator mutator2;
        boolean z2;
        Mutex mutex2;
        InternalMutatorMutex.Mutator mutator3;
        InternalMutatorMutex internalMutatorMutex2;
        Throwable th;
        AtomicReference<InternalMutatorMutex.Mutator> atomicReference;
        AtomicReference<InternalMutatorMutex.Mutator> atomicReference2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ?? r1 = this.label;
        try {
            try {
                if (r1 != 0) {
                    if (r1 != 1) {
                        if (r1 == 2) {
                            internalMutatorMutex2 = (InternalMutatorMutex) this.L$2;
                            mutex2 = this.L$1;
                            mutator3 = (InternalMutatorMutex.Mutator) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                atomicReference2 = internalMutatorMutex2.currentMutator;
                                while (!atomicReference2.compareAndSet(mutator3, null) && atomicReference2.get() == mutator3) {
                                }
                                mutex2.unlock(null);
                                return obj;
                            } catch (Throwable th2) {
                                th = th2;
                                atomicReference = internalMutatorMutex2.currentMutator;
                                while (!atomicReference.compareAndSet(mutator3, null)) {
                                }
                                throw th;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    InternalMutatorMutex internalMutatorMutex3 = this.L$3;
                    function1 = (Function1) this.L$2;
                    mutex = this.L$1;
                    mutator2 = (InternalMutatorMutex.Mutator) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    internalMutatorMutex = internalMutatorMutex3;
                } else {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext.Element element = ((CoroutineScope) this.L$0).getCoroutineContext().get(Job.Key.$$INSTANCE);
                    Intrinsics.checkNotNull(element);
                    InternalMutatorMutex.Mutator mutator4 = new InternalMutatorMutex.Mutator(this.$priority, (Job) element);
                    do {
                        internalMutatorMutex = this.this$0;
                        AtomicReference<InternalMutatorMutex.Mutator> atomicReference3 = internalMutatorMutex.currentMutator;
                        mutator = atomicReference3.get();
                        z = false;
                        if (mutator != null) {
                            if (mutator4.priority.compareTo(mutator.priority) >= 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                throw new CancellationException("Current mutation had a higher priority");
                            }
                        }
                        while (true) {
                            if (atomicReference3.compareAndSet(mutator, mutator4)) {
                                z = true;
                                break;
                            }
                            if (atomicReference3.get() != mutator) {
                                break;
                            }
                        }
                    } while (!z);
                    if (mutator != null) {
                        mutator.job.cancel(null);
                    }
                    this.L$0 = mutator4;
                    mutex = internalMutatorMutex.mutex;
                    this.L$1 = mutex;
                    Function1<Continuation<Object>, Object> function12 = this.$block;
                    this.L$2 = function12;
                    this.L$3 = internalMutatorMutex;
                    this.label = 1;
                    if (mutex.lock(null, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    function1 = function12;
                    mutator2 = mutator4;
                }
                this.L$0 = mutator2;
                this.L$1 = mutex2;
                this.L$2 = internalMutatorMutex;
                this.L$3 = null;
                this.label = 2;
                Object invoke = function1.invoke(this);
                if (invoke == coroutineSingletons) {
                    return coroutineSingletons;
                }
                internalMutatorMutex2 = internalMutatorMutex;
                obj = invoke;
                mutator3 = mutator2;
                atomicReference2 = internalMutatorMutex2.currentMutator;
                while (!atomicReference2.compareAndSet(mutator3, null)) {
                }
                mutex2.unlock(null);
                return obj;
            } catch (Throwable th3) {
                mutator3 = mutator2;
                internalMutatorMutex2 = internalMutatorMutex;
                th = th3;
                atomicReference = internalMutatorMutex2.currentMutator;
                while (!atomicReference.compareAndSet(mutator3, null) && atomicReference.get() == mutator3) {
                }
                throw th;
            }
            mutex2 = mutex;
        } catch (Throwable th4) {
            r1.unlock(null);
            throw th4;
        }
    }
}
