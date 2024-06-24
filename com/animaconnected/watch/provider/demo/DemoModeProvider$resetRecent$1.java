package com.animaconnected.watch.provider.demo;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* compiled from: DemoModeProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.demo.DemoModeProvider$resetRecent$1", f = "DemoModeProvider.kt", l = {87}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DemoModeProvider$resetRecent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DemoModeProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DemoModeProvider$resetRecent$1(DemoModeProvider demoModeProvider, Continuation<? super DemoModeProvider$resetRecent$1> continuation) {
        super(2, continuation);
        this.this$0 = demoModeProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DemoModeProvider$resetRecent$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
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
            this.this$0.resetRecentRequested = true;
            channel = this.this$0.notifyRequest;
            Unit unit = Unit.INSTANCE;
            this.label = 1;
            if (channel.send(unit, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DemoModeProvider$resetRecent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
