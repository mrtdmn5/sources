package com.animaconnected.watch.behaviour.types;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.location.LocationProvider;
import com.animaconnected.watch.location.LocationResult;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RememberThisSpot.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.types.RememberThisSpot$getLocationResult$2", f = "RememberThisSpot.kt", l = {R.styleable.AppTheme_stepsHistoryColumnTodayColorActivity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RememberThisSpot$getLocationResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LocationResult>, Object> {
    int label;
    final /* synthetic */ RememberThisSpot this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RememberThisSpot$getLocationResult$2(RememberThisSpot rememberThisSpot, Continuation<? super RememberThisSpot$getLocationResult$2> continuation) {
        super(2, continuation);
        this.this$0 = rememberThisSpot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RememberThisSpot$getLocationResult$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LocationProvider locationProvider;
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
            locationProvider = this.this$0.locationProvider;
            this.label = 1;
            obj = locationProvider.getLocationSuspending(this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super LocationResult> continuation) {
        return ((RememberThisSpot$getLocationResult$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
