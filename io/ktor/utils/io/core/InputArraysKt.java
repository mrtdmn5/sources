package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputArrays.kt */
/* loaded from: classes3.dex */
public final class InputArraysKt {
    public static final int readAvailable(Input input, byte[] bArr, int r7, int r8) {
        boolean z;
        Intrinsics.checkNotNullParameter(input, "<this>");
        boolean z2 = true;
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        int r2 = r8;
        if (prepareReadFirstHead != null) {
            while (true) {
                try {
                    int min = Math.min(r2, prepareReadFirstHead.writePosition - prepareReadFirstHead.readPosition);
                    BufferPrimitivesKt.readFully(prepareReadFirstHead, bArr, r7, min);
                    r2 -= min;
                    r7 += min;
                    if (r2 > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        break;
                    }
                    try {
                        ChunkBuffer prepareReadNextHead = UnsafeKt.prepareReadNextHead(input, prepareReadFirstHead);
                        if (prepareReadNextHead == null) {
                            z2 = false;
                            break;
                        }
                        prepareReadFirstHead = prepareReadNextHead;
                    } catch (Throwable th) {
                        th = th;
                        z2 = false;
                        if (z2) {
                            UnsafeKt.completeReadHead(input, prepareReadFirstHead);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z2) {
                UnsafeKt.completeReadHead(input, prepareReadFirstHead);
            }
        }
        return r8 - r2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:            if (r2 == false) goto L24;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r20, r3);     */
    /* renamed from: readAvailable-UAd2zVI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long m1658readAvailableUAd2zVI(io.ktor.utils.io.core.Input r20, java.nio.ByteBuffer r21, long r22, long r24) {
        /*
            r1 = r20
            r0 = r21
            java.lang.String r2 = "$this$readAvailable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "destination"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r3 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r2)
            r4 = 0
            if (r3 != 0) goto L1a
            r8 = r24
            goto L65
        L1a:
            r6 = r22
            r8 = r24
        L1e:
            int r10 = r3.writePosition     // Catch: java.lang.Throwable -> L8c
            int r11 = r3.readPosition     // Catch: java.lang.Throwable -> L8c
            int r10 = r10 - r11
            long r10 = (long) r10     // Catch: java.lang.Throwable -> L8c
            long r10 = java.lang.Math.min(r8, r10)     // Catch: java.lang.Throwable -> L8c
            int r10 = (int) r10     // Catch: java.lang.Throwable -> L8c
            java.nio.ByteBuffer r11 = r3.memory     // Catch: java.lang.Throwable -> L8c
            int r12 = r3.readPosition     // Catch: java.lang.Throwable -> L8c
            long r12 = (long) r12     // Catch: java.lang.Throwable -> L8c
            long r14 = (long) r10     // Catch: java.lang.Throwable -> L8c
            java.nio.ByteBuffer r16 = io.ktor.utils.io.bits.Memory.Empty     // Catch: java.lang.Throwable -> L8c
            r16 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r18 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            r19 = 0
            if (r18 >= 0) goto L86
            int r12 = (int) r12     // Catch: java.lang.Throwable -> L8c
            int r13 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r13 >= 0) goto L80
            int r13 = (int) r14     // Catch: java.lang.Throwable -> L8c
            int r16 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r16 >= 0) goto L7a
            int r2 = (int) r6     // Catch: java.lang.Throwable -> L8c
            io.ktor.utils.io.bits.Memory.m1654copyToJT6ljtQ(r11, r0, r12, r13, r2)     // Catch: java.lang.Throwable -> L8c
            r3.discardExact(r10)     // Catch: java.lang.Throwable -> L8c
            long r8 = r8 - r14
            long r6 = r6 + r14
            int r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            r10 = 0
            if (r2 <= 0) goto L54
            r2 = 1
            goto L55
        L54:
            r2 = r10
        L55:
            if (r2 != 0) goto L59
            r2 = 1
            goto L60
        L59:
            io.ktor.utils.io.core.internal.ChunkBuffer r2 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r1, r3)     // Catch: java.lang.Throwable -> L77
            if (r2 != 0) goto L74
            r2 = r10
        L60:
            if (r2 == 0) goto L65
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r3)
        L65:
            long r2 = r24 - r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L73
            boolean r0 = r20.getEndOfInput()
            if (r0 == 0) goto L73
            r2 = -1
        L73:
            return r2
        L74:
            r3 = r2
            r2 = 1
            goto L1e
        L77:
            r0 = move-exception
            r2 = r10
            goto L8e
        L7a:
            java.lang.String r0 = "destinationOffset"
            io.ktor.utils.io.core.internal.NumbersKt.failLongToIntConversion(r6, r0)     // Catch: java.lang.Throwable -> L8c
            throw r19     // Catch: java.lang.Throwable -> L8c
        L80:
            java.lang.String r0 = "length"
            io.ktor.utils.io.core.internal.NumbersKt.failLongToIntConversion(r14, r0)     // Catch: java.lang.Throwable -> L8c
            throw r19     // Catch: java.lang.Throwable -> L8c
        L86:
            java.lang.String r0 = "offset"
            io.ktor.utils.io.core.internal.NumbersKt.failLongToIntConversion(r12, r0)     // Catch: java.lang.Throwable -> L8c
            throw r19     // Catch: java.lang.Throwable -> L8c
        L8c:
            r0 = move-exception
            r2 = 1
        L8e:
            if (r2 == 0) goto L93
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r3)
        L93:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputArraysKt.m1658readAvailableUAd2zVI(io.ktor.utils.io.core.Input, java.nio.ByteBuffer, long, long):long");
    }
}
