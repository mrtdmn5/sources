package com.animaconnected.secondo.provider.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.animaconnected.cloud.Cloud;
import com.animaconnected.cloud.util.CloudStatusApp;
import com.animaconnected.cloud.util.CloudStatusDevice;
import com.animaconnected.cloud.util.CloudStatusMobile;
import com.animaconnected.cloud.util.CloudStatusResponse;
import com.animaconnected.dfu.fota.utils.FotaZipArchive;
import com.animaconnected.future.FailCallback;
import com.animaconnected.future.FlatMapCallback;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureUtils;
import com.animaconnected.future.MapCallback;
import com.animaconnected.future.Promise;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.FirmwareVariant;
import com.animaconnected.info.UserCategoryKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.BuildConfig;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.misc.ConfigProvider;
import com.animaconnected.secondo.screens.watchupdate.BundledFirmware;
import com.animaconnected.secondo.screens.watchupdate.BundledFirmwareKt;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.BaseFirmwareVersion;
import com.animaconnected.watch.device.DeviceInfo;
import com.animaconnected.watch.device.FirmwareUpdate;
import com.animaconnected.watch.device.FirmwareVersion;
import com.animaconnected.watch.device.FirmwareVersionKt;
import com.google.common.io.Files;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: WatchAppUpdateProvider.kt */
/* loaded from: classes3.dex */
public final class WatchAppUpdateProvider {
    private static final String APP_VARIANT = "";
    private static final String FW_FILENAME = "fw.zip";
    private static final String PLATFORM = "Android";
    private static final String SHARED_PREFS_NAME = "cachedFirmware";
    private static final String SHARED_PREFS_VERSION_KEY = "version";
    private final Cloud cloud;
    private final ConfigProvider config;
    private final Context context;
    private final Set<FirmwareListener> firmwareListeners;
    private final Set<FotaVersionListener> fotaVersionListeners;
    private final SharedPreferences sharedPreferences;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: WatchAppUpdateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: WatchAppUpdateProvider.kt */
    /* loaded from: classes3.dex */
    public final class DebugFirmwareReceiver extends BroadcastReceiver {
        public DebugFirmwareReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Bundle extras = intent.getExtras();
            if (extras == null) {
                WatchAppUpdateProvider.this.setCachedVersion(null);
                WatchAppUpdateProvider.this.onFirmwareRemoved();
            } else {
                String string = extras.getString("DFU_FILE_PATH");
                if (string != null) {
                    WatchAppUpdateProvider.this.setDebugFirmware(new File(string));
                }
            }
        }
    }

    /* compiled from: WatchAppUpdateProvider.kt */
    /* loaded from: classes3.dex */
    public interface FirmwareListener {
        void onDfuFirmwareDownloaded(File file, String str);

        void onFirmwareRemoved();

        void onFotaFirmwareDownloaded(File file, String str);
    }

    /* compiled from: WatchAppUpdateProvider.kt */
    /* loaded from: classes3.dex */
    public interface FotaVersionListener {
        void onNewFotaVersionDownloaded();
    }

    public WatchAppUpdateProvider(Cloud cloud, ConfigProvider config, Context context) {
        Intrinsics.checkNotNullParameter(cloud, "cloud");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(context, "context");
        this.cloud = cloud;
        this.config = config;
        this.context = context;
        this.firmwareListeners = new CopyOnWriteArraySet();
        this.fotaVersionListeners = new CopyOnWriteArraySet();
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, 0);
    }

    private final Future<Void> download(final CloudStatusResponse cloudStatusResponse, final FirmwareUpdate firmwareUpdate) {
        final Promise promise = new Promise();
        try {
            Map<String, String> deviceDownloadInfo = cloudStatusResponse.getDeviceDownloadInfo();
            final File createTempFile = File.createTempFile(DfuBaseService.NOTIFICATION_CHANNEL_DFU, ".zip", this.context.getCacheDir());
            LogKt.debug$default((Object) this, "Download firmware info: " + new Gson().toJson(deviceDownloadInfo), (String) null, (Throwable) null, false, 14, (Object) null);
            this.cloud.downloadFromS3(cloudStatusResponse.getDeviceDownloadInfo(), createTempFile).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.update.WatchAppUpdateProvider$$ExternalSyntheticLambda6
                @Override // com.animaconnected.future.SuccessCallback
                public final void onSuccess(Object obj) {
                    WatchAppUpdateProvider.download$lambda$7(CloudStatusResponse.this, this, createTempFile, firmwareUpdate, promise, (Void) obj);
                }
            }).fail(new FailCallback() { // from class: com.animaconnected.secondo.provider.update.WatchAppUpdateProvider$$ExternalSyntheticLambda7
                @Override // com.animaconnected.future.FailCallback
                public final void onFail(Throwable th) {
                    WatchAppUpdateProvider.download$lambda$8(Promise.this, th);
                }
            });
        } catch (IOException e) {
            promise.reject(e);
        } catch (Exception e2) {
            promise.reject(e2);
        }
        Future<Void> future = promise.getFuture();
        Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
        return future;
    }

    public static final void download$lambda$7(CloudStatusResponse statusResponse, WatchAppUpdateProvider this$0, File file, FirmwareUpdate firmwareUpdate, Promise promise, Void r14) {
        Intrinsics.checkNotNullParameter(statusResponse, "$statusResponse");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(firmwareUpdate, "$firmwareUpdate");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        String deviceFWRevision = statusResponse.getDeviceFWRevision();
        boolean z = !Intrinsics.areEqual(deviceFWRevision, this$0.getCachedVersion());
        ProviderFactory.getWatchUpdateProvider().setDownloadedVersion(deviceFWRevision);
        LogKt.debug$default((Object) this$0, "Downloaded " + deviceFWRevision + " successfully. Previously cached version " + this$0.getCachedVersion() + ". newVersion " + z, (String) null, (Throwable) null, false, 14, (Object) null);
        Intrinsics.checkNotNull(file);
        if (this$0.setFirmware(file)) {
            this$0.setCachedVersion(deviceFWRevision);
            if (z && firmwareUpdate == FirmwareUpdate.FOTA) {
                LogKt.debug$default((Object) this$0, "New FOTA version has been downloaded", (String) null, (Throwable) null, false, 14, (Object) null);
                this$0.notifyNewFotaVersionDownloaded();
            }
            if (firmwareUpdate == FirmwareUpdate.FOTA) {
                this$0.notifyFotaFirmwareDownloaded(this$0.getCachedFirmware(), this$0.getCachedVersion());
                promise.resolve(null);
                return;
            } else if (firmwareUpdate.isDfu()) {
                this$0.notifyDfuFirmwareDownloaded(this$0.getCachedFirmware(), this$0.getCachedVersion());
                promise.resolve(null);
                return;
            } else {
                promise.reject(new Throwable("firmwareUpdate: " + firmwareUpdate));
                return;
            }
        }
        LogKt.debug$default((Object) this$0, "Failed copying file", (String) null, (Throwable) null, false, 14, (Object) null);
        promise.reject(new Throwable("Failed setting/copying firmware"));
    }

    public static final void download$lambda$8(Promise promise, Throwable th) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        promise.reject(th);
    }

    public static final Future downloadAlways$lambda$1(WatchAppUpdateProvider this$0, WatchProvider watch, CloudStatusResponse result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(watch, "$watch");
        Intrinsics.checkNotNullParameter(result, "result");
        return this$0.download(result, watch.getFirmwareUpdateCached());
    }

    public static final Future downloadIfAvailable$lambda$0(WatchAppUpdateProvider this$0, WatchProvider watch, CloudStatusResponse cloudStatusResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(watch, "$watch");
        Intrinsics.checkNotNullParameter(cloudStatusResponse, "cloudStatusResponse");
        boolean isFirmwareAvailable = this$0.isFirmwareAvailable(cloudStatusResponse);
        LogKt.debug$default((Object) this$0, "downloadIfAvailable(): " + cloudStatusResponse + " isAvailable: " + isFirmwareAvailable, (String) null, (Throwable) null, false, 14, (Object) null);
        if (isFirmwareAvailable) {
            return this$0.download(cloudStatusResponse, watch.getFirmwareUpdateCached());
        }
        return FutureUtils.just(null);
    }

    private final CloudStatusApp getCloudAppStatus() {
        return new CloudStatusApp(BuildConfig.APPLICATION_ID, this.config.getBuildType(), String.valueOf(this.config.getVersionCode()), this.config.getVersionName(), APP_VARIANT);
    }

    private final CloudStatusDevice getCloudDeviceStatus(Map<DeviceInfo, String> map, DeviceType deviceType, FirmwareVariant firmwareVariant, FirmwareUpdate firmwareUpdate) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String format = String.format(Locale.ROOT, "%02d", Arrays.copyOf(new Object[]{Integer.valueOf(deviceType.getAdvertisedNumber())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        if (map != null && (str6 = map.get(DeviceInfo.SerialNumber)) != null) {
            str = str6;
        } else {
            str = APP_VARIANT;
        }
        if (map != null && (str5 = map.get(DeviceInfo.HardwareRevision)) != null) {
            str2 = str5;
        } else {
            str2 = APP_VARIANT;
        }
        if (map != null && (str4 = map.get(DeviceInfo.FirmwareRevision)) != null) {
            str3 = str4;
        } else {
            str3 = APP_VARIANT;
        }
        return new CloudStatusDevice(format, str, str2, str3, firmwareUpdate.getAppStatusUpdateType(), firmwareVariant);
    }

    private final Future<CloudStatusDevice> getCloudDeviceStatusAlways(final WatchProvider watchProvider) {
        final Promise promise = new Promise();
        watchProvider.getDeviceInformation().success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.update.WatchAppUpdateProvider$$ExternalSyntheticLambda2
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                WatchAppUpdateProvider.getCloudDeviceStatusAlways$lambda$5(WatchAppUpdateProvider.this, watchProvider, promise, (Map) obj);
            }
        }).fail(new FailCallback() { // from class: com.animaconnected.secondo.provider.update.WatchAppUpdateProvider$$ExternalSyntheticLambda3
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                WatchAppUpdateProvider.getCloudDeviceStatusAlways$lambda$6(WatchProvider.this, promise, th);
            }
        });
        Future<CloudStatusDevice> future = promise.getFuture();
        Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
        return future;
    }

    public static final void getCloudDeviceStatusAlways$lambda$5(WatchAppUpdateProvider this$0, WatchProvider watch, Promise promise, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(watch, "$watch");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        DeviceType deviceType = watch.getDeviceType();
        Intrinsics.checkNotNull(deviceType);
        CloudStatusDevice cloudDeviceStatus = this$0.getCloudDeviceStatus(map, deviceType, watch.getFirmwareVariant(), watch.getFirmwareUpdateCached());
        cloudDeviceStatus.setAlwaysSendLatest(true);
        promise.resolve(cloudDeviceStatus);
    }

    public static final void getCloudDeviceStatusAlways$lambda$6(WatchProvider watch, Promise promise, Throwable th) {
        Intrinsics.checkNotNullParameter(watch, "$watch");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Locale locale = Locale.ROOT;
        DeviceType deviceType = watch.getDeviceType();
        Intrinsics.checkNotNull(deviceType);
        String format = String.format(locale, "%02d", Arrays.copyOf(new Object[]{Integer.valueOf(deviceType.getAdvertisedNumber())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        CloudStatusDevice cloudStatusDevice = new CloudStatusDevice(format, watch.getFirmwareUpdate().getAppStatusUpdateType(), watch.getFirmwareVariant());
        cloudStatusDevice.setAlwaysSendLatest(true);
        promise.resolve(cloudStatusDevice);
    }

    private final CloudStatusMobile getCloudMobileStatus() {
        return new CloudStatusMobile(Build.BRAND, Build.MODEL, PLATFORM, Build.VERSION.RELEASE);
    }

    private final Future<CloudStatusResponse> getCloudStatus(final WatchProvider watchProvider) {
        LogKt.debug$default((Object) this, "Checking for updates", (String) null, (Throwable) null, false, 14, (Object) null);
        Future flatMap = watchProvider.getDeviceInformation().flatMap(new FlatMapCallback() { // from class: com.animaconnected.secondo.provider.update.WatchAppUpdateProvider$$ExternalSyntheticLambda1
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future cloudStatus$lambda$3;
                cloudStatus$lambda$3 = WatchAppUpdateProvider.getCloudStatus$lambda$3(WatchAppUpdateProvider.this, watchProvider, (Map) obj);
                return cloudStatus$lambda$3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap(...)");
        return flatMap;
    }

    public static final Future getCloudStatus$lambda$3(WatchAppUpdateProvider this$0, WatchProvider watch, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(watch, "$watch");
        CloudStatusMobile cloudMobileStatus = this$0.getCloudMobileStatus();
        CloudStatusApp cloudAppStatus = this$0.getCloudAppStatus();
        DeviceType deviceType = watch.getDeviceType();
        Intrinsics.checkNotNull(deviceType);
        CloudStatusDevice cloudDeviceStatus = this$0.getCloudDeviceStatus(map, deviceType, watch.getFirmwareVariant(), watch.getFirmwareUpdateCached());
        LogKt.debug$default((Object) this$0, "getCloudStatus(): " + cloudMobileStatus + ' ' + cloudAppStatus + ' ' + cloudDeviceStatus, (String) null, (Throwable) null, false, 14, (Object) null);
        return this$0.cloud.sendStatus(cloudMobileStatus, cloudAppStatus, cloudDeviceStatus);
    }

    private final Future<CloudStatusResponse> getCloudStatusAlways(WatchProvider watchProvider) {
        LogKt.debug$default((Object) this, "Fetching cloud status", (String) null, (Throwable) null, false, 14, (Object) null);
        Future flatMap = getCloudDeviceStatusAlways(watchProvider).flatMap(new FlatMapCallback() { // from class: com.animaconnected.secondo.provider.update.WatchAppUpdateProvider$$ExternalSyntheticLambda5
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future cloudStatusAlways$lambda$4;
                cloudStatusAlways$lambda$4 = WatchAppUpdateProvider.getCloudStatusAlways$lambda$4(WatchAppUpdateProvider.this, (CloudStatusDevice) obj);
                return cloudStatusAlways$lambda$4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap(...)");
        return flatMap;
    }

    public static final Future getCloudStatusAlways$lambda$4(WatchAppUpdateProvider this$0, CloudStatusDevice cloudStatusDevice) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cloudStatusDevice, "cloudStatusDevice");
        CloudStatusMobile cloudMobileStatus = this$0.getCloudMobileStatus();
        CloudStatusApp cloudAppStatus = this$0.getCloudAppStatus();
        LogKt.debug$default((Object) this$0, "getCloudStatusAlways(): " + cloudMobileStatus + ' ' + cloudAppStatus + ' ' + cloudStatusDevice, (String) null, (Throwable) null, false, 14, (Object) null);
        return this$0.cloud.sendStatus(cloudMobileStatus, cloudAppStatus, cloudStatusDevice);
    }

    public static final Boolean hasCloudNewerFirmware$lambda$2(WatchAppUpdateProvider this$0, CloudStatusResponse statusResponse) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(statusResponse, "statusResponse");
        return Boolean.valueOf(this$0.isFirmwareAvailable(statusResponse));
    }

    private final boolean isFirmwareAvailable(CloudStatusResponse cloudStatusResponse) {
        if (cloudStatusResponse.getDeviceStatus() != CloudStatusResponse.STATUS_E.UPDATE_AVAILABLE && cloudStatusResponse.getDeviceStatus() != CloudStatusResponse.STATUS_E.UPDATE_REQUIRED) {
            return false;
        }
        return true;
    }

    private final void notifyDfuFirmwareDownloaded(File file, String str) {
        Iterator<T> it = this.firmwareListeners.iterator();
        while (it.hasNext()) {
            ((FirmwareListener) it.next()).onDfuFirmwareDownloaded(file, str);
        }
    }

    private final void notifyFotaFirmwareDownloaded(File file, String str) {
        Iterator<T> it = this.firmwareListeners.iterator();
        while (it.hasNext()) {
            ((FirmwareListener) it.next()).onFotaFirmwareDownloaded(file, str);
        }
    }

    private final void notifyNewFotaVersionDownloaded() {
        Iterator<T> it = this.fotaVersionListeners.iterator();
        while (it.hasNext()) {
            ((FotaVersionListener) it.next()).onNewFotaVersionDownloaded();
        }
    }

    public final void onFirmwareRemoved() {
        Iterator<T> it = this.firmwareListeners.iterator();
        while (it.hasNext()) {
            ((FirmwareListener) it.next()).onFirmwareRemoved();
        }
    }

    public final void setCachedVersion(String str) {
        this.sharedPreferences.edit().putString("version", str).apply();
    }

    public final void setDebugFirmware(File file) {
        if (file.exists()) {
            String str = "debug." + System.currentTimeMillis();
            try {
                Files.copy(file, this.context.getFileStreamPath(FW_FILENAME));
            } catch (Exception e) {
                LogKt.debug$default((Object) this, String.valueOf(e.getMessage()), (String) null, (Throwable) null, false, 14, (Object) null);
            }
            setCachedVersion(str);
            if (ProviderFactory.getWatch().getFirmwareUpdate().isDfu()) {
                notifyDfuFirmwareDownloaded(file, str);
            } else {
                notifyFotaFirmwareDownloaded(file, str);
            }
        }
    }

    private final boolean setFirmware(File file) {
        try {
            Files.move(file, this.context.getFileStreamPath(FW_FILENAME));
            return true;
        } catch (Exception e) {
            LogKt.debug$default((Object) this, e + ".message", (String) null, (Throwable) null, false, 14, (Object) null);
            return false;
        }
    }

    public final void clear() {
        File cachedFirmware = getCachedFirmware();
        boolean z = false;
        if (cachedFirmware != null && cachedFirmware.exists()) {
            z = true;
        }
        if (z) {
            cachedFirmware.delete();
            onFirmwareRemoved();
        }
        setCachedVersion(null);
    }

    public final Future<Void> downloadAlways(final WatchProvider watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        Future flatMap = getCloudStatusAlways(watch).flatMap(new FlatMapCallback() { // from class: com.animaconnected.secondo.provider.update.WatchAppUpdateProvider$$ExternalSyntheticLambda8
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future downloadAlways$lambda$1;
                downloadAlways$lambda$1 = WatchAppUpdateProvider.downloadAlways$lambda$1(WatchAppUpdateProvider.this, watch, (CloudStatusResponse) obj);
                return downloadAlways$lambda$1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap(...)");
        return flatMap;
    }

    public final Future<Void> downloadIfAvailable(final WatchProvider watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        Future flatMap = getCloudStatus(watch).flatMap(new FlatMapCallback() { // from class: com.animaconnected.secondo.provider.update.WatchAppUpdateProvider$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future downloadIfAvailable$lambda$0;
                downloadIfAvailable$lambda$0 = WatchAppUpdateProvider.downloadIfAvailable$lambda$0(WatchAppUpdateProvider.this, watch, (CloudStatusResponse) obj);
                return downloadIfAvailable$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap(...)");
        return flatMap;
    }

    public final File getCachedFirmware() {
        File fileStreamPath = this.context.getFileStreamPath(FW_FILENAME);
        if (!fileStreamPath.exists()) {
            return null;
        }
        return fileStreamPath;
    }

    public final String getCachedVersion() {
        return this.sharedPreferences.getString("version", null);
    }

    public final boolean hasCachedNewerFirmware(WatchProvider watchProvider) {
        String firmwareRevisionCached;
        BaseFirmwareVersion firmwareVersion;
        boolean z;
        Object obj;
        if (watchProvider == null || (firmwareRevisionCached = watchProvider.getFirmwareRevisionCached()) == null || (firmwareVersion = FirmwareVersionKt.toFirmwareVersion(firmwareRevisionCached)) == null) {
            return false;
        }
        DeviceType deviceType = watchProvider.getDeviceType();
        if (deviceType != null && deviceType.getHasDisplay()) {
            z = true;
        } else {
            z = false;
        }
        if (z && !UserCategoryKt.allowAnyPascalFirmware(watchProvider.getUserCategory()) && (firmwareVersion instanceof FirmwareVersion)) {
            String cachedVersion = getCachedVersion();
            FirmwareVersion firmwareVersion2 = null;
            if (cachedVersion != null) {
                obj = FirmwareVersionKt.toFirmwareVersion(cachedVersion);
            } else {
                obj = null;
            }
            if (obj instanceof FirmwareVersion) {
                firmwareVersion2 = (FirmwareVersion) obj;
            }
            if (firmwareVersion2 == null || Intrinsics.areEqual(firmwareVersion2, firmwareVersion) || !isCachedFirmwareNewerThanBundled()) {
                return false;
            }
        } else if (getCachedFirmware() == null || Intrinsics.areEqual(firmwareRevisionCached, getCachedVersion())) {
            return false;
        }
        return true;
    }

    public final Future<Boolean> hasCloudNewerFirmware(WatchProvider watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        Future map = getCloudStatus(watch).map(new MapCallback() { // from class: com.animaconnected.secondo.provider.update.WatchAppUpdateProvider$$ExternalSyntheticLambda4
            @Override // com.animaconnected.future.MapCallback
            public final Object onResult(Object obj) {
                Boolean hasCloudNewerFirmware$lambda$2;
                hasCloudNewerFirmware$lambda$2 = WatchAppUpdateProvider.hasCloudNewerFirmware$lambda$2(WatchAppUpdateProvider.this, (CloudStatusResponse) obj);
                return hasCloudNewerFirmware$lambda$2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "map(...)");
        return map;
    }

    public final boolean isCachedFirmwareNewerThanBundled() {
        Object obj;
        FirmwareVersion firmwareVersion;
        String cachedVersion = getCachedVersion();
        FirmwareVersion firmwareVersion2 = null;
        if (cachedVersion != null) {
            obj = FirmwareVersionKt.toFirmwareVersion(cachedVersion);
        } else {
            obj = null;
        }
        if (obj instanceof FirmwareVersion) {
            firmwareVersion2 = (FirmwareVersion) obj;
        }
        if (firmwareVersion2 == null) {
            return false;
        }
        BundledFirmware bundledFirmware = BundledFirmwareKt.getBundledFirmware(ProviderFactory.getWatch().getDeviceType(), ProviderFactory.getWatch().getFirmwareVariant());
        if (bundledFirmware == null || (firmwareVersion = bundledFirmware.getFirmwareVersion()) == null) {
            firmwareVersion = new FirmwareVersion(0, 0, 0);
        }
        if (!FirmwareVersionKt.isSupported(firmwareVersion2) || firmwareVersion2.compareTo(firmwareVersion) <= 0) {
            return false;
        }
        return true;
    }

    public final boolean registerFirmwareListener(FirmwareListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.firmwareListeners.add(listener);
    }

    public final boolean registerFotaVersionListener(FotaVersionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.fotaVersionListeners.add(listener);
    }

    public final boolean setFotaFirmwareFromFile(Uri firmwareUri) {
        Intrinsics.checkNotNullParameter(firmwareUri, "firmwareUri");
        try {
            InputStream openInputStream = this.context.getContentResolver().openInputStream(firmwareUri);
            try {
                FileOutputStream openFileOutput = this.context.openFileOutput(FW_FILENAME, 0);
                try {
                    try {
                        openInputStream.getClass();
                        openFileOutput.getClass();
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = openInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            openFileOutput.write(bArr, 0, read);
                        }
                        openInputStream.close();
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(openFileOutput, null);
                        CloseableKt.closeFinally(openInputStream, null);
                        String version = new FotaZipArchive(this.context, firmwareUri).getVersion();
                        if (version != null) {
                            setCachedVersion(version);
                        }
                        return true;
                    } catch (Throwable th) {
                        openInputStream.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally(openFileOutput, th2);
                        throw th3;
                    }
                }
            } finally {
            }
        } catch (IOException e) {
            ViewKt.toast$default(this.context, "File error: " + e + ".message", false, 2, (Object) null);
            return false;
        }
    }

    public final boolean unregisterFirmwareListener(FirmwareListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.firmwareListeners.remove(listener);
    }
}
