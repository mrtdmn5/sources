package io.ktor.client.statement;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* compiled from: HttpResponse.kt */
/* loaded from: classes3.dex */
public final class HttpResponseKt {
    /* JADX WARN: Removed duplicated region for block: B:11:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object bodyAsText(io.ktor.client.statement.HttpResponse r6, java.nio.charset.Charset r7, kotlin.coroutines.Continuation<? super java.lang.String> r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.client.statement.HttpResponseKt$bodyAsText$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.client.statement.HttpResponseKt$bodyAsText$1 r0 = (io.ktor.client.statement.HttpResponseKt$bodyAsText$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpResponseKt$bodyAsText$1 r0 = new io.ktor.client.statement.HttpResponseKt$bodyAsText$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            java.nio.charset.CharsetDecoder r6 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L70
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r8)
            io.ktor.http.ContentType r8 = io.ktor.http.HttpMessagePropertiesKt.contentType(r6)
            if (r8 == 0) goto L44
            java.nio.charset.Charset r8 = io.ktor.http.ContentTypesKt.charset(r8)
            goto L45
        L44:
            r8 = 0
        L45:
            if (r8 != 0) goto L48
            goto L49
        L48:
            r7 = r8
        L49:
            java.nio.charset.CharsetDecoder r7 = r7.newDecoder()
            io.ktor.client.call.HttpClientCall r6 = r6.getCall()
            java.lang.Class<io.ktor.utils.io.core.Input> r8 = io.ktor.utils.io.core.Input.class
            kotlin.jvm.internal.TypeReference r2 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r4 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            kotlin.jvm.internal.ClassReference r8 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            io.ktor.util.reflect.TypeInfo r5 = new io.ktor.util.reflect.TypeInfo
            r5.<init>(r4, r8, r2)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r6.bodyNullable(r5, r0)
            if (r8 != r1) goto L6f
            return r1
        L6f:
            r6 = r7
        L70:
            if (r8 == 0) goto L81
            io.ktor.utils.io.core.Input r8 = (io.ktor.utils.io.core.Input) r8
            java.lang.String r7 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r7 = 2147483647(0x7fffffff, float:NaN)
            java.lang.String r6 = io.ktor.utils.io.charsets.EncodingKt.decode(r6, r8, r7)
            return r6
        L81:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type io.ktor.utils.io.core.Input"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpResponseKt.bodyAsText(io.ktor.client.statement.HttpResponse, java.nio.charset.Charset, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void complete(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        CoroutineContext coroutineContext = httpResponse.getCoroutineContext();
        int r0 = Job.$r8$clinit;
        CoroutineContext.Element element = coroutineContext.get(Job.Key.$$INSTANCE);
        Intrinsics.checkNotNull(element);
        ((CompletableJob) element).complete();
    }
}
