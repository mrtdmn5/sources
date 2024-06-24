package com.animaconnected.secondo.screens.dashboard;

import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.update.BackgroundUpdateChecker;
import com.animaconnected.secondo.provider.update.UpdateChangeListener;
import com.animaconnected.secondo.provider.update.WatchFotaProvider;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.BatteryState;
import com.animaconnected.watch.device.DeviceConnectionListener;
import com.animaconnected.watch.provider.quiethours.RefreshTimer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashboardPresenter.kt */
/* loaded from: classes3.dex */
public final class DashboardPresenter implements UpdateChangeListener, DeviceConnectionListener, WatchFotaProvider.FotaStatusListener {
    public static final int $stable = 8;
    private final BackgroundUpdateChecker backgroundUpdateChecker;
    private RefreshTimer quietHoursRefreshTimer;
    private final DashboardView view;
    private final WatchProvider watchProvider;

    /* compiled from: DashboardPresenter.kt */
    /* loaded from: classes3.dex */
    public interface DashboardView {
        void enableApps(boolean z);

        void enableButtons(boolean z);

        void enableUpdateBadge(boolean z);

        void updateQuietHoursBadge(boolean z);
    }

    public DashboardPresenter(DashboardView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.backgroundUpdateChecker = ProviderFactory.getBackgroundUpdateChecker();
        this.watchProvider = ProviderFactory.getWatch();
    }

    private final void enableButtonCheck(boolean z, boolean z2) {
        boolean z3;
        DashboardView dashboardView = this.view;
        if ((z && z2) || ProviderFactory.getSettingProvider().getAvailability()) {
            z3 = true;
        } else {
            z3 = false;
        }
        dashboardView.enableButtons(z3);
    }

    private final boolean isDeviceIsFullyOperating() {
        if (ProviderFactory.getBatteryProvider().getState() == BatteryState.CRITICAL && !this.watchProvider.getWatch().getCapabilities().getHasChargeableBattery()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateQuietHoursBadge() {
        boolean z;
        RefreshTimer refreshTimer = this.quietHoursRefreshTimer;
        if (refreshTimer != null) {
            refreshTimer.dispose();
        }
        ProviderFactory providerFactory = ProviderFactory.INSTANCE;
        this.quietHoursRefreshTimer = providerFactory.getQuietHoursProvider().runOnNextChange(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.dashboard.DashboardPresenter$updateQuietHoursBadge$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DashboardPresenter.this.updateQuietHoursBadge();
            }
        });
        DashboardView dashboardView = this.view;
        if (providerFactory.getQuietHoursProvider().isActive() && this.watchProvider.hasDoNotDisturb()) {
            z = true;
        } else {
            z = false;
        }
        dashboardView.updateQuietHoursBadge(z);
    }

    private final void updateWatchType() {
        this.view.enableApps(this.watchProvider.getWatch().getHasDisplay());
    }

    private final void updateWatchUpdateBadge() {
        boolean z;
        if (!ProviderFactory.getWatchDfuProvider().isDfuAvailable() && !this.watchProvider.isInDfuMode() && !this.watchProvider.isInUpdateRequired() && !ProviderFactory.getWatchFotaProvider().isReadyToPerformFota()) {
            z = false;
        } else {
            z = true;
        }
        this.view.enableUpdateBadge(z);
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnected() {
        enableButtonCheck(true, isDeviceIsFullyOperating());
        updateWatchUpdateBadge();
    }

    public final void onCreate() {
        updateWatchType();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onDisconnected() {
        enableButtonCheck(false, isDeviceIsFullyOperating());
        updateWatchUpdateBadge();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterDfuMode() {
        updateWatchUpdateBadge();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterUpdateRequired() {
        updateWatchUpdateBadge();
    }

    @Override // com.animaconnected.secondo.provider.update.WatchFotaProvider.FotaStatusListener
    public void onFotaError(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    @Override // com.animaconnected.secondo.provider.update.WatchFotaProvider.FotaStatusListener
    public void onFotaProgress(List<Byte> pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
    }

    public final void onPause() {
        this.watchProvider.unregisterDeviceConnectionListener(this);
        this.backgroundUpdateChecker.unregisterListener(this);
        ProviderFactory.getWatchFotaProvider().unregisterFotaStatusListener(this);
        RefreshTimer refreshTimer = this.quietHoursRefreshTimer;
        if (refreshTimer != null) {
            refreshTimer.dispose();
        }
    }

    @Override // com.animaconnected.secondo.provider.update.WatchFotaProvider.FotaStatusListener
    public void onReadyToPerformFota() {
        updateWatchUpdateBadge();
    }

    public final void onResume() {
        this.watchProvider.registerDeviceConnectionListener(this);
        enableButtonCheck(this.watchProvider.isConnected(), isDeviceIsFullyOperating());
        this.backgroundUpdateChecker.registerListener(this);
        ProviderFactory.getWatchFotaProvider().registerFotaStatusListener(this);
        updateWatchUpdateBadge();
        updateQuietHoursBadge();
    }

    @Override // com.animaconnected.secondo.provider.update.UpdateChangeListener
    public void onUpdateInfoChanged() {
        updateWatchUpdateBadge();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnecting() {
    }

    @Override // com.animaconnected.secondo.provider.update.WatchFotaProvider.FotaStatusListener
    public void onPerformFotaCompleted() {
    }

    @Override // com.animaconnected.secondo.provider.update.WatchFotaProvider.FotaStatusListener
    public void onPerformFotaError(byte b) {
    }
}
