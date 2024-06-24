package com.animaconnected.secondo.provider.battery;

import com.animaconnected.watch.BaseWatchProviderListener;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.BatteryState;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BatteryProvider.kt */
/* loaded from: classes3.dex */
public final class BatteryProvider {
    public static final int $stable = 8;
    private boolean isCharging;
    private final Set<BatteryListener> listeners;
    private Float percentage;
    private Float previousPercentage;
    private BatteryState state;

    /* compiled from: BatteryProvider.kt */
    /* loaded from: classes3.dex */
    public interface BatteryListener {
        void onBatteryValuesChanged();
    }

    public BatteryProvider(WatchProvider watchProvider) {
        Intrinsics.checkNotNullParameter(watchProvider, "watchProvider");
        this.state = BatteryState.NORMAL;
        this.listeners = new CopyOnWriteArraySet();
        watchProvider.registerListener(new BaseWatchProviderListener() { // from class: com.animaconnected.secondo.provider.battery.BatteryProvider.1
            @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
            public void onBatteryChargerChanged(boolean z) {
                BatteryProvider.this.setCharging(z);
                Iterator it = BatteryProvider.this.listeners.iterator();
                while (it.hasNext()) {
                    ((BatteryListener) it.next()).onBatteryValuesChanged();
                }
            }

            @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
            public void onBatteryPercentChanged(float f) {
                BatteryProvider batteryProvider = BatteryProvider.this;
                batteryProvider.setPreviousPercentage(batteryProvider.getPercentage());
                BatteryProvider.this.setPercentage(Float.valueOf(f));
                Iterator it = BatteryProvider.this.listeners.iterator();
                while (it.hasNext()) {
                    ((BatteryListener) it.next()).onBatteryValuesChanged();
                }
            }

            @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
            public void onBatteryStateChanged(BatteryState batteryState) {
                if (batteryState != null) {
                    BatteryProvider.this.setState(batteryState);
                }
                Iterator it = BatteryProvider.this.listeners.iterator();
                while (it.hasNext()) {
                    ((BatteryListener) it.next()).onBatteryValuesChanged();
                }
            }
        });
    }

    public final Float getPercentage() {
        return this.percentage;
    }

    public final Float getPreviousPercentage() {
        return this.previousPercentage;
    }

    public final BatteryState getState() {
        return this.state;
    }

    public final boolean isCharging() {
        return this.isCharging;
    }

    public final boolean registerBatteryListener(BatteryListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.listeners.add(listener);
    }

    public final void setCharging(boolean z) {
        this.isCharging = z;
    }

    public final void setPercentage(Float f) {
        this.percentage = f;
    }

    public final void setPreviousPercentage(Float f) {
        this.previousPercentage = f;
    }

    public final void setState(BatteryState batteryState) {
        Intrinsics.checkNotNullParameter(batteryState, "<set-?>");
        this.state = batteryState;
    }

    public final boolean unregisterBatteryListener(BatteryListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.listeners.remove(listener);
    }
}
