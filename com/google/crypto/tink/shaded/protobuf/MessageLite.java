package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    /* loaded from: classes3.dex */
    public interface Builder extends MessageLiteOrBuilder, Cloneable {
    }

    int getSerializedSize();

    GeneratedMessageLite.Builder newBuilderForType$1();

    GeneratedMessageLite.Builder toBuilder$1();

    byte[] toByteArray();

    ByteString.LiteralByteString toByteString();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
