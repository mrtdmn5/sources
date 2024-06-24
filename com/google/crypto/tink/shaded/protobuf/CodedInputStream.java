package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class CodedInputStream {
    public int recursionDepth;
    public final int recursionLimit = 100;
    public CodedInputStreamReader wrapper;

    /* loaded from: classes3.dex */
    public static final class ArrayDecoder extends CodedInputStream {
        public final byte[] buffer;
        public int bufferSizeAfterLimit;
        public int currentLimit = Integer.MAX_VALUE;
        public int lastTag;
        public int limit;
        public int pos;
        public final int startPos;

        public ArrayDecoder(byte[] bArr, int r2, int r3, boolean z) {
            this.buffer = bArr;
            this.limit = r3 + r2;
            this.pos = r2;
            this.startPos = r2;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final void checkLastTagWas(int r2) throws InvalidProtocolBufferException {
            if (this.lastTag == r2) {
            } else {
                throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final boolean isAtEnd() throws IOException {
            if (this.pos == this.limit) {
                return true;
            }
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final void popLimit(int r3) {
            this.currentLimit = r3;
            int r0 = this.limit + this.bufferSizeAfterLimit;
            this.limit = r0;
            int r1 = r0 - this.startPos;
            if (r1 > r3) {
                int r12 = r1 - r3;
                this.bufferSizeAfterLimit = r12;
                this.limit = r0 - r12;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final int pushLimit(int r5) throws InvalidProtocolBufferException {
            if (r5 >= 0) {
                int r0 = this.pos;
                int r1 = this.startPos;
                int r02 = (r0 - r1) + r5;
                int r52 = this.currentLimit;
                if (r02 <= r52) {
                    this.currentLimit = r02;
                    int r2 = this.limit + this.bufferSizeAfterLimit;
                    this.limit = r2;
                    int r12 = r2 - r1;
                    if (r12 > r02) {
                        int r13 = r12 - r02;
                        this.bufferSizeAfterLimit = r13;
                        this.limit = r2 - r13;
                    } else {
                        this.bufferSizeAfterLimit = 0;
                    }
                    return r52;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final boolean readBool() throws IOException {
            if (readRawVarint64() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final ByteString.LiteralByteString readBytes() throws IOException {
            byte[] bArr;
            int readRawVarint32 = readRawVarint32();
            byte[] bArr2 = this.buffer;
            if (readRawVarint32 > 0) {
                int r2 = this.limit;
                int r3 = this.pos;
                if (readRawVarint32 <= r2 - r3) {
                    ByteString.LiteralByteString copyFrom = ByteString.copyFrom(bArr2, r3, readRawVarint32);
                    this.pos += readRawVarint32;
                    return copyFrom;
                }
            }
            if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            if (readRawVarint32 > 0) {
                int r22 = this.limit;
                int r32 = this.pos;
                if (readRawVarint32 <= r22 - r32) {
                    int r0 = readRawVarint32 + r32;
                    this.pos = r0;
                    bArr = Arrays.copyOfRange(bArr2, r32, r0);
                    ByteString.LiteralByteString literalByteString = ByteString.EMPTY;
                    return new ByteString.LiteralByteString(bArr);
                }
            }
            if (readRawVarint32 <= 0) {
                if (readRawVarint32 == 0) {
                    bArr = Internal.EMPTY_BYTE_ARRAY;
                    ByteString.LiteralByteString literalByteString2 = ByteString.EMPTY;
                    return new ByteString.LiteralByteString(bArr);
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final long readInt64() throws IOException {
            return readRawVarint64();
        }

        public final int readRawLittleEndian32() throws IOException {
            int r0 = this.pos;
            if (this.limit - r0 >= 4) {
                this.pos = r0 + 4;
                byte[] bArr = this.buffer;
                return ((bArr[r0 + 3] & 255) << 24) | (bArr[r0] & 255) | ((bArr[r0 + 1] & 255) << 8) | ((bArr[r0 + 2] & 255) << 16);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final long readRawLittleEndian64() throws IOException {
            int r0 = this.pos;
            if (this.limit - r0 >= 8) {
                this.pos = r0 + 8;
                byte[] bArr = this.buffer;
                return ((bArr[r0 + 7] & 255) << 56) | (bArr[r0] & 255) | ((bArr[r0 + 1] & 255) << 8) | ((bArr[r0 + 2] & 255) << 16) | ((bArr[r0 + 3] & 255) << 24) | ((bArr[r0 + 4] & 255) << 32) | ((bArr[r0 + 5] & 255) << 40) | ((bArr[r0 + 6] & 255) << 48);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:            if (r3[r2] < 0) goto L72;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int readRawVarint32() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.pos
                int r1 = r5.limit
                if (r1 != r0) goto L7
                goto L6a
            L7:
                int r2 = r0 + 1
                byte[] r3 = r5.buffer
                r0 = r3[r0]
                if (r0 < 0) goto L12
                r5.pos = r2
                return r0
            L12:
                int r1 = r1 - r2
                r4 = 9
                if (r1 >= r4) goto L18
                goto L6a
            L18:
                int r1 = r2 + 1
                r2 = r3[r2]
                int r2 = r2 << 7
                r0 = r0 ^ r2
                if (r0 >= 0) goto L24
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L70
            L24:
                int r2 = r1 + 1
                r1 = r3[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L31
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L2f:
                r1 = r2
                goto L70
            L31:
                int r1 = r2 + 1
                r2 = r3[r2]
                int r2 = r2 << 21
                r0 = r0 ^ r2
                if (r0 >= 0) goto L3f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L70
            L3f:
                int r2 = r1 + 1
                r1 = r3[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L2f
                int r1 = r2 + 1
                r2 = r3[r2]
                if (r2 >= 0) goto L70
                int r2 = r1 + 1
                r1 = r3[r1]
                if (r1 >= 0) goto L2f
                int r1 = r2 + 1
                r2 = r3[r2]
                if (r2 >= 0) goto L70
                int r2 = r1 + 1
                r1 = r3[r1]
                if (r1 >= 0) goto L2f
                int r1 = r2 + 1
                r2 = r3[r2]
                if (r2 >= 0) goto L70
            L6a:
                long r0 = r5.readRawVarint64SlowPath()
                int r0 = (int) r0
                return r0
            L70:
                r5.pos = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.CodedInputStream.ArrayDecoder.readRawVarint32():int");
        }

        public final long readRawVarint64() throws IOException {
            long j;
            long j2;
            long j3;
            int r0;
            int r02 = this.pos;
            int r1 = this.limit;
            if (r1 != r02) {
                int r2 = r02 + 1;
                byte[] bArr = this.buffer;
                byte b = bArr[r02];
                if (b >= 0) {
                    this.pos = r2;
                    return b;
                }
                if (r1 - r2 >= 9) {
                    int r12 = r2 + 1;
                    int r03 = b ^ (bArr[r2] << 7);
                    if (r03 < 0) {
                        r0 = r03 ^ (-128);
                    } else {
                        int r22 = r12 + 1;
                        int r04 = r03 ^ (bArr[r12] << 14);
                        if (r04 >= 0) {
                            j = r04 ^ 16256;
                        } else {
                            r12 = r22 + 1;
                            int r05 = r04 ^ (bArr[r22] << 21);
                            if (r05 < 0) {
                                r0 = r05 ^ (-2080896);
                            } else {
                                long j4 = r05;
                                int r06 = r12 + 1;
                                long j5 = (bArr[r12] << 28) ^ j4;
                                if (j5 >= 0) {
                                    j2 = j5 ^ 266354560;
                                    r12 = r06;
                                } else {
                                    int r6 = r06 + 1;
                                    long j6 = j5 ^ (bArr[r06] << 35);
                                    if (j6 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        r22 = r6 + 1;
                                        long j7 = j6 ^ (bArr[r6] << 42);
                                        if (j7 >= 0) {
                                            j = j7 ^ 4363953127296L;
                                        } else {
                                            r6 = r22 + 1;
                                            j6 = j7 ^ (bArr[r22] << 49);
                                            if (j6 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                r22 = r6 + 1;
                                                j = (j6 ^ (bArr[r6] << 56)) ^ 71499008037633920L;
                                                if (j < 0) {
                                                    r6 = r22 + 1;
                                                    if (bArr[r22] >= 0) {
                                                        j2 = j;
                                                        r12 = r6;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j2 = j3 ^ j6;
                                    r12 = r6;
                                }
                                this.pos = r12;
                                return j2;
                            }
                        }
                        r12 = r22;
                        j2 = j;
                        this.pos = r12;
                        return j2;
                    }
                    j2 = r0;
                    this.pos = r12;
                    return j2;
                }
            }
            return readRawVarint64SlowPath();
        }

        public final long readRawVarint64SlowPath() throws IOException {
            long j = 0;
            for (int r2 = 0; r2 < 64; r2 += 7) {
                int r3 = this.pos;
                if (r3 != this.limit) {
                    this.pos = r3 + 1;
                    j |= (r3 & Byte.MAX_VALUE) << r2;
                    if ((this.buffer[r3] & 128) == 0) {
                        return j;
                    }
                } else {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int r1 = this.limit;
                int r2 = this.pos;
                if (readRawVarint32 <= r1 - r2) {
                    String str = new String(this.buffer, r2, readRawVarint32, Internal.UTF_8);
                    this.pos += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int r1 = this.limit;
                int r2 = this.pos;
                if (readRawVarint32 <= r1 - r2) {
                    String decodeUtf8 = Utf8.processor.decodeUtf8(this.buffer, r2, readRawVarint32);
                    this.pos += readRawVarint32;
                    return decodeUtf8;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if ((readRawVarint32 >>> 3) != 0) {
                return readRawVarint32;
            }
            throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public final boolean skipField(int r6) throws IOException {
            int readTag;
            int r0 = r6 & 7;
            int r1 = 0;
            if (r0 != 0) {
                if (r0 != 1) {
                    if (r0 != 2) {
                        if (r0 != 3) {
                            if (r0 == 4) {
                                return false;
                            }
                            if (r0 == 5) {
                                skipRawBytes(4);
                                return true;
                            }
                            int r62 = InvalidProtocolBufferException.$r8$clinit;
                            throw new InvalidProtocolBufferException.InvalidWireTypeException();
                        }
                        do {
                            readTag = readTag();
                            if (readTag == 0) {
                                break;
                            }
                        } while (skipField(readTag));
                        checkLastTagWas(((r6 >>> 3) << 3) | 4);
                        return true;
                    }
                    skipRawBytes(readRawVarint32());
                    return true;
                }
                skipRawBytes(8);
                return true;
            }
            int r63 = this.limit - this.pos;
            byte[] bArr = this.buffer;
            if (r63 >= 10) {
                while (r1 < 10) {
                    int r64 = this.pos;
                    this.pos = r64 + 1;
                    if (bArr[r64] < 0) {
                        r1++;
                    }
                }
                throw InvalidProtocolBufferException.malformedVarint();
            }
            while (r1 < 10) {
                int r65 = this.pos;
                if (r65 != this.limit) {
                    this.pos = r65 + 1;
                    if (bArr[r65] < 0) {
                        r1++;
                    }
                } else {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
            return true;
        }

        public final void skipRawBytes(int r3) throws IOException {
            if (r3 >= 0) {
                int r0 = this.limit;
                int r1 = this.pos;
                if (r3 <= r0 - r1) {
                    this.pos = r1 + r3;
                    return;
                }
            }
            if (r3 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public static int decodeZigZag32(int r1) {
        return (-(r1 & 1)) ^ (r1 >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public abstract void checkLastTagWas(int r1) throws InvalidProtocolBufferException;

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd() throws IOException;

    public abstract void popLimit(int r1);

    public abstract int pushLimit(int r1) throws InvalidProtocolBufferException;

    public abstract boolean readBool() throws IOException;

    public abstract ByteString.LiteralByteString readBytes() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract int readEnum() throws IOException;

    public abstract int readFixed32() throws IOException;

    public abstract long readFixed64() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract int readInt32() throws IOException;

    public abstract long readInt64() throws IOException;

    public abstract int readSFixed32() throws IOException;

    public abstract long readSFixed64() throws IOException;

    public abstract int readSInt32() throws IOException;

    public abstract long readSInt64() throws IOException;

    public abstract String readString() throws IOException;

    public abstract String readStringRequireUtf8() throws IOException;

    public abstract int readTag() throws IOException;

    public abstract int readUInt32() throws IOException;

    public abstract long readUInt64() throws IOException;

    public abstract boolean skipField(int r1) throws IOException;
}
