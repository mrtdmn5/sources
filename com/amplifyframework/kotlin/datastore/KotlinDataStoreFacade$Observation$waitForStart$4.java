package com.amplifyframework.kotlin.datastore;

import com.amplifyframework.core.async.Cancelable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: KotlinDataStoreFacade.kt */
@DebugMetadata(c = "com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation$waitForStart$4", f = "KotlinDataStoreFacade.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class KotlinDataStoreFacade$Observation$waitForStart$4<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Cancelable $cancelable;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinDataStoreFacade$Observation$waitForStart$4(Cancelable cancelable, Continuation<? super KotlinDataStoreFacade$Observation$waitForStart$4> continuation) {
        super(3, continuation);
        this.$cancelable = cancelable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$cancelable.cancel();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super T> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        return new KotlinDataStoreFacade$Observation$waitForStart$4(this.$cancelable, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
