package com.animaconnected.info;

import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteArrayBuilder.kt */
/* loaded from: classes.dex */
public final class ByteArrayReader {
    private final byte[] byteArray;
    private int readPointer;

    public ByteArrayReader(byte[] byteArray, int r3) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        this.byteArray = byteArray;
        this.readPointer = r3;
    }

    private final <T> T read(int r3, Function2<? super byte[], ? super Integer, ? extends T> function2) {
        T invoke = function2.invoke(this.byteArray, Integer.valueOf(this.readPointer));
        this.readPointer += r3;
        return invoke;
    }

    public final byte[] getByteArray() {
        return this.byteArray;
    }

    public final short int16LE() {
        return ((Number) read(2, new Function2<byte[], Integer, Short>() { // from class: com.animaconnected.info.ByteArrayReader$int16LE$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Short invoke(byte[] bArr, Integer num) {
                return invoke(bArr, num.intValue());
            }

            public final Short invoke(byte[] read, int r3) {
                Intrinsics.checkNotNullParameter(read, "$this$read");
                return Short.valueOf(ByteUtils.decodeInt16LE(read, r3));
            }
        })).shortValue();
    }

    public final int int32LE() {
        return ((Number) read(4, new Function2<byte[], Integer, Integer>() { // from class: com.animaconnected.info.ByteArrayReader$int32LE$1
            public final Integer invoke(byte[] read, int r3) {
                Intrinsics.checkNotNullParameter(read, "$this$read");
                return Integer.valueOf(ByteUtils.decodeInt32LE(read, r3));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(byte[] bArr, Integer num) {
                return invoke(bArr, num.intValue());
            }
        })).intValue();
    }

    public final long int64LE() {
        return ((Number) read(8, new Function2<byte[], Integer, Long>() { // from class: com.animaconnected.info.ByteArrayReader$int64LE$1
            public final Long invoke(byte[] read, int r3) {
                Intrinsics.checkNotNullParameter(read, "$this$read");
                return Long.valueOf(ByteUtils.decodeInt64LE(read, r3));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Long invoke(byte[] bArr, Integer num) {
                return invoke(bArr, num.intValue());
            }
        })).longValue();
    }

    public final byte int8LE() {
        return ((Number) read(1, new Function2<byte[], Integer, Byte>() { // from class: com.animaconnected.info.ByteArrayReader$int8LE$1
            public final Byte invoke(byte[] read, int r3) {
                Intrinsics.checkNotNullParameter(read, "$this$read");
                return Byte.valueOf(ByteUtils.decodeInt8LE(read, r3));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Byte invoke(byte[] bArr, Integer num) {
                return invoke(bArr, num.intValue());
            }
        })).byteValue();
    }

    /* renamed from: uInt16LE-Mh2AYeg, reason: not valid java name */
    public final short m723uInt16LEMh2AYeg() {
        return ((UShort) read(2, new Function2<byte[], Integer, UShort>() { // from class: com.animaconnected.info.ByteArrayReader$uInt16LE$1
            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ UShort invoke(byte[] bArr, Integer num) {
                return new UShort(m725invokeErzVvmY(bArr, num.intValue()));
            }

            /* renamed from: invoke-ErzVvmY, reason: not valid java name */
            public final short m725invokeErzVvmY(byte[] read, int r3) {
                Intrinsics.checkNotNullParameter(read, "$this$read");
                return ByteUtils.decodeUInt16LE(read, r3);
            }
        })).data;
    }

    public final long uInt32LE() {
        return ((Number) read(4, new Function2<byte[], Integer, Long>() { // from class: com.animaconnected.info.ByteArrayReader$uInt32LE$1
            public final Long invoke(byte[] read, int r3) {
                Intrinsics.checkNotNullParameter(read, "$this$read");
                return Long.valueOf(ByteUtils.decodeUInt32LE(read, r3));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Long invoke(byte[] bArr, Integer num) {
                return invoke(bArr, num.intValue());
            }
        })).longValue();
    }

    /* renamed from: uInt64LE-s-VKNKU, reason: not valid java name */
    public final long m724uInt64LEsVKNKU() {
        return ((ULong) read(8, new Function2<byte[], Integer, ULong>() { // from class: com.animaconnected.info.ByteArrayReader$uInt64LE$1
            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ ULong invoke(byte[] bArr, Integer num) {
                return new ULong(m726invokeZIaKswc(bArr, num.intValue()));
            }

            /* renamed from: invoke-ZIaKswc, reason: not valid java name */
            public final long m726invokeZIaKswc(byte[] read, int r3) {
                Intrinsics.checkNotNullParameter(read, "$this$read");
                return ByteUtils.decodeUInt64LE(read, r3);
            }
        })).data;
    }

    public final short uInt8LE() {
        return ((Number) read(1, new Function2<byte[], Integer, Short>() { // from class: com.animaconnected.info.ByteArrayReader$uInt8LE$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Short invoke(byte[] bArr, Integer num) {
                return invoke(bArr, num.intValue());
            }

            public final Short invoke(byte[] read, int r3) {
                Intrinsics.checkNotNullParameter(read, "$this$read");
                return Short.valueOf(ByteUtils.decodeUInt8LE(read, r3));
            }
        })).shortValue();
    }

    public /* synthetic */ ByteArrayReader(byte[] bArr, int r2, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (r3 & 2) != 0 ? 0 : r2);
    }
}
