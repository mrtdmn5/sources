package com.animaconnected.secondo.provider.update;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.net.Uri;
import com.animaconnected.bluetooth.dfu.BaseDfuController;
import com.animaconnected.bluetooth.gatt.DeviceListener;
import com.animaconnected.dfu.dfu.Dfu8Controller;
import com.animaconnected.dfu.dfu15.Dfu15Controller;
import com.animaconnected.dfu.utils.RemoveBondException;
import com.animaconnected.future.AlwaysCallback;
import com.animaconnected.future.FailCallback;
import com.animaconnected.future.Future;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.update.DfuState;
import com.animaconnected.secondo.provider.update.RemoveBondController;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceDfuListener;
import com.animaconnected.watch.device.FirmwareUpdate;
import com.google.common.io.Files;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: WatchDfuProvider.kt */
/* loaded from: classes3.dex */
public final class WatchDfuProvider {
    private static final String FW_FILENAME = "fw_dfu.zip";
    public static final int REMOVE_BOND_STATE_AUTO_FLOW_NOT_STARTED = 0;
    public static final int REMOVE_BOND_STATE_AUTO_FLOW_STARTED = 1;
    public static final int REMOVE_BOND_STATE_TRIED_BT_TOGGLE = 2;
    private static final String SHARED_PREFS_HAS_FAILED_KEY = "failed";
    private static final String SHARED_PREFS_NAME = "dfuStatus";
    private final WatchDfuProvider$dfuListener$1 dfuListener;
    private DfuState dfuState;
    private final Set<DfuStatusListener> listeners;
    private DfuState prevDfuState;
    private final RemoveBondController removeBondController;
    private int removeBondState;
    private final SharedPreferences sharedPref;
    private final WatchAppUpdateProvider updateProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: WatchDfuProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: WatchDfuProvider.kt */
    /* loaded from: classes3.dex */
    public interface DfuStatusListener {
        void onDfuStatusChanged(DfuState dfuState);
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [com.animaconnected.secondo.provider.update.WatchDfuProvider$dfuListener$1] */
    public WatchDfuProvider(WatchAppUpdateProvider updateProvider) {
        Intrinsics.checkNotNullParameter(updateProvider, "updateProvider");
        this.updateProvider = updateProvider;
        this.dfuState = DfuState.NotStarted.INSTANCE;
        this.removeBondController = new RemoveBondController();
        this.sharedPref = KronabyApplication.Companion.getContext().getSharedPreferences(SHARED_PREFS_NAME, 0);
        this.listeners = new CopyOnWriteArraySet();
        this.dfuListener = new DeviceDfuListener() { // from class: com.animaconnected.secondo.provider.update.WatchDfuProvider$dfuListener$1
            @Override // com.animaconnected.watch.device.DeviceDfuListener
            public void onDfuProgress(int r3) {
                if ((WatchDfuProvider.this.getDfuState() instanceof DfuState.Ongoing) || Intrinsics.areEqual(WatchDfuProvider.this.getDfuState(), DfuState.Initiating.INSTANCE)) {
                    WatchDfuProvider.this.dfuState = new DfuState.Ongoing(r3);
                    WatchDfuProvider watchDfuProvider = WatchDfuProvider.this;
                    watchDfuProvider.onDfuStateChange(watchDfuProvider.getDfuState());
                }
            }
        };
    }

    private final File copyAndGetFile(File file) {
        try {
            File fileStreamPath = KronabyApplication.Companion.getContext().getFileStreamPath(FW_FILENAME);
            Files.copy(file, fileStreamPath);
            return fileStreamPath;
        } catch (Exception e) {
            LogKt.debug$default((Object) this, String.valueOf(e.getMessage()), (String) null, (Throwable) null, false, 14, (Object) null);
            return null;
        }
    }

    public final void onDfuStateChange(DfuState dfuState) {
        if (!Intrinsics.areEqual(this.prevDfuState, this.dfuState)) {
            LogKt.debug$default((Object) this, "state: " + dfuState, (String) null, (Throwable) null, false, 14, (Object) null);
            this.prevDfuState = this.dfuState;
        }
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((DfuStatusListener) it.next()).onDfuStatusChanged(dfuState);
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    private final void setDfuFailed(boolean z) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(this.sharedPref, SHARED_PREFS_HAS_FAILED_KEY, z);
    }

    public final void startDfuFromUri(final WatchProvider watchProvider, final Uri uri, final DeviceListener deviceListener) {
        BaseDfuController dfu8Controller;
        DisplayWatch displayWatch;
        Future<Void> success;
        Future<Void> fail;
        if (watchProvider.getFirmwareUpdate() == FirmwareUpdate.DFU15) {
            dfu8Controller = new Dfu15Controller(KronabyApplication.Companion.getContext(), deviceListener, new Dfu15Controller.AddressChangeListener() { // from class: com.animaconnected.secondo.provider.update.WatchDfuProvider$startDfuFromUri$controller$listener$1
                @Override // com.animaconnected.dfu.dfu15.Dfu15Controller.AddressChangeListener
                public void onEnterDfuAddressChange(String dfuAddress) {
                    Intrinsics.checkNotNullParameter(dfuAddress, "dfuAddress");
                    WatchProvider.this.saveNewAddress(dfuAddress);
                    WatchProvider.this.changeAddress(dfuAddress);
                }

                @Override // com.animaconnected.dfu.dfu15.Dfu15Controller.AddressChangeListener
                public void onLeaveDfuAddressChange(String address) {
                    Intrinsics.checkNotNullParameter(address, "address");
                    WatchProvider.this.saveNewAddress(address);
                    WatchProvider.this.changeAddress(address);
                }
            });
        } else {
            dfu8Controller = new Dfu8Controller(KronabyApplication.Companion.getContext(), deviceListener);
        }
        setDfuFailed(false);
        watchProvider.registerDfuListener(this.dfuListener);
        DfuState.Initiating initiating = DfuState.Initiating.INSTANCE;
        this.dfuState = initiating;
        onDfuStateChange(initiating);
        Watch watch = watchProvider.getWatch();
        if (watch instanceof DisplayWatch) {
            displayWatch = (DisplayWatch) watch;
        } else {
            displayWatch = null;
        }
        if (displayWatch != null) {
            BuildersKt.launch$default(displayWatch.getScope(), null, null, new WatchDfuProvider$startDfuFromUri$1$1(displayWatch, null), 3);
        }
        Future<Void> startDfu = watchProvider.startDfu(dfu8Controller, uri);
        if (startDfu != null && (success = startDfu.success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.update.WatchDfuProvider$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                WatchDfuProvider.startDfuFromUri$lambda$1(WatchDfuProvider.this, (Void) obj);
            }
        })) != null && (fail = success.fail(new FailCallback() { // from class: com.animaconnected.secondo.provider.update.WatchDfuProvider$$ExternalSyntheticLambda1
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                WatchDfuProvider.startDfuFromUri$lambda$2(WatchDfuProvider.this, watchProvider, uri, deviceListener, th);
            }
        })) != null) {
            fail.always(new AlwaysCallback() { // from class: com.animaconnected.secondo.provider.update.WatchDfuProvider$$ExternalSyntheticLambda2
                @Override // com.animaconnected.future.AlwaysCallback
                public final void onFinished() {
                    WatchDfuProvider.startDfuFromUri$lambda$3(WatchDfuProvider.this, watchProvider);
                }
            });
        }
    }

    public static final void startDfuFromUri$lambda$1(WatchDfuProvider this$0, Void r1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DfuState.Successful successful = DfuState.Successful.INSTANCE;
        this$0.dfuState = successful;
        this$0.onDfuStateChange(successful);
    }

    public static final void startDfuFromUri$lambda$2(WatchDfuProvider this$0, WatchProvider watch, Uri fwUri, DeviceListener deviceListener, Throwable error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(watch, "$watch");
        Intrinsics.checkNotNullParameter(fwUri, "$fwUri");
        Intrinsics.checkNotNullParameter(error, "error");
        this$0.dfuState = new DfuState.Failed(String.valueOf(error.getMessage()));
        if (error instanceof RemoveBondException) {
            this$0.startRemoveBondFlow(watch, fwUri, deviceListener);
        }
        this$0.setDfuFailed(true);
        this$0.onDfuStateChange(this$0.dfuState);
    }

    public static final void startDfuFromUri$lambda$3(WatchDfuProvider this$0, WatchProvider watch) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(watch, "$watch");
        this$0.dfuState = DfuState.NotStarted.INSTANCE;
        watch.unregisterDfuListener(this$0.dfuListener);
    }

    private final void startRemoveBondFlow(final WatchProvider watchProvider, final Uri uri, final DeviceListener deviceListener) {
        this.removeBondController.registerListener(new RemoveBondController.ProgressListener() { // from class: com.animaconnected.secondo.provider.update.WatchDfuProvider$startRemoveBondFlow$1
            @Override // com.animaconnected.secondo.provider.update.RemoveBondController.ProgressListener
            public void onRemoveBondAutoFlowStarted() {
                WatchDfuProvider.this.removeBondState = 1;
            }

            @Override // com.animaconnected.secondo.provider.update.RemoveBondController.ProgressListener
            public void onRemoveBondFinished() {
                WatchDfuProvider.this.startDfuFromUri(watchProvider, uri, deviceListener);
            }

            @Override // com.animaconnected.secondo.provider.update.RemoveBondController.ProgressListener
            public void onRemoveBondStarted(boolean z) {
                if (z) {
                    WatchDfuProvider.this.removeBondState = 2;
                }
            }
        });
        this.removeBondController.startRemoveBondFlow();
    }

    public final void clear() {
        setDfuFailed(false);
        this.dfuState = DfuState.NotStarted.INSTANCE;
        this.prevDfuState = null;
        this.removeBondState = 0;
    }

    public final DfuState getDfuState() {
        return this.dfuState;
    }

    public final int getRemoveBondState() {
        return this.removeBondState;
    }

    public final boolean hasDfuFailed() {
        return KronabyApplication.Companion.getContext().getSharedPreferences(SHARED_PREFS_NAME, 0).getBoolean(SHARED_PREFS_HAS_FAILED_KEY, false);
    }

    public final boolean isDfuAvailable() {
        WatchProvider watch = ProviderFactory.getWatch();
        if (watch.getFirmwareUpdate().isDfu() && this.updateProvider.hasCachedNewerFirmware(watch)) {
            return true;
        }
        return false;
    }

    public final boolean registerListener(DfuStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.listeners.add(listener);
    }

    public final void registerRemoveBondProgressListener(RemoveBondController.ProgressListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.removeBondController.registerListener(listener);
    }

    public final boolean shouldShowRemoveBond() {
        return this.removeBondController.shouldShowStatus();
    }

    public final void startDfu(WatchProvider watch, File file, DeviceListener deviceListener) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        if (!Intrinsics.areEqual(this.dfuState, DfuState.NotStarted.INSTANCE)) {
            onDfuStateChange(new DfuState.Failed("DFU ongoing"));
            return;
        }
        if (file == null) {
            onDfuStateChange(new DfuState.Failed("FW file is null"));
            return;
        }
        File copyAndGetFile = copyAndGetFile(file);
        if (copyAndGetFile == null) {
            onDfuStateChange(new DfuState.Failed("FW file copy is null"));
            return;
        }
        Uri fromFile = Uri.fromFile(copyAndGetFile);
        Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(...)");
        startDfuFromUri(watch, fromFile, deviceListener);
    }

    public final void startDfuFromFile(WatchProvider watch, Uri uri) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        if (!Intrinsics.areEqual(this.dfuState, DfuState.NotStarted.INSTANCE)) {
            onDfuStateChange(new DfuState.Failed("DFU ongoing"));
        } else if (uri == null) {
            onDfuStateChange(new DfuState.Failed("FW file is null"));
        } else {
            startDfuFromUri(watch, uri, null);
        }
    }

    public final void startRemoveBondAutoFlow() {
        this.removeBondController.startAutoFlow();
    }

    public final boolean unregisterListener(DfuStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.listeners.remove(listener);
    }

    public final void unregisterRemoveBondProgressListener(RemoveBondController.ProgressListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.removeBondController.unregisterListener(listener);
    }
}
