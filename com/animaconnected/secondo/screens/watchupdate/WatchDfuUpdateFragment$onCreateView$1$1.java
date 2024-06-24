package com.animaconnected.secondo.screens.watchupdate;

import android.view.View;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: WatchDfuUpdateFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdateFragment$onCreateView$1$1", f = "WatchDfuUpdateFragment.kt", l = {49}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchDfuUpdateFragment$onCreateView$1$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WatchDfuUpdateFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchDfuUpdateFragment$onCreateView$1$1(WatchDfuUpdateFragment watchDfuUpdateFragment, Continuation<? super WatchDfuUpdateFragment$onCreateView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = watchDfuUpdateFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchDfuUpdateFragment$onCreateView$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((WatchDfuUpdateFragment$onCreateView$1$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
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
            BaseWatchUpdatePresenter watchUpdatePresenter = this.this$0.getWatchUpdatePresenter();
            this.label = 1;
            if (watchUpdatePresenter.updateButtonClicked(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
