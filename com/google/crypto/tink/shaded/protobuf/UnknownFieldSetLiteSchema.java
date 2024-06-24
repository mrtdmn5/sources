package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final void addFixed32(int r1, int r2, Object obj) {
        ((UnknownFieldSetLite) obj).storeField((r1 << 3) | 5, Integer.valueOf(r2));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final void addFixed64(long j, int r3, Object obj) {
        ((UnknownFieldSetLite) obj).storeField((r3 << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final void addGroup(UnknownFieldSetLite unknownFieldSetLite, int r2, UnknownFieldSetLite unknownFieldSetLite2) {
        unknownFieldSetLite.storeField((r2 << 3) | 3, unknownFieldSetLite2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final void addLengthDelimited(UnknownFieldSetLite unknownFieldSetLite, int r2, ByteString byteString) {
        unknownFieldSetLite.storeField((r2 << 3) | 2, byteString);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final void addVarint(long j, int r3, Object obj) {
        ((UnknownFieldSetLite) obj).storeField((r3 << 3) | 0, Long.valueOf(j));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final UnknownFieldSetLite getBuilderFromMessage(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite == UnknownFieldSetLite.DEFAULT_INSTANCE) {
            UnknownFieldSetLite unknownFieldSetLite2 = new UnknownFieldSetLite();
            generatedMessageLite.unknownFields = unknownFieldSetLite2;
            return unknownFieldSetLite2;
        }
        return unknownFieldSetLite;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final UnknownFieldSetLite getFromMessage(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final int getSerializedSize(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSize();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final int getSerializedSizeAsMessageSet(UnknownFieldSetLite unknownFieldSetLite) {
        UnknownFieldSetLite unknownFieldSetLite2 = unknownFieldSetLite;
        int r0 = unknownFieldSetLite2.memoizedSerializedSize;
        if (r0 == -1) {
            int r1 = 0;
            for (int r02 = 0; r02 < unknownFieldSetLite2.count; r02++) {
                int r2 = unknownFieldSetLite2.tags[r02] >>> 3;
                r1 += CodedOutputStream.computeBytesSize(3, (ByteString) unknownFieldSetLite2.objects[r02]) + CodedOutputStream.computeUInt32Size(2, r2) + (CodedOutputStream.computeTagSize(1) * 2);
            }
            unknownFieldSetLite2.memoizedSerializedSize = r1;
            return r1;
        }
        return r0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final void makeImmutable(Object obj) {
        ((GeneratedMessageLite) obj).unknownFields.isMutable = false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final UnknownFieldSetLite merge(Object obj, Object obj2) {
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) obj2;
        if (!unknownFieldSetLite2.equals(UnknownFieldSetLite.DEFAULT_INSTANCE)) {
            int r0 = unknownFieldSetLite.count + unknownFieldSetLite2.count;
            int[] copyOf = Arrays.copyOf(unknownFieldSetLite.tags, r0);
            System.arraycopy(unknownFieldSetLite2.tags, 0, copyOf, unknownFieldSetLite.count, unknownFieldSetLite2.count);
            Object[] copyOf2 = Arrays.copyOf(unknownFieldSetLite.objects, r0);
            System.arraycopy(unknownFieldSetLite2.objects, 0, copyOf2, unknownFieldSetLite.count, unknownFieldSetLite2.count);
            return new UnknownFieldSetLite(r0, copyOf, copyOf2, true);
        }
        return unknownFieldSetLite;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final UnknownFieldSetLite newBuilder() {
        return new UnknownFieldSetLite();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final void setBuilderToMessage(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        ((GeneratedMessageLite) obj).unknownFields = unknownFieldSetLite;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final void setToMessage(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        ((GeneratedMessageLite) obj).unknownFields = unknownFieldSetLite;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final UnknownFieldSetLite toImmutable(Object obj) {
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        unknownFieldSetLite.isMutable = false;
        return unknownFieldSetLite;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final void writeAsMessageSetTo(Object obj, CodedOutputStreamWriter codedOutputStreamWriter) throws IOException {
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        unknownFieldSetLite.getClass();
        codedOutputStreamWriter.getClass();
        if (Writer$FieldOrder.ASCENDING == Writer$FieldOrder.DESCENDING) {
            int r0 = unknownFieldSetLite.count;
            while (true) {
                r0--;
                if (r0 >= 0) {
                    codedOutputStreamWriter.writeMessageSetItem(unknownFieldSetLite.tags[r0] >>> 3, unknownFieldSetLite.objects[r0]);
                } else {
                    return;
                }
            }
        } else {
            for (int r02 = 0; r02 < unknownFieldSetLite.count; r02++) {
                codedOutputStreamWriter.writeMessageSetItem(unknownFieldSetLite.tags[r02] >>> 3, unknownFieldSetLite.objects[r02]);
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final void writeTo(Object obj, CodedOutputStreamWriter codedOutputStreamWriter) throws IOException {
        ((UnknownFieldSetLite) obj).writeTo(codedOutputStreamWriter);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema
    public final void shouldDiscardUnknownFields() {
    }
}
