package com.animaconnected.dfu.dfu;

import com.animaconnected.bluetooth.dfu.DfuProgressListener;

/* loaded from: classes.dex */
public class DfuModel {
    private static DfuModel sInstance;
    private ImageState mCurrentImageState;
    private boolean mInDfu;
    private DfuProgressListener mProgressListener;

    /* loaded from: classes.dex */
    public enum ImageState {
        UPDATE_NOT_STARTED,
        UPDATING_BOOTLOADER,
        UPDATING_APPLICATION,
        UPDATE_COMPLETED
    }

    public static DfuModel getInstance() {
        if (sInstance == null) {
            sInstance = new DfuModel();
        }
        return sInstance;
    }

    public void Reset() {
        this.mInDfu = false;
        this.mCurrentImageState = ImageState.UPDATE_NOT_STARTED;
    }

    public ImageState getCurrentImageState() {
        return this.mCurrentImageState;
    }

    public boolean isInDFU() {
        return this.mInDfu;
    }

    public void onDfuError(Throwable th) {
        DfuProgressListener dfuProgressListener = this.mProgressListener;
        if (dfuProgressListener != null) {
            dfuProgressListener.onError(th);
        }
    }

    public void onDfuStartedSuccessfully() {
        this.mInDfu = true;
    }

    public void setCurrentImageState(ImageState imageState) {
        this.mCurrentImageState = imageState;
        if (imageState == ImageState.UPDATE_COMPLETED) {
            this.mProgressListener.onSuccess();
        }
    }

    public void setCurrentPercent(int r2) {
        DfuProgressListener dfuProgressListener = this.mProgressListener;
        if (dfuProgressListener != null) {
            dfuProgressListener.onProgressChanged(r2);
        }
    }

    public void setListener(DfuProgressListener dfuProgressListener) {
        this.mProgressListener = dfuProgressListener;
    }
}
