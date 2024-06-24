package com.animaconnected.watch.provider;

import com.animaconnected.watch.provider.SpotsProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SpotsProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.SpotsProvider$removeSpot$3$1", f = "SpotsProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SpotsProvider$removeSpot$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ SpotsProvider.SpotsProviderListener $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpotsProvider$removeSpot$3$1(SpotsProvider.SpotsProviderListener spotsProviderListener, int r2, Continuation<? super SpotsProvider$removeSpot$3$1> continuation) {
        super(2, continuation);
        this.$it = spotsProviderListener;
        this.$index = r2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpotsProvider$removeSpot$3$1(this.$it, this.$index, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$it.onSpotRemoved(this.$index);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SpotsProvider$removeSpot$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
