package com.animaconnected.watch;

import com.animaconnected.msgpack.MsgPack;
import com.animaconnected.watch.fitness.CSEMLogs;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchManager.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchManager$deviceEventListener$1$onCSEMLog$1", f = "WatchManager.kt", l = {303}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchManager$deviceEventListener$1$onCSEMLog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MsgPack $msgPack;
    int label;
    final /* synthetic */ WatchManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchManager$deviceEventListener$1$onCSEMLog$1(WatchManager watchManager, MsgPack msgPack, Continuation<? super WatchManager$deviceEventListener$1$onCSEMLog$1> continuation) {
        super(2, continuation);
        this.this$0 = watchManager;
        this.$msgPack = msgPack;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchManager$deviceEventListener$1$onCSEMLog$1(this.this$0, this.$msgPack, continuation);
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
            CSEMLogs csemLogs = this.this$0.getCsemLogs();
            MsgPack msgPack = this.$msgPack;
            this.label = 1;
            if (csemLogs.handle(msgPack, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchManager$deviceEventListener$1$onCSEMLog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
