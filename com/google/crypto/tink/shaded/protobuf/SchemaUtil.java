package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet;
import com.google.crypto.tink.shaded.protobuf.Internal;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class SchemaUtil {
    public static final Class<?> GENERATED_MESSAGE_CLASS;
    public static final UnknownFieldSchema<?, ?> PROTO2_UNKNOWN_FIELD_SET_SCHEMA;
    public static final UnknownFieldSchema<?, ?> PROTO3_UNKNOWN_FIELD_SET_SCHEMA;
    public static final UnknownFieldSetLiteSchema UNKNOWN_FIELD_SET_LITE_SCHEMA;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        GENERATED_MESSAGE_CLASS = cls;
        PROTO2_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(false);
        PROTO3_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(true);
        UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();
    }

    public static int computeSizeBoolList(int r0, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return CodedOutputStream.computeBoolSize(r0) * size;
    }

    public static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    public static int computeSizeByteStringList(int r3, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(r3) * size;
        for (int r1 = 0; r1 < list.size(); r1++) {
            int size2 = list.get(r1).size();
            computeTagSize += CodedOutputStream.computeUInt32SizeNoTag(size2) + size2;
        }
        return computeTagSize;
    }

    public static int computeSizeEnumList(int r1, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.computeTagSize(r1) * size) + computeSizeEnumListNoTag(list);
    }

    public static int computeSizeEnumListNoTag(List<Integer> list) {
        int r2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            r2 = 0;
            while (r1 < size) {
                intArrayList.ensureIndexInRange(r1);
                r2 += CodedOutputStream.computeInt32SizeNoTag(intArrayList.array[r1]);
                r1++;
            }
        } else {
            r2 = 0;
            while (r1 < size) {
                r2 += CodedOutputStream.computeInt32SizeNoTag(list.get(r1).intValue());
                r1++;
            }
        }
        return r2;
    }

    public static int computeSizeFixed32List(int r0, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return CodedOutputStream.computeFixed32Size(r0) * size;
    }

    public static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    public static int computeSizeFixed64List(int r0, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return CodedOutputStream.computeFixed64Size(r0) * size;
    }

    public static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    public static int computeSizeGroupList(int r4, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r2 = 0;
        for (int r1 = 0; r1 < size; r1++) {
            r2 += CodedOutputStream.computeGroupSize(r4, list.get(r1), schema);
        }
        return r2;
    }

    public static int computeSizeInt32List(int r1, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.computeTagSize(r1) * size) + computeSizeInt32ListNoTag(list);
    }

    public static int computeSizeInt32ListNoTag(List<Integer> list) {
        int r2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            r2 = 0;
            while (r1 < size) {
                intArrayList.ensureIndexInRange(r1);
                r2 += CodedOutputStream.computeInt32SizeNoTag(intArrayList.array[r1]);
                r1++;
            }
        } else {
            r2 = 0;
            while (r1 < size) {
                r2 += CodedOutputStream.computeInt32SizeNoTag(list.get(r1).intValue());
                r1++;
            }
        }
        return r2;
    }

    public static int computeSizeInt64List(int r1, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (CodedOutputStream.computeTagSize(r1) * list.size()) + computeSizeInt64ListNoTag(list);
    }

    public static int computeSizeInt64ListNoTag(List<Long> list) {
        int r2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            r2 = 0;
            while (r1 < size) {
                longArrayList.ensureIndexInRange(r1);
                r2 += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.array[r1]);
                r1++;
            }
        } else {
            r2 = 0;
            while (r1 < size) {
                r2 += CodedOutputStream.computeUInt64SizeNoTag(list.get(r1).longValue());
                r1++;
            }
        }
        return r2;
    }

    public static int computeSizeMessage(int r2, Schema schema, Object obj) {
        if (obj instanceof LazyFieldLite) {
            return CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj) + CodedOutputStream.computeTagSize(r2);
        }
        int computeTagSize = CodedOutputStream.computeTagSize(r2);
        AbstractMessageLite abstractMessageLite = (AbstractMessageLite) ((MessageLite) obj);
        int memoizedSerializedSize = abstractMessageLite.getMemoizedSerializedSize();
        if (memoizedSerializedSize == -1) {
            memoizedSerializedSize = schema.getSerializedSize(abstractMessageLite);
            abstractMessageLite.setMemoizedSerializedSize(memoizedSerializedSize);
        }
        return CodedOutputStream.computeUInt32SizeNoTag(memoizedSerializedSize) + memoizedSerializedSize + computeTagSize;
    }

    public static int computeSizeMessageList(int r5, List<?> list, Schema schema) {
        int computeUInt32SizeNoTag;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(r5) * size;
        for (int r1 = 0; r1 < size; r1++) {
            Object obj = list.get(r1);
            if (obj instanceof LazyFieldLite) {
                computeUInt32SizeNoTag = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                AbstractMessageLite abstractMessageLite = (AbstractMessageLite) ((MessageLite) obj);
                int memoizedSerializedSize = abstractMessageLite.getMemoizedSerializedSize();
                if (memoizedSerializedSize == -1) {
                    memoizedSerializedSize = schema.getSerializedSize(abstractMessageLite);
                    abstractMessageLite.setMemoizedSerializedSize(memoizedSerializedSize);
                }
                computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(memoizedSerializedSize) + memoizedSerializedSize;
            }
            computeTagSize += computeUInt32SizeNoTag;
        }
        return computeTagSize;
    }

    public static int computeSizeSInt32List(int r1, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.computeTagSize(r1) * size) + computeSizeSInt32ListNoTag(list);
    }

    public static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int r2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            r2 = 0;
            while (r1 < size) {
                intArrayList.ensureIndexInRange(r1);
                int r3 = intArrayList.array[r1];
                r2 += CodedOutputStream.computeUInt32SizeNoTag((r3 >> 31) ^ (r3 << 1));
                r1++;
            }
        } else {
            r2 = 0;
            while (r1 < size) {
                int intValue = list.get(r1).intValue();
                r2 += CodedOutputStream.computeUInt32SizeNoTag((intValue >> 31) ^ (intValue << 1));
                r1++;
            }
        }
        return r2;
    }

    public static int computeSizeSInt64List(int r1, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.computeTagSize(r1) * size) + computeSizeSInt64ListNoTag(list);
    }

    public static int computeSizeSInt64ListNoTag(List<Long> list) {
        int r2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            r2 = 0;
            while (r1 < size) {
                longArrayList.ensureIndexInRange(r1);
                long j = longArrayList.array[r1];
                r2 += CodedOutputStream.computeUInt64SizeNoTag((j >> 63) ^ (j << 1));
                r1++;
            }
        } else {
            r2 = 0;
            while (r1 < size) {
                long longValue = list.get(r1).longValue();
                r2 += CodedOutputStream.computeUInt64SizeNoTag((longValue >> 63) ^ (longValue << 1));
                r1++;
            }
        }
        return r2;
    }

    public static int computeSizeStringList(int r4, List<?> list) {
        int computeStringSizeNoTag;
        int computeStringSizeNoTag2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(r4) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (r1 < size) {
                Object raw = lazyStringList.getRaw(r1);
                if (raw instanceof ByteString) {
                    int size2 = ((ByteString) raw).size();
                    computeStringSizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(size2) + size2;
                } else {
                    computeStringSizeNoTag2 = CodedOutputStream.computeStringSizeNoTag((String) raw);
                }
                computeTagSize += computeStringSizeNoTag2;
                r1++;
            }
        } else {
            while (r1 < size) {
                Object obj = list.get(r1);
                if (obj instanceof ByteString) {
                    int size3 = ((ByteString) obj).size();
                    computeStringSizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(size3) + size3;
                } else {
                    computeStringSizeNoTag = CodedOutputStream.computeStringSizeNoTag((String) obj);
                }
                computeTagSize += computeStringSizeNoTag;
                r1++;
            }
        }
        return computeTagSize;
    }

    public static int computeSizeUInt32List(int r1, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.computeTagSize(r1) * size) + computeSizeUInt32ListNoTag(list);
    }

    public static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int r2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            r2 = 0;
            while (r1 < size) {
                intArrayList.ensureIndexInRange(r1);
                r2 += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.array[r1]);
                r1++;
            }
        } else {
            r2 = 0;
            while (r1 < size) {
                r2 += CodedOutputStream.computeUInt32SizeNoTag(list.get(r1).intValue());
                r1++;
            }
        }
        return r2;
    }

    public static int computeSizeUInt64List(int r1, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.computeTagSize(r1) * size) + computeSizeUInt64ListNoTag(list);
    }

    public static int computeSizeUInt64ListNoTag(List<Long> list) {
        int r2;
        int size = list.size();
        int r1 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            r2 = 0;
            while (r1 < size) {
                longArrayList.ensureIndexInRange(r1);
                r2 += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.array[r1]);
                r1++;
            }
        } else {
            r2 = 0;
            while (r1 < size) {
                r2 += CodedOutputStream.computeUInt64SizeNoTag(list.get(r1).longValue());
                r1++;
            }
        }
        return r2;
    }

    public static <UT, UB> UB filterUnknownEnumList(int r5, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int r2 = 0;
            for (int r1 = 0; r1 < size; r1++) {
                int intValue = list.get(r1).intValue();
                if (enumVerifier.isInRange(intValue)) {
                    if (r1 != r2) {
                        list.set(r2, Integer.valueOf(intValue));
                    }
                    r2++;
                } else {
                    ub = (UB) storeUnknownEnum(r5, intValue, ub, unknownFieldSchema);
                }
            }
            if (r2 != size) {
                list.subList(r2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!enumVerifier.isInRange(intValue2)) {
                    ub = (UB) storeUnknownEnum(r5, intValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (UnknownFieldSchema) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> extensionSchema, T t, T t2) {
        SmallSortedMap<FT, Object> smallSortedMap;
        FieldSet<FT> extensions = extensionSchema.getExtensions(t2);
        if (!extensions.isEmpty()) {
            FieldSet<FT> mutableExtensions = extensionSchema.getMutableExtensions(t);
            mutableExtensions.getClass();
            int r3 = 0;
            while (true) {
                smallSortedMap = extensions.fields;
                if (r3 >= smallSortedMap.getNumArrayEntries()) {
                    break;
                }
                mutableExtensions.mergeFromField(smallSortedMap.getArrayEntryAt(r3));
                r3++;
            }
            Iterator<Map.Entry<FT, Object>> it = smallSortedMap.getOverflowEntries().iterator();
            while (it.hasNext()) {
                mutableExtensions.mergeFromField(it.next());
            }
        }
    }

    public static boolean safeEquals(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static <UT, UB> UB storeUnknownEnum(int r2, int r3, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = (UB) unknownFieldSchema.newBuilder();
        }
        unknownFieldSchema.addVarint(r3, r2, ub);
        return ub;
    }

    public static void writeBoolList(int r2, List list, CodedOutputStreamWriter codedOutputStreamWriter, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            int r0 = 0;
            if (z) {
                codedOutputStream.writeTag(r2, 2);
                int r5 = 0;
                for (int r22 = 0; r22 < list.size(); r22++) {
                    ((Boolean) list.get(r22)).booleanValue();
                    Logger logger = CodedOutputStream.logger;
                    r5++;
                }
                codedOutputStream.writeUInt32NoTag(r5);
                while (r0 < list.size()) {
                    codedOutputStream.write(((Boolean) list.get(r0)).booleanValue() ? (byte) 1 : (byte) 0);
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                codedOutputStream.writeBool(r2, ((Boolean) list.get(r0)).booleanValue());
                r0++;
            }
        }
    }

    public static void writeBytesList(int r3, List list, CodedOutputStreamWriter codedOutputStreamWriter) throws IOException {
        if (list != null && !list.isEmpty()) {
            codedOutputStreamWriter.getClass();
            for (int r0 = 0; r0 < list.size(); r0++) {
                codedOutputStreamWriter.output.writeBytes(r3, (ByteString) list.get(r0));
            }
        }
    }

    public static void writeDoubleList(int r3, List list, CodedOutputStreamWriter codedOutputStreamWriter, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            int r0 = 0;
            if (z) {
                codedOutputStream.writeTag(r3, 2);
                int r6 = 0;
                for (int r32 = 0; r32 < list.size(); r32++) {
                    ((Double) list.get(r32)).doubleValue();
                    Logger logger = CodedOutputStream.logger;
                    r6 += 8;
                }
                codedOutputStream.writeUInt32NoTag(r6);
                while (r0 < list.size()) {
                    codedOutputStream.writeFixed64NoTag(Double.doubleToRawLongBits(((Double) list.get(r0)).doubleValue()));
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                double doubleValue = ((Double) list.get(r0)).doubleValue();
                codedOutputStream.getClass();
                codedOutputStream.writeFixed64(r3, Double.doubleToRawLongBits(doubleValue));
                r0++;
            }
        }
    }

    public static void writeEnumList(int r2, List list, CodedOutputStreamWriter codedOutputStreamWriter, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            int r0 = 0;
            if (z) {
                codedOutputStream.writeTag(r2, 2);
                int r5 = 0;
                for (int r22 = 0; r22 < list.size(); r22++) {
                    r5 += CodedOutputStream.computeInt32SizeNoTag(((Integer) list.get(r22)).intValue());
                }
                codedOutputStream.writeUInt32NoTag(r5);
                while (r0 < list.size()) {
                    codedOutputStream.writeInt32NoTag(((Integer) list.get(r0)).intValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                codedOutputStream.writeInt32(r2, ((Integer) list.get(r0)).intValue());
                r0++;
            }
        }
    }

    public static void writeFixed32List(int r2, List list, CodedOutputStreamWriter codedOutputStreamWriter, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            int r0 = 0;
            if (z) {
                codedOutputStream.writeTag(r2, 2);
                int r5 = 0;
                for (int r22 = 0; r22 < list.size(); r22++) {
                    ((Integer) list.get(r22)).intValue();
                    Logger logger = CodedOutputStream.logger;
                    r5 += 4;
                }
                codedOutputStream.writeUInt32NoTag(r5);
                while (r0 < list.size()) {
                    codedOutputStream.writeFixed32NoTag(((Integer) list.get(r0)).intValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                codedOutputStream.writeFixed32(r2, ((Integer) list.get(r0)).intValue());
                r0++;
            }
        }
    }

    public static void writeFixed64List(int r3, List list, CodedOutputStreamWriter codedOutputStreamWriter, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            int r0 = 0;
            if (z) {
                codedOutputStream.writeTag(r3, 2);
                int r6 = 0;
                for (int r32 = 0; r32 < list.size(); r32++) {
                    ((Long) list.get(r32)).longValue();
                    Logger logger = CodedOutputStream.logger;
                    r6 += 8;
                }
                codedOutputStream.writeUInt32NoTag(r6);
                while (r0 < list.size()) {
                    codedOutputStream.writeFixed64NoTag(((Long) list.get(r0)).longValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                codedOutputStream.writeFixed64(r3, ((Long) list.get(r0)).longValue());
                r0++;
            }
        }
    }

    public static void writeFloatList(int r2, List list, CodedOutputStreamWriter codedOutputStreamWriter, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            int r0 = 0;
            if (z) {
                codedOutputStream.writeTag(r2, 2);
                int r5 = 0;
                for (int r22 = 0; r22 < list.size(); r22++) {
                    ((Float) list.get(r22)).floatValue();
                    Logger logger = CodedOutputStream.logger;
                    r5 += 4;
                }
                codedOutputStream.writeUInt32NoTag(r5);
                while (r0 < list.size()) {
                    codedOutputStream.writeFixed32NoTag(Float.floatToRawIntBits(((Float) list.get(r0)).floatValue()));
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                float floatValue = ((Float) list.get(r0)).floatValue();
                codedOutputStream.getClass();
                codedOutputStream.writeFixed32(r2, Float.floatToRawIntBits(floatValue));
                r0++;
            }
        }
    }

    public static void writeGroupList(int r2, List list, CodedOutputStreamWriter codedOutputStreamWriter, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            codedOutputStreamWriter.getClass();
            for (int r0 = 0; r0 < list.size(); r0++) {
                codedOutputStreamWriter.writeGroup(r2, schema, list.get(r0));
            }
        }
    }

    public static void writeInt32List(int r2, List list, CodedOutputStreamWriter codedOutputStreamWriter, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            int r0 = 0;
            if (z) {
                codedOutputStream.writeTag(r2, 2);
                int r5 = 0;
                for (int r22 = 0; r22 < list.size(); r22++) {
                    r5 += CodedOutputStream.computeInt32SizeNoTag(((Integer) list.get(r22)).intValue());
                }
                codedOutputStream.writeUInt32NoTag(r5);
                while (r0 < list.size()) {
                    codedOutputStream.writeInt32NoTag(((Integer) list.get(r0)).intValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                codedOutputStream.writeInt32(r2, ((Integer) list.get(r0)).intValue());
                r0++;
            }
        }
    }

    public static void writeInt64List(int r3, List list, CodedOutputStreamWriter codedOutputStreamWriter, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            int r0 = 0;
            if (z) {
                codedOutputStream.writeTag(r3, 2);
                int r6 = 0;
                for (int r32 = 0; r32 < list.size(); r32++) {
                    r6 += CodedOutputStream.computeUInt64SizeNoTag(((Long) list.get(r32)).longValue());
                }
                codedOutputStream.writeUInt32NoTag(r6);
                while (r0 < list.size()) {
                    codedOutputStream.writeUInt64NoTag(((Long) list.get(r0)).longValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                codedOutputStream.writeUInt64(r3, ((Long) list.get(r0)).longValue());
                r0++;
            }
        }
    }

    public static void writeMessageList(int r2, List list, CodedOutputStreamWriter codedOutputStreamWriter, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            codedOutputStreamWriter.getClass();
            for (int r0 = 0; r0 < list.size(); r0++) {
                codedOutputStreamWriter.writeMessage(r2, schema, list.get(r0));
            }
        }
    }

    public static void writeSFixed32List(int r2, List list, CodedOutputStreamWriter codedOutputStreamWriter, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            int r0 = 0;
            if (z) {
                codedOutputStream.writeTag(r2, 2);
                int r5 = 0;
                for (int r22 = 0; r22 < list.size(); r22++) {
                    ((Integer) list.get(r22)).intValue();
                    Logger logger = CodedOutputStream.logger;
                    r5 += 4;
                }
                codedOutputStream.writeUInt32NoTag(r5);
                while (r0 < list.size()) {
                    codedOutputStream.writeFixed32NoTag(((Integer) list.get(r0)).intValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                codedOutputStream.writeFixed32(r2, ((Integer) list.get(r0)).intValue());
                r0++;
            }
        }
    }

    public static void writeSFixed64List(int r3, List list, CodedOutputStreamWriter codedOutputStreamWriter, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            int r0 = 0;
            if (z) {
                codedOutputStream.writeTag(r3, 2);
                int r6 = 0;
                for (int r32 = 0; r32 < list.size(); r32++) {
                    ((Long) list.get(r32)).longValue();
                    Logger logger = CodedOutputStream.logger;
                    r6 += 8;
                }
                codedOutputStream.writeUInt32NoTag(r6);
                while (r0 < list.size()) {
                    codedOutputStream.writeFixed64NoTag(((Long) list.get(r0)).longValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                codedOutputStream.writeFixed64(r3, ((Long) list.get(r0)).longValue());
                r0++;
            }
        }
    }

    public static void writeSInt32List(int r3, List list, CodedOutputStreamWriter codedOutputStreamWriter, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            int r0 = 0;
            if (z) {
                codedOutputStream.writeTag(r3, 2);
                int r6 = 0;
                for (int r32 = 0; r32 < list.size(); r32++) {
                    int intValue = ((Integer) list.get(r32)).intValue();
                    r6 += CodedOutputStream.computeUInt32SizeNoTag((intValue >> 31) ^ (intValue << 1));
                }
                codedOutputStream.writeUInt32NoTag(r6);
                while (r0 < list.size()) {
                    int intValue2 = ((Integer) list.get(r0)).intValue();
                    codedOutputStream.writeUInt32NoTag((intValue2 >> 31) ^ (intValue2 << 1));
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                int intValue3 = ((Integer) list.get(r0)).intValue();
                codedOutputStream.writeUInt32(r3, (intValue3 >> 31) ^ (intValue3 << 1));
                r0++;
            }
        }
    }

    public static void writeSInt64List(int r7, List list, CodedOutputStreamWriter codedOutputStreamWriter, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            int r2 = 0;
            if (z) {
                codedOutputStream.writeTag(r7, 2);
                int r10 = 0;
                for (int r72 = 0; r72 < list.size(); r72++) {
                    long longValue = ((Long) list.get(r72)).longValue();
                    r10 += CodedOutputStream.computeUInt64SizeNoTag((longValue >> 63) ^ (longValue << 1));
                }
                codedOutputStream.writeUInt32NoTag(r10);
                while (r2 < list.size()) {
                    long longValue2 = ((Long) list.get(r2)).longValue();
                    codedOutputStream.writeUInt64NoTag((longValue2 >> 63) ^ (longValue2 << 1));
                    r2++;
                }
                return;
            }
            while (r2 < list.size()) {
                long longValue3 = ((Long) list.get(r2)).longValue();
                codedOutputStream.writeUInt64(r7, (longValue3 >> 63) ^ (longValue3 << 1));
                r2++;
            }
        }
    }

    public static void writeStringList(int r4, List list, CodedOutputStreamWriter codedOutputStreamWriter) throws IOException {
        if (list != null && !list.isEmpty()) {
            codedOutputStreamWriter.getClass();
            boolean z = list instanceof LazyStringList;
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            int r1 = 0;
            if (z) {
                LazyStringList lazyStringList = (LazyStringList) list;
                while (r1 < list.size()) {
                    Object raw = lazyStringList.getRaw(r1);
                    if (raw instanceof String) {
                        codedOutputStream.writeString(r4, (String) raw);
                    } else {
                        codedOutputStream.writeBytes(r4, (ByteString) raw);
                    }
                    r1++;
                }
                return;
            }
            while (r1 < list.size()) {
                codedOutputStream.writeString(r4, (String) list.get(r1));
                r1++;
            }
        }
    }

    public static void writeUInt32List(int r2, List list, CodedOutputStreamWriter codedOutputStreamWriter, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            int r0 = 0;
            if (z) {
                codedOutputStream.writeTag(r2, 2);
                int r5 = 0;
                for (int r22 = 0; r22 < list.size(); r22++) {
                    r5 += CodedOutputStream.computeUInt32SizeNoTag(((Integer) list.get(r22)).intValue());
                }
                codedOutputStream.writeUInt32NoTag(r5);
                while (r0 < list.size()) {
                    codedOutputStream.writeUInt32NoTag(((Integer) list.get(r0)).intValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                codedOutputStream.writeUInt32(r2, ((Integer) list.get(r0)).intValue());
                r0++;
            }
        }
    }

    public static void writeUInt64List(int r3, List list, CodedOutputStreamWriter codedOutputStreamWriter, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
            int r0 = 0;
            if (z) {
                codedOutputStream.writeTag(r3, 2);
                int r6 = 0;
                for (int r32 = 0; r32 < list.size(); r32++) {
                    r6 += CodedOutputStream.computeUInt64SizeNoTag(((Long) list.get(r32)).longValue());
                }
                codedOutputStream.writeUInt32NoTag(r6);
                while (r0 < list.size()) {
                    codedOutputStream.writeUInt64NoTag(((Long) list.get(r0)).longValue());
                    r0++;
                }
                return;
            }
            while (r0 < list.size()) {
                codedOutputStream.writeUInt64(r3, ((Long) list.get(r0)).longValue());
                r0++;
            }
        }
    }
}
