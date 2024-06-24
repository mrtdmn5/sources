package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class UnknownFieldSchema<T, B> {
    public abstract void addFixed32(int r1, int r2, Object obj);

    public abstract void addFixed64(long j, int r3, Object obj);

    public abstract void addGroup(B b, int r2, T t);

    public abstract void addLengthDelimited(B b, int r2, ByteString byteString);

    public abstract void addVarint(long j, int r3, Object obj);

    public abstract UnknownFieldSetLite getBuilderFromMessage(Object obj);

    public abstract UnknownFieldSetLite getFromMessage(Object obj);

    public abstract int getSerializedSize(T t);

    public abstract int getSerializedSizeAsMessageSet(T t);

    public abstract void makeImmutable(Object obj);

    public abstract UnknownFieldSetLite merge(Object obj, Object obj2);

    public final boolean mergeOneFieldFrom(B b, Reader reader) throws IOException {
        int tag = reader.getTag();
        int r1 = tag >>> 3;
        int r0 = tag & 7;
        if (r0 != 0) {
            if (r0 != 1) {
                if (r0 != 2) {
                    if (r0 != 3) {
                        if (r0 != 4) {
                            if (r0 == 5) {
                                addFixed32(r1, reader.readFixed32(), b);
                                return true;
                            }
                            int r7 = InvalidProtocolBufferException.$r8$clinit;
                            throw new InvalidProtocolBufferException.InvalidWireTypeException();
                        }
                        return false;
                    }
                    UnknownFieldSetLite newBuilder = newBuilder();
                    int r3 = (r1 << 3) | 4;
                    while (reader.getFieldNumber() != Integer.MAX_VALUE && mergeOneFieldFrom(newBuilder, reader)) {
                    }
                    if (r3 == reader.getTag()) {
                        addGroup(b, r1, toImmutable(newBuilder));
                        return true;
                    }
                    throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
                }
                addLengthDelimited(b, r1, reader.readBytes());
                return true;
            }
            addFixed64(reader.readFixed64(), r1, b);
            return true;
        }
        addVarint(reader.readInt64(), r1, b);
        return true;
    }

    public abstract UnknownFieldSetLite newBuilder();

    public abstract void setBuilderToMessage(Object obj, B b);

    public abstract void setToMessage(Object obj, T t);

    public abstract void shouldDiscardUnknownFields();

    public abstract UnknownFieldSetLite toImmutable(Object obj);

    public abstract void writeAsMessageSetTo(Object obj, CodedOutputStreamWriter codedOutputStreamWriter) throws IOException;

    public abstract void writeTo(Object obj, CodedOutputStreamWriter codedOutputStreamWriter) throws IOException;
}
