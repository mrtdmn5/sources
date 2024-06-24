package com.animaconnected.dfu.dfu15;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.foundation.text.ValidatingOffsetMapping$$ExternalSyntheticOutline0;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.animaconnected.bluetooth.dfu.BaseDfuController;
import com.animaconnected.bluetooth.dfu.DfuProgressListener;
import com.animaconnected.bluetooth.gatt.DeviceListener;
import com.animaconnected.bluetooth.gatt.GattDevice;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.bluetooth.util.ConnectionListener;
import com.animaconnected.dfu.dfu.utils.DfuUtilities;
import com.animaconnected.dfu.dfu15.Dfu15Controller;
import java.util.Locale;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuProgressListenerAdapter;
import no.nordicsemi.android.dfu.DfuServiceController;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import no.nordicsemi.android.dfu.DfuServiceListenerHelper;

/* loaded from: classes.dex */
public class Dfu15Controller implements BaseDfuController {
    private static final int DISCONNECT_RESTART_DELAY_MS = 10000;
    private static final String TAG = "Dfu15Controller";
    private final AddressChangeListener mAddressChangeListener;
    private final Context mContext;
    private DfuServiceController mController;
    private String mCurrentAddress;
    private GattDevice mDevice;
    private GattDevice mDfuDevice;
    private final DeviceListener mDfuDeviceListener;
    private DfuProgressListener mDfuProgressListener;
    private Uri mFirmware;
    private final DfuProgressListenerAdapter mDfu15ProgressListener = new AnonymousClass1();
    private final DeviceListener deviceListener = new DeviceListener() { // from class: com.animaconnected.dfu.dfu15.Dfu15Controller.2
        @Override // com.animaconnected.bluetooth.gatt.DeviceListener
        public void onConnected() {
            Dfu15Controller.this.startDfuService();
            Dfu15Controller.this.mDfuDevice.unregisterListener(this);
        }

        @Override // com.animaconnected.bluetooth.gatt.DeviceListener
        public void onDisconnected() {
        }

        @Override // com.animaconnected.bluetooth.gatt.DeviceListener
        public void onCharacteristicChanged(UUID r1, UUID r2, byte[] bArr) {
        }
    };
    private final ConnectionListener mConnectionListener = new ConnectionListener() { // from class: com.animaconnected.dfu.dfu15.Dfu15Controller.3
        @Override // com.animaconnected.bluetooth.util.ConnectionListener
        public void onChanged(boolean z) {
            if (z) {
                DfuUtilities.log(Dfu15Controller.TAG, "Bluetooth enabled, start DFU.");
                Dfu15Controller.this.mDfuDevice.connect();
                Dfu15Controller.this.mDfuDevice.unregisterListener(Dfu15Controller.this.deviceListener);
                Dfu15Controller.this.mDfuDevice.registerListener(Dfu15Controller.this.deviceListener);
                return;
            }
            DfuUtilities.log(Dfu15Controller.TAG, "Bluetooth disabled");
            if (!Dfu15Controller.this.mController.isAborted()) {
                Dfu15Controller.this.mController.abort();
            }
        }
    };
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.animaconnected.dfu.dfu15.Dfu15Controller$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends DfuProgressListenerAdapter {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$0() {
            Dfu15Controller.this.startDfuService();
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceConnected(String str) {
            DfuUtilities.log(Dfu15Controller.TAG, "Dfu device connected");
            if (Dfu15Controller.this.mDfuDeviceListener != null) {
                Dfu15Controller.this.mDfuDeviceListener.onConnected();
            }
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceDisconnected(String str) {
            DfuUtilities.log(Dfu15Controller.TAG, "Dfu device disconnect");
            if (Dfu15Controller.this.mDfuDeviceListener != null) {
                Dfu15Controller.this.mDfuDeviceListener.onDisconnected();
            }
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuAborted(String str) {
            DfuUtilities.log(Dfu15Controller.TAG, "Dfu aborted!");
            if (ConnectionFactory.getConnection().isEnabled()) {
                Dfu15Controller.this.mDfuProgressListener.onError(new RuntimeException(ConstraintSet$$ExternalSyntheticOutline0.m("App in DFU. DeviceAddress: ", str)));
                Dfu15Controller.this.clean();
            } else {
                DfuUtilities.log(Dfu15Controller.TAG, "Dfu aborted. Waiting for bluetooth reconnection");
            }
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuCompleted(String str) {
            Dfu15Controller.this.clean();
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuProcessStarting(String str) {
            Dfu15Controller.this.mDfuDevice.changeAddress(str);
            Dfu15Controller.this.mAddressChangeListener.onEnterDfuAddressChange(str);
            Dfu15Controller.this.mCurrentAddress = str;
            Dfu15Controller.this.mDevice.disconnect();
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onEnablingDfuMode(String str) {
            super.onEnablingDfuMode(str);
            Dfu15Controller.this.mCurrentAddress = str;
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onError(String str, int r4, int r5, String str2) {
            if (r4 != 133 && r4 != 520 && r4 != 4096) {
                if (r4 != 4106) {
                    StringBuilder m = ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("error: ", r4, ", errorType: ", r5, ", message: ");
                    m.append(str2);
                    String sb = m.toString();
                    DfuUtilities.log(Dfu15Controller.TAG, sb);
                    Dfu15Controller.this.mDfuProgressListener.onError(new RuntimeException(sb));
                    return;
                }
                DfuUtilities.log(Dfu15Controller.TAG, String.format(Locale.getDefault(), "Error: Bluetooth Disabled[%d], start again when enabled", Integer.valueOf(r4)));
                return;
            }
            if (ConnectionFactory.getConnection().isEnabled()) {
                DfuUtilities.log(Dfu15Controller.TAG, String.format(Locale.getDefault(), "Error: Disconnect[%d], retry connection in %d ms", Integer.valueOf(r4), 10000));
                if (r4 == 520) {
                    DfuUtilities.log(Dfu15Controller.TAG, "Received a UNKNOWN_DFU_15_ERROR error");
                }
                Dfu15Controller.this.mHandler.postDelayed(new Runnable() { // from class: com.animaconnected.dfu.dfu15.Dfu15Controller$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Dfu15Controller.AnonymousClass1.this.lambda$onError$0();
                    }
                }, 10000L);
                return;
            }
            DfuUtilities.log(Dfu15Controller.TAG, String.format(Locale.getDefault(), "Error: Bluetooth Disabled[%d], start again when enabled", Integer.valueOf(r4)));
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onProgressChanged(String str, int r2, float f, float f2, int r5, int r6) {
            DfuUtilities.setPercentage(r2);
            Dfu15Controller.this.mDfuProgressListener.onProgressChanged(r2);
            if (r2 >= 100) {
                DfuUtilities.log(Dfu15Controller.TAG, "Dfu completed, reboot and cleanup!");
                String softAdressFromBootAdress = DeviceAddressHelper.getSoftAdressFromBootAdress(str);
                Dfu15Controller.this.mDfuProgressListener.onSuccess();
                Dfu15Controller.this.mAddressChangeListener.onLeaveDfuAddressChange(softAdressFromBootAdress);
                Dfu15Controller.this.mCurrentAddress = softAdressFromBootAdress;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface AddressChangeListener {
        void onEnterDfuAddressChange(String str);

        void onLeaveDfuAddressChange(String str);
    }

    public Dfu15Controller(Context context, DeviceListener deviceListener, AddressChangeListener addressChangeListener) {
        this.mContext = context;
        this.mDfuDeviceListener = deviceListener;
        this.mAddressChangeListener = addressChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clean() {
        this.mDfuDevice.disconnect();
        this.mController.abort();
        DfuUtilities.log(TAG, "Cleaning up...");
        ConnectionFactory.getConnection().removeConnectionListener(this.mConnectionListener);
        DfuServiceListenerHelper.unregisterProgressListener(this.mContext, this.mDfu15ProgressListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$start$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDfuService() {
        DfuUtilities.log(TAG, "Staring DFU Service using Nordic DFU lib.");
        if (this.mCurrentAddress == null) {
            this.mCurrentAddress = this.mDevice.getAddress();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            DfuServiceInitiator.createDfuNotificationChannel(this.mContext);
        }
        this.mController = new DfuServiceInitiator(this.mCurrentAddress).setUnsafeExperimentalButtonlessServiceInSecureDfuEnabled(true).setForeground(false).setZip(this.mFirmware).setDisableNotification(true).setPacketsReceiptNotificationsValue(1).setPacketsReceiptNotificationsEnabled(true).setKeepBond(true).start(this.mContext, DfuService.class);
    }

    @Override // com.animaconnected.bluetooth.dfu.BaseDfuController
    public void start(GattDevice gattDevice, Uri uri, DfuProgressListener dfuProgressListener) {
        DfuUtilities.resetLog();
        if (this.mController != null) {
            dfuProgressListener.onError(new RuntimeException("Already started"));
            return;
        }
        this.mDevice = gattDevice;
        GattDevice createClone = gattDevice.createClone(new Dfu15Controller$$ExternalSyntheticLambda0());
        this.mDfuDevice = createClone;
        createClone.skipBondingAndRefresh();
        this.mFirmware = uri;
        this.mDfuProgressListener = dfuProgressListener;
        ConnectionFactory.getConnection().addConnectionListener(this.mConnectionListener);
        DfuServiceListenerHelper.registerProgressListener(this.mContext, this.mDfu15ProgressListener);
        startDfuService();
    }
}
