package com.animaconnected.secondo.provider.location;

import android.location.Location;
import android.os.Looper;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.location.AndroidLocationBackend;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidLocationBackend.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.location.AndroidLocationBackend$getBestLocation$2", f = "AndroidLocationBackend.kt", l = {322}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AndroidLocationBackend$getBestLocation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Location>, Object> {
    final /* synthetic */ Ref$ObjectRef<Location> $bestLocation;
    final /* synthetic */ Ref$ObjectRef<LocationCallback> $callback;
    final /* synthetic */ AndroidLocationBackend.LocationCriteria $locationCriteria;
    final /* synthetic */ Looper $mainLooper;
    final /* synthetic */ LocationRequest $request;
    final /* synthetic */ FusedLocationProviderClient $this_getBestLocation;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidLocationBackend$getBestLocation$2(Ref$ObjectRef<LocationCallback> ref$ObjectRef, AndroidLocationBackend.LocationCriteria locationCriteria, Ref$ObjectRef<Location> ref$ObjectRef2, FusedLocationProviderClient fusedLocationProviderClient, LocationRequest locationRequest, Looper looper, Continuation<? super AndroidLocationBackend$getBestLocation$2> continuation) {
        super(2, continuation);
        this.$callback = ref$ObjectRef;
        this.$locationCriteria = locationCriteria;
        this.$bestLocation = ref$ObjectRef2;
        this.$this_getBestLocation = fusedLocationProviderClient;
        this.$request = locationRequest;
        this.$mainLooper = looper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidLocationBackend$getBestLocation$2(this.$callback, this.$locationCriteria, this.$bestLocation, this.$this_getBestLocation, this.$request, this.$mainLooper, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.animaconnected.secondo.provider.location.AndroidLocationBackend$getBestLocation$2$1$1, com.google.android.gms.location.LocationCallback] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
            Ref$ObjectRef<LocationCallback> ref$ObjectRef = this.$callback;
            final AndroidLocationBackend.LocationCriteria locationCriteria = this.$locationCriteria;
            final Ref$ObjectRef<Location> ref$ObjectRef2 = this.$bestLocation;
            FusedLocationProviderClient fusedLocationProviderClient = this.$this_getBestLocation;
            LocationRequest locationRequest = this.$request;
            Looper looper = this.$mainLooper;
            this.L$0 = ref$ObjectRef;
            this.L$1 = locationCriteria;
            this.L$2 = ref$ObjectRef2;
            this.L$3 = fusedLocationProviderClient;
            this.L$4 = locationRequest;
            this.L$5 = looper;
            this.label = 1;
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(this));
            cancellableContinuationImpl.initCancellability();
            ?? r2 = new LocationCallback() { // from class: com.animaconnected.secondo.provider.location.AndroidLocationBackend$getBestLocation$2$1$1
                /* JADX WARN: Type inference failed for: r11v3, types: [T, java.lang.Object, android.location.Location] */
                @Override // com.google.android.gms.location.LocationCallback
                public void onLocationResult(LocationResult locationResult) {
                    boolean isRecent;
                    Intrinsics.checkNotNullParameter(locationResult, "locationResult");
                    List list = locationResult.zzb;
                    Intrinsics.checkNotNullExpressionValue(list, "getLocations(...)");
                    ?? r11 = (Location) CollectionsKt___CollectionsKt.lastOrNull(list);
                    if (r11 != 0) {
                        AndroidLocationBackend.LocationCriteria locationCriteria2 = AndroidLocationBackend.LocationCriteria.this;
                        CancellableContinuation<Location> cancellableContinuation = cancellableContinuationImpl;
                        Ref$ObjectRef<Location> ref$ObjectRef3 = ref$ObjectRef2;
                        isRecent = AndroidLocationBackend.INSTANCE.isRecent(r11, locationCriteria2.getValidTimeMin());
                        if (isRecent && r11.getAccuracy() <= locationCriteria2.getAccuracyInMeter()) {
                            LogKt.debug$default((Object) this, "Found location matching criteria", (String) null, (Throwable) null, false, 14, (Object) null);
                            if (cancellableContinuation.isActive()) {
                                cancellableContinuation.resumeWith(r11);
                                return;
                            }
                            return;
                        }
                        Location location = ref$ObjectRef3.element;
                        if (location != null) {
                            Intrinsics.checkNotNull(location);
                            if (location.getAccuracy() < r11.getAccuracy()) {
                                return;
                            }
                        }
                        ref$ObjectRef3.element = r11;
                    }
                }
            };
            ref$ObjectRef.element = r2;
            fusedLocationProviderClient.requestLocationUpdates(locationRequest, r2, looper);
            obj = cancellableContinuationImpl.getResult();
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Location> continuation) {
        return ((AndroidLocationBackend$getBestLocation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
