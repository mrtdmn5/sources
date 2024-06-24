package com.animaconnected.secondo.behaviour.watchbattery;

import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.battery.BatteryProvider;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.behaviour.WatchFaceBehavior;
import com.animaconnected.watch.device.Scale;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchBattery.kt */
/* loaded from: classes3.dex */
public final class WatchBattery extends WatchFaceBehavior {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    public static final String TYPE = "WatchBattery";
    private final float maxAngle = 300.0f;
    private final BatteryProvider batteryProvider = ProviderFactory.getBatteryProvider();
    private final WatchBattery$listener$1 listener = new BatteryProvider.BatteryListener() { // from class: com.animaconnected.secondo.behaviour.watchbattery.WatchBattery$listener$1
        @Override // com.animaconnected.secondo.provider.battery.BatteryProvider.BatteryListener
        public void onBatteryValuesChanged() {
            WatchBattery.this.notifyDataChanged();
        }
    };
    private final int deviceComplicationMode = 46;
    private final String type = TYPE;
    private final String analyticsName = "watch_battery";

    /* compiled from: WatchBattery.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final float batteryInDegrees() {
        float f;
        Float percentage = this.batteryProvider.getPercentage();
        if (percentage != null) {
            f = percentage.floatValue();
        } else {
            f = 0.0f;
        }
        float f2 = this.maxAngle;
        float f3 = f * f2;
        if (f3 <= f2) {
            return f3;
        }
        return f2;
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public List<Scale> compatibleScales() {
        return CollectionsKt__CollectionsKt.listOf(Scale.ZeroToHundred);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return new Slot[]{Slot.MainComplication, Slot.MainComplicationDouble, Slot.SubComplication1, Slot.SubComplication2};
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.behaviour.Complication
    public int getDeviceComplicationMode() {
        return this.deviceComplicationMode;
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getHoursInDegrees() {
        return batteryInDegrees();
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getMinutesInDegrees() {
        return batteryInDegrees();
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public boolean isSelectable(Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        return watch.getCapabilities().getHasChargeableBattery();
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public void startRefreshing() {
        this.batteryProvider.registerBatteryListener(this.listener);
        notifyDataChanged();
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public void stopRefreshing() {
        this.batteryProvider.unregisterBatteryListener(this.listener);
    }
}
