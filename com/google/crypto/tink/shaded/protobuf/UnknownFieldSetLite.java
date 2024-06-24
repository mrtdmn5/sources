package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class UnknownFieldSetLite {
    public static final UnknownFieldSetLite DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    public int count;
    public boolean isMutable;
    public int memoizedSerializedSize;
    public Object[] objects;
    public int[] tags;

    public UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int r2 = this.count;
        if (r2 == unknownFieldSetLite.count) {
            int[] r3 = this.tags;
            int[] r4 = unknownFieldSetLite.tags;
            int r5 = 0;
            while (true) {
                if (r5 < r2) {
                    if (r3[r5] != r4[r5]) {
                        z = false;
                        break;
                    }
                    r5++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                Object[] objArr = this.objects;
                Object[] objArr2 = unknownFieldSetLite.objects;
                int r32 = this.count;
                int r42 = 0;
                while (true) {
                    if (r42 < r32) {
                        if (!objArr[r42].equals(objArr2[r42])) {
                            z2 = false;
                            break;
                        }
                        r42++;
                    } else {
                        z2 = true;
                        break;
                    }
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int getSerializedSize() {
        int computeUInt64Size;
        int r0 = this.memoizedSerializedSize;
        if (r0 != -1) {
            return r0;
        }
        int r1 = 0;
        for (int r02 = 0; r02 < this.count; r02++) {
            int r2 = this.tags[r02];
            int r3 = r2 >>> 3;
            int r22 = r2 & 7;
            if (r22 != 0) {
                if (r22 != 1) {
                    if (r22 != 2) {
                        if (r22 != 3) {
                            if (r22 == 5) {
                                ((Integer) this.objects[r02]).intValue();
                                computeUInt64Size = CodedOutputStream.computeFixed32Size(r3);
                            } else {
                                int r12 = InvalidProtocolBufferException.$r8$clinit;
                                throw new IllegalStateException(new InvalidProtocolBufferException.InvalidWireTypeException());
                            }
                        } else {
                            r1 = ((UnknownFieldSetLite) this.objects[r02]).getSerializedSize() + (CodedOutputStream.computeTagSize(r3) * 2) + r1;
                        }
                    } else {
                        computeUInt64Size = CodedOutputStream.computeBytesSize(r3, (ByteString) this.objects[r02]);
                    }
                } else {
                    ((Long) this.objects[r02]).longValue();
                    computeUInt64Size = CodedOutputStream.computeFixed64Size(r3);
                }
            } else {
                computeUInt64Size = CodedOutputStream.computeUInt64Size(r3, ((Long) this.objects[r02]).longValue());
            }
            r1 = computeUInt64Size + r1;
        }
        this.memoizedSerializedSize = r1;
        return r1;
    }

    public final int hashCode() {
        int r0 = this.count;
        int r1 = (527 + r0) * 31;
        int[] r2 = this.tags;
        int r4 = 17;
        int r6 = 17;
        for (int r5 = 0; r5 < r0; r5++) {
            r6 = (r6 * 31) + r2[r5];
        }
        int r12 = (r1 + r6) * 31;
        Object[] objArr = this.objects;
        int r22 = this.count;
        for (int r3 = 0; r3 < r22; r3++) {
            r4 = (r4 * 31) + objArr[r3].hashCode();
        }
        return r12 + r4;
    }

    public final void storeField(int r4, Object obj) {
        int r2;
        if (this.isMutable) {
            int r0 = this.count;
            int[] r1 = this.tags;
            if (r0 == r1.length) {
                if (r0 < 4) {
                    r2 = 8;
                } else {
                    r2 = r0 >> 1;
                }
                int r02 = r0 + r2;
                this.tags = Arrays.copyOf(r1, r02);
                this.objects = Arrays.copyOf(this.objects, r02);
            }
            int[] r03 = this.tags;
            int r12 = this.count;
            r03[r12] = r4;
            this.objects[r12] = obj;
            this.count = r12 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void writeTo(CodedOutputStreamWriter codedOutputStreamWriter) throws IOException {
        if (this.count == 0) {
            return;
        }
        codedOutputStreamWriter.getClass();
        Writer$FieldOrder writer$FieldOrder = Writer$FieldOrder.ASCENDING;
        for (int r0 = 0; r0 < this.count; r0++) {
            int r1 = this.tags[r0];
            Object obj = this.objects[r0];
            int r3 = r1 >>> 3;
            int r12 = r1 & 7;
            if (r12 != 0) {
                if (r12 != 1) {
                    if (r12 != 2) {
                        if (r12 != 3) {
                            if (r12 == 5) {
                                codedOutputStreamWriter.writeFixed32(r3, ((Integer) obj).intValue());
                            } else {
                                int r02 = InvalidProtocolBufferException.$r8$clinit;
                                throw new RuntimeException(new InvalidProtocolBufferException.InvalidWireTypeException());
                            }
                        } else {
                            codedOutputStreamWriter.getClass();
                            Writer$FieldOrder writer$FieldOrder2 = Writer$FieldOrder.ASCENDING;
                            CodedOutputStream codedOutputStream = codedOutputStreamWriter.output;
                            codedOutputStream.writeTag(r3, 3);
                            ((UnknownFieldSetLite) obj).writeTo(codedOutputStreamWriter);
                            codedOutputStream.writeTag(r3, 4);
                        }
                    } else {
                        codedOutputStreamWriter.writeBytes(r3, (ByteString) obj);
                    }
                } else {
                    codedOutputStreamWriter.writeFixed64(r3, ((Long) obj).longValue());
                }
            } else {
                codedOutputStreamWriter.writeInt64(r3, ((Long) obj).longValue());
            }
        }
    }

    public UnknownFieldSetLite(int r2, int[] r3, Object[] objArr, boolean z) {
        this.memoizedSerializedSize = -1;
        this.count = r2;
        this.tags = r3;
        this.objects = objArr;
        this.isMutable = z;
    }
}
