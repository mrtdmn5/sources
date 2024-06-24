package io.ktor.utils.io.charsets;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Encoding.kt */
/* loaded from: classes3.dex */
public final class EncodingKt {
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a7, code lost:            throw new java.lang.IllegalStateException("Buffer's limit change is not allowed".toString());     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00cf, code lost:            if (r5 == 0) goto L59;     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d1, code lost:            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r14, r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d4, code lost:            r5 = r7;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String decode(java.nio.charset.CharsetDecoder r13, io.ktor.utils.io.core.Input r14, int r15) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.EncodingKt.decode(java.nio.charset.CharsetDecoder, io.ktor.utils.io.core.Input, int):java.lang.String");
    }

    public static final ByteReadPacket encode(CharsetEncoder charsetEncoder, CharSequence input, int r4, int r5) {
        Intrinsics.checkNotNullParameter(input, "input");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null);
        try {
            encodeToImpl(charsetEncoder, bytePacketBuilder, input, r4, r5);
            return bytePacketBuilder.build();
        } catch (Throwable th) {
            bytePacketBuilder.close();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0063, code lost:            throw new java.lang.IllegalStateException("Check failed.".toString());     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void encodeToImpl(java.nio.charset.CharsetEncoder r6, io.ktor.utils.io.core.Output r7, java.lang.CharSequence r8, int r9, int r10) {
        /*
            java.lang.String r0 = "destination"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            if (r9 < r10) goto Ld
            return
        Ld:
            r0 = 1
            r1 = 0
            io.ktor.utils.io.core.internal.ChunkBuffer r2 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r7, r0, r1)
        L13:
            int r3 = io.ktor.utils.io.charsets.CharsetJVMKt.encodeImpl(r6, r8, r9, r10, r2)     // Catch: java.lang.Throwable -> L64
            r4 = 0
            if (r3 < 0) goto L1c
            r5 = r0
            goto L1d
        L1c:
            r5 = r4
        L1d:
            if (r5 == 0) goto L58
            int r9 = r9 + r3
            if (r9 < r10) goto L24
            r3 = r4
            goto L2a
        L24:
            if (r3 != 0) goto L29
            r3 = 8
            goto L2a
        L29:
            r3 = r0
        L2a:
            if (r3 <= 0) goto L31
            io.ktor.utils.io.core.internal.ChunkBuffer r2 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r7, r3, r2)     // Catch: java.lang.Throwable -> L64
            goto L13
        L31:
            r7.afterHeadWrite()
            io.ktor.utils.io.core.internal.ChunkBuffer r8 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r7, r0, r1)
            r9 = r0
        L39:
            boolean r10 = io.ktor.utils.io.charsets.CharsetJVMKt.encodeComplete(r6, r8)     // Catch: java.lang.Throwable -> L4e
            if (r10 == 0) goto L41
            r9 = r4
            goto L42
        L41:
            int r9 = r9 + r0
        L42:
            if (r9 <= 0) goto L46
            r10 = r0
            goto L47
        L46:
            r10 = r4
        L47:
            if (r10 == 0) goto L50
            io.ktor.utils.io.core.internal.ChunkBuffer r8 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r7, r0, r8)     // Catch: java.lang.Throwable -> L4e
            goto L39
        L4e:
            r6 = move-exception
            goto L54
        L50:
            r7.afterHeadWrite()
            return
        L54:
            r7.afterHeadWrite()
            throw r6
        L58:
            java.lang.String r6 = "Check failed."
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L64
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L64
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L64
            throw r8     // Catch: java.lang.Throwable -> L64
        L64:
            r6 = move-exception
            r7.afterHeadWrite()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.EncodingKt.encodeToImpl(java.nio.charset.CharsetEncoder, io.ktor.utils.io.core.Output, java.lang.CharSequence, int, int):void");
    }
}
