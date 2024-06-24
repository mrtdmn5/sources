package com.animaconnected.watch;

import com.animaconnected.watch.device.WatchFace;
import com.animaconnected.watch.device.WatchIO;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider$makeNewCalibration$1", f = "WatchProvider.kt", l = {541}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchProvider$makeNewCalibration$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ int $angleDiff;
    final /* synthetic */ int $hand;
    final /* synthetic */ WatchIO $io;
    final /* synthetic */ WatchFace $watchFace;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchProvider$makeNewCalibration$1(WatchIO watchIO, WatchFace watchFace, int r3, int r4, Continuation<? super WatchProvider$makeNewCalibration$1> continuation) {
        super(1, continuation);
        this.$io = watchIO;
        this.$watchFace = watchFace;
        this.$hand = r3;
        this.$angleDiff = r4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new WatchProvider$makeNewCalibration$1(this.$io, this.$watchFace, this.$hand, this.$angleDiff, continuation);
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
            WatchIO watchIO = this.$io;
            WatchFace watchFace = this.$watchFace;
            int r3 = this.$hand;
            int r4 = this.$angleDiff;
            this.label = 1;
            if (watchIO.writeRecalibrateMove(watchFace, r3, r4, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((WatchProvider$makeNewCalibration$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
