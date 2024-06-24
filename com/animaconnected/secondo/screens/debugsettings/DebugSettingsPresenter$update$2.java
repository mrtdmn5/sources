package com.animaconnected.secondo.screens.debugsettings;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DebugSettingsPresenter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$update$2", f = "DebugSettingsPresenter.kt", l = {89, 93}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugSettingsPresenter$update$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DebugSettingsPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugSettingsPresenter$update$2(DebugSettingsPresenter debugSettingsPresenter, Continuation<? super DebugSettingsPresenter$update$2> continuation) {
        super(2, continuation);
        this.this$0 = debugSettingsPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugSettingsPresenter$update$2(this.this$0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00cc A[LOOP:0: B:10:0x00a5->B:12:0x00cc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0099  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L2a
            if (r2 == r4) goto L24
            if (r2 != r3) goto L1c
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r20)
            r3 = r20
            goto L58
        L1c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L24:
            kotlin.ResultKt.throwOnFailure(r20)
            r2 = r20
            goto L3d
        L2a:
            kotlin.ResultKt.throwOnFailure(r20)
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter r2 = r0.this$0
            r2.updateBluetoothStatus()
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter r2 = r0.this$0
            r0.label = r4
            java.lang.Object r2 = com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter.access$fetchUserCategoryAndFwVersion(r2, r0)
            if (r2 != r1) goto L3d
            return r1
        L3d:
            kotlin.Pair r2 = (kotlin.Pair) r2
            A r4 = r2.first
            java.lang.String r4 = (java.lang.String) r4
            B r2 = r2.second
            java.lang.String r2 = (java.lang.String) r2
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter r5 = r0.this$0
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r3 = com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter.access$fetchFirmwareUpdateStatus(r5, r0)
            if (r3 != r1) goto L56
            return r1
        L56:
            r1 = r2
            r2 = r4
        L58:
            java.lang.String r3 = (java.lang.String) r3
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter r4 = r0.this$0
            com.animaconnected.watch.WatchProvider r4 = com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter.access$getWatchProvider$p(r4)
            java.lang.String r4 = r4.getLastDfuReadyResult()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            com.animaconnected.secondo.screens.debugsettings.DebugFirmwareStatus r15 = new com.animaconnected.secondo.screens.debugsettings.DebugFirmwareStatus
            r15.<init>(r1, r3, r4)
            com.animaconnected.secondo.screens.debugsettings.DebugAppInfo r1 = new com.animaconnected.secondo.screens.debugsettings.DebugAppInfo
            com.animaconnected.secondo.KronabyApplication$Companion r3 = com.animaconnected.secondo.KronabyApplication.Companion
            android.content.Context r3 = r3.getContext()
            java.lang.String r3 = com.animaconnected.secondo.utils.AppUtils.getVersion(r3)
            java.lang.String r4 = "getVersion(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            com.animaconnected.secondo.provider.PoolIdProvider r4 = com.animaconnected.secondo.provider.ProviderFactory.getPoolIdProvider()
            boolean r4 = r4.isOnSandbox()
            com.animaconnected.logger.LibLogger r5 = com.animaconnected.logger.LogKt.getCurrentLogger()
            boolean r5 = r5 instanceof com.animaconnected.secondo.utils.debugging.DogfoodLogger
            r1.<init>(r3, r2, r4, r5)
            com.animaconnected.secondo.provider.status.StatusProvider r2 = com.animaconnected.secondo.provider.ProviderFactory.getStatusProvider()
            com.animaconnected.secondo.provider.status.internal.app.PowerOptimizationStatusController r2 = r2.getPowerOptimizationController()
            if (r2 == 0) goto L9e
            boolean r2 = r2.isIgnoringBatteryOptimizations()
            goto L9f
        L9e:
            r2 = 0
        L9f:
            com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter r3 = r0.this$0
            kotlinx.coroutines.flow.MutableStateFlow r3 = r3.getUiState()
        La5:
            java.lang.Object r4 = r3.getValue()
            r5 = r4
            com.animaconnected.secondo.screens.debugsettings.DebugUiState r5 = (com.animaconnected.secondo.screens.debugsettings.DebugUiState) r5
            r6 = 0
            r7 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r16 = 243(0xf3, float:3.4E-43)
            r17 = 0
            r8 = r15
            r9 = r1
            r14 = r2
            r18 = r15
            r15 = r16
            r16 = r17
            com.animaconnected.secondo.screens.debugsettings.DebugUiState r5 = com.animaconnected.secondo.screens.debugsettings.DebugUiState.copy$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r4 = r3.compareAndSet(r4, r5)
            if (r4 == 0) goto Lcc
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        Lcc:
            r15 = r18
            goto La5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugSettingsPresenter$update$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugSettingsPresenter$update$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
