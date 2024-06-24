package com.animaconnected.secondo.screens.watchupdate;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.bluetooth.util.ConnectionListener;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.device.DeviceConnectionListener;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseWatchUpdatePresenter.kt */
/* loaded from: classes3.dex */
public abstract class BaseWatchUpdatePresenter implements DeviceConnectionListener {
    private static final int WATCH_UPDATE_FRAGMENT_TIMEOUT = 600000;
    private final ConnectionListener connectionListener;
    private final Context context;
    private final Handler handler;
    private boolean isResumed;
    private boolean timedOut;
    private final WatchUpdateView view;
    private final Runnable watchUpdateTimeoutRunnable;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: BaseWatchUpdatePresenter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BaseWatchUpdatePresenter(WatchUpdateView view, Context context) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = view;
        this.context = context;
        Handler handler = new Handler(Looper.getMainLooper());
        this.handler = handler;
        Runnable runnable = new Runnable() { // from class: com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BaseWatchUpdatePresenter.watchUpdateTimeoutRunnable$lambda$0(BaseWatchUpdatePresenter.this);
            }
        };
        this.watchUpdateTimeoutRunnable = runnable;
        if (!ProviderFactory.getWatch().isInDfuMode()) {
            handler.postDelayed(runnable, 600000L);
        }
        this.connectionListener = new ConnectionListener() { // from class: com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter$$ExternalSyntheticLambda1
            @Override // com.animaconnected.bluetooth.util.ConnectionListener
            public final void onChanged(boolean z) {
                BaseWatchUpdatePresenter.connectionListener$lambda$2(BaseWatchUpdatePresenter.this, z);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectionListener$lambda$2(final BaseWatchUpdatePresenter this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handler.post(new Runnable() { // from class: com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                BaseWatchUpdatePresenter.connectionListener$lambda$2$lambda$1(BaseWatchUpdatePresenter.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectionListener$lambda$2$lambda$1(BaseWatchUpdatePresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$3(BaseWatchUpdatePresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onTimeout();
    }

    private final void onTimeout() {
        if (!hasUpdateStarted()) {
            if (this.isResumed) {
                this.view.goBackToSettings();
            }
            this.timedOut = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void watchUpdateTimeoutRunnable$lambda$0(BaseWatchUpdatePresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onTimeout();
    }

    public final Context getContext() {
        return this.context;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public abstract boolean hasUpdateStarted();

    public final boolean isResumed() {
        return this.isResumed;
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnected() {
        updateView();
        if (ProviderFactory.getWatchUpdateProvider().hasUpdateCompletedInfo() && this.isResumed) {
            updateDone();
        }
    }

    public final void onDestroy() {
        this.handler.removeCallbacks(this.watchUpdateTimeoutRunnable);
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onDisconnected() {
        updateView();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterDfuMode() {
        updateView();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterUpdateRequired() {
        updateView();
        if (ProviderFactory.getWatchUpdateProvider().hasUpdateCompletedInfo() && this.isResumed) {
            updateDone();
        }
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onLeaveDfuMode() {
        updateView();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onLeaveUpdateRequired() {
        updateView();
    }

    public void onPause() {
        this.isResumed = false;
        ConnectionFactory.getConnection().removeConnectionListener(this.connectionListener);
        ProviderFactory.getWatch().unregisterDeviceConnectionListener(this);
    }

    public void onResume() {
        this.isResumed = true;
        if (ProviderFactory.getWatchUpdateProvider().hasUpdateCompletedInfo() && (ProviderFactory.getWatch().isConnected() || ProviderFactory.getWatch().isInUpdateRequired())) {
            updateDone();
        } else if (this.timedOut) {
            this.handler.post(new Runnable() { // from class: com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    BaseWatchUpdatePresenter.onResume$lambda$3(BaseWatchUpdatePresenter.this);
                }
            });
        } else {
            onResumeWithoutChangingView();
        }
        ConnectionFactory.getConnection().addConnectionListener(this.connectionListener);
        ProviderFactory.getWatch().registerDeviceConnectionListener(this);
        updateView();
    }

    public final void setResumed(boolean z) {
        this.isResumed = z;
    }

    public abstract Object updateButtonClicked(Continuation<? super Unit> continuation);

    public void updateDone() {
        this.view.onUpdateDone();
    }

    public abstract void updateView();

    /* compiled from: BaseWatchUpdatePresenter.kt */
    /* loaded from: classes3.dex */
    public interface WatchUpdateView {
        void goBackToSettings();

        void hideDialogs();

        void onUpdateStarted();

        void showBluetoothDisabledDialog();

        void showBluetoothDisabledWarning();

        void showDisconnectedWarning();

        void showStartWatchUpdate(boolean z);

        default void onUpdateDone() {
        }
    }

    public void onResumeWithoutChangingView() {
    }
}
