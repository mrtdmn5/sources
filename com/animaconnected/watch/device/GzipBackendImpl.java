package com.animaconnected.watch.device;

/* compiled from: GzipBackendImpl.kt */
/* loaded from: classes3.dex */
public final class GzipBackendImpl implements GzipBackend {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.Closeable] */
    @Override // com.animaconnected.watch.device.GzipBackend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object compress(java.lang.String r7, kotlin.coroutines.Continuation<? super byte[]> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.GzipBackendImpl$compress$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.GzipBackendImpl$compress$1 r0 = (com.animaconnected.watch.device.GzipBackendImpl$compress$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.GzipBackendImpl$compress$1 r0 = new com.animaconnected.watch.device.GzipBackendImpl$compress$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r7 = r0.L$1
            java.io.ByteArrayOutputStream r7 = (java.io.ByteArrayOutputStream) r7
            java.lang.Object r0 = r0.L$0
            java.io.Closeable r0 = (java.io.Closeable) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L30
            goto L5c
        L30:
            r7 = move-exception
            goto L69
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream
            int r2 = r7.length()
            r8.<init>(r2)
            kotlinx.coroutines.scheduling.DefaultIoScheduler r2 = kotlinx.coroutines.Dispatchers.IO     // Catch: java.lang.Throwable -> L6b
            com.animaconnected.watch.device.GzipBackendImpl$compress$2$1 r5 = new com.animaconnected.watch.device.GzipBackendImpl$compress$2$1     // Catch: java.lang.Throwable -> L6b
            r5.<init>(r8, r7, r3)     // Catch: java.lang.Throwable -> L6b
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L6b
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L6b
            r0.label = r4     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r2, r5, r0)     // Catch: java.lang.Throwable -> L6b
            if (r7 != r1) goto L5a
            return r1
        L5a:
            r7 = r8
            r0 = r7
        L5c:
            byte[] r7 = r7.toByteArray()     // Catch: java.lang.Throwable -> L30
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            java.lang.String r8 = "use(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            return r7
        L69:
            r8 = r0
            goto L6c
        L6b:
            r7 = move-exception
        L6c:
            throw r7     // Catch: java.lang.Throwable -> L6d
        L6d:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.GzipBackendImpl.compress(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.device.GzipBackend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object decompress(byte[] r7, kotlin.coroutines.Continuation<? super java.lang.String> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.GzipBackendImpl$decompress$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.GzipBackendImpl$decompress$1 r0 = (com.animaconnected.watch.device.GzipBackendImpl$decompress$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.GzipBackendImpl$decompress$1 r0 = new com.animaconnected.watch.device.GzipBackendImpl$decompress$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r7 = r0.L$0
            java.io.Closeable r7 = (java.io.Closeable) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L2c
            goto L53
        L2c:
            r8 = move-exception
            goto L5d
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            kotlin.ResultKt.throwOnFailure(r8)
            java.io.ByteArrayInputStream r8 = new java.io.ByteArrayInputStream
            r8.<init>(r7)
            kotlinx.coroutines.scheduling.DefaultIoScheduler r7 = kotlinx.coroutines.Dispatchers.IO     // Catch: java.lang.Throwable -> L59
            com.animaconnected.watch.device.GzipBackendImpl$decompress$2$1 r2 = new com.animaconnected.watch.device.GzipBackendImpl$decompress$2$1     // Catch: java.lang.Throwable -> L59
            r2.<init>(r8, r3)     // Catch: java.lang.Throwable -> L59
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L59
            r0.label = r4     // Catch: java.lang.Throwable -> L59
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)     // Catch: java.lang.Throwable -> L59
            if (r7 != r1) goto L50
            return r1
        L50:
            r5 = r8
            r8 = r7
            r7 = r5
        L53:
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L2c
            kotlin.io.CloseableKt.closeFinally(r7, r3)
            return r8
        L59:
            r7 = move-exception
            r5 = r8
            r8 = r7
            r7 = r5
        L5d:
            throw r8     // Catch: java.lang.Throwable -> L5e
        L5e:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r7, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.GzipBackendImpl.decompress(byte[], kotlin.coroutines.Continuation):java.lang.Object");
    }
}
