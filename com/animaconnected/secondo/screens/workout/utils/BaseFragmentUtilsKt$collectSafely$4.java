package com.animaconnected.secondo.screens.workout.utils;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: BaseFragmentUtils.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt$collectSafely$4", f = "BaseFragmentUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BaseFragmentUtilsKt$collectSafely$4<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Throwable, Unit> $onError;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseFragmentUtilsKt$collectSafely$4(Function1<? super Throwable, Unit> function1, Continuation<? super BaseFragmentUtilsKt$collectSafely$4> continuation) {
        super(3, continuation);
        this.$onError = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$onError.invoke((Throwable) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super T> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        BaseFragmentUtilsKt$collectSafely$4 baseFragmentUtilsKt$collectSafely$4 = new BaseFragmentUtilsKt$collectSafely$4(this.$onError, continuation);
        baseFragmentUtilsKt$collectSafely$4.L$0 = th;
        return baseFragmentUtilsKt$collectSafely$4.invokeSuspend(Unit.INSTANCE);
    }
}
