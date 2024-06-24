package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.ValidatingOffsetMapping$$ExternalSyntheticOutline0;
import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuCallback;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScannerFactory;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"MissingPermission"})
/* loaded from: classes4.dex */
public abstract class BaseDfuImpl implements DfuService {
    static final int INDICATIONS = 2;
    private static final int MAX_PACKET_SIZE_DEFAULT = 20;
    static final int NOTIFICATIONS = 1;
    private static final String TAG = "DfuImpl";
    boolean mAborted;
    private int mCurrentMtu;
    int mError;
    int mFileType;
    InputStream mFirmwareStream;
    BluetoothGatt mGatt;
    int mImageSizeInBytes;
    int mInitPacketSizeInBytes;
    InputStream mInitPacketStream;
    boolean mPaused;
    DfuProgressInfo mProgressInfo;
    boolean mRequestCompleted;
    boolean mResetRequestSent;
    DfuBaseService mService;
    static final UUID GENERIC_ATTRIBUTE_SERVICE_UUID = new UUID(26392574038016L, -9223371485494954757L);
    static final UUID SERVICE_CHANGED_UUID = new UUID(46200963207168L, -9223371485494954757L);
    static final UUID CLIENT_CHARACTERISTIC_CONFIG = new UUID(45088566677504L, -9223371485494954757L);
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    final Object mLock = new Object();
    byte[] mReceivedData = null;
    byte[] mBuffer = new byte[20];
    boolean mConnected = true;

    /* loaded from: classes4.dex */
    public class BaseBluetoothGattCallback extends DfuCallback.DfuGattCallback {
        public BaseBluetoothGattCallback() {
        }

        private String phyToString(int r3) {
            if (r3 != 1) {
                if (r3 != 2) {
                    if (r3 != 3) {
                        return ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("UNKNOWN (", r3, ")");
                    }
                    return "LE Coded";
                }
                return "LE 2M";
            }
            return "LE 1M";
        }

        public int getInt(byte[] bArr, int r4) {
            return ((bArr[r4 + 3] & 255) << 24) | (bArr[r4] & 255) | ((bArr[r4 + 1] & 255) << 8) | ((bArr[r4 + 2] & 255) << 16);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int r5) {
            if (r5 == 0) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "Read Response received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                baseDfuImpl.mReceivedData = bArr;
                baseDfuImpl.mRequestCompleted = true;
            } else {
                BaseDfuImpl.this.loge(SubMenuBuilder$$ExternalSyntheticOutline0.m("Characteristic read error: ", r5));
                BaseDfuImpl.this.mError = r5 | DfuBaseService.ERROR_CONNECTION_MASK;
            }
            BaseDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int r4, byte[] bArr) {
            if (r4 == 0) {
                UUID uuid = bluetoothGattDescriptor.getUuid();
                UUID uuid2 = bluetoothGattDescriptor.getCharacteristic().getUuid();
                BaseDfuImpl.this.mReceivedData = bArr;
                if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(uuid)) {
                    BaseDfuImpl.this.mService.sendLogBroadcast(5, "Read Response received from descr." + uuid2 + ", value (0x): " + parse(bArr));
                    if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(uuid2)) {
                        BaseDfuImpl.this.mRequestCompleted = true;
                    } else {
                        BaseDfuImpl.this.loge("Unknown descriptor read");
                    }
                }
            } else {
                BaseDfuImpl.this.loge(SubMenuBuilder$$ExternalSyntheticOutline0.m("Descriptor read error: ", r4));
                BaseDfuImpl.this.mError = r4 | DfuBaseService.ERROR_CONNECTION_MASK;
            }
            BaseDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int r5) {
            if (r5 == 0) {
                UUID uuid = bluetoothGattDescriptor.getUuid();
                UUID uuid2 = bluetoothGattDescriptor.getCharacteristic().getUuid();
                if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(uuid)) {
                    BaseDfuImpl.this.mService.sendLogBroadcast(5, "Data written to descr." + uuid2);
                    if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(uuid2)) {
                        BaseDfuImpl.this.mService.sendLogBroadcast(1, "Indications enabled for " + uuid2);
                    } else {
                        BaseDfuImpl.this.mService.sendLogBroadcast(1, "Notifications enabled for " + uuid2);
                    }
                }
                BaseDfuImpl.this.mRequestCompleted = true;
            } else {
                BaseDfuImpl.this.loge(SubMenuBuilder$$ExternalSyntheticOutline0.m("Descriptor write error: ", r5));
                BaseDfuImpl.this.mError = r5 | DfuBaseService.ERROR_CONNECTION_MASK;
            }
            BaseDfuImpl.this.notifyLock();
        }

        @Override // no.nordicsemi.android.dfu.DfuCallback.DfuGattCallback
        public void onDisconnected() {
            BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
            baseDfuImpl.mConnected = false;
            baseDfuImpl.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int r5, int r6) {
            if (r6 == 0) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "MTU changed to: " + r5);
                int r4 = r5 + (-3);
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                if (r4 > baseDfuImpl.mBuffer.length) {
                    baseDfuImpl.mBuffer = new byte[r4];
                }
                baseDfuImpl.logi(SubMenuBuilder$$ExternalSyntheticOutline0.m("MTU changed to: ", r5));
            } else {
                BaseDfuImpl.this.logw(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("Changing MTU failed: ", r6, " (mtu: ", r5, ")"));
                if (r6 == 4 && BaseDfuImpl.this.mCurrentMtu > 23) {
                    int r42 = BaseDfuImpl.this.mCurrentMtu - 3;
                    BaseDfuImpl baseDfuImpl2 = BaseDfuImpl.this;
                    if (r42 > baseDfuImpl2.mBuffer.length) {
                        baseDfuImpl2.mBuffer = new byte[baseDfuImpl2.mCurrentMtu - 3];
                        BaseDfuImpl.this.logi("MTU restored to: " + BaseDfuImpl.this.mCurrentMtu);
                    }
                }
            }
            BaseDfuImpl baseDfuImpl3 = BaseDfuImpl.this;
            baseDfuImpl3.mRequestCompleted = true;
            baseDfuImpl3.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int r6, int r7, int r8) {
            if (r8 == 0) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "PHY updated (TX: " + phyToString(r6) + ", RX: " + phyToString(r7) + ")");
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                StringBuilder sb = new StringBuilder("PHY updated (TX: ");
                sb.append(phyToString(r6));
                sb.append(", RX: ");
                baseDfuImpl.logi(ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, phyToString(r7), ")"));
                return;
            }
            BaseDfuImpl.this.logw(ConstraintWidget$$ExternalSyntheticOutline0.m(ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("Updating PHY failed: ", r8, " (txPhy: ", r6, ", rxPhy: "), r7, ")"));
        }

        public String parse(byte[] bArr) {
            int length;
            if (bArr == null || (length = bArr.length) == 0) {
                return "";
            }
            char[] cArr = new char[(length * 3) - 1];
            for (int r2 = 0; r2 < length; r2++) {
                int r3 = bArr[r2] & 255;
                int r4 = r2 * 3;
                cArr[r4] = BaseDfuImpl.HEX_ARRAY[r3 >>> 4];
                cArr[r4 + 1] = BaseDfuImpl.HEX_ARRAY[r3 & 15];
                if (r2 != length - 1) {
                    cArr[r4 + 2] = '-';
                }
            }
            return new String(cArr);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int r4) {
            onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue(), r4);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int r4) {
            onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, r4, bluetoothGattDescriptor.getValue());
        }
    }

    public BaseDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        this.mService = dfuBaseService;
        this.mProgressInfo = dfuBaseService.mProgressInfo;
    }

    private boolean createBondApi18(BluetoothDevice bluetoothDevice) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("createBond", new Class[0]);
            this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond() (hidden)");
            return ((Boolean) method.invoke(bluetoothDevice, new Object[0])).booleanValue();
        } catch (Exception e) {
            Log.w(TAG, "An exception occurred while creating bond", e);
            return false;
        }
    }

    private boolean isServiceChangedCCCDEnabled() throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattDescriptor descriptor;
        if (this.mConnected) {
            if (!this.mAborted) {
                BluetoothGatt bluetoothGatt = this.mGatt;
                BluetoothGattService service = bluetoothGatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID);
                if (service == null || (characteristic = service.getCharacteristic(SERVICE_CHANGED_UUID)) == null || (descriptor = characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG)) == null) {
                    return false;
                }
                this.mRequestCompleted = false;
                this.mReceivedData = null;
                this.mError = 0;
                logi("Reading Service Changed CCCD value...");
                this.mService.sendLogBroadcast(1, "Reading Service Changed CCCD value...");
                this.mService.sendLogBroadcast(0, "gatt.readDescriptor(" + descriptor.getUuid() + ")");
                bluetoothGatt.readDescriptor(descriptor);
                try {
                    synchronized (this.mLock) {
                        while (true) {
                            if ((this.mRequestCompleted || !this.mConnected || this.mError != 0) && !this.mPaused) {
                                break;
                            }
                            this.mLock.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    loge("Sleeping interrupted", e);
                }
                if (this.mConnected) {
                    if (this.mError == 0) {
                        byte[] bArr = this.mReceivedData;
                        if (bArr == null || bArr.length != 2) {
                            return false;
                        }
                        byte b = bArr[0];
                        byte[] bArr2 = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
                        if (b != bArr2[0] || bArr[1] != bArr2[1]) {
                            return false;
                        }
                        return true;
                    }
                    throw new DfuException("Unable to read Service Changed CCCD", this.mError);
                }
                throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
            }
            throw new UploadAbortedException();
        }
        throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void abort() {
        this.mPaused = false;
        this.mAborted = true;
        notifyLock();
    }

    public boolean createBond() {
        BluetoothDevice device = this.mGatt.getDevice();
        this.mRequestCompleted = false;
        this.mService.sendLogBroadcast(1, "Starting pairing...");
        this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond()");
        boolean createBond = device.createBond();
        try {
            synchronized (this.mLock) {
                while (createBond) {
                    if (this.mRequestCompleted || this.mAborted) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        return createBond;
    }

    public void enableCCCD(BluetoothGattCharacteristic bluetoothGattCharacteristic, int r10) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        String str;
        String str2;
        byte[] bArr;
        byte[] bArr2;
        BluetoothGatt bluetoothGatt = this.mGatt;
        if (r10 == 1) {
            str = "notifications";
        } else {
            str = "indications";
        }
        if (this.mConnected) {
            if (!this.mAborted) {
                this.mRequestCompleted = false;
                this.mReceivedData = null;
                this.mError = 0;
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG);
                logi(zzav$$ExternalSyntheticOutline0.m("Enabling ", str, "..."));
                DfuBaseService dfuBaseService = this.mService;
                StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Enabling ", str, " for ");
                m.append(bluetoothGattCharacteristic.getUuid());
                dfuBaseService.sendLogBroadcast(1, m.toString());
                this.mService.sendLogBroadcast(0, "gatt.setCharacteristicNotification(" + bluetoothGattCharacteristic.getUuid() + ", true)");
                bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
                DfuBaseService dfuBaseService2 = this.mService;
                StringBuilder sb = new StringBuilder("gatt.writeDescriptor(");
                sb.append(descriptor.getUuid());
                if (r10 == 1) {
                    str2 = ", value=0x01-00)";
                } else {
                    str2 = ", value=0x02-00)";
                }
                sb.append(str2);
                dfuBaseService2.sendLogBroadcast(0, sb.toString());
                if (Build.VERSION.SDK_INT >= 33) {
                    if (r10 == 1) {
                        bArr2 = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
                    } else {
                        bArr2 = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
                    }
                    bluetoothGatt.writeDescriptor(descriptor, bArr2);
                } else {
                    if (r10 == 1) {
                        bArr = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
                    } else {
                        bArr = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
                    }
                    descriptor.setValue(bArr);
                    bluetoothGatt.writeDescriptor(descriptor);
                }
                try {
                    synchronized (this.mLock) {
                        while (true) {
                            if ((this.mRequestCompleted || !this.mConnected || this.mError != 0) && !this.mPaused) {
                                break;
                            } else {
                                this.mLock.wait();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    loge("Sleeping interrupted", e);
                }
                if (this.mConnected) {
                    if (this.mError == 0) {
                        return;
                    } else {
                        throw new DfuException(zzav$$ExternalSyntheticOutline0.m("Unable to set ", str, " state"), this.mError);
                    }
                }
                throw new DeviceDisconnectedException(zzav$$ExternalSyntheticOutline0.m("Unable to set ", str, " state: device disconnected"));
            }
            throw new UploadAbortedException();
        }
        throw new DeviceDisconnectedException(zzav$$ExternalSyntheticOutline0.m("Unable to set ", str, " state: device disconnected"));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(1:3)|(1:5)|6|(12:32|33|(1:35)|36|9|10|11|(2:13|(1:15)(1:16))|17|18|(3:24|(1:26)|27)|28)|8|9|10|11|(0)|17|18|(5:20|22|24|(0)|27)|28) */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062 A[Catch: Exception -> 0x0074, TryCatch #1 {Exception -> 0x0074, blocks: (B:11:0x005c, B:13:0x0062, B:15:0x0066, B:16:0x006d, B:17:0x0070), top: B:10:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    @Override // no.nordicsemi.android.dfu.DfuService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean initialize(android.content.Intent r6, android.bluetooth.BluetoothGatt r7, int r8, java.io.InputStream r9, java.io.InputStream r10) throws no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r5 = this;
            r5.mGatt = r7
            r5.mFileType = r8
            r5.mFirmwareStream = r9
            r5.mInitPacketStream = r10
            java.lang.String r0 = "no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT"
            r1 = 1
            int r0 = r6.getIntExtra(r0, r1)
            java.lang.String r2 = "no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL"
            int r2 = r6.getIntExtra(r2, r1)
            java.lang.String r3 = "no.nordicsemi.android.dfu.extra.EXTRA_CURRENT_MTU"
            r4 = 23
            int r6 = r6.getIntExtra(r3, r4)
            r5.mCurrentMtu = r6
            r6 = 4
            r3 = 15
            r4 = 2
            if (r8 <= r6) goto L3f
            java.lang.String r6 = "DFU target does not support (SD/BL)+App update, splitting into 2 parts"
            r5.logw(r6)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r5.mService
            java.lang.String r8 = "Sending system components"
            r6.sendLogBroadcast(r3, r8)
            int r6 = r5.mFileType
            r6 = r6 & (-5)
            r5.mFileType = r6
            java.io.InputStream r8 = r5.mFirmwareStream
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r8 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r8
            r8.setContentType(r6)
            r2 = r4
        L3f:
            if (r0 != r4) goto L48
            no.nordicsemi.android.dfu.DfuBaseService r6 = r5.mService
            java.lang.String r8 = "Sending application"
            r6.sendLogBroadcast(r3, r8)
        L48:
            r6 = 0
            if (r10 == 0) goto L59
            boolean r8 = r10.markSupported()     // Catch: java.lang.Exception -> L59
            if (r8 == 0) goto L54
            r10.reset()     // Catch: java.lang.Exception -> L59
        L54:
            int r8 = r10.available()     // Catch: java.lang.Exception -> L59
            goto L5a
        L59:
            r8 = r6
        L5a:
            r5.mInitPacketSizeInBytes = r8
            boolean r8 = r9.markSupported()     // Catch: java.lang.Exception -> L74
            if (r8 == 0) goto L70
            boolean r8 = r9 instanceof no.nordicsemi.android.dfu.internal.ArchiveInputStream     // Catch: java.lang.Exception -> L74
            if (r8 == 0) goto L6d
            r8 = r9
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r8 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r8     // Catch: java.lang.Exception -> L74
            r8.fullReset()     // Catch: java.lang.Exception -> L74
            goto L70
        L6d:
            r9.reset()     // Catch: java.lang.Exception -> L74
        L70:
            int r6 = r9.available()     // Catch: java.lang.Exception -> L74
        L74:
            r5.mImageSizeInBytes = r6
            no.nordicsemi.android.dfu.DfuProgressInfo r8 = r5.mProgressInfo
            r8.init(r6, r0, r2)
            android.bluetooth.BluetoothDevice r6 = r7.getDevice()
            int r6 = r6.getBondState()
            r8 = 12
            if (r6 != r8) goto Lac
            java.util.UUID r6 = no.nordicsemi.android.dfu.BaseDfuImpl.GENERIC_ATTRIBUTE_SERVICE_UUID
            android.bluetooth.BluetoothGattService r6 = r7.getService(r6)
            if (r6 == 0) goto Lac
            java.util.UUID r7 = no.nordicsemi.android.dfu.BaseDfuImpl.SERVICE_CHANGED_UUID
            android.bluetooth.BluetoothGattCharacteristic r6 = r6.getCharacteristic(r7)
            if (r6 == 0) goto Lac
            boolean r7 = r5.isServiceChangedCCCDEnabled()
            if (r7 != 0) goto La0
            r5.enableCCCD(r6, r4)
        La0:
            java.lang.String r6 = "Service Changed indications enabled"
            r5.logi(r6)
            no.nordicsemi.android.dfu.DfuBaseService r7 = r5.mService
            r8 = 10
            r7.sendLogBroadcast(r8, r6)
        Lac:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.BaseDfuImpl.initialize(android.content.Intent, android.bluetooth.BluetoothGatt, int, java.io.InputStream, java.io.InputStream):boolean");
    }

    public boolean isBonded() {
        if (this.mGatt.getDevice().getBondState() == 12) {
            return true;
        }
        return false;
    }

    public void loge(String str) {
        Log.e(TAG, str);
    }

    public void logi(String str) {
        if (DfuBaseService.DEBUG) {
            Log.i(TAG, str);
        }
    }

    public void logw(String str) {
        if (DfuBaseService.DEBUG) {
            Log.w(TAG, str);
        }
    }

    public void notifyLock() {
        synchronized (this.mLock) {
            this.mLock.notifyAll();
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public void onBondStateChanged(int r1) {
        this.mRequestCompleted = true;
        notifyLock();
    }

    public String parse(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) == 0) {
            return "";
        }
        char[] cArr = new char[(length * 3) - 1];
        for (int r2 = 0; r2 < length; r2++) {
            int r3 = bArr[r2] & 255;
            int r4 = r2 * 3;
            char[] cArr2 = HEX_ARRAY;
            cArr[r4] = cArr2[r3 >>> 4];
            cArr[r4 + 1] = cArr2[r3 & 15];
            if (r2 != length - 1) {
                cArr[r4 + 2] = '-';
            }
        }
        return new String(cArr);
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void pause() {
        this.mPaused = true;
    }

    public byte[] readNotificationResponse() throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mReceivedData != null || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mAborted) {
            if (this.mConnected) {
                if (this.mError == 0) {
                    return this.mReceivedData;
                }
                throw new DfuException("Unable to write Op Code", this.mError);
            }
            throw new DeviceDisconnectedException("Unable to write Op Code: device disconnected");
        }
        throw new UploadAbortedException();
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public void release() {
        this.mService = null;
    }

    public boolean removeBond() {
        BluetoothDevice device = this.mGatt.getDevice();
        if (device.getBondState() == 10) {
            return true;
        }
        this.mService.sendLogBroadcast(1, "Removing bond information...");
        boolean z = false;
        try {
            Method method = device.getClass().getMethod("removeBond", new Class[0]);
            this.mRequestCompleted = false;
            this.mService.sendLogBroadcast(0, "gatt.getDevice().removeBond() (hidden)");
            z = ((Boolean) method.invoke(device, new Object[0])).booleanValue();
            try {
                synchronized (this.mLock) {
                    while (!this.mRequestCompleted && !this.mAborted) {
                        this.mLock.wait();
                    }
                }
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
        } catch (Exception e2) {
            Log.w(TAG, "An exception occurred while removing bond information", e2);
        }
        return z;
    }

    public void requestMtu(int r5) throws DeviceDisconnectedException, UploadAbortedException {
        if (Build.HARDWARE.equals("ums512_25c10")) {
            if (r5 == 516) {
                logw("MTU request forced");
            } else {
                logw("MTU request disabled for this device. See https://github.com/NordicSemiconductor/Android-DFU-Library/issues/339");
                return;
            }
        }
        if (!this.mAborted) {
            this.mRequestCompleted = false;
            this.mService.sendLogBroadcast(1, "Requesting new MTU...");
            this.mService.sendLogBroadcast(0, "gatt.requestMtu(" + r5 + ")");
            if (!this.mGatt.requestMtu(r5)) {
                return;
            }
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if ((this.mRequestCompleted || !this.mConnected || this.mError != 0) && !this.mPaused) {
                            break;
                        } else {
                            this.mLock.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
            if (this.mConnected) {
                return;
            } else {
                throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
            }
        }
        throw new UploadAbortedException();
    }

    public void restartService(Intent intent, boolean z) {
        String str;
        if (z) {
            long longExtra = intent.getLongExtra(DfuBaseService.EXTRA_SCAN_DELAY, 0L);
            long longExtra2 = intent.getLongExtra(DfuBaseService.EXTRA_SCAN_TIMEOUT, DfuServiceInitiator.DEFAULT_SCAN_TIMEOUT);
            this.mService.sendLogBroadcast(1, "Scanning for the DFU Bootloader... (timeout " + longExtra2 + " ms)");
            if (longExtra > 0) {
                this.mService.waitFor(longExtra);
            }
            str = BootloaderScannerFactory.getScanner(this.mGatt.getDevice().getAddress()).searchUsing(this.mService.getDeviceSelector(), longExtra2);
            logi(ConstraintSet$$ExternalSyntheticOutline0.m("Scanning for new address finished with: ", str));
            if (str != null) {
                this.mService.sendLogBroadcast(5, "DFU Bootloader found with address ".concat(str));
            } else {
                this.mService.sendLogBroadcast(5, "DFU Bootloader not found. Trying the same address...");
            }
        } else {
            str = null;
        }
        if (str != null) {
            intent.putExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS, str);
        }
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DFU_ATTEMPT", 0);
        this.mService.startService(intent);
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void resume() {
        this.mPaused = false;
        notifyLock();
    }

    public void waitIfPaused() {
        try {
            synchronized (this.mLock) {
                while (this.mPaused) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
    }

    public void writeOpCode(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, boolean z) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (!this.mAborted) {
            this.mReceivedData = null;
            this.mError = 0;
            this.mRequestCompleted = false;
            this.mResetRequestSent = z;
            this.mService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
            if (Build.VERSION.SDK_INT >= 33) {
                this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ", value=0x" + parse(bArr) + ", WRITE_TYPE_DEFAULT)");
                this.mGatt.writeCharacteristic(bluetoothGattCharacteristic, bArr, 2);
            } else {
                bluetoothGattCharacteristic.setWriteType(2);
                bluetoothGattCharacteristic.setValue(bArr);
                this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
                this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
            }
            try {
                synchronized (this.mLock) {
                    while (true) {
                        if ((this.mRequestCompleted || !this.mConnected || this.mError != 0) && !this.mPaused) {
                            break;
                        } else {
                            this.mLock.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
            boolean z2 = this.mResetRequestSent;
            if (!z2 && !this.mConnected) {
                throw new DeviceDisconnectedException(ConstraintWidget$$ExternalSyntheticOutline0.m(new StringBuilder("Unable to write Op Code "), bArr[0], ": device disconnected"));
            }
            if (!z2 && this.mError != 0) {
                throw new DfuException("Unable to write Op Code " + ((int) bArr[0]), this.mError);
            }
            return;
        }
        throw new UploadAbortedException();
    }

    public void loge(String str, Throwable th) {
        Log.e(TAG, str, th);
    }
}
