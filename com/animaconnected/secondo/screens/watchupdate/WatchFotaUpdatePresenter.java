package com.animaconnected.secondo.screens.watchupdate;

import android.content.Context;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.update.WatchFotaProvider;
import com.animaconnected.secondo.screens.debugsettings.DeviceInfoFragment$$ExternalSyntheticLambda7;
import com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchFotaUpdatePresenter.kt */
/* loaded from: classes3.dex */
public final class WatchFotaUpdatePresenter extends BaseWatchUpdatePresenter implements WatchFotaProvider.FotaStatusListener {
    private static final long FOTA_TIMEOUT = 240000;
    private static final String FOTA_TIMEOUT_ANALYTICS = "FotaTimeoutGotoDashboard";
    private Byte fotaError;
    private final WatchFotaProvider fotaProvider;
    private boolean fotaStarted;
    private boolean isFotaTimeout;
    private final Runnable timeOutRunnable;
    private final FotaWatchUpdateView view;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: WatchFotaUpdatePresenter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: WatchFotaUpdatePresenter.kt */
    /* loaded from: classes3.dex */
    public interface FotaWatchUpdateView extends BaseWatchUpdatePresenter.WatchUpdateView {
        void goBackToDashboard();

        void onStarted();

        void showUpdateFailedDialog(String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFotaUpdatePresenter(FotaWatchUpdateView view, Context context) {
        super(view, context);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = view;
        this.fotaProvider = ProviderFactory.getWatchFotaProvider();
        this.timeOutRunnable = new DeviceInfoFragment$$ExternalSyntheticLambda7(1, this);
    }

    private final void showUpdateFailedDialog(byte b) {
        String string;
        FotaWatchUpdateView fotaWatchUpdateView = this.view;
        if (b == 8) {
            string = getContext().getString(R.string.watch_update_error_battery_too_low);
        } else if (b == 9) {
            string = getContext().getString(R.string.watch_update_error_too_cold);
        } else {
            string = getContext().getString(R.string.watch_update_error_general);
        }
        fotaWatchUpdateView.showUpdateFailedDialog(string);
    }

    public static final void timeOutRunnable$lambda$0(WatchFotaUpdatePresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ProviderFactory.getAppAnalytics().sendAction(FOTA_TIMEOUT_ANALYTICS);
        this$0.isFotaTimeout = true;
        if (this$0.isResumed()) {
            this$0.view.goBackToDashboard();
        }
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter
    public boolean hasUpdateStarted() {
        if (this.fotaStarted && this.fotaError == null) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.secondo.provider.update.WatchFotaProvider.FotaStatusListener
    public void onFotaError(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    @Override // com.animaconnected.secondo.provider.update.WatchFotaProvider.FotaStatusListener
    public void onFotaProgress(List<Byte> pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter
    public void onPause() {
        super.onPause();
        this.fotaProvider.unregisterFotaStatusListener(this);
    }

    @Override // com.animaconnected.secondo.provider.update.WatchFotaProvider.FotaStatusListener
    public void onPerformFotaError(byte b) {
        if ((b == 8 || b == 5 || b == 9) && isResumed()) {
            this.fotaError = Byte.valueOf(b);
            this.fotaProvider.getGetAndClearFotaError();
            showUpdateFailedDialog(b);
        }
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter
    public void onResume() {
        super.onResume();
        this.fotaProvider.registerFotaStatusListener(this);
        Byte getAndClearFotaError = this.fotaProvider.getGetAndClearFotaError();
        if (getAndClearFotaError != null) {
            byte byteValue = getAndClearFotaError.byteValue();
            this.fotaError = Byte.valueOf(byteValue);
            showUpdateFailedDialog(byteValue);
        }
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter
    public void onResumeWithoutChangingView() {
        if (this.isFotaTimeout) {
            this.view.goBackToDashboard();
        }
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter
    public Object updateButtonClicked(Continuation<? super Unit> continuation) {
        if (!ConnectionFactory.getConnection().isEnabled()) {
            ConnectionFactory.getConnection().enable();
        } else {
            getHandler().postDelayed(this.timeOutRunnable, FOTA_TIMEOUT);
            this.fotaStarted = this.fotaProvider.performFota();
            this.view.onStarted();
            updateView();
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter
    public void updateDone() {
        super.updateDone();
        getHandler().removeCallbacks(this.timeOutRunnable);
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter
    public void updateView() {
        if (!isResumed()) {
            return;
        }
        boolean hasUpdateStarted = hasUpdateStarted();
        if (hasUpdateStarted) {
            this.view.onUpdateStarted();
        }
        if (!ConnectionFactory.getConnection().isEnabled()) {
            if (hasUpdateStarted) {
                this.view.showBluetoothDisabledDialog();
                return;
            } else {
                this.view.showBluetoothDisabledWarning();
                return;
            }
        }
        if (!hasUpdateStarted && !ProviderFactory.getWatch().isConnected()) {
            this.view.showDisconnectedWarning();
        } else if (hasUpdateStarted) {
            this.view.hideDialogs();
        } else {
            this.view.showStartWatchUpdate(false);
        }
    }

    @Override // com.animaconnected.secondo.provider.update.WatchFotaProvider.FotaStatusListener
    public void onPerformFotaCompleted() {
    }

    @Override // com.animaconnected.secondo.provider.update.WatchFotaProvider.FotaStatusListener
    public void onReadyToPerformFota() {
    }
}
