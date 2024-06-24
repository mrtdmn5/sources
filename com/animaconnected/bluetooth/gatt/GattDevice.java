package com.animaconnected.bluetooth.gatt;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.animaconnected.bluetooth.device.ScanToConnectInterface;
import com.animaconnected.bluetooth.util.Callback;
import com.animaconnected.future.Future;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.FirmwareVariant;
import java.util.UUID;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GattDevice.kt */
/* loaded from: classes.dex */
public interface GattDevice {
    static /* synthetic */ void setNotification$default(GattDevice gattDevice, UUID r1, UUID r2, byte[] ENABLE_INDICATION_VALUE, int r4, Object obj) {
        if (obj == null) {
            if ((r4 & 4) != 0) {
                ENABLE_INDICATION_VALUE = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
                Intrinsics.checkNotNullExpressionValue(ENABLE_INDICATION_VALUE, "ENABLE_INDICATION_VALUE");
            }
            gattDevice.setNotification(r1, r2, ENABLE_INDICATION_VALUE);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNotification");
    }

    void changeAddress(String str);

    void connect();

    GattDevice createClone(ScanToConnectInterface scanToConnectInterface);

    void disconnect();

    Object fakeConnect(Continuation<? super Unit> continuation);

    String getAddress();

    BluetoothGattCharacteristic getCharacteristic(UUID r1, UUID r2);

    DeviceType getDeviceType();

    FirmwareVariant getFirmwareVariant();

    boolean guessIfDeviceIsInDfu();

    boolean hasGattService(UUID r1);

    boolean isBonded();

    boolean isConnected();

    void onResume();

    void read(UUID r1, UUID r2, ReadCallback readCallback);

    void refreshConnection(boolean z);

    void registerListener(DeviceListener deviceListener);

    Future<Void> removeBond();

    void removeOnboardingConnectionListener(OnboardingConnectionListener onboardingConnectionListener);

    Object scan(String str, Continuation<? super Unit> continuation);

    void setNotification(UUID r1, UUID r2, byte[] bArr);

    void setNotification(UUID r1, UUID r2, byte[] bArr, Callback<Void> callback);

    void setOnboardingConnectionListener(OnboardingConnectionListener onboardingConnectionListener);

    void skipBondingAndRefresh();

    void unregisterListener(DeviceListener deviceListener);

    void write(UUID r1, UUID r2, byte[] bArr, Callback<Void> callback);

    void writeRead(UUID r1, UUID r2, byte[] bArr, ReadCallback readCallback);
}
