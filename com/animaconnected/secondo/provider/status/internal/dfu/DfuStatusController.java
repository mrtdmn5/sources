package com.animaconnected.secondo.provider.status.internal.dfu;

import android.content.Context;
import android.util.Log;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.provider.status.DfuFailedStatus;
import com.animaconnected.secondo.provider.status.DfuRequiredStatus;
import com.animaconnected.secondo.provider.status.StatusChangeListener;
import com.animaconnected.secondo.provider.status.StatusController;
import com.animaconnected.secondo.provider.status.StatusModel;
import com.animaconnected.secondo.provider.update.BackgroundUpdateChecker;
import com.animaconnected.secondo.provider.update.DfuState;
import com.animaconnected.secondo.provider.update.UpdateChangeListener;
import com.animaconnected.secondo.provider.update.WatchAppUpdateProvider;
import com.animaconnected.secondo.provider.update.WatchDfuProvider;
import com.animaconnected.secondo.provider.update.WatchUpdateProvider;
import com.animaconnected.watch.DeviceAvailableListener;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceConnectionListener;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DfuStatusController.kt */
/* loaded from: classes3.dex */
public final class DfuStatusController extends StatusController implements UpdateChangeListener, DeviceConnectionListener, WatchDfuProvider.DfuStatusListener, DeviceAvailableListener {
    private final Context context;
    private final WatchProvider watch;
    private final WatchAppUpdateProvider watchAppUpdateProvider;
    private final WatchDfuProvider watchDfuProvider;
    private final WatchUpdateProvider watchUpdateProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "DfuStatusController";

    /* compiled from: DfuStatusController.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DfuStatusController(BackgroundUpdateChecker backgroundUpdateChecker, WatchProvider watch, Context context, WatchAppUpdateProvider watchAppUpdateProvider, WatchUpdateProvider watchUpdateProvider, WatchDfuProvider watchDfuProvider) {
        Intrinsics.checkNotNullParameter(backgroundUpdateChecker, "backgroundUpdateChecker");
        Intrinsics.checkNotNullParameter(watch, "watch");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(watchAppUpdateProvider, "watchAppUpdateProvider");
        Intrinsics.checkNotNullParameter(watchUpdateProvider, "watchUpdateProvider");
        Intrinsics.checkNotNullParameter(watchDfuProvider, "watchDfuProvider");
        this.watch = watch;
        this.context = context;
        this.watchAppUpdateProvider = watchAppUpdateProvider;
        this.watchUpdateProvider = watchUpdateProvider;
        this.watchDfuProvider = watchDfuProvider;
        backgroundUpdateChecker.registerListener(this);
        watch.registerDeviceAvailableListener(this);
        watch.registerDeviceConnectionListener(this);
        watchDfuProvider.registerListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onEnterDfuMode$lambda$0(DfuStatusController this$0, Void r2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.d(TAG, "Successfully downloaded");
        this$0.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onEnterDfuMode$lambda$1(Throwable th) {
        Log.d(TAG, "Failed downloading");
    }

    public final Context getContext() {
        return this.context;
    }

    public final WatchProvider getWatch() {
        return this.watch;
    }

    public final WatchAppUpdateProvider getWatchAppUpdateProvider() {
        return this.watchAppUpdateProvider;
    }

    public final WatchDfuProvider getWatchDfuProvider() {
        return this.watchDfuProvider;
    }

    public final WatchUpdateProvider getWatchUpdateProvider() {
        return this.watchUpdateProvider;
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnected() {
        update();
    }

    @Override // com.animaconnected.watch.DeviceAvailableListener
    public void onDeviceRemoved() {
        this.watchDfuProvider.clear();
        this.watchAppUpdateProvider.clear();
    }

    @Override // com.animaconnected.secondo.provider.update.WatchDfuProvider.DfuStatusListener
    public void onDfuStatusChanged(DfuState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof DfuState.Successful) {
            this.watchDfuProvider.clear();
            this.watchAppUpdateProvider.clear();
        }
        update();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onDisconnected() {
        update();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterDfuMode() {
        if (this.watchAppUpdateProvider.getCachedFirmware() == null) {
            Log.d(TAG, "Entering DFU without cached FW");
            this.watchAppUpdateProvider.downloadAlways(this.watch).success(new SuccessCallback() { // from class: com.animaconnected.secondo.provider.status.internal.dfu.DfuStatusController$$ExternalSyntheticLambda0
                @Override // com.animaconnected.future.SuccessCallback
                public final void onSuccess(Object obj) {
                    DfuStatusController.onEnterDfuMode$lambda$0(DfuStatusController.this, (Void) obj);
                }
            }).fail(new DfuStatusController$$ExternalSyntheticLambda1());
        } else {
            update();
        }
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterUpdateRequired() {
        update();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onLeaveDfuMode() {
        update();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onLeaveUpdateRequired() {
        update();
    }

    @Override // com.animaconnected.secondo.provider.update.UpdateChangeListener
    public void onUpdateInfoChanged() {
        update();
    }

    @Override // com.animaconnected.secondo.provider.status.StatusController
    public void update() {
        StatusModel statusModel;
        boolean isPhoneBatteryOKForUpdate = this.watchUpdateProvider.isPhoneBatteryOKForUpdate(this.context);
        if (!this.watch.isInDfuMode() && !this.watch.isInUpdateRequired()) {
            if (this.watchDfuProvider.hasDfuFailed() && isPhoneBatteryOKForUpdate) {
                Log.d(TAG, "updating: DFU failed");
                statusModel = DfuFailedStatus.INSTANCE;
            } else {
                if (this.watchDfuProvider.isDfuAvailable()) {
                    this.watchUpdateProvider.showWatchUpdateNotification(false);
                } else if (!this.watchDfuProvider.isDfuAvailable()) {
                    this.watchUpdateProvider.dismissWatchUpdateNotification();
                }
                statusModel = null;
            }
        } else {
            Log.d(TAG, "updating: DFU required");
            this.watchUpdateProvider.showWatchUpdateNotification(true);
            statusModel = DfuRequiredStatus.INSTANCE;
        }
        setCurrentStatusModel(statusModel);
        StatusChangeListener statusChangeListener = getStatusChangeListener();
        if (statusChangeListener != null) {
            statusChangeListener.onStatusChanged();
        }
    }

    @Override // com.animaconnected.watch.DeviceAvailableListener
    public void onDeviceAdded() {
    }
}
