package com.animaconnected.secondo.provider.analytics;

import android.os.SystemClock;
import com.animaconnected.secondo.provider.ProviderFactory;

/* loaded from: classes3.dex */
public class AnalyticsTrackingProvider {
    private static AnalyticsTrackingProvider sInstance;
    private String mCurrentFragment;
    private Long mTimePaused;
    private Long mTimeStampLastPause;
    private Long mTimeStampStart;

    private AnalyticsTrackingProvider() {
    }

    public static AnalyticsTrackingProvider getInstance() {
        if (sInstance == null) {
            sInstance = new AnalyticsTrackingProvider();
        }
        return sInstance;
    }

    public void pauseTrackingFragment() {
        if (this.mCurrentFragment != null) {
            this.mTimeStampLastPause = Long.valueOf(SystemClock.elapsedRealtime());
        }
    }

    public void resumeTrackingFragment() {
        if (this.mCurrentFragment != null && this.mTimeStampLastPause != null) {
            this.mTimePaused = Long.valueOf((SystemClock.elapsedRealtime() - this.mTimeStampLastPause.longValue()) + this.mTimePaused.longValue());
            this.mTimeStampLastPause = null;
        }
    }

    public void startTrackingFragment(String str) {
        String str2 = this.mCurrentFragment;
        if (str2 != null && !str2.equals(str)) {
            stopTrackingFragment();
        }
        this.mCurrentFragment = str;
        this.mTimeStampStart = Long.valueOf(SystemClock.elapsedRealtime());
        this.mTimePaused = 0L;
    }

    public void stopTrackingFragment() {
        if (this.mCurrentFragment != null) {
            if (this.mTimeStampLastPause != null) {
                this.mTimePaused = Long.valueOf((SystemClock.elapsedRealtime() - this.mTimeStampLastPause.longValue()) + this.mTimePaused.longValue());
                this.mTimeStampLastPause = null;
            }
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.mTimeStampStart.longValue()) - this.mTimePaused.longValue();
            this.mCurrentFragment = this.mCurrentFragment.replace("Fragment", "F");
            ProviderFactory.getAppAnalytics().sendFragmentVisited(this.mCurrentFragment, Long.valueOf(elapsedRealtime));
            this.mCurrentFragment = null;
        }
    }
}
