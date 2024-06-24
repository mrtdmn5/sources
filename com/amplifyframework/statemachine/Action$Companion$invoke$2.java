package com.amplifyframework.statemachine;

import com.amplifyframework.statemachine.Action;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Action.kt */
/* loaded from: classes.dex */
public final class Action$Companion$invoke$2 implements Action {
    final /* synthetic */ Function4<EnvType, String, EventDispatcher, Continuation<? super Unit>, Object> $block;
    private final String id;

    /* JADX WARN: Multi-variable type inference failed */
    public Action$Companion$invoke$2(String str, Function4<? super EnvType, ? super String, ? super EventDispatcher, ? super Continuation<? super Unit>, ? extends Object> function4) {
        this.$block = function4;
        this.id = str == null ? Action.DefaultImpls.getId(this) : str;
    }

    @Override // com.amplifyframework.statemachine.Action
    public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
        Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
        Object invoke = this.$block.invoke(environment, getId(), eventDispatcher, continuation);
        if (invoke == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return invoke;
        }
        return Unit.INSTANCE;
    }

    public Object execute$$forInline(EventDispatcher eventDispatcher, Environment environment, final Continuation<? super Unit> continuation) {
        new ContinuationImpl(continuation) { // from class: com.amplifyframework.statemachine.Action$Companion$invoke$2$execute$1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return Action$Companion$invoke$2.this.execute(null, null, this);
            }
        };
        Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
        this.$block.invoke(environment, getId(), eventDispatcher, continuation);
        return Unit.INSTANCE;
    }

    @Override // com.amplifyframework.statemachine.Action
    public String getId() {
        return this.id;
    }
}
