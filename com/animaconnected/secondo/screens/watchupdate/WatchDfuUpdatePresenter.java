package com.animaconnected.secondo.screens.watchupdate;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import com.animaconnected.bluetooth.gatt.DeviceListener;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.location.AndroidLocationBackend;
import com.animaconnected.secondo.provider.update.DfuState;
import com.animaconnected.secondo.provider.update.RemoveBondController;
import com.animaconnected.secondo.provider.update.WatchDfuProvider;
import com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter;
import com.animaconnected.secondo.utils.CustomActivityResult;
import com.animaconnected.watch.device.DfuStatus;
import java.io.File;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchDfuUpdatePresenter.kt */
/* loaded from: classes3.dex */
public final class WatchDfuUpdatePresenter extends BaseWatchUpdatePresenter implements WatchDfuProvider.DfuStatusListener, RemoveBondController.ProgressListener {
    public static final int $stable = 8;
    private final DeviceListener dfuDeviceListener;
    private final WatchDfuProvider dfuProvider;
    private boolean isDfuDeviceConnected;
    private DfuStatus lastDfuStatus;
    private boolean lastPhoneBatteryOk;
    private DfuState lastReceivedDfuState;
    private final PermissionCompat.PermissionHelper permissionHelper;
    private final DfuWatchUpdateView view;

    /* compiled from: WatchDfuUpdatePresenter.kt */
    /* loaded from: classes3.dex */
    public interface DfuWatchUpdateView extends BaseWatchUpdatePresenter.WatchUpdateView {
        static /* synthetic */ void showStartDfuError$default(DfuWatchUpdateView dfuWatchUpdateView, DfuStatus dfuStatus, boolean z, int r3, Object obj) {
            if (obj == null) {
                if ((r3 & 2) != 0) {
                    z = false;
                }
                dfuWatchUpdateView.showStartDfuError(dfuStatus, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showStartDfuError");
        }

        CustomActivityResult<Intent, ActivityResult> activityLauncher();

        void requestLocationPermission(String[] strArr);

        void showDisconnectedDialog();

        void showLoading();

        void showLocationDisabledWarning();

        void showLocationPermissionWarning();

        void showRemoveBondBluetoothDialog();

        void showRemoveBondRestartPhoneFragment();

        void showStartDfuError(DfuStatus dfuStatus, boolean z);

        void updateDfuState(DfuState dfuState);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchDfuUpdatePresenter(DfuWatchUpdateView view, Context context, PermissionCompat.PermissionHelper permissionHelper) {
        super(view, context);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissionHelper, "permissionHelper");
        this.view = view;
        this.permissionHelper = permissionHelper;
        this.dfuProvider = ProviderFactory.getWatchDfuProvider();
        this.lastReceivedDfuState = DfuState.NotStarted.INSTANCE;
        this.lastDfuStatus = DfuStatus.Unknown;
        this.lastPhoneBatteryOk = true;
        this.dfuDeviceListener = new DeviceListener() { // from class: com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdatePresenter$dfuDeviceListener$1
            @Override // com.animaconnected.bluetooth.gatt.DeviceListener
            public void onCharacteristicChanged(UUID service, UUID characteristic, byte[] data) {
                Intrinsics.checkNotNullParameter(service, "service");
                Intrinsics.checkNotNullParameter(characteristic, "characteristic");
                Intrinsics.checkNotNullParameter(data, "data");
            }

            @Override // com.animaconnected.bluetooth.gatt.DeviceListener
            public void onConnected() {
                WatchDfuUpdatePresenter.this.isDfuDeviceConnected = true;
                WatchDfuUpdatePresenter.this.updateView();
            }

            @Override // com.animaconnected.bluetooth.gatt.DeviceListener
            public void onDisconnected() {
                WatchDfuUpdatePresenter.this.isDfuDeviceConnected = false;
                WatchDfuUpdatePresenter.this.updateView();
            }
        };
    }

    private final void startDfu(File file) {
        this.view.onUpdateStarted();
        this.dfuProvider.startDfu(ProviderFactory.getWatch(), file, this.dfuDeviceListener);
    }

    public final PermissionCompat.PermissionHelper getPermissionHelper() {
        return this.permissionHelper;
    }

    public final DfuWatchUpdateView getView() {
        return this.view;
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter
    public boolean hasUpdateStarted() {
        return !Intrinsics.areEqual(this.lastReceivedDfuState, DfuState.NotStarted.INSTANCE);
    }

    @Override // com.animaconnected.secondo.provider.update.WatchDfuProvider.DfuStatusListener
    public void onDfuStatusChanged(DfuState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.lastReceivedDfuState = state;
        updateView();
        this.view.updateDfuState(state);
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter
    public void onPause() {
        super.onPause();
        this.dfuProvider.unregisterListener(this);
        this.dfuProvider.unregisterRemoveBondProgressListener(this);
    }

    @Override // com.animaconnected.secondo.provider.update.RemoveBondController.ProgressListener
    public void onRemoveBondAutoFlowStarted() {
        updateView();
    }

    @Override // com.animaconnected.secondo.provider.update.RemoveBondController.ProgressListener
    public void onRemoveBondFinished() {
        updateView();
    }

    @Override // com.animaconnected.secondo.provider.update.RemoveBondController.ProgressListener
    public void onRemoveBondStarted(boolean z) {
        updateView();
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter
    public void onResume() {
        super.onResume();
        this.dfuProvider.registerListener(this);
        this.dfuProvider.registerRemoveBondProgressListener(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object updateButtonClicked(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdatePresenter.updateButtonClicked(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter
    public void updateView() {
        boolean z;
        DfuState dfuState;
        if (!isResumed()) {
            return;
        }
        DfuState dfuState2 = this.dfuProvider.getDfuState();
        if (hasUpdateStarted()) {
            if (Intrinsics.areEqual(dfuState2, DfuState.NotStarted.INSTANCE)) {
                dfuState = DfuState.Successful.INSTANCE;
            } else {
                dfuState = dfuState2;
            }
            this.view.updateDfuState(dfuState);
        }
        if (hasUpdateStarted() && dfuState2.getAllowDisconnection()) {
            z = true;
        } else {
            z = false;
        }
        if (this.dfuProvider.shouldShowRemoveBond()) {
            int removeBondState = this.dfuProvider.getRemoveBondState();
            if (removeBondState != 0) {
                if (removeBondState != 1) {
                    if (removeBondState == 2) {
                        this.view.showRemoveBondRestartPhoneFragment();
                        return;
                    }
                    return;
                }
                this.view.hideDialogs();
                return;
            }
            this.view.showRemoveBondBluetoothDialog();
            return;
        }
        if (ProviderFactory.getWatch().isInDfuMode()) {
            this.view.showStartWatchUpdate(true);
            return;
        }
        if (!ConnectionFactory.getConnection().isEnabled()) {
            if (hasUpdateStarted()) {
                this.view.showBluetoothDisabledDialog();
                return;
            } else {
                this.view.showBluetoothDisabledWarning();
                return;
            }
        }
        if (!hasUpdateStarted() && !AndroidLocationBackend.isLocationEnabled()) {
            this.view.showLocationDisabledWarning();
            return;
        }
        if (!hasUpdateStarted() && !AndroidLocationBackend.hasForegroundLocationPermission()) {
            this.view.showLocationPermissionWarning();
            return;
        }
        if (!hasUpdateStarted() && !ProviderFactory.getWatchUpdateProvider().isPhoneBatteryOKForUpdate(getContext())) {
            this.view.showStartDfuError(null, true);
            return;
        }
        if (hasUpdateStarted() && !this.isDfuDeviceConnected && !z) {
            this.view.showDisconnectedDialog();
            return;
        }
        if (!hasUpdateStarted() && !ProviderFactory.getWatch().isConnected() && !ProviderFactory.getWatch().isInUpdateRequired() && !z) {
            this.view.showDisconnectedWarning();
        } else if (hasUpdateStarted()) {
            this.view.hideDialogs();
        } else {
            this.view.showStartWatchUpdate(false);
        }
    }
}
