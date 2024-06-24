package com.animaconnected.secondo.provider.lostwatch;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.location.AndroidLocationBackend;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceConnectionListener;
import com.animaconnected.watch.location.LocationResult;
import com.animaconnected.watch.location.Spot;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes3.dex */
public class LostWatchProvider implements DeviceConnectionListener {
    private static final int FETCH_LOCATION_DELAY_MS = 10000;
    private String mAddress;
    private long mAnalyticsFetchLocationTime;
    private final boolean mIsEnabled;
    private OnSpotFetchedListener mListener;
    private final LostWatchStorage mLostWatchStorage;
    private boolean mStartOnDisconnect;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mFetchLocationRunnable = new Runnable() { // from class: com.animaconnected.secondo.provider.lostwatch.LostWatchProvider$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            LostWatchProvider.this.lambda$new$0();
        }
    };
    private FetchStatus mStatus = FetchStatus.IDLE;

    /* loaded from: classes3.dex */
    public enum FetchStatus {
        WAITING_ON_DELAY,
        WAITING_FOR_LOCATION_FETCHER,
        IDLE
    }

    /* loaded from: classes3.dex */
    public interface OnSpotFetchedListener {
        void onSpotFetched(Spot spot);
    }

    public LostWatchProvider(Context context) {
        this.mLostWatchStorage = new LostWatchStorage(context.getApplicationContext());
        boolean appLostWatchEnable = RemoteConfigController.getInstance(context.getApplicationContext()).getAppLostWatchEnable();
        this.mIsEnabled = appLostWatchEnable;
        if (appLostWatchEnable) {
            ProviderFactory.getWatch().registerDeviceConnectionListener(this);
        }
    }

    private void failedToFetchLocation(String str) {
        ProviderFactory.getAppAnalytics().sendLostWatchEvent("fetch_location_failed", Long.valueOf(System.currentTimeMillis() - this.mAnalyticsFetchLocationTime));
        this.mLostWatchStorage.removeLostWatchSpot(str);
        this.mStatus = FetchStatus.IDLE;
        OnSpotFetchedListener onSpotFetchedListener = this.mListener;
        if (onSpotFetchedListener != null) {
            onSpotFetchedListener.onSpotFetched(this.mLostWatchStorage.getLostWatchSpot(str));
        }
    }

    private void fetchLocation(final String str) {
        this.mAnalyticsFetchLocationTime = System.currentTimeMillis();
        this.mStatus = FetchStatus.WAITING_FOR_LOCATION_FETCHER;
        AndroidLocationBackend.fetchLocation(AndroidLocationBackend.LocationCriteria.HighAccuracy, new Function1() { // from class: com.animaconnected.secondo.provider.lostwatch.LostWatchProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$fetchLocation$1;
                lambda$fetchLocation$1 = LostWatchProvider.this.lambda$fetchLocation$1(str, (LocationResult) obj);
                return lambda$fetchLocation$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$fetchLocation$1(String str, LocationResult locationResult) {
        if (locationResult instanceof Spot) {
            ProviderFactory.getAppAnalytics().sendLostWatchEvent("fetch_location_success", Long.valueOf(System.currentTimeMillis() - this.mAnalyticsFetchLocationTime));
            this.mStatus = FetchStatus.IDLE;
            OnSpotFetchedListener onSpotFetchedListener = this.mListener;
            if (onSpotFetchedListener != null) {
                onSpotFetchedListener.onSpotFetched((Spot) locationResult);
            }
            this.mLostWatchStorage.storeLostWatchSpot(str, (Spot) locationResult);
            return null;
        }
        failedToFetchLocation(str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        ProviderFactory.getAppAnalytics().sendLostWatchEvent("fetch_location_after_delay", null);
        fetchLocation(this.mAddress);
    }

    private void startLostWatch() {
        this.mHandler.postDelayed(this.mFetchLocationRunnable, 10000L);
        this.mStatus = FetchStatus.WAITING_ON_DELAY;
    }

    private void stopLostWatch() {
        this.mHandler.removeCallbacks(this.mFetchLocationRunnable);
        this.mStatus = FetchStatus.IDLE;
    }

    public void getLastKnownSpot(String str, OnSpotFetchedListener onSpotFetchedListener) {
        this.mListener = onSpotFetchedListener;
        WatchProvider watch = ProviderFactory.getWatch();
        if (watch.isConnected() && str.equals(watch.getAddress())) {
            fetchLocation(str);
            return;
        }
        FetchStatus fetchStatus = this.mStatus;
        if (fetchStatus == FetchStatus.WAITING_ON_DELAY) {
            stopLostWatch();
            fetchLocation(str);
        } else if (fetchStatus == FetchStatus.IDLE && this.mListener != null) {
            ProviderFactory.getAppAnalytics().sendLostWatchEvent("fetch_location_from_storage", null);
            this.mListener.onSpotFetched(this.mLostWatchStorage.getLostWatchSpot(str));
        }
    }

    public FetchStatus getStatus() {
        return this.mStatus;
    }

    public boolean hasStoredLocation(String str) {
        return this.mLostWatchStorage.hasLostWatchSpot(str);
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnected() {
        String address = ProviderFactory.getWatch().getAddress();
        stopLostWatch();
        String str = this.mAddress;
        if (str != null && !str.equals(address)) {
            fetchLocation(this.mAddress);
        } else {
            this.mLostWatchStorage.removeLostWatchSpot(address);
        }
        this.mStartOnDisconnect = true;
        this.mAddress = address;
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onDisconnected() {
        String address = ProviderFactory.getWatch().getAddress();
        String str = this.mAddress;
        if (str != null && !str.equals(address)) {
            fetchLocation(this.mAddress);
        }
        this.mAddress = address;
        if (this.mStartOnDisconnect) {
            this.mStartOnDisconnect = false;
            startLostWatch();
        }
    }
}
