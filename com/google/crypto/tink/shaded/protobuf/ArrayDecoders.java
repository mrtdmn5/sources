package com.google.crypto.tink.shaded.protobuf;

import com.animaconnected.secondo.R;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.Internal;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class ArrayDecoders {

    /* loaded from: classes3.dex */
    public static final class Registers {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;

        public Registers(ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            this.extensionRegistry = extensionRegistryLite;
        }
    }

    public static int decodeBoolList(int r7, byte[] bArr, int r9, int r10, Internal.ProtobufList<?> protobufList, Registers registers) {
        boolean z;
        boolean z2;
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, r9, registers);
        if (registers.long1 != 0) {
            z = true;
        } else {
            z = false;
        }
        booleanArrayList.addBoolean(z);
        while (decodeVarint64 < r10) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (r7 != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            if (registers.long1 != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            booleanArrayList.addBoolean(z2);
        }
        return decodeVarint64;
    }

    public static int decodeBytes(byte[] bArr, int r3, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, r3, registers);
        int r0 = registers.int1;
        if (r0 >= 0) {
            if (r0 <= bArr.length - decodeVarint32) {
                if (r0 == 0) {
                    registers.object1 = ByteString.EMPTY;
                    return decodeVarint32;
                }
                registers.object1 = ByteString.copyFrom(bArr, decodeVarint32, r0);
                return decodeVarint32 + r0;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public static int decodeBytesList(int r2, byte[] bArr, int r4, int r5, Internal.ProtobufList<?> protobufList, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, r4, registers);
        int r0 = registers.int1;
        if (r0 >= 0) {
            if (r0 <= bArr.length - decodeVarint32) {
                if (r0 == 0) {
                    protobufList.add(ByteString.EMPTY);
                } else {
                    protobufList.add(ByteString.copyFrom(bArr, decodeVarint32, r0));
                    decodeVarint32 += r0;
                }
                while (decodeVarint32 < r5) {
                    int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
                    if (r2 != registers.int1) {
                        break;
                    }
                    decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
                    int r02 = registers.int1;
                    if (r02 >= 0) {
                        if (r02 <= bArr.length - decodeVarint32) {
                            if (r02 == 0) {
                                protobufList.add(ByteString.EMPTY);
                            } else {
                                protobufList.add(ByteString.copyFrom(bArr, decodeVarint32, r02));
                                decodeVarint32 += r02;
                            }
                        } else {
                            throw InvalidProtocolBufferException.truncatedMessage();
                        }
                    } else {
                        throw InvalidProtocolBufferException.negativeSize();
                    }
                }
                return decodeVarint32;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public static double decodeDouble(int r0, byte[] bArr) {
        return Double.longBitsToDouble(decodeFixed64(r0, bArr));
    }

    public static int decodeDoubleList(int r3, byte[] bArr, int r5, int r6, Internal.ProtobufList<?> protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        doubleArrayList.addDouble(Double.longBitsToDouble(decodeFixed64(r5, bArr)));
        int r52 = r5 + 8;
        while (r52 < r6) {
            int decodeVarint32 = decodeVarint32(bArr, r52, registers);
            if (r3 != registers.int1) {
                break;
            }
            doubleArrayList.addDouble(Double.longBitsToDouble(decodeFixed64(decodeVarint32, bArr)));
            r52 = decodeVarint32 + 8;
        }
        return r52;
    }

    public static int decodeExtensionOrUnknownField(int r6, byte[] bArr, int r8, int r9, Object obj, MessageLite messageLite, Registers registers) throws IOException {
        ExtensionRegistryLite extensionRegistryLite = registers.extensionRegistry;
        extensionRegistryLite.getClass();
        if (extensionRegistryLite.extensionsByNumber.get(new ExtensionRegistryLite.ObjectIntPair(r6 >>> 3, messageLite)) == null) {
            return decodeUnknownField(r6, bArr, r8, r9, MessageSchema.getMutableUnknownFields(obj), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet = extendableMessage.extensions;
        if (fieldSet.isImmutable) {
            extendableMessage.extensions = fieldSet.m1646clone();
        }
        throw null;
    }

    public static int decodeFixed32(int r2, byte[] bArr) {
        return ((bArr[r2 + 3] & 255) << 24) | (bArr[r2] & 255) | ((bArr[r2 + 1] & 255) << 8) | ((bArr[r2 + 2] & 255) << 16);
    }

    public static int decodeFixed32List(int r2, byte[] bArr, int r4, int r5, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        intArrayList.addInt(decodeFixed32(r4, bArr));
        int r42 = r4 + 4;
        while (r42 < r5) {
            int decodeVarint32 = decodeVarint32(bArr, r42, registers);
            if (r2 != registers.int1) {
                break;
            }
            intArrayList.addInt(decodeFixed32(decodeVarint32, bArr));
            r42 = decodeVarint32 + 4;
        }
        return r42;
    }

    public static long decodeFixed64(int r7, byte[] bArr) {
        return ((bArr[r7 + 7] & 255) << 56) | (bArr[r7] & 255) | ((bArr[r7 + 1] & 255) << 8) | ((bArr[r7 + 2] & 255) << 16) | ((bArr[r7 + 3] & 255) << 24) | ((bArr[r7 + 4] & 255) << 32) | ((bArr[r7 + 5] & 255) << 40) | ((bArr[r7 + 6] & 255) << 48);
    }

    public static int decodeFixed64List(int r3, byte[] bArr, int r5, int r6, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        longArrayList.addLong(decodeFixed64(r5, bArr));
        int r52 = r5 + 8;
        while (r52 < r6) {
            int decodeVarint32 = decodeVarint32(bArr, r52, registers);
            if (r3 != registers.int1) {
                break;
            }
            longArrayList.addLong(decodeFixed64(decodeVarint32, bArr));
            r52 = decodeVarint32 + 8;
        }
        return r52;
    }

    public static float decodeFloat(int r0, byte[] bArr) {
        return Float.intBitsToFloat(decodeFixed32(r0, bArr));
    }

    public static int decodeFloatList(int r2, byte[] bArr, int r4, int r5, Internal.ProtobufList<?> protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        floatArrayList.addFloat(Float.intBitsToFloat(decodeFixed32(r4, bArr)));
        int r42 = r4 + 4;
        while (r42 < r5) {
            int decodeVarint32 = decodeVarint32(bArr, r42, registers);
            if (r2 != registers.int1) {
                break;
            }
            floatArrayList.addFloat(Float.intBitsToFloat(decodeFixed32(decodeVarint32, bArr)));
            r42 = decodeVarint32 + 4;
        }
        return r42;
    }

    public static int decodeGroupField(Schema schema, byte[] bArr, int r10, int r11, int r12, Registers registers) throws IOException {
        MessageSchema messageSchema = (MessageSchema) schema;
        Object newInstance = messageSchema.newInstance();
        int parseProto2Message = messageSchema.parseProto2Message(newInstance, bArr, r10, r11, r12, registers);
        messageSchema.makeImmutable(newInstance);
        registers.object1 = newInstance;
        return parseProto2Message;
    }

    public static int decodeGroupList(Schema schema, int r8, byte[] bArr, int r10, int r11, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int r0 = (r8 & (-8)) | 4;
        int decodeGroupField = decodeGroupField(schema, bArr, r10, r11, r0, registers);
        protobufList.add(registers.object1);
        while (decodeGroupField < r11) {
            int decodeVarint32 = decodeVarint32(bArr, decodeGroupField, registers);
            if (r8 != registers.int1) {
                break;
            }
            decodeGroupField = decodeGroupField(schema, bArr, decodeVarint32, r11, r0, registers);
            protobufList.add(registers.object1);
        }
        return decodeGroupField;
    }

    public static int decodeMessageField(Schema schema, byte[] bArr, int r8, int r9, Registers registers) throws IOException {
        int r0 = r8 + 1;
        int r82 = bArr[r8];
        if (r82 < 0) {
            r0 = decodeVarint32(r82, bArr, r0, registers);
            r82 = registers.int1;
        }
        int r3 = r0;
        if (r82 >= 0 && r82 <= r9 - r3) {
            Object newInstance = schema.newInstance();
            int r83 = r82 + r3;
            schema.mergeFrom(newInstance, bArr, r3, r83, registers);
            schema.makeImmutable(newInstance);
            registers.object1 = newInstance;
            return r83;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodeMessageList(Schema<?> schema, int r3, byte[] bArr, int r5, int r6, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int decodeMessageField = decodeMessageField(schema, bArr, r5, r6, registers);
        protobufList.add(registers.object1);
        while (decodeMessageField < r6) {
            int decodeVarint32 = decodeVarint32(bArr, decodeMessageField, registers);
            if (r3 != registers.int1) {
                break;
            }
            decodeMessageField = decodeMessageField(schema, bArr, decodeVarint32, r6, registers);
            protobufList.add(registers.object1);
        }
        return decodeMessageField;
    }

    public static int decodePackedBoolList(byte[] bArr, int r6, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        boolean z;
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, r6, registers);
        int r0 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < r0) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            if (registers.long1 != 0) {
                z = true;
            } else {
                z = false;
            }
            booleanArrayList.addBoolean(z);
        }
        if (decodeVarint32 == r0) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedDoubleList(byte[] bArr, int r3, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, r3, registers);
        int r5 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < r5) {
            doubleArrayList.addDouble(Double.longBitsToDouble(decodeFixed64(decodeVarint32, bArr)));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == r5) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed32List(byte[] bArr, int r2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, r2, registers);
        int r4 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < r4) {
            intArrayList.addInt(decodeFixed32(decodeVarint32, bArr));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == r4) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed64List(byte[] bArr, int r3, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, r3, registers);
        int r5 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < r5) {
            longArrayList.addLong(decodeFixed64(decodeVarint32, bArr));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == r5) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFloatList(byte[] bArr, int r2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, r2, registers);
        int r4 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < r4) {
            floatArrayList.addFloat(Float.intBitsToFloat(decodeFixed32(decodeVarint32, bArr)));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == r4) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt32List(byte[] bArr, int r3, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, r3, registers);
        int r0 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < r0) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        if (decodeVarint32 == r0) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt64List(byte[] bArr, int r4, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, r4, registers);
        int r0 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < r0) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        if (decodeVarint32 == r0) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint32List(byte[] bArr, int r3, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, r3, registers);
        int r0 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < r0) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, registers);
            intArrayList.addInt(registers.int1);
        }
        if (decodeVarint32 == r0) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint64List(byte[] bArr, int r4, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, r4, registers);
        int r0 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < r0) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        if (decodeVarint32 == r0) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodeSInt32List(int r2, byte[] bArr, int r4, int r5, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, r4, registers);
        intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        while (decodeVarint32 < r5) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (r2 != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        return decodeVarint32;
    }

    public static int decodeSInt64List(int r2, byte[] bArr, int r4, int r5, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, r4, registers);
        longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        while (decodeVarint64 < r5) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (r2 != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        return decodeVarint64;
    }

    public static int decodeString(byte[] bArr, int r4, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, r4, registers);
        int r0 = registers.int1;
        if (r0 >= 0) {
            if (r0 == 0) {
                registers.object1 = "";
                return decodeVarint32;
            }
            registers.object1 = new String(bArr, decodeVarint32, r0, Internal.UTF_8);
            return decodeVarint32 + r0;
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public static int decodeStringList(int r4, byte[] bArr, int r6, int r7, Internal.ProtobufList<?> protobufList, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, r6, registers);
        int r0 = registers.int1;
        if (r0 >= 0) {
            if (r0 == 0) {
                protobufList.add("");
            } else {
                protobufList.add(new String(bArr, decodeVarint32, r0, Internal.UTF_8));
                decodeVarint32 += r0;
            }
            while (decodeVarint32 < r7) {
                int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
                if (r4 != registers.int1) {
                    break;
                }
                decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
                int r02 = registers.int1;
                if (r02 >= 0) {
                    if (r02 == 0) {
                        protobufList.add("");
                    } else {
                        protobufList.add(new String(bArr, decodeVarint32, r02, Internal.UTF_8));
                        decodeVarint32 += r02;
                    }
                } else {
                    throw InvalidProtocolBufferException.negativeSize();
                }
            }
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public static int decodeStringListRequireUtf8(int r5, byte[] bArr, int r7, int r8, Internal.ProtobufList<?> protobufList, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, r7, registers);
        int r0 = registers.int1;
        if (r0 >= 0) {
            if (r0 == 0) {
                protobufList.add("");
            } else {
                int r2 = decodeVarint32 + r0;
                if (Utf8.isValidUtf8(bArr, decodeVarint32, r2)) {
                    protobufList.add(new String(bArr, decodeVarint32, r0, Internal.UTF_8));
                    decodeVarint32 = r2;
                } else {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            while (decodeVarint32 < r8) {
                int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
                if (r5 != registers.int1) {
                    break;
                }
                decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
                int r02 = registers.int1;
                if (r02 >= 0) {
                    if (r02 == 0) {
                        protobufList.add("");
                    } else {
                        int r22 = decodeVarint32 + r02;
                        if (Utf8.isValidUtf8(bArr, decodeVarint32, r22)) {
                            protobufList.add(new String(bArr, decodeVarint32, r02, Internal.UTF_8));
                            decodeVarint32 = r22;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    }
                } else {
                    throw InvalidProtocolBufferException.negativeSize();
                }
            }
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public static int decodeStringRequireUtf8(byte[] bArr, int r3, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, r3, registers);
        int r0 = registers.int1;
        if (r0 >= 0) {
            if (r0 == 0) {
                registers.object1 = "";
                return decodeVarint32;
            }
            registers.object1 = Utf8.processor.decodeUtf8(bArr, decodeVarint32, r0);
            return decodeVarint32 + r0;
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public static int decodeUnknownField(int r9, byte[] bArr, int r11, int r12, UnknownFieldSetLite unknownFieldSetLite, Registers registers) throws InvalidProtocolBufferException {
        if ((r9 >>> 3) != 0) {
            int r0 = r9 & 7;
            if (r0 != 0) {
                if (r0 != 1) {
                    if (r0 != 2) {
                        if (r0 != 3) {
                            if (r0 == 5) {
                                unknownFieldSetLite.storeField(r9, Integer.valueOf(decodeFixed32(r11, bArr)));
                                return r11 + 4;
                            }
                            throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
                        }
                        UnknownFieldSetLite unknownFieldSetLite2 = new UnknownFieldSetLite();
                        int r1 = (r9 & (-8)) | 4;
                        int r2 = 0;
                        while (true) {
                            if (r11 >= r12) {
                                break;
                            }
                            int decodeVarint32 = decodeVarint32(bArr, r11, registers);
                            int r112 = registers.int1;
                            if (r112 == r1) {
                                r2 = r112;
                                r11 = decodeVarint32;
                                break;
                            }
                            r2 = r112;
                            r11 = decodeUnknownField(r112, bArr, decodeVarint32, r12, unknownFieldSetLite2, registers);
                        }
                        if (r11 <= r12 && r2 == r1) {
                            unknownFieldSetLite.storeField(r9, unknownFieldSetLite2);
                            return r11;
                        }
                        throw InvalidProtocolBufferException.parseFailure();
                    }
                    int decodeVarint322 = decodeVarint32(bArr, r11, registers);
                    int r122 = registers.int1;
                    if (r122 >= 0) {
                        if (r122 <= bArr.length - decodeVarint322) {
                            if (r122 == 0) {
                                unknownFieldSetLite.storeField(r9, ByteString.EMPTY);
                            } else {
                                unknownFieldSetLite.storeField(r9, ByteString.copyFrom(bArr, decodeVarint322, r122));
                            }
                            return decodeVarint322 + r122;
                        }
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    throw InvalidProtocolBufferException.negativeSize();
                }
                unknownFieldSetLite.storeField(r9, Long.valueOf(decodeFixed64(r11, bArr)));
                return r11 + 8;
            }
            int decodeVarint64 = decodeVarint64(bArr, r11, registers);
            unknownFieldSetLite.storeField(r9, Long.valueOf(registers.long1));
            return decodeVarint64;
        }
        throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    public static int decodeVarint32(byte[] bArr, int r2, Registers registers) {
        int r0 = r2 + 1;
        byte b = bArr[r2];
        if (b >= 0) {
            registers.int1 = b;
            return r0;
        }
        return decodeVarint32(b, bArr, r0, registers);
    }

    public static int decodeVarint32List(int r2, byte[] bArr, int r4, int r5, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, r4, registers);
        intArrayList.addInt(registers.int1);
        while (decodeVarint32 < r5) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (r2 != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
            intArrayList.addInt(registers.int1);
        }
        return decodeVarint32;
    }

    public static int decodeVarint64(byte[] bArr, int r10, Registers registers) {
        int r0 = r10 + 1;
        long j = bArr[r10];
        if (j >= 0) {
            registers.long1 = j;
            return r0;
        }
        int r102 = r0 + 1;
        byte b = bArr[r0];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int r3 = 7;
        while (b < 0) {
            int r02 = r102 + 1;
            r3 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << r3;
            b = bArr[r102];
            r102 = r02;
        }
        registers.long1 = j2;
        return r102;
    }

    public static int decodeVarint64List(int r2, byte[] bArr, int r4, int r5, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, r4, registers);
        longArrayList.addLong(registers.long1);
        while (decodeVarint64 < r5) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (r2 != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        return decodeVarint64;
    }

    public static int skipField(int r3, byte[] bArr, int r5, int r6, Registers registers) throws InvalidProtocolBufferException {
        if ((r3 >>> 3) != 0) {
            int r0 = r3 & 7;
            if (r0 != 0) {
                if (r0 != 1) {
                    if (r0 != 2) {
                        if (r0 != 3) {
                            if (r0 == 5) {
                                return r5 + 4;
                            }
                            throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
                        }
                        int r32 = (r3 & (-8)) | 4;
                        int r02 = 0;
                        while (r5 < r6) {
                            r5 = decodeVarint32(bArr, r5, registers);
                            r02 = registers.int1;
                            if (r02 == r32) {
                                break;
                            }
                            r5 = skipField(r02, bArr, r5, r6, registers);
                        }
                        if (r5 <= r6 && r02 == r32) {
                            return r5;
                        }
                        throw InvalidProtocolBufferException.parseFailure();
                    }
                    return decodeVarint32(bArr, r5, registers) + registers.int1;
                }
                return r5 + 8;
            }
            return decodeVarint64(bArr, r5, registers);
        }
        throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    public static int decodeVarint32(int r1, byte[] bArr, int r3, Registers registers) {
        int r12 = r1 & R.styleable.AppTheme_statusTextH5;
        int r0 = r3 + 1;
        byte b = bArr[r3];
        if (b >= 0) {
            registers.int1 = r12 | (b << 7);
            return r0;
        }
        int r13 = r12 | ((b & Byte.MAX_VALUE) << 7);
        int r32 = r0 + 1;
        byte b2 = bArr[r0];
        if (b2 >= 0) {
            registers.int1 = r13 | (b2 << 14);
            return r32;
        }
        int r14 = r13 | ((b2 & Byte.MAX_VALUE) << 14);
        int r02 = r32 + 1;
        byte b3 = bArr[r32];
        if (b3 >= 0) {
            registers.int1 = r14 | (b3 << 21);
            return r02;
        }
        int r15 = r14 | ((b3 & Byte.MAX_VALUE) << 21);
        int r33 = r02 + 1;
        byte b4 = bArr[r02];
        if (b4 >= 0) {
            registers.int1 = r15 | (b4 << 28);
            return r33;
        }
        int r16 = r15 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int r03 = r33 + 1;
            if (bArr[r33] >= 0) {
                registers.int1 = r16;
                return r03;
            }
            r33 = r03;
        }
    }
}
