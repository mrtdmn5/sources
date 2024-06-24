package com.animaconnected.watch;

import com.animaconnected.watch.device.WatchIO;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider$readStopwatch$1", f = "WatchProvider.kt", l = {646}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchProvider$readStopwatch$1 extends SuspendLambda implements Function1<Continuation<? super List<? extends Integer[]>>, Object> {
    int label;
    final /* synthetic */ WatchProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchProvider$readStopwatch$1(WatchProvider watchProvider, Continuation<? super WatchProvider$readStopwatch$1> continuation) {
        super(1, continuation);
        this.this$0 = watchProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new WatchProvider$readStopwatch$1(this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super List<? extends Integer[]>> continuation) {
        return invoke2((Continuation<? super List<Integer[]>>) continuation);
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
            Intrinsics.checkNotNull(io2);
            this.label = 1;
            obj = io2.readStopwatch(this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super List<Integer[]>> continuation) {
        return ((WatchProvider$readStopwatch$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
