package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import com.amazonaws.logging.LogFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class SdkInputStream extends InputStream implements MetricAware {
    public final void abortIfNeeded() {
        if (!Thread.interrupted()) {
            return;
        }
        try {
            abort();
        } catch (IOException e) {
            LogFactory.getLog(getClass()).debug("FYI", e);
        }
        throw new AbortedException();
    }

    public abstract InputStream getWrappedInputStream();

    @Override // com.amazonaws.internal.MetricAware
    @Deprecated
    public final boolean isMetricActivated() {
        Closeable wrappedInputStream = getWrappedInputStream();
        if (wrappedInputStream instanceof MetricAware) {
            return ((MetricAware) wrappedInputStream).isMetricActivated();
        }
        return false;
    }

    public void abort() throws IOException {
    }
}
