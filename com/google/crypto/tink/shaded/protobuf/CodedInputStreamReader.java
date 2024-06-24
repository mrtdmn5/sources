package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/* loaded from: classes3.dex */
public final class CodedInputStreamReader implements Reader {
    public int endGroupTag;
    public final CodedInputStream input;
    public int nextTag = 0;
    public int tag;

    public CodedInputStreamReader(CodedInputStream codedInputStream) {
        Charset charset = Internal.UTF_8;
        if (codedInputStream != null) {
            this.input = codedInputStream;
            codedInputStream.wrapper = this;
            return;
        }
        throw new NullPointerException("input");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int getFieldNumber() throws IOException {
        int r0 = this.nextTag;
        if (r0 != 0) {
            this.tag = r0;
            this.nextTag = 0;
        } else {
            this.tag = this.input.readTag();
        }
        int r02 = this.tag;
        if (r02 != 0 && r02 != this.endGroupTag) {
            return r02 >>> 3;
        }
        return Integer.MAX_VALUE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final boolean readBool() throws IOException {
        requireWireType(0);
        return this.input.readBool();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readBoolList(List<Boolean> list) throws IOException {
        int readTag;
        int readTag2;
        boolean z = list instanceof BooleanArrayList;
        CodedInputStream codedInputStream = this.input;
        if (z) {
            BooleanArrayList booleanArrayList = (BooleanArrayList) list;
            int r4 = this.tag & 7;
            if (r4 != 0) {
                if (r4 == 2) {
                    int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                    do {
                        booleanArrayList.addBoolean(codedInputStream.readBool());
                    } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
                    requirePosition(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                booleanArrayList.addBoolean(codedInputStream.readBool());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    readTag2 = codedInputStream.readTag();
                }
            } while (readTag2 == this.tag);
            this.nextTag = readTag2;
            return;
        }
        int r0 = this.tag & 7;
        if (r0 != 0) {
            if (r0 == 2) {
                int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                do {
                    list.add(Boolean.valueOf(codedInputStream.readBool()));
                } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Boolean.valueOf(codedInputStream.readBool()));
            if (codedInputStream.isAtEnd()) {
                return;
            } else {
                readTag = codedInputStream.readTag();
            }
        } while (readTag == this.tag);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final ByteString readBytes() throws IOException {
        requireWireType(2);
        return this.input.readBytes();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readBytesList(List<ByteString> list) throws IOException {
        int readTag;
        if ((this.tag & 7) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(readBytes());
            CodedInputStream codedInputStream = this.input;
            if (codedInputStream.isAtEnd()) {
                return;
            } else {
                readTag = codedInputStream.readTag();
            }
        } while (readTag == this.tag);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final double readDouble() throws IOException {
        requireWireType(1);
        return this.input.readDouble();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readDoubleList(List<Double> list) throws IOException {
        int readTag;
        int readTag2;
        boolean z = list instanceof DoubleArrayList;
        CodedInputStream codedInputStream = this.input;
        if (z) {
            DoubleArrayList doubleArrayList = (DoubleArrayList) list;
            int r7 = this.tag & 7;
            if (r7 != 1) {
                if (r7 == 2) {
                    int readUInt32 = codedInputStream.readUInt32();
                    verifyPackedFixed64Length(readUInt32);
                    int totalBytesRead = codedInputStream.getTotalBytesRead() + readUInt32;
                    do {
                        doubleArrayList.addDouble(codedInputStream.readDouble());
                    } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                doubleArrayList.addDouble(codedInputStream.readDouble());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    readTag2 = codedInputStream.readTag();
                }
            } while (readTag2 == this.tag);
            this.nextTag = readTag2;
            return;
        }
        int r0 = this.tag & 7;
        if (r0 != 1) {
            if (r0 == 2) {
                int readUInt322 = codedInputStream.readUInt32();
                verifyPackedFixed64Length(readUInt322);
                int totalBytesRead2 = codedInputStream.getTotalBytesRead() + readUInt322;
                do {
                    list.add(Double.valueOf(codedInputStream.readDouble()));
                } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Double.valueOf(codedInputStream.readDouble()));
            if (codedInputStream.isAtEnd()) {
                return;
            } else {
                readTag = codedInputStream.readTag();
            }
        } while (readTag == this.tag);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int readEnum() throws IOException {
        requireWireType(0);
        return this.input.readEnum();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readEnumList(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        boolean z = list instanceof IntArrayList;
        CodedInputStream codedInputStream = this.input;
        if (z) {
            IntArrayList intArrayList = (IntArrayList) list;
            int r4 = this.tag & 7;
            if (r4 != 0) {
                if (r4 == 2) {
                    int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                    do {
                        intArrayList.addInt(codedInputStream.readEnum());
                    } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
                    requirePosition(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                intArrayList.addInt(codedInputStream.readEnum());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    readTag2 = codedInputStream.readTag();
                }
            } while (readTag2 == this.tag);
            this.nextTag = readTag2;
            return;
        }
        int r0 = this.tag & 7;
        if (r0 != 0) {
            if (r0 == 2) {
                int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                do {
                    list.add(Integer.valueOf(codedInputStream.readEnum()));
                } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Integer.valueOf(codedInputStream.readEnum()));
            if (codedInputStream.isAtEnd()) {
                return;
            } else {
                readTag = codedInputStream.readTag();
            }
        } while (readTag == this.tag);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int readFixed32() throws IOException {
        requireWireType(5);
        return this.input.readFixed32();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readFixed32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        boolean z = list instanceof IntArrayList;
        CodedInputStream codedInputStream = this.input;
        if (z) {
            IntArrayList intArrayList = (IntArrayList) list;
            int r6 = this.tag & 7;
            if (r6 != 2) {
                if (r6 != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    intArrayList.addInt(codedInputStream.readFixed32());
                    if (codedInputStream.isAtEnd()) {
                        return;
                    } else {
                        readTag2 = codedInputStream.readTag();
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
                return;
            }
            int readUInt32 = codedInputStream.readUInt32();
            verifyPackedFixed32Length(readUInt32);
            int totalBytesRead = codedInputStream.getTotalBytesRead() + readUInt32;
            do {
                intArrayList.addInt(codedInputStream.readFixed32());
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
            return;
        }
        int r0 = this.tag & 7;
        if (r0 != 2) {
            if (r0 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(codedInputStream.readFixed32()));
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    readTag = codedInputStream.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        int readUInt322 = codedInputStream.readUInt32();
        verifyPackedFixed32Length(readUInt322);
        int totalBytesRead2 = codedInputStream.getTotalBytesRead() + readUInt322;
        do {
            list.add(Integer.valueOf(codedInputStream.readFixed32()));
        } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final long readFixed64() throws IOException {
        requireWireType(1);
        return this.input.readFixed64();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readFixed64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        boolean z = list instanceof LongArrayList;
        CodedInputStream codedInputStream = this.input;
        if (z) {
            LongArrayList longArrayList = (LongArrayList) list;
            int r7 = this.tag & 7;
            if (r7 != 1) {
                if (r7 == 2) {
                    int readUInt32 = codedInputStream.readUInt32();
                    verifyPackedFixed64Length(readUInt32);
                    int totalBytesRead = codedInputStream.getTotalBytesRead() + readUInt32;
                    do {
                        longArrayList.addLong(codedInputStream.readFixed64());
                    } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                longArrayList.addLong(codedInputStream.readFixed64());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    readTag2 = codedInputStream.readTag();
                }
            } while (readTag2 == this.tag);
            this.nextTag = readTag2;
            return;
        }
        int r0 = this.tag & 7;
        if (r0 != 1) {
            if (r0 == 2) {
                int readUInt322 = codedInputStream.readUInt32();
                verifyPackedFixed64Length(readUInt322);
                int totalBytesRead2 = codedInputStream.getTotalBytesRead() + readUInt322;
                do {
                    list.add(Long.valueOf(codedInputStream.readFixed64()));
                } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Long.valueOf(codedInputStream.readFixed64()));
            if (codedInputStream.isAtEnd()) {
                return;
            } else {
                readTag = codedInputStream.readTag();
            }
        } while (readTag == this.tag);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final float readFloat() throws IOException {
        requireWireType(5);
        return this.input.readFloat();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readFloatList(List<Float> list) throws IOException {
        int readTag;
        int readTag2;
        boolean z = list instanceof FloatArrayList;
        CodedInputStream codedInputStream = this.input;
        if (z) {
            FloatArrayList floatArrayList = (FloatArrayList) list;
            int r6 = this.tag & 7;
            if (r6 != 2) {
                if (r6 != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    floatArrayList.addFloat(codedInputStream.readFloat());
                    if (codedInputStream.isAtEnd()) {
                        return;
                    } else {
                        readTag2 = codedInputStream.readTag();
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
                return;
            }
            int readUInt32 = codedInputStream.readUInt32();
            verifyPackedFixed32Length(readUInt32);
            int totalBytesRead = codedInputStream.getTotalBytesRead() + readUInt32;
            do {
                floatArrayList.addFloat(codedInputStream.readFloat());
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
            return;
        }
        int r0 = this.tag & 7;
        if (r0 != 2) {
            if (r0 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Float.valueOf(codedInputStream.readFloat()));
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    readTag = codedInputStream.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        int readUInt322 = codedInputStream.readUInt32();
        verifyPackedFixed32Length(readUInt322);
        int totalBytesRead2 = codedInputStream.getTotalBytesRead() + readUInt322;
        do {
            list.add(Float.valueOf(codedInputStream.readFloat()));
        } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
    }

    public final <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int r0 = this.endGroupTag;
        this.endGroupTag = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = schema.newInstance();
            schema.mergeFrom(newInstance, this, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            if (this.tag == this.endGroupTag) {
                return newInstance;
            }
            throw InvalidProtocolBufferException.parseFailure();
        } finally {
            this.endGroupTag = r0;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final <T> T readGroupBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        requireWireType(3);
        return (T) readGroup(schema, extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final <T> void readGroupList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readTag;
        int r0 = this.tag;
        if ((r0 & 7) != 3) {
            int r4 = InvalidProtocolBufferException.$r8$clinit;
            throw new InvalidProtocolBufferException.InvalidWireTypeException();
        }
        do {
            list.add(readGroup(schema, extensionRegistryLite));
            CodedInputStream codedInputStream = this.input;
            if (!codedInputStream.isAtEnd() && this.nextTag == 0) {
                readTag = codedInputStream.readTag();
            } else {
                return;
            }
        } while (readTag == r0);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int readInt32() throws IOException {
        requireWireType(0);
        return this.input.readInt32();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readInt32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        boolean z = list instanceof IntArrayList;
        CodedInputStream codedInputStream = this.input;
        if (z) {
            IntArrayList intArrayList = (IntArrayList) list;
            int r4 = this.tag & 7;
            if (r4 != 0) {
                if (r4 == 2) {
                    int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                    do {
                        intArrayList.addInt(codedInputStream.readInt32());
                    } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
                    requirePosition(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                intArrayList.addInt(codedInputStream.readInt32());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    readTag2 = codedInputStream.readTag();
                }
            } while (readTag2 == this.tag);
            this.nextTag = readTag2;
            return;
        }
        int r0 = this.tag & 7;
        if (r0 != 0) {
            if (r0 == 2) {
                int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                do {
                    list.add(Integer.valueOf(codedInputStream.readInt32()));
                } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Integer.valueOf(codedInputStream.readInt32()));
            if (codedInputStream.isAtEnd()) {
                return;
            } else {
                readTag = codedInputStream.readTag();
            }
        } while (readTag == this.tag);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final long readInt64() throws IOException {
        requireWireType(0);
        return this.input.readInt64();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readInt64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        boolean z = list instanceof LongArrayList;
        CodedInputStream codedInputStream = this.input;
        if (z) {
            LongArrayList longArrayList = (LongArrayList) list;
            int r6 = this.tag & 7;
            if (r6 != 0) {
                if (r6 == 2) {
                    int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                    do {
                        longArrayList.addLong(codedInputStream.readInt64());
                    } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
                    requirePosition(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                longArrayList.addLong(codedInputStream.readInt64());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    readTag2 = codedInputStream.readTag();
                }
            } while (readTag2 == this.tag);
            this.nextTag = readTag2;
            return;
        }
        int r0 = this.tag & 7;
        if (r0 != 0) {
            if (r0 == 2) {
                int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                do {
                    list.add(Long.valueOf(codedInputStream.readInt64()));
                } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Long.valueOf(codedInputStream.readInt64()));
            if (codedInputStream.isAtEnd()) {
                return;
            } else {
                readTag = codedInputStream.readTag();
            }
        } while (readTag == this.tag);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readMap() throws IOException {
        requireWireType(2);
        CodedInputStream codedInputStream = this.input;
        codedInputStream.pushLimit(codedInputStream.readUInt32());
        throw null;
    }

    public final <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = this.input;
        int readUInt32 = codedInputStream.readUInt32();
        if (codedInputStream.recursionDepth < codedInputStream.recursionLimit) {
            int pushLimit = codedInputStream.pushLimit(readUInt32);
            T newInstance = schema.newInstance();
            codedInputStream.recursionDepth++;
            schema.mergeFrom(newInstance, this, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            codedInputStream.checkLastTagWas(0);
            codedInputStream.recursionDepth--;
            codedInputStream.popLimit(pushLimit);
            return newInstance;
        }
        throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final <T> T readMessageBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        requireWireType(2);
        return (T) readMessage(schema, extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final <T> void readMessageList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readTag;
        int r0 = this.tag;
        if ((r0 & 7) != 2) {
            int r4 = InvalidProtocolBufferException.$r8$clinit;
            throw new InvalidProtocolBufferException.InvalidWireTypeException();
        }
        do {
            list.add(readMessage(schema, extensionRegistryLite));
            CodedInputStream codedInputStream = this.input;
            if (!codedInputStream.isAtEnd() && this.nextTag == 0) {
                readTag = codedInputStream.readTag();
            } else {
                return;
            }
        } while (readTag == r0);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int readSFixed32() throws IOException {
        requireWireType(5);
        return this.input.readSFixed32();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readSFixed32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        boolean z = list instanceof IntArrayList;
        CodedInputStream codedInputStream = this.input;
        if (z) {
            IntArrayList intArrayList = (IntArrayList) list;
            int r6 = this.tag & 7;
            if (r6 != 2) {
                if (r6 != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    intArrayList.addInt(codedInputStream.readSFixed32());
                    if (codedInputStream.isAtEnd()) {
                        return;
                    } else {
                        readTag2 = codedInputStream.readTag();
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
                return;
            }
            int readUInt32 = codedInputStream.readUInt32();
            verifyPackedFixed32Length(readUInt32);
            int totalBytesRead = codedInputStream.getTotalBytesRead() + readUInt32;
            do {
                intArrayList.addInt(codedInputStream.readSFixed32());
            } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
            return;
        }
        int r0 = this.tag & 7;
        if (r0 != 2) {
            if (r0 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(codedInputStream.readSFixed32()));
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    readTag = codedInputStream.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        int readUInt322 = codedInputStream.readUInt32();
        verifyPackedFixed32Length(readUInt322);
        int totalBytesRead2 = codedInputStream.getTotalBytesRead() + readUInt322;
        do {
            list.add(Integer.valueOf(codedInputStream.readSFixed32()));
        } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final long readSFixed64() throws IOException {
        requireWireType(1);
        return this.input.readSFixed64();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readSFixed64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        boolean z = list instanceof LongArrayList;
        CodedInputStream codedInputStream = this.input;
        if (z) {
            LongArrayList longArrayList = (LongArrayList) list;
            int r7 = this.tag & 7;
            if (r7 != 1) {
                if (r7 == 2) {
                    int readUInt32 = codedInputStream.readUInt32();
                    verifyPackedFixed64Length(readUInt32);
                    int totalBytesRead = codedInputStream.getTotalBytesRead() + readUInt32;
                    do {
                        longArrayList.addLong(codedInputStream.readSFixed64());
                    } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                longArrayList.addLong(codedInputStream.readSFixed64());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    readTag2 = codedInputStream.readTag();
                }
            } while (readTag2 == this.tag);
            this.nextTag = readTag2;
            return;
        }
        int r0 = this.tag & 7;
        if (r0 != 1) {
            if (r0 == 2) {
                int readUInt322 = codedInputStream.readUInt32();
                verifyPackedFixed64Length(readUInt322);
                int totalBytesRead2 = codedInputStream.getTotalBytesRead() + readUInt322;
                do {
                    list.add(Long.valueOf(codedInputStream.readSFixed64()));
                } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Long.valueOf(codedInputStream.readSFixed64()));
            if (codedInputStream.isAtEnd()) {
                return;
            } else {
                readTag = codedInputStream.readTag();
            }
        } while (readTag == this.tag);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int readSInt32() throws IOException {
        requireWireType(0);
        return this.input.readSInt32();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readSInt32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        boolean z = list instanceof IntArrayList;
        CodedInputStream codedInputStream = this.input;
        if (z) {
            IntArrayList intArrayList = (IntArrayList) list;
            int r4 = this.tag & 7;
            if (r4 != 0) {
                if (r4 == 2) {
                    int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                    do {
                        intArrayList.addInt(codedInputStream.readSInt32());
                    } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
                    requirePosition(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                intArrayList.addInt(codedInputStream.readSInt32());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    readTag2 = codedInputStream.readTag();
                }
            } while (readTag2 == this.tag);
            this.nextTag = readTag2;
            return;
        }
        int r0 = this.tag & 7;
        if (r0 != 0) {
            if (r0 == 2) {
                int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                do {
                    list.add(Integer.valueOf(codedInputStream.readSInt32()));
                } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Integer.valueOf(codedInputStream.readSInt32()));
            if (codedInputStream.isAtEnd()) {
                return;
            } else {
                readTag = codedInputStream.readTag();
            }
        } while (readTag == this.tag);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final long readSInt64() throws IOException {
        requireWireType(0);
        return this.input.readSInt64();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readSInt64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        boolean z = list instanceof LongArrayList;
        CodedInputStream codedInputStream = this.input;
        if (z) {
            LongArrayList longArrayList = (LongArrayList) list;
            int r6 = this.tag & 7;
            if (r6 != 0) {
                if (r6 == 2) {
                    int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                    do {
                        longArrayList.addLong(codedInputStream.readSInt64());
                    } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
                    requirePosition(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                longArrayList.addLong(codedInputStream.readSInt64());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    readTag2 = codedInputStream.readTag();
                }
            } while (readTag2 == this.tag);
            this.nextTag = readTag2;
            return;
        }
        int r0 = this.tag & 7;
        if (r0 != 0) {
            if (r0 == 2) {
                int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                do {
                    list.add(Long.valueOf(codedInputStream.readSInt64()));
                } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Long.valueOf(codedInputStream.readSInt64()));
            if (codedInputStream.isAtEnd()) {
                return;
            } else {
                readTag = codedInputStream.readTag();
            }
        } while (readTag == this.tag);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final String readString() throws IOException {
        requireWireType(2);
        return this.input.readString();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readStringList(List<String> list) throws IOException {
        readStringListInternal(list, false);
    }

    public final void readStringListInternal(List<String> list, boolean z) throws IOException {
        String readString;
        int readTag;
        int readTag2;
        if ((this.tag & 7) == 2) {
            boolean z2 = list instanceof LazyStringList;
            CodedInputStream codedInputStream = this.input;
            if (z2 && !z) {
                LazyStringList lazyStringList = (LazyStringList) list;
                do {
                    lazyStringList.add(readBytes());
                    if (codedInputStream.isAtEnd()) {
                        return;
                    } else {
                        readTag2 = codedInputStream.readTag();
                    }
                } while (readTag2 == this.tag);
                this.nextTag = readTag2;
                return;
            }
            do {
                if (z) {
                    readString = readStringRequireUtf8();
                } else {
                    readString = readString();
                }
                list.add(readString);
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    readTag = codedInputStream.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readStringListRequireUtf8(List<String> list) throws IOException {
        readStringListInternal(list, true);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final String readStringRequireUtf8() throws IOException {
        requireWireType(2);
        return this.input.readStringRequireUtf8();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final int readUInt32() throws IOException {
        requireWireType(0);
        return this.input.readUInt32();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readUInt32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        boolean z = list instanceof IntArrayList;
        CodedInputStream codedInputStream = this.input;
        if (z) {
            IntArrayList intArrayList = (IntArrayList) list;
            int r4 = this.tag & 7;
            if (r4 != 0) {
                if (r4 == 2) {
                    int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                    do {
                        intArrayList.addInt(codedInputStream.readUInt32());
                    } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
                    requirePosition(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                intArrayList.addInt(codedInputStream.readUInt32());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    readTag2 = codedInputStream.readTag();
                }
            } while (readTag2 == this.tag);
            this.nextTag = readTag2;
            return;
        }
        int r0 = this.tag & 7;
        if (r0 != 0) {
            if (r0 == 2) {
                int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                do {
                    list.add(Integer.valueOf(codedInputStream.readUInt32()));
                } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Integer.valueOf(codedInputStream.readUInt32()));
            if (codedInputStream.isAtEnd()) {
                return;
            } else {
                readTag = codedInputStream.readTag();
            }
        } while (readTag == this.tag);
        this.nextTag = readTag;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final long readUInt64() throws IOException {
        requireWireType(0);
        return this.input.readUInt64();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final void readUInt64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        boolean z = list instanceof LongArrayList;
        CodedInputStream codedInputStream = this.input;
        if (z) {
            LongArrayList longArrayList = (LongArrayList) list;
            int r6 = this.tag & 7;
            if (r6 != 0) {
                if (r6 == 2) {
                    int totalBytesRead = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                    do {
                        longArrayList.addLong(codedInputStream.readUInt64());
                    } while (codedInputStream.getTotalBytesRead() < totalBytesRead);
                    requirePosition(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                longArrayList.addLong(codedInputStream.readUInt64());
                if (codedInputStream.isAtEnd()) {
                    return;
                } else {
                    readTag2 = codedInputStream.readTag();
                }
            } while (readTag2 == this.tag);
            this.nextTag = readTag2;
            return;
        }
        int r0 = this.tag & 7;
        if (r0 != 0) {
            if (r0 == 2) {
                int totalBytesRead2 = codedInputStream.getTotalBytesRead() + codedInputStream.readUInt32();
                do {
                    list.add(Long.valueOf(codedInputStream.readUInt64()));
                } while (codedInputStream.getTotalBytesRead() < totalBytesRead2);
                requirePosition(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Long.valueOf(codedInputStream.readUInt64()));
            if (codedInputStream.isAtEnd()) {
                return;
            } else {
                readTag = codedInputStream.readTag();
            }
        } while (readTag == this.tag);
        this.nextTag = readTag;
    }

    public final void requirePosition(int r2) throws IOException {
        if (this.input.getTotalBytesRead() == r2) {
        } else {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public final void requireWireType(int r2) throws IOException {
        if ((this.tag & 7) == r2) {
        } else {
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Reader
    public final boolean skipField() throws IOException {
        int r1;
        CodedInputStream codedInputStream = this.input;
        if (!codedInputStream.isAtEnd() && (r1 = this.tag) != this.endGroupTag) {
            return codedInputStream.skipField(r1);
        }
        return false;
    }

    public final void verifyPackedFixed32Length(int r1) throws IOException {
        if ((r1 & 3) == 0) {
        } else {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    public final void verifyPackedFixed64Length(int r1) throws IOException {
        if ((r1 & 7) == 0) {
        } else {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }
}
