package com.animaconnected.secondo.provider.update;

import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DfuStatus;
import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchFotaProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.update.WatchFotaProvider$update$1", f = "WatchFotaProvider.kt", l = {81}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFotaProvider$update$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $fwFile;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatchFotaProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFotaProvider$update$1(WatchFotaProvider watchFotaProvider, File file, Continuation<? super WatchFotaProvider$update$1> continuation) {
        super(2, continuation);
        this.this$0 = watchFotaProvider;
        this.$fwFile = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchFotaProvider$update$1 watchFotaProvider$update$1 = new WatchFotaProvider$update$1(this.this$0, this.$fwFile, continuation);
        watchFotaProvider$update$1.L$0 = obj;
        return watchFotaProvider$update$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
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
            WatchProvider watch = ProviderFactory.getWatch();
            this.L$0 = coroutineScope2;
            this.label = 1;
            Object dfuStatus = watch.getDfuStatus(this);
            if (dfuStatus == coroutineSingletons) {
                return coroutineSingletons;
            }
            coroutineScope = coroutineScope2;
            obj = dfuStatus;
        }
        DfuStatus dfuStatus2 = (DfuStatus) obj;
        if (dfuStatus2.getSafeToDfu()) {
            this.this$0.startFota(ProviderFactory.getWatch(), this.$fwFile);
        } else {
            LogKt.debug$default((Object) coroutineScope, "DFU not ready, can't start FOTA: " + dfuStatus2, (String) null, (Throwable) null, false, 14, (Object) null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchFotaProvider$update$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
