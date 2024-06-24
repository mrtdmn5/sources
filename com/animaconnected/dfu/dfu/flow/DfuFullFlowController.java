package com.animaconnected.dfu.dfu.flow;

import com.animaconnected.bluetooth.gatt.GattDevice;
import com.animaconnected.bluetooth.util.Callback;
import com.animaconnected.dfu.dfu.flow.DfuCommands;
import com.animaconnected.dfu.dfu.utils.DfuConstants;
import com.animaconnected.dfu.dfu.utils.DfuUtilities;
import com.animaconnected.info.ByteUtils;
import java.util.UUID;

/* loaded from: classes.dex */
public class DfuFullFlowController {
    private static final String TAG = "DfuFullFlowController";
    private FlowState mCurrentFlowState;
    private GattDevice mDevice;
    private final DfuCommands mDfuCommands;
    private final byte mImageType;
    private DfuFlowListener mListener;
    private boolean mRunFullFlow;

    /* loaded from: classes.dex */
    public interface DfuFlowListener {
        void onError(Throwable th);

        void onProgressChanged(int r1);

        void onStartedSuccessfully();

        void onSuccess();
    }

    /* loaded from: classes.dex */
    public enum FlowState {
        NOT_STARTED,
        SENDING_START,
        RUNNING,
        DONE
    }

    public DfuFullFlowController(byte[] bArr, byte b) {
        this.mImageType = b;
        this.mDfuCommands = new DfuCommands(bArr, b);
        setState(FlowState.NOT_STARTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendBuffer$0(int r2) {
        this.mListener.onProgressChanged(r2);
    }

    private void onDeviceResult(final byte b, final byte b2, final byte b3) {
        if (b != 16) {
            return;
        }
        if (b3 == 1) {
            if (b2 != 1) {
                if (b2 != 2) {
                    if (b2 != 3) {
                        if (b2 == 4) {
                            sendActivateAndReset();
                            return;
                        }
                        return;
                    }
                    sendValidation();
                    return;
                }
                sendBuffer();
                return;
            }
            setState(FlowState.RUNNING);
            sendInitParams();
            return;
        }
        this.mDfuCommands.sendControlOpCode(this.mDevice, new byte[]{6}, new Callback<Void>() { // from class: com.animaconnected.dfu.dfu.flow.DfuFullFlowController.8
            @Override // com.animaconnected.bluetooth.util.Callback
            public void onError(Throwable th) {
                DfuFullFlowController.this.mListener.onError(th);
            }

            @Override // com.animaconnected.bluetooth.util.Callback
            public void onSuccess(Void r5) {
                DfuFullFlowController.this.mListener.onError(new RuntimeException("Recived error repsonse: " + ((int) b) + " " + ((int) b2) + " " + ((int) b3)));
            }
        });
    }

    private void sendActivateAndReset() {
        DfuUtilities.log(TAG, "Send ActivateAndReset...");
        this.mDfuCommands.sendControlOpCode(this.mDevice, new byte[]{5}, new Callback<Void>() { // from class: com.animaconnected.dfu.dfu.flow.DfuFullFlowController.7
            @Override // com.animaconnected.bluetooth.util.Callback
            public void onError(Throwable th) {
                DfuFullFlowController.this.mListener.onError(th);
            }

            @Override // com.animaconnected.bluetooth.util.Callback
            public void onSuccess(Void r2) {
                DfuFullFlowController.this.setState(FlowState.DONE);
                DfuUtilities.log(DfuFullFlowController.TAG, "ActivateAndReset sent!");
                DfuUtilities.log(DfuFullFlowController.TAG, "---Flow Completed---");
                DfuFullFlowController.this.mListener.onSuccess();
            }
        });
    }

    private void sendBuffer() {
        DfuUtilities.log(TAG, "Send Buffer...");
        this.mDfuCommands.sendBuffer(this.mDevice, new DfuCommands.SendBufferProgressListener() { // from class: com.animaconnected.dfu.dfu.flow.DfuFullFlowController$$ExternalSyntheticLambda0
            @Override // com.animaconnected.dfu.dfu.flow.DfuCommands.SendBufferProgressListener
            public final void onProgressChanged(int r2) {
                DfuFullFlowController.this.lambda$sendBuffer$0(r2);
            }
        }, new Callback<Void>() { // from class: com.animaconnected.dfu.dfu.flow.DfuFullFlowController.5
            @Override // com.animaconnected.bluetooth.util.Callback
            public void onError(Throwable th) {
                DfuFullFlowController.this.mListener.onError(th);
            }

            @Override // com.animaconnected.bluetooth.util.Callback
            public void onSuccess(Void r2) {
                DfuUtilities.log(DfuFullFlowController.TAG, "Buffer sent!");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendControlOpStartCode() {
        DfuUtilities.log(TAG, "Send ControlOpStart...");
        this.mDfuCommands.sendControlOpCode(this.mDevice, new byte[]{1, this.mImageType}, new Callback<Void>() { // from class: com.animaconnected.dfu.dfu.flow.DfuFullFlowController.2
            @Override // com.animaconnected.bluetooth.util.Callback
            public void onError(Throwable th) {
                DfuFullFlowController.this.mListener.onError(th);
            }

            @Override // com.animaconnected.bluetooth.util.Callback
            public void onSuccess(Void r2) {
                DfuUtilities.log(DfuFullFlowController.TAG, "ControlOpStart sent!");
                if (DfuFullFlowController.this.mRunFullFlow) {
                    DfuFullFlowController.this.sendDataImageSize();
                } else {
                    DfuFullFlowController.this.mListener.onSuccess();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDataImageSize() {
        DfuUtilities.log(TAG, "Send image size...");
        this.mDfuCommands.sendDataImageSize(this.mDevice, new Callback<Void>() { // from class: com.animaconnected.dfu.dfu.flow.DfuFullFlowController.3
            @Override // com.animaconnected.bluetooth.util.Callback
            public void onError(Throwable th) {
                DfuFullFlowController.this.mListener.onError(th);
            }

            @Override // com.animaconnected.bluetooth.util.Callback
            public void onSuccess(Void r2) {
                DfuUtilities.log(DfuFullFlowController.TAG, "image size sent!");
            }
        });
    }

    private void sendInitParams() {
        DfuUtilities.log(TAG, "Send InitParams...");
        this.mDfuCommands.sendInitParams(this.mDevice, new Callback<Void>() { // from class: com.animaconnected.dfu.dfu.flow.DfuFullFlowController.4
            @Override // com.animaconnected.bluetooth.util.Callback
            public void onError(Throwable th) {
                DfuFullFlowController.this.mListener.onError(th);
            }

            @Override // com.animaconnected.bluetooth.util.Callback
            public void onSuccess(Void r2) {
                DfuUtilities.log(DfuFullFlowController.TAG, "InitParams sent!");
            }
        });
    }

    private void sendValidation() {
        DfuUtilities.log(TAG, "Send Validation...");
        this.mDfuCommands.sendControlOpCode(this.mDevice, new byte[]{4}, new Callback<Void>() { // from class: com.animaconnected.dfu.dfu.flow.DfuFullFlowController.6
            @Override // com.animaconnected.bluetooth.util.Callback
            public void onError(Throwable th) {
                DfuFullFlowController.this.mListener.onError(th);
            }

            @Override // com.animaconnected.bluetooth.util.Callback
            public void onSuccess(Void r2) {
                DfuUtilities.log(DfuFullFlowController.TAG, "...validation sent!");
            }
        });
    }

    private void setNotification() {
        DfuUtilities.log(TAG, "Set Notification...");
        this.mDfuCommands.setNotification(this.mDevice, new Callback<Void>() { // from class: com.animaconnected.dfu.dfu.flow.DfuFullFlowController.1
            @Override // com.animaconnected.bluetooth.util.Callback
            public void onError(Throwable th) {
                DfuFullFlowController.this.mListener.onError(th);
            }

            @Override // com.animaconnected.bluetooth.util.Callback
            public void onSuccess(Void r2) {
                DfuUtilities.log(DfuFullFlowController.TAG, "Notification Set!");
                DfuFullFlowController.this.sendControlOpStartCode();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(FlowState flowState) {
        this.mCurrentFlowState = flowState;
        if (flowState == FlowState.RUNNING) {
            this.mListener.onStartedSuccessfully();
        }
    }

    public FlowState getFlowState() {
        return this.mCurrentFlowState;
    }

    public void onCharacteristicChanged(UUID r4, UUID r5, byte[] bArr) {
        DfuUtilities.log(TAG, "onCharaChange: " + ByteUtils.toHex(bArr));
        if (r5.equals(DfuConstants.CONTROL_CHARA_UUID)) {
            if (bArr.length == 3) {
                onDeviceResult(bArr[0], bArr[1], bArr[2]);
                return;
            }
            if (bArr.length >= 2) {
                onDeviceResult(bArr[0], bArr[1], (byte) 1);
                return;
            }
            this.mListener.onError(new RuntimeException("Can't parse response data: " + ByteUtils.toHex(bArr)));
        }
    }

    public void reset() {
        setState(FlowState.NOT_STARTED);
        start(this.mDevice, this.mRunFullFlow, this.mListener);
    }

    public void start(GattDevice gattDevice, boolean z, DfuFlowListener dfuFlowListener) {
        this.mDevice = gattDevice;
        this.mRunFullFlow = z;
        FlowState flowState = this.mCurrentFlowState;
        if (flowState == FlowState.NOT_STARTED || flowState == FlowState.SENDING_START) {
            DfuUtilities.log(TAG, "---Flow Start---");
            setState(FlowState.SENDING_START);
            this.mListener = dfuFlowListener;
            setNotification();
        }
    }
}
