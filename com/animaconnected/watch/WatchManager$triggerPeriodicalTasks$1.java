package com.animaconnected.watch;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.device.CrashBackend;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchManager.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchManager$triggerPeriodicalTasks$1", f = "WatchManager.kt", l = {500}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchManager$triggerPeriodicalTasks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatchManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchManager$triggerPeriodicalTasks$1(WatchManager watchManager, Continuation<? super WatchManager$triggerPeriodicalTasks$1> continuation) {
        super(2, continuation);
        this.this$0 = watchManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchManager$triggerPeriodicalTasks$1 watchManager$triggerPeriodicalTasks$1 = new WatchManager$triggerPeriodicalTasks$1(this.this$0, continuation);
        watchManager$triggerPeriodicalTasks$1.L$0 = obj;
        return watchManager$triggerPeriodicalTasks$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
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
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            str = this.this$0.tag;
            final WatchManager watchManager = this.this$0;
            LogKt.debug$default((Object) coroutineScope, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.WatchManager$triggerPeriodicalTasks$1.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    long j;
                    StringBuilder sb = new StringBuilder("Running periodical (");
                    j = WatchManager.this.periodicalInterval;
                    sb.append((Object) Duration.m1690toStringimpl(j));
                    sb.append(") tasks");
                    return sb.toString();
                }
            }, 6, (Object) null);
            CrashBackend crashBackend = ServiceLocator.INSTANCE.getCrashBackend();
            this.label = 1;
            if (crashBackend.uploadStoredCrashes(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchManager$triggerPeriodicalTasks$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
