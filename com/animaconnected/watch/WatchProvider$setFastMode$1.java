package com.animaconnected.watch;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.device.WatchIO;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider$setFastMode$1", f = "WatchProvider.kt", l = {523}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchProvider$setFastMode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatchProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchProvider$setFastMode$1(WatchProvider watchProvider, boolean z, Continuation<? super WatchProvider$setFastMode$1> continuation) {
        super(2, continuation);
        this.this$0 = watchProvider;
        this.$enabled = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchProvider$setFastMode$1 watchProvider$setFastMode$1 = new WatchProvider$setFastMode$1(this.this$0, this.$enabled, continuation);
        watchProvider$setFastMode$1.L$0 = obj;
        return watchProvider$setFastMode$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WatchIO io2;
        CoroutineScope coroutineScope;
        Exception exc;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    exc = e;
                    coroutineScope = coroutineScope2;
                    LogKt.debug$default((Object) coroutineScope, "Failed to write fast mode", (String) null, (Throwable) exc, false, 10, (Object) null);
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            io2 = this.this$0.getIo();
            if (io2 == null) {
                return Unit.INSTANCE;
            }
            try {
                boolean z = this.$enabled;
                this.L$0 = coroutineScope3;
                this.label = 1;
                if (io2.writeFastMode(z, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } catch (Exception e2) {
                coroutineScope = coroutineScope3;
                exc = e2;
                LogKt.debug$default((Object) coroutineScope, "Failed to write fast mode", (String) null, (Throwable) exc, false, 10, (Object) null);
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchProvider$setFastMode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
