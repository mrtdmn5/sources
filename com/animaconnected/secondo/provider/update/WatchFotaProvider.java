package com.animaconnected.secondo.provider.update;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.net.Uri;
import com.animaconnected.bluetooth.device.DeviceFotaListener;
import com.animaconnected.dfu.fota.FotaController;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.update.WatchAppUpdateProvider;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceConnectionListener;
import com.animaconnected.watch.device.FirmwareUpdate;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: WatchFotaProvider.kt */
/* loaded from: classes3.dex */
public final class WatchFotaProvider implements DeviceConnectionListener, DeviceFotaListener, WatchAppUpdateProvider.FotaVersionListener {
    private static final String FOTA_FORCE_RESTART = "fota_force_restart";
    private static final String FOTA_STARTED_FROM_DEBUG_KEY = "fota_started_from_debug";
    private static final String FOTA_STORAGE = "fota_storage";
    private Byte fotaError;
    private final Set<FotaStatusListener> fotaStatusListeners;
    private FotaUiState fotaUiState;
    private final WatchAppUpdateProvider watchAppUpdateProvider;
    private final WatchProvider watchProvider;
    private final WatchUpdateProvider watchUpdateProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: WatchFotaProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: WatchFotaProvider.kt */
    /* loaded from: classes3.dex */
    public interface FotaStatusListener {
        void onFotaError(String str);

        void onFotaProgress(List<Byte> list);

        void onPerformFotaCompleted();

        void onPerformFotaError(byte b);

        void onReadyToPerformFota();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: WatchFotaProvider.kt */
    /* loaded from: classes3.dex */
    public static final class FotaUiState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FotaUiState[] $VALUES;
        public static final FotaUiState IDLE = new FotaUiState("IDLE", 0);
        public static final FotaUiState READY_TO_PERFORM = new FotaUiState("READY_TO_PERFORM", 1);
        public static final FotaUiState PERFORMING = new FotaUiState("PERFORMING", 2);

        private static final /* synthetic */ FotaUiState[] $values() {
            return new FotaUiState[]{IDLE, READY_TO_PERFORM, PERFORMING};
        }

        static {
            FotaUiState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private FotaUiState(String str, int r2) {
        }

        public static EnumEntries<FotaUiState> getEntries() {
            return $ENTRIES;
        }

        public static FotaUiState valueOf(String str) {
            return (FotaUiState) Enum.valueOf(FotaUiState.class, str);
        }

        public static FotaUiState[] values() {
            return (FotaUiState[]) $VALUES.clone();
        }
    }

    public WatchFotaProvider(WatchProvider watchProvider, WatchAppUpdateProvider watchAppUpdateProvider, WatchUpdateProvider watchUpdateProvider) {
        Intrinsics.checkNotNullParameter(watchProvider, "watchProvider");
        Intrinsics.checkNotNullParameter(watchAppUpdateProvider, "watchAppUpdateProvider");
        Intrinsics.checkNotNullParameter(watchUpdateProvider, "watchUpdateProvider");
        this.watchProvider = watchProvider;
        this.watchAppUpdateProvider = watchAppUpdateProvider;
        this.watchUpdateProvider = watchUpdateProvider;
        this.fotaStatusListeners = new CopyOnWriteArraySet();
        this.fotaUiState = FotaUiState.IDLE;
        watchProvider.registerDeviceConnectionListener(this);
        watchAppUpdateProvider.registerFotaVersionListener(this);
    }

    private final boolean getForceFotaRestart() {
        return getSharedPreferences().getBoolean(FOTA_FORCE_RESTART, false);
    }

    private final SharedPreferences getSharedPreferences() {
        SharedPreferences sharedPreferences = KronabyApplication.Companion.getContext().getSharedPreferences(FOTA_STORAGE, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    private final void notifyFotaError(String str) {
        Iterator<T> it = this.fotaStatusListeners.iterator();
        while (it.hasNext()) {
            ((FotaStatusListener) it.next()).onFotaError(str);
        }
    }

    private final void notifyFotaProgress(List<Byte> list) {
        Iterator<T> it = this.fotaStatusListeners.iterator();
        while (it.hasNext()) {
            ((FotaStatusListener) it.next()).onFotaProgress(list);
        }
    }

    private final void notifyPerformFotaCompleted() {
        Iterator<T> it = this.fotaStatusListeners.iterator();
        while (it.hasNext()) {
            ((FotaStatusListener) it.next()).onPerformFotaCompleted();
        }
    }

    private final void notifyPerformFotaError(byte b) {
        Iterator<T> it = this.fotaStatusListeners.iterator();
        while (it.hasNext()) {
            ((FotaStatusListener) it.next()).onPerformFotaError(b);
        }
    }

    private final void notifyReadyToPerformFota() {
        Iterator<T> it = this.fotaStatusListeners.iterator();
        while (it.hasNext()) {
            ((FotaStatusListener) it.next()).onReadyToPerformFota();
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    private final void setForceFotaRestart(boolean z) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(getSharedPreferences(), FOTA_FORCE_RESTART, z);
    }

    private final void setFotaSlowMode(boolean z) {
        this.watchProvider.setFotaSlowMode(z);
    }

    private final void update() {
        boolean z;
        boolean isOnboardingFinished = ProviderFactory.createBluetoothOnboardingProvider().isOnboardingFinished();
        File cachedFirmware = this.watchAppUpdateProvider.getCachedFirmware();
        if (getFotaStartedFromDebug() && cachedFirmware != null) {
            z = true;
        } else {
            z = false;
        }
        if (ProviderFactory.getWatch().isConnected()) {
            if ((this.watchAppUpdateProvider.hasCachedNewerFirmware(ProviderFactory.getWatch()) || z) && isOnboardingFinished && ProviderFactory.getWatch().getFirmwareUpdate() == FirmwareUpdate.FOTA) {
                LogKt.debug$default((Object) this, "Failed to set firmware from file", (String) null, (Throwable) null, false, 14, (Object) null);
                BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new WatchFotaProvider$update$1(this, cachedFirmware, null), 3);
            }
        }
    }

    public final void clear() {
        this.fotaUiState = FotaUiState.IDLE;
        this.fotaError = null;
    }

    public final boolean getFotaStartedFromDebug() {
        return getSharedPreferences().getBoolean(FOTA_STARTED_FROM_DEBUG_KEY, false);
    }

    public final Byte getGetAndClearFotaError() {
        Byte b = this.fotaError;
        this.fotaError = null;
        return b;
    }

    public final boolean isReadyToPerformFota() {
        if (this.fotaUiState == FotaUiState.READY_TO_PERFORM) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnected() {
        update();
        this.watchProvider.registerFotaListener(this);
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onDisconnected() {
        this.watchProvider.unregisterFotaListener(this);
    }

    @Override // com.animaconnected.bluetooth.device.DeviceFotaListener
    public void onFotaError(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        notifyFotaError(error);
    }

    @Override // com.animaconnected.bluetooth.device.DeviceFotaListener
    public void onFotaProgress(List<Byte> pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        notifyFotaProgress(pages);
    }

    @Override // com.animaconnected.secondo.provider.update.WatchAppUpdateProvider.FotaVersionListener
    public void onNewFotaVersionDownloaded() {
        setForceFotaRestart(true);
        this.watchProvider.cancelFota();
        update();
    }

    public final void onPause() {
        setFotaSlowMode(false);
    }

    @Override // com.animaconnected.bluetooth.device.DeviceFotaListener
    public void onPerformFotaCompleted() {
        this.fotaUiState = FotaUiState.IDLE;
        this.watchUpdateProvider.dismissWatchUpdateNotification();
        setFotaStartedFromDebug(false);
        notifyPerformFotaCompleted();
    }

    @Override // com.animaconnected.bluetooth.device.DeviceFotaListener
    public void onPerformFotaError(byte b) {
        if (b == 8 || b == 5 || b == 9) {
            this.fotaUiState = FotaUiState.READY_TO_PERFORM;
            this.fotaError = Byte.valueOf(b);
        }
        notifyPerformFotaError(b);
    }

    @Override // com.animaconnected.bluetooth.device.DeviceFotaListener
    public void onReadyToPerformFota() {
        this.watchUpdateProvider.showWatchUpdateNotification(false);
        this.fotaUiState = FotaUiState.READY_TO_PERFORM;
        notifyReadyToPerformFota();
    }

    public final void onResume() {
        setFotaSlowMode(true);
    }

    public final boolean performFota() {
        if (this.fotaUiState == FotaUiState.READY_TO_PERFORM) {
            this.fotaError = null;
            this.fotaUiState = FotaUiState.PERFORMING;
            this.watchProvider.performFota();
            return true;
        }
        return false;
    }

    public final boolean registerFotaStatusListener(FotaStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.fotaStatusListeners.add(listener);
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void setFotaStartedFromDebug(boolean z) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(getSharedPreferences(), FOTA_STARTED_FROM_DEBUG_KEY, z);
    }

    public final void startFota(WatchProvider watch, File file) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        FotaController fotaController = new FotaController(KronabyApplication.Companion.getContext());
        Uri fromFile = Uri.fromFile(file);
        Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(...)");
        watch.startFota(fotaController, fromFile, getForceFotaRestart());
        setForceFotaRestart(false);
    }

    public final void startFotaFromFile(WatchProvider watch, Uri uri) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        WatchAppUpdateProvider watchAppUpdateProvider = this.watchAppUpdateProvider;
        Intrinsics.checkNotNull(uri);
        if (watchAppUpdateProvider.setFotaFirmwareFromFile(uri)) {
            startFota(watch, this.watchAppUpdateProvider.getCachedFirmware());
        } else {
            LogKt.debug$default((Object) this, "Failed to set firmware from file", (String) null, (Throwable) null, false, 14, (Object) null);
        }
    }

    public final boolean unregisterFotaStatusListener(FotaStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.fotaStatusListeners.remove(listener);
    }
}
