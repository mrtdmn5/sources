package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.LazyField;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class MessageSetSchema<T> implements Schema<T> {
    public final MessageLite defaultInstance;
    public final ExtensionSchema<?> extensionSchema;
    public final boolean hasExtensions;
    public final UnknownFieldSchema<?, ?> unknownFieldSchema;

    public MessageSetSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite messageLite) {
        this.unknownFieldSchema = unknownFieldSchema;
        this.hasExtensions = extensionSchema.hasExtensions(messageLite);
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final boolean equals(T t, T t2) {
        UnknownFieldSchema<?, ?> unknownFieldSchema = this.unknownFieldSchema;
        if (!unknownFieldSchema.getFromMessage(t).equals(unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            ExtensionSchema<?> extensionSchema = this.extensionSchema;
            return extensionSchema.getExtensions(t).equals(extensionSchema.getExtensions(t2));
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final int getSerializedSize(T t) {
        SmallSortedMap<?, Object> smallSortedMap;
        UnknownFieldSchema<?, ?> unknownFieldSchema = this.unknownFieldSchema;
        int r1 = 0;
        int serializedSizeAsMessageSet = unknownFieldSchema.getSerializedSizeAsMessageSet(unknownFieldSchema.getFromMessage(t)) + 0;
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(t);
            int r2 = 0;
            while (true) {
                smallSortedMap = extensions.fields;
                if (r1 >= smallSortedMap.getNumArrayEntries()) {
                    break;
                }
                r2 += FieldSet.getMessageSetSerializedSize(smallSortedMap.getArrayEntryAt(r1));
                r1++;
            }
            Iterator<Map.Entry<?, Object>> it = smallSortedMap.getOverflowEntries().iterator();
            while (it.hasNext()) {
                r2 += FieldSet.getMessageSetSerializedSize(it.next());
            }
            return serializedSizeAsMessageSet + r2;
        }
        return serializedSizeAsMessageSet;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final int hashCode(T t) {
        int hashCode = this.unknownFieldSchema.getFromMessage(t).hashCode();
        if (this.hasExtensions) {
            return (hashCode * 53) + this.extensionSchema.getExtensions(t).hashCode();
        }
        return hashCode;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final boolean isInitialized(T t) {
        return this.extensionSchema.getExtensions(t).isInitialized();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final void makeImmutable(T t) {
        this.unknownFieldSchema.makeImmutable(t);
        this.extensionSchema.makeImmutable(t);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final void mergeFrom(T t, T t2) {
        Class<?> cls = SchemaUtil.GENERATED_MESSAGE_CLASS;
        UnknownFieldSchema<?, ?> unknownFieldSchema = this.unknownFieldSchema;
        unknownFieldSchema.setToMessage(t, unknownFieldSchema.merge(unknownFieldSchema.getFromMessage(t), unknownFieldSchema.getFromMessage(t2)));
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final T newInstance() {
        return (T) this.defaultInstance.newBuilderForType$1().buildPartial();
    }

    public final <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(Reader reader, ExtensionRegistryLite extensionRegistryLite, ExtensionSchema<ET> extensionSchema, FieldSet<ET> fieldSet, UnknownFieldSchema<UT, UB> unknownFieldSchema, UB ub) throws IOException {
        int tag = reader.getTag();
        MessageLite messageLite = this.defaultInstance;
        if (tag != 11) {
            if ((tag & 7) == 2) {
                GeneratedMessageLite.GeneratedExtension findExtensionByNumber = extensionSchema.findExtensionByNumber(extensionRegistryLite, messageLite, tag >>> 3);
                if (findExtensionByNumber != null) {
                    extensionSchema.parseLengthPrefixedMessageSetItem(findExtensionByNumber);
                    return true;
                }
                return unknownFieldSchema.mergeOneFieldFrom(ub, reader);
            }
            return reader.skipField();
        }
        GeneratedMessageLite.GeneratedExtension generatedExtension = null;
        int r3 = 0;
        ByteString byteString = null;
        while (reader.getFieldNumber() != Integer.MAX_VALUE) {
            int tag2 = reader.getTag();
            if (tag2 == 16) {
                r3 = reader.readUInt32();
                generatedExtension = extensionSchema.findExtensionByNumber(extensionRegistryLite, messageLite, r3);
            } else if (tag2 == 26) {
                if (generatedExtension != null) {
                    extensionSchema.parseLengthPrefixedMessageSetItem(generatedExtension);
                } else {
                    byteString = reader.readBytes();
                }
            } else if (!reader.skipField()) {
                break;
            }
        }
        if (reader.getTag() == 12) {
            if (byteString != null) {
                if (generatedExtension != null) {
                    extensionSchema.parseMessageSetItem(generatedExtension);
                } else {
                    unknownFieldSchema.addLengthDelimited(ub, r3, byteString);
                }
            }
            return true;
        }
        throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final void writeTo(Object obj, CodedOutputStreamWriter codedOutputStreamWriter) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.extensionSchema.getExtensions(obj).iterator();
        while (it.hasNext()) {
            Map.Entry<?, Object> next = it.next();
            FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite) next.getKey();
            if (fieldDescriptorLite.getLiteJavaType() == WireFormat$JavaType.MESSAGE) {
                fieldDescriptorLite.isRepeated();
                fieldDescriptorLite.isPacked();
                if (next instanceof LazyField.LazyEntry) {
                    fieldDescriptorLite.getNumber();
                    codedOutputStreamWriter.writeMessageSetItem(0, ((LazyField.LazyEntry) next).entry.getValue().toByteString());
                } else {
                    fieldDescriptorLite.getNumber();
                    codedOutputStreamWriter.writeMessageSetItem(0, next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        UnknownFieldSchema<?, ?> unknownFieldSchema = this.unknownFieldSchema;
        unknownFieldSchema.writeAsMessageSetTo(unknownFieldSchema.getFromMessage(obj), codedOutputStreamWriter);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ad, code lost:            if (r5 == null) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00af, code lost:            r10.storeField((r1 << 3) | 2, r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b6, code lost:            r1 = r3;        r11 = r4;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ad A[EDGE_INSN: B:33:0x00ad->B:34:0x00ad BREAK  A[LOOP:1: B:13:0x0064->B:23:0x00a9], SYNTHETIC] */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mergeFrom(T r18, byte[] r19, int r20, int r21, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSetSchema.mergeFrom(java.lang.Object, byte[], int, int, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):void");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        UnknownFieldSchema unknownFieldSchema = this.unknownFieldSchema;
        UnknownFieldSetLite builderFromMessage = unknownFieldSchema.getBuilderFromMessage(t);
        ExtensionSchema extensionSchema = this.extensionSchema;
        FieldSet<ET> mutableExtensions = extensionSchema.getMutableExtensions(t);
        do {
            try {
                if (reader.getFieldNumber() == Integer.MAX_VALUE) {
                    break;
                }
            } finally {
                unknownFieldSchema.setBuilderToMessage(t, builderFromMessage);
            }
        } while (parseMessageSetItemOrUnknownField(reader, extensionRegistryLite, extensionSchema, mutableExtensions, unknownFieldSchema, builderFromMessage));
    }
}
