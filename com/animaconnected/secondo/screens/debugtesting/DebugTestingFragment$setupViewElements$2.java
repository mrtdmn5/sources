package com.animaconnected.secondo.screens.debugtesting;

import android.view.View;
import com.google.common.collect.Hashing;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugTestingFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugtesting.DebugTestingFragment$setupViewElements$2", f = "DebugTestingFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugTestingFragment$setupViewElements$2 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DebugTestingFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugTestingFragment$setupViewElements$2(DebugTestingFragment debugTestingFragment, Continuation<? super DebugTestingFragment$setupViewElements$2> continuation) {
        super(2, continuation);
        this.this$0 = debugTestingFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugTestingFragment$setupViewElements$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugTestingFragment$setupViewElements$2) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DebugTestingPresenter debugTestingPresenter;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            debugTestingPresenter = this.this$0.mPresenter;
            if (debugTestingPresenter != null) {
                debugTestingPresenter.onDepleteBatteriesClicked(Hashing.getLifecycleScope(this.this$0));
                return Unit.INSTANCE;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
            throw null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
