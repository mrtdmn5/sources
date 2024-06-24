package com.animaconnected.secondo.screens.complications;

import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.Behaviours;
import com.animaconnected.watch.behaviour.types.Empty;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ComplicationsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.complications.ComplicationsFragment$onViewCreated$1", f = "ComplicationsFragment.kt", l = {50}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ComplicationsFragment$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ComplicationsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComplicationsFragment$onViewCreated$1(ComplicationsFragment complicationsFragment, Continuation<? super ComplicationsFragment$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = complicationsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ComplicationsFragment$onViewCreated$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean hasDoubleMainComplication;
        Behaviours behaviours;
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
            hasDoubleMainComplication = this.this$0.getHasDoubleMainComplication();
            if (hasDoubleMainComplication && !ProviderFactory.getDoubleCrownProvider().shouldShowDoubleCrown()) {
                behaviours = this.this$0.behaviours;
                Slot slot = Slot.MainComplication;
                this.label = 1;
                obj = behaviours.getBehaviour(slot, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
        if (!Intrinsics.areEqual(((Behaviour) obj).getType(), Empty.INSTANCE.getTYPE())) {
            ProviderFactory.getDoubleCrownProvider().setShouldShowDoubleCrown(true);
            this.this$0.animateDoubleCrownLine();
            this.this$0.animateDoubleCrownTarget();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ComplicationsFragment$onViewCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
