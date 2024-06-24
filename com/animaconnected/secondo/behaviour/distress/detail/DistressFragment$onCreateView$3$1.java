package com.animaconnected.secondo.behaviour.distress.detail;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DistressFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.distress.detail.DistressFragment$onCreateView$3$1", f = "DistressFragment.kt", l = {81}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DistressFragment$onCreateView$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DistressFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistressFragment$onCreateView$3$1(DistressFragment distressFragment, Continuation<? super DistressFragment$onCreateView$3$1> continuation) {
        super(2, continuation);
        this.this$0 = distressFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DistressFragment$onCreateView$3$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DistressPresenter distressPresenter;
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
            distressPresenter = this.this$0.presenter;
            if (distressPresenter != null) {
                this.label = 1;
                if (distressPresenter.sendRemove(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
                throw null;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DistressFragment$onCreateView$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
