package com.animaconnected.secondo.screens.settings;

import com.animaconnected.secondo.provider.update.WatchUpdateProvider;
import com.animaconnected.watch.device.DfuStatus;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: WatchSettingsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.WatchSettingsFragment$updateDfuReady$1", f = "WatchSettingsFragment.kt", l = {385}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchSettingsFragment$updateDfuReady$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatchSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchSettingsFragment$updateDfuReady$1(WatchSettingsFragment watchSettingsFragment, Continuation<? super WatchSettingsFragment$updateDfuReady$1> continuation) {
        super(2, continuation);
        this.this$0 = watchSettingsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchSettingsFragment$updateDfuReady$1 watchSettingsFragment$updateDfuReady$1 = new WatchSettingsFragment$updateDfuReady$1(this.this$0, continuation);
        watchSettingsFragment$updateDfuReady$1.L$0 = obj;
        return watchSettingsFragment$updateDfuReady$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WatchUpdateProvider watchUpdateProvider;
        CoroutineScope coroutineScope;
        String readableError;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            watchUpdateProvider = this.this$0.watchUpdateProvider;
            this.L$0 = coroutineScope2;
            this.label = 1;
            Object isDeviceReadyForDfu = watchUpdateProvider.isDeviceReadyForDfu(this);
            if (isDeviceReadyForDfu == coroutineSingletons) {
                return coroutineSingletons;
            }
            coroutineScope = coroutineScope2;
            obj = isDeviceReadyForDfu;
        }
        DfuStatus dfuStatus = (DfuStatus) obj;
        if (!CoroutineScopeKt.isActive(coroutineScope)) {
            return Unit.INSTANCE;
        }
        if (dfuStatus.getSafeToDfu()) {
            this.this$0.showWatchUpdateStart();
        } else {
            WatchSettingsFragment watchSettingsFragment = this.this$0;
            readableError = watchSettingsFragment.readableError(dfuStatus);
            watchSettingsFragment.showWatchUpdateWarning(readableError);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchSettingsFragment$updateDfuReady$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
