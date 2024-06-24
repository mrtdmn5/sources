package com.animaconnected.watch;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FlowExtensions.kt */
@DebugMetadata(c = "com.animaconnected.watch.StartClosableImpl$start$1", f = "FlowExtensions.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class StartClosableImpl$start$1<T> extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StartClosableImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartClosableImpl$start$1(StartClosableImpl<T> startClosableImpl, Continuation<? super StartClosableImpl$start$1> continuation) {
        super(2, continuation);
        this.this$0 = startClosableImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StartClosableImpl$start$1 startClosableImpl$start$1 = new StartClosableImpl$start$1(this.this$0, continuation);
        startClosableImpl$start$1.L$0 = obj;
        return startClosableImpl$start$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke2((StartClosableImpl$start$1<T>) obj, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Function1 function1;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            function1 = ((StartClosableImpl) this.this$0).block;
            function1.invoke(obj2);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(T t, Continuation<? super Unit> continuation) {
        return ((StartClosableImpl$start$1) create(t, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
