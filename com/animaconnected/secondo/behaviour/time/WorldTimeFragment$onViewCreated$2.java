package com.animaconnected.secondo.behaviour.time;

import com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: WorldTimeFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.time.WorldTimeFragment$onViewCreated$2", f = "WorldTimeFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorldTimeFragment$onViewCreated$2 extends SuspendLambda implements Function2<WorldTimeViewModel.EditState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WorldTimeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorldTimeFragment$onViewCreated$2(WorldTimeFragment worldTimeFragment, Continuation<? super WorldTimeFragment$onViewCreated$2> continuation) {
        super(2, continuation);
        this.this$0 = worldTimeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WorldTimeFragment$onViewCreated$2 worldTimeFragment$onViewCreated$2 = new WorldTimeFragment$onViewCreated$2(this.this$0, continuation);
        worldTimeFragment$onViewCreated$2.L$0 = obj;
        return worldTimeFragment$onViewCreated$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WorldTimeViewModel.EditState editState, Continuation<? super Unit> continuation) {
        return ((WorldTimeFragment$onViewCreated$2) create(editState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            WorldTimeViewModel.EditState editState = (WorldTimeViewModel.EditState) this.L$0;
            this.this$0.invalidateEditView(editState.isEditing(), editState.isVisible());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
