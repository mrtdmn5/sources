package com.animaconnected.dfu.fota;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.animaconnected.bluetooth.dfu.BaseFotaController;
import com.animaconnected.bluetooth.dfu.FotaProgressListener;
import com.animaconnected.bluetooth.gatt.DeviceListener;
import com.animaconnected.bluetooth.gatt.GattDevice;
import com.animaconnected.bluetooth.util.Callback;
import com.animaconnected.bluetooth.util.TryCounter;
import com.animaconnected.dfu.dfu.utils.DfuUtilities;
import com.animaconnected.dfu.fota.FotaController;
import com.animaconnected.dfu.fota.utils.FotaConstants;
import com.animaconnected.dfu.fota.utils.FotaZipArchive;
import com.animaconnected.info.ByteUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public class FotaController extends BaseFotaController {
    private static final int FOTA_SLOW_MODE_SPEED = 20000;
    private static final String TAG = "FotaController";
    private FotaZipArchive mArchive;
    private FotaCommands mCommands;
    private final Context mContext;
    private DataHandler mDataHandler;
    private GattDevice mDevice;
    private boolean mIsRunningFota;
    private boolean mIsSlowModeEnabled;
    private FotaProgressListener mListener;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final TryCounter mCommandsTryCounter = new TryCounter(1);
    private final TryCounter mRestartFotaTryCounter = new TryCounter(3);
    private int mConnectionInterval = 400;
    private final DeviceListener mDeviceListener = new DeviceListener() { // from class: com.animaconnected.dfu.fota.FotaController.1
        @Override // com.animaconnected.bluetooth.gatt.DeviceListener
        public void onCharacteristicChanged(UUID r2, UUID r3, byte[] bArr) {
            if (r3.equals(FotaConstants.FOTA_TX_CHARACTERISTIC)) {
                short decodeUInt8LE = ByteUtils.decodeUInt8LE(bArr, 0);
                if (decodeUInt8LE == 1 && bArr.length == 18) {
                    FotaController.this.decodeStatusPackage(bArr);
                } else if (decodeUInt8LE == 170 && bArr.length == 3) {
                    FotaController.this.decodeResponsePackage(bArr);
                }
            }
        }

        @Override // com.animaconnected.bluetooth.gatt.DeviceListener
        public void onConnected() {
            DfuUtilities.log(FotaController.TAG, "Connected");
            if (FotaController.this.mIsRunningFota) {
                FotaController.this.mCommands.setNotificationsForTX();
                FotaController.this.mCommands.sendStatus();
            }
        }

        @Override // com.animaconnected.bluetooth.gatt.DeviceListener
        public void onDisconnected() {
        }
    };

    /* renamed from: com.animaconnected.dfu.fota.FotaController$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements Callback<Void> {
        final /* synthetic */ byte[] val$dataSection;

        public AnonymousClass2(byte[] bArr) {
            this.val$dataSection = bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0() {
            if (FotaController.this.mIsRunningFota) {
                FotaController.this.sendPageData();
            }
        }

        @Override // com.animaconnected.bluetooth.util.Callback
        public void onSuccess(Void r5) {
            FotaController.this.mDataHandler.addBytesReceived(this.val$dataSection.length);
            FotaController.this.mHandler.postDelayed(new Runnable() { // from class: com.animaconnected.dfu.fota.FotaController$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FotaController.AnonymousClass2.this.lambda$onSuccess$0();
                }
            }, FotaController.this.mIsSlowModeEnabled ? FotaController.FOTA_SLOW_MODE_SPEED : FotaController.this.mConnectionInterval);
        }

        @Override // com.animaconnected.bluetooth.util.Callback
        public void onError(Throwable th) {
        }
    }

    public FotaController(Context context) {
        this.mContext = context;
    }

    private void close() {
        DfuUtilities.log(TAG, "Closing");
        GattDevice gattDevice = this.mDevice;
        if (gattDevice != null) {
            gattDevice.unregisterListener(this.mDeviceListener);
        }
        this.mIsRunningFota = false;
        FotaProgressListener fotaProgressListener = this.mListener;
        if (fotaProgressListener != null) {
            fotaProgressListener.onClosing();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decodeResponsePackage(byte[] bArr) {
        byte b = bArr[1];
        byte b2 = bArr[2];
        String responseAsName = FotaConstants.getResponseAsName(b2);
        String str = "Type: " + FotaConstants.getTypeAsName(b) + " Response: " + responseAsName;
        String str2 = TAG;
        DfuUtilities.log(str2, str);
        if (b != 2) {
            if (b != 3) {
                if (b != 5) {
                    if (b != 6) {
                        if (b == 7) {
                            if (b2 == 0) {
                                this.mListener.onReadyToPerformFota();
                                return;
                            }
                            this.mListener.onError(responseAsName);
                            if (b2 == 4) {
                                sendInitPackage();
                                return;
                            }
                            if (b2 == 5) {
                                if (this.mCommandsTryCounter.shouldTryAgain()) {
                                    this.mCommands.sendVerifyFota();
                                    return;
                                } else {
                                    sendInitPackage();
                                    return;
                                }
                            }
                            this.mCommands.sendStatus();
                            return;
                        }
                        return;
                    }
                    if (b2 == 0) {
                        this.mCommandsTryCounter.resetTries();
                        this.mListener.onPerformFotaCompleted();
                        close();
                        return;
                    }
                    this.mListener.onPerformFotaError(b2);
                    if (b2 == 4) {
                        sendInitPackage();
                        return;
                    }
                    if (b2 == 5) {
                        if (this.mCommandsTryCounter.shouldTryAgain()) {
                            this.mCommands.sendPerformFota();
                            return;
                        }
                        return;
                    } else {
                        if (b2 != 9 && b2 != 8) {
                            this.mCommands.sendStatus();
                            return;
                        }
                        return;
                    }
                }
                if (b2 == 0) {
                    this.mCommandsTryCounter.resetTries();
                    this.mCommands.sendStatus();
                    return;
                }
                this.mListener.onError(responseAsName);
                if (b2 == 5) {
                    if (this.mCommandsTryCounter.shouldTryAgain()) {
                        this.mCommands.sendPageEnd();
                        return;
                    } else {
                        sendInitPackage();
                        return;
                    }
                }
                this.mCommands.sendStatus();
                return;
            }
            if (b2 == 0) {
                DfuUtilities.log(str2, "Send: PageData...");
                sendPageData();
                return;
            } else {
                this.mListener.onError(responseAsName);
                return;
            }
        }
        if (b2 == 0) {
            sendPageStarter();
            return;
        }
        this.mListener.onError(responseAsName);
        if (b2 == 5) {
            sendInitPackage();
            return;
        }
        if (b2 == 7) {
            close();
        } else if (b2 == 8) {
            close();
        } else {
            this.mCommands.sendStatus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decodeStatusPackage(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 1, bArr2, 0, 8);
        long decodeUInt32LE = ByteUtils.decodeUInt32LE(bArr, 9);
        long decodeUInt32LE2 = ByteUtils.decodeUInt32LE(bArr, 13);
        byte b = bArr[17];
        int r0 = (int) decodeUInt32LE;
        if (isCurrentPageDone(bArr2, r0)) {
            r0 = getPageIndex(bArr2);
            this.mDataHandler.setCurrentData(r0, 0L);
        } else {
            this.mDataHandler.setCurrentData(r0, decodeUInt32LE2);
        }
        sendProgress(bArr2, r0);
        String str = "State: " + FotaConstants.getStateAsName(b) + " Current page: " + decodeUInt32LE + " Next page: " + r0;
        String str2 = TAG;
        DfuUtilities.log(str2, str);
        if (r0 >= 0) {
            if (b == 0) {
                sendInitPackage();
                return;
            } else if (b == 1) {
                sendPageStarter();
                return;
            } else {
                if (b == 2) {
                    sendPageData();
                    return;
                }
                return;
            }
        }
        if (b == 1) {
            DfuUtilities.log(str2, "All pages completed! Verifying FOTA...");
            this.mCommands.sendVerifyFota();
        }
    }

    private int getPageIndex(byte[] bArr) {
        int totalPages = this.mDataHandler.getTotalPages();
        for (int r1 = 0; r1 < totalPages; r1++) {
            if (!ByteUtils.isSet(bArr, r1)) {
                return r1;
            }
        }
        return -1;
    }

    private boolean isCurrentPageDone(byte[] bArr, int r2) {
        return ByteUtils.isSet(bArr, r2);
    }

    private void sendInitPackage() {
        if (this.mRestartFotaTryCounter.shouldTryAgain()) {
            this.mCommands.sendInitPackage(this.mArchive.getFile().length, this.mArchive.getHash());
        } else {
            this.mListener.onError("Max FOTA attempts reached");
            close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPageData() {
        if (!this.mDataHandler.isPageCompleted()) {
            byte[] nextDataSection = this.mDataHandler.getNextDataSection();
            this.mCommands.sendPageData(nextDataSection, new AnonymousClass2(nextDataSection));
        } else {
            this.mCommands.sendPageEnd();
            DfuUtilities.log(TAG, "...Done, wait for response!");
        }
    }

    private void sendPageStarter() {
        this.mDataHandler.resetCurrentBytesReceived();
        CRC32 crc32 = new CRC32();
        crc32.update(this.mDataHandler.getPageData());
        int pageSize = this.mDataHandler.getPageSize();
        DfuUtilities.log(TAG, "Send: PageStarter[crc: " + crc32.getValue() + ", size:" + pageSize + "]");
        this.mCommands.sendPageStart(this.mDataHandler.getCurrentPageIndex(), pageSize, crc32.getValue());
    }

    private void sendProgress(byte[] bArr, int r6) {
        List asList = Arrays.asList(new Byte[this.mDataHandler.getTotalPages()]);
        if (!asList.isEmpty()) {
            for (int r2 = 0; r2 < asList.size(); r2++) {
                if (r2 == r6) {
                    asList.set(r2, (byte) 2);
                } else if (isCurrentPageDone(bArr, r2)) {
                    asList.set(r2, (byte) 1);
                } else {
                    asList.set(r2, (byte) 0);
                }
            }
            this.mListener.onProgressChanged(Collections.unmodifiableList(asList));
        }
    }

    @Override // com.animaconnected.bluetooth.dfu.BaseFotaController
    public void cancelFota() {
        this.mListener.onError("FOTA has been canceled.");
        close();
    }

    @Override // com.animaconnected.bluetooth.dfu.BaseFotaController
    public void onConnIntChange(int r1) {
        this.mConnectionInterval = r1;
    }

    @Override // com.animaconnected.bluetooth.dfu.BaseFotaController
    public void performFota() {
        this.mCommands.sendPerformFota();
    }

    @Override // com.animaconnected.bluetooth.dfu.BaseFotaController
    public void setFotaSlowMode(boolean z) {
        this.mIsSlowModeEnabled = z;
    }

    @Override // com.animaconnected.bluetooth.dfu.BaseFotaController
    public void start(GattDevice gattDevice, Uri uri, boolean z, FotaProgressListener fotaProgressListener) {
        if (!this.mIsRunningFota) {
            this.mIsRunningFota = true;
            DfuUtilities.resetLog();
            String str = TAG;
            DfuUtilities.log(str, "FOTA starting...");
            this.mListener = fotaProgressListener;
            try {
                FotaZipArchive fotaZipArchive = new FotaZipArchive(this.mContext, uri);
                this.mArchive = fotaZipArchive;
                this.mDataHandler = new DataHandler(fotaZipArchive.getFile());
                this.mCommands = new FotaCommands(gattDevice);
                this.mDevice = gattDevice;
                gattDevice.registerListener(this.mDeviceListener);
                this.mCommands.setNotificationsForTX();
                if (z) {
                    DfuUtilities.log(str, "FOTA has been forced to restart");
                    sendInitPackage();
                } else {
                    this.mCommands.sendStatus();
                }
            } catch (IOException e) {
                Toast.makeText(this.mContext, "File error: " + e.getMessage(), 1).show();
                close();
            }
        }
    }
}
