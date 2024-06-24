package com.amazonaws.event;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes.dex */
public class ProgressReportingInputStream extends SdkFilterInputStream {
    private static final int BYTES_IN_KB = 1024;
    private static final int THRESHOLD_IN_KB = 8;
    private boolean fireCompletedEvent;
    private final ProgressListenerCallbackExecutor listenerCallbackExecutor;
    private int notificationThreshold;
    private int unnotifiedByteCount;

    public ProgressReportingInputStream(InputStream inputStream, ProgressListenerCallbackExecutor progressListenerCallbackExecutor) {
        super(inputStream);
        this.notificationThreshold = DfuBaseService.ERROR_REMOTE_MASK;
        this.listenerCallbackExecutor = progressListenerCallbackExecutor;
    }

    private void notify(int r5) {
        int r0 = this.unnotifiedByteCount + r5;
        this.unnotifiedByteCount = r0;
        if (r0 >= this.notificationThreshold) {
            this.listenerCallbackExecutor.progressChanged(new ProgressEvent(r0));
            this.unnotifiedByteCount = 0;
        }
    }

    private void notifyCompleted() {
        if (!this.fireCompletedEvent) {
            return;
        }
        ProgressEvent progressEvent = new ProgressEvent(this.unnotifiedByteCount);
        progressEvent.setEventCode(4);
        this.unnotifiedByteCount = 0;
        this.listenerCallbackExecutor.progressChanged(progressEvent);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        int r0 = this.unnotifiedByteCount;
        if (r0 > 0) {
            this.listenerCallbackExecutor.progressChanged(new ProgressEvent(r0));
            this.unnotifiedByteCount = 0;
        }
        super.close();
    }

    public boolean getFireCompletedEvent() {
        return this.fireCompletedEvent;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        if (read == -1) {
            notifyCompleted();
        } else {
            notify(1);
        }
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        ProgressEvent progressEvent = new ProgressEvent(this.unnotifiedByteCount);
        progressEvent.setEventCode(32);
        this.listenerCallbackExecutor.progressChanged(progressEvent);
        this.unnotifiedByteCount = 0;
    }

    public void setFireCompletedEvent(boolean z) {
        this.fireCompletedEvent = z;
    }

    public void setNotificationThreshold(int r1) {
        this.notificationThreshold = r1 * 1024;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int r2, int r3) throws IOException {
        int read = super.read(bArr, r2, r3);
        if (read == -1) {
            notifyCompleted();
        }
        if (read != -1) {
            notify(read);
        }
        return read;
    }
}
