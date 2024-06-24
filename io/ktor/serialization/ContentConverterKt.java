package io.ktor.serialization;

/* compiled from: ContentConverter.kt */
/* loaded from: classes3.dex */
public final class ContentConverterKt {
    /* JADX WARN: Removed duplicated region for block: B:11:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object deserialize(java.util.ArrayList r4, final io.ktor.utils.io.ByteReadChannel r5, final io.ktor.util.reflect.TypeInfo r6, final java.nio.charset.Charset r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.serialization.ContentConverterKt$deserialize$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.serialization.ContentConverterKt$deserialize$1 r0 = (io.ktor.serialization.ContentConverterKt$deserialize$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.serialization.ContentConverterKt$deserialize$1 r0 = new io.ktor.serialization.ContentConverterKt$deserialize$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            io.ktor.util.reflect.TypeInfo r6 = r0.L$1
            io.ktor.utils.io.ByteReadChannel r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L53
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3 r8 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3
            r8.<init>(r4)
            io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1 r4 = new io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1
            r4.<init>()
            io.ktor.serialization.ContentConverterKt$deserialize$result$2 r7 = new io.ktor.serialization.ContentConverterKt$deserialize$result$2
            r8 = 0
            r7.<init>(r5, r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r4, r7, r0)
            if (r8 != r1) goto L53
            return r1
        L53:
            if (r8 != 0) goto L81
            boolean r4 = r5.isClosedForRead()
            if (r4 != 0) goto L5c
            goto L82
        L5c:
            kotlin.reflect.KType r4 = r6.kotlinType
            if (r4 == 0) goto L67
            boolean r4 = r4.isMarkedNullable()
            if (r4 != r3) goto L67
            goto L68
        L67:
            r3 = 0
        L68:
            if (r3 == 0) goto L6d
            io.ktor.http.content.NullBody r5 = io.ktor.http.content.NullBody.INSTANCE
            goto L82
        L6d:
            io.ktor.serialization.ContentConvertException r4 = new io.ktor.serialization.ContentConvertException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "No suitable converter found for "
            r5.<init>(r7)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L81:
            r5 = r8
        L82:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.ContentConverterKt.deserialize(java.util.ArrayList, io.ktor.utils.io.ByteReadChannel, io.ktor.util.reflect.TypeInfo, java.nio.charset.Charset, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
