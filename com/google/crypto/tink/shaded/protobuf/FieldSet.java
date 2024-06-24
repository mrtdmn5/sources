package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.LazyField;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.SmallSortedMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class FieldSet<T extends FieldDescriptorLite<T>> {
    public static final FieldSet DEFAULT_INSTANCE = new FieldSet(0);
    public final SmallSortedMap<T, Object> fields;
    public boolean hasLazyField;
    public boolean isImmutable;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.FieldSet$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

        static {
            int[] r0 = new int[WireFormat$FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            try {
                r0[WireFormat$FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.SFIXED32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.SINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.SINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat$FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] r9 = new int[WireFormat$JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = r9;
            try {
                r9[WireFormat$JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat$JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        WireFormat$JavaType getLiteJavaType();

        void getLiteType();

        void getNumber();

        GeneratedMessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);

        void isPacked();

        void isRepeated();
    }

    public FieldSet() {
        int r0 = SmallSortedMap.$r8$clinit;
        this.fields = new SmallSortedMap.AnonymousClass1(16);
    }

    public static int computeElementSize(WireFormat$FieldType wireFormat$FieldType, int r2, Object obj) {
        int computeTagSize = CodedOutputStream.computeTagSize(r2);
        if (wireFormat$FieldType == WireFormat$FieldType.GROUP) {
            computeTagSize *= 2;
        }
        return computeElementSizeNoTag(wireFormat$FieldType, obj) + computeTagSize;
    }

    public static int computeElementSizeNoTag(WireFormat$FieldType wireFormat$FieldType, Object obj) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[wireFormat$FieldType.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                Logger logger = CodedOutputStream.logger;
                return 8;
            case 2:
                ((Float) obj).floatValue();
                Logger logger2 = CodedOutputStream.logger;
                return 4;
            case 3:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                Logger logger3 = CodedOutputStream.logger;
                return 8;
            case 7:
                ((Integer) obj).intValue();
                Logger logger4 = CodedOutputStream.logger;
                return 4;
            case 8:
                ((Boolean) obj).booleanValue();
                Logger logger5 = CodedOutputStream.logger;
                return 1;
            case 9:
                Logger logger6 = CodedOutputStream.logger;
                return ((MessageLite) obj).getSerializedSize();
            case 10:
                if (obj instanceof LazyField) {
                    return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) obj);
                }
                Logger logger7 = CodedOutputStream.logger;
                int serializedSize = ((MessageLite) obj).getSerializedSize();
                return CodedOutputStream.computeUInt32SizeNoTag(serializedSize) + serializedSize;
            case 11:
                if (obj instanceof ByteString) {
                    Logger logger8 = CodedOutputStream.logger;
                    int size = ((ByteString) obj).size();
                    return CodedOutputStream.computeUInt32SizeNoTag(size) + size;
                }
                return CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 12:
                if (obj instanceof ByteString) {
                    Logger logger9 = CodedOutputStream.logger;
                    int size2 = ((ByteString) obj).size();
                    return CodedOutputStream.computeUInt32SizeNoTag(size2) + size2;
                }
                Logger logger10 = CodedOutputStream.logger;
                int length = ((byte[]) obj).length;
                return CodedOutputStream.computeUInt32SizeNoTag(length) + length;
            case 13:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                Logger logger11 = CodedOutputStream.logger;
                return 4;
            case 15:
                ((Long) obj).longValue();
                Logger logger12 = CodedOutputStream.logger;
                return 8;
            case 16:
                int intValue = ((Integer) obj).intValue();
                return CodedOutputStream.computeUInt32SizeNoTag((intValue >> 31) ^ (intValue << 1));
            case 17:
                long longValue = ((Long) obj).longValue();
                return CodedOutputStream.computeUInt64SizeNoTag((longValue >> 63) ^ (longValue << 1));
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    return CodedOutputStream.computeInt32SizeNoTag(((Internal.EnumLite) obj).getNumber());
                }
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        fieldDescriptorLite.getLiteType();
        fieldDescriptorLite.getNumber();
        fieldDescriptorLite.isRepeated();
        return computeElementSize(null, 0, obj);
    }

    public static int getMessageSetSerializedSize(Map.Entry entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (fieldDescriptorLite.getLiteJavaType() == WireFormat$JavaType.MESSAGE) {
            fieldDescriptorLite.isRepeated();
            fieldDescriptorLite.isPacked();
            if (value instanceof LazyField) {
                ((FieldDescriptorLite) entry.getKey()).getNumber();
                return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) value) + CodedOutputStream.computeTagSize(3) + CodedOutputStream.computeUInt32Size(2, 0) + (CodedOutputStream.computeTagSize(1) * 2);
            }
            ((FieldDescriptorLite) entry.getKey()).getNumber();
            int computeUInt32Size = CodedOutputStream.computeUInt32Size(2, 0) + (CodedOutputStream.computeTagSize(1) * 2);
            int computeTagSize = CodedOutputStream.computeTagSize(3);
            int serializedSize = ((MessageLite) value).getSerializedSize();
            return CodedOutputStream.computeUInt32SizeNoTag(serializedSize) + serializedSize + computeTagSize + computeUInt32Size;
        }
        return computeFieldSize(fieldDescriptorLite, value);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:            if ((r2 instanceof com.google.crypto.tink.shaded.protobuf.Internal.EnumLite) == false) goto L26;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:            if ((r2 instanceof byte[]) == false) goto L26;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:            if ((r2 instanceof com.google.crypto.tink.shaded.protobuf.LazyField) == false) goto L26;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void verifyType(com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1, java.lang.Object r2) {
        /*
            java.nio.charset.Charset r0 = com.google.crypto.tink.shaded.protobuf.Internal.UTF_8
            r2.getClass()
            int[] r0 = com.google.crypto.tink.shaded.protobuf.FieldSet.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType
            com.google.crypto.tink.shaded.protobuf.WireFormat$JavaType r1 = r1.getJavaType()
            int r1 = r1.ordinal()
            r1 = r0[r1]
            r0 = 0
            switch(r1) {
                case 1: goto L42;
                case 2: goto L3f;
                case 3: goto L3c;
                case 4: goto L39;
                case 5: goto L36;
                case 6: goto L33;
                case 7: goto L28;
                case 8: goto L1f;
                case 9: goto L16;
                default: goto L15;
            }
        L15:
            goto L44
        L16:
            boolean r1 = r2 instanceof com.google.crypto.tink.shaded.protobuf.MessageLite
            if (r1 != 0) goto L30
            boolean r1 = r2 instanceof com.google.crypto.tink.shaded.protobuf.LazyField
            if (r1 == 0) goto L44
            goto L30
        L1f:
            boolean r1 = r2 instanceof java.lang.Integer
            if (r1 != 0) goto L30
            boolean r1 = r2 instanceof com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
            if (r1 == 0) goto L44
            goto L30
        L28:
            boolean r1 = r2 instanceof com.google.crypto.tink.shaded.protobuf.ByteString
            if (r1 != 0) goto L30
            boolean r1 = r2 instanceof byte[]
            if (r1 == 0) goto L44
        L30:
            r1 = 1
            r0 = r1
            goto L44
        L33:
            boolean r0 = r2 instanceof java.lang.String
            goto L44
        L36:
            boolean r0 = r2 instanceof java.lang.Boolean
            goto L44
        L39:
            boolean r0 = r2 instanceof java.lang.Double
            goto L44
        L3c:
            boolean r0 = r2 instanceof java.lang.Float
            goto L44
        L3f:
            boolean r0 = r2 instanceof java.lang.Long
            goto L44
        L42:
            boolean r0 = r2 instanceof java.lang.Integer
        L44:
            if (r0 == 0) goto L47
            return
        L47:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Wrong object type used with protocol message reflection."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.FieldSet.verifyType(com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType, java.lang.Object):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldSet)) {
            return false;
        }
        return this.fields.equals(((FieldSet) obj).fields);
    }

    public final Object getField(T t) {
        Object obj = this.fields.get(t);
        if (obj instanceof LazyField) {
            return ((LazyField) obj).getValue(null);
        }
        return obj;
    }

    public final int getSerializedSize() {
        SmallSortedMap<T, Object> smallSortedMap;
        int r0 = 0;
        int r1 = 0;
        while (true) {
            smallSortedMap = this.fields;
            if (r0 >= smallSortedMap.getNumArrayEntries()) {
                break;
            }
            Map.Entry<T, Object> arrayEntryAt = smallSortedMap.getArrayEntryAt(r0);
            r1 += computeFieldSize(arrayEntryAt.getKey(), arrayEntryAt.getValue());
            r0++;
        }
        for (Map.Entry<T, Object> entry : smallSortedMap.getOverflowEntries()) {
            r1 += computeFieldSize(entry.getKey(), entry.getValue());
        }
        return r1;
    }

    public final int hashCode() {
        return this.fields.hashCode();
    }

    public final boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public final boolean isInitialized() {
        int r1 = 0;
        while (true) {
            SmallSortedMap<T, Object> smallSortedMap = this.fields;
            if (r1 < smallSortedMap.getNumArrayEntries()) {
                if (!isInitialized(smallSortedMap.getArrayEntryAt(r1))) {
                    return false;
                }
                r1++;
            } else {
                Iterator<Map.Entry<T, Object>> it = smallSortedMap.getOverflowEntries().iterator();
                while (it.hasNext()) {
                    if (!isInitialized(it.next())) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        boolean z = this.hasLazyField;
        SmallSortedMap<T, Object> smallSortedMap = this.fields;
        if (z) {
            return new LazyField.LazyIterator(smallSortedMap.entrySet().iterator());
        }
        return smallSortedMap.entrySet().iterator();
    }

    public final void mergeFromField(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).getValue(null);
        }
        key.isRepeated();
        WireFormat$JavaType liteJavaType = key.getLiteJavaType();
        WireFormat$JavaType wireFormat$JavaType = WireFormat$JavaType.MESSAGE;
        SmallSortedMap<T, Object> smallSortedMap = this.fields;
        if (liteJavaType == wireFormat$JavaType) {
            Object field = getField(key);
            if (field == null) {
                if (value instanceof byte[]) {
                    byte[] bArr = (byte[]) value;
                    byte[] bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    value = bArr2;
                }
                smallSortedMap.put((SmallSortedMap<T, Object>) key, (T) value);
                return;
            }
            smallSortedMap.put((SmallSortedMap<T, Object>) key, (T) key.internalMergeFrom(((MessageLite) field).toBuilder$1(), (MessageLite) value).build());
            return;
        }
        if (value instanceof byte[]) {
            byte[] bArr3 = (byte[]) value;
            byte[] bArr4 = new byte[bArr3.length];
            System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
            value = bArr4;
        }
        smallSortedMap.put((SmallSortedMap<T, Object>) key, (T) value);
    }

    public final void setField(T t, Object obj) {
        t.isRepeated();
        t.getLiteType();
        verifyType(null, obj);
        if (obj instanceof LazyField) {
            this.hasLazyField = true;
        }
        this.fields.put((SmallSortedMap<T, Object>) t, (T) obj);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final FieldSet<T> m1646clone() {
        SmallSortedMap<T, Object> smallSortedMap;
        FieldSet<T> fieldSet = new FieldSet<>();
        int r1 = 0;
        while (true) {
            smallSortedMap = this.fields;
            if (r1 >= smallSortedMap.getNumArrayEntries()) {
                break;
            }
            Map.Entry<T, Object> arrayEntryAt = smallSortedMap.getArrayEntryAt(r1);
            fieldSet.setField(arrayEntryAt.getKey(), arrayEntryAt.getValue());
            r1++;
        }
        for (Map.Entry<T, Object> entry : smallSortedMap.getOverflowEntries()) {
            fieldSet.setField(entry.getKey(), entry.getValue());
        }
        fieldSet.hasLazyField = this.hasLazyField;
        return fieldSet;
    }

    public FieldSet(int r3) {
        int r32 = SmallSortedMap.$r8$clinit;
        SmallSortedMap.AnonymousClass1 anonymousClass1 = new SmallSortedMap.AnonymousClass1(0);
        this.fields = anonymousClass1;
        if (!this.isImmutable) {
            anonymousClass1.makeImmutable();
            this.isImmutable = true;
        }
        if (this.isImmutable) {
            return;
        }
        anonymousClass1.makeImmutable();
        this.isImmutable = true;
    }

    public static <T extends FieldDescriptorLite<T>> boolean isInitialized(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.getLiteJavaType() == WireFormat$JavaType.MESSAGE) {
            key.isRepeated();
            Object value = entry.getValue();
            if (value instanceof MessageLite) {
                if (!((MessageLite) value).isInitialized()) {
                    return false;
                }
            } else {
                if (value instanceof LazyField) {
                    return true;
                }
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }
}
