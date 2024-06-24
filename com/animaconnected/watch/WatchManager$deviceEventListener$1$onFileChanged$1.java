package com.animaconnected.watch;

import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchManager.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchManager$deviceEventListener$1$onFileChanged$1", f = "WatchManager.kt", l = {292}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchManager$deviceEventListener$1$onFileChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UInt $dataHash;
    final /* synthetic */ DisplayWatch $displayWatch;
    final /* synthetic */ int $pathHash;
    final /* synthetic */ Integer $size;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchManager$deviceEventListener$1$onFileChanged$1(DisplayWatch displayWatch, int r2, Integer num, UInt uInt, Continuation<? super WatchManager$deviceEventListener$1$onFileChanged$1> continuation) {
        super(2, continuation);
        this.$displayWatch = displayWatch;
        this.$pathHash = r2;
        this.$size = num;
        this.$dataHash = uInt;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchManager$deviceEventListener$1$onFileChanged$1(this.$displayWatch, this.$pathHash, this.$size, this.$dataHash, continuation);
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
            DisplayWatch displayWatch = this.$displayWatch;
            int r12 = this.$pathHash;
            int intValue = this.$size.intValue();
            int r4 = this.$dataHash.data;
            this.label = 1;
            if (displayWatch.m1045onFileChangedb1QGwmY$watch_release(r12, intValue, r4, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchManager$deviceEventListener$1$onFileChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
