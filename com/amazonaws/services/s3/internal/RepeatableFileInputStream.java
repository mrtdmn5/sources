package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkInputStream;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class RepeatableFileInputStream extends SdkInputStream {
    private static final Log log = LogFactory.getLog("RepeatableFIS");
    private final File file;
    private FileInputStream fis;
    private long bytesReadPastMarkPoint = 0;
    private long markPoint = 0;

    public RepeatableFileInputStream(File file) throws FileNotFoundException {
        this.fis = null;
        if (file != null) {
            this.fis = new FileInputStream(file);
            this.file = file;
            return;
        }
        throw new IllegalArgumentException("File cannot be null");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        abortIfNeeded();
        return this.fis.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.fis.close();
        abortIfNeeded();
    }

    public File getFile() {
        return this.file;
    }

    @Override // com.amazonaws.internal.SdkInputStream
    public InputStream getWrappedInputStream() {
        return this.fis;
    }

    @Override // java.io.InputStream
    public void mark(int r5) {
        abortIfNeeded();
        this.markPoint += this.bytesReadPastMarkPoint;
        this.bytesReadPastMarkPoint = 0L;
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Input stream marked at " + this.markPoint + " bytes");
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        abortIfNeeded();
        int read = this.fis.read();
        if (read == -1) {
            return -1;
        }
        this.bytesReadPastMarkPoint++;
        return read;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.fis.close();
        abortIfNeeded();
        this.fis = new FileInputStream(this.file);
        long j = this.markPoint;
        while (j > 0) {
            j -= this.fis.skip(j);
        }
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Reset to mark point " + this.markPoint + " after returning " + this.bytesReadPastMarkPoint + " bytes");
        }
        this.bytesReadPastMarkPoint = 0L;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        abortIfNeeded();
        long skip = this.fis.skip(j);
        this.bytesReadPastMarkPoint += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int r4, int r5) throws IOException {
        abortIfNeeded();
        int read = this.fis.read(bArr, r4, r5);
        this.bytesReadPastMarkPoint += read;
        return read;
    }
}
