package com.google.crypto.tink.shaded.protobuf;

import com.amazonaws.services.s3.internal.Constants;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class Internal {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Charset UTF_8 = Charset.forName(Constants.DEFAULT_ENCODING);

    /* loaded from: classes3.dex */
    public interface EnumLite {
        int getNumber();
    }

    /* loaded from: classes3.dex */
    public interface EnumLiteMap<T extends EnumLite> {
    }

    /* loaded from: classes3.dex */
    public interface EnumVerifier {
        boolean isInRange(int r1);
    }

    /* loaded from: classes3.dex */
    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int r1);
    }

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        ByteBuffer.wrap(bArr);
        try {
            new CodedInputStream.ArrayDecoder(bArr, 0, 0, false).pushLimit(0);
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int hashLong(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static GeneratedMessageLite mergeMessage(Object obj, Object obj2) {
        GeneratedMessageLite.Builder builder$1 = ((MessageLite) obj).toBuilder$1();
        MessageLite messageLite = (MessageLite) obj2;
        builder$1.getClass();
        if (builder$1.defaultInstance.getClass().isInstance(messageLite)) {
            builder$1.copyOnWrite();
            GeneratedMessageLite.Builder.mergeFromInstance(builder$1.instance, (GeneratedMessageLite) ((AbstractMessageLite) messageLite));
            return builder$1.buildPartial();
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
