package com.animaconnected.secondo.screens.behaviourconfiguration;

import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.watch.display.PascalDisplay;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BehaviourConfigurationBaseFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment$tabChanged$1", f = "BehaviourConfigurationBaseFragment.kt", l = {PascalDisplay.right}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BehaviourConfigurationBaseFragment$tabChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $tab;
    int label;
    final /* synthetic */ BehaviourConfigurationBaseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BehaviourConfigurationBaseFragment$tabChanged$1(BehaviourConfigurationBaseFragment behaviourConfigurationBaseFragment, int r2, Continuation<? super BehaviourConfigurationBaseFragment$tabChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = behaviourConfigurationBaseFragment;
        this.$tab = r2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BehaviourConfigurationBaseFragment$tabChanged$1(this.this$0, this.$tab, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BehaviourConfigurationBasePresenter behaviourConfigurationBasePresenter;
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
            MainController mainController = this.this$0.getMainController();
            int r12 = this.$tab;
            this.label = 1;
            if (mainController.updateWatchAreaViews(r12, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        behaviourConfigurationBasePresenter = this.this$0.presenter;
        if (behaviourConfigurationBasePresenter != null) {
            behaviourConfigurationBasePresenter.syncUiWithStorage();
            return Unit.INSTANCE;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BehaviourConfigurationBaseFragment$tabChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
