package com.amplifyframework.kotlin.api;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: KotlinApiFacade.kt */
@DebugMetadata(c = "com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription$awaitStart$3", f = "KotlinApiFacade.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class KotlinApiFacade$Subscription$awaitStart$3 extends SuspendLambda implements Function2<Object, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public KotlinApiFacade$Subscription$awaitStart$3(Continuation<? super KotlinApiFacade$Subscription$awaitStart$3> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KotlinApiFacade$Subscription$awaitStart$3 kotlinApiFacade$Subscription$awaitStart$3 = new KotlinApiFacade$Subscription$awaitStart$3(continuation);
        kotlinApiFacade$Subscription$awaitStart$3.L$0 = obj;
        return kotlinApiFacade$Subscription$awaitStart$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boolean.valueOf(!(this.L$0 instanceof Unit));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Boolean> continuation) {
        return ((KotlinApiFacade$Subscription$awaitStart$3) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
