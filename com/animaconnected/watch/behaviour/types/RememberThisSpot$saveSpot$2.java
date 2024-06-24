package com.animaconnected.watch.behaviour.types;

import com.animaconnected.watch.location.Spot;
import com.animaconnected.watch.provider.SpotsProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RememberThisSpot.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.types.RememberThisSpot$saveSpot$2", f = "RememberThisSpot.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RememberThisSpot$saveSpot$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Spot $updatedSpot;
    int label;
    final /* synthetic */ RememberThisSpot this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RememberThisSpot$saveSpot$2(RememberThisSpot rememberThisSpot, Spot spot, Continuation<? super RememberThisSpot$saveSpot$2> continuation) {
        super(2, continuation);
        this.this$0 = rememberThisSpot;
        this.$updatedSpot = spot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RememberThisSpot$saveSpot$2(this.this$0, this.$updatedSpot, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SpotsProvider spotsProvider;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            spotsProvider = this.this$0.spotsProvider;
            spotsProvider.addSpot(this.$updatedSpot);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RememberThisSpot$saveSpot$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
