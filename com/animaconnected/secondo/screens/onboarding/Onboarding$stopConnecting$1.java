package com.animaconnected.secondo.screens.onboarding;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Onboarding.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.Onboarding$stopConnecting$1", f = "Onboarding.kt", l = {561}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Onboarding$stopConnecting$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Onboarding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Onboarding$stopConnecting$1(Onboarding onboarding, Continuation<? super Onboarding$stopConnecting$1> continuation) {
        super(2, continuation);
        this.this$0 = onboarding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Onboarding$stopConnecting$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object forgetCurrentDeviceIfNeeded;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Onboarding onboarding = this.this$0;
            this.label = 1;
            forgetCurrentDeviceIfNeeded = onboarding.forgetCurrentDeviceIfNeeded(this);
            if (forgetCurrentDeviceIfNeeded == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Onboarding$stopConnecting$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
