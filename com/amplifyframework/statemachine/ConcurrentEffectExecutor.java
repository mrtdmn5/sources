package com.amplifyframework.statemachine;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.GlobalScope;

/* compiled from: ConcurrentEffectExecutor.kt */
/* loaded from: classes.dex */
public final class ConcurrentEffectExecutor implements EffectExecutor {
    private final CoroutineDispatcher dispatcherQueue;

    public ConcurrentEffectExecutor(CoroutineDispatcher dispatcherQueue) {
        Intrinsics.checkNotNullParameter(dispatcherQueue, "dispatcherQueue");
        this.dispatcherQueue = dispatcherQueue;
    }

    @Override // com.amplifyframework.statemachine.EffectExecutor
    public void execute(List<? extends Action> actions, EventDispatcher eventDispatcher, Environment environment) {
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Iterator<T> it = actions.iterator();
        while (it.hasNext()) {
            BuildersKt.launch$default(GlobalScope.INSTANCE, this.dispatcherQueue, null, new ConcurrentEffectExecutor$execute$1$1((Action) it.next(), eventDispatcher, environment, null), 2);
        }
    }
}
