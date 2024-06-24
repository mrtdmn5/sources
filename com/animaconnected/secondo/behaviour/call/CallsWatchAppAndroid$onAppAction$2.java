package com.animaconnected.secondo.behaviour.call;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CallsWatchAppAndroid.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid$onAppAction$2", f = "CallsWatchAppAndroid.kt", l = {60, 64}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CallsWatchAppAndroid$onAppAction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CallsWatchAppAndroid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallsWatchAppAndroid$onAppAction$2(CallsWatchAppAndroid callsWatchAppAndroid, Continuation<? super CallsWatchAppAndroid$onAppAction$2> continuation) {
        super(2, continuation);
        this.this$0 = callsWatchAppAndroid;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CallsWatchAppAndroid$onAppAction$2(this.this$0, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:            r4 = r11.this$0.watch;     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.throwOnFailure(r12)
            goto L74
        L10:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L18:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L30
        L1c:
            kotlin.ResultKt.throwOnFailure(r12)
            int r12 = kotlin.time.Duration.$r8$clinit
            kotlin.time.DurationUnit r12 = kotlin.time.DurationUnit.SECONDS
            long r4 = kotlin.time.DurationKt.toDuration(r2, r12)
            r11.label = r3
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.m1695delayVtjQ1oo(r4, r11)
            if (r12 != r0) goto L30
            return r0
        L30:
            com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid r12 = r11.this$0
            java.util.Set r12 = com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid.access$getActiveCalls$p(r12)
            java.util.Collection r12 = (java.util.Collection) r12
            boolean r12 = r12.isEmpty()
            r12 = r12 ^ r3
            if (r12 == 0) goto L74
            com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid r12 = r11.this$0
            com.animaconnected.watch.DisplayWatch r4 = com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid.access$getWatch$p(r12)
            if (r4 == 0) goto L74
            com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid r12 = r11.this$0
            int r5 = com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid.access$getCallId$p(r12)
            com.animaconnected.watch.device.CallState r6 = com.animaconnected.watch.device.CallState.OffHook
            com.animaconnected.watch.strings.Key r12 = com.animaconnected.watch.strings.Key.calls_multiple
            java.lang.String r7 = com.animaconnected.watch.strings.StringsExtensionsKt.getFirmwareString(r12)
            com.animaconnected.watch.CallHelper r12 = com.animaconnected.watch.CallHelper.INSTANCE
            boolean r8 = r12.canAnswerCalls()
            boolean r12 = r12.canEndCalls()
            if (r12 != 0) goto L69
            boolean r12 = com.animaconnected.watch.CallHelper.shouldMuteCalls()
            if (r12 == 0) goto L68
            goto L69
        L68:
            r3 = 0
        L69:
            r9 = r3
            r11.label = r2
            r10 = r11
            java.lang.Object r12 = com.animaconnected.watch.DisplayWatchJvm.setCallStatus(r4, r5, r6, r7, r8, r9, r10)
            if (r12 != r0) goto L74
            return r0
        L74:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.call.CallsWatchAppAndroid$onAppAction$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CallsWatchAppAndroid$onAppAction$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
