package io.ktor.client.plugins.logging;

/* compiled from: ObservingUtils.kt */
/* loaded from: classes3.dex */
public final class ObservingUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Type inference failed for: r7v6, types: [io.ktor.utils.io.ByteWriteChannel] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object observe(io.ktor.http.content.OutgoingContent r6, io.ktor.utils.io.ByteBufferChannel r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.client.plugins.logging.ObservingUtilsKt$observe$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.client.plugins.logging.ObservingUtilsKt$observe$1 r0 = (io.ktor.client.plugins.logging.ObservingUtilsKt$observe$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.logging.ObservingUtilsKt$observe$1 r0 = new io.ktor.client.plugins.logging.ObservingUtilsKt$observe$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            io.ktor.utils.io.ByteWriteChannel r7 = r0.L$1
            io.ktor.http.content.OutgoingContent r6 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4e
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r6 instanceof io.ktor.http.content.OutgoingContent.ByteArrayContent
            if (r8 == 0) goto L52
            r8 = r6
            io.ktor.http.content.OutgoingContent$ByteArrayContent r8 = (io.ktor.http.content.OutgoingContent.ByteArrayContent) r8
            byte[] r8 = r8.bytes()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = io.ktor.utils.io.ByteWriteChannelKt.writeFully(r7, r8, r0)
            if (r8 != r1) goto L4e
            return r1
        L4e:
            io.ktor.utils.io.ByteWriteChannelKt.close(r7)
            goto L95
        L52:
            boolean r8 = r6 instanceof io.ktor.http.content.OutgoingContent.ReadChannelContent
            r0 = 0
            if (r8 == 0) goto L6d
            io.ktor.utils.io.ByteBufferChannel r8 = new io.ktor.utils.io.ByteBufferChannel
            r8.<init>(r0)
            r0 = r6
            io.ktor.http.content.OutgoingContent$ReadChannelContent r0 = (io.ktor.http.content.OutgoingContent.ReadChannelContent) r0
            io.ktor.utils.io.ByteReadChannel r0 = r0.readFrom()
            io.ktor.util.ByteChannelsKt.copyToBoth(r0, r7, r8)
            io.ktor.client.plugins.logging.LoggedContent r7 = new io.ktor.client.plugins.logging.LoggedContent
            r7.<init>(r6, r8)
        L6b:
            r6 = r7
            goto L95
        L6d:
            boolean r8 = r6 instanceof io.ktor.http.content.OutgoingContent.WriteChannelContent
            if (r8 == 0) goto L92
            io.ktor.utils.io.ByteBufferChannel r8 = new io.ktor.utils.io.ByteBufferChannel
            r8.<init>(r0)
            r1 = r6
            io.ktor.http.content.OutgoingContent$WriteChannelContent r1 = (io.ktor.http.content.OutgoingContent.WriteChannelContent) r1
            kotlinx.coroutines.GlobalScope r2 = kotlinx.coroutines.GlobalScope.INSTANCE
            kotlinx.coroutines.scheduling.DefaultScheduler r3 = kotlinx.coroutines.Dispatchers.Default
            io.ktor.client.plugins.logging.ObservingUtilsKt$toReadChannel$1 r4 = new io.ktor.client.plugins.logging.ObservingUtilsKt$toReadChannel$1
            r5 = 0
            r4.<init>(r1, r5)
            io.ktor.utils.io.ChannelJob r0 = io.ktor.utils.io.CoroutinesKt.writer(r2, r3, r0, r4)
            io.ktor.utils.io.ByteChannel r0 = r0.channel
            io.ktor.util.ByteChannelsKt.copyToBoth(r0, r7, r8)
            io.ktor.client.plugins.logging.LoggedContent r7 = new io.ktor.client.plugins.logging.LoggedContent
            r7.<init>(r6, r8)
            goto L6b
        L92:
            io.ktor.utils.io.ByteWriteChannelKt.close(r7)
        L95:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.ObservingUtilsKt.observe(io.ktor.http.content.OutgoingContent, io.ktor.utils.io.ByteBufferChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
