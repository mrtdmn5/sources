package com.animaconnected.watch.behaviour.types;

import com.animaconnected.watch.device.ButtonAction;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Ifttt.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.types.Ifttt$sendTrigger$1", f = "Ifttt.kt", l = {53, 54}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Ifttt$sendTrigger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ButtonAction $action;
    int label;
    final /* synthetic */ Ifttt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ifttt$sendTrigger$1(Ifttt ifttt, ButtonAction buttonAction, Continuation<? super Ifttt$sendTrigger$1> continuation) {
        super(2, continuation);
        this.this$0 = ifttt;
        this.$action = buttonAction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Ifttt$sendTrigger$1(this.this$0, this.$action, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0058  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r10.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L1d
            if (r1 == r4) goto L19
            if (r1 != r3) goto L11
            kotlin.ResultKt.throwOnFailure(r11)
            goto L48
        L11:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L19:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L31
        L1d:
            kotlin.ResultKt.throwOnFailure(r11)
            com.animaconnected.watch.behaviour.types.Ifttt r11 = r10.this$0
            r5 = 1
            r6 = 0
            r8 = 2
            r9 = 0
            r10.label = r4
            r4 = r11
            r7 = r10
            java.lang.Object r11 = com.animaconnected.watch.display.RemoteAppImpl.changeView$default(r4, r5, r6, r7, r8, r9)
            if (r11 != r0) goto L31
            return r0
        L31:
            com.animaconnected.watch.behaviour.types.Ifttt r11 = r10.this$0
            boolean r11 = r11.getLocationEnabled()
            if (r11 == 0) goto L4b
            com.animaconnected.watch.ServiceLocator r11 = com.animaconnected.watch.ServiceLocator.INSTANCE
            com.animaconnected.watch.location.LocationProvider r11 = r11.getLocationProvider()
            r10.label = r3
            java.lang.Object r11 = r11.getLocationSuspending(r10)
            if (r11 != r0) goto L48
            return r0
        L48:
            com.animaconnected.watch.location.LocationResult r11 = (com.animaconnected.watch.location.LocationResult) r11
            goto L4c
        L4b:
            r11 = r2
        L4c:
            com.animaconnected.watch.behaviour.types.Ifttt r0 = r10.this$0
            com.animaconnected.watch.behaviour.types.IftttApi r0 = com.animaconnected.watch.behaviour.types.Ifttt.access$getApi$p(r0)
            com.animaconnected.watch.device.ButtonAction r1 = r10.$action
            boolean r3 = r11 instanceof com.animaconnected.watch.location.Spot
            if (r3 == 0) goto L5b
            r2 = r11
            com.animaconnected.watch.location.Spot r2 = (com.animaconnected.watch.location.Spot) r2
        L5b:
            com.animaconnected.watch.behaviour.types.Ifttt$sendTrigger$1$1 r11 = new com.animaconnected.watch.behaviour.types.Ifttt$sendTrigger$1$1
            com.animaconnected.watch.behaviour.types.Ifttt r3 = r10.this$0
            r11.<init>()
            r0.sendIftttTrigger(r1, r2, r11)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.types.Ifttt$sendTrigger$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Ifttt$sendTrigger$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
