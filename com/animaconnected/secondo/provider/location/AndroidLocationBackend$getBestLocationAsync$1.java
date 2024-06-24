package com.animaconnected.secondo.provider.location;

import com.animaconnected.secondo.provider.location.AndroidLocationBackend;
import com.animaconnected.watch.location.LocationResult;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidLocationBackend.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.location.AndroidLocationBackend$getBestLocationAsync$1", f = "AndroidLocationBackend.kt", l = {76, 90}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AndroidLocationBackend$getBestLocationAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<LocationResult, Unit> $listener;
    final /* synthetic */ AndroidLocationBackend.LocationCriteria $locationCriteria;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidLocationBackend$getBestLocationAsync$1(AndroidLocationBackend.LocationCriteria locationCriteria, Function1<? super LocationResult, Unit> function1, Continuation<? super AndroidLocationBackend$getBestLocationAsync$1> continuation) {
        super(2, continuation);
        this.$locationCriteria = locationCriteria;
        this.$listener = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidLocationBackend$getBestLocationAsync$1 androidLocationBackend$getBestLocationAsync$1 = new AndroidLocationBackend$getBestLocationAsync$1(this.$locationCriteria, this.$listener, continuation);
        androidLocationBackend$getBestLocationAsync$1.L$0 = obj;
        return androidLocationBackend$getBestLocationAsync$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00bb A[Catch: Exception -> 0x0017, TryCatch #0 {Exception -> 0x0017, blocks: (B:8:0x0012, B:9:0x00b7, B:11:0x00bb, B:15:0x00d8), top: B:7:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d8 A[Catch: Exception -> 0x0017, TRY_LEAVE, TryCatch #0 {Exception -> 0x0017, blocks: (B:8:0x0012, B:9:0x00b7, B:11:0x00bb, B:15:0x00d8), top: B:7:0x0012 }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.location.AndroidLocationBackend$getBestLocationAsync$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidLocationBackend$getBestLocationAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
