package com.amplifyframework.statemachine;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class BasicAction implements Action {
    private final Function3<EventDispatcher, Environment, Continuation<? super Unit>, Object> block;
    private String id;

    /* JADX WARN: Multi-variable type inference failed */
    public BasicAction(String id, Function3<? super EventDispatcher, ? super Environment, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(block, "block");
        this.id = id;
        this.block = block;
    }

    @Override // com.amplifyframework.statemachine.Action
    public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
        Object invoke = this.block.invoke(eventDispatcher, environment, continuation);
        if (invoke == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return invoke;
        }
        return Unit.INSTANCE;
    }

    public final Function3<EventDispatcher, Environment, Continuation<? super Unit>, Object> getBlock() {
        return this.block;
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }
}
