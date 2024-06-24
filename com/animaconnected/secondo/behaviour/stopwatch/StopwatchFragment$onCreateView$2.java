package com.animaconnected.secondo.behaviour.stopwatch;

import android.content.Context;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.provider.lottie.LottieKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: StopwatchFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.stopwatch.StopwatchFragment$onCreateView$2", f = "StopwatchFragment.kt", l = {48}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class StopwatchFragment$onCreateView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StopwatchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StopwatchFragment$onCreateView$2(StopwatchFragment stopwatchFragment, Continuation<? super StopwatchFragment$onCreateView$2> continuation) {
        super(2, continuation);
        this.this$0 = stopwatchFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StopwatchFragment$onCreateView$2(this.this$0, continuation);
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
            Context context = this.this$0.getContext();
            if (context != null) {
                LottieFile[] lottieFileArr = {LottieFile.DvStopwatch1, LottieFile.DvStopwatch2};
                this.label = 1;
                obj = LottieKt.loadLottieAnimation(context, lottieFileArr, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StopwatchFragment$onCreateView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
