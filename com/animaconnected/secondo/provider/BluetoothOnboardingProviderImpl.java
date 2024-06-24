package com.animaconnected.secondo.provider;

import com.animaconnected.bluetooth.device.scanner.HybridDevice;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceConnectionListener;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class BluetoothOnboardingProviderImpl implements BluetoothOnboardingProvider {
    private final WatchProvider mWatch;

    public BluetoothOnboardingProviderImpl(WatchProvider watchProvider) {
        this.mWatch = watchProvider;
    }

    @Override // com.animaconnected.secondo.provider.BluetoothOnboardingProvider
    public HybridDevice getCurrentOnboardedDevice() {
        return this.mWatch.getCurrentOnboardedDevice();
    }

    @Override // com.animaconnected.secondo.provider.BluetoothOnboardingProvider
    public List<HybridDevice> getOnboardedDevices() {
        return this.mWatch.getOnboardedDevices();
    }

    @Override // com.animaconnected.secondo.provider.BluetoothOnboardingProvider
    public boolean getWroteOnboardingDeviceSettings() {
        return this.mWatch.getWroteOnboardingDeviceSettings();
    }

    @Override // com.animaconnected.secondo.provider.BluetoothOnboardingProvider
    public boolean hasDevice() {
        return this.mWatch.hasDevice();
    }

    @Override // com.animaconnected.secondo.provider.BluetoothOnboardingProvider
    public boolean isConnected() {
        return this.mWatch.isConnected();
    }

    @Override // com.animaconnected.secondo.provider.BluetoothOnboardingProvider
    public boolean isInDfuMode() {
        return this.mWatch.isInDfuMode();
    }

    @Override // com.animaconnected.secondo.provider.BluetoothOnboardingProvider
    public boolean isInUpdateRequired() {
        return this.mWatch.isInUpdateRequired();
    }

    @Override // com.animaconnected.secondo.provider.BluetoothOnboardingProvider
    public boolean isOnboardingFinished() {
        return this.mWatch.isOnboardingFinished();
    }

    @Override // com.animaconnected.secondo.provider.BluetoothOnboardingProvider
    public void onboardDevice(HybridDevice hybridDevice) {
        this.mWatch.onboardDevice(hybridDevice);
    }

    @Override // com.animaconnected.secondo.provider.BluetoothOnboardingProvider
    public void registerDeviceConnectionListener(DeviceConnectionListener deviceConnectionListener) {
        this.mWatch.registerDeviceConnectionListener(deviceConnectionListener);
    }

    @Override // com.animaconnected.secondo.provider.BluetoothOnboardingProvider
    public void unregisterDeviceConnectionListener(DeviceConnectionListener deviceConnectionListener) {
        this.mWatch.unregisterDeviceConnectionListener(deviceConnectionListener);
    }
}
