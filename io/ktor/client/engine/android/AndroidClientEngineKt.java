package io.ktor.client.engine.android;

import io.ktor.http.HttpMethod;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: AndroidClientEngine.kt */
/* loaded from: classes3.dex */
public final class AndroidClientEngineKt {
    public static final List<HttpMethod> METHODS_WITHOUT_BODY;

    static {
        HttpMethod httpMethod = HttpMethod.Get;
        METHODS_WITHOUT_BODY = CollectionsKt__CollectionsKt.listOf((Object[]) new HttpMethod[]{HttpMethod.Get, HttpMethod.Head});
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object writeTo(io.ktor.http.content.OutgoingContent r8, java.io.OutputStream r9, kotlin.coroutines.CoroutineContext r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof io.ktor.client.engine.android.AndroidClientEngineKt$writeTo$1
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.client.engine.android.AndroidClientEngineKt$writeTo$1 r0 = (io.ktor.client.engine.android.AndroidClientEngineKt$writeTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.engine.android.AndroidClientEngineKt$writeTo$1 r0 = new io.ktor.client.engine.android.AndroidClientEngineKt$writeTo$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3b
            if (r2 == r5) goto L35
            if (r2 != r4) goto L2d
            java.io.OutputStream r9 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L6c
            goto L8f
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            java.io.OutputStream r9 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L6c
            goto L66
        L3b:
            kotlin.ResultKt.throwOnFailure(r11)
            boolean r11 = r8 instanceof io.ktor.http.content.OutgoingContent.ByteArrayContent     // Catch: java.lang.Throwable -> L6c
            if (r11 == 0) goto L4c
            io.ktor.http.content.OutgoingContent$ByteArrayContent r8 = (io.ktor.http.content.OutgoingContent.ByteArrayContent) r8     // Catch: java.lang.Throwable -> L6c
            byte[] r8 = r8.bytes()     // Catch: java.lang.Throwable -> L6c
            r9.write(r8)     // Catch: java.lang.Throwable -> L6c
            goto L8f
        L4c:
            boolean r11 = r8 instanceof io.ktor.http.content.OutgoingContent.ReadChannelContent     // Catch: java.lang.Throwable -> L6c
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r11 == 0) goto L6e
            io.ktor.http.content.OutgoingContent$ReadChannelContent r8 = (io.ktor.http.content.OutgoingContent.ReadChannelContent) r8     // Catch: java.lang.Throwable -> L6c
            io.ktor.utils.io.ByteReadChannel r8 = r8.readFrom()     // Catch: java.lang.Throwable -> L6c
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L6c
            r0.label = r5     // Catch: java.lang.Throwable -> L6c
            java.lang.Object r11 = io.ktor.utils.io.jvm.javaio.WritingKt.copyTo(r8, r9, r6, r0)     // Catch: java.lang.Throwable -> L6c
            if (r11 != r1) goto L66
            return r1
        L66:
            java.lang.Number r11 = (java.lang.Number) r11     // Catch: java.lang.Throwable -> L6c
            r11.longValue()     // Catch: java.lang.Throwable -> L6c
            goto L8f
        L6c:
            r8 = move-exception
            goto L9d
        L6e:
            boolean r11 = r8 instanceof io.ktor.http.content.OutgoingContent.WriteChannelContent     // Catch: java.lang.Throwable -> L6c
            if (r11 == 0) goto L8b
            kotlinx.coroutines.GlobalScope r11 = kotlinx.coroutines.GlobalScope.INSTANCE     // Catch: java.lang.Throwable -> L6c
            io.ktor.client.engine.android.AndroidClientEngineKt$writeTo$2$channel$1 r2 = new io.ktor.client.engine.android.AndroidClientEngineKt$writeTo$2$channel$1     // Catch: java.lang.Throwable -> L6c
            r2.<init>(r8, r3)     // Catch: java.lang.Throwable -> L6c
            r8 = 0
            io.ktor.utils.io.ChannelJob r8 = io.ktor.utils.io.CoroutinesKt.writer(r11, r10, r8, r2)     // Catch: java.lang.Throwable -> L6c
            io.ktor.utils.io.ByteChannel r8 = r8.channel     // Catch: java.lang.Throwable -> L6c
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L6c
            r0.label = r4     // Catch: java.lang.Throwable -> L6c
            java.lang.Object r8 = io.ktor.utils.io.jvm.javaio.WritingKt.copyTo(r8, r9, r6, r0)     // Catch: java.lang.Throwable -> L6c
            if (r8 != r1) goto L8f
            return r1
        L8b:
            boolean r10 = r8 instanceof io.ktor.http.content.OutgoingContent.NoContent     // Catch: java.lang.Throwable -> L6c
            if (r10 == 0) goto L97
        L8f:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L6c
            kotlin.io.CloseableKt.closeFinally(r9, r3)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L97:
            io.ktor.client.call.UnsupportedContentTypeException r10 = new io.ktor.client.call.UnsupportedContentTypeException     // Catch: java.lang.Throwable -> L6c
            r10.<init>(r8)     // Catch: java.lang.Throwable -> L6c
            throw r10     // Catch: java.lang.Throwable -> L6c
        L9d:
            throw r8     // Catch: java.lang.Throwable -> L9e
        L9e:
            r10 = move-exception
            kotlin.io.CloseableKt.closeFinally(r9, r8)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.android.AndroidClientEngineKt.writeTo(io.ktor.http.content.OutgoingContent, java.io.OutputStream, kotlin.coroutines.CoroutineContext, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
