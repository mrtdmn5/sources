package com.animaconnected.secondo.screens.dashboard;

import android.view.View;
import com.animaconnected.secondo.screens.BaseFragment;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: DashboardFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.dashboard.DashboardFragment$onCreateView$1$5", f = "DashboardFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DashboardFragment$onCreateView$1$5 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseFragment $activityFragment;
    int label;
    final /* synthetic */ DashboardFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DashboardFragment$onCreateView$1$5(DashboardFragment dashboardFragment, BaseFragment baseFragment, Continuation<? super DashboardFragment$onCreateView$1$5> continuation) {
        super(2, continuation);
        this.this$0 = dashboardFragment;
        this.$activityFragment = baseFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DashboardFragment$onCreateView$1$5(this.this$0, this.$activityFragment, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DashboardFragment$onCreateView$1$5) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getMainController().gotoNextFragment(this.$activityFragment);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
