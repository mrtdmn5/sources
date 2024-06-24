package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Build;
import java.util.UUID;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"MissingPermission"})
/* loaded from: classes4.dex */
public class LegacyDfuImpl extends BaseCustomDfuImpl {
    static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    static final UUID DEFAULT_DFU_PACKET_UUID;
    static final UUID DEFAULT_DFU_SERVICE_UUID;
    static final UUID DEFAULT_DFU_VERSION_UUID;
    static UUID DFU_CONTROL_POINT_UUID = null;
    static UUID DFU_PACKET_UUID = null;
    static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    static UUID DFU_VERSION_UUID = null;
    private static final byte[] OP_CODE_ACTIVATE_AND_RESET;
    private static final int OP_CODE_ACTIVATE_AND_RESET_KEY = 5;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_COMPLETE;
    private static final int OP_CODE_INIT_DFU_PARAMS_KEY = 2;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_START;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_KEY = 17;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 8;
    private static final byte[] OP_CODE_RECEIVE_FIRMWARE_IMAGE;
    private static final int OP_CODE_RECEIVE_FIRMWARE_IMAGE_KEY = 3;
    private static final byte[] OP_CODE_RESET;
    private static final int OP_CODE_RESET_KEY = 6;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 16;
    private static final byte[] OP_CODE_START_DFU;
    private static final int OP_CODE_START_DFU_KEY = 1;
    private static final byte[] OP_CODE_START_DFU_V1;
    private static final byte[] OP_CODE_VALIDATE;
    private static final int OP_CODE_VALIDATE_KEY = 4;
    private final LegacyBluetoothCallback mBluetoothCallback;
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private boolean mImageSizeInProgress;
    private BluetoothGattCharacteristic mPacketCharacteristic;

    /* loaded from: classes4.dex */
    public class LegacyBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        public LegacyBluetoothCallback() {
            super();
        }

        @Override // no.nordicsemi.android.dfu.BaseDfuImpl.BaseBluetoothGattCallback, android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            if ((bArr[0] & 255) == 17) {
                LegacyDfuImpl.this.mProgressInfo.setBytesReceived(getInt(bArr, 1));
                handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
            } else {
                LegacyDfuImpl legacyDfuImpl = LegacyDfuImpl.this;
                if (!legacyDfuImpl.mRemoteErrorOccurred) {
                    if ((bArr[2] & 255) != 1) {
                        legacyDfuImpl.mRemoteErrorOccurred = true;
                    }
                    handleNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
                }
            }
            LegacyDfuImpl.this.notifyLock();
        }

        @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl.BaseCustomBluetoothCallback
        public void onPacketCharacteristicWrite() {
            if (LegacyDfuImpl.this.mImageSizeInProgress) {
                LegacyDfuImpl.this.mImageSizeInProgress = false;
            }
        }
    }

    static {
        UUID r0 = new UUID(23296205844446L, 1523193452336828707L);
        DEFAULT_DFU_SERVICE_UUID = r0;
        UUID r1 = new UUID(23300500811742L, 1523193452336828707L);
        DEFAULT_DFU_CONTROL_POINT_UUID = r1;
        UUID r2 = new UUID(23304795779038L, 1523193452336828707L);
        DEFAULT_DFU_PACKET_UUID = r2;
        UUID r5 = new UUID(23313385713630L, 1523193452336828707L);
        DEFAULT_DFU_VERSION_UUID = r5;
        DFU_SERVICE_UUID = r0;
        DFU_CONTROL_POINT_UUID = r1;
        DFU_PACKET_UUID = r2;
        DFU_VERSION_UUID = r5;
        OP_CODE_START_DFU = new byte[]{1, 0};
        OP_CODE_START_DFU_V1 = new byte[]{1};
        OP_CODE_INIT_DFU_PARAMS = new byte[]{2};
        OP_CODE_INIT_DFU_PARAMS_START = new byte[]{2, 0};
        OP_CODE_INIT_DFU_PARAMS_COMPLETE = new byte[]{2, 1};
        OP_CODE_RECEIVE_FIRMWARE_IMAGE = new byte[]{3};
        OP_CODE_VALIDATE = new byte[]{4};
        OP_CODE_ACTIVATE_AND_RESET = new byte[]{5};
        OP_CODE_RESET = new byte[]{6};
        OP_CODE_PACKET_RECEIPT_NOTIF_REQ = new byte[]{8, 0, 0};
    }

    public LegacyDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        this.mBluetoothCallback = new LegacyBluetoothCallback();
    }

    private int getStatusCode(byte[] bArr, int r5) throws UnknownResponseException {
        byte b;
        if (bArr != null && bArr.length == 3 && bArr[0] == 16 && bArr[1] == r5 && (b = bArr[2]) >= 1 && b <= 6) {
            return b;
        }
        throw new UnknownResponseException("Invalid response received", bArr, 16, r5);
    }

    private int readVersion(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic == null) {
            return 0;
        }
        return bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
    }

    private void resetAndRestart(BluetoothGatt bluetoothGatt, Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        boolean z;
        this.mService.sendLogBroadcast(15, "Last upload interrupted. Restarting device...");
        this.mProgressInfo.setProgress(-5);
        logi("Sending Reset command (Op Code = 6)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
        this.mService.sendLogBroadcast(10, "Reset request sent");
        this.mService.waitUntilDisconnected();
        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        BluetoothGattService service = bluetoothGatt.getService(BaseDfuImpl.GENERIC_ATTRIBUTE_SERVICE_UUID);
        if (service != null && service.getCharacteristic(BaseDfuImpl.SERVICE_CHANGED_UUID) != null) {
            z = true;
        } else {
            z = false;
        }
        this.mService.refreshDeviceCache(bluetoothGatt, !z);
        this.mService.close(bluetoothGatt);
        logi("Restarting the service");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, false);
    }

    private void setImageSize(byte[] bArr, int r4, int r5) {
        bArr[r5] = (byte) (r4 & 255);
        bArr[r5 + 1] = (byte) ((r4 >> 8) & 255);
        bArr[r5 + 2] = (byte) ((r4 >> 16) & 255);
        bArr[r5 + 3] = (byte) ((r4 >> 24) & 255);
    }

    private void setNumberOfPackets(byte[] bArr, int r4) {
        bArr[1] = (byte) (r4 & 255);
        bArr[2] = (byte) ((r4 >> 8) & 255);
    }

    private void writeImageSize(BluetoothGattCharacteristic bluetoothGattCharacteristic, int r7) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeInProgress = true;
        byte[] bArr = new byte[4];
        setImageSize(bArr, r7, 0);
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
        if (Build.VERSION.SDK_INT >= 33) {
            this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ", value=" + parse(bArr) + ", WRITE_TYPE_NO_RESPONSE)");
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic, bArr, 1);
        } else {
            bluetoothGattCharacteristic.setWriteType(1);
            bluetoothGattCharacteristic.setValue(bArr);
            this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        }
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((!this.mImageSizeInProgress || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    } else {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mAborted) {
            if (this.mConnected) {
                if (this.mError != 0) {
                    throw new DfuException("Unable to write Image Size", this.mError);
                }
                return;
            }
            throw new DeviceDisconnectedException("Unable to write Image Size: device disconnected");
        }
        throw new UploadAbortedException();
    }

    private void writeOpCode(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        boolean z = false;
        byte b = bArr[0];
        if (b == 6 || b == 5) {
            z = true;
        }
        writeOpCode(bluetoothGattCharacteristic, bArr, z);
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    public UUID getControlPointCharacteristicUUID() {
        return DFU_CONTROL_POINT_UUID;
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    public UUID getDfuServiceUUID() {
        return DFU_SERVICE_UUID;
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    public UUID getPacketCharacteristicUUID() {
        return DFU_PACKET_UUID;
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = bluetoothGatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_PACKET_UUID);
        this.mPacketCharacteristic = characteristic2;
        if (characteristic2 == null) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x061d A[Catch: UnknownResponseException -> 0x0214, UploadAbortedException -> 0x0218, RemoteDfuException -> 0x0635, TryCatch #0 {RemoteDfuException -> 0x0635, blocks: (B:65:0x03bb, B:67:0x03bf, B:70:0x03cc, B:71:0x0432, B:74:0x045e, B:75:0x0465, B:76:0x040a, B:78:0x0468, B:85:0x0478, B:86:0x04b0, B:88:0x04cf, B:89:0x04e2, B:91:0x053a, B:93:0x05e2, B:96:0x0610, B:99:0x0615, B:100:0x061c, B:101:0x061d, B:102:0x0624, B:105:0x0626, B:106:0x062c, B:107:0x0474, B:118:0x0316, B:122:0x0320, B:124:0x03b3, B:129:0x062d, B:130:0x0632, B:131:0x0633, B:132:0x0634), top: B:117:0x0316 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03bf A[Catch: UnknownResponseException -> 0x0214, UploadAbortedException -> 0x0218, RemoteDfuException -> 0x0635, TRY_LEAVE, TryCatch #0 {RemoteDfuException -> 0x0635, blocks: (B:65:0x03bb, B:67:0x03bf, B:70:0x03cc, B:71:0x0432, B:74:0x045e, B:75:0x0465, B:76:0x040a, B:78:0x0468, B:85:0x0478, B:86:0x04b0, B:88:0x04cf, B:89:0x04e2, B:91:0x053a, B:93:0x05e2, B:96:0x0610, B:99:0x0615, B:100:0x061c, B:101:0x061d, B:102:0x0624, B:105:0x0626, B:106:0x062c, B:107:0x0474, B:118:0x0316, B:122:0x0320, B:124:0x03b3, B:129:0x062d, B:130:0x0632, B:131:0x0633, B:132:0x0634), top: B:117:0x0316 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0468 A[Catch: UnknownResponseException -> 0x0214, UploadAbortedException -> 0x0218, RemoteDfuException -> 0x0635, TryCatch #0 {RemoteDfuException -> 0x0635, blocks: (B:65:0x03bb, B:67:0x03bf, B:70:0x03cc, B:71:0x0432, B:74:0x045e, B:75:0x0465, B:76:0x040a, B:78:0x0468, B:85:0x0478, B:86:0x04b0, B:88:0x04cf, B:89:0x04e2, B:91:0x053a, B:93:0x05e2, B:96:0x0610, B:99:0x0615, B:100:0x061c, B:101:0x061d, B:102:0x0624, B:105:0x0626, B:106:0x062c, B:107:0x0474, B:118:0x0316, B:122:0x0320, B:124:0x03b3, B:129:0x062d, B:130:0x0632, B:131:0x0633, B:132:0x0634), top: B:117:0x0316 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0478 A[Catch: UnknownResponseException -> 0x0214, UploadAbortedException -> 0x0218, RemoteDfuException -> 0x0635, TryCatch #0 {RemoteDfuException -> 0x0635, blocks: (B:65:0x03bb, B:67:0x03bf, B:70:0x03cc, B:71:0x0432, B:74:0x045e, B:75:0x0465, B:76:0x040a, B:78:0x0468, B:85:0x0478, B:86:0x04b0, B:88:0x04cf, B:89:0x04e2, B:91:0x053a, B:93:0x05e2, B:96:0x0610, B:99:0x0615, B:100:0x061c, B:101:0x061d, B:102:0x0624, B:105:0x0626, B:106:0x062c, B:107:0x0474, B:118:0x0316, B:122:0x0320, B:124:0x03b3, B:129:0x062d, B:130:0x0632, B:131:0x0633, B:132:0x0634), top: B:117:0x0316 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x053a A[Catch: UnknownResponseException -> 0x0214, UploadAbortedException -> 0x0218, RemoteDfuException -> 0x0635, TryCatch #0 {RemoteDfuException -> 0x0635, blocks: (B:65:0x03bb, B:67:0x03bf, B:70:0x03cc, B:71:0x0432, B:74:0x045e, B:75:0x0465, B:76:0x040a, B:78:0x0468, B:85:0x0478, B:86:0x04b0, B:88:0x04cf, B:89:0x04e2, B:91:0x053a, B:93:0x05e2, B:96:0x0610, B:99:0x0615, B:100:0x061c, B:101:0x061d, B:102:0x0624, B:105:0x0626, B:106:0x062c, B:107:0x0474, B:118:0x0316, B:122:0x0320, B:124:0x03b3, B:129:0x062d, B:130:0x0632, B:131:0x0633, B:132:0x0634), top: B:117:0x0316 }] */
    @Override // no.nordicsemi.android.dfu.DfuService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void performDfu(android.content.Intent r37) throws no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            Method dump skipped, instructions count: 1787
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyDfuImpl.performDfu(android.content.Intent):void");
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseCustomDfuImpl.BaseCustomBluetoothCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    private void writeImageSize(BluetoothGattCharacteristic bluetoothGattCharacteristic, int r5, int r6, int r7) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeInProgress = true;
        byte[] bArr = new byte[12];
        setImageSize(bArr, r5, 0);
        setImageSize(bArr, r6, 4);
        setImageSize(bArr, r7, 8);
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
        if (Build.VERSION.SDK_INT >= 33) {
            this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ", value=" + parse(bArr) + ", WRITE_TYPE_NO_RESPONSE)");
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic, bArr, 1);
        } else {
            bluetoothGattCharacteristic.setWriteType(1);
            bluetoothGattCharacteristic.setValue(bArr);
            this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        }
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((!this.mImageSizeInProgress || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    } else {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mAborted) {
            if (this.mConnected) {
                if (this.mError != 0) {
                    throw new DfuException("Unable to write Image Sizes", this.mError);
                }
                return;
            }
            throw new DeviceDisconnectedException("Unable to write Image Sizes: device disconnected");
        }
        throw new UploadAbortedException();
    }
}
