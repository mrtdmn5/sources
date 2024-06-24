package com.animaconnected.secondo.screens.workout.utils;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: BaseFragmentUtils.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt$collectSafely$3", f = "BaseFragmentUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BaseFragmentUtilsKt$collectSafely$3<T> extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<T, Unit> $onEach;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseFragmentUtilsKt$collectSafely$3(Function1<? super T, Unit> function1, Continuation<? super BaseFragmentUtilsKt$collectSafely$3> continuation) {
        super(2, continuation);
        this.$onEach = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseFragmentUtilsKt$collectSafely$3 baseFragmentUtilsKt$collectSafely$3 = new BaseFragmentUtilsKt$collectSafely$3(this.$onEach, continuation);
        baseFragmentUtilsKt$collectSafely$3.L$0 = obj;
        return baseFragmentUtilsKt$collectSafely$3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke2((BaseFragmentUtilsKt$collectSafely$3<T>) obj, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$onEach.invoke(this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(T t, Continuation<? super Unit> continuation) {
        return ((BaseFragmentUtilsKt$collectSafely$3) create(t, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
