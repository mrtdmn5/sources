package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.SystemClock;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.UUID;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.BaseDfuImpl;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.error.SecureDfuError;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class SecureDfuImpl extends BaseCustomDfuImpl {
    static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    static final UUID DEFAULT_DFU_PACKET_UUID;
    static final UUID DEFAULT_DFU_SERVICE_UUID;
    static UUID DFU_CONTROL_POINT_UUID = null;
    static UUID DFU_PACKET_UUID = null;
    static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    private static final int MAX_ATTEMPTS = 3;
    private static final int OBJECT_COMMAND = 1;
    private static final int OBJECT_DATA = 2;
    private static final byte[] OP_CODE_CALCULATE_CHECKSUM;
    private static final int OP_CODE_CALCULATE_CHECKSUM_KEY = 3;
    private static final byte[] OP_CODE_CREATE_COMMAND;
    private static final byte[] OP_CODE_CREATE_DATA;
    private static final int OP_CODE_CREATE_KEY = 1;
    private static final byte[] OP_CODE_EXECUTE;
    private static final int OP_CODE_EXECUTE_KEY = 4;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 2;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 96;
    private static final byte[] OP_CODE_SELECT_OBJECT;
    private static final int OP_CODE_SELECT_OBJECT_KEY = 6;
    private final SecureBluetoothCallback mBluetoothCallback;
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private BluetoothGattCharacteristic mPacketCharacteristic;
    private long prepareObjectDelay;

    /* loaded from: classes4.dex */
    public static class ObjectChecksum {
        int CRC32;
        int offset;

        public /* synthetic */ ObjectChecksum(int r1) {
            this();
        }

        private ObjectChecksum() {
        }
    }

    /* loaded from: classes4.dex */
    public static class ObjectInfo extends ObjectChecksum {
        int maxSize;

        public /* synthetic */ ObjectInfo(int r1) {
            this();
        }

        private ObjectInfo() {
            super(0);
        }
    }

    /* loaded from: classes4.dex */
    public class SecureBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        public SecureBluetoothCallback() {
            super();
        }

        @Override // no.nordicsemi.android.dfu.BaseDfuImpl.BaseBluetoothGattCallback, android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            if (bArr.length < 3) {
                SecureDfuImpl.this.loge("Empty response: " + parse(bArr));
                SecureDfuImpl secureDfuImpl = SecureDfuImpl.this;
                secureDfuImpl.mError = DfuBaseService.ERROR_INVALID_RESPONSE;
                secureDfuImpl.notifyLock();
                return;
            }
            if ((bArr[0] & 255) == 96) {
                if ((bArr[1] & 255) != 3) {
                    SecureDfuImpl secureDfuImpl2 = SecureDfuImpl.this;
                    if (!secureDfuImpl2.mRemoteErrorOccurred) {
                        if ((bArr[2] & 255) != 1) {
                            secureDfuImpl2.mRemoteErrorOccurred = true;
                        }
                        handleNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
                    }
                } else {
                    int intValue = bluetoothGattCharacteristic.getIntValue(20, 3).intValue();
                    if (((int) (((ArchiveInputStream) SecureDfuImpl.this.mFirmwareStream).getCrc32() & 4294967295L)) == bluetoothGattCharacteristic.getIntValue(20, 7).intValue()) {
                        SecureDfuImpl.this.mProgressInfo.setBytesReceived(intValue);
                    } else {
                        SecureDfuImpl secureDfuImpl3 = SecureDfuImpl.this;
                        if (secureDfuImpl3.mFirmwareUploadInProgress) {
                            secureDfuImpl3.mFirmwareUploadInProgress = false;
                            secureDfuImpl3.notifyLock();
                            return;
                        }
                    }
                    handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
                }
            } else {
                SecureDfuImpl.this.loge("Invalid response: " + parse(bArr));
                SecureDfuImpl.this.mError = DfuBaseService.ERROR_INVALID_RESPONSE;
            }
            SecureDfuImpl.this.notifyLock();
        }
    }

    static {
        UUID r0 = new UUID(279658205548544L, -9223371485494954757L);
        DEFAULT_DFU_SERVICE_UUID = r0;
        UUID r1 = new UUID(-8157989241631715488L, -6937650605005804976L);
        DEFAULT_DFU_CONTROL_POINT_UUID = r1;
        UUID r2 = new UUID(-8157989237336748192L, -6937650605005804976L);
        DEFAULT_DFU_PACKET_UUID = r2;
        DFU_SERVICE_UUID = r0;
        DFU_CONTROL_POINT_UUID = r1;
        DFU_PACKET_UUID = r2;
        OP_CODE_CREATE_COMMAND = new byte[]{1, 1, 0, 0, 0, 0};
        OP_CODE_CREATE_DATA = new byte[]{1, 2, 0, 0, 0, 0};
        OP_CODE_PACKET_RECEIPT_NOTIF_REQ = new byte[]{2, 0, 0};
        OP_CODE_CALCULATE_CHECKSUM = new byte[]{3};
        OP_CODE_EXECUTE = new byte[]{4};
        OP_CODE_SELECT_OBJECT = new byte[]{6, 0};
    }

    public SecureDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        this.mBluetoothCallback = new SecureBluetoothCallback();
    }

    private int getStatusCode(byte[] bArr, int r7) throws UnknownResponseException {
        byte b;
        if (bArr != null && bArr.length >= 3 && bArr[0] == 96 && bArr[1] == r7 && ((b = bArr[2]) == 1 || b == 2 || b == 3 || b == 4 || b == 5 || b == 7 || b == 8 || b == 10 || b == 11)) {
            return b;
        }
        throw new UnknownResponseException("Invalid response received", bArr, 96, r7);
    }

    private ObjectChecksum readChecksum() throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.mConnected) {
            writeOpCode(this.mControlPointCharacteristic, OP_CODE_CALCULATE_CHECKSUM);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 3);
            if (statusCode != 11) {
                if (statusCode == 1) {
                    ObjectChecksum objectChecksum = new ObjectChecksum(0);
                    objectChecksum.offset = unsignedBytesToInt(readNotificationResponse, 3);
                    objectChecksum.CRC32 = unsignedBytesToInt(readNotificationResponse, 7);
                    return objectChecksum;
                }
                throw new RemoteDfuException("Receiving Checksum failed", statusCode);
            }
            throw new RemoteDfuExtendedErrorException("Receiving Checksum failed", readNotificationResponse[3]);
        }
        throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
    }

    private ObjectInfo selectObject(int r6) throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.mConnected) {
            byte[] bArr = OP_CODE_SELECT_OBJECT;
            bArr[1] = (byte) r6;
            writeOpCode(this.mControlPointCharacteristic, bArr);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 6);
            if (statusCode != 11) {
                if (statusCode == 1) {
                    ObjectInfo objectInfo = new ObjectInfo(0);
                    objectInfo.maxSize = unsignedBytesToInt(readNotificationResponse, 3);
                    objectInfo.offset = unsignedBytesToInt(readNotificationResponse, 7);
                    objectInfo.CRC32 = unsignedBytesToInt(readNotificationResponse, 11);
                    return objectInfo;
                }
                throw new RemoteDfuException("Selecting object failed", statusCode);
            }
            throw new RemoteDfuExtendedErrorException("Selecting object failed", readNotificationResponse[3]);
        }
        throw new DeviceDisconnectedException("Unable to read object info: device disconnected");
    }

    private void sendFirmware(BluetoothGatt bluetoothGatt) throws RemoteDfuException, DeviceDisconnectedException, DfuException, UploadAbortedException, UnknownResponseException {
        int r16;
        String str;
        int r14;
        boolean z;
        String str2;
        boolean z2;
        int r6 = this.mPacketsBeforeNotification;
        if (r6 > 0) {
            setPacketReceiptNotifications(r6);
            this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 2) sent (Value = " + r6 + ")");
        }
        logi("Setting object to Data (Op Code = 6, Type = 2)");
        ObjectInfo selectObject = selectObject(2);
        Locale locale = Locale.US;
        logi(String.format(locale, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(selectObject.maxSize), Integer.valueOf(selectObject.offset), Integer.valueOf(selectObject.CRC32)));
        this.mService.sendLogBroadcast(10, String.format(locale, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(selectObject.maxSize), Integer.valueOf(selectObject.offset), Integer.valueOf(selectObject.CRC32)));
        this.mProgressInfo.setMaxObjectSizeInBytes(selectObject.maxSize);
        int r8 = this.mImageSizeInBytes;
        int r9 = selectObject.maxSize;
        int r82 = ((r8 + r9) - 1) / r9;
        int r10 = selectObject.offset;
        if (r10 <= 0) {
            str = ")";
            r14 = r82;
            this.mProgressInfo.setBytesSent(0);
            z = false;
            r16 = 0;
        } else {
            try {
                int r142 = r10 / r9;
                int r15 = r9 * r142;
                int r102 = r10 - r15;
                if (r102 == 0) {
                    r15 -= r9;
                } else {
                    r9 = r102;
                }
                if (r15 > 0) {
                    r16 = r142;
                    this.mFirmwareStream.read(new byte[r15]);
                    this.mFirmwareStream.mark(selectObject.maxSize);
                } else {
                    r16 = r142;
                }
                this.mFirmwareStream.read(new byte[r9]);
                str = ")";
                r14 = r82;
                if (((int) (((ArchiveInputStream) this.mFirmwareStream).getCrc32() & 4294967295L)) == selectObject.CRC32) {
                    logi(selectObject.offset + " bytes of data sent before, CRC match");
                    this.mService.sendLogBroadcast(10, selectObject.offset + " bytes of data sent before, CRC match");
                    this.mProgressInfo.setBytesSent(selectObject.offset);
                    this.mProgressInfo.setBytesReceived(selectObject.offset);
                    if (r9 == selectObject.maxSize && selectObject.offset < this.mImageSizeInBytes) {
                        logi("Executing data object (Op Code = 4)");
                        try {
                            writeExecute();
                            this.mService.sendLogBroadcast(10, "Data object executed");
                        } catch (RemoteDfuException e) {
                            if (e.getErrorNumber() == 8) {
                                this.mService.sendLogBroadcast(10, "Data object already executed");
                                this.mRemoteErrorOccurred = false;
                            } else {
                                throw e;
                            }
                        }
                    } else {
                        z = true;
                    }
                } else {
                    logi(selectObject.offset + " bytes sent before, CRC does not match");
                    this.mService.sendLogBroadcast(15, selectObject.offset + " bytes sent before, CRC does not match");
                    this.mProgressInfo.setBytesSent(r15);
                    this.mProgressInfo.setBytesReceived(r15);
                    selectObject.offset = selectObject.offset - r9;
                    selectObject.CRC32 = 0;
                    this.mFirmwareStream.reset();
                    logi("Resuming from byte " + selectObject.offset + "...");
                    this.mService.sendLogBroadcast(10, "Resuming from byte " + selectObject.offset + "...");
                }
                z = false;
            } catch (IOException e2) {
                loge("Error while reading firmware stream", e2);
                this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_FILE_IO_EXCEPTION);
                return;
            }
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (selectObject.offset < this.mImageSizeInBytes) {
            int r5 = 1;
            while (this.mProgressInfo.getAvailableObjectSizeIsBytes() > 0) {
                if (!z) {
                    int availableObjectSizeIsBytes = this.mProgressInfo.getAvailableObjectSizeIsBytes();
                    StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Creating Data object (Op Code = 1, Type = 2, Size = ", availableObjectSizeIsBytes, ") (");
                    int r152 = r16 + 1;
                    m.append(r152);
                    boolean z3 = z;
                    m.append("/");
                    m.append(r14);
                    m.append(str);
                    logi(m.toString());
                    writeCreateRequest(2, availableObjectSizeIsBytes);
                    str2 = str;
                    this.mService.sendLogBroadcast(10, ExecutorsRegistrar$$ExternalSyntheticLambda8.m("Data object (", r152, "/", r14, ") created"));
                    long j = this.prepareObjectDelay;
                    if (j > 0 || r14 == 0) {
                        DfuBaseService dfuBaseService = this.mService;
                        if (j <= 0) {
                            j = 400;
                        }
                        dfuBaseService.waitFor(j);
                    }
                    this.mService.sendLogBroadcast(10, "Uploading firmware...");
                    z2 = z3;
                } else {
                    str2 = str;
                    this.mService.sendLogBroadcast(10, "Resuming uploading firmware...");
                    z2 = false;
                }
                try {
                    logi("Uploading firmware...");
                    uploadFirmwareImage(this.mPacketCharacteristic);
                    logi("Sending Calculate Checksum command (Op Code = 3)");
                    ObjectChecksum readChecksum = readChecksum();
                    Locale locale2 = Locale.US;
                    logi(String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(readChecksum.offset), Integer.valueOf(readChecksum.CRC32)));
                    boolean z4 = z2;
                    this.mService.sendLogBroadcast(10, String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(readChecksum.offset), Integer.valueOf(readChecksum.CRC32)));
                    int bytesSent = this.mProgressInfo.getBytesSent() - readChecksum.offset;
                    if (bytesSent > 0) {
                        logw(bytesSent + " bytes were lost!");
                        this.mService.sendLogBroadcast(15, bytesSent + " bytes were lost");
                        try {
                            this.mFirmwareStream.reset();
                            this.mFirmwareStream.read(new byte[selectObject.maxSize - bytesSent]);
                            this.mProgressInfo.setBytesSent(readChecksum.offset);
                            int r92 = this.mPacketsBeforeNotification;
                            if (r92 == 0 || r92 > 1) {
                                this.mPacketsBeforeNotification = 1;
                                setPacketReceiptNotifications(1);
                                this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 2) sent (Value = 1)");
                            }
                        } catch (IOException e3) {
                            loge("Error while reading firmware stream", e3);
                            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_FILE_IO_EXCEPTION);
                            return;
                        } catch (Throwable th) {
                            loge("Progress lost. Bytes sent: " + this.mProgressInfo.getBytesSent(), th);
                            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_PROGRESS_LOST);
                            return;
                        }
                    }
                    int crc32 = (int) (((ArchiveInputStream) this.mFirmwareStream).getCrc32() & 4294967295L);
                    if (crc32 == readChecksum.CRC32) {
                        if (bytesSent > 0) {
                            z = true;
                            str = str2;
                        } else {
                            logi("Executing data object (Op Code = 4)");
                            writeExecute(this.mProgressInfo.isComplete());
                            this.mService.sendLogBroadcast(10, "Data object executed");
                            r16++;
                            this.mFirmwareStream.mark(0);
                            r5 = 1;
                        }
                    } else {
                        String format = String.format(locale2, "CRC does not match! Expected %08X but found %08X.", Integer.valueOf(crc32), Integer.valueOf(readChecksum.CRC32));
                        if (r5 < 3) {
                            r5++;
                            StringBuilder m2 = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(format);
                            m2.append(String.format(locale2, " Retrying...(%d/%d)", Integer.valueOf(r5), 3));
                            String sb = m2.toString();
                            logi(sb);
                            this.mService.sendLogBroadcast(15, sb);
                            try {
                                this.mFirmwareStream.reset();
                                this.mProgressInfo.setBytesSent(((ArchiveInputStream) this.mFirmwareStream).getBytesRead());
                            } catch (IOException e4) {
                                loge("Error while resetting the firmware stream", e4);
                                this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_FILE_IO_EXCEPTION);
                                return;
                            }
                        } else {
                            loge(format);
                            this.mService.sendLogBroadcast(20, format);
                            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_CRC_ERROR);
                            return;
                        }
                    }
                    z = z4;
                    str = str2;
                } catch (DeviceDisconnectedException e5) {
                    loge("Disconnected while sending data");
                    throw e5;
                }
            }
        } else {
            logi("Executing data object (Op Code = 4)");
            writeExecute(true);
            this.mService.sendLogBroadcast(10, "Data object executed");
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        StringBuilder sb2 = new StringBuilder("Transfer of ");
        sb2.append(this.mProgressInfo.getBytesSent() - selectObject.offset);
        sb2.append(" bytes has taken ");
        long j2 = elapsedRealtime2 - elapsedRealtime;
        sb2.append(j2);
        sb2.append(" ms");
        logi(sb2.toString());
        this.mService.sendLogBroadcast(10, "Upload completed in " + j2 + " ms");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void sendInitPacket(android.bluetooth.BluetoothGatt r17, boolean r18) throws no.nordicsemi.android.dfu.internal.exception.RemoteDfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.UnknownResponseException {
        /*
            Method dump skipped, instructions count: 535
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.SecureDfuImpl.sendInitPacket(android.bluetooth.BluetoothGatt, boolean):void");
    }

    private void setNumberOfPackets(byte[] bArr, int r4) {
        bArr[1] = (byte) (r4 & 255);
        bArr[2] = (byte) ((r4 >> 8) & 255);
    }

    private void setObjectSize(byte[] bArr, int r4) {
        bArr[2] = (byte) (r4 & 255);
        bArr[3] = (byte) ((r4 >> 8) & 255);
        bArr[4] = (byte) ((r4 >> 16) & 255);
        bArr[5] = (byte) ((r4 >> 24) & 255);
    }

    private void setPacketReceiptNotifications(int r4) throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        if (this.mConnected) {
            logi(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Sending the number of packets before notifications (Op Code = 2, Value = ", r4, ")"));
            byte[] bArr = OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
            setNumberOfPackets(bArr, r4);
            writeOpCode(this.mControlPointCharacteristic, bArr);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 2);
            if (statusCode != 11) {
                if (statusCode == 1) {
                    return;
                } else {
                    throw new RemoteDfuException("Sending the number of packets failed", statusCode);
                }
            }
            throw new RemoteDfuExtendedErrorException("Sending the number of packets failed", readNotificationResponse[3]);
        }
        throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
    }

    private int unsignedBytesToInt(byte[] bArr, int r4) {
        return (bArr[r4] & 255) + ((bArr[r4 + 1] & 255) << 8) + ((bArr[r4 + 2] & 255) << 16) + ((bArr[r4 + 3] & 255) << 24);
    }

    private void writeCreateRequest(int r4, int r5) throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        byte[] bArr;
        if (this.mConnected) {
            if (r4 == 1) {
                bArr = OP_CODE_CREATE_COMMAND;
            } else {
                bArr = OP_CODE_CREATE_DATA;
            }
            setObjectSize(bArr, r5);
            writeOpCode(this.mControlPointCharacteristic, bArr);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 1);
            if (statusCode != 11) {
                if (statusCode == 1) {
                    return;
                } else {
                    throw new RemoteDfuException("Creating Command object failed", statusCode);
                }
            }
            throw new RemoteDfuExtendedErrorException("Creating Command object failed", readNotificationResponse[3]);
        }
        throw new DeviceDisconnectedException("Unable to create object: device disconnected");
    }

    private void writeExecute() throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        if (this.mConnected) {
            writeOpCode(this.mControlPointCharacteristic, OP_CODE_EXECUTE);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 4);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Executing object failed", readNotificationResponse[3]);
            }
            if (statusCode != 1) {
                throw new RemoteDfuException("Executing object failed", statusCode);
            }
            return;
        }
        throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
    }

    private void writeOpCode(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        writeOpCode(bluetoothGattCharacteristic, bArr, false);
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

    @Override // no.nordicsemi.android.dfu.BaseDfuImpl, no.nordicsemi.android.dfu.DfuService
    public boolean initialize(Intent intent, BluetoothGatt bluetoothGatt, int r3, InputStream inputStream, InputStream inputStream2) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        if (inputStream2 == null) {
            this.mService.sendLogBroadcast(20, "The Init packet is required by this version DFU Bootloader");
            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_INIT_PACKET_REQUIRED);
            return false;
        }
        return super.initialize(intent, bluetoothGatt, r3, inputStream, inputStream2);
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

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:            logi("Resume feature disabled. Performing fresh DFU");     */
    @Override // no.nordicsemi.android.dfu.DfuService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void performDfu(android.content.Intent r8) throws no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.SecureDfuImpl.performDfu(android.content.Intent):void");
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseDfuImpl.BaseBluetoothGattCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    private void writeExecute(boolean z) throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        try {
            writeExecute();
        } catch (RemoteDfuException e) {
            if (z && e.getErrorNumber() == 5) {
                logw(e.getMessage() + ": " + SecureDfuError.parse(517));
                if (this.mFileType == 1) {
                    logw("Are you sure your new SoftDevice is API compatible with the updated one? If not, update the bootloader as well");
                }
                this.mService.sendLogBroadcast(15, String.format(Locale.US, "Remote DFU error: %s. SD busy? Retrying...", SecureDfuError.parse(517)));
                logi("SD busy? Retrying...");
                logi("Executing data object (Op Code = 4)");
                writeExecute();
                return;
            }
            throw e;
        }
    }
}
