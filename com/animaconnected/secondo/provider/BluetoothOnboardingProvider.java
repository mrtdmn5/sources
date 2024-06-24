package com.animaconnected.secondo.provider;

import com.animaconnected.bluetooth.device.scanner.HybridDevice;
import com.animaconnected.watch.device.DeviceConnectionListener;
import java.util.List;

/* loaded from: classes3.dex */
public interface BluetoothOnboardingProvider {
    HybridDevice getCurrentOnboardedDevice();

    List<HybridDevice> getOnboardedDevices();

    boolean getWroteOnboardingDeviceSettings();

    boolean hasDevice();

    boolean isConnected();

    boolean isInDfuMode();

    boolean isInUpdateRequired();

    boolean isOnboardingFinished();

    void onboardDevice(HybridDevice hybridDevice);

    void registerDeviceConnectionListener(DeviceConnectionListener deviceConnectionListener);

    void unregisterDeviceConnectionListener(DeviceConnectionListener deviceConnectionListener);
}
