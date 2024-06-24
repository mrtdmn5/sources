package com.animaconnected.secondo.screens.details;

import android.view.View;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.display.WatchApp;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: BaseDetailsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.details.BaseDetailsFragment$setupQuickActionButton$3$1", f = "BaseDetailsFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BaseDetailsFragment$setupQuickActionButton$3$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $updateVisibility;
    final /* synthetic */ WatchApp $watchApp;
    int label;
    final /* synthetic */ BaseDetailsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDetailsFragment$setupQuickActionButton$3$1(BaseDetailsFragment baseDetailsFragment, WatchApp watchApp, Function0<Unit> function0, Continuation<? super BaseDetailsFragment$setupQuickActionButton$3$1> continuation) {
        super(2, continuation);
        this.this$0 = baseDetailsFragment;
        this.$watchApp = watchApp;
        this.$updateVisibility = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseDetailsFragment$setupQuickActionButton$3$1(this.this$0, this.$watchApp, this.$updateVisibility, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((BaseDetailsFragment$setupQuickActionButton$3$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WatchProvider watch;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            watch = this.this$0.getWatch();
            watch.getWatchManager().getBehaviours().removeQuickAction(this.$watchApp);
            this.$updateVisibility.invoke();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
