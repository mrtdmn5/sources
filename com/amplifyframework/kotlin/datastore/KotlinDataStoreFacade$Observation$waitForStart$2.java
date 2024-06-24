package com.amplifyframework.kotlin.datastore;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: KotlinDataStoreFacade.kt */
@DebugMetadata(c = "com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation$waitForStart$2", f = "KotlinDataStoreFacade.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class KotlinDataStoreFacade$Observation$waitForStart$2 extends SuspendLambda implements Function2<Object, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public KotlinDataStoreFacade$Observation$waitForStart$2(Continuation<? super KotlinDataStoreFacade$Observation$waitForStart$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KotlinDataStoreFacade$Observation$waitForStart$2 kotlinDataStoreFacade$Observation$waitForStart$2 = new KotlinDataStoreFacade$Observation$waitForStart$2(continuation);
        kotlinDataStoreFacade$Observation$waitForStart$2.L$0 = obj;
        return kotlinDataStoreFacade$Observation$waitForStart$2;
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
        return ((KotlinDataStoreFacade$Observation$waitForStart$2) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
