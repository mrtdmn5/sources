package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import com.amazonaws.services.s3.model.ProgressEvent;
import com.amazonaws.services.s3.model.ProgressListener;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
/* loaded from: classes.dex */
public class ProgressReportingInputStream extends SdkFilterInputStream {
    private static final int NOTIFICATION_THRESHOLD = 8192;
    private boolean fireCompletedEvent;
    private final ProgressListener listener;
    private int unnotifiedByteCount;

    public ProgressReportingInputStream(InputStream inputStream, ProgressListener progressListener) {
        super(inputStream);
        this.listener = progressListener;
    }

    private void notify(int r3) {
        int r0 = this.unnotifiedByteCount + r3;
        this.unnotifiedByteCount = r0;
        if (r0 >= 8192) {
            this.listener.progressChanged(new ProgressEvent(r0));
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
        this.listener.progressChanged(progressEvent);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        int r0 = this.unnotifiedByteCount;
        if (r0 > 0) {
            this.listener.progressChanged(new ProgressEvent(r0));
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
        }
        if (read != -1) {
            notify(1);
        }
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        ProgressEvent progressEvent = new ProgressEvent(this.unnotifiedByteCount);
        progressEvent.setEventCode(32);
        this.listener.progressChanged(progressEvent);
        this.unnotifiedByteCount = 0;
    }

    public void setFireCompletedEvent(boolean z) {
        this.fireCompletedEvent = z;
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
