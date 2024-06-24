package aws.smithy.kotlin.runtime.io;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.RealBufferedSink;

/* compiled from: BufferedSinkAdapterJVM.kt */
/* loaded from: classes.dex */
public final class BufferedSinkAdapter implements SdkBufferedSink {
    public final BufferedSink delegate;

    public BufferedSinkAdapter(RealBufferedSink realBufferedSink) {
        this.delegate = realBufferedSink;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    /* renamed from: close$aws$smithy$kotlin$runtime$io$AbstractBufferedSinkAdapter, reason: merged with bridge method [inline-methods] */
    public final void close() {
        this.delegate.close();
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkBufferedSink
    public final void emit() {
        this.delegate.emit();
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkSink
    public final void flush() {
        this.delegate.flush();
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkBufferedSink
    public final SdkBuffer getBuffer() {
        Buffer buffer = this.delegate.getBuffer();
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return new SdkBuffer(buffer);
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return this.delegate.isOpen();
    }

    /* renamed from: toString$aws$smithy$kotlin$runtime$io$AbstractBufferedSinkAdapter, reason: merged with bridge method [inline-methods] */
    public final String toString() {
        return this.delegate.toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer src) {
        Intrinsics.checkNotNullParameter(src, "src");
        return this.delegate.write(src);
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkSink
    public final void write(SdkBuffer sdkBuffer, long j) {
        this.delegate.write(sdkBuffer.inner, j);
    }
}
