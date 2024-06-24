package com.animaconnected.secondo.screens.onboarding;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: Onboarding.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.Onboarding$forgetCurrentDeviceIfNeededThenUpdateState$1", f = "Onboarding.kt", l = {630, 631}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Onboarding$forgetCurrentDeviceIfNeededThenUpdateState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Onboarding this$0;

    /* compiled from: Onboarding.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.Onboarding$forgetCurrentDeviceIfNeededThenUpdateState$1$1", f = "Onboarding.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.onboarding.Onboarding$forgetCurrentDeviceIfNeededThenUpdateState$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ Onboarding this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Onboarding onboarding, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = onboarding;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.updateState();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Onboarding$forgetCurrentDeviceIfNeededThenUpdateState$1(Onboarding onboarding, Continuation<? super Onboarding$forgetCurrentDeviceIfNeededThenUpdateState$1> continuation) {
        super(2, continuation);
        this.this$0 = onboarding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Onboarding$forgetCurrentDeviceIfNeededThenUpdateState$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object forgetCurrentDeviceIfNeeded;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            Onboarding onboarding = this.this$0;
            this.label = 1;
            forgetCurrentDeviceIfNeeded = onboarding.forgetCurrentDeviceIfNeeded(this);
            if (forgetCurrentDeviceIfNeeded == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        MainCoroutineDispatcher mainCoroutineDispatcher = MainDispatcherLoader.dispatcher;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(mainCoroutineDispatcher, anonymousClass1, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Onboarding$forgetCurrentDeviceIfNeededThenUpdateState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
