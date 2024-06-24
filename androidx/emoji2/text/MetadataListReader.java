package androidx.emoji2.text;

import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;

/* loaded from: classes.dex */
public final class MetadataListReader {

    /* loaded from: classes.dex */
    public static class ByteBufferReader {
        public final ByteBuffer mByteBuffer;

        public ByteBufferReader(ByteBuffer byteBuffer) {
            this.mByteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public final long readUnsignedInt() throws IOException {
            return this.mByteBuffer.getInt() & 4294967295L;
        }

        public final void skip(int r3) throws IOException {
            ByteBuffer byteBuffer = this.mByteBuffer;
            byteBuffer.position(byteBuffer.position() + r3);
        }
    }

    public static MetadataList read(MappedByteBuffer mappedByteBuffer) throws IOException {
        ByteBuffer byteBuffer;
        long j;
        ByteBuffer duplicate = mappedByteBuffer.duplicate();
        ByteBufferReader byteBufferReader = new ByteBufferReader(duplicate);
        byteBufferReader.skip(4);
        int r2 = duplicate.getShort() & 65535;
        if (r2 <= 100) {
            byteBufferReader.skip(6);
            int r5 = 0;
            while (true) {
                byteBuffer = byteBufferReader.mByteBuffer;
                if (r5 < r2) {
                    int r9 = byteBuffer.getInt();
                    byteBufferReader.skip(4);
                    j = byteBufferReader.readUnsignedInt();
                    byteBufferReader.skip(4);
                    if (1835365473 == r9) {
                        break;
                    }
                    r5++;
                } else {
                    j = -1;
                    break;
                }
            }
            if (j != -1) {
                byteBufferReader.skip((int) (j - duplicate.position()));
                byteBufferReader.skip(12);
                long readUnsignedInt = byteBufferReader.readUnsignedInt();
                for (int r3 = 0; r3 < readUnsignedInt; r3++) {
                    int r52 = byteBuffer.getInt();
                    long readUnsignedInt2 = byteBufferReader.readUnsignedInt();
                    byteBufferReader.readUnsignedInt();
                    if (1164798569 == r52 || 1701669481 == r52) {
                        duplicate.position((int) (readUnsignedInt2 + j));
                        MetadataList metadataList = new MetadataList();
                        duplicate.order(ByteOrder.LITTLE_ENDIAN);
                        metadataList.__reset(duplicate.position() + duplicate.getInt(duplicate.position()), duplicate);
                        return metadataList;
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }
}
