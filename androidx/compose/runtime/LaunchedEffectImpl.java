package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.internal.ContextScope;

/* compiled from: Effects.kt */
/* loaded from: classes.dex */
public final class LaunchedEffectImpl implements RememberObserver {
    public StandaloneCoroutine job;
    public final ContextScope scope;
    public final Function2<CoroutineScope, Continuation<? super Unit>, Object> task;

    /* JADX WARN: Multi-variable type inference failed */
    public LaunchedEffectImpl(CoroutineContext parentCoroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> task) {
        Intrinsics.checkNotNullParameter(parentCoroutineContext, "parentCoroutineContext");
        Intrinsics.checkNotNullParameter(task, "task");
        this.task = task;
        this.scope = CoroutineScopeKt.CoroutineScope(parentCoroutineContext);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        StandaloneCoroutine standaloneCoroutine = this.job;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(new LeftCompositionCancellationException());
        }
        this.job = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        StandaloneCoroutine standaloneCoroutine = this.job;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(new LeftCompositionCancellationException());
        }
        this.job = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        StandaloneCoroutine standaloneCoroutine = this.job;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(ExceptionsKt.CancellationException("Old job was still running!", null));
        }
        this.job = BuildersKt.launch$default(this.scope, null, null, this.task, 3);
    }
}
