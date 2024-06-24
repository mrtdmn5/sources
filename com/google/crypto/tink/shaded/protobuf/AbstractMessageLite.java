package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite;
import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedOutputStream;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.IOException;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode = 0;

    /* loaded from: classes3.dex */
    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {
    }

    public int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    public final String getSerializingExceptionMessage(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public void setMemoizedSerializedSize(int r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final byte[] toByteArray() {
        try {
            GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) this;
            int serializedSize = generatedMessageLite.getSerializedSize();
            byte[] bArr = new byte[serializedSize];
            Logger logger = CodedOutputStream.logger;
            CodedOutputStream.ArrayEncoder arrayEncoder = new CodedOutputStream.ArrayEncoder(bArr, serializedSize);
            generatedMessageLite.writeTo(arrayEncoder);
            if (arrayEncoder.spaceLeft() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final ByteString.LiteralByteString toByteString() {
        try {
            GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) this;
            int serializedSize = generatedMessageLite.getSerializedSize();
            ByteString.LiteralByteString literalByteString = ByteString.EMPTY;
            byte[] bArr = new byte[serializedSize];
            Logger logger = CodedOutputStream.logger;
            CodedOutputStream.ArrayEncoder arrayEncoder = new CodedOutputStream.ArrayEncoder(bArr, serializedSize);
            generatedMessageLite.writeTo(arrayEncoder);
            if (arrayEncoder.spaceLeft() == 0) {
                return new ByteString.LiteralByteString(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e);
        }
    }
}
