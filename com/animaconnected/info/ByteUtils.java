package com.animaconnected.info;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.UStringsKt;

/* compiled from: ByteUtils.kt */
/* loaded from: classes.dex */
public final class ByteUtils {
    public static final byte[] decodeHex(String str) throws Exception {
        Intrinsics.checkNotNullParameter(str, "<this>");
        List<String> split$default = StringsKt__StringsKt.split$default(str, new String[]{" "}, 0, 6);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(split$default, 10));
        for (String str2 : split$default) {
            CharsKt__CharKt.checkRadix(16);
            arrayList.add(Byte.valueOf((byte) Integer.parseInt(str2, 16)));
        }
        return CollectionsKt___CollectionsKt.toByteArray(arrayList);
    }

    public static final short decodeInt16(byte[] bArr, int r2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (short) (((bArr[r2] & 255) << 8) + (bArr[r2 + 1] & 255));
    }

    public static /* synthetic */ short decodeInt16$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeInt16(bArr, r1);
    }

    public static final short decodeInt16LE(byte[] bArr, int r2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (short) ((bArr[r2] & 255) + ((bArr[r2 + 1] & 255) << 8));
    }

    public static /* synthetic */ short decodeInt16LE$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeInt16LE(bArr, r1);
    }

    public static final int decodeInt32(byte[] bArr, int r3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ((bArr[r3] & 255) << 24) + ((bArr[r3 + 1] & 255) << 16) + ((bArr[r3 + 2] & 255) << 8) + (bArr[r3 + 3] & 255);
    }

    public static /* synthetic */ int decodeInt32$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeInt32(bArr, r1);
    }

    public static final int decodeInt32LE(byte[] bArr, int r3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (bArr[r3] & 255) + ((bArr[r3 + 1] & 255) << 8) + ((bArr[r3 + 2] & 255) << 16) + ((bArr[r3 + 3] & 255) << 24);
    }

    public static /* synthetic */ int decodeInt32LE$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeInt32LE(bArr, r1);
    }

    public static final long decodeInt64(byte[] bArr, int r8) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ((bArr[r8] & 255) << 56) + ((bArr[r8 + 1] & 255) << 48) + ((bArr[r8 + 2] & 255) << 40) + ((bArr[r8 + 3] & 255) << 32) + ((bArr[r8 + 4] & 255) << 24) + ((bArr[r8 + 5] & 255) << 16) + ((bArr[r8 + 6] & 255) << 8) + (bArr[r8 + 7] & 255);
    }

    public static /* synthetic */ long decodeInt64$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeInt64(bArr, r1);
    }

    public static final long decodeInt64LE(byte[] bArr, int r8) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (bArr[r8] & 255) + ((bArr[r8 + 1] & 255) << 8) + ((bArr[r8 + 2] & 255) << 16) + ((bArr[r8 + 3] & 255) << 24) + ((bArr[r8 + 4] & 255) << 32) + ((bArr[r8 + 5] & 255) << 40) + ((bArr[r8 + 6] & 255) << 48) + ((bArr[r8 + 7] & 255) << 56);
    }

    public static /* synthetic */ long decodeInt64LE$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeInt64LE(bArr, r1);
    }

    public static final byte decodeInt8(byte[] bArr, int r2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (byte) (bArr[r2] & (-1));
    }

    public static /* synthetic */ byte decodeInt8$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeInt8(bArr, r1);
    }

    public static final byte decodeInt8LE(byte[] bArr, int r2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (byte) (bArr[r2] & (-1));
    }

    public static /* synthetic */ byte decodeInt8LE$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeInt8LE(bArr, r1);
    }

    public static final short decodeUInt16(byte[] bArr, int r2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (short) (((bArr[r2] & 255) << 8) + (bArr[r2 + 1] & 255));
    }

    public static /* synthetic */ short decodeUInt16$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeUInt16(bArr, r1);
    }

    public static final short decodeUInt16LE(byte[] bArr, int r2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (short) ((bArr[r2] & 255) + ((bArr[r2 + 1] & 255) << 8));
    }

    public static /* synthetic */ short decodeUInt16LE$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeUInt16LE(bArr, r1);
    }

    public static final int decodeUInt32(byte[] bArr, int r8) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (int) (((bArr[r8] & 255) << 24) + ((bArr[r8 + 1] & 255) << 16) + ((bArr[r8 + 2] & 255) << 8) + (bArr[r8 + 3] & 255));
    }

    public static /* synthetic */ int decodeUInt32$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeUInt32(bArr, r1);
    }

    public static final long decodeUInt32LE(byte[] bArr, int r8) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (bArr[r8] & 255) + ((bArr[r8 + 1] & 255) << 8) + ((bArr[r8 + 2] & 255) << 16) + ((bArr[r8 + 3] & 255) << 24);
    }

    public static /* synthetic */ long decodeUInt32LE$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeUInt32LE(bArr, r1);
    }

    public static final long decodeUInt64(byte[] bArr, int r8) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ((bArr[r8] & 255) << 56) + ((bArr[r8 + 1] & 255) << 48) + ((bArr[r8 + 2] & 255) << 40) + ((bArr[r8 + 3] & 255) << 32) + ((bArr[r8 + 4] & 255) << 24) + ((bArr[r8 + 5] & 255) << 16) + ((bArr[r8 + 6] & 255) << 8) + (bArr[r8 + 7] & 255);
    }

    public static /* synthetic */ long decodeUInt64$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeUInt64(bArr, r1);
    }

    public static final long decodeUInt64LE(byte[] bArr, int r8) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (bArr[r8] & 255) + ((bArr[r8 + 1] & 255) << 8) + ((bArr[r8 + 2] & 255) << 16) + ((bArr[r8 + 3] & 255) << 24) + ((bArr[r8 + 4] & 255) << 32) + ((bArr[r8 + 5] & 255) << 40) + ((bArr[r8 + 6] & 255) << 48) + ((bArr[r8 + 7] & 255) << 56);
    }

    public static /* synthetic */ long decodeUInt64LE$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeUInt64LE(bArr, r1);
    }

    public static final byte decodeUInt8(byte[] bArr, int r2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (byte) (bArr[r2] & (-1));
    }

    public static /* synthetic */ byte decodeUInt8$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeUInt8(bArr, r1);
    }

    public static final short decodeUInt8LE(byte[] bArr, int r2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (short) (((byte) (bArr[r2] & (-1))) & 255);
    }

    public static /* synthetic */ short decodeUInt8LE$default(byte[] bArr, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 0;
        }
        return decodeUInt8LE(bArr, r1);
    }

    public static final byte[] encodeInt16(short s) {
        byte[] bArr = new byte[2];
        encodeInt16(s, bArr, 0);
        return bArr;
    }

    public static /* synthetic */ void encodeInt16$default(short s, byte[] bArr, int r2, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            r2 = 0;
        }
        encodeInt16(s, bArr, r2);
    }

    public static final byte[] encodeInt16LE(short s) {
        byte[] bArr = new byte[2];
        encodeInt16LE(s, bArr, 0);
        return bArr;
    }

    public static final byte[] encodeInt32(int r2) {
        byte[] bArr = new byte[4];
        encodeInt32(r2, bArr, 0);
        return bArr;
    }

    public static /* synthetic */ void encodeInt32$default(int r0, byte[] bArr, int r2, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            r2 = 0;
        }
        encodeInt32(r0, bArr, r2);
    }

    public static final byte[] encodeInt32LE(int r2) {
        byte[] bArr = new byte[4];
        encodeInt32LE(r2, bArr, 0);
        return bArr;
    }

    public static final byte[] encodeInt64(long j) {
        byte[] bArr = new byte[8];
        encodeInt64(j, bArr, 0);
        return bArr;
    }

    public static final byte[] encodeInt64LE(long j) {
        byte[] bArr = new byte[8];
        encodeInt64LE(j, bArr, 0);
        return bArr;
    }

    public static /* synthetic */ void encodeInt64LE$default(long j, byte[] bArr, int r3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            bArr = new byte[8];
        }
        encodeInt64LE(j, bArr, r3);
    }

    public static final byte[] encodeInt8(byte b) {
        byte[] bArr = new byte[1];
        encodeInt8(b, bArr, 0);
        return bArr;
    }

    public static final byte[] encodeInt8LE(byte b) {
        byte[] bArr = new byte[1];
        encodeInt8LE(b, bArr, 0);
        return bArr;
    }

    /* renamed from: encodeInt8LE-d-jbwkw */
    public static final void m727encodeInt8LEdjbwkw(byte b, byte[] byteArray, int r3) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        byteArray[r3] = b;
    }

    /* renamed from: encodeUInt16-_TFR7lA */
    public static final void m728encodeUInt16_TFR7lA(short s, byte[] byteArray, int r7) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Iterator<Integer> it = new IntRange(0, 1).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            byteArray[r7 + nextInt] = (byte) (((65535 & s) >> ((1 - nextInt) * 8)) & 255);
        }
    }

    /* renamed from: encodeUInt16-_TFR7lA$default */
    public static /* synthetic */ void m729encodeUInt16_TFR7lA$default(short s, byte[] bArr, int r2, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            r2 = 0;
        }
        m728encodeUInt16_TFR7lA(s, bArr, r2);
    }

    /* renamed from: encodeUInt16-xj2QHRw */
    public static final byte[] m730encodeUInt16xj2QHRw(short s) {
        byte[] bArr = new byte[2];
        m728encodeUInt16_TFR7lA(s, bArr, 0);
        return bArr;
    }

    public static final void encodeUInt16LE(int r1, byte[] byteArray, int r3) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        m731encodeUInt16LE_TFR7lA((short) r1, byteArray, r3);
    }

    /* renamed from: encodeUInt16LE-_TFR7lA */
    public static final void m731encodeUInt16LE_TFR7lA(short s, byte[] byteArray, int r6) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Iterator<Integer> it = new IntRange(0, 1).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            byteArray[r6 + nextInt] = (byte) (((65535 & s) >> (nextInt * 8)) & 255);
        }
    }

    /* renamed from: encodeUInt16LE-xj2QHRw */
    public static final byte[] m732encodeUInt16LExj2QHRw(short s) {
        byte[] bArr = new byte[2];
        m731encodeUInt16LE_TFR7lA(s, bArr, 0);
        return bArr;
    }

    /* renamed from: encodeUInt32-OzbTU-A */
    public static final void m733encodeUInt32OzbTUA(int r4, byte[] byteArray, int r6) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Iterator<Integer> it = new IntRange(0, 3).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            byteArray[r6 + nextInt] = (byte) ((r4 >>> ((3 - nextInt) * 8)) & 255);
        }
    }

    /* renamed from: encodeUInt32-OzbTU-A$default */
    public static /* synthetic */ void m734encodeUInt32OzbTUA$default(int r0, byte[] bArr, int r2, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            r2 = 0;
        }
        m733encodeUInt32OzbTUA(r0, bArr, r2);
    }

    /* renamed from: encodeUInt32-WZ4Q5Ns */
    public static final byte[] m735encodeUInt32WZ4Q5Ns(int r2) {
        byte[] bArr = new byte[4];
        m733encodeUInt32OzbTUA(r2, bArr, 0);
        return bArr;
    }

    public static final void encodeUInt32LE(long j, byte[] byteArray, int r4) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        m736encodeUInt32LEOzbTUA((int) j, byteArray, r4);
    }

    /* renamed from: encodeUInt32LE-OzbTU-A */
    public static final void m736encodeUInt32LEOzbTUA(int r3, byte[] byteArray, int r5) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Iterator<Integer> it = new IntRange(0, 3).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            byteArray[r5 + nextInt] = (byte) ((r3 >>> (nextInt * 8)) & 255);
        }
    }

    /* renamed from: encodeUInt32LE-WZ4Q5Ns */
    public static final byte[] m737encodeUInt32LEWZ4Q5Ns(int r2) {
        byte[] bArr = new byte[4];
        m736encodeUInt32LEOzbTUA(r2, bArr, 0);
        return bArr;
    }

    /* renamed from: encodeUInt64-E0BElUM */
    public static final void m738encodeUInt64E0BElUM(long j, byte[] byteArray, int r11) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Iterator<Integer> it = new IntRange(0, 7).iterator();
        while (it.hasNext()) {
            byteArray[r11 + ((IntIterator) it).nextInt()] = (byte) ((j >>> ((7 - r1) * 8)) & 255);
        }
    }

    /* renamed from: encodeUInt64-VKZWuLQ */
    public static final byte[] m739encodeUInt64VKZWuLQ(long j) {
        byte[] bArr = new byte[8];
        m738encodeUInt64E0BElUM(j, bArr, 0);
        return bArr;
    }

    /* renamed from: encodeUInt64LE-E0BElUM */
    public static final void m740encodeUInt64LEE0BElUM(long j, byte[] byteArray, int r10) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Iterator<Integer> it = new IntRange(0, 7).iterator();
        while (it.hasNext()) {
            byteArray[r10 + ((IntIterator) it).nextInt()] = (byte) ((j >>> (r1 * 8)) & 255);
        }
    }

    /* renamed from: encodeUInt64LE-E0BElUM$default */
    public static /* synthetic */ void m741encodeUInt64LEE0BElUM$default(long j, byte[] bArr, int r3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            bArr = new byte[8];
        }
        m740encodeUInt64LEE0BElUM(j, bArr, r3);
    }

    /* renamed from: encodeUInt64LE-VKZWuLQ */
    public static final byte[] m742encodeUInt64LEVKZWuLQ(long j) {
        byte[] bArr = new byte[8];
        m740encodeUInt64LEE0BElUM(j, bArr, 0);
        return bArr;
    }

    /* renamed from: encodeUInt8-7apg3OU */
    public static final byte[] m743encodeUInt87apg3OU(byte b) {
        byte[] bArr = new byte[1];
        m744encodeUInt8djbwkw(b, bArr, 0);
        return bArr;
    }

    /* renamed from: encodeUInt8-d-jbwkw */
    public static final void m744encodeUInt8djbwkw(byte b, byte[] byteArray, int r3) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        byteArray[r3] = b;
    }

    /* renamed from: encodeUInt8LE-7apg3OU */
    public static final byte[] m745encodeUInt8LE7apg3OU(byte b) {
        byte[] bArr = new byte[1];
        m727encodeInt8LEdjbwkw(b, bArr, 0);
        return bArr;
    }

    public static final boolean isSet(byte b, int r1) {
        return ((b >> r1) & 1) == 1;
    }

    /* renamed from: toByteArrayLE--ajY-9A */
    public static final byte[] m746toByteArrayLEajY9A(int[] toByteArrayLE) {
        Intrinsics.checkNotNullParameter(toByteArrayLE, "$this$toByteArrayLE");
        byte[] bArr = new byte[toByteArrayLE.length * 4];
        int length = toByteArrayLE.length;
        int r2 = 0;
        int r3 = 0;
        while (r2 < length) {
            int r4 = toByteArrayLE[r2];
            int r5 = r3 + 1;
            int r32 = r3 * 4;
            bArr[r32 + 0] = (byte) (r4 & 255);
            bArr[r32 + 1] = (byte) ((r4 >>> 8) & 255);
            bArr[r32 + 2] = (byte) ((r4 >>> 16) & 255);
            bArr[r32 + 3] = (byte) ((r4 >>> 24) & 255);
            r2++;
            r3 = r5;
        }
        return bArr;
    }

    public static final String toHex(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return toHexUnsigned(copyOf);
    }

    public static final String toHexString(int r0, int r1) {
        return m747toHexStringqim9Vi0(r0, r1);
    }

    public static /* synthetic */ String toHexString$default(int r0, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 2;
        }
        return toHexString(r0, r1);
    }

    /* renamed from: toHexString-qim9Vi0 */
    public static final String m747toHexStringqim9Vi0(int r2, int r3) {
        return "0x" + StringsKt__StringsKt.padStart(UStringsKt.m1669toStringV7xB4Y4(r2), r3, '0');
    }

    /* renamed from: toHexString-qim9Vi0$default */
    public static /* synthetic */ String m748toHexStringqim9Vi0$default(int r0, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = 2;
        }
        return m747toHexStringqim9Vi0(r0, r1);
    }

    public static final String toHexUnsigned(byte[] toHex) {
        Intrinsics.checkNotNullParameter(toHex, "$this$toHex");
        return CollectionsKt___CollectionsKt.joinToString$default(new UByteArray(toHex), " ", null, null, new Function1<UByte, CharSequence>() { // from class: com.animaconnected.info.ByteUtils$toHex$1
            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ CharSequence invoke(UByte uByte) {
                return m749invoke7apg3OU(uByte.data);
            }

            /* renamed from: invoke-7apg3OU, reason: not valid java name */
            public final CharSequence m749invoke7apg3OU(byte b) {
                return ByteUtils.toHexUnsigned(b);
            }
        }, 30);
    }

    public static final void encodeInt16(short s, byte[] byteArray, int r6) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Iterator<Integer> it = new IntRange(0, 1).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            byteArray[r6 + nextInt] = (byte) ((s >> ((1 - nextInt) * 8)) & 255);
        }
    }

    public static final void encodeInt16LE(short s, byte[] byteArray, int r5) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Iterator<Integer> it = new IntRange(0, 1).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            byteArray[r5 + nextInt] = (byte) ((s >> (nextInt * 8)) & 255);
        }
    }

    public static final void encodeInt32(int r4, byte[] byteArray, int r6) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Iterator<Integer> it = new IntRange(0, 3).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            byteArray[r6 + nextInt] = (byte) ((r4 >> ((3 - nextInt) * 8)) & 255);
        }
    }

    public static final void encodeInt32LE(int r3, byte[] byteArray, int r5) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Iterator<Integer> it = new IntRange(0, 3).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            byteArray[r5 + nextInt] = (byte) ((r3 >> (nextInt * 8)) & 255);
        }
    }

    public static final void encodeInt64(long j, byte[] byteArray, int r11) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Iterator<Integer> it = new IntRange(0, 7).iterator();
        while (it.hasNext()) {
            byteArray[r11 + ((IntIterator) it).nextInt()] = (byte) ((j >> ((7 - r1) * 8)) & 255);
        }
    }

    public static final void encodeInt64LE(long j, byte[] byteArray, int r10) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Iterator<Integer> it = new IntRange(0, 7).iterator();
        while (it.hasNext()) {
            byteArray[r10 + ((IntIterator) it).nextInt()] = (byte) ((j >> (r1 * 8)) & 255);
        }
    }

    public static final void encodeInt8(byte b, byte[] byteArray, int r3) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        byteArray[r3] = b;
    }

    public static final void encodeInt8LE(byte b, byte[] byteArray, int r3) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        byteArray[r3] = b;
    }

    public static final boolean isSet(byte[] bArr, int r2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ((bArr[r2 / 8] >> (r2 % 8)) & 1) == 1;
    }

    public static final String toHex(byte b) {
        return toHexUnsigned(b);
    }

    public static final String toHexUnsigned(byte b) {
        CharsKt__CharKt.checkRadix(16);
        String num = Integer.toString(b & 255, 16);
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        String upperCase = StringsKt__StringsKt.padStart(num, 2, '0').toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
