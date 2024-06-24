package com.google.crypto.tink.shaded.protobuf;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import com.google.crypto.tink.shaded.protobuf.ArrayDecoders;
import com.google.crypto.tink.shaded.protobuf.Internal;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
public final class MessageSchema<T> implements Schema<T> {
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();
    public final int[] buffer;
    public final int checkInitializedCount;
    public final MessageLite defaultInstance;
    public final ExtensionSchema<?> extensionSchema;
    public final boolean hasExtensions;
    public final int[] intArray;
    public final ListFieldSchema listFieldSchema;
    public final boolean lite;
    public final MapFieldSchema mapFieldSchema;
    public final int maxFieldNumber;
    public final int minFieldNumber;
    public final NewInstanceSchema newInstanceSchema;
    public final Object[] objects;
    public final boolean proto3;
    public final int repeatedFieldOffsetStart;
    public final UnknownFieldSchema<?, ?> unknownFieldSchema;
    public final boolean useCachedSizeField;

    public MessageSchema(int[] r1, Object[] objArr, int r3, int r4, MessageLite messageLite, boolean z, int[] r7, int r8, int r9, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MapFieldSchema mapFieldSchema) {
        boolean z2;
        this.buffer = r1;
        this.objects = objArr;
        this.minFieldNumber = r3;
        this.maxFieldNumber = r4;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z;
        if (extensionSchema != null && extensionSchema.hasExtensions(messageLite)) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.hasExtensions = z2;
        this.useCachedSizeField = false;
        this.intArray = r7;
        this.checkInitializedCount = r8;
        this.repeatedFieldOffsetStart = r9;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    public static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite == UnknownFieldSetLite.DEFAULT_INSTANCE) {
            UnknownFieldSetLite unknownFieldSetLite2 = new UnknownFieldSetLite();
            generatedMessageLite.unknownFields = unknownFieldSetLite2;
            return unknownFieldSetLite2;
        }
        return unknownFieldSetLite;
    }

    public static List listAt(long j, Object obj) {
        return (List) UnsafeUtil.getObject(j, obj);
    }

    public static MessageSchema newSchema(MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        ProtoSyntax protoSyntax = ProtoSyntax.PROTO2;
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0289  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> com.google.crypto.tink.shaded.protobuf.MessageSchema<T> newSchemaForRawMessageInfo(com.google.crypto.tink.shaded.protobuf.RawMessageInfo r34, com.google.crypto.tink.shaded.protobuf.NewInstanceSchema r35, com.google.crypto.tink.shaded.protobuf.ListFieldSchema r36, com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<?, ?> r37, com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r38, com.google.crypto.tink.shaded.protobuf.MapFieldSchema r39) {
        /*
            Method dump skipped, instructions count: 1027
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.newSchemaForRawMessageInfo(com.google.crypto.tink.shaded.protobuf.RawMessageInfo, com.google.crypto.tink.shaded.protobuf.NewInstanceSchema, com.google.crypto.tink.shaded.protobuf.ListFieldSchema, com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema, com.google.crypto.tink.shaded.protobuf.ExtensionSchema, com.google.crypto.tink.shaded.protobuf.MapFieldSchema):com.google.crypto.tink.shaded.protobuf.MessageSchema");
    }

    public static long offset(int r2) {
        return r2 & 1048575;
    }

    public static int oneofIntAt(long j, Object obj) {
        return ((Integer) UnsafeUtil.getObject(j, obj)).intValue();
    }

    public static long oneofLongAt(long j, Object obj) {
        return ((Long) UnsafeUtil.getObject(j, obj)).longValue();
    }

    public static Field reflectField(String str, Class cls) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Field ", str, " for ");
            m.append(cls.getName());
            m.append(" not found. Known fields are ");
            m.append(Arrays.toString(declaredFields));
            throw new RuntimeException(m.toString());
        }
    }

    public static void writeString(int r1, Object obj, CodedOutputStreamWriter codedOutputStreamWriter) throws IOException {
        if (obj instanceof String) {
            codedOutputStreamWriter.output.writeString(r1, (String) obj);
        } else {
            codedOutputStreamWriter.writeBytes(r1, (ByteString) obj);
        }
    }

    public final boolean arePresentForEquals(Object obj, int r2, Object obj2) {
        if (isFieldPresent(r2, obj) == isFieldPresent(r2, obj2)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:            if (com.google.crypto.tink.shaded.protobuf.SchemaUtil.safeEquals(com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject(r7, r11), com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject(r7, r12)) != false) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:            if (com.google.crypto.tink.shaded.protobuf.SchemaUtil.safeEquals(com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject(r7, r11), com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject(r7, r12)) != false) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0083, code lost:            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong(r7, r11) == com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong(r7, r12)) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0095, code lost:            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt(r7, r11) == com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt(r7, r12)) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a9, code lost:            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong(r7, r11) == com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong(r7, r12)) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bb, code lost:            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt(r7, r11) == com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt(r7, r12)) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cd, code lost:            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt(r7, r11) == com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt(r7, r12)) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00df, code lost:            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt(r7, r11) == com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt(r7, r12)) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f5, code lost:            if (com.google.crypto.tink.shaded.protobuf.SchemaUtil.safeEquals(com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject(r7, r11), com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject(r7, r12)) != false) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x010b, code lost:            if (com.google.crypto.tink.shaded.protobuf.SchemaUtil.safeEquals(com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject(r7, r11), com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject(r7, r12)) != false) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0121, code lost:            if (com.google.crypto.tink.shaded.protobuf.SchemaUtil.safeEquals(com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject(r7, r11), com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject(r7, r12)) != false) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0133, code lost:            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getBoolean(r7, r11) == com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getBoolean(r7, r12)) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0145, code lost:            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt(r7, r11) == com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt(r7, r12)) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0159, code lost:            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong(r7, r11) == com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong(r7, r12)) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x016b, code lost:            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt(r7, r11) == com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt(r7, r12)) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x017e, code lost:            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong(r7, r11) == com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong(r7, r12)) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0191, code lost:            if (com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong(r7, r11) == com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong(r7, r12)) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01aa, code lost:            if (java.lang.Float.floatToIntBits(com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getFloat(r7, r11)) == java.lang.Float.floatToIntBits(com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getFloat(r7, r12))) goto L109;     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c5, code lost:            if (java.lang.Double.doubleToLongBits(com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getDouble(r7, r11)) == java.lang.Double.doubleToLongBits(com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getDouble(r7, r12))) goto L109;     */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01cc A[LOOP:0: B:2:0x0005->B:89:0x01cc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01cb A[SYNTHETIC] */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(T r11, T r12) {
        /*
            Method dump skipped, instructions count: 644
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.equals(java.lang.Object, java.lang.Object):boolean");
    }

    public final void filterMapUnknownEnumValues(Object obj, int r4, Object obj2, UnknownFieldSchema unknownFieldSchema) {
        Internal.EnumVerifier enumFieldVerifier;
        int r0 = this.buffer[r4];
        Object object = UnsafeUtil.getObject(typeAndOffsetAt(r4) & 1048575, obj);
        if (object == null || (enumFieldVerifier = getEnumFieldVerifier(r4)) == null) {
            return;
        }
        MapFieldSchema mapFieldSchema = this.mapFieldSchema;
        MapFieldLite forMutableMapData = mapFieldSchema.forMutableMapData(object);
        mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(r4));
        for (Map.Entry entry : forMutableMapData.entrySet()) {
            if (!enumFieldVerifier.isInRange(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    unknownFieldSchema.newBuilder();
                }
                entry.getKey();
                entry.getValue();
                throw null;
            }
        }
    }

    public final Internal.EnumVerifier getEnumFieldVerifier(int r2) {
        return (Internal.EnumVerifier) this.objects[((r2 / 3) * 2) + 1];
    }

    public final Object getMapFieldDefaultEntry(int r2) {
        return this.objects[(r2 / 3) * 2];
    }

    public final Schema getMessageFieldSchema(int r4) {
        int r42 = (r4 / 3) * 2;
        Object[] objArr = this.objects;
        Schema schema = (Schema) objArr[r42];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaFor = Protobuf.INSTANCE.schemaFor((Class) objArr[r42 + 1]);
        objArr[r42] = schemaFor;
        return schemaFor;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final int getSerializedSize(T t) {
        if (this.proto3) {
            return getSerializedSizeProto3(t);
        }
        return getSerializedSizeProto2(t);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x005c. Please report as an issue. */
    public final int getSerializedSizeProto2(T t) {
        int r17;
        int r7;
        int r15;
        int computeDoubleSize;
        int computeStringSize;
        int computeSizeFixed64ListNoTag;
        int computeTagSize;
        int computeUInt32SizeNoTag;
        int r2 = -1;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        while (true) {
            int[] r72 = this.buffer;
            if (r4 < r72.length) {
                int typeAndOffsetAt = typeAndOffsetAt(r4);
                int r9 = r72[r4];
                int r10 = (267386880 & typeAndOffsetAt) >>> 20;
                boolean z = this.useCachedSizeField;
                Unsafe unsafe = UNSAFE;
                if (r10 <= 17) {
                    r7 = r72[r4 + 2];
                    int r11 = r7 & 1048575;
                    r15 = 1 << (r7 >>> 20);
                    r17 = r4;
                    if (r11 != r2) {
                        r6 = unsafe.getInt(t, r11);
                        r2 = r11;
                    }
                } else {
                    r17 = r4;
                    if (z && r10 >= FieldType.DOUBLE_LIST_PACKED.id() && r10 <= FieldType.SINT64_LIST_PACKED.id()) {
                        r7 = r72[r17 + 2] & 1048575;
                    } else {
                        r7 = 0;
                    }
                    r15 = 0;
                }
                long j = typeAndOffsetAt & 1048575;
                int r8 = r17;
                switch (r10) {
                    case 0:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeDoubleSize(r9);
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 1:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeFloatSize(r9);
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 2:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeInt64Size(r9, unsafe.getLong(t, j));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 3:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeUInt64Size(r9, unsafe.getLong(t, j));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 4:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeInt32Size(r9, unsafe.getInt(t, j));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 5:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeFixed64Size(r9);
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 6:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeFixed32Size(r9);
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 7:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeBoolSize(r9);
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 8:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            Object object = unsafe.getObject(t, j);
                            if (object instanceof ByteString) {
                                computeStringSize = CodedOutputStream.computeBytesSize(r9, (ByteString) object);
                            } else {
                                computeStringSize = CodedOutputStream.computeStringSize(r9, (String) object);
                            }
                            r5 = computeStringSize + r5;
                            break;
                        }
                    case 9:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = SchemaUtil.computeSizeMessage(r9, getMessageFieldSchema(r8), unsafe.getObject(t, j));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 10:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeBytesSize(r9, (ByteString) unsafe.getObject(t, j));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 11:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeUInt32Size(r9, unsafe.getInt(t, j));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 12:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeEnumSize(r9, unsafe.getInt(t, j));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 13:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSFixed32Size(r9);
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 14:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSFixed64Size(r9);
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 15:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSInt32Size(r9, unsafe.getInt(t, j));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 16:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSInt64Size(r9, unsafe.getLong(t, j));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 17:
                        if ((r6 & r15) == 0) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeGroupSize(r9, (MessageLite) unsafe.getObject(t, j), getMessageFieldSchema(r8));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 18:
                        computeDoubleSize = SchemaUtil.computeSizeFixed64List(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 19:
                        computeDoubleSize = SchemaUtil.computeSizeFixed32List(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 20:
                        computeDoubleSize = SchemaUtil.computeSizeInt64List(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 21:
                        computeDoubleSize = SchemaUtil.computeSizeUInt64List(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 22:
                        computeDoubleSize = SchemaUtil.computeSizeInt32List(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 23:
                        computeDoubleSize = SchemaUtil.computeSizeFixed64List(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 24:
                        computeDoubleSize = SchemaUtil.computeSizeFixed32List(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 25:
                        computeDoubleSize = SchemaUtil.computeSizeBoolList(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 26:
                        computeDoubleSize = SchemaUtil.computeSizeStringList(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 27:
                        computeDoubleSize = SchemaUtil.computeSizeMessageList(r9, (List) unsafe.getObject(t, j), getMessageFieldSchema(r8));
                        r5 += computeDoubleSize;
                        break;
                    case 28:
                        computeDoubleSize = SchemaUtil.computeSizeByteStringList(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 29:
                        computeDoubleSize = SchemaUtil.computeSizeUInt32List(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 30:
                        computeDoubleSize = SchemaUtil.computeSizeEnumList(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 31:
                        computeDoubleSize = SchemaUtil.computeSizeFixed32List(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 32:
                        computeDoubleSize = SchemaUtil.computeSizeFixed64List(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 33:
                        computeDoubleSize = SchemaUtil.computeSizeSInt32List(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 34:
                        computeDoubleSize = SchemaUtil.computeSizeSInt64List(r9, (List) unsafe.getObject(t, j));
                        r5 += computeDoubleSize;
                        break;
                    case 35:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r7, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r9);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r5 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + r5;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r7, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r9);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r5 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + r5;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r7, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r9);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r5 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + r5;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r7, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r9);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r5 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + r5;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r7, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r9);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r5 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + r5;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r7, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r9);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r5 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + r5;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r7, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r9);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r5 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + r5;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r7, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r9);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r5 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + r5;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r7, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r9);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r5 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + r5;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r7, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r9);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r5 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + r5;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r7, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r9);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r5 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + r5;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r7, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r9);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r5 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + r5;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r7, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r9);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r5 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + r5;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r7, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r9);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r5 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + r5;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        computeDoubleSize = SchemaUtil.computeSizeGroupList(r9, (List) unsafe.getObject(t, j), getMessageFieldSchema(r8));
                        r5 += computeDoubleSize;
                        break;
                    case 50:
                        computeDoubleSize = this.mapFieldSchema.getSerializedSize(unsafe.getObject(t, j), r9, getMapFieldDefaultEntry(r8));
                        r5 += computeDoubleSize;
                        break;
                    case 51:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeDoubleSize(r9);
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 52:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeFloatSize(r9);
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 53:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeInt64Size(r9, oneofLongAt(j, t));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 54:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeUInt64Size(r9, oneofLongAt(j, t));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 55:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeInt32Size(r9, oneofIntAt(j, t));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 56:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeFixed64Size(r9);
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 57:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeFixed32Size(r9);
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 58:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeBoolSize(r9);
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 59:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            Object object2 = unsafe.getObject(t, j);
                            if (object2 instanceof ByteString) {
                                computeStringSize = CodedOutputStream.computeBytesSize(r9, (ByteString) object2);
                            } else {
                                computeStringSize = CodedOutputStream.computeStringSize(r9, (String) object2);
                            }
                            r5 = computeStringSize + r5;
                            break;
                        }
                    case 60:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = SchemaUtil.computeSizeMessage(r9, getMessageFieldSchema(r8), unsafe.getObject(t, j));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 61:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeBytesSize(r9, (ByteString) unsafe.getObject(t, j));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 62:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeUInt32Size(r9, oneofIntAt(j, t));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 63:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeEnumSize(r9, oneofIntAt(j, t));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 64:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSFixed32Size(r9);
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 65:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSFixed64Size(r9);
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 66:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSInt32Size(r9, oneofIntAt(j, t));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 67:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSInt64Size(r9, oneofLongAt(j, t));
                            r5 += computeDoubleSize;
                            break;
                        }
                    case 68:
                        if (!isOneofPresent(r9, r8, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeGroupSize(r9, (MessageLite) unsafe.getObject(t, j), getMessageFieldSchema(r8));
                            r5 += computeDoubleSize;
                            break;
                        }
                }
                r4 = r8 + 3;
            } else {
                UnknownFieldSchema<?, ?> unknownFieldSchema = this.unknownFieldSchema;
                int serializedSize = unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t)) + r5;
                if (this.hasExtensions) {
                    return serializedSize + this.extensionSchema.getExtensions(t).getSerializedSize();
                }
                return serializedSize;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0033. Please report as an issue. */
    public final int getSerializedSizeProto3(T t) {
        int r3;
        int computeDoubleSize;
        int computeStringSize;
        int computeSizeFixed64ListNoTag;
        int computeTagSize;
        int computeUInt32SizeNoTag;
        int r1 = 0;
        int r2 = 0;
        while (true) {
            int[] r32 = this.buffer;
            if (r1 < r32.length) {
                int typeAndOffsetAt = typeAndOffsetAt(r1);
                int r5 = (267386880 & typeAndOffsetAt) >>> 20;
                int r6 = r32[r1];
                long j = typeAndOffsetAt & 1048575;
                if (r5 >= FieldType.DOUBLE_LIST_PACKED.id() && r5 <= FieldType.SINT64_LIST_PACKED.id()) {
                    r3 = r32[r1 + 2] & 1048575;
                } else {
                    r3 = 0;
                }
                boolean z = this.useCachedSizeField;
                Unsafe unsafe = UNSAFE;
                switch (r5) {
                    case 0:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeDoubleSize(r6);
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 1:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeFloatSize(r6);
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 2:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeInt64Size(r6, UnsafeUtil.getLong(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 3:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeUInt64Size(r6, UnsafeUtil.getLong(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 4:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeInt32Size(r6, UnsafeUtil.getInt(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 5:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeFixed64Size(r6);
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 6:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeFixed32Size(r6);
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 7:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeBoolSize(r6);
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 8:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            Object object = UnsafeUtil.getObject(j, t);
                            if (object instanceof ByteString) {
                                computeStringSize = CodedOutputStream.computeBytesSize(r6, (ByteString) object);
                            } else {
                                computeStringSize = CodedOutputStream.computeStringSize(r6, (String) object);
                            }
                            r2 += computeStringSize;
                            break;
                        }
                    case 9:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = SchemaUtil.computeSizeMessage(r6, getMessageFieldSchema(r1), UnsafeUtil.getObject(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 10:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeBytesSize(r6, (ByteString) UnsafeUtil.getObject(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 11:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeUInt32Size(r6, UnsafeUtil.getInt(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 12:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeEnumSize(r6, UnsafeUtil.getInt(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 13:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSFixed32Size(r6);
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 14:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSFixed64Size(r6);
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 15:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSInt32Size(r6, UnsafeUtil.getInt(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 16:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSInt64Size(r6, UnsafeUtil.getLong(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 17:
                        if (!isFieldPresent(r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeGroupSize(r6, (MessageLite) UnsafeUtil.getObject(j, t), getMessageFieldSchema(r1));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 18:
                        computeDoubleSize = SchemaUtil.computeSizeFixed64List(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 19:
                        computeDoubleSize = SchemaUtil.computeSizeFixed32List(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 20:
                        computeDoubleSize = SchemaUtil.computeSizeInt64List(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 21:
                        computeDoubleSize = SchemaUtil.computeSizeUInt64List(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 22:
                        computeDoubleSize = SchemaUtil.computeSizeInt32List(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 23:
                        computeDoubleSize = SchemaUtil.computeSizeFixed64List(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 24:
                        computeDoubleSize = SchemaUtil.computeSizeFixed32List(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 25:
                        computeDoubleSize = SchemaUtil.computeSizeBoolList(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 26:
                        computeDoubleSize = SchemaUtil.computeSizeStringList(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 27:
                        computeDoubleSize = SchemaUtil.computeSizeMessageList(r6, listAt(j, t), getMessageFieldSchema(r1));
                        r2 += computeDoubleSize;
                        break;
                    case 28:
                        computeDoubleSize = SchemaUtil.computeSizeByteStringList(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 29:
                        computeDoubleSize = SchemaUtil.computeSizeUInt32List(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 30:
                        computeDoubleSize = SchemaUtil.computeSizeEnumList(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 31:
                        computeDoubleSize = SchemaUtil.computeSizeFixed32List(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 32:
                        computeDoubleSize = SchemaUtil.computeSizeFixed64List(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 33:
                        computeDoubleSize = SchemaUtil.computeSizeSInt32List(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 34:
                        computeDoubleSize = SchemaUtil.computeSizeSInt64List(r6, listAt(j, t));
                        r2 += computeDoubleSize;
                        break;
                    case 35:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r3, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r6);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r2 += computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r3, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r6);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r2 += computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r3, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r6);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r2 += computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r3, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r6);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r2 += computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r3, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r6);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r2 += computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r3, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r6);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r2 += computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r3, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r6);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r2 += computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r3, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r6);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r2 += computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r3, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r6);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r2 += computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r3, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r6);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r2 += computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r3, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r6);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r2 += computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r3, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r6);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r2 += computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r3, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r6);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r2 += computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        computeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, j));
                        if (computeSizeFixed64ListNoTag > 0) {
                            if (z) {
                                unsafe.putInt(t, r3, computeSizeFixed64ListNoTag);
                            }
                            computeTagSize = CodedOutputStream.computeTagSize(r6);
                            computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                            r2 += computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        computeDoubleSize = SchemaUtil.computeSizeGroupList(r6, listAt(j, t), getMessageFieldSchema(r1));
                        r2 += computeDoubleSize;
                        break;
                    case 50:
                        computeDoubleSize = this.mapFieldSchema.getSerializedSize(UnsafeUtil.getObject(j, t), r6, getMapFieldDefaultEntry(r1));
                        r2 += computeDoubleSize;
                        break;
                    case 51:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeDoubleSize(r6);
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 52:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeFloatSize(r6);
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 53:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeInt64Size(r6, oneofLongAt(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 54:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeUInt64Size(r6, oneofLongAt(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 55:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeInt32Size(r6, oneofIntAt(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 56:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeFixed64Size(r6);
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 57:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeFixed32Size(r6);
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 58:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeBoolSize(r6);
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 59:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            Object object2 = UnsafeUtil.getObject(j, t);
                            if (object2 instanceof ByteString) {
                                computeStringSize = CodedOutputStream.computeBytesSize(r6, (ByteString) object2);
                            } else {
                                computeStringSize = CodedOutputStream.computeStringSize(r6, (String) object2);
                            }
                            r2 += computeStringSize;
                            break;
                        }
                    case 60:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = SchemaUtil.computeSizeMessage(r6, getMessageFieldSchema(r1), UnsafeUtil.getObject(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 61:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeBytesSize(r6, (ByteString) UnsafeUtil.getObject(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 62:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeUInt32Size(r6, oneofIntAt(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 63:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeEnumSize(r6, oneofIntAt(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 64:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSFixed32Size(r6);
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 65:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSFixed64Size(r6);
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 66:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSInt32Size(r6, oneofIntAt(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 67:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeSInt64Size(r6, oneofLongAt(j, t));
                            r2 += computeDoubleSize;
                            break;
                        }
                    case 68:
                        if (!isOneofPresent(r6, r1, t)) {
                            break;
                        } else {
                            computeDoubleSize = CodedOutputStream.computeGroupSize(r6, (MessageLite) UnsafeUtil.getObject(j, t), getMessageFieldSchema(r1));
                            r2 += computeDoubleSize;
                            break;
                        }
                }
                r1 += 3;
            } else {
                UnknownFieldSchema<?, ?> unknownFieldSchema = this.unknownFieldSchema;
                return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t)) + r2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01f2, code lost:            if (r4 != false) goto L85;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00da, code lost:            if (r4 != false) goto L85;     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01f5, code lost:            r8 = 1237;     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01f6, code lost:            r4 = r8;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int hashCode(T r11) {
        /*
            Method dump skipped, instructions count: 756
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.hashCode(java.lang.Object):int");
    }

    public final boolean isFieldPresent(int r7, Object obj) {
        boolean equals;
        if (this.proto3) {
            int typeAndOffsetAt = typeAndOffsetAt(r7);
            long j = typeAndOffsetAt & 1048575;
            switch ((typeAndOffsetAt & 267386880) >>> 20) {
                case 0:
                    if (UnsafeUtil.getDouble(j, obj) == 0.0d) {
                        return false;
                    }
                    return true;
                case 1:
                    if (UnsafeUtil.getFloat(j, obj) == 0.0f) {
                        return false;
                    }
                    return true;
                case 2:
                    if (UnsafeUtil.getLong(j, obj) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (UnsafeUtil.getLong(j, obj) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (UnsafeUtil.getInt(j, obj) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (UnsafeUtil.getLong(j, obj) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (UnsafeUtil.getInt(j, obj) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return UnsafeUtil.getBoolean(j, obj);
                case 8:
                    Object object = UnsafeUtil.getObject(j, obj);
                    if (object instanceof String) {
                        equals = ((String) object).isEmpty();
                        break;
                    } else if (object instanceof ByteString) {
                        equals = ByteString.EMPTY.equals(object);
                        break;
                    } else {
                        throw new IllegalArgumentException();
                    }
                case 9:
                    if (UnsafeUtil.getObject(j, obj) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    equals = ByteString.EMPTY.equals(UnsafeUtil.getObject(j, obj));
                    break;
                case 11:
                    if (UnsafeUtil.getInt(j, obj) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (UnsafeUtil.getInt(j, obj) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (UnsafeUtil.getInt(j, obj) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (UnsafeUtil.getLong(j, obj) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (UnsafeUtil.getInt(j, obj) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (UnsafeUtil.getLong(j, obj) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (UnsafeUtil.getObject(j, obj) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
            return !equals;
        }
        if ((UnsafeUtil.getInt(r7 & 1048575, obj) & (1 << (this.buffer[r7 + 2] >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final boolean isInitialized(T t) {
        int r6;
        boolean z;
        boolean z2;
        int r0 = -1;
        int r2 = 0;
        int r3 = 0;
        while (true) {
            boolean z3 = true;
            if (r2 < this.checkInitializedCount) {
                int r4 = this.intArray[r2];
                int[] r62 = this.buffer;
                int r7 = r62[r4];
                int typeAndOffsetAt = typeAndOffsetAt(r4);
                boolean z4 = this.proto3;
                if (!z4) {
                    int r63 = r62[r4 + 2];
                    int r11 = r63 & 1048575;
                    r6 = 1 << (r63 >>> 20);
                    if (r11 != r0) {
                        r3 = UNSAFE.getInt(t, r11);
                        r0 = r11;
                    }
                } else {
                    r6 = 0;
                }
                if ((268435456 & typeAndOffsetAt) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (z4) {
                        z2 = isFieldPresent(r4, t);
                    } else if ((r3 & r6) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        return false;
                    }
                }
                int r112 = (267386880 & typeAndOffsetAt) >>> 20;
                if (r112 != 9 && r112 != 17) {
                    if (r112 != 27) {
                        if (r112 != 60 && r112 != 68) {
                            if (r112 != 49) {
                                if (r112 != 50) {
                                    continue;
                                } else {
                                    Object object = UnsafeUtil.getObject(typeAndOffsetAt & 1048575, t);
                                    MapFieldSchema mapFieldSchema = this.mapFieldSchema;
                                    if (!mapFieldSchema.forMapData(object).isEmpty()) {
                                        mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(r4));
                                        throw null;
                                    }
                                }
                            }
                        } else if (isOneofPresent(r7, r4, t) && !getMessageFieldSchema(r4).isInitialized(UnsafeUtil.getObject(typeAndOffsetAt & 1048575, t))) {
                            return false;
                        }
                    }
                    List list = (List) UnsafeUtil.getObject(typeAndOffsetAt & 1048575, t);
                    if (!list.isEmpty()) {
                        Schema messageFieldSchema = getMessageFieldSchema(r4);
                        int r72 = 0;
                        while (true) {
                            if (r72 >= list.size()) {
                                break;
                            }
                            if (!messageFieldSchema.isInitialized(list.get(r72))) {
                                z3 = false;
                                break;
                            }
                            r72++;
                        }
                    }
                    if (!z3) {
                        return false;
                    }
                } else {
                    if (z4) {
                        z3 = isFieldPresent(r4, t);
                    } else if ((r6 & r3) == 0) {
                        z3 = false;
                    }
                    if (z3 && !getMessageFieldSchema(r4).isInitialized(UnsafeUtil.getObject(typeAndOffsetAt & 1048575, t))) {
                        return false;
                    }
                }
                r2++;
            } else {
                if (this.hasExtensions && !this.extensionSchema.getExtensions(t).isInitialized()) {
                    return false;
                }
                return true;
            }
        }
    }

    public final boolean isOneofPresent(int r3, int r4, Object obj) {
        if (UnsafeUtil.getInt(this.buffer[r4 + 2] & 1048575, obj) == r3) {
            return true;
        }
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final void makeImmutable(T t) {
        int[] r1;
        int r2;
        int r0 = this.checkInitializedCount;
        while (true) {
            r1 = this.intArray;
            r2 = this.repeatedFieldOffsetStart;
            if (r0 >= r2) {
                break;
            }
            long typeAndOffsetAt = typeAndOffsetAt(r1[r0]) & 1048575;
            Object object = UnsafeUtil.getObject(typeAndOffsetAt, t);
            if (object != null) {
                UnsafeUtil.putObject(typeAndOffsetAt, t, this.mapFieldSchema.toImmutable(object));
            }
            r0++;
        }
        int length = r1.length;
        while (r2 < length) {
            this.listFieldSchema.makeImmutableListAt(r1[r2], t);
            r2++;
        }
        this.unknownFieldSchema.makeImmutable(t);
        if (this.hasExtensions) {
            this.extensionSchema.makeImmutable(t);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final void mergeFrom(T t, T t2) {
        t2.getClass();
        int r0 = 0;
        while (true) {
            int[] r1 = this.buffer;
            if (r0 < r1.length) {
                int typeAndOffsetAt = typeAndOffsetAt(r0);
                long j = 1048575 & typeAndOffsetAt;
                int r12 = r1[r0];
                switch ((typeAndOffsetAt & 267386880) >>> 20) {
                    case 0:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putDouble(t, j, UnsafeUtil.getDouble(j, t2));
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 1:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putFloat(t, j, UnsafeUtil.getFloat(j, t2));
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 2:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putLong(t, j, UnsafeUtil.getLong(j, t2));
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 3:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putLong(t, j, UnsafeUtil.getLong(j, t2));
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 4:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putInt(j, UnsafeUtil.getInt(j, t2), t);
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 5:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putLong(t, j, UnsafeUtil.getLong(j, t2));
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 6:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putInt(j, UnsafeUtil.getInt(j, t2), t);
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 7:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putBoolean(t, j, UnsafeUtil.getBoolean(j, t2));
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 8:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putObject(j, t, UnsafeUtil.getObject(j, t2));
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 9:
                        mergeMessage(t, r0, t2);
                        break;
                    case 10:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putObject(j, t, UnsafeUtil.getObject(j, t2));
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 11:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putInt(j, UnsafeUtil.getInt(j, t2), t);
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 12:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putInt(j, UnsafeUtil.getInt(j, t2), t);
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 13:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putInt(j, UnsafeUtil.getInt(j, t2), t);
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 14:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putLong(t, j, UnsafeUtil.getLong(j, t2));
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 15:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putInt(j, UnsafeUtil.getInt(j, t2), t);
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 16:
                        if (!isFieldPresent(r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putLong(t, j, UnsafeUtil.getLong(j, t2));
                            setFieldPresent(r0, t);
                            break;
                        }
                    case 17:
                        mergeMessage(t, r0, t2);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.listFieldSchema.mergeListsAt(j, t, t2);
                        break;
                    case 50:
                        Class<?> cls = SchemaUtil.GENERATED_MESSAGE_CLASS;
                        UnsafeUtil.putObject(j, t, this.mapFieldSchema.mergeFrom(UnsafeUtil.getObject(j, t), UnsafeUtil.getObject(j, t2)));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!isOneofPresent(r12, r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putObject(j, t, UnsafeUtil.getObject(j, t2));
                            setOneofPresent(r12, r0, t);
                            break;
                        }
                    case 60:
                        mergeOneofMessage(t, r0, t2);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!isOneofPresent(r12, r0, t2)) {
                            break;
                        } else {
                            UnsafeUtil.putObject(j, t, UnsafeUtil.getObject(j, t2));
                            setOneofPresent(r12, r0, t);
                            break;
                        }
                    case 68:
                        mergeOneofMessage(t, r0, t2);
                        break;
                }
                r0 += 3;
            } else {
                Class<?> cls2 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                UnknownFieldSchema<?, ?> unknownFieldSchema = this.unknownFieldSchema;
                unknownFieldSchema.setToMessage(t, unknownFieldSchema.merge(unknownFieldSchema.getFromMessage(t), unknownFieldSchema.getFromMessage(t2)));
                if (this.hasExtensions) {
                    SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
                    return;
                }
                return;
            }
        }
    }

    public final <K, V> void mergeMap(Object obj, int r5, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long typeAndOffsetAt = typeAndOffsetAt(r5) & 1048575;
        Object object = UnsafeUtil.getObject(typeAndOffsetAt, obj);
        MapFieldSchema mapFieldSchema = this.mapFieldSchema;
        if (object == null) {
            object = mapFieldSchema.newMapField();
            UnsafeUtil.putObject(typeAndOffsetAt, obj, object);
        } else if (mapFieldSchema.isImmutable(object)) {
            MapFieldLite newMapField = mapFieldSchema.newMapField();
            mapFieldSchema.mergeFrom(newMapField, object);
            UnsafeUtil.putObject(typeAndOffsetAt, obj, newMapField);
            object = newMapField;
        }
        mapFieldSchema.forMutableMapData(object);
        mapFieldSchema.forMapMetadata(obj2);
        reader.readMap();
    }

    public final void mergeMessage(Object obj, int r5, Object obj2) {
        long typeAndOffsetAt = typeAndOffsetAt(r5) & 1048575;
        if (!isFieldPresent(r5, obj2)) {
            return;
        }
        Object object = UnsafeUtil.getObject(typeAndOffsetAt, obj);
        Object object2 = UnsafeUtil.getObject(typeAndOffsetAt, obj2);
        if (object != null && object2 != null) {
            UnsafeUtil.putObject(typeAndOffsetAt, obj, Internal.mergeMessage(object, object2));
            setFieldPresent(r5, obj);
        } else if (object2 != null) {
            UnsafeUtil.putObject(typeAndOffsetAt, obj, object2);
            setFieldPresent(r5, obj);
        }
    }

    public final void mergeOneofMessage(Object obj, int r6, Object obj2) {
        int typeAndOffsetAt = typeAndOffsetAt(r6);
        int r1 = this.buffer[r6];
        long j = typeAndOffsetAt & 1048575;
        if (!isOneofPresent(r1, r6, obj2)) {
            return;
        }
        Object object = UnsafeUtil.getObject(j, obj);
        Object object2 = UnsafeUtil.getObject(j, obj2);
        if (object != null && object2 != null) {
            UnsafeUtil.putObject(j, obj, Internal.mergeMessage(object, object2));
            setOneofPresent(r1, r6, obj);
        } else if (object2 != null) {
            UnsafeUtil.putObject(j, obj, object2);
            setOneofPresent(r1, r6, obj);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    public final void parseMapField(Object obj, byte[] bArr, int r7, int r8, int r9, long j, ArrayDecoders.Registers registers) throws IOException {
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(r9);
        Unsafe unsafe = UNSAFE;
        Object object = unsafe.getObject(obj, j);
        MapFieldSchema mapFieldSchema = this.mapFieldSchema;
        if (mapFieldSchema.isImmutable(object)) {
            MapFieldLite newMapField = mapFieldSchema.newMapField();
            mapFieldSchema.mergeFrom(newMapField, object);
            unsafe.putObject(obj, j, newMapField);
            object = newMapField;
        }
        mapFieldSchema.forMapMetadata(mapFieldDefaultEntry);
        mapFieldSchema.forMutableMapData(object);
        int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, r7, registers);
        int r6 = registers.int1;
        if (r6 >= 0 && r6 <= r8 - decodeVarint32) {
            throw null;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    public final int parseOneofField(T t, byte[] bArr, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long j, int r28, ArrayDecoders.Registers registers) throws IOException {
        Object obj;
        Object obj2;
        long j2 = this.buffer[r28 + 2] & 1048575;
        boolean z = true;
        Unsafe unsafe = UNSAFE;
        switch (r25) {
            case 51:
                if (r23 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(ArrayDecoders.decodeDouble(r19, bArr)));
                    int r2 = r19 + 8;
                    unsafe.putInt(t, j2, r22);
                    return r2;
                }
                return r19;
            case 52:
                if (r23 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(ArrayDecoders.decodeFloat(r19, bArr)));
                    int r26 = r19 + 4;
                    unsafe.putInt(t, j2, r22);
                    return r26;
                }
                return r19;
            case 53:
            case 54:
                if (r23 == 0) {
                    int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, r19, registers);
                    unsafe.putObject(t, j, Long.valueOf(registers.long1));
                    unsafe.putInt(t, j2, r22);
                    return decodeVarint64;
                }
                return r19;
            case 55:
            case 62:
                if (r23 == 0) {
                    int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, r19, registers);
                    unsafe.putObject(t, j, Integer.valueOf(registers.int1));
                    unsafe.putInt(t, j2, r22);
                    return decodeVarint32;
                }
                return r19;
            case 56:
            case 65:
                if (r23 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(ArrayDecoders.decodeFixed64(r19, bArr)));
                    int r27 = r19 + 8;
                    unsafe.putInt(t, j2, r22);
                    return r27;
                }
                return r19;
            case 57:
            case 64:
                if (r23 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(ArrayDecoders.decodeFixed32(r19, bArr)));
                    int r29 = r19 + 4;
                    unsafe.putInt(t, j2, r22);
                    return r29;
                }
                return r19;
            case 58:
                if (r23 == 0) {
                    int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, r19, registers);
                    if (registers.long1 == 0) {
                        z = false;
                    }
                    unsafe.putObject(t, j, Boolean.valueOf(z));
                    unsafe.putInt(t, j2, r22);
                    return decodeVarint642;
                }
                return r19;
            case 59:
                if (r23 == 2) {
                    int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, r19, registers);
                    int r4 = registers.int1;
                    if (r4 == 0) {
                        unsafe.putObject(t, j, "");
                    } else {
                        if ((r24 & 536870912) != 0 && !Utf8.isValidUtf8(bArr, decodeVarint322, decodeVarint322 + r4)) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        unsafe.putObject(t, j, new String(bArr, decodeVarint322, r4, Internal.UTF_8));
                        decodeVarint322 += r4;
                    }
                    unsafe.putInt(t, j2, r22);
                    return decodeVarint322;
                }
                return r19;
            case 60:
                if (r23 == 2) {
                    int decodeMessageField = ArrayDecoders.decodeMessageField(getMessageFieldSchema(r28), bArr, r19, r20, registers);
                    if (unsafe.getInt(t, j2) == r22) {
                        obj = unsafe.getObject(t, j);
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        unsafe.putObject(t, j, registers.object1);
                    } else {
                        unsafe.putObject(t, j, Internal.mergeMessage(obj, registers.object1));
                    }
                    unsafe.putInt(t, j2, r22);
                    return decodeMessageField;
                }
                return r19;
            case 61:
                if (r23 == 2) {
                    int decodeBytes = ArrayDecoders.decodeBytes(bArr, r19, registers);
                    unsafe.putObject(t, j, registers.object1);
                    unsafe.putInt(t, j2, r22);
                    return decodeBytes;
                }
                return r19;
            case 63:
                if (r23 == 0) {
                    int decodeVarint323 = ArrayDecoders.decodeVarint32(bArr, r19, registers);
                    int r42 = registers.int1;
                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(r28);
                    if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(r42)) {
                        getMutableUnknownFields(t).storeField(r21, Long.valueOf(r42));
                    } else {
                        unsafe.putObject(t, j, Integer.valueOf(r42));
                        unsafe.putInt(t, j2, r22);
                    }
                    return decodeVarint323;
                }
                return r19;
            case 66:
                if (r23 == 0) {
                    int decodeVarint324 = ArrayDecoders.decodeVarint32(bArr, r19, registers);
                    unsafe.putObject(t, j, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                    unsafe.putInt(t, j2, r22);
                    return decodeVarint324;
                }
                return r19;
            case 67:
                if (r23 == 0) {
                    int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, r19, registers);
                    unsafe.putObject(t, j, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                    unsafe.putInt(t, j2, r22);
                    return decodeVarint643;
                }
                return r19;
            case 68:
                if (r23 == 3) {
                    int decodeGroupField = ArrayDecoders.decodeGroupField(getMessageFieldSchema(r28), bArr, r19, r20, (r21 & (-8)) | 4, registers);
                    if (unsafe.getInt(t, j2) == r22) {
                        obj2 = unsafe.getObject(t, j);
                    } else {
                        obj2 = null;
                    }
                    if (obj2 == null) {
                        unsafe.putObject(t, j, registers.object1);
                    } else {
                        unsafe.putObject(t, j, Internal.mergeMessage(obj2, registers.object1));
                    }
                    unsafe.putInt(t, j2, r22);
                    return decodeGroupField;
                }
                return r19;
            default:
                return r19;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x0097. Please report as an issue. */
    public final int parseProto2Message(T t, byte[] bArr, int r30, int r31, int r32, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe;
        MessageSchema<T> messageSchema;
        Object obj;
        T t2;
        int r5;
        int r0;
        int r3;
        int r02;
        int r10;
        int r17;
        int r1;
        int r19;
        int r21;
        int r20;
        int r8;
        int r7;
        int r2;
        int r15;
        int r18;
        int r12;
        int r52;
        int r13;
        int r82;
        int decodeVarint64;
        int r03;
        boolean z;
        int r04;
        int r14;
        int r05;
        MessageSchema<T> messageSchema2 = this;
        T t3 = t;
        byte[] bArr2 = bArr;
        int r132 = r31;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe2 = UNSAFE;
        int r06 = r30;
        int r16 = r32;
        int r22 = -1;
        int r33 = 0;
        int r4 = 0;
        int r6 = -1;
        int r72 = 0;
        while (true) {
            if (r06 < r132) {
                int r42 = r06 + 1;
                int r07 = bArr2[r06];
                if (r07 < 0) {
                    r42 = ArrayDecoders.decodeVarint32(r07, bArr2, r42, registers2);
                    r07 = registers2.int1;
                }
                int r83 = r07 >>> 3;
                int r102 = r07 & 7;
                int r53 = messageSchema2.maxFieldNumber;
                int r182 = r07;
                int r08 = messageSchema2.minFieldNumber;
                int r192 = r16;
                if (r83 > r22) {
                    int r34 = r33 / 3;
                    if (r83 >= r08 && r83 <= r53) {
                        r05 = messageSchema2.slowPositionForFieldNumber(r83, r34);
                    } else {
                        r05 = -1;
                    }
                    r3 = r05;
                    r02 = -1;
                    r5 = 0;
                } else {
                    if (r83 >= r08 && r83 <= r53) {
                        r5 = 0;
                        r0 = messageSchema2.slowPositionForFieldNumber(r83, 0);
                    } else {
                        r5 = 0;
                        r0 = -1;
                    }
                    r3 = r0;
                    r02 = -1;
                }
                if (r3 == r02) {
                    r10 = r5;
                    r17 = r83;
                    unsafe = unsafe2;
                    r1 = r192;
                    r19 = r182;
                } else {
                    int[] r23 = messageSchema2.buffer;
                    int r09 = r23[r3 + 1];
                    int r110 = (r09 & 267386880) >>> 20;
                    long j = r09 & 1048575;
                    if (r110 <= 17) {
                        int r24 = r23[r3 + 2];
                        int r232 = 1 << (r24 >>> 20);
                        int r25 = r24 & 1048575;
                        if (r25 != r6) {
                            if (r6 != -1) {
                                unsafe2.putInt(t3, r6, r72);
                            }
                            r6 = r25;
                            r72 = unsafe2.getInt(t3, r25);
                        }
                        switch (r110) {
                            case 0:
                                r52 = r42;
                                r17 = r83;
                                r82 = r3;
                                r13 = r182;
                                bArr2 = bArr;
                                if (r102 == 1) {
                                    UnsafeUtil.putDouble(t3, j, ArrayDecoders.decodeDouble(r52, bArr2));
                                    r06 = r52 + 8;
                                    r72 |= r232;
                                    r16 = r32;
                                    r33 = r82;
                                    r4 = r13;
                                    r22 = r17;
                                    r132 = r31;
                                    break;
                                } else {
                                    r1 = r32;
                                    r42 = r52;
                                    r10 = r82;
                                    unsafe = unsafe2;
                                    r19 = r13;
                                    break;
                                }
                            case 1:
                                r52 = r42;
                                r17 = r83;
                                r82 = r3;
                                r13 = r182;
                                bArr2 = bArr;
                                if (r102 == 5) {
                                    UnsafeUtil.putFloat(t3, j, ArrayDecoders.decodeFloat(r52, bArr2));
                                    r06 = r52 + 4;
                                    r72 |= r232;
                                    r16 = r32;
                                    r33 = r82;
                                    r4 = r13;
                                    r22 = r17;
                                    r132 = r31;
                                    break;
                                } else {
                                    r1 = r32;
                                    r42 = r52;
                                    r10 = r82;
                                    unsafe = unsafe2;
                                    r19 = r13;
                                    break;
                                }
                            case 2:
                            case 3:
                                r52 = r42;
                                r17 = r83;
                                r82 = r3;
                                r13 = r182;
                                bArr2 = bArr;
                                if (r102 == 0) {
                                    decodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, r52, registers2);
                                    unsafe2.putLong(t, j, registers2.long1);
                                    r72 |= r232;
                                    r06 = decodeVarint64;
                                    r16 = r32;
                                    r33 = r82;
                                    r4 = r13;
                                    r22 = r17;
                                    r132 = r31;
                                    break;
                                } else {
                                    r1 = r32;
                                    r42 = r52;
                                    r10 = r82;
                                    unsafe = unsafe2;
                                    r19 = r13;
                                    break;
                                }
                            case 4:
                            case 11:
                                r52 = r42;
                                r17 = r83;
                                r82 = r3;
                                r13 = r182;
                                bArr2 = bArr;
                                if (r102 == 0) {
                                    r06 = ArrayDecoders.decodeVarint32(bArr2, r52, registers2);
                                    unsafe2.putInt(t3, j, registers2.int1);
                                    r72 |= r232;
                                    r16 = r32;
                                    r33 = r82;
                                    r4 = r13;
                                    r22 = r17;
                                    r132 = r31;
                                    break;
                                } else {
                                    r1 = r32;
                                    r42 = r52;
                                    r10 = r82;
                                    unsafe = unsafe2;
                                    r19 = r13;
                                    break;
                                }
                            case 5:
                            case 14:
                                r17 = r83;
                                r13 = r182;
                                bArr2 = bArr;
                                r82 = r3;
                                if (r102 == 1) {
                                    unsafe2.putLong(t, j, ArrayDecoders.decodeFixed64(r42, bArr2));
                                    r06 = r42 + 8;
                                    r72 |= r232;
                                    r16 = r32;
                                    r33 = r82;
                                    r4 = r13;
                                    r22 = r17;
                                    r132 = r31;
                                    break;
                                } else {
                                    r52 = r42;
                                    r1 = r32;
                                    r42 = r52;
                                    r10 = r82;
                                    unsafe = unsafe2;
                                    r19 = r13;
                                    break;
                                }
                            case 6:
                            case 13:
                                r17 = r83;
                                r13 = r182;
                                bArr2 = bArr;
                                r82 = r3;
                                if (r102 == 5) {
                                    unsafe2.putInt(t3, j, ArrayDecoders.decodeFixed32(r42, bArr2));
                                    r03 = r42 + 4;
                                    r14 = r03;
                                    r04 = r72 | r232;
                                    r72 = r04;
                                    r06 = r14;
                                    r16 = r32;
                                    r33 = r82;
                                    r4 = r13;
                                    r22 = r17;
                                    r132 = r31;
                                    break;
                                } else {
                                    r52 = r42;
                                    r1 = r32;
                                    r42 = r52;
                                    r10 = r82;
                                    unsafe = unsafe2;
                                    r19 = r13;
                                    break;
                                }
                            case 7:
                                r17 = r83;
                                r82 = r3;
                                r13 = r182;
                                bArr2 = bArr;
                                if (r102 == 0) {
                                    int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr2, r42, registers2);
                                    if (registers2.long1 != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    UnsafeUtil.putBoolean(t3, j, z);
                                    r04 = r72 | r232;
                                    r14 = decodeVarint642;
                                    r72 = r04;
                                    r06 = r14;
                                    r16 = r32;
                                    r33 = r82;
                                    r4 = r13;
                                    r22 = r17;
                                    r132 = r31;
                                    break;
                                } else {
                                    r52 = r42;
                                    r1 = r32;
                                    r42 = r52;
                                    r10 = r82;
                                    unsafe = unsafe2;
                                    r19 = r13;
                                    break;
                                }
                            case 8:
                                r17 = r83;
                                r82 = r3;
                                r13 = r182;
                                bArr2 = bArr;
                                if (r102 == 2) {
                                    if ((r09 & 536870912) == 0) {
                                        r03 = ArrayDecoders.decodeString(bArr2, r42, registers2);
                                    } else {
                                        r03 = ArrayDecoders.decodeStringRequireUtf8(bArr2, r42, registers2);
                                    }
                                    unsafe2.putObject(t3, j, registers2.object1);
                                    r14 = r03;
                                    r04 = r72 | r232;
                                    r72 = r04;
                                    r06 = r14;
                                    r16 = r32;
                                    r33 = r82;
                                    r4 = r13;
                                    r22 = r17;
                                    r132 = r31;
                                    break;
                                } else {
                                    r52 = r42;
                                    r1 = r32;
                                    r42 = r52;
                                    r10 = r82;
                                    unsafe = unsafe2;
                                    r19 = r13;
                                    break;
                                }
                            case 9:
                                r17 = r83;
                                r82 = r3;
                                r13 = r182;
                                bArr2 = bArr;
                                if (r102 == 2) {
                                    r03 = ArrayDecoders.decodeMessageField(messageSchema2.getMessageFieldSchema(r82), bArr2, r42, r31, registers2);
                                    if ((r72 & r232) == 0) {
                                        unsafe2.putObject(t3, j, registers2.object1);
                                    } else {
                                        unsafe2.putObject(t3, j, Internal.mergeMessage(unsafe2.getObject(t3, j), registers2.object1));
                                    }
                                    r14 = r03;
                                    r04 = r72 | r232;
                                    r72 = r04;
                                    r06 = r14;
                                    r16 = r32;
                                    r33 = r82;
                                    r4 = r13;
                                    r22 = r17;
                                    r132 = r31;
                                    break;
                                } else {
                                    r52 = r42;
                                    r1 = r32;
                                    r42 = r52;
                                    r10 = r82;
                                    unsafe = unsafe2;
                                    r19 = r13;
                                    break;
                                }
                            case 10:
                                r17 = r83;
                                r82 = r3;
                                r13 = r182;
                                bArr2 = bArr;
                                if (r102 == 2) {
                                    r06 = ArrayDecoders.decodeBytes(bArr2, r42, registers2);
                                    unsafe2.putObject(t3, j, registers2.object1);
                                    r72 |= r232;
                                    r16 = r32;
                                    r33 = r82;
                                    r4 = r13;
                                    r22 = r17;
                                    r132 = r31;
                                    break;
                                } else {
                                    r52 = r42;
                                    r1 = r32;
                                    r42 = r52;
                                    r10 = r82;
                                    unsafe = unsafe2;
                                    r19 = r13;
                                    break;
                                }
                            case 12:
                                r17 = r83;
                                r82 = r3;
                                r13 = r182;
                                bArr2 = bArr;
                                if (r102 == 0) {
                                    r06 = ArrayDecoders.decodeVarint32(bArr2, r42, registers2);
                                    int r111 = registers2.int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(r82);
                                    if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(r111)) {
                                        getMutableUnknownFields(t).storeField(r13, Long.valueOf(r111));
                                        r16 = r32;
                                        r33 = r82;
                                        r4 = r13;
                                        r22 = r17;
                                        r132 = r31;
                                    } else {
                                        unsafe2.putInt(t3, j, r111);
                                        r72 |= r232;
                                        r16 = r32;
                                        r33 = r82;
                                        r4 = r13;
                                        r22 = r17;
                                        r132 = r31;
                                        break;
                                    }
                                } else {
                                    r52 = r42;
                                    r1 = r32;
                                    r42 = r52;
                                    r10 = r82;
                                    unsafe = unsafe2;
                                    r19 = r13;
                                    break;
                                }
                                break;
                            case 15:
                                r17 = r83;
                                r82 = r3;
                                r13 = r182;
                                bArr2 = bArr;
                                if (r102 == 0) {
                                    r06 = ArrayDecoders.decodeVarint32(bArr2, r42, registers2);
                                    unsafe2.putInt(t3, j, CodedInputStream.decodeZigZag32(registers2.int1));
                                    r72 |= r232;
                                    r16 = r32;
                                    r33 = r82;
                                    r4 = r13;
                                    r22 = r17;
                                    r132 = r31;
                                    break;
                                } else {
                                    r52 = r42;
                                    r1 = r32;
                                    r42 = r52;
                                    r10 = r82;
                                    unsafe = unsafe2;
                                    r19 = r13;
                                    break;
                                }
                            case 16:
                                r17 = r83;
                                r82 = r3;
                                if (r102 == 0) {
                                    bArr2 = bArr;
                                    decodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, r42, registers2);
                                    r13 = r182;
                                    unsafe2.putLong(t, j, CodedInputStream.decodeZigZag64(registers2.long1));
                                    r72 |= r232;
                                    r06 = decodeVarint64;
                                    r16 = r32;
                                    r33 = r82;
                                    r4 = r13;
                                    r22 = r17;
                                    r132 = r31;
                                    break;
                                } else {
                                    r13 = r182;
                                    r52 = r42;
                                    r1 = r32;
                                    r42 = r52;
                                    r10 = r82;
                                    unsafe = unsafe2;
                                    r19 = r13;
                                    break;
                                }
                            case 17:
                                if (r102 == 3) {
                                    int r54 = (r83 << 3) | 4;
                                    r17 = r83;
                                    r82 = r3;
                                    r06 = ArrayDecoders.decodeGroupField(messageSchema2.getMessageFieldSchema(r3), bArr, r42, r31, r54, registers);
                                    if ((r72 & r232) == 0) {
                                        unsafe2.putObject(t3, j, registers2.object1);
                                    } else {
                                        unsafe2.putObject(t3, j, Internal.mergeMessage(unsafe2.getObject(t3, j), registers2.object1));
                                    }
                                    bArr2 = bArr;
                                    r72 |= r232;
                                    r13 = r182;
                                    r16 = r32;
                                    r33 = r82;
                                    r4 = r13;
                                    r22 = r17;
                                    r132 = r31;
                                    break;
                                } else {
                                    r17 = r83;
                                    r82 = r3;
                                    r52 = r42;
                                    r13 = r182;
                                    r1 = r32;
                                    r42 = r52;
                                    r10 = r82;
                                    unsafe = unsafe2;
                                    r19 = r13;
                                    break;
                                }
                            default:
                                r52 = r42;
                                r17 = r83;
                                r13 = r182;
                                r82 = r3;
                                r1 = r32;
                                r42 = r52;
                                r10 = r82;
                                unsafe = unsafe2;
                                r19 = r13;
                                break;
                        }
                    } else {
                        int r55 = r42;
                        r17 = r83;
                        int r84 = r3;
                        bArr2 = bArr;
                        if (r110 == 27) {
                            if (r102 == 2) {
                                Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe2.getObject(t3, j);
                                if (!protobufList.isModifiable()) {
                                    int size = protobufList.size();
                                    if (size == 0) {
                                        r12 = 10;
                                    } else {
                                        r12 = size * 2;
                                    }
                                    protobufList = protobufList.mutableCopyWithCapacity(r12);
                                    unsafe2.putObject(t3, j, protobufList);
                                }
                                r06 = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(r84), r182, bArr, r55, r31, protobufList, registers);
                                r16 = r32;
                                r33 = r84;
                                r4 = r182;
                                r22 = r17;
                                r6 = r6;
                                r132 = r31;
                            } else {
                                r20 = r6;
                                r15 = r55;
                                r21 = r72;
                                r18 = r84;
                                unsafe = unsafe2;
                                r19 = r182;
                            }
                        } else {
                            r20 = r6;
                            if (r110 <= 49) {
                                r21 = r72;
                                r18 = r84;
                                unsafe = unsafe2;
                                r19 = r182;
                                r42 = parseRepeatedField(t, bArr, r55, r31, r182, r17, r102, r84, r09, r110, j, registers);
                                if (r42 != r55) {
                                    r06 = r42;
                                }
                                r1 = r32;
                                r10 = r18;
                                r6 = r20;
                                r72 = r21;
                            } else {
                                r15 = r55;
                                r21 = r72;
                                r18 = r84;
                                unsafe = unsafe2;
                                r19 = r182;
                                if (r110 == 50) {
                                    if (r102 == 2) {
                                        parseMapField(t, bArr, r15, r31, r18, j, registers);
                                        throw null;
                                    }
                                } else {
                                    obj = null;
                                    r06 = parseOneofField(t, bArr, r15, r31, r19, r17, r102, r09, r110, j, r18, registers);
                                    if (r06 == r15) {
                                        r7 = r32;
                                        r2 = r06;
                                        r10 = r18;
                                        r8 = r19;
                                        if (r8 != r7 && r7 != 0) {
                                            messageSchema = this;
                                            r06 = r2;
                                            r16 = r7;
                                            r4 = r8;
                                            r6 = r20;
                                            r72 = r21;
                                        } else {
                                            registers2 = registers;
                                            if (!this.hasExtensions && registers2.extensionRegistry != ExtensionRegistryLite.getEmptyRegistry()) {
                                                r06 = ArrayDecoders.decodeExtensionOrUnknownField(r8, bArr, r2, r31, t, this.defaultInstance, registers);
                                            } else {
                                                r06 = ArrayDecoders.decodeUnknownField(r8, bArr, r2, r31, getMutableUnknownFields(t), registers);
                                            }
                                            t3 = t;
                                            bArr2 = bArr;
                                            r132 = r31;
                                            r16 = r7;
                                            r4 = r8;
                                            messageSchema2 = this;
                                            r33 = r10;
                                            r22 = r17;
                                            r6 = r20;
                                            r72 = r21;
                                            unsafe2 = unsafe;
                                        }
                                    }
                                }
                            }
                            messageSchema2 = this;
                            t3 = t;
                            bArr2 = bArr;
                            r132 = r31;
                            r16 = r32;
                            registers2 = registers;
                            r22 = r17;
                            r33 = r18;
                            r4 = r19;
                            r6 = r20;
                            r72 = r21;
                            unsafe2 = unsafe;
                        }
                        r42 = r15;
                        r1 = r32;
                        r10 = r18;
                        r6 = r20;
                        r72 = r21;
                    }
                }
                r2 = r42;
                r20 = r6;
                r21 = r72;
                r8 = r19;
                obj = null;
                r7 = r1;
                if (r8 != r7) {
                }
                registers2 = registers;
                if (!this.hasExtensions) {
                }
                r06 = ArrayDecoders.decodeUnknownField(r8, bArr, r2, r31, getMutableUnknownFields(t), registers);
                t3 = t;
                bArr2 = bArr;
                r132 = r31;
                r16 = r7;
                r4 = r8;
                messageSchema2 = this;
                r33 = r10;
                r22 = r17;
                r6 = r20;
                r72 = r21;
                unsafe2 = unsafe;
            } else {
                unsafe = unsafe2;
                messageSchema = messageSchema2;
                obj = null;
            }
        }
        if (r6 != -1) {
            t2 = t;
            unsafe.putInt(t2, r6, r72);
        } else {
            t2 = t;
        }
        for (int r26 = messageSchema.checkInitializedCount; r26 < messageSchema.repeatedFieldOffsetStart; r26++) {
            messageSchema.filterMapUnknownEnumValues(t2, messageSchema.intArray[r26], obj, messageSchema.unknownFieldSchema);
        }
        if (r16 == 0) {
            if (r06 != r31) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (r06 > r31 || r4 != r16) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return r06;
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x01f0, code lost:            if (r0 != r15) goto L111;     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0241, code lost:            r2 = r0;     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x023e, code lost:            r2 = r17;     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x023c, code lost:            if (r0 != r15) goto L111;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x006a. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r28v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v17, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void parseProto3Message(java.lang.Object r28, byte[] r29, int r30, int r31, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 664
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.parseProto3Message(java.lang.Object, byte[], int, int, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x002f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public final int parseRepeatedField(T t, byte[] bArr, int r16, int r17, int r18, int r19, int r20, int r21, long j, int r24, long j2, ArrayDecoders.Registers registers) throws IOException {
        int decodeVarint32List;
        int r11;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t, j2);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            if (size == 0) {
                r11 = 10;
            } else {
                r11 = size * 2;
            }
            protobufList = protobufList.mutableCopyWithCapacity(r11);
            unsafe.putObject(t, j2, protobufList);
        }
        switch (r24) {
            case 18:
            case 35:
                if (r20 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, r16, protobufList, registers);
                }
                if (r20 == 1) {
                    return ArrayDecoders.decodeDoubleList(r18, bArr, r16, r17, protobufList, registers);
                }
                return r16;
            case 19:
            case 36:
                if (r20 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, r16, protobufList, registers);
                }
                if (r20 == 5) {
                    return ArrayDecoders.decodeFloatList(r18, bArr, r16, r17, protobufList, registers);
                }
                return r16;
            case 20:
            case 21:
            case 37:
            case 38:
                if (r20 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, r16, protobufList, registers);
                }
                if (r20 == 0) {
                    return ArrayDecoders.decodeVarint64List(r18, bArr, r16, r17, protobufList, registers);
                }
                return r16;
            case 22:
            case 29:
            case 39:
            case 43:
                if (r20 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, r16, protobufList, registers);
                }
                if (r20 == 0) {
                    return ArrayDecoders.decodeVarint32List(r18, bArr, r16, r17, protobufList, registers);
                }
                return r16;
            case 23:
            case 32:
            case 40:
            case 46:
                if (r20 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, r16, protobufList, registers);
                }
                if (r20 == 1) {
                    return ArrayDecoders.decodeFixed64List(r18, bArr, r16, r17, protobufList, registers);
                }
                return r16;
            case 24:
            case 31:
            case 41:
            case 45:
                if (r20 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, r16, protobufList, registers);
                }
                if (r20 == 5) {
                    return ArrayDecoders.decodeFixed32List(r18, bArr, r16, r17, protobufList, registers);
                }
                return r16;
            case 25:
            case 42:
                if (r20 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, r16, protobufList, registers);
                }
                if (r20 == 0) {
                    return ArrayDecoders.decodeBoolList(r18, bArr, r16, r17, protobufList, registers);
                }
                return r16;
            case 26:
                if (r20 == 2) {
                    if ((j & 536870912) == 0) {
                        return ArrayDecoders.decodeStringList(r18, bArr, r16, r17, protobufList, registers);
                    }
                    return ArrayDecoders.decodeStringListRequireUtf8(r18, bArr, r16, r17, protobufList, registers);
                }
                return r16;
            case 27:
                if (r20 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(r21), r18, bArr, r16, r17, protobufList, registers);
                }
                return r16;
            case 28:
                if (r20 == 2) {
                    return ArrayDecoders.decodeBytesList(r18, bArr, r16, r17, protobufList, registers);
                }
                return r16;
            case 30:
            case 44:
                if (r20 == 2) {
                    decodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, r16, protobufList, registers);
                } else {
                    if (r20 == 0) {
                        decodeVarint32List = ArrayDecoders.decodeVarint32List(r18, bArr, r16, r17, protobufList, registers);
                    }
                    return r16;
                }
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.DEFAULT_INSTANCE) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(r19, protobufList, getEnumFieldVerifier(r21), unknownFieldSetLite, this.unknownFieldSchema);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return decodeVarint32List;
            case 33:
            case 47:
                if (r20 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, r16, protobufList, registers);
                }
                if (r20 == 0) {
                    return ArrayDecoders.decodeSInt32List(r18, bArr, r16, r17, protobufList, registers);
                }
                return r16;
            case 34:
            case 48:
                if (r20 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, r16, protobufList, registers);
                }
                if (r20 == 0) {
                    return ArrayDecoders.decodeSInt64List(r18, bArr, r16, r17, protobufList, registers);
                }
                return r16;
            case 49:
                if (r20 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(r21), r18, bArr, r16, r17, protobufList, registers);
                }
                return r16;
            default:
                return r16;
        }
    }

    public final <E> void readGroupList(Object obj, long j, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(j, obj), schema, extensionRegistryLite);
    }

    public final <E> void readMessageList(Object obj, int r4, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(r4 & 1048575, obj), schema, extensionRegistryLite);
    }

    public final void readString(Object obj, int r4, Reader reader) throws IOException {
        boolean z;
        if ((536870912 & r4) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            UnsafeUtil.putObject(r4 & 1048575, obj, reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(r4 & 1048575, obj, reader.readString());
        } else {
            UnsafeUtil.putObject(r4 & 1048575, obj, reader.readBytes());
        }
    }

    public final void readStringList(Object obj, int r5, Reader reader) throws IOException {
        boolean z;
        if ((536870912 & r5) != 0) {
            z = true;
        } else {
            z = false;
        }
        ListFieldSchema listFieldSchema = this.listFieldSchema;
        if (z) {
            reader.readStringListRequireUtf8(listFieldSchema.mutableListAt(r5 & 1048575, obj));
        } else {
            reader.readStringList(listFieldSchema.mutableListAt(r5 & 1048575, obj));
        }
    }

    public final void setFieldPresent(int r4, Object obj) {
        if (this.proto3) {
            return;
        }
        int r42 = this.buffer[r4 + 2];
        long j = r42 & 1048575;
        UnsafeUtil.putInt(j, UnsafeUtil.getInt(j, obj) | (1 << (r42 >>> 20)), obj);
    }

    public final void setOneofPresent(int r3, int r4, Object obj) {
        UnsafeUtil.putInt(this.buffer[r4 + 2] & 1048575, r3, obj);
    }

    public final int slowPositionForFieldNumber(int r6, int r7) {
        int[] r0 = this.buffer;
        int length = (r0.length / 3) - 1;
        while (r7 <= length) {
            int r2 = (length + r7) >>> 1;
            int r3 = r2 * 3;
            int r4 = r0[r3];
            if (r6 == r4) {
                return r3;
            }
            if (r6 < r4) {
                length = r2 - 1;
            } else {
                r7 = r2 + 1;
            }
        }
        return -1;
    }

    public final int typeAndOffsetAt(int r2) {
        return this.buffer[r2 + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0237  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeFieldsInAscendingOrderProto2(java.lang.Object r21, com.google.crypto.tink.shaded.protobuf.CodedOutputStreamWriter r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.writeFieldsInAscendingOrderProto2(java.lang.Object, com.google.crypto.tink.shaded.protobuf.CodedOutputStreamWriter):void");
    }

    public final void writeMapHelper(CodedOutputStreamWriter codedOutputStreamWriter, int r3, Object obj, int r5) throws IOException {
        if (obj != null) {
            Object mapFieldDefaultEntry = getMapFieldDefaultEntry(r5);
            MapFieldSchema mapFieldSchema = this.mapFieldSchema;
            mapFieldSchema.forMapMetadata(mapFieldDefaultEntry);
            MapFieldLite forMapData = mapFieldSchema.forMapData(obj);
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            codedOutputStream.getClass();
            Iterator it = forMapData.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                codedOutputStream.writeTag(r3, 2);
                entry.getKey();
                entry.getValue();
                throw null;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:323:0x05ac. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04f4  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0538  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0548 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x062d  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0641  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0683  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x069d  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x06b1  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x06d9  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x06ed  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0700  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x071e  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x073b  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0748  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x075d  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0772  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0785  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0798  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x07ab  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x07be  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x07d1  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x07e4  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x07f6  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0808  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x081a  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x082c  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x083e  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0850  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0868  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x087c  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0891  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x08a7  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x08ba  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x08cd  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x08e2  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x08f5  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x090c  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0920  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0933  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x094b  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x095f  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0973  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0987  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x099b  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x09af  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x09c6  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x09e0  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x09f5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0a0a  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0a1f  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x0a34  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x0a49  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x0a5e  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0a75  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x0a8e  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x0aa3  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0ab8  */
    /* JADX WARN: Removed duplicated region for block: B:485:0x0acd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0ae1  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0af5  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x0b09  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x0b1d  */
    /* JADX WARN: Removed duplicated region for block: B:510:0x0b31  */
    /* JADX WARN: Removed duplicated region for block: B:515:0x0718  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x0b4b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0180  */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void writeTo(java.lang.Object r19, com.google.crypto.tink.shaded.protobuf.CodedOutputStreamWriter r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.writeTo(java.lang.Object, com.google.crypto.tink.shaded.protobuf.CodedOutputStreamWriter):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0089. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:236:0x05ba A[LOOP:3: B:235:0x05b8->B:236:0x05ba, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0598 A[Catch: all -> 0x05b3, TryCatch #1 {all -> 0x05b3, blocks: (B:268:0x0051, B:254:0x0066, B:214:0x0580, B:24:0x0593, B:26:0x0598, B:27:0x059d), top: B:267:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x05a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0016 A[SYNTHETIC] */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mergeFrom(T r20, com.google.crypto.tink.shaded.protobuf.Reader r21, com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.mergeFrom(java.lang.Object, com.google.crypto.tink.shaded.protobuf.Reader, com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite):void");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final void mergeFrom(T t, byte[] bArr, int r11, int r12, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(t, bArr, r11, r12, registers);
        } else {
            parseProto2Message(t, bArr, r11, r12, 0, registers);
        }
    }
}
