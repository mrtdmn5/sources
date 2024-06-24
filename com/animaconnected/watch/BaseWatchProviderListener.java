package com.animaconnected.watch;

import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.device.BatteryState;
import com.animaconnected.watch.device.ButtonAction;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseWatchProviderListener.kt */
/* loaded from: classes3.dex */
public class BaseWatchProviderListener implements WatchProvider.WatchProviderListener {
    public static final int $stable = 0;

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onBehaviourSet(Slot slot, Behaviour behaviour) {
        Intrinsics.checkNotNullParameter(slot, "slot");
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onButtonClicked(Slot slot, Behaviour behaviour, ButtonAction action, boolean z) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(action, "action");
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener, com.animaconnected.watch.device.WatchEventListener
    public void onDiagEvent(Map<String, String> diagEvent) {
        Intrinsics.checkNotNullParameter(diagEvent, "diagEvent");
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onCalibrationTimeout() {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onDaily() {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onOnboardingStarted() {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onStopwatchDataChanged() {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onWroteDeviceSettings() {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onAlarmEvent(int r1) {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onBatteryChargerChanged(boolean z) {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onBatteryPercentChanged(float f) {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onBatteryStateChanged(BatteryState batteryState) {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onBehaviourExecuted(Behaviour behaviour) {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onConnectionChanged(boolean z) {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onOnboardingFinished(boolean z) {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener, com.animaconnected.watch.device.WatchEventListener
    public void onRssiEvent(int r1) {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onStillnessEvent(int r1) {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onStepsNow(int r1, int r2) {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener, com.animaconnected.watch.device.WatchEventListener
    public void onConnIntChange(int r1, int r2, int r3) {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onDeviceDebugDisconnect(Integer num, Integer num2, Integer num3) {
    }

    @Override // com.animaconnected.watch.WatchProvider.WatchProviderListener
    public void onAlertEvent(int r1, int r2, int r3, int r4, int r5) {
    }
}
