package com.animaconnected.secondo.app;

import com.animaconnected.watch.WatchManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LocaleChangedReceiver.kt */
@DebugMetadata(c = "com.animaconnected.secondo.app.LocaleChangedReceiver$onReceive$2", f = "LocaleChangedReceiver.kt", l = {29}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class LocaleChangedReceiver$onReceive$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WatchManager $watchManager;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocaleChangedReceiver$onReceive$2(WatchManager watchManager, Continuation<? super LocaleChangedReceiver$onReceive$2> continuation) {
        super(2, continuation);
        this.$watchManager = watchManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocaleChangedReceiver$onReceive$2(this.$watchManager, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
            WatchManager watchManager = this.$watchManager;
            this.label = 1;
            if (watchManager.sync(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LocaleChangedReceiver$onReceive$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
