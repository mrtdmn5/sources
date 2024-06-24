package io.ktor.utils.io;

import io.ktor.utils.io.internal.SequentialCopyToKt;
import kotlin.coroutines.Continuation;

/* compiled from: ByteReadChannelJVM.kt */
/* loaded from: classes3.dex */
public final class ByteReadChannelJVMKt {
    public static final Object copyTo(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation<? super Long> continuation) {
        boolean z;
        if (byteReadChannel != byteWriteChannel) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (j == 0) {
                return new Long(0L);
            }
            if ((byteReadChannel instanceof ByteBufferChannel) && (byteWriteChannel instanceof ByteBufferChannel)) {
                return ((ByteBufferChannel) byteWriteChannel).copyDirect$ktor_io((ByteBufferChannel) byteReadChannel, j, continuation);
            }
            if ((byteReadChannel instanceof ByteChannelSequentialBase) && (byteWriteChannel instanceof ByteChannelSequentialBase)) {
                return SequentialCopyToKt.copyToSequentialImpl((ByteChannelSequentialBase) byteReadChannel, (ByteChannelSequentialBase) byteWriteChannel, Long.MAX_VALUE, continuation);
            }
            return copyToImpl(byteReadChannel, byteWriteChannel, j, continuation);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bb A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #4 {all -> 0x005f, blocks: (B:12:0x0038, B:41:0x00b2, B:43:0x00bb, B:61:0x005b), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v2, types: [int] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00d2 -> B:14:0x00dc). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object copyToImpl(io.ktor.utils.io.ByteReadChannel r21, io.ktor.utils.io.ByteWriteChannel r22, long r23, kotlin.coroutines.Continuation<? super java.lang.Long> r25) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelJVMKt.copyToImpl(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
