package com.animaconnected.watch.device;

import com.animaconnected.info.DeviceType;
import kotlin.coroutines.Continuation;

/* compiled from: DeviceConnectionListener.kt */
/* loaded from: classes3.dex */
public interface DeviceConnectionListener {
    static /* synthetic */ Object onWatchConnecting$suspendImpl(DeviceConnectionListener deviceConnectionListener, WatchBackend watchBackend, DeviceType deviceType, Continuation<? super WatchConnectingResult> continuation) {
        return WatchConnectingResult.Success;
    }

    default Object onWatchConnecting(WatchBackend watchBackend, DeviceType deviceType, Continuation<? super WatchConnectingResult> continuation) {
        return onWatchConnecting$suspendImpl(this, watchBackend, deviceType, continuation);
    }

    default void onConnected() {
    }

    default void onConnecting() {
    }

    default void onDisconnected() {
    }

    default void onEnterDfuMode() {
    }

    default void onEnterUpdateRequired() {
    }

    default void onLeaveDfuMode() {
    }

    default void onLeaveUpdateRequired() {
    }
}
