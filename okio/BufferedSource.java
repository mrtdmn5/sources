package okio;

import java.io.IOException;
import java.nio.channels.ReadableByteChannel;

/* compiled from: BufferedSource.kt */
/* loaded from: classes4.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    boolean exhausted() throws IOException;

    Buffer getBuffer();

    long indexOf(ByteString byteString) throws IOException;

    long indexOfElement(ByteString byteString) throws IOException;

    boolean rangeEquals(ByteString byteString) throws IOException;

    long readAll(Buffer buffer) throws IOException;

    byte readByte() throws IOException;

    byte[] readByteArray() throws IOException;

    ByteString readByteString(long j) throws IOException;

    long readHexadecimalUnsignedLong() throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    String readUtf8LineStrict() throws IOException;

    String readUtf8LineStrict(long j) throws IOException;

    boolean request(long j) throws IOException;

    void require(long j) throws IOException;

    int select(Options options) throws IOException;

    void skip(long j) throws IOException;
}
