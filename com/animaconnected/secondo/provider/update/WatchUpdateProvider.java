package com.animaconnected.secondo.provider.update;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.status.internal.dfu.WatchUpdateNotificationController;
import com.animaconnected.secondo.screens.watchupdate.updateinfo.Update;
import com.animaconnected.secondo.screens.watchupdate.updateinfo.UpdateInfo;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DfuStatus;
import com.animaconnected.watch.device.FirmwareUpdate;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchUpdateProvider.kt */
/* loaded from: classes3.dex */
public final class WatchUpdateProvider {
    private static final double MIN_PHONE_BATTERY_PERCENTAGE_FOR_DFU = 0.3d;
    private static final double MIN_PHONE_BATTERY_PERCENTAGE_FOR_RESUMING_DFU = 0.25d;
    private final WatchUpdateNotificationController notificationController;
    private final UpdateInfo updateInfo;
    private final WatchProvider watchProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: WatchUpdateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public WatchUpdateProvider(WatchProvider watchProvider, Context context) {
        Intrinsics.checkNotNullParameter(watchProvider, "watchProvider");
        this.watchProvider = watchProvider;
        UpdateInfo updateInfo = new UpdateInfo(KronabyApplication.Companion.getContext());
        this.updateInfo = updateInfo;
        this.notificationController = new WatchUpdateNotificationController(context);
        watchProvider.registerFirmwareChangedListener(updateInfo);
    }

    public final void clear() {
        clearUpdateInfo();
        this.notificationController.clear();
    }

    public final void clearUpdateInfo() {
        this.updateInfo.clearInfo();
    }

    public final void dismissWatchUpdateNotification() {
        this.notificationController.dismissUpdateAvailableNotification();
    }

    public final List<Update> getCompletedUpdates(FirmwareUpdate firmwareUpdate) {
        return this.updateInfo.getCompletedUpdates(firmwareUpdate);
    }

    public final List<Update> getPendingUpdates(String str, FirmwareUpdate firmwareUpdate) {
        return this.updateInfo.getDownloadedUpdates(str, firmwareUpdate);
    }

    public final boolean hasUpdateCompletedInfo() {
        return this.updateInfo.hasUpdateCompletedInfo();
    }

    public final Object isDeviceReadyForDfu(Continuation<? super DfuStatus> continuation) {
        return this.watchProvider.getDfuStatus(continuation);
    }

    public final boolean isPhoneBatteryOKForUpdate(Context context) {
        boolean z;
        double d;
        if (context == null) {
            return false;
        }
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        Intrinsics.checkNotNull(registerReceiver);
        int intExtra = registerReceiver.getIntExtra(AnalyticsConstants.KEY_STATUS, -1);
        if (intExtra != 2 && intExtra != 5) {
            z = false;
        } else {
            z = true;
        }
        float intExtra2 = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
        FirmwareUpdate firmwareUpdate = this.watchProvider.getFirmwareUpdate();
        if (this.watchProvider.isInDfuMode()) {
            d = MIN_PHONE_BATTERY_PERCENTAGE_FOR_RESUMING_DFU;
        } else if (firmwareUpdate.isDfu()) {
            d = MIN_PHONE_BATTERY_PERCENTAGE_FOR_DFU;
        } else {
            d = 0.0d;
        }
        if (!z && intExtra2 < d) {
            return false;
        }
        return true;
    }

    public final void setDownloadedVersion(String str) {
        this.updateInfo.setDownloadedFirmwareRevision(str);
    }

    public final void showWatchUpdateNotification(boolean z) {
        this.notificationController.createUpdateAvailableNotification(z);
    }
}
