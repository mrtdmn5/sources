package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.JsonTreeReader$readObject$2;

/* compiled from: DeepRecursive.kt */
/* loaded from: classes.dex */
public final class DeepRecursiveScopeImpl<T, R> extends DeepRecursiveScope<T, R> implements Continuation<R> {
    public Continuation<Object> cont;
    public final Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function;
    public Object result;
    public Object value;

    public DeepRecursiveScopeImpl(Unit unit, Function3 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.function = block;
        this.value = unit;
        this.cont = this;
        this.result = DeepRecursiveKt.UNDEFINED_RESULT;
    }

    @Override // kotlin.DeepRecursiveScope
    public final CoroutineSingletons callRecursive(Unit unit, JsonTreeReader$readObject$2 jsonTreeReader$readObject$2) {
        this.cont = jsonTreeReader$readObject$2;
        this.value = unit;
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        this.cont = null;
        this.result = obj;
    }
}
