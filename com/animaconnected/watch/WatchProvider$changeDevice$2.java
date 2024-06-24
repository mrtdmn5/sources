package com.animaconnected.watch;

import android.content.Context;
import com.animaconnected.future.Future;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.analytics.WatchProviderAnalytics;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.storage.models.DBWatch;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider$changeDevice$2", f = "WatchProvider.kt", l = {1183}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchProvider$changeDevice$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Future<Void>>, Object> {
    final /* synthetic */ String $address;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatchProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchProvider$changeDevice$2(WatchProvider watchProvider, String str, Continuation<? super WatchProvider$changeDevice$2> continuation) {
        super(2, continuation);
        this.this$0 = watchProvider;
        this.$address = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchProvider$changeDevice$2 watchProvider$changeDevice$2 = new WatchProvider$changeDevice$2(this.this$0, this.$address, continuation);
        watchProvider$changeDevice$2.L$0 = obj;
        return watchProvider$changeDevice$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DeviceInterface deviceInterface;
        String str;
        CoroutineScope coroutineScope;
        WatchProvider.Vibrations vibrations;
        Context context;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        String str2 = null;
        if (r1 != 0) {
            if (r1 == 1) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope = coroutineScope2;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            this.this$0.getWatchManager().unregisterEventListener(this.this$0);
            WatchProvider watchProvider = this.this$0;
            deviceInterface = watchProvider.device;
            if (deviceInterface != null) {
                vibrations = this.this$0.vibrations;
                vibrations.stopVibrateForIncomingCall();
                deviceInterface.close();
            }
            watchProvider.device = null;
            this.this$0.onDisconnected();
            StringBuilder sb = new StringBuilder("Multi-watch: Old watch: ");
            DBWatch currentWatch = this.this$0.getDb().getCurrentWatch();
            if (currentWatch != null) {
                str = currentWatch.getDevice_address();
            } else {
                str = null;
            }
            sb.append(str);
            LogKt.debug$default((Object) coroutineScope3, sb.toString(), (String) null, (Throwable) null, true, 6, (Object) null);
            WatchManager watchManager = this.this$0.getWatchManager();
            String str3 = this.$address;
            this.L$0 = coroutineScope3;
            this.label = 1;
            if (watchManager.setPreferredWatch(str3, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            coroutineScope = coroutineScope3;
        }
        StringBuilder sb2 = new StringBuilder("Multi-watch: New watch: ");
        DBWatch currentWatch2 = this.this$0.getDb().getCurrentWatch();
        if (currentWatch2 != null) {
            str2 = currentWatch2.getDevice_address();
        }
        sb2.append(str2);
        LogKt.debug$default((Object) coroutineScope, sb2.toString(), (String) null, (Throwable) null, true, 6, (Object) null);
        WatchProvider watchProvider2 = this.this$0;
        context = watchProvider2.context;
        WatchProviderAnalytics.sendDevicesAnalytics(watchProvider2, context);
        this.this$0.setupDevice();
        return ProviderFactory.getBackgroundUpdateChecker().refreshNow();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Future<Void>> continuation) {
        return ((WatchProvider$changeDevice$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
