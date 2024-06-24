package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.content.Intent;
import java.io.InputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* loaded from: classes4.dex */
interface DfuService extends DfuCallback {
    boolean initialize(Intent intent, BluetoothGatt bluetoothGatt, int r3, InputStream inputStream, InputStream inputStream2) throws DfuException, DeviceDisconnectedException, UploadAbortedException;

    boolean isClientCompatible(Intent intent, BluetoothGatt bluetoothGatt) throws DfuException, DeviceDisconnectedException, UploadAbortedException;

    void performDfu(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException;

    void release();
}
