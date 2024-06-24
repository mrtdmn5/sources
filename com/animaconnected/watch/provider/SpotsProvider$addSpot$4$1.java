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
@DebugMetadata(c = "com.animaconnected.watch.provider.SpotsProvider$addSpot$4$1", f = "SpotsProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SpotsProvider$addSpot$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SpotsProvider.SpotsProviderListener $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpotsProvider$addSpot$4$1(SpotsProvider.SpotsProviderListener spotsProviderListener, Continuation<? super SpotsProvider$addSpot$4$1> continuation) {
        super(2, continuation);
        this.$it = spotsProviderListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpotsProvider$addSpot$4$1(this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$it.onSpotAdded(0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SpotsProvider$addSpot$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
