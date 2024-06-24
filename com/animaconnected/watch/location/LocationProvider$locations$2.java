package com.animaconnected.watch.location;

import com.animaconnected.logger.LogKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: LocationProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.location.LocationProvider$locations$2", f = "LocationProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class LocationProvider$locations$2 extends SuspendLambda implements Function3<FlowCollector<? super LocationResult>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LocationProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationProvider$locations$2(LocationProvider locationProvider, Continuation<? super LocationProvider$locations$2> continuation) {
        super(3, continuation);
        this.this$0 = locationProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LogKt.verbose$default(this.L$0, this.this$0.getTag(), (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.location.LocationProvider$locations$2.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Location callback flow closed.";
                }
            }, 6, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super LocationResult> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        LocationProvider$locations$2 locationProvider$locations$2 = new LocationProvider$locations$2(this.this$0, continuation);
        locationProvider$locations$2.L$0 = flowCollector;
        return locationProvider$locations$2.invokeSuspend(Unit.INSTANCE);
    }
}
