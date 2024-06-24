package io.ktor.utils.io;

/* compiled from: WriterSession.kt */
/* loaded from: classes3.dex */
public final class WriterSessionKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object completeWritingFallback(io.ktor.utils.io.ByteWriteChannel r4, io.ktor.utils.io.core.Buffer r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1 r0 = (io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1 r0 = new io.ktor.utils.io.WriterSessionKt$completeWritingFallback$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.utils.io.core.Buffer r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L43
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5 instanceof io.ktor.utils.io.core.internal.ChunkBuffer
            if (r6 == 0) goto L4d
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.writeFully(r5, r0)
            if (r4 != r1) goto L43
            return r1
        L43:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = (io.ktor.utils.io.core.internal.ChunkBuffer) r5
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion$Pool$1 r4 = io.ktor.utils.io.core.internal.ChunkBuffer.Pool
            r5.release(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L4d:
            java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
            java.lang.String r5 = "Only ChunkBuffer instance is supported."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.WriterSessionKt.completeWritingFallback(io.ktor.utils.io.ByteWriteChannel, io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object writeBufferSuspend(io.ktor.utils.io.WriterSuspendSession r4, int r5, kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.Buffer> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1 r0 = (io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1 r0 = new io.ktor.utils.io.WriterSessionKt$writeBufferSuspend$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r5 = r0.I$0
            io.ktor.utils.io.WriterSuspendSession r4 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L43
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.tryAwait(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = r4.request(r5)
            if (r5 == 0) goto L4a
            goto L4e
        L4a:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = r4.request(r3)
        L4e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.WriterSessionKt.writeBufferSuspend(io.ktor.utils.io.WriterSuspendSession, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
