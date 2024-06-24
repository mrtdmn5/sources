package com.animaconnected.dfu.dfu;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.animaconnected.bluetooth.device.ScanToConnectInterface;
import com.animaconnected.bluetooth.dfu.BaseDfuController;
import com.animaconnected.bluetooth.dfu.DfuProgressListener;
import com.animaconnected.bluetooth.gatt.DeviceListener;
import com.animaconnected.bluetooth.gatt.GattDevice;
import com.animaconnected.dfu.dfu.DfuModel;
import com.animaconnected.dfu.dfu.flow.DfuFullFlowController;
import com.animaconnected.dfu.dfu.utils.DfuUtilities;
import com.animaconnected.dfu.dfu.utils.DfuZipArchive;
import com.animaconnected.dfu.utils.RemoveBondException;
import com.animaconnected.future.FailCallback;
import com.animaconnected.future.Future;
import com.animaconnected.future.SuccessCallback;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes.dex */
public class Dfu8Controller implements BaseDfuController {
    private static final long DFU_DELAY_START = 1000;
    private static final String TAG = "Dfu8Controller";
    private DfuZipArchive mArchive;
    private final Context mContext;
    private GattDevice mDevice;
    private GattDevice mDfuDevice;
    private final DeviceListener mDfuDeviceListener;
    private DfuFullFlowController mDfuFullFlow;
    private final DfuModel mDfuModel;
    private boolean mIsConnection;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final DeviceListener mDeviceListener = new DeviceListener() { // from class: com.animaconnected.dfu.dfu.Dfu8Controller.1
        @Override // com.animaconnected.bluetooth.gatt.DeviceListener
        public void onCharacteristicChanged(UUID r2, UUID r3, byte[] bArr) {
            if (Dfu8Controller.this.mDfuFullFlow != null) {
                Dfu8Controller.this.mDfuFullFlow.onCharacteristicChanged(r2, r3, bArr);
            }
        }

        @Override // com.animaconnected.bluetooth.gatt.DeviceListener
        public void onConnected() {
            DfuUtilities.log(Dfu8Controller.TAG, "Connected");
            if (Dfu8Controller.this.mDfuFullFlow != null) {
                int r0 = AnonymousClass5.$SwitchMap$com$animaconnected$dfu$dfu$flow$DfuFullFlowController$FlowState[Dfu8Controller.this.mDfuFullFlow.getFlowState().ordinal()];
                if (r0 != 1 && r0 != 2) {
                    if (r0 == 3) {
                        DfuUtilities.log(Dfu8Controller.TAG, "Reconnected, Let's restart the procedure");
                        Dfu8Controller.this.restartDfu();
                        return;
                    }
                    return;
                }
                DfuUtilities.log(Dfu8Controller.TAG, "Connected to device");
                Dfu8Controller.this.mDfuFullFlow.start(Dfu8Controller.this.mDfuDevice, true, Dfu8Controller.this.mFlowListener);
            }
        }

        @Override // com.animaconnected.bluetooth.gatt.DeviceListener
        public void onDisconnected() {
            DfuUtilities.log(Dfu8Controller.TAG, "Disconnected");
        }
    };
    private final DfuFullFlowController.DfuFlowListener mFlowListener = new DfuFullFlowController.DfuFlowListener() { // from class: com.animaconnected.dfu.dfu.Dfu8Controller.2
        @Override // com.animaconnected.dfu.dfu.flow.DfuFullFlowController.DfuFlowListener
        public void onError(Throwable th) {
            DfuUtilities.log(Dfu8Controller.TAG, "Dfu flow error: " + th.getMessage());
        }

        @Override // com.animaconnected.dfu.dfu.flow.DfuFullFlowController.DfuFlowListener
        public void onProgressChanged(int r2) {
            Dfu8Controller.this.mDfuModel.setCurrentPercent(r2);
        }

        @Override // com.animaconnected.dfu.dfu.flow.DfuFullFlowController.DfuFlowListener
        public void onStartedSuccessfully() {
            Dfu8Controller.this.mDfuModel.onDfuStartedSuccessfully();
        }

        @Override // com.animaconnected.dfu.dfu.flow.DfuFullFlowController.DfuFlowListener
        public void onSuccess() {
            Dfu8Controller.this.updateDfuImageState();
        }
    };

    /* renamed from: com.animaconnected.dfu.dfu.Dfu8Controller$5, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$animaconnected$dfu$dfu$DfuModel$ImageState;
        static final /* synthetic */ int[] $SwitchMap$com$animaconnected$dfu$dfu$flow$DfuFullFlowController$FlowState;

        static {
            int[] r0 = new int[DfuModel.ImageState.values().length];
            $SwitchMap$com$animaconnected$dfu$dfu$DfuModel$ImageState = r0;
            try {
                r0[DfuModel.ImageState.UPDATING_BOOTLOADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$animaconnected$dfu$dfu$DfuModel$ImageState[DfuModel.ImageState.UPDATING_APPLICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] r2 = new int[DfuFullFlowController.FlowState.values().length];
            $SwitchMap$com$animaconnected$dfu$dfu$flow$DfuFullFlowController$FlowState = r2;
            try {
                r2[DfuFullFlowController.FlowState.NOT_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$animaconnected$dfu$dfu$flow$DfuFullFlowController$FlowState[DfuFullFlowController.FlowState.SENDING_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$animaconnected$dfu$dfu$flow$DfuFullFlowController$FlowState[DfuFullFlowController.FlowState.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class DFUScanToConnect implements ScanToConnectInterface {
        private DFUScanToConnect() {
        }

        @Override // com.animaconnected.bluetooth.device.ScanToConnectInterface
        public boolean shouldUseScanToConnect() {
            return true;
        }
    }

    public Dfu8Controller(Context context, DeviceListener deviceListener) {
        this.mContext = context;
        this.mDfuDeviceListener = deviceListener;
        DfuModel dfuModel = DfuModel.getInstance();
        this.mDfuModel = dfuModel;
        dfuModel.setCurrentImageState(DfuModel.ImageState.UPDATE_NOT_STARTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callDfuLibraryDelayed() {
        removeBond().delay(DFU_DELAY_START).success(new SuccessCallback() { // from class: com.animaconnected.dfu.dfu.Dfu8Controller$$ExternalSyntheticLambda1
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                Dfu8Controller.this.lambda$callDfuLibraryDelayed$1((Void) obj);
            }
        }).fail(new FailCallback() { // from class: com.animaconnected.dfu.dfu.Dfu8Controller$$ExternalSyntheticLambda2
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                Dfu8Controller.this.lambda$callDfuLibraryDelayed$2(th);
            }
        });
    }

    private void close() {
        DfuUtilities.log(TAG, "Closing down dfu");
        GattDevice gattDevice = this.mDfuDevice;
        if (gattDevice != null) {
            gattDevice.disconnect();
            this.mDfuDevice.unregisterListener(this.mDeviceListener);
            DeviceListener deviceListener = this.mDfuDeviceListener;
            if (deviceListener != null) {
                this.mDfuDevice.unregisterListener(deviceListener);
            }
        }
        this.mDfuModel.setCurrentImageState(DfuModel.ImageState.UPDATE_NOT_STARTED);
    }

    private void connectToDevice() {
        if (this.mIsConnection) {
            DfuUtilities.log(TAG, "Connecting already");
        } else {
            this.mIsConnection = true;
            this.mHandler.postDelayed(new Runnable() { // from class: com.animaconnected.dfu.dfu.Dfu8Controller$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Dfu8Controller.this.lambda$connectToDevice$0();
                }
            }, 3000L);
        }
    }

    private void finnishDfu() {
        this.mDfuModel.setCurrentImageState(DfuModel.ImageState.UPDATE_COMPLETED);
        this.mDfuModel.Reset();
        close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callDfuLibraryDelayed$1(Void r2) {
        DfuUtilities.log(TAG, "Starting DFU");
        startBootloader();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callDfuLibraryDelayed$2(Throwable th) {
        this.mDfuModel.onDfuError(new RemoveBondException("Failed to remove Bluetooth bond"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connectToDevice$0() {
        this.mIsConnection = false;
        DfuUtilities.log(TAG, "Device connecting...");
        GattDevice createClone = this.mDevice.createClone(new DFUScanToConnect());
        this.mDfuDevice = createClone;
        createClone.skipBondingAndRefresh();
        DeviceListener deviceListener = this.mDfuDeviceListener;
        if (deviceListener != null) {
            this.mDfuDevice.registerListener(deviceListener);
        }
        this.mDfuDevice.registerListener(this.mDeviceListener);
        this.mDfuDevice.connect();
    }

    private Future<Void> removeBond() {
        return this.mDevice.removeBond();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartDfu() {
        DfuModel.ImageState currentImageState = this.mDfuModel.getCurrentImageState();
        String str = TAG;
        DfuUtilities.log(str, "onRestartDfu -> " + currentImageState.name());
        int r0 = AnonymousClass5.$SwitchMap$com$animaconnected$dfu$dfu$DfuModel$ImageState[currentImageState.ordinal()];
        if (r0 != 1) {
            if (r0 == 2) {
                DfuUtilities.log(str, "onRestartDfu UPDATING_APPLICATION");
            }
        } else {
            DfuUtilities.log(str, "onRestartDfu UPDATING_BOOTLOADER");
        }
        this.mDfuFullFlow.reset();
    }

    private void startApplication() {
        this.mDfuModel.setCurrentImageState(DfuModel.ImageState.UPDATING_APPLICATION);
        if (this.mArchive.getApplication() != null) {
            DfuUtilities.log(TAG, "Starting application");
            startDfuFlow(this.mArchive.getApplication(), (byte) 4);
        } else {
            updateDfuImageState();
        }
    }

    private void startBootloader() {
        this.mDfuModel.setCurrentImageState(DfuModel.ImageState.UPDATING_BOOTLOADER);
        if (this.mArchive.getBootloader() != null) {
            DfuUtilities.log(TAG, "Starting bootloader");
            startDfuFlow(this.mArchive.getBootloader(), (byte) 2);
        } else {
            updateDfuImageState();
        }
    }

    private void startDfuFlow(byte[] bArr, byte b) {
        DfuUtilities.log(TAG, "Starting new DfuFullFlowController");
        this.mDfuFullFlow = new DfuFullFlowController(bArr, b);
        if (!this.mDfuModel.isInDFU()) {
            connectToDevice();
        } else if (this.mDfuDevice.isConnected()) {
            this.mDfuFullFlow.start(this.mDfuDevice, true, this.mFlowListener);
        }
    }

    private void startDfuWhenDisconnected() {
        if (!this.mDevice.isConnected()) {
            Log.d(TAG, "No need to wait for a disconnect");
            callDfuLibraryDelayed();
        } else {
            Log.d(TAG, "Waiting for device to disconnect before starting DFU...");
            this.mDevice.registerListener(new DeviceListener() { // from class: com.animaconnected.dfu.dfu.Dfu8Controller.3
                @Override // com.animaconnected.bluetooth.gatt.DeviceListener
                public void onDisconnected() {
                    Dfu8Controller.this.mDevice.unregisterListener(this);
                    Dfu8Controller.this.callDfuLibraryDelayed();
                }

                @Override // com.animaconnected.bluetooth.gatt.DeviceListener
                public void onConnected() {
                }

                @Override // com.animaconnected.bluetooth.gatt.DeviceListener
                public void onCharacteristicChanged(UUID r1, UUID r2, byte[] bArr) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDfuImageState() {
        DfuUtilities.log(TAG, "Connected after dfu flow, updateState");
        int r0 = AnonymousClass5.$SwitchMap$com$animaconnected$dfu$dfu$DfuModel$ImageState[this.mDfuModel.getCurrentImageState().ordinal()];
        if (r0 != 1) {
            if (r0 == 2) {
                finnishDfu();
                return;
            }
            return;
        }
        startApplication();
    }

    @Override // com.animaconnected.bluetooth.dfu.BaseDfuController
    public void start(GattDevice gattDevice, Uri uri, DfuProgressListener dfuProgressListener) {
        byte b;
        this.mDfuModel.setListener(dfuProgressListener);
        try {
            this.mArchive = new DfuZipArchive(this.mContext, uri);
            this.mDevice = gattDevice;
            DfuUtilities.resetLog();
            if (this.mDevice.guessIfDeviceIsInDfu()) {
                this.mDevice.disconnect();
            } else {
                byte[] bootloader = this.mArchive.getBootloader();
                if (bootloader == null) {
                    bootloader = this.mArchive.getApplication();
                    b = 4;
                } else {
                    b = 2;
                }
                new DfuFullFlowController(bootloader, b).start(this.mDevice, false, new DfuFullFlowController.DfuFlowListener() { // from class: com.animaconnected.dfu.dfu.Dfu8Controller.4
                    @Override // com.animaconnected.dfu.dfu.flow.DfuFullFlowController.DfuFlowListener
                    public void onError(Throwable th) {
                        Dfu8Controller.this.mDevice.disconnect();
                    }

                    @Override // com.animaconnected.dfu.dfu.flow.DfuFullFlowController.DfuFlowListener
                    public void onSuccess() {
                        DfuUtilities.log(Dfu8Controller.TAG, "---Flow Completed---");
                        Dfu8Controller.this.mDevice.disconnect();
                    }

                    @Override // com.animaconnected.dfu.dfu.flow.DfuFullFlowController.DfuFlowListener
                    public void onStartedSuccessfully() {
                    }

                    @Override // com.animaconnected.dfu.dfu.flow.DfuFullFlowController.DfuFlowListener
                    public void onProgressChanged(int r1) {
                    }
                });
            }
            startDfuWhenDisconnected();
        } catch (IOException e) {
            this.mDfuModel.onDfuError(new IOException("Failed to create DfuZipArchive", e));
            Toast.makeText(this.mContext, "File error: " + e.getMessage(), 1).show();
        }
    }
}
