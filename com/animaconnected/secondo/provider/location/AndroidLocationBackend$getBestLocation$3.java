package com.animaconnected.secondo.provider.location;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.tasks.Task;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidLocationBackend.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.location.AndroidLocationBackend$getBestLocation$3", f = "AndroidLocationBackend.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AndroidLocationBackend$getBestLocation$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Task<Void>>, Object> {
    final /* synthetic */ Ref$ObjectRef<LocationCallback> $callback;
    final /* synthetic */ FusedLocationProviderClient $this_getBestLocation;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidLocationBackend$getBestLocation$3(Ref$ObjectRef<LocationCallback> ref$ObjectRef, FusedLocationProviderClient fusedLocationProviderClient, Continuation<? super AndroidLocationBackend$getBestLocation$3> continuation) {
        super(2, continuation);
        this.$callback = ref$ObjectRef;
        this.$this_getBestLocation = fusedLocationProviderClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidLocationBackend$getBestLocation$3(this.$callback, this.$this_getBestLocation, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LocationCallback locationCallback = this.$callback.element;
            if (locationCallback != null) {
                return this.$this_getBestLocation.removeLocationUpdates(locationCallback);
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Task<Void>> continuation) {
        return ((AndroidLocationBackend$getBestLocation$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
