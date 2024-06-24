package com.google.crypto.tink.shaded.protobuf;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.R;
import com.google.crypto.tink.shaded.protobuf.Utf8;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class CodedOutputStream extends ByteOutput {
    public CodedOutputStreamWriter wrapper;
    public static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
    public static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.HAS_UNSAFE_ARRAY_OPERATIONS;

    public static int computeBoolSize(int r0) {
        return computeTagSize(r0) + 1;
    }

    public static int computeBytesSize(int r1, ByteString byteString) {
        int computeTagSize = computeTagSize(r1);
        int size = byteString.size();
        return computeUInt32SizeNoTag(size) + size + computeTagSize;
    }

    public static int computeDoubleSize(int r0) {
        return computeTagSize(r0) + 8;
    }

    public static int computeEnumSize(int r0, int r1) {
        return computeInt32SizeNoTag(r1) + computeTagSize(r0);
    }

    public static int computeFixed32Size(int r0) {
        return computeTagSize(r0) + 4;
    }

    public static int computeFixed64Size(int r0) {
        return computeTagSize(r0) + 8;
    }

    public static int computeFloatSize(int r0) {
        return computeTagSize(r0) + 4;
    }

    @Deprecated
    public static int computeGroupSize(int r2, MessageLite messageLite, Schema schema) {
        int computeTagSize = computeTagSize(r2) * 2;
        AbstractMessageLite abstractMessageLite = (AbstractMessageLite) messageLite;
        int memoizedSerializedSize = abstractMessageLite.getMemoizedSerializedSize();
        if (memoizedSerializedSize == -1) {
            memoizedSerializedSize = schema.getSerializedSize(abstractMessageLite);
            abstractMessageLite.setMemoizedSerializedSize(memoizedSerializedSize);
        }
        return memoizedSerializedSize + computeTagSize;
    }

    public static int computeInt32Size(int r0, int r1) {
        return computeInt32SizeNoTag(r1) + computeTagSize(r0);
    }

    public static int computeInt32SizeNoTag(int r0) {
        if (r0 >= 0) {
            return computeUInt32SizeNoTag(r0);
        }
        return 10;
    }

    public static int computeInt64Size(int r0, long j) {
        return computeUInt64SizeNoTag(j) + computeTagSize(r0);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        int r1;
        if (lazyFieldLite.memoizedBytes != null) {
            r1 = lazyFieldLite.memoizedBytes.size();
        } else if (lazyFieldLite.value != null) {
            r1 = lazyFieldLite.value.getSerializedSize();
        } else {
            r1 = 0;
        }
        return computeUInt32SizeNoTag(r1) + r1;
    }

    public static int computeSFixed32Size(int r0) {
        return computeTagSize(r0) + 4;
    }

    public static int computeSFixed64Size(int r0) {
        return computeTagSize(r0) + 8;
    }

    public static int computeSInt32Size(int r1, int r2) {
        return computeUInt32SizeNoTag((r2 >> 31) ^ (r2 << 1)) + computeTagSize(r1);
    }

    public static int computeSInt64Size(int r3, long j) {
        return computeUInt64SizeNoTag((j >> 63) ^ (j << 1)) + computeTagSize(r3);
    }

    public static int computeStringSize(int r0, String str) {
        return computeStringSizeNoTag(str) + computeTagSize(r0);
    }

    public static int computeStringSizeNoTag(String str) {
        int length;
        try {
            length = Utf8.encodedLength(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.UTF_8).length;
        }
        return computeUInt32SizeNoTag(length) + length;
    }

    public static int computeTagSize(int r0) {
        return computeUInt32SizeNoTag((r0 << 3) | 0);
    }

    public static int computeUInt32Size(int r0, int r1) {
        return computeUInt32SizeNoTag(r1) + computeTagSize(r0);
    }

    public static int computeUInt32SizeNoTag(int r1) {
        if ((r1 & (-128)) == 0) {
            return 1;
        }
        if ((r1 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & r1) == 0) {
            return 3;
        }
        if ((r1 & (-268435456)) == 0) {
            return 4;
        }
        return 5;
    }

    public static int computeUInt64Size(int r0, long j) {
        return computeUInt64SizeNoTag(j) + computeTagSize(r0);
    }

    public static int computeUInt64SizeNoTag(long j) {
        int r0;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            r0 = 6;
        } else {
            r0 = 2;
        }
        if (((-2097152) & j) != 0) {
            r0 += 2;
            j >>>= 14;
        }
        if ((j & (-16384)) != 0) {
            return r0 + 1;
        }
        return r0;
    }

    public abstract void write(byte b) throws IOException;

    public abstract void writeBool(int r1, boolean z) throws IOException;

    public abstract void writeBytes(int r1, ByteString byteString) throws IOException;

    public abstract void writeFixed32(int r1, int r2) throws IOException;

    public abstract void writeFixed32NoTag(int r1) throws IOException;

    public abstract void writeFixed64(int r1, long j) throws IOException;

    public abstract void writeFixed64NoTag(long j) throws IOException;

    public abstract void writeInt32(int r1, int r2) throws IOException;

    public abstract void writeInt32NoTag(int r1) throws IOException;

    public abstract void writeMessage(int r1, MessageLite messageLite, Schema schema) throws IOException;

    public abstract void writeMessageSetExtension(int r1, MessageLite messageLite) throws IOException;

    public abstract void writeRawMessageSetExtension(int r1, ByteString byteString) throws IOException;

    public abstract void writeString(int r1, String str) throws IOException;

    public abstract void writeTag(int r1, int r2) throws IOException;

    public abstract void writeUInt32(int r1, int r2) throws IOException;

    public abstract void writeUInt32NoTag(int r1) throws IOException;

    public abstract void writeUInt64(int r1, long j) throws IOException;

    public abstract void writeUInt64NoTag(long j) throws IOException;

    /* loaded from: classes3.dex */
    public static class ArrayEncoder extends CodedOutputStream {
        public final byte[] buffer;
        public final int limit;
        public int position;

        public ArrayEncoder(byte[] bArr, int r6) {
            int r3 = 0 + r6;
            if ((0 | r6 | (bArr.length - r3)) >= 0) {
                this.buffer = bArr;
                this.position = 0;
                this.limit = r3;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(r6)));
        }

        public final int spaceLeft() {
            return this.limit - this.position;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void write(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int r1 = this.position;
                this.position = r1 + 1;
                bArr[r1] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeBool(int r2, boolean z) throws IOException {
            writeTag(r2, 0);
            write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeBytes(int r2, ByteString byteString) throws IOException {
            writeTag(r2, 2);
            writeBytesNoTag(byteString);
        }

        public final void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed32(int r2, int r3) throws IOException {
            writeTag(r2, 5);
            writeFixed32NoTag(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int r5) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int r1 = this.position;
                int r2 = r1 + 1;
                bArr[r1] = (byte) (r5 & 255);
                int r12 = r2 + 1;
                bArr[r2] = (byte) ((r5 >> 8) & 255);
                int r22 = r12 + 1;
                bArr[r12] = (byte) ((r5 >> 16) & 255);
                this.position = r22 + 1;
                bArr[r22] = (byte) ((r5 >> 24) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed64(int r2, long j) throws IOException {
            writeTag(r2, 1);
            writeFixed64NoTag(j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int r1 = this.position;
                int r2 = r1 + 1;
                bArr[r1] = (byte) (((int) j) & 255);
                int r12 = r2 + 1;
                bArr[r2] = (byte) (((int) (j >> 8)) & 255);
                int r22 = r12 + 1;
                bArr[r12] = (byte) (((int) (j >> 16)) & 255);
                int r13 = r22 + 1;
                bArr[r22] = (byte) (((int) (j >> 24)) & 255);
                int r23 = r13 + 1;
                bArr[r13] = (byte) (((int) (j >> 32)) & 255);
                int r14 = r23 + 1;
                bArr[r23] = (byte) (((int) (j >> 40)) & 255);
                int r24 = r14 + 1;
                bArr[r14] = (byte) (((int) (j >> 48)) & 255);
                this.position = r24 + 1;
                bArr[r24] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeInt32(int r2, int r3) throws IOException {
            writeTag(r2, 0);
            writeInt32NoTag(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int r3) throws IOException {
            if (r3 >= 0) {
                writeUInt32NoTag(r3);
            } else {
                writeUInt64NoTag(r3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void writeLazy(byte[] bArr, int r2, int r3) throws IOException {
            write(bArr, r2, r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeMessage(int r3, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(r3, 2);
            AbstractMessageLite abstractMessageLite = (AbstractMessageLite) messageLite;
            int memoizedSerializedSize = abstractMessageLite.getMemoizedSerializedSize();
            if (memoizedSerializedSize == -1) {
                memoizedSerializedSize = schema.getSerializedSize(abstractMessageLite);
                abstractMessageLite.setMemoizedSerializedSize(memoizedSerializedSize);
            }
            writeUInt32NoTag(memoizedSerializedSize);
            schema.writeTo(messageLite, this.wrapper);
        }

        public final void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int r4, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r4);
            writeTag(3, 2);
            writeMessageNoTag(messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int r4, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, r4);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeString(int r2, String str) throws IOException {
            writeTag(r2, 2);
            writeStringNoTag(str);
        }

        public final void writeStringNoTag(String str) throws IOException {
            int r0 = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                int r3 = this.limit;
                byte[] bArr = this.buffer;
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int r1 = r0 + computeUInt32SizeNoTag2;
                    this.position = r1;
                    int encodeUtf8 = Utf8.processor.encodeUtf8(str, bArr, r1, r3 - r1);
                    this.position = r0;
                    writeUInt32NoTag((encodeUtf8 - r0) - computeUInt32SizeNoTag2);
                    this.position = encodeUtf8;
                } else {
                    writeUInt32NoTag(Utf8.encodedLength(str));
                    int r12 = this.position;
                    this.position = Utf8.processor.encodeUtf8(str, bArr, r12, r3 - r12);
                }
            } catch (Utf8.UnpairedSurrogateException e) {
                this.position = r0;
                CodedOutputStream.logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e);
                byte[] bytes = str.getBytes(Internal.UTF_8);
                try {
                    writeUInt32NoTag(bytes.length);
                    write(bytes, 0, bytes.length);
                } catch (OutOfSpaceException e2) {
                    throw e2;
                } catch (IndexOutOfBoundsException e3) {
                    throw new OutOfSpaceException(e3);
                }
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeTag(int r1, int r2) throws IOException {
            writeUInt32NoTag((r1 << 3) | r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt32(int r2, int r3) throws IOException {
            writeTag(r2, 0);
            writeUInt32NoTag(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int r6) throws IOException {
            boolean z = CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS;
            int r1 = this.limit;
            byte[] bArr = this.buffer;
            if (z && !Android.isOnAndroidDevice()) {
                int r0 = this.position;
                if (r1 - r0 >= 5) {
                    if ((r6 & (-128)) == 0) {
                        this.position = r0 + 1;
                        UnsafeUtil.putByte(bArr, r0, (byte) r6);
                        return;
                    }
                    this.position = r0 + 1;
                    UnsafeUtil.putByte(bArr, r0, (byte) (r6 | 128));
                    int r62 = r6 >>> 7;
                    if ((r62 & (-128)) == 0) {
                        int r02 = this.position;
                        this.position = r02 + 1;
                        UnsafeUtil.putByte(bArr, r02, (byte) r62);
                        return;
                    }
                    int r03 = this.position;
                    this.position = r03 + 1;
                    UnsafeUtil.putByte(bArr, r03, (byte) (r62 | 128));
                    int r63 = r62 >>> 7;
                    if ((r63 & (-128)) == 0) {
                        int r04 = this.position;
                        this.position = r04 + 1;
                        UnsafeUtil.putByte(bArr, r04, (byte) r63);
                        return;
                    }
                    int r05 = this.position;
                    this.position = r05 + 1;
                    UnsafeUtil.putByte(bArr, r05, (byte) (r63 | 128));
                    int r64 = r63 >>> 7;
                    if ((r64 & (-128)) == 0) {
                        int r06 = this.position;
                        this.position = r06 + 1;
                        UnsafeUtil.putByte(bArr, r06, (byte) r64);
                        return;
                    } else {
                        int r07 = this.position;
                        this.position = r07 + 1;
                        UnsafeUtil.putByte(bArr, r07, (byte) (r64 | 128));
                        int r08 = this.position;
                        this.position = r08 + 1;
                        UnsafeUtil.putByte(bArr, r08, (byte) (r64 >>> 7));
                        return;
                    }
                }
            }
            while ((r6 & (-128)) != 0) {
                try {
                    int r09 = this.position;
                    this.position = r09 + 1;
                    bArr[r09] = (byte) ((r6 & R.styleable.AppTheme_statusTextH5) | 128);
                    r6 >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(r1), 1), e);
                }
            }
            int r010 = this.position;
            this.position = r010 + 1;
            bArr[r010] = (byte) r6;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt64(int r2, long j) throws IOException {
            writeTag(r2, 0);
            writeUInt64NoTag(j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long j) throws IOException {
            boolean z = CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS;
            int r2 = this.limit;
            byte[] bArr = this.buffer;
            if (z && r2 - this.position >= 10) {
                while ((j & (-128)) != 0) {
                    int r0 = this.position;
                    this.position = r0 + 1;
                    UnsafeUtil.putByte(bArr, r0, (byte) ((((int) j) & R.styleable.AppTheme_statusTextH5) | 128));
                    j >>>= 7;
                }
                int r02 = this.position;
                this.position = r02 + 1;
                UnsafeUtil.putByte(bArr, r02, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    int r03 = this.position;
                    this.position = r03 + 1;
                    bArr[r03] = (byte) ((((int) j) & R.styleable.AppTheme_statusTextH5) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(r2), 1), e);
                }
            }
            int r04 = this.position;
            this.position = r04 + 1;
            bArr[r04] = (byte) j;
        }

        public final void write(byte[] bArr, int r4, int r5) throws IOException {
            try {
                System.arraycopy(bArr, r4, this.buffer, this.position, r5);
                this.position += r5;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(r5)), e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class OutOfSpaceException extends IOException {
        public OutOfSpaceException(String str, IndexOutOfBoundsException indexOutOfBoundsException) {
            super(ConstraintSet$$ExternalSyntheticOutline0.m("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str), indexOutOfBoundsException);
        }

        public OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public OutOfSpaceException(IndexOutOfBoundsException indexOutOfBoundsException) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
        }
    }
}
