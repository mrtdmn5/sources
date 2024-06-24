package aws.smithy.kotlin.runtime.io;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

/* compiled from: SdkBufferJVM.kt */
/* loaded from: classes.dex */
public final class SdkBuffer implements SdkBufferedSource, SdkBufferedSink {
    public final Buffer inner;

    public SdkBuffer() {
        this(new Buffer());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        this.inner.getClass();
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkBufferedSink
    public final void emit() {
        this.inner.getClass();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SdkBuffer)) {
            return false;
        }
        return Intrinsics.areEqual(this.inner, ((SdkBuffer) obj).inner);
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkSink
    public final void flush() {
        this.inner.getClass();
    }

    public final int hashCode() {
        return this.inner.hashCode();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        this.inner.getClass();
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer dst) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        return this.inner.read(dst);
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkBufferedSource
    public final byte[] readByteArray() {
        return this.inner.readByteArray();
    }

    public final String toString() {
        return this.inner.toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer src) {
        Intrinsics.checkNotNullParameter(src, "src");
        return this.inner.write(src);
    }

    public final void writeUtf8(int r2, int r3, String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.inner.m1737writeUtf8(r2, r3, string);
    }

    public SdkBuffer(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.inner = buffer;
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkSource
    public final long read(SdkBuffer sdkBuffer) {
        return this.inner.read(sdkBuffer.inner, 8192L);
    }

    public final void write(byte[] source, int r3, int r4) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.inner.m1733write(source, r3, r4);
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkSink
    public final void write(SdkBuffer sdkBuffer, long j) {
        this.inner.write(sdkBuffer.inner, j);
    }

    @Override // aws.smithy.kotlin.runtime.io.SdkBufferedSink
    public final SdkBuffer getBuffer() {
        return this;
    }
}
