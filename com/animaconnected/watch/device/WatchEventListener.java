package com.animaconnected.watch.device;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchEventListener.kt */
/* loaded from: classes3.dex */
public interface WatchEventListener {
    default void onDeviceButtonClicked(Button button, ButtonAction action) {
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(action, "action");
    }

    void onDeviceCrash(int r1);

    default void onDeviceError(DeviceError deviceError) {
        Intrinsics.checkNotNullParameter(deviceError, "deviceError");
    }

    default void onDiagEvent(Map<String, String> diagEvent) {
        Intrinsics.checkNotNullParameter(diagEvent, "diagEvent");
    }

    void onStillnessEvent(int r1);

    void onStopwatchDataChanged();

    default void onDevicePostMortem() {
    }

    default void onAlarm(int r1) {
    }

    default void onBatteryCharger(boolean z) {
    }

    default void onBatteryPercent(float f) {
    }

    default void onNotificationDismissed(int r1) {
    }

    default void onPressDuringCall(int r1) {
    }

    default void onRssiEvent(int r1) {
    }

    default void onConnIntChange(int r1, int r2, int r3) {
    }

    default void onStepsNow(int r1, int r2, int r3, int r4) {
    }

    default void onAlert(int r1, int r2, int r3, int r4, int r5) {
    }
}
