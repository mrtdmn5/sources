package com.animaconnected.secondo.screens.behaviourconfiguration;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.behaviour.Behaviour;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BehaviourConfigurationBasePresenter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter$onItemChanged$1", f = "BehaviourConfigurationBasePresenter.kt", l = {R.styleable.AppTheme_topPusherDropZoneNotSelected, R.styleable.AppTheme_workoutDetailTintColor, 182}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BehaviourConfigurationBasePresenter$onItemChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Behaviour $behaviour;
    final /* synthetic */ int $group;
    int label;
    final /* synthetic */ BehaviourConfigurationBasePresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BehaviourConfigurationBasePresenter$onItemChanged$1(int r1, BehaviourConfigurationBasePresenter behaviourConfigurationBasePresenter, Behaviour behaviour, Continuation<? super BehaviourConfigurationBasePresenter$onItemChanged$1> continuation) {
        super(2, continuation);
        this.$group = r1;
        this.this$0 = behaviourConfigurationBasePresenter;
        this.$behaviour = behaviour;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BehaviourConfigurationBasePresenter$onItemChanged$1(this.$group, this.this$0, this.$behaviour, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x009d A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r5.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L24
            if (r1 == r4) goto L20
            if (r1 == r3) goto L1c
            if (r1 != r2) goto L14
            kotlin.ResultKt.throwOnFailure(r6)
            goto L9e
        L14:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1c:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L7a
        L20:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L56
        L24:
            kotlin.ResultKt.throwOnFailure(r6)
            int r6 = r5.$group
            r1 = -1
            if (r6 == r1) goto L65
            com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter r6 = r5.this$0
            com.animaconnected.watch.behaviour.Behaviours r6 = com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter.access$getBehaviours$p(r6)
            com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter r1 = r5.this$0
            int r2 = com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter.access$getCurrentGroup$p(r1)
            com.animaconnected.watch.Slot r1 = r1.getSlotFromGroup(r2)
            com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter r2 = r5.this$0
            com.animaconnected.secondo.behaviour.BehaviourPlugin r2 = com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter.access$getCurrentBehaviourPlugin$p(r2)
            if (r2 == 0) goto L49
            com.animaconnected.watch.behaviour.Behaviour r2 = r2.getBehaviour()
            goto L4a
        L49:
            r2 = 0
        L4a:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r5.label = r4
            java.lang.Object r6 = r6.moveBehaviourToSlot(r1, r2, r5)
            if (r6 != r0) goto L56
            return r0
        L56:
            com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter r6 = r5.this$0
            com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter.access$checkAndConfigureBehaviour(r6)
            com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter r6 = r5.this$0
            com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter$BehaviourConfigurationView r6 = com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter.access$getPushersComplicationsView$p(r6)
            r6.onItemChanged()
            goto La7
        L65:
            com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter r6 = r5.this$0
            com.animaconnected.watch.behaviour.Behaviour r1 = r5.$behaviour
            java.lang.String r1 = r1.getType()
            com.animaconnected.future.Future r6 = r6.getSlotFromBehaviourType(r1)
            r5.label = r3
            java.lang.Object r6 = com.animaconnected.future.FutureCoroutineKt.getSuspending(r6, r5)
            if (r6 != r0) goto L7a
            return r0
        L7a:
            com.animaconnected.watch.Slot r6 = (com.animaconnected.watch.Slot) r6
            com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter r1 = r5.this$0
            com.animaconnected.watch.behaviour.Behaviours r1 = com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter.access$getBehaviours$p(r1)
            com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter r3 = r5.this$0
            com.animaconnected.watch.behaviour.Behaviours r3 = com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter.access$getBehaviours$p(r3)
            com.animaconnected.watch.behaviour.types.Empty r4 = com.animaconnected.watch.behaviour.types.Empty.INSTANCE
            java.lang.String r4 = r4.getTYPE()
            com.animaconnected.watch.behaviour.Behaviour r3 = r3.getBehaviour(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r5.label = r2
            java.lang.Object r6 = r1.setBehaviourForSlot(r6, r3, r5)
            if (r6 != r0) goto L9e
            return r0
        L9e:
            com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter r6 = r5.this$0
            com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter$BehaviourConfigurationView r6 = com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter.access$getPushersComplicationsView$p(r6)
            r6.onItemChanged()
        La7:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter$onItemChanged$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BehaviourConfigurationBasePresenter$onItemChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
