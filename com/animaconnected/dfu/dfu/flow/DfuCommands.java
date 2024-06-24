package com.animaconnected.dfu.dfu.flow;

import android.bluetooth.BluetoothGattCharacteristic;
import com.animaconnected.bluetooth.gatt.GattDevice;
import com.animaconnected.bluetooth.util.Callback;
import com.animaconnected.dfu.dfu.utils.DfuConstants;
import com.animaconnected.dfu.dfu.utils.DfuUtilities;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes.dex */
public class DfuCommands {
    private static final String TAG = "DfuCommands";
    private final byte[] mBuffer;
    private final byte mImageType;
    private int mPreviousPercentage;
    private SendBufferProgressListener mProgressListener;
    private final int mSize;

    /* loaded from: classes.dex */
    public interface SendBufferProgressListener {
        void onProgressChanged(int r1);
    }

    public DfuCommands(byte[] bArr, byte b) {
        this.mBuffer = bArr;
        this.mSize = bArr.length;
        this.mImageType = b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BluetoothGattCharacteristic getBluetoothCaracteristics(GattDevice gattDevice, UUID r2) {
        return gattDevice.getCharacteristic(DfuConstants.SERVICE_UUID, r2);
    }

    private void sendData(GattDevice gattDevice, final int r6, final int r7, final Callback<Void> callback) {
        UUID r0 = DfuConstants.DATA_CHARA_UUID;
        BluetoothGattCharacteristic bluetoothCaracteristics = getBluetoothCaracteristics(gattDevice, r0);
        bluetoothCaracteristics.setWriteType(1);
        bluetoothCaracteristics.setValue(Arrays.copyOfRange(this.mBuffer, r6, r6 + r7));
        write(gattDevice, bluetoothCaracteristics.getValue(), r0, new Callback<Void>() { // from class: com.animaconnected.dfu.dfu.flow.DfuCommands.4
            @Override // com.animaconnected.bluetooth.util.Callback
            public void onError(Throwable th) {
                callback.onError(th);
            }

            @Override // com.animaconnected.bluetooth.util.Callback
            public void onSuccess(Void r4) {
                int r02 = (int) (((r6 + r7) / (DfuCommands.this.mSize - (DfuCommands.this.mSize % 20))) * 100.0f);
                if (r02 != DfuCommands.this.mPreviousPercentage) {
                    DfuCommands.this.mPreviousPercentage = r02;
                    DfuUtilities.setPercentage(r02);
                    DfuCommands.this.mProgressListener.onProgressChanged(r02);
                }
                callback.onSuccess(r4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextPart(final GattDevice gattDevice, final int r11, final int r12, final Callback<Void> callback) {
        int r0 = r11 * 20;
        if (r11 == r12) {
            int r112 = this.mSize;
            if (r112 % 20 != 0) {
                sendData(gattDevice, r0, r112 % 20, callback);
                return;
            } else {
                callback.onSuccess(null);
                return;
            }
        }
        sendData(gattDevice, r0, 20, new Callback<Void>() { // from class: com.animaconnected.dfu.dfu.flow.DfuCommands.3
            @Override // com.animaconnected.bluetooth.util.Callback
            public void onError(Throwable th) {
                callback.onError(th);
            }

            @Override // com.animaconnected.bluetooth.util.Callback
            public void onSuccess(Void r5) {
                DfuCommands.this.sendNextPart(gattDevice, r11 + 1, r12, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void write(GattDevice gattDevice, byte[] bArr, UUID r4, Callback<Void> callback) {
        gattDevice.write(DfuConstants.SERVICE_UUID, r4, bArr, callback);
    }

    public void sendBuffer(final GattDevice gattDevice, final SendBufferProgressListener sendBufferProgressListener, final Callback<Void> callback) {
        sendControlOpCode(gattDevice, new byte[]{3}, new Callback<Void>() { // from class: com.animaconnected.dfu.dfu.flow.DfuCommands.2
            @Override // com.animaconnected.bluetooth.util.Callback
            public void onError(Throwable th) {
                callback.onError(th);
            }

            @Override // com.animaconnected.bluetooth.util.Callback
            public void onSuccess(Void r5) {
                DfuUtilities.log("Percentage", "0%");
                DfuCommands.this.mPreviousPercentage = -1;
                DfuCommands.this.mProgressListener = sendBufferProgressListener;
                DfuCommands dfuCommands = DfuCommands.this;
                dfuCommands.sendNextPart(gattDevice, 0, dfuCommands.mSize / 20, callback);
            }
        });
    }

    public void sendControlOpCode(GattDevice gattDevice, byte[] bArr, Callback<Void> callback) {
        UUID r0 = DfuConstants.CONTROL_CHARA_UUID;
        BluetoothGattCharacteristic bluetoothCaracteristics = getBluetoothCaracteristics(gattDevice, r0);
        bluetoothCaracteristics.setValue(bArr);
        write(gattDevice, bluetoothCaracteristics.getValue(), r0, callback);
    }

    public void sendDataImageSize(GattDevice gattDevice, Callback<Void> callback) {
        int r2;
        int r22;
        UUID r0 = DfuConstants.DATA_CHARA_UUID;
        BluetoothGattCharacteristic bluetoothCaracteristics = getBluetoothCaracteristics(gattDevice, r0);
        bluetoothCaracteristics.setWriteType(1);
        bluetoothCaracteristics.setValue(new byte[12]);
        int r4 = 0;
        if (this.mImageType == 1) {
            r2 = this.mSize;
        } else {
            r2 = 0;
        }
        bluetoothCaracteristics.setValue(r2, 20, 0);
        if (this.mImageType == 2) {
            r22 = this.mSize;
        } else {
            r22 = 0;
        }
        bluetoothCaracteristics.setValue(r22, 20, 4);
        if (this.mImageType == 4) {
            r4 = this.mSize;
        }
        bluetoothCaracteristics.setValue(r4, 20, 8);
        write(gattDevice, bluetoothCaracteristics.getValue(), r0, callback);
    }

    public void sendInitParams(final GattDevice gattDevice, final Callback<Void> callback) {
        sendControlOpCode(gattDevice, new byte[]{2, 0}, new Callback<Void>() { // from class: com.animaconnected.dfu.dfu.flow.DfuCommands.1
            @Override // com.animaconnected.bluetooth.util.Callback
            public void onError(Throwable th) {
                callback.onError(th);
            }

            @Override // com.animaconnected.bluetooth.util.Callback
            public void onSuccess(Void r8) {
                GattDevice gattDevice2 = gattDevice;
                UUID r0 = DfuConstants.DATA_CHARA_UUID;
                BluetoothGattCharacteristic bluetoothCaracteristics = DfuCommands.getBluetoothCaracteristics(gattDevice2, r0);
                bluetoothCaracteristics.setWriteType(1);
                bluetoothCaracteristics.setValue(new byte[14]);
                bluetoothCaracteristics.setValue(65535, 18, 0);
                bluetoothCaracteristics.setValue(65535, 18, 2);
                bluetoothCaracteristics.setValue(-1, 20, 4);
                bluetoothCaracteristics.setValue(1, 17, 8);
                bluetoothCaracteristics.setValue(0, 17, 9);
                bluetoothCaracteristics.setValue(65534, 18, 10);
                bluetoothCaracteristics.setValue(DfuUtilities.crc16(DfuCommands.this.mBuffer), 18, 12);
                DfuCommands.this.write(gattDevice, bluetoothCaracteristics.getValue(), r0, new Callback<Void>() { // from class: com.animaconnected.dfu.dfu.flow.DfuCommands.1.1
                    @Override // com.animaconnected.bluetooth.util.Callback
                    public void onError(Throwable th) {
                        callback.onError(th);
                    }

                    @Override // com.animaconnected.bluetooth.util.Callback
                    public void onSuccess(Void r4) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        DfuCommands.this.sendControlOpCode(gattDevice, new byte[]{2, 1}, callback);
                    }
                });
            }
        });
    }

    public void setNotification(GattDevice gattDevice, Callback<Void> callback) {
        gattDevice.setNotification(DfuConstants.SERVICE_UUID, DfuConstants.CONTROL_CHARA_UUID, new byte[]{1}, callback);
    }
}
