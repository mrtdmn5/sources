package androidx.compose.foundation;

import androidx.compose.foundation.MutatorMutex;
import com.animaconnected.secondo.R;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;

/* compiled from: MutatorMutex.kt */
@DebugMetadata(c = "androidx.compose.foundation.MutatorMutex$mutateWith$2", f = "MutatorMutex.kt", l = {186, R.styleable.AppTheme_themeGradientOpacity}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class MutatorMutex$mutateWith$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
    public final /* synthetic */ Function2<Object, Continuation<Object>, Object> $block;
    public final /* synthetic */ MutatePriority $priority;
    public final /* synthetic */ Object $receiver;
    public /* synthetic */ Object L$0;
    public Mutex L$1;
    public Object L$2;
    public Object L$3;
    public MutatorMutex L$4;
    public int label;
    public final /* synthetic */ MutatorMutex this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MutatorMutex$mutateWith$2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function2<Object, ? super Continuation<Object>, ? extends Object> function2, Object obj, Continuation<? super MutatorMutex$mutateWith$2> continuation) {
        super(2, continuation);
        this.$priority = mutatePriority;
        this.this$0 = mutatorMutex;
        this.$block = function2;
        this.$receiver = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MutatorMutex$mutateWith$2 mutatorMutex$mutateWith$2 = new MutatorMutex$mutateWith$2(this.$priority, this.this$0, this.$block, this.$receiver, continuation);
        mutatorMutex$mutateWith$2.L$0 = obj;
        return mutatorMutex$mutateWith$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((MutatorMutex$mutateWith$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.sync.Mutex] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutatorMutex mutatorMutex;
        Object obj2;
        MutatorMutex.Mutator mutator;
        Mutex mutex;
        Function2<Object, Continuation<Object>, Object> function2;
        MutatorMutex.Mutator mutator2;
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
                            mutex = this.L$1;
                            mutator2 = (MutatorMutex.Mutator) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                atomicReference2 = mutatorMutex2.currentMutator;
                                while (!atomicReference2.compareAndSet(mutator2, null) && atomicReference2.get() == mutator2) {
                                }
                                mutex.unlock(null);
                                return obj;
                            } catch (Throwable th2) {
                                th = th2;
                                atomicReference = mutatorMutex2.currentMutator;
                                while (!atomicReference.compareAndSet(mutator2, null)) {
                                }
                                throw th;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    MutatorMutex mutatorMutex3 = this.L$4;
                    obj2 = this.L$3;
                    function2 = (Function2) this.L$2;
                    Mutex mutex2 = this.L$1;
                    mutator = (MutatorMutex.Mutator) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutatorMutex = mutatorMutex3;
                    mutex = mutex2;
                } else {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext.Element element = ((CoroutineScope) this.L$0).getCoroutineContext().get(Job.Key.$$INSTANCE);
                    Intrinsics.checkNotNull(element);
                    MutatorMutex.Mutator mutator3 = new MutatorMutex.Mutator(this.$priority, (Job) element);
                    mutatorMutex = this.this$0;
                    MutatorMutex.access$tryMutateOrCancel(mutatorMutex, mutator3);
                    this.L$0 = mutator3;
                    MutexImpl mutexImpl = mutatorMutex.mutex;
                    this.L$1 = mutexImpl;
                    Function2<Object, Continuation<Object>, Object> function22 = this.$block;
                    this.L$2 = function22;
                    Object obj3 = this.$receiver;
                    this.L$3 = obj3;
                    this.L$4 = mutatorMutex;
                    this.label = 1;
                    if (mutexImpl.lock(null, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    obj2 = obj3;
                    mutator = mutator3;
                    mutex = mutexImpl;
                    function2 = function22;
                }
                this.L$0 = mutator;
                this.L$1 = mutex;
                this.L$2 = mutatorMutex;
                this.L$3 = null;
                this.L$4 = null;
                this.label = 2;
                Object invoke = function2.invoke(obj2, this);
                if (invoke == coroutineSingletons) {
                    return coroutineSingletons;
                }
                mutatorMutex2 = mutatorMutex;
                obj = invoke;
                mutator2 = mutator;
                atomicReference2 = mutatorMutex2.currentMutator;
                while (!atomicReference2.compareAndSet(mutator2, null)) {
                }
                mutex.unlock(null);
                return obj;
            } catch (Throwable th3) {
                mutator2 = mutator;
                mutatorMutex2 = mutatorMutex;
                th = th3;
                atomicReference = mutatorMutex2.currentMutator;
                while (!atomicReference.compareAndSet(mutator2, null) && atomicReference.get() == mutator2) {
                }
                throw th;
            }
        } catch (Throwable th4) {
            r1.unlock(null);
            throw th4;
        }
    }
}
