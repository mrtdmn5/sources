package com.animaconnected.secondo.provider;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceConnectionListener;

/* loaded from: classes3.dex */
public class FastModeProvider implements DeviceConnectionListener {
    private static final String FAST_MODE_ANALYTICS_REFRESH = "fast_mode_refreshed";
    private static final String TAG = "FastModeProvider";
    private static FastModeProvider sInstance;
    private boolean mIsAppInForeground;
    private boolean mIsFastmodeRunning;
    private final WatchProvider mWatchProvider;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mFastModeRunnable = new Runnable() { // from class: com.animaconnected.secondo.provider.FastModeProvider.1
        @Override // java.lang.Runnable
        public void run() {
            FastModeProvider.this.refreshFastMode();
            FastModeProvider.this.mHandler.postDelayed(FastModeProvider.this.mFastModeRunnable, 60000L);
        }
    };

    private FastModeProvider(WatchProvider watchProvider) {
        this.mWatchProvider = watchProvider;
        watchProvider.registerDeviceConnectionListener(this);
    }

    public static FastModeProvider getInstance(WatchProvider watchProvider) {
        if (sInstance == null) {
            sInstance = new FastModeProvider(watchProvider);
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshFastMode() {
        this.mWatchProvider.setFastMode(true);
        ProviderFactory.getAppAnalytics().sendAction(FAST_MODE_ANALYTICS_REFRESH);
        Log.d(TAG, "Refreshing fastMode to keep it alive");
    }

    private void update() {
        boolean hasFastMode = this.mWatchProvider.hasFastMode();
        boolean fastModeEnable = RemoteConfigController.getInstance(KronabyApplication.getContext()).getFastModeEnable();
        boolean isConnected = this.mWatchProvider.isConnected();
        Log.d(TAG, "Watch connected: " + isConnected + " | Watch has fastmode: " + hasFastMode + " | App is in foreground: " + this.mIsAppInForeground + " | Remoteconfig enabled: " + fastModeEnable);
        if (isConnected && hasFastMode && this.mIsAppInForeground && fastModeEnable) {
            if (!this.mIsFastmodeRunning) {
                this.mIsFastmodeRunning = true;
                this.mHandler.post(this.mFastModeRunnable);
                return;
            }
            return;
        }
        if (this.mIsFastmodeRunning) {
            this.mIsFastmodeRunning = false;
            this.mWatchProvider.setFastMode(false);
            this.mHandler.removeCallbacks(this.mFastModeRunnable);
        }
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnected() {
        update();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onDisconnected() {
        update();
    }

    public void onPause() {
        this.mIsAppInForeground = false;
        update();
    }

    public void onResume() {
        this.mIsAppInForeground = true;
        update();
    }
}
