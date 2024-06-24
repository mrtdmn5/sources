package aws.smithy.kotlin.runtime.io;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.RealBufferedSource;

/* compiled from: BufferedSourceAdapterJVM.kt */
/* loaded from: classes.dex */
public final class BufferedSourceAdapter implements SdkBufferedSource {
    public final BufferedSource delegate;

    public BufferedSourceAdapter(RealBufferedSource realBufferedSource) {
        this.delegate = realBufferedSource;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    /* renamed from: close$aws$smithy$kotlin$runtime$io$AbstractBufferedSourceAdapter, reason: merged with bridge method [inline-methods] */
    public final void close() {
        this.delegate.close();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer dst) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        return this.delegate.read(dst);
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkBufferedSource
    public final byte[] readByteArray() {
        return this.delegate.readByteArray();
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkSource
    public final long read(SdkBuffer sdkBuffer) {
        return this.delegate.read(sdkBuffer.inner, 8192L);
    }
}
