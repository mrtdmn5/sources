package com.animaconnected.watch.provider.demo;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.provider.demo.DemoModeProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.sync.Mutex;

/* compiled from: DemoModeProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.demo.DemoModeProvider$stopJob$1", f = "DemoModeProvider.kt", l = {340, R.styleable.AppTheme_themeGradientColor}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DemoModeProvider$stopJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DemoModeProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DemoModeProvider$stopJob$1(DemoModeProvider demoModeProvider, Continuation<? super DemoModeProvider$stopJob$1> continuation) {
        super(2, continuation);
        this.this$0 = demoModeProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DemoModeProvider$stopJob$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        DemoModeProvider demoModeProvider;
        Mutex mutex2;
        DemoModeProvider.RunState runState;
        Channel channel;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 != 1) {
                    if (r1 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                demoModeProvider = (DemoModeProvider) this.L$1;
                mutex2 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                mutex = this.this$0.runStateMutex;
                demoModeProvider = this.this$0;
                this.L$0 = mutex;
                this.L$1 = demoModeProvider;
                this.label = 1;
                if (mutex.lock(null, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                mutex2 = mutex;
            }
            runState = demoModeProvider.runState;
            if (runState == DemoModeProvider.RunState.Running) {
                demoModeProvider.runState = DemoModeProvider.RunState.Exiting;
                Unit unit = Unit.INSTANCE;
                mutex2.unlock(null);
                channel = this.this$0.notifyRequest;
                Unit unit2 = Unit.INSTANCE;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                if (channel.send(unit2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        } finally {
            mutex2.unlock(null);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DemoModeProvider$stopJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
