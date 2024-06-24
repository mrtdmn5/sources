package androidx.compose.animation.core;

import androidx.compose.animation.core.MutatorMutex;
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
@DebugMetadata(c = "androidx.compose.animation.core.MutatorMutex$mutate$2", f = "InternalMutatorMutex.kt", l = {184, R.styleable.AppTheme_stepsHistoryBackgroundDetail}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class MutatorMutex$mutate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
    public final /* synthetic */ Function1<Continuation<Object>, Object> $block;
    public final /* synthetic */ MutatePriority $priority;
    public /* synthetic */ Object L$0;
    public Mutex L$1;
    public Object L$2;
    public MutatorMutex L$3;
    public int label;
    public final /* synthetic */ MutatorMutex this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MutatorMutex$mutate$2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function1<? super Continuation<Object>, ? extends Object> function1, Continuation<? super MutatorMutex$mutate$2> continuation) {
        super(2, continuation);
        this.$priority = mutatePriority;
        this.this$0 = mutatorMutex;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MutatorMutex$mutate$2 mutatorMutex$mutate$2 = new MutatorMutex$mutate$2(this.$priority, this.this$0, this.$block, continuation);
        mutatorMutex$mutate$2.L$0 = obj;
        return mutatorMutex$mutate$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((MutatorMutex$mutate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.sync.Mutex] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutatorMutex mutatorMutex;
        MutatorMutex.Mutator mutator;
        boolean z;
        Mutex mutex;
        Function1<Continuation<Object>, Object> function1;
        MutatorMutex.Mutator mutator2;
        boolean z2;
        Mutex mutex2;
        MutatorMutex.Mutator mutator3;
        MutatorMutex mutatorMutex2;
        Throwable th;
        AtomicReference<MutatorMutex.Mutator> atomicReference;
        AtomicReference<MutatorMutex.Mutator> atomicReference2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ?? r1 = this.label;
        try {
            try {
                if (r1 != 0) {
                    if (r1 != 1) {
                        if (r1 == 2) {
                            mutatorMutex2 = (MutatorMutex) this.L$2;
                            mutex2 = this.L$1;
                            mutator3 = (MutatorMutex.Mutator) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                atomicReference2 = mutatorMutex2.currentMutator;
                                while (!atomicReference2.compareAndSet(mutator3, null) && atomicReference2.get() == mutator3) {
                                }
                                mutex2.unlock(null);
                                return obj;
                            } catch (Throwable th2) {
                                th = th2;
                                atomicReference = mutatorMutex2.currentMutator;
                                while (!atomicReference.compareAndSet(mutator3, null)) {
                                }
                                throw th;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    MutatorMutex mutatorMutex3 = this.L$3;
                    function1 = (Function1) this.L$2;
                    mutex = this.L$1;
                    mutator2 = (MutatorMutex.Mutator) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutatorMutex = mutatorMutex3;
                } else {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext.Element element = ((CoroutineScope) this.L$0).getCoroutineContext().get(Job.Key.$$INSTANCE);
                    Intrinsics.checkNotNull(element);
                    MutatorMutex.Mutator mutator4 = new MutatorMutex.Mutator(this.$priority, (Job) element);
                    do {
                        mutatorMutex = this.this$0;
                        AtomicReference<MutatorMutex.Mutator> atomicReference3 = mutatorMutex.currentMutator;
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
                        mutator.job.cancel(new MutationInterruptedException());
                    }
                    this.L$0 = mutator4;
                    mutex = mutatorMutex.mutex;
                    this.L$1 = mutex;
                    Function1<Continuation<Object>, Object> function12 = this.$block;
                    this.L$2 = function12;
                    this.L$3 = mutatorMutex;
                    this.label = 1;
                    if (mutex.lock(null, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    function1 = function12;
                    mutator2 = mutator4;
                }
                this.L$0 = mutator2;
                this.L$1 = mutex2;
                this.L$2 = mutatorMutex;
                this.L$3 = null;
                this.label = 2;
                Object invoke = function1.invoke(this);
                if (invoke == coroutineSingletons) {
                    return coroutineSingletons;
                }
                mutatorMutex2 = mutatorMutex;
                obj = invoke;
                mutator3 = mutator2;
                atomicReference2 = mutatorMutex2.currentMutator;
                while (!atomicReference2.compareAndSet(mutator3, null)) {
                }
                mutex2.unlock(null);
                return obj;
            } catch (Throwable th3) {
                mutator3 = mutator2;
                mutatorMutex2 = mutatorMutex;
                th = th3;
                atomicReference = mutatorMutex2.currentMutator;
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
