package com.google.android.datatransport.runtime;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class TransportRuntimeComponent implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ((DaggerTransportRuntimeComponent) this).sQLiteEventStoreProvider.get().close();
    }
}
