package com.animaconnected.secondo.screens.settings;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SettingsDebuggingFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.SettingsDebuggingFragment$onCreateView$1$2", f = "SettingsDebuggingFragment.kt", l = {57}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SettingsDebuggingFragment$onCreateView$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SettingsDebuggingFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsDebuggingFragment$onCreateView$1$2(SettingsDebuggingFragment settingsDebuggingFragment, Continuation<? super SettingsDebuggingFragment$onCreateView$1$2> continuation) {
        super(2, continuation);
        this.this$0 = settingsDebuggingFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsDebuggingFragment$onCreateView$1$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object startUartDump;
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
            SettingsDebuggingFragment settingsDebuggingFragment = this.this$0;
            this.label = 1;
            startUartDump = settingsDebuggingFragment.startUartDump(this);
            if (startUartDump == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsDebuggingFragment$onCreateView$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
