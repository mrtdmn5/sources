package com.animaconnected.watch;

import android.net.Uri;
import com.animaconnected.bluetooth.device.DeviceFotaListener;
import com.animaconnected.bluetooth.dfu.BaseDfuController;
import com.animaconnected.bluetooth.dfu.BaseFotaController;
import com.animaconnected.bluetooth.gatt.OnboardingConnectionListener;
import com.animaconnected.future.Future;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.FirmwareVariant;
import com.animaconnected.watch.device.DeviceDfuListener;
import com.animaconnected.watch.device.DeviceInfo;
import com.animaconnected.watch.device.FirmwareUpdate;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: DeviceInterface.kt */
/* loaded from: classes3.dex */
public interface DeviceInterface {

    /* compiled from: DeviceInterface.kt */
    /* loaded from: classes3.dex */
    public interface FirmwareInfoListener {
        void onFirmwareChanged(String str, String str2, boolean z);
    }

    void cancelFota();

    void changeAddress(String str);

    void close();

    void connect();

    Object debugFakeConnect(Continuation<? super Unit> continuation);

    Object debugScan(Continuation<? super Unit> continuation);

    String getAddress();

    boolean getDebugMode();

    Future<Map<DeviceInfo, String>> getDeviceInformationCached();

    DeviceType getDeviceType();

    String getFirmwareRevisionCached();

    FirmwareUpdate getFirmwareUpdate();

    FirmwareUpdate getFirmwareUpdateCached();

    FirmwareVariant getFirmwareVariant();

    List<Byte> getLastPagesInfo();

    boolean isBonded();

    boolean isConnected();

    boolean isConnecting();

    boolean isFotaSlowModeEnabled();

    boolean isInDfuMode();

    boolean isInUpdateRequired();

    boolean isRunningFota();

    void onConnectionIntervalChange(int r1);

    void onResume();

    void performFota();

    void registerDfuListener(DeviceDfuListener deviceDfuListener);

    void registerFotaListener(DeviceFotaListener deviceFotaListener);

    void registerOnboardingConnectionListener(OnboardingConnectionListener onboardingConnectionListener);

    /* renamed from: removeBond-IoAF18A */
    Object mo1044removeBondIoAF18A(Continuation<? super Result<Unit>> continuation);

    void setDebugMode(boolean z);

    void setFirmwareInfoListener(FirmwareInfoListener firmwareInfoListener);

    void setFotaSlowMode(boolean z);

    Future<Void> startDfu(BaseDfuController baseDfuController, Uri uri);

    void startFota(BaseFotaController baseFotaController, Uri uri, boolean z);

    void unregisterDfuListener(DeviceDfuListener deviceDfuListener);

    void unregisterFotaListener(DeviceFotaListener deviceFotaListener);

    void unregisterOnboardingConnectionListener(OnboardingConnectionListener onboardingConnectionListener);
}
