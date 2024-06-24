package com.animaconnected.watch;

import com.animaconnected.watch.device.WatchIO;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider$startVibratorWithPattern$1", f = "WatchProvider.kt", l = {1088}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchProvider$startVibratorWithPattern$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ int[] $ints;
    int label;
    final /* synthetic */ WatchProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchProvider$startVibratorWithPattern$1(WatchProvider watchProvider, int[] r2, Continuation<? super WatchProvider$startVibratorWithPattern$1> continuation) {
        super(1, continuation);
        this.this$0 = watchProvider;
        this.$ints = r2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new WatchProvider$startVibratorWithPattern$1(this.this$0, this.$ints, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WatchIO io2;
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
            io2 = this.this$0.getIo();
            if (io2 != null) {
                int[] r12 = this.$ints;
                this.label = 1;
                if (io2.writeStartVibratorWithPattern(r12, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                return null;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((WatchProvider$startVibratorWithPattern$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
