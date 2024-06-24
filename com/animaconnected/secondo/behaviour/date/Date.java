package com.animaconnected.secondo.behaviour.date;

import android.os.Handler;
import android.os.Looper;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.WatchFaceBehavior;
import com.animaconnected.watch.device.Capabilities;
import com.animaconnected.watch.device.Scale;
import com.animaconnected.watch.device.WatchConstantsKt;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

/* loaded from: classes3.dex */
public class Date extends WatchFaceBehavior {
    private static final String BEHAVIOUR_ANALYTICS_NAME = "date";
    private static final long REFRESH_INTERVAL = 1000;
    public static final String TYPE = "Date";
    private Slot mCurrentSlot = Slot.Unknown;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mRefreshRunnable = new Runnable() { // from class: com.animaconnected.secondo.behaviour.date.Date.1
        @Override // java.lang.Runnable
        public void run() {
            Date.this.refresh();
            Date.this.mHandler.postDelayed(this, Date.REFRESH_INTERVAL);
        }
    };

    private float getDateInDegrees0_31() {
        return getDateValue() * 6.0f;
    }

    private float getDateInDegrees0_31_1() {
        if (getDateValue() == 31) {
            return 6.0f;
        }
        return getDateValue() * 12.0f;
    }

    private int getDateValue() {
        return new GregorianCalendar().get(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        notifyDataChanged();
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void activate(Slot slot) {
        super.activate(slot);
        this.mCurrentSlot = slot;
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public List<Scale> compatibleScales() {
        return Collections.singletonList(Scale.ZeroToThirtyOne);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return new Slot[]{Slot.MainComplication, Slot.MainComplicationDouble, Slot.SubComplication1, Slot.SubComplication2};
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void deactivated(Slot slot) {
        super.deactivated(slot);
        this.mCurrentSlot = Slot.Unknown;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return BEHAVIOUR_ANALYTICS_NAME;
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public int getDeviceComplicationMode() {
        return 0;
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getHoursInDegrees() {
        return getHoursInDegrees(this.mCurrentSlot);
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getMinutesInDegrees() {
        return getHoursInDegrees(this.mCurrentSlot);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return TYPE;
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public void startRefreshing() {
        this.mHandler.post(this.mRefreshRunnable);
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public void stopRefreshing() {
        this.mHandler.removeCallbacks(this.mRefreshRunnable);
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getHoursInDegrees(Slot slot) {
        if (slot != Slot.SubComplication1 && slot != Slot.SubComplication2) {
            return getDateInDegrees0_31();
        }
        Capabilities capabilities = ProviderFactory.getWatch().getCapabilities();
        if (capabilities.getWatchFaces().get(WatchConstantsKt.toWatchFace(slot)).getScales().contains(Scale.ZeroToThirtyOne)) {
            return getDateInDegrees0_31_1();
        }
        throw new RuntimeException("Slot put on unsupported watch face");
    }
}
