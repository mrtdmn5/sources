package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class SdkFilterInputStream extends FilterInputStream implements MetricAware {
    public SdkFilterInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public final void abortIfNeeded() {
        if (!Thread.interrupted()) {
            return;
        }
        abort();
        throw new AbortedException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        abortIfNeeded();
        return ((FilterInputStream) this).in.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterInputStream) this).in.close();
        abortIfNeeded();
    }

    @Override // com.amazonaws.internal.MetricAware
    @Deprecated
    public boolean isMetricActivated() {
        if (((FilterInputStream) this).in instanceof MetricAware) {
            return ((MetricAware) ((FilterInputStream) this).in).isMetricActivated();
        }
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r2) {
        abortIfNeeded();
        ((FilterInputStream) this).in.mark(r2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        abortIfNeeded();
        return ((FilterInputStream) this).in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        abortIfNeeded();
        return ((FilterInputStream) this).in.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        abortIfNeeded();
        ((FilterInputStream) this).in.reset();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        abortIfNeeded();
        return ((FilterInputStream) this).in.skip(j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int r3, int r4) throws IOException {
        abortIfNeeded();
        return ((FilterInputStream) this).in.read(bArr, r3, r4);
    }

    public void abort() {
    }
}
