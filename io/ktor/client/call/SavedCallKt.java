package io.ktor.client.call;

/* compiled from: SavedCall.kt */
/* loaded from: classes3.dex */
public final class SavedCallKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object save(io.ktor.client.call.HttpClientCall r4, kotlin.coroutines.Continuation<? super io.ktor.client.call.HttpClientCall> r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.client.call.SavedCallKt$save$1
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.client.call.SavedCallKt$save$1 r0 = (io.ktor.client.call.SavedCallKt$save$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.call.SavedCallKt$save$1 r0 = new io.ktor.client.call.SavedCallKt$save$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            io.ktor.client.call.HttpClientCall r4 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L47
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            io.ktor.client.statement.HttpResponse r5 = r4.getResponse()
            io.ktor.utils.io.ByteReadChannel r5 = r5.getContent()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.readRemaining$default(r5, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            io.ktor.utils.io.core.ByteReadPacket r5 = (io.ktor.utils.io.core.ByteReadPacket) r5
            byte[] r5 = io.ktor.utils.io.core.StringsKt.readBytes$default(r5)
            io.ktor.client.call.SavedHttpCall r0 = new io.ktor.client.call.SavedHttpCall
            io.ktor.client.HttpClient r1 = r4.client
            io.ktor.client.request.HttpRequest r2 = r4.getRequest()
            io.ktor.client.statement.HttpResponse r4 = r4.getResponse()
            r0.<init>(r1, r2, r4, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.call.SavedCallKt.save(io.ktor.client.call.HttpClientCall, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
