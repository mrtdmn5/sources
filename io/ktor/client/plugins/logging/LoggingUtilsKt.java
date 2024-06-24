package io.ktor.client.plugins.logging;

import io.ktor.client.statement.HttpResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoggingUtils.kt */
/* loaded from: classes3.dex */
public final class LoggingUtilsKt {
    public static final void logHeader(Appendable appendable, String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Appendable append = appendable.append("-> " + key + ": " + value);
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
    }

    public static final void logHeaders(Appendable appendable, Set<? extends Map.Entry<String, ? extends List<String>>> headers, List<SanitizedHeader> sanitizedHeaders) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(sanitizedHeaders, "sanitizedHeaders");
        for (Map.Entry entry : CollectionsKt___CollectionsKt.sortedWith(CollectionsKt___CollectionsKt.toList(headers), new LoggingUtilsKt$logHeaders$$inlined$sortedBy$1())) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            Iterator<T> it = sanitizedHeaders.iterator();
            if (!it.hasNext()) {
                logHeader(appendable, str, CollectionsKt___CollectionsKt.joinToString$default(list, "; ", null, null, null, 62));
            } else {
                ((SanitizedHeader) it.next()).getClass();
                throw null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object logResponseBody(java.lang.StringBuilder r5, io.ktor.http.ContentType r6, io.ktor.utils.io.ByteReadChannel r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.client.plugins.logging.LoggingUtilsKt$logResponseBody$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.client.plugins.logging.LoggingUtilsKt$logResponseBody$1 r0 = (io.ktor.client.plugins.logging.LoggingUtilsKt$logResponseBody$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.logging.LoggingUtilsKt$logResponseBody$1 r0 = new io.ktor.client.plugins.logging.LoggingUtilsKt$logResponseBody$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.nio.charset.Charset r5 = r0.L$1
            java.lang.StringBuilder r6 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L2b
            goto L75
        L2b:
            r5 = r6
            goto L7c
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r2 = "BODY Content-Type: "
            r8.<init>(r2)
            r8.append(r6)
            java.lang.String r8 = r8.toString()
            r5.append(r8)
            r8 = 10
            r5.append(r8)
            java.lang.String r2 = "BODY START"
            r5.append(r2)
            r5.append(r8)
            if (r6 == 0) goto L5e
            java.nio.charset.Charset r6 = io.ktor.http.ContentTypesKt.charset(r6)
            if (r6 != 0) goto L60
        L5e:
            java.nio.charset.Charset r6 = kotlin.text.Charsets.UTF_8
        L60:
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L7c
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L7c
            r0.label = r3     // Catch: java.lang.Throwable -> L7c
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r8 = r7.readRemaining(r2, r0)     // Catch: java.lang.Throwable -> L7c
            if (r8 != r1) goto L72
            return r1
        L72:
            r4 = r6
            r6 = r5
            r5 = r4
        L75:
            io.ktor.utils.io.core.Input r8 = (io.ktor.utils.io.core.Input) r8     // Catch: java.lang.Throwable -> L2b
            java.lang.String r5 = io.ktor.utils.io.core.StringsKt.readText$default(r8, r5)     // Catch: java.lang.Throwable -> L2b
            goto L80
        L7c:
            r6 = 0
            r4 = r6
            r6 = r5
            r5 = r4
        L80:
            if (r5 != 0) goto L84
            java.lang.String r5 = "[response body omitted]"
        L84:
            r6.append(r5)
            java.lang.String r5 = "\nBODY END"
            r6.append(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.LoggingUtilsKt.logResponseBody(java.lang.StringBuilder, io.ktor.http.ContentType, io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void logResponseHeader(StringBuilder sb, HttpResponse httpResponse, LogLevel level, List<SanitizedHeader> sanitizedHeaders) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(sanitizedHeaders, "sanitizedHeaders");
        if (level.getInfo()) {
            sb.append("RESPONSE: " + httpResponse.getStatus());
            sb.append('\n');
            sb.append("METHOD: " + httpResponse.getCall().getRequest().getMethod());
            sb.append('\n');
            sb.append("FROM: " + httpResponse.getCall().getRequest().getUrl());
            sb.append('\n');
        }
        if (level.getHeaders()) {
            sb.append("COMMON HEADERS");
            sb.append('\n');
            logHeaders(sb, httpResponse.getHeaders().entries(), sanitizedHeaders);
        }
    }
}
