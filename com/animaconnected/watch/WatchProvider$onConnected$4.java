package com.animaconnected.watch;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider$onConnected$4", f = "WatchProvider.kt", l = {783}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchProvider$onConnected$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatchProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchProvider$onConnected$4(WatchProvider watchProvider, Continuation<? super WatchProvider$onConnected$4> continuation) {
        super(2, continuation);
        this.this$0 = watchProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchProvider$onConnected$4 watchProvider$onConnected$4 = new WatchProvider$onConnected$4(this.this$0, continuation);
        watchProvider$onConnected$4.L$0 = obj;
        return watchProvider$onConnected$4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0083, code lost:            return kotlin.Unit.INSTANCE;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007e, code lost:            if (com.animaconnected.watch.LePingReqKt.getNeedsLePingRegWorkaround(r10.this$0) != false) goto L22;     */
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
            java.lang.String r2 = "LePingReq-enabled"
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 != r3) goto L17
            java.lang.Object r0 = r10.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L69
            goto L54
        L13:
            r11 = move-exception
            r6 = r11
            r3 = r0
            goto L6e
        L17:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1f:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            com.animaconnected.watch.WatchProvider r1 = r10.this$0     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            r1.setWroteOnboardingDeviceSettings(r3)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            com.animaconnected.watch.WatchProvider r1 = r10.this$0     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            java.util.Set r1 = com.animaconnected.watch.WatchProvider.access$getListeners$p(r1)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
        L37:
            boolean r4 = r1.hasNext()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            if (r4 == 0) goto L47
            java.lang.Object r4 = r1.next()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            com.animaconnected.watch.WatchProvider$WatchProviderListener r4 = (com.animaconnected.watch.WatchProvider.WatchProviderListener) r4     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            r4.onWroteDeviceSettings()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            goto L37
        L47:
            com.animaconnected.watch.WatchProvider r1 = r10.this$0     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            r10.L$0 = r11     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            r10.label = r3     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            java.lang.Object r11 = com.animaconnected.watch.WatchProvider.access$readDeviceDebugDisconnect(r1, r10)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            if (r11 != r0) goto L54
            return r0
        L54:
            com.animaconnected.watch.WatchProvider r11 = r10.this$0
            boolean r11 = com.animaconnected.watch.LePingReqKt.getNeedsLePingRegWorkaround(r11)
            if (r11 == 0) goto L81
        L5c:
            com.animaconnected.firebase.AppEvents r11 = com.animaconnected.secondo.provider.ProviderFactory.getAppAnalytics()
            r11.sendAction(r2)
            com.animaconnected.watch.LePingReq r11 = com.animaconnected.watch.LePingReq.INSTANCE
            r11.enable()
            goto L81
        L69:
            r11 = move-exception
            goto L84
        L6b:
            r0 = move-exception
            r3 = r11
            r6 = r0
        L6e:
            java.lang.String r4 = "Failed to read data during onConnect()"
            r5 = 0
            r7 = 0
            r8 = 10
            r9 = 0
            com.animaconnected.logger.LogKt.debug$default(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L69
            com.animaconnected.watch.WatchProvider r11 = r10.this$0
            boolean r11 = com.animaconnected.watch.LePingReqKt.getNeedsLePingRegWorkaround(r11)
            if (r11 == 0) goto L81
            goto L5c
        L81:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L84:
            com.animaconnected.watch.WatchProvider r0 = r10.this$0
            boolean r0 = com.animaconnected.watch.LePingReqKt.getNeedsLePingRegWorkaround(r0)
            if (r0 == 0) goto L98
            com.animaconnected.firebase.AppEvents r0 = com.animaconnected.secondo.provider.ProviderFactory.getAppAnalytics()
            r0.sendAction(r2)
            com.animaconnected.watch.LePingReq r0 = com.animaconnected.watch.LePingReq.INSTANCE
            r0.enable()
        L98:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider$onConnected$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchProvider$onConnected$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
