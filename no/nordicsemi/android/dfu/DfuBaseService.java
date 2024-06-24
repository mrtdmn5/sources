package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.watch.image.Kolors;
import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import no.nordicsemi.android.dfu.DfuProgressInfo;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.HexInputStream;

@SuppressLint({"MissingPermission"})
/* loaded from: classes4.dex */
public abstract class DfuBaseService extends IntentService implements DfuProgressInfo.ProgressListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ACTION_ABORT = 2;
    public static final int ACTION_PAUSE = 0;
    public static final int ACTION_RESUME = 1;
    public static final String BROADCAST_ACTION = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION";
    public static final String BROADCAST_ERROR = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR";
    public static final String BROADCAST_LOG = "no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG";
    public static final String BROADCAST_PROGRESS = "no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS";
    static boolean DEBUG = false;
    public static final int ERROR_BLUETOOTH_DISABLED = 4106;
    public static final int ERROR_CONNECTION_MASK = 16384;
    public static final int ERROR_CONNECTION_STATE_MASK = 32768;
    public static final int ERROR_CRC_ERROR = 4109;
    public static final int ERROR_DEVICE_DISCONNECTED = 4096;
    public static final int ERROR_DEVICE_NOT_BONDED = 4110;
    public static final int ERROR_FILE_ERROR = 4098;
    public static final int ERROR_FILE_INVALID = 4099;
    public static final int ERROR_FILE_IO_EXCEPTION = 4100;
    public static final int ERROR_FILE_NOT_FOUND = 4097;
    public static final int ERROR_FILE_SIZE_INVALID = 4108;
    public static final int ERROR_FILE_TYPE_UNSUPPORTED = 4105;
    public static final int ERROR_INIT_PACKET_REQUIRED = 4107;
    public static final int ERROR_INVALID_RESPONSE = 4104;
    public static final int ERROR_MASK = 4096;
    public static final int ERROR_PROGRESS_LOST = 4111;
    public static final int ERROR_REMOTE_MASK = 8192;
    public static final int ERROR_REMOTE_TYPE_LEGACY = 256;
    public static final int ERROR_REMOTE_TYPE_SECURE = 512;
    public static final int ERROR_REMOTE_TYPE_SECURE_BUTTONLESS = 2048;
    public static final int ERROR_REMOTE_TYPE_SECURE_EXTENDED = 1024;
    public static final int ERROR_SERVICE_DISCOVERY_NOT_STARTED = 4101;
    public static final int ERROR_SERVICE_NOT_FOUND = 4102;
    public static final int ERROR_TYPE_COMMUNICATION = 2;
    public static final int ERROR_TYPE_COMMUNICATION_STATE = 1;
    public static final int ERROR_TYPE_DFU_REMOTE = 3;
    public static final int ERROR_TYPE_OTHER = 0;
    public static final String EXTRA_ACTION = "no.nordicsemi.android.dfu.extra.EXTRA_ACTION";
    public static final String EXTRA_AVG_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_AVG_SPEED_B_PER_MS";
    public static final String EXTRA_CURRENT_MTU = "no.nordicsemi.android.dfu.extra.EXTRA_CURRENT_MTU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU";
    public static final String EXTRA_DATA = "no.nordicsemi.android.dfu.extra.EXTRA_DATA";
    public static final String EXTRA_DATA_OBJECT_DELAY = "no.nordicsemi.android.dfu.extra.EXTRA_DATA_OBJECT_DELAY";
    public static final String EXTRA_DEVICE_ADDRESS = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS";
    public static final String EXTRA_DEVICE_NAME = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME";
    static final String EXTRA_DFU_ATTEMPT = "no.nordicsemi.android.dfu.extra.EXTRA_DFU_ATTEMPT";
    public static final String EXTRA_DISABLE_NOTIFICATION = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_NOTIFICATION";
    public static final String EXTRA_DISABLE_RESUME = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_RESUME";
    public static final String EXTRA_ERROR_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE";
    public static final String EXTRA_FILE_MIME_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE";
    public static final String EXTRA_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH";
    public static final String EXTRA_FILE_RES_ID = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_RES_ID";
    public static final String EXTRA_FILE_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE";
    public static final String EXTRA_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_URI";
    public static final String EXTRA_FORCE_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_FORCE_DFU";
    public static final String EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU";
    public static final String EXTRA_FOREGROUND_SERVICE = "no.nordicsemi.android.dfu.extra.EXTRA_FOREGROUND_SERVICE";
    public static final String EXTRA_INIT_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_PATH";
    public static final String EXTRA_INIT_FILE_RES_ID = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_RES_ID";
    public static final String EXTRA_INIT_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_URI";
    public static final String EXTRA_KEEP_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND";
    public static final String EXTRA_LOG_LEVEL = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_LEVEL";
    public static final String EXTRA_LOG_MESSAGE = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_INFO";
    public static final String EXTRA_MAX_DFU_ATTEMPTS = "no.nordicsemi.android.dfu.extra.EXTRA_MAX_DFU_ATTEMPTS";
    public static final String EXTRA_MBR_SIZE = "no.nordicsemi.android.dfu.extra.EXTRA_MBR_SIZE";
    public static final String EXTRA_MTU = "no.nordicsemi.android.dfu.extra.EXTRA_MTU";
    public static final String EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED = "no.nordicsemi.android.dfu.extra.EXTRA_PRN_ENABLED";
    public static final String EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE = "no.nordicsemi.android.dfu.extra.EXTRA_PRN_VALUE";
    public static final String EXTRA_PARTS_TOTAL = "no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL";
    public static final String EXTRA_PART_CURRENT = "no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT";
    public static final String EXTRA_PROGRESS = "no.nordicsemi.android.dfu.extra.EXTRA_PROGRESS";
    private static final String EXTRA_RECONNECTION_ATTEMPT = "no.nordicsemi.android.dfu.extra.EXTRA_RECONNECTION_ATTEMPT";
    public static final String EXTRA_RESTORE_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND";
    public static final String EXTRA_SCAN_DELAY = "no.nordicsemi.android.dfu.extra.EXTRA_SCAN_DELAY";
    public static final String EXTRA_SCAN_TIMEOUT = "no.nordicsemi.android.dfu.extra.EXTRA_SCAN_TIMEOUT";
    public static final String EXTRA_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_SPEED_B_PER_MS";
    public static final String EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU";
    public static final int LOG_LEVEL_APPLICATION = 10;
    public static final int LOG_LEVEL_DEBUG = 0;
    public static final int LOG_LEVEL_ERROR = 20;
    public static final int LOG_LEVEL_INFO = 5;
    public static final int LOG_LEVEL_VERBOSE = 1;
    public static final int LOG_LEVEL_WARNING = 15;
    public static final String MIME_TYPE_OCTET_STREAM = "application/octet-stream";
    public static final String MIME_TYPE_ZIP = "application/zip";
    public static final String NOTIFICATION_CHANNEL_DFU = "dfu";
    public static final int NOTIFICATION_ID = 283;
    public static final int PROGRESS_ABORTED = -7;
    public static final int PROGRESS_COMPLETED = -6;
    public static final int PROGRESS_CONNECTING = -1;
    public static final int PROGRESS_DISCONNECTING = -5;
    public static final int PROGRESS_ENABLING_DFU_MODE = -3;
    public static final int PROGRESS_STARTING = -2;
    public static final int PROGRESS_VALIDATING = -4;
    protected static final int STATE_CLOSED = -5;
    protected static final int STATE_CONNECTED = -2;
    protected static final int STATE_CONNECTED_AND_READY = -3;
    protected static final int STATE_CONNECTING = -1;
    protected static final int STATE_DISCONNECTED = 0;
    protected static final int STATE_DISCONNECTING = -4;
    private static final String TAG = "DfuBaseService";
    public static final int TYPE_APPLICATION = 4;
    public static final int TYPE_AUTO = 0;
    public static final int TYPE_BOOTLOADER = 2;
    public static final int TYPE_SOFT_DEVICE = 1;
    private boolean mAborted;
    private BluetoothAdapter mBluetoothAdapter;
    private final BroadcastReceiver mBluetoothStateBroadcastReceiver;
    private final BroadcastReceiver mBondStateBroadcastReceiver;
    protected int mConnectionState;
    private final BroadcastReceiver mConnectionStateBroadcastReceiver;
    private String mDeviceAddress;
    private String mDeviceName;
    private final BroadcastReceiver mDfuActionReceiver;
    private DfuCallback mDfuServiceImpl;
    private boolean mDisableNotification;
    private int mError;
    private InputStream mFirmwareInputStream;
    private final BluetoothGattCallback mGattCallback;
    private InputStream mInitFileInputStream;
    private long mLastNotificationTime;
    private int mLastProgress;
    private final Object mLock;
    DfuProgressInfo mProgressInfo;

    public DfuBaseService() {
        super(TAG);
        this.mLock = new Object();
        this.mLastProgress = -1;
        this.mDfuActionReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_ACTION, 0);
                DfuBaseService.this.logi("User action received: " + intExtra);
                if (intExtra != 0) {
                    if (intExtra != 1) {
                        if (intExtra == 2) {
                            DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Abort action received");
                            DfuBaseService.this.mAborted = true;
                            if (DfuBaseService.this.mDfuServiceImpl != null) {
                                DfuBaseService.this.mDfuServiceImpl.abort();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Resume action received");
                    if (DfuBaseService.this.mDfuServiceImpl != null) {
                        DfuBaseService.this.mDfuServiceImpl.resume();
                        return;
                    }
                    return;
                }
                DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Pause action received");
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.pause();
                }
            }
        };
        this.mBluetoothStateBroadcastReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 12);
                DfuBaseService.this.logw(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("Action received: android.bluetooth.adapter.action.STATE_CHANGED [state: ", intExtra, ", previous state: ", intExtra2, "]"));
                if (intExtra2 == 12) {
                    if (intExtra == 13 || intExtra == 10) {
                        DfuBaseService.this.sendLogBroadcast(15, "Bluetooth adapter disabled");
                        DfuBaseService dfuBaseService = DfuBaseService.this;
                        dfuBaseService.mConnectionState = 0;
                        if (dfuBaseService.mDfuServiceImpl != null) {
                            DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                        }
                        synchronized (DfuBaseService.this.mLock) {
                            DfuBaseService.this.mLock.notifyAll();
                        }
                    }
                }
            }
        };
        this.mBondStateBroadcastReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra;
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice != null && bluetoothDevice.getAddress().equals(DfuBaseService.this.mDeviceAddress) && (intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1)) != 11 && DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.onBondStateChanged(intExtra);
                }
            }
        };
        this.mConnectionStateBroadcastReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.4
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice != null && bluetoothDevice.getAddress().equals(DfuBaseService.this.mDeviceAddress)) {
                    String action = intent.getAction();
                    DfuBaseService.this.logi("Action received: " + action);
                    DfuBaseService.this.sendLogBroadcast(0, "[Broadcast] Action received: " + action);
                }
            }
        };
        this.mGattCallback = new BluetoothGattCallback() { // from class: no.nordicsemi.android.dfu.DfuBaseService.5
            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int r4) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, r4);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int r4) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, r4);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int r5, int r6) {
                String str;
                if (r5 == 0) {
                    if (r6 == 2) {
                        DfuBaseService.this.logi("Connected to GATT server");
                        DfuBaseService.this.sendLogBroadcast(5, "Connected to " + DfuBaseService.this.mDeviceAddress);
                        DfuBaseService.this.mConnectionState = -2;
                        if (bluetoothGatt.getDevice().getBondState() == 12) {
                            DfuBaseService.this.logi("Waiting 1600 ms for a possible Service Changed indication...");
                            DfuBaseService.this.waitFor(1600L);
                        }
                        DfuBaseService.this.sendLogBroadcast(1, "Discovering services...");
                        DfuBaseService.this.sendLogBroadcast(0, "gatt.discoverServices()");
                        boolean discoverServices = bluetoothGatt.discoverServices();
                        DfuBaseService dfuBaseService = DfuBaseService.this;
                        if (discoverServices) {
                            str = "succeed";
                        } else {
                            str = "failed";
                        }
                        dfuBaseService.logi("Attempting to start service discovery... ".concat(str));
                        if (!discoverServices) {
                            DfuBaseService.this.mError = DfuBaseService.ERROR_SERVICE_DISCOVERY_NOT_STARTED;
                        } else {
                            return;
                        }
                    } else if (r6 == 0) {
                        DfuBaseService.this.logi("Disconnected from GATT server");
                        DfuBaseService dfuBaseService2 = DfuBaseService.this;
                        dfuBaseService2.mConnectionState = 0;
                        if (dfuBaseService2.mDfuServiceImpl != null) {
                            DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                        }
                    }
                } else {
                    if (r5 != 8 && r5 != 19) {
                        DfuBaseService.this.loge("Connection state change error: " + r5 + " newState: " + r6);
                    } else {
                        DfuBaseService.this.logw("Target device disconnected with status: " + r5);
                    }
                    DfuBaseService.this.mError = r5 | DfuBaseService.ERROR_CONNECTION_STATE_MASK;
                    if (r6 == 0) {
                        DfuBaseService dfuBaseService3 = DfuBaseService.this;
                        dfuBaseService3.mConnectionState = 0;
                        if (dfuBaseService3.mDfuServiceImpl != null) {
                            DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                        }
                    }
                }
                synchronized (DfuBaseService.this.mLock) {
                    DfuBaseService.this.mLock.notifyAll();
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int r4) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, r4);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int r4) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, r4);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            @SuppressLint({"NewApi"})
            public void onMtuChanged(BluetoothGatt bluetoothGatt, int r3, int r4) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onMtuChanged(bluetoothGatt, r3, r4);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            @SuppressLint({"NewApi"})
            public void onPhyUpdate(BluetoothGatt bluetoothGatt, int r3, int r4, int r5) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onPhyUpdate(bluetoothGatt, r3, r4, r5);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int r4) {
                if (r4 == 0) {
                    DfuBaseService.this.logi("Services discovered");
                    DfuBaseService.this.mConnectionState = -3;
                } else {
                    DfuBaseService.this.loge("Service discovery error: " + r4);
                    DfuBaseService.this.mError = r4 | DfuBaseService.ERROR_CONNECTION_MASK;
                }
                synchronized (DfuBaseService.this.mLock) {
                    DfuBaseService.this.mLock.notifyAll();
                }
            }
        };
    }

    private boolean initialize() {
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
        if (bluetoothManager == null) {
            loge("Unable to initialize BluetoothManager.");
            return false;
        }
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter == null) {
            loge("Unable to obtain a BluetoothAdapter.");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loge(String str) {
        Log.e(TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logi(String str) {
        if (DEBUG) {
            Log.i(TAG, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logw(String str) {
        if (DEBUG) {
            Log.w(TAG, str);
        }
    }

    private static IntentFilter makeDfuActionIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION);
        return intentFilter;
    }

    private InputStream openInputStream(String str, String str2, int r5, int r6) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        if (MIME_TYPE_ZIP.equals(str2)) {
            return new ArchiveInputStream(fileInputStream, r5, r6);
        }
        return str.toLowerCase(Locale.US).endsWith("hex") ? new HexInputStream(fileInputStream, r5) : fileInputStream;
    }

    private void report(int r8) {
        sendErrorBroadcast(r8);
        if (this.mDisableNotification) {
            return;
        }
        String str = this.mDeviceAddress;
        String str2 = this.mDeviceName;
        if (str2 == null) {
            str2 = getString(R.string.dfu_unknown_name);
        }
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, NOTIFICATION_CHANNEL_DFU);
        Notification notification = notificationCompat$Builder.mNotification;
        notification.icon = android.R.drawable.stat_sys_upload;
        notificationCompat$Builder.setFlag(8, true);
        notificationCompat$Builder.mColor = Kolors.red;
        notificationCompat$Builder.setFlag(2, false);
        notificationCompat$Builder.setContentTitle(getString(R.string.dfu_status_error));
        notification.icon = android.R.drawable.stat_sys_upload_done;
        notificationCompat$Builder.setContentText(getString(R.string.dfu_status_error_msg));
        notificationCompat$Builder.setFlag(16, true);
        Intent intent = new Intent(this, getNotificationTarget());
        intent.addFlags(268435456);
        intent.putExtra(EXTRA_DEVICE_ADDRESS, str);
        intent.putExtra(EXTRA_DEVICE_NAME, str2);
        intent.putExtra(EXTRA_PROGRESS, r8);
        notificationCompat$Builder.mContentIntent = PendingIntent.getActivity(this, 0, intent, 201326592);
        updateErrorNotification(notificationCompat$Builder);
        NotificationManager notificationManager = (NotificationManager) getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, notificationCompat$Builder.build());
        }
    }

    private void sendErrorBroadcast(int r5) {
        Intent intent = new Intent(BROADCAST_ERROR);
        if ((r5 & ERROR_CONNECTION_MASK) > 0) {
            intent.putExtra(EXTRA_DATA, r5 & (-16385));
            intent.putExtra(EXTRA_ERROR_TYPE, 2);
        } else if ((32768 & r5) > 0) {
            intent.putExtra(EXTRA_DATA, r5 & (-32769));
            intent.putExtra(EXTRA_ERROR_TYPE, 1);
        } else if ((r5 & ERROR_REMOTE_MASK) > 0) {
            intent.putExtra(EXTRA_DATA, r5 & (-8193));
            intent.putExtra(EXTRA_ERROR_TYPE, 3);
        } else {
            intent.putExtra(EXTRA_DATA, r5);
            intent.putExtra(EXTRA_ERROR_TYPE, 0);
        }
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void sendProgressBroadcast(DfuProgressInfo dfuProgressInfo) {
        Intent intent = new Intent(BROADCAST_PROGRESS);
        intent.putExtra(EXTRA_DATA, dfuProgressInfo.getProgress());
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        intent.putExtra(EXTRA_PART_CURRENT, dfuProgressInfo.getCurrentPart());
        intent.putExtra(EXTRA_PARTS_TOTAL, dfuProgressInfo.getTotalParts());
        intent.putExtra(EXTRA_SPEED_B_PER_MS, dfuProgressInfo.getSpeed());
        intent.putExtra(EXTRA_AVG_SPEED_B_PER_MS, dfuProgressInfo.getAverageSpeed());
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void startForeground() {
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, NOTIFICATION_CHANNEL_DFU);
        notificationCompat$Builder.mNotification.icon = android.R.drawable.stat_sys_upload;
        notificationCompat$Builder.setContentTitle(getString(R.string.dfu_status_foreground_title));
        notificationCompat$Builder.setContentText(getString(R.string.dfu_status_foreground_content));
        notificationCompat$Builder.mColor = -7829368;
        notificationCompat$Builder.mPriority = -1;
        notificationCompat$Builder.setFlag(2, true);
        Class<? extends Activity> notificationTarget = getNotificationTarget();
        if (notificationTarget != null) {
            Intent intent = new Intent(this, notificationTarget);
            intent.addFlags(268435456);
            intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
            intent.putExtra(EXTRA_DEVICE_NAME, this.mDeviceName);
            notificationCompat$Builder.mContentIntent = PendingIntent.getActivity(this, 0, intent, 201326592);
        } else {
            logw("getNotificationTarget() should not return null if the service is to be started as a foreground service");
        }
        updateForegroundNotification(notificationCompat$Builder);
        startForeground(NOTIFICATION_ID, notificationCompat$Builder.build());
    }

    public void close(BluetoothGatt bluetoothGatt) {
        logi("Cleaning up...");
        sendLogBroadcast(0, "gatt.disconnect()");
        bluetoothGatt.disconnect();
        sendLogBroadcast(0, "gatt.close()");
        bluetoothGatt.close();
        this.mConnectionState = -5;
    }

    public BluetoothGatt connect(String str) {
        BluetoothGatt connectGatt;
        if (!this.mBluetoothAdapter.isEnabled()) {
            return null;
        }
        this.mConnectionState = -1;
        logi("Connecting to the device...");
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
        if (Build.VERSION.SDK_INT >= 26) {
            sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE, preferredPhy = LE_1M | LE_2M)");
            connectGatt = remoteDevice.connectGatt(this, false, this.mGattCallback, 2, 3);
        } else {
            sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE)");
            connectGatt = remoteDevice.connectGatt(this, false, this.mGattCallback, 2);
        }
        try {
            synchronized (this.mLock) {
                while (true) {
                    int r2 = this.mConnectionState;
                    if ((r2 == -1 || r2 == -2) && this.mError == 0 && !this.mAborted) {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        return connectGatt;
    }

    public void disconnect(BluetoothGatt bluetoothGatt) {
        if (this.mConnectionState == 0) {
            return;
        }
        sendLogBroadcast(1, "Disconnecting...");
        this.mProgressInfo.setProgress(-5);
        logi("Disconnecting from the device...");
        sendLogBroadcast(0, "gatt.disconnect()");
        bluetoothGatt.disconnect();
        waitUntilDisconnected();
        sendLogBroadcast(5, "Disconnected");
    }

    public DfuDeviceSelector getDeviceSelector() {
        return new DfuDefaultDeviceSelector();
    }

    public abstract Class<? extends Activity> getNotificationTarget();

    public boolean isDebug() {
        return false;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        DEBUG = isDebug();
        logi("DFU service created. Version: 2.4.1");
        initialize();
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter makeDfuActionIntentFilter = makeDfuActionIntentFilter();
        localBroadcastManager.registerReceiver(this.mDfuActionReceiver, makeDfuActionIntentFilter);
        ContextCompat.registerReceiver(this, this.mDfuActionReceiver, makeDfuActionIntentFilter, 2);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        ContextCompat.registerReceiver(this, this.mConnectionStateBroadcastReceiver, intentFilter, 2);
        ContextCompat.registerReceiver(this, this.mBondStateBroadcastReceiver, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"), 2);
        ContextCompat.registerReceiver(this, this.mBluetoothStateBroadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"), 2);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        DfuCallback dfuCallback = this.mDfuServiceImpl;
        if (dfuCallback != null) {
            dfuCallback.abort();
        }
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mDfuActionReceiver);
        unregisterReceiver(this.mDfuActionReceiver);
        unregisterReceiver(this.mConnectionStateBroadcastReceiver);
        unregisterReceiver(this.mBondStateBroadcastReceiver);
        unregisterReceiver(this.mBluetoothStateBroadcastReceiver);
        try {
            InputStream inputStream = this.mFirmwareInputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            InputStream inputStream2 = this.mInitFileInputStream;
            if (inputStream2 != null) {
                inputStream2.close();
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.mFirmwareInputStream = null;
            this.mInitFileInputStream = null;
            throw th;
        }
        this.mFirmwareInputStream = null;
        this.mInitFileInputStream = null;
        logi("DFU service destroyed");
    }

    /* JADX WARN: Code restructure failed: missing block: B:210:0x04c4, code lost:            if (r2 != null) goto L252;     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0544, code lost:            if (r2 != null) goto L252;     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x0131, code lost:            if (r3 < 0) goto L62;     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0126, code lost:            if (r3 < 0) goto L62;     */
    /* JADX WARN: Removed duplicated region for block: B:185:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04ed A[Catch: all -> 0x0465, TRY_LEAVE, TryCatch #2 {all -> 0x0465, blocks: (B:172:0x03f2, B:206:0x046b, B:208:0x0473, B:209:0x04b6, B:211:0x0496, B:190:0x04cd, B:192:0x04ed, B:200:0x052c, B:214:0x0532), top: B:171:0x03f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0473 A[Catch: all -> 0x0465, TryCatch #2 {all -> 0x0465, blocks: (B:172:0x03f2, B:206:0x046b, B:208:0x0473, B:209:0x04b6, B:211:0x0496, B:190:0x04cd, B:192:0x04ed, B:200:0x052c, B:214:0x0532), top: B:171:0x03f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0496 A[Catch: all -> 0x0465, TryCatch #2 {all -> 0x0465, blocks: (B:172:0x03f2, B:206:0x046b, B:208:0x0473, B:209:0x04b6, B:211:0x0496, B:190:0x04cd, B:192:0x04ed, B:200:0x052c, B:214:0x0532), top: B:171:0x03f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0550 A[Catch: all -> 0x01a0, TRY_ENTER, TryCatch #0 {all -> 0x01a0, blocks: (B:63:0x014b, B:65:0x0155, B:67:0x016c, B:68:0x018e, B:71:0x01be, B:73:0x01c4, B:75:0x01c9, B:76:0x01d2, B:78:0x01d6, B:81:0x01df, B:82:0x01e6, B:83:0x01e7, B:85:0x01eb, B:88:0x01f4, B:89:0x01fb, B:90:0x01fc, B:92:0x0200, B:95:0x0209, B:96:0x0210, B:99:0x0214, B:101:0x021a, B:104:0x023b, B:106:0x0244, B:107:0x024b, B:108:0x0255, B:111:0x0263, B:116:0x0276, B:118:0x0292, B:123:0x02a7, B:129:0x02b8, B:131:0x02d4, B:135:0x02e1, B:136:0x0360, B:138:0x037b, B:140:0x0386, B:141:0x0389, B:146:0x03ab, B:151:0x02ff, B:153:0x032f, B:155:0x03b7, B:157:0x03bb, B:162:0x03cd, B:164:0x03d1, B:169:0x03e8, B:225:0x0416, B:183:0x0445, B:219:0x0550, B:220:0x0553, B:203:0x04c6, B:194:0x0521, B:254:0x0224, B:256:0x022a, B:257:0x01ce, B:259:0x0198, B:260:0x019f, B:262:0x0177, B:264:0x0181, B:267:0x015c, B:269:0x0163, B:294:0x0554, B:287:0x0579, B:301:0x059e, B:273:0x05b5, B:280:0x05cc), top: B:59:0x0147, inners: #9, #13, #14, #18, #21 }] */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[Catch: all -> 0x01a0, SYNTHETIC, TryCatch #0 {all -> 0x01a0, blocks: (B:63:0x014b, B:65:0x0155, B:67:0x016c, B:68:0x018e, B:71:0x01be, B:73:0x01c4, B:75:0x01c9, B:76:0x01d2, B:78:0x01d6, B:81:0x01df, B:82:0x01e6, B:83:0x01e7, B:85:0x01eb, B:88:0x01f4, B:89:0x01fb, B:90:0x01fc, B:92:0x0200, B:95:0x0209, B:96:0x0210, B:99:0x0214, B:101:0x021a, B:104:0x023b, B:106:0x0244, B:107:0x024b, B:108:0x0255, B:111:0x0263, B:116:0x0276, B:118:0x0292, B:123:0x02a7, B:129:0x02b8, B:131:0x02d4, B:135:0x02e1, B:136:0x0360, B:138:0x037b, B:140:0x0386, B:141:0x0389, B:146:0x03ab, B:151:0x02ff, B:153:0x032f, B:155:0x03b7, B:157:0x03bb, B:162:0x03cd, B:164:0x03d1, B:169:0x03e8, B:225:0x0416, B:183:0x0445, B:219:0x0550, B:220:0x0553, B:203:0x04c6, B:194:0x0521, B:254:0x0224, B:256:0x022a, B:257:0x01ce, B:259:0x0198, B:260:0x019f, B:262:0x0177, B:264:0x0181, B:267:0x015c, B:269:0x0163, B:294:0x0554, B:287:0x0579, B:301:0x059e, B:273:0x05b5, B:280:0x05cc), top: B:59:0x0147, inners: #9, #13, #14, #18, #21 }] */
    @Override // android.app.IntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onHandleIntent(android.content.Intent r33) {
        /*
            Method dump skipped, instructions count: 1535
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.DfuBaseService.onHandleIntent(android.content.Intent):void");
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        if (notificationManager != null) {
            notificationManager.cancel(NOTIFICATION_ID);
        }
        stopSelf();
    }

    public void refreshDeviceCache(BluetoothGatt bluetoothGatt, boolean z) {
        if (z || bluetoothGatt.getDevice().getBondState() == 10) {
            sendLogBroadcast(0, "gatt.refresh() (hidden)");
            try {
                logi("Refreshing result: " + ((Boolean) bluetoothGatt.getClass().getMethod("refresh", new Class[0]).invoke(bluetoothGatt, new Object[0])).booleanValue());
            } catch (Exception e) {
                loge("An exception occurred while refreshing device", e);
                sendLogBroadcast(15, "Refreshing failed");
            }
        }
    }

    public void sendLogBroadcast(int r3, String str) {
        String m = ConstraintSet$$ExternalSyntheticOutline0.m("[DFU] ", str);
        Intent intent = new Intent(BROADCAST_LOG);
        intent.putExtra(EXTRA_LOG_MESSAGE, m);
        intent.putExtra(EXTRA_LOG_LEVEL, r3);
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public void terminateConnection(BluetoothGatt bluetoothGatt, int r4) {
        if (this.mConnectionState != 0) {
            disconnect(bluetoothGatt);
        }
        refreshDeviceCache(bluetoothGatt, false);
        close(bluetoothGatt);
        waitFor(600L);
        if (r4 != 0) {
            report(r4);
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressInfo.ProgressListener
    public void updateProgressNotification() {
        String string;
        DfuProgressInfo dfuProgressInfo = this.mProgressInfo;
        int progress = dfuProgressInfo.getProgress();
        if (this.mLastProgress == progress) {
            return;
        }
        this.mLastProgress = progress;
        sendProgressBroadcast(dfuProgressInfo);
        if (this.mDisableNotification) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.mLastNotificationTime >= 250 || -6 == progress || -7 == progress) {
            this.mLastNotificationTime = elapsedRealtime;
            String str = this.mDeviceAddress;
            String str2 = this.mDeviceName;
            if (str2 == null) {
                str2 = getString(R.string.dfu_unknown_name);
            }
            NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, NOTIFICATION_CHANNEL_DFU);
            Notification notification = notificationCompat$Builder.mNotification;
            notification.icon = android.R.drawable.stat_sys_upload;
            notificationCompat$Builder.setFlag(8, true);
            notificationCompat$Builder.mColor = -7829368;
            switch (progress) {
                case PROGRESS_ABORTED /* -7 */:
                    notificationCompat$Builder.setFlag(2, false);
                    notificationCompat$Builder.setContentTitle(getString(R.string.dfu_status_aborted));
                    notification.icon = android.R.drawable.stat_sys_upload_done;
                    notificationCompat$Builder.setContentText(getString(R.string.dfu_status_aborted_msg));
                    notificationCompat$Builder.setFlag(16, true);
                    break;
                case PROGRESS_COMPLETED /* -6 */:
                    notificationCompat$Builder.setFlag(2, false);
                    notificationCompat$Builder.setContentTitle(getString(R.string.dfu_status_completed));
                    notification.icon = android.R.drawable.stat_sys_upload_done;
                    notificationCompat$Builder.setContentText(getString(R.string.dfu_status_completed_msg));
                    notificationCompat$Builder.setFlag(16, true);
                    notificationCompat$Builder.mColor = -16730086;
                    break;
                case -5:
                    notificationCompat$Builder.setFlag(2, true);
                    notificationCompat$Builder.setContentTitle(getString(R.string.dfu_status_disconnecting));
                    notificationCompat$Builder.setContentText(getString(R.string.dfu_status_disconnecting_msg, str2));
                    notificationCompat$Builder.setProgress(100, 0, true);
                    break;
                case -4:
                    notificationCompat$Builder.setFlag(2, true);
                    notificationCompat$Builder.setContentTitle(getString(R.string.dfu_status_validating));
                    notificationCompat$Builder.setContentText(getString(R.string.dfu_status_validating_msg));
                    notificationCompat$Builder.setProgress(100, 0, true);
                    break;
                case -3:
                    notificationCompat$Builder.setFlag(2, true);
                    notificationCompat$Builder.setContentTitle(getString(R.string.dfu_status_switching_to_dfu));
                    notificationCompat$Builder.setContentText(getString(R.string.dfu_status_switching_to_dfu_msg));
                    notificationCompat$Builder.setProgress(100, 0, true);
                    break;
                case -2:
                    notificationCompat$Builder.setFlag(2, true);
                    notificationCompat$Builder.setContentTitle(getString(R.string.dfu_status_starting));
                    notificationCompat$Builder.setContentText(getString(R.string.dfu_status_starting_msg));
                    notificationCompat$Builder.setProgress(100, 0, true);
                    break;
                case -1:
                    notificationCompat$Builder.setFlag(2, true);
                    notificationCompat$Builder.setContentTitle(getString(R.string.dfu_status_connecting));
                    notificationCompat$Builder.setContentText(getString(R.string.dfu_status_connecting_msg, str2));
                    notificationCompat$Builder.setProgress(100, 0, true);
                    break;
                default:
                    if (dfuProgressInfo.getTotalParts() == 1) {
                        string = getString(R.string.dfu_status_uploading);
                    } else {
                        string = getString(R.string.dfu_status_uploading_part, Integer.valueOf(dfuProgressInfo.getCurrentPart()), Integer.valueOf(dfuProgressInfo.getTotalParts()));
                    }
                    String string2 = getString(R.string.dfu_status_uploading_msg, str2);
                    notificationCompat$Builder.setFlag(2, true);
                    notificationCompat$Builder.setContentTitle(string);
                    notificationCompat$Builder.setContentText(string2);
                    notificationCompat$Builder.setProgress(100, progress, false);
                    break;
            }
            Intent intent = new Intent(this, getNotificationTarget());
            intent.addFlags(268435456);
            intent.putExtra(EXTRA_DEVICE_ADDRESS, str);
            intent.putExtra(EXTRA_DEVICE_NAME, str2);
            intent.putExtra(EXTRA_PROGRESS, progress);
            notificationCompat$Builder.mContentIntent = PendingIntent.getActivity(this, 0, intent, 201326592);
            updateProgressNotification(notificationCompat$Builder, progress);
            NotificationManager notificationManager = (NotificationManager) getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
            if (notificationManager != null) {
                notificationManager.notify(NOTIFICATION_ID, notificationCompat$Builder.build());
            }
        }
    }

    public void waitFor(long j) {
        synchronized (this.mLock) {
            try {
                sendLogBroadcast(0, "wait(" + j + ")");
                this.mLock.wait(j);
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
        }
    }

    public void waitUntilDisconnected() {
        try {
            synchronized (this.mLock) {
                while (this.mConnectionState != 0 && this.mError == 0) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
    }

    private void loge(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    private InputStream openInputStream(Uri uri, String str, int r10, int r11) throws IOException {
        InputStream openInputStream;
        if (uri.toString().startsWith("file:///android_asset/")) {
            openInputStream = getAssets().open(uri.getPath().substring(15));
        } else {
            openInputStream = getContentResolver().openInputStream(uri);
        }
        if (MIME_TYPE_ZIP.equals(str)) {
            return new ArchiveInputStream(openInputStream, r10, r11);
        }
        Cursor query = getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
        if (query != null) {
            try {
                if (query.moveToNext() && query.getString(0).toLowerCase(Locale.US).endsWith("hex")) {
                    HexInputStream hexInputStream = new HexInputStream(openInputStream, r10);
                    query.close();
                    return hexInputStream;
                }
            } catch (Throwable th) {
                try {
                    query.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (query != null) {
            query.close();
        }
        return openInputStream;
    }

    private InputStream openInputStream(int r2, String str, int r4, int r5) throws IOException {
        InputStream openRawResource = getResources().openRawResource(r2);
        if (MIME_TYPE_ZIP.equals(str)) {
            return new ArchiveInputStream(openRawResource, r4, r5);
        }
        openRawResource.mark(2);
        int read = openRawResource.read();
        openRawResource.reset();
        return read == 58 ? new HexInputStream(openRawResource, r4) : openRawResource;
    }

    public void updateProgressNotification(NotificationCompat$Builder notificationCompat$Builder, int r4) {
        if (r4 == -7 || r4 == -6) {
            return;
        }
        Intent intent = new Intent(BROADCAST_ACTION);
        intent.putExtra(EXTRA_ACTION, 2);
        notificationCompat$Builder.addAction(R.drawable.ic_action_notify_cancel, getString(R.string.dfu_action_abort), PendingIntent.getBroadcast(this, 1, intent, 201326592));
    }

    public void updateErrorNotification(NotificationCompat$Builder notificationCompat$Builder) {
    }

    public void updateForegroundNotification(NotificationCompat$Builder notificationCompat$Builder) {
    }
}
