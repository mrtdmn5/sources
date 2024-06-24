package com.animaconnected.watch.behaviour.types;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RememberThisSpot.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.types.RememberThisSpot$execute$1", f = "RememberThisSpot.kt", l = {50, 55}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RememberThisSpot$execute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RememberThisSpot this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RememberThisSpot$execute$1(RememberThisSpot rememberThisSpot, Continuation<? super RememberThisSpot$execute$1> continuation) {
        super(2, continuation);
        this.this$0 = rememberThisSpot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RememberThisSpot$execute$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0079  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.throwOnFailure(r5)
            goto L6f
        L10:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L18:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L35
        L1c:
            kotlin.ResultKt.throwOnFailure(r5)
            com.animaconnected.watch.behaviour.types.RememberThisSpot r5 = r4.this$0
            com.animaconnected.watch.behaviour.types.RememberThisSpotListener r5 = com.animaconnected.watch.behaviour.types.RememberThisSpot.access$getListener$p(r5)
            if (r5 == 0) goto L2a
            r5.onFetchingSpot()
        L2a:
            com.animaconnected.watch.behaviour.types.RememberThisSpot r5 = r4.this$0
            r4.label = r3
            java.lang.Object r5 = com.animaconnected.watch.behaviour.types.RememberThisSpot.access$getLocationResult(r5, r4)
            if (r5 != r0) goto L35
            return r0
        L35:
            com.animaconnected.watch.location.LocationResult r5 = (com.animaconnected.watch.location.LocationResult) r5
            com.animaconnected.watch.location.ErrorServiceDisabled r1 = com.animaconnected.watch.location.ErrorServiceDisabled.INSTANCE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r1)
            if (r1 == 0) goto L41
            r1 = r3
            goto L47
        L41:
            com.animaconnected.watch.location.ErrorMissingPermission r1 = com.animaconnected.watch.location.ErrorMissingPermission.INSTANCE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r1)
        L47:
            if (r1 == 0) goto L4a
            goto L50
        L4a:
            com.animaconnected.watch.location.ErrorNoLocation r1 = com.animaconnected.watch.location.ErrorNoLocation.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r1)
        L50:
            if (r3 == 0) goto L5e
            com.animaconnected.watch.behaviour.types.RememberThisSpot r0 = r4.this$0
            com.animaconnected.watch.behaviour.types.RememberThisSpotListener r0 = com.animaconnected.watch.behaviour.types.RememberThisSpot.access$getListener$p(r0)
            if (r0 == 0) goto L7c
            r0.onFetched(r5)
            goto L7c
        L5e:
            boolean r1 = r5 instanceof com.animaconnected.watch.location.Spot
            if (r1 == 0) goto L7c
            com.animaconnected.watch.behaviour.types.RememberThisSpot r1 = r4.this$0
            com.animaconnected.watch.location.Spot r5 = (com.animaconnected.watch.location.Spot) r5
            r4.label = r2
            java.lang.Object r5 = com.animaconnected.watch.behaviour.types.RememberThisSpot.access$saveSpot(r1, r5, r4)
            if (r5 != r0) goto L6f
            return r0
        L6f:
            com.animaconnected.watch.location.Spot r5 = (com.animaconnected.watch.location.Spot) r5
            com.animaconnected.watch.behaviour.types.RememberThisSpot r0 = r4.this$0
            com.animaconnected.watch.behaviour.types.RememberThisSpotListener r0 = com.animaconnected.watch.behaviour.types.RememberThisSpot.access$getListener$p(r0)
            if (r0 == 0) goto L7c
            r0.onFetched(r5)
        L7c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.types.RememberThisSpot$execute$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RememberThisSpot$execute$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
