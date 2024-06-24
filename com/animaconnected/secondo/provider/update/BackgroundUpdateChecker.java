package com.animaconnected.secondo.provider.update;

import android.content.Context;
import android.util.Log;
import com.animaconnected.future.AlwaysCallback;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureUtils;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.productinfo.ProductInfoProvider;
import com.animaconnected.secondo.provider.update.WatchAppUpdateProvider;
import com.animaconnected.secondo.screens.debugsettings.DebugStorage;
import com.animaconnected.watch.WatchProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class BackgroundUpdateChecker {
    private static final String TAG = "BackgroundUpdateChecker";
    private final Context mContext;
    private final WatchAppUpdateProvider.FirmwareListener mFirmwareListener;
    private final List<UpdateChangeListener> mListeners = new ArrayList();
    private long mPrevUpdateCheckIntervalHours;
    private final RemoteConfigController mRemoteConfigController;
    private final RemoteConfigController.RemoteConfigControllerListener mRemoteConfigListener;
    private final UpdateJobScheduler mScheduler;
    private final WatchProvider mWatch;
    private final WatchAppUpdateProvider mWatchAppUpdateProvider;

    /* renamed from: com.animaconnected.secondo.provider.update.BackgroundUpdateChecker$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements WatchAppUpdateProvider.FirmwareListener {
        public AnonymousClass1() {
        }

        @Override // com.animaconnected.secondo.provider.update.WatchAppUpdateProvider.FirmwareListener
        public void onDfuFirmwareDownloaded(File file, String str) {
            BackgroundUpdateChecker.this.notifyListeners();
        }

        @Override // com.animaconnected.secondo.provider.update.WatchAppUpdateProvider.FirmwareListener
        public void onFirmwareRemoved() {
            BackgroundUpdateChecker.this.notifyListeners();
        }

        @Override // com.animaconnected.secondo.provider.update.WatchAppUpdateProvider.FirmwareListener
        public void onFotaFirmwareDownloaded(File file, String str) {
            BackgroundUpdateChecker.this.notifyListeners();
        }
    }

    public BackgroundUpdateChecker(WatchProvider watchProvider, UpdateJobScheduler updateJobScheduler, WatchAppUpdateProvider watchAppUpdateProvider, Context context, RemoteConfigController remoteConfigController) {
        AnonymousClass1 anonymousClass1 = new WatchAppUpdateProvider.FirmwareListener() { // from class: com.animaconnected.secondo.provider.update.BackgroundUpdateChecker.1
            public AnonymousClass1() {
            }

            @Override // com.animaconnected.secondo.provider.update.WatchAppUpdateProvider.FirmwareListener
            public void onDfuFirmwareDownloaded(File file, String str) {
                BackgroundUpdateChecker.this.notifyListeners();
            }

            @Override // com.animaconnected.secondo.provider.update.WatchAppUpdateProvider.FirmwareListener
            public void onFirmwareRemoved() {
                BackgroundUpdateChecker.this.notifyListeners();
            }

            @Override // com.animaconnected.secondo.provider.update.WatchAppUpdateProvider.FirmwareListener
            public void onFotaFirmwareDownloaded(File file, String str) {
                BackgroundUpdateChecker.this.notifyListeners();
            }
        };
        this.mFirmwareListener = anonymousClass1;
        AnonymousClass2 anonymousClass2 = new RemoteConfigController.RemoteConfigControllerListener() { // from class: com.animaconnected.secondo.provider.update.BackgroundUpdateChecker.2
            public AnonymousClass2() {
            }

            @Override // com.animaconnected.secondo.app.RemoteConfigController.RemoteConfigControllerListener
            public void onFetch() {
                BackgroundUpdateChecker.this.configureFromRemoteConfig();
            }

            @Override // com.animaconnected.secondo.app.RemoteConfigController.RemoteConfigControllerListener
            public void onFetchFailed(String str) {
            }
        };
        this.mRemoteConfigListener = anonymousClass2;
        this.mWatch = watchProvider;
        this.mScheduler = updateJobScheduler;
        this.mWatchAppUpdateProvider = watchAppUpdateProvider;
        this.mContext = context.getApplicationContext();
        this.mRemoteConfigController = remoteConfigController;
        configureFromRemoteConfig();
        remoteConfigController.registerListener(anonymousClass2);
        watchAppUpdateProvider.registerFirmwareListener(anonymousClass1);
    }

    public void configureFromRemoteConfig() {
        long appConfigUpdateCheckIntervalHours = this.mRemoteConfigController.getAppConfigUpdateCheckIntervalHours();
        if (appConfigUpdateCheckIntervalHours != this.mPrevUpdateCheckIntervalHours) {
            this.mPrevUpdateCheckIntervalHours = appConfigUpdateCheckIntervalHours;
            this.mScheduler.schedulePeriodicUpdateJob(appConfigUpdateCheckIntervalHours * 60 * 60 * 1000);
        }
    }

    public /* synthetic */ void lambda$refreshNow$0() {
        if (ProductInfoProvider.getCurrentSkuData() != null) {
            this.mWatch.setSku(ProductInfoProvider.getCurrentSkuData().sku);
        }
    }

    public void notifyListeners() {
        Iterator<UpdateChangeListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onUpdateInfoChanged();
        }
    }

    public Future<Void> refreshNow() {
        Log.d(TAG, "Refreshing update info");
        ProductInfoProvider.updateProductInfoFuture(true).always(new AlwaysCallback() { // from class: com.animaconnected.secondo.provider.update.BackgroundUpdateChecker$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.AlwaysCallback
            public final void onFinished() {
                BackgroundUpdateChecker.this.lambda$refreshNow$0();
            }
        });
        ProviderFactory.getRemoteCrashProvider().crashDeviceIfNeeded();
        if (!DebugStorage.getUpdateFotaFromCloud(this.mContext)) {
            return FutureUtils.error(new Throwable("FOTA update disabled in debug"));
        }
        return this.mWatchAppUpdateProvider.downloadIfAvailable(this.mWatch);
    }

    public void registerListener(UpdateChangeListener updateChangeListener) {
        this.mListeners.add(updateChangeListener);
    }

    public void unregisterListener(UpdateChangeListener updateChangeListener) {
        this.mListeners.remove(updateChangeListener);
    }

    /* renamed from: com.animaconnected.secondo.provider.update.BackgroundUpdateChecker$2 */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 implements RemoteConfigController.RemoteConfigControllerListener {
        public AnonymousClass2() {
        }

        @Override // com.animaconnected.secondo.app.RemoteConfigController.RemoteConfigControllerListener
        public void onFetch() {
            BackgroundUpdateChecker.this.configureFromRemoteConfig();
        }

        @Override // com.animaconnected.secondo.app.RemoteConfigController.RemoteConfigControllerListener
        public void onFetchFailed(String str) {
        }
    }
}
