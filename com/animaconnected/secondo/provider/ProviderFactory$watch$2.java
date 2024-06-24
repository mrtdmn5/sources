package com.animaconnected.secondo.provider;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.app.DeviceManager;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.behaviour.BehaviourFactory;
import com.animaconnected.secondo.provider.update.WatchAppUpdateProvider;
import com.animaconnected.secondo.provider.update.WatchFotaProvider;
import com.animaconnected.secondo.provider.update.WatchUpdateProvider;
import com.animaconnected.secondo.utils.ThreadUtils;
import com.animaconnected.watch.WatchProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ProviderFactory.kt */
/* loaded from: classes3.dex */
public final class ProviderFactory$watch$2 extends Lambda implements Function0<WatchProvider> {
    public static final ProviderFactory$watch$2 INSTANCE = new ProviderFactory$watch$2();

    public ProviderFactory$watch$2() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(WatchProvider watchProvider) {
        Intrinsics.checkNotNullParameter(watchProvider, "$watchProvider");
        watchProvider.init();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WatchProvider invoke() {
        Context applicationContext;
        Context applicationContext2;
        Context applicationContext3;
        Context applicationContext4;
        WatchUpdateProvider watchUpdateProvider;
        ThreadUtils.assertIsOnMainThread();
        ProviderFactory providerFactory = ProviderFactory.INSTANCE;
        applicationContext = providerFactory.getApplicationContext();
        BehaviourFactory behaviourFactory = ProviderFactory.getBehaviourFactory();
        RemoteConfigController.Companion companion = RemoteConfigController.Companion;
        applicationContext2 = providerFactory.getApplicationContext();
        final WatchProvider watchProvider = new WatchProvider(applicationContext, behaviourFactory, companion.getInstance(applicationContext2));
        LogKt.info$default((Object) providerFactory, "ProviderFactory", (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.provider.ProviderFactory$watch$2.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "WatchProvider initialized";
            }
        }, 2, (Object) null);
        applicationContext3 = providerFactory.getApplicationContext();
        new DeviceManager(applicationContext3).listenTo(watchProvider);
        applicationContext4 = providerFactory.getApplicationContext();
        ProviderFactory.sWatchUpdateProvider = new WatchUpdateProvider(watchProvider, applicationContext4);
        WatchAppUpdateProvider watchAppUpdateProvider = ProviderFactory.getWatchAppUpdateProvider();
        watchUpdateProvider = ProviderFactory.sWatchUpdateProvider;
        Intrinsics.checkNotNull(watchUpdateProvider);
        ProviderFactory.sWatchFotaProvider = new WatchFotaProvider(watchProvider, watchAppUpdateProvider, watchUpdateProvider);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.animaconnected.secondo.provider.ProviderFactory$watch$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ProviderFactory$watch$2.invoke$lambda$1(WatchProvider.this);
            }
        });
        return watchProvider;
    }
}
