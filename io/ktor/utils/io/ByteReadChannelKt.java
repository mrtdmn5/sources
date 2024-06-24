package io.ktor.utils.io;

/* compiled from: ByteReadChannel.kt */
/* loaded from: classes3.dex */
public final class ByteReadChannelKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Type inference failed for: r5v3, types: [io.ktor.utils.io.ByteWriteChannel] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object copyAndClose(io.ktor.utils.io.ByteReadChannel r4, io.ktor.utils.io.ByteChannel r5, long r6, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteReadChannelKt$copyAndClose$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.ByteReadChannelKt$copyAndClose$1 r0 = (io.ktor.utils.io.ByteReadChannelKt$copyAndClose$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.utils.io.ByteReadChannelKt$copyAndClose$1 r0 = new io.ktor.utils.io.ByteReadChannelKt$copyAndClose$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.utils.io.ByteWriteChannel r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L3f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r8 = io.ktor.utils.io.ByteReadChannelJVMKt.copyTo(r4, r5, r6, r0)
            if (r8 != r1) goto L3f
            return r1
        L3f:
            java.lang.Number r8 = (java.lang.Number) r8
            long r6 = r8.longValue()
            io.ktor.utils.io.ByteWriteChannelKt.close(r5)
            java.lang.Long r4 = new java.lang.Long
            r4.<init>(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelKt.copyAndClose(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
