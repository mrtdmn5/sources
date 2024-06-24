package com.animaconnected.secondo.behaviour.dayofweek;

import android.os.Handler;
import android.os.Looper;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.behaviour.WatchFaceBehavior;
import com.animaconnected.watch.device.Scale;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

/* loaded from: classes3.dex */
public class DayOfWeek extends WatchFaceBehavior {
    private static final String BEHAVIOUR_ANALYTICS_NAME = "dayofweek";
    private static final long REFRESH_INTERVAL = 1000;
    public static final String TYPE = "DayOfWeek";
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mRefreshRunnable = new Runnable() { // from class: com.animaconnected.secondo.behaviour.dayofweek.DayOfWeek.1
        @Override // java.lang.Runnable
        public void run() {
            DayOfWeek.this.refresh();
            DayOfWeek.this.mHandler.postDelayed(this, DayOfWeek.REFRESH_INTERVAL);
        }
    };

    private float getDayOfWeekInDegrees() {
        return (getDayOfWeekValue() - 1) * 51.42857f;
    }

    private int getDayOfWeekValue() {
        return new GregorianCalendar().get(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        notifyDataChanged();
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public List<Scale> compatibleScales() {
        return Collections.singletonList(Scale.DaysOfWeek);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return new Slot[]{Slot.SubComplication1, Slot.SubComplication2};
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return BEHAVIOUR_ANALYTICS_NAME;
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public int getDeviceComplicationMode() {
        return 28;
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getHoursInDegrees() {
        return getDayOfWeekInDegrees();
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getMinutesInDegrees() {
        return getDayOfWeekInDegrees();
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return TYPE;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public boolean isSelectable(Watch watch) {
        return watch.getCapabilities().hasScaleOnSubdials(Scale.DaysOfWeek);
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public void startRefreshing() {
        this.mHandler.post(this.mRefreshRunnable);
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public void stopRefreshing() {
        this.mHandler.removeCallbacks(this.mRefreshRunnable);
    }
}
