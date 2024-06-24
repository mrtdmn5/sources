package io.ktor.client.statement;

import io.ktor.client.HttpClient;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpStatement.kt */
/* loaded from: classes3.dex */
public final class HttpStatement {
    public final HttpRequestBuilder builder;
    public final HttpClient client;

    public HttpStatement(HttpRequestBuilder httpRequestBuilder, HttpClient client) {
        Set keySet;
        Intrinsics.checkNotNullParameter(client, "client");
        this.builder = httpRequestBuilder;
        this.client = client;
        Map map = (Map) httpRequestBuilder.attributes.getOrNull(HttpClientEngineCapabilityKt.ENGINE_CAPABILITIES_KEY);
        if (map != null && (keySet = map.keySet()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : keySet) {
                if (obj instanceof HttpClientPlugin) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                HttpClientPlugin httpClientPlugin = (HttpClientPlugin) it.next();
                if (HttpClientPluginKt.pluginOrNull(this.client, httpClientPlugin) == null) {
                    throw new IllegalArgumentException(("Consider installing " + httpClientPlugin + " plugin because the request requires it to be installed").toString());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object cleanup(io.ktor.client.statement.HttpResponse r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.statement.HttpStatement$cleanup$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = (io.ktor.client.statement.HttpStatement$cleanup$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = new io.ktor.client.statement.HttpStatement$cleanup$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5c
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.coroutines.CoroutineContext r6 = r5.getCoroutineContext()
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.Key.$$INSTANCE
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            kotlinx.coroutines.CompletableJob r6 = (kotlinx.coroutines.CompletableJob) r6
            r6.complete()
            io.ktor.utils.io.ByteReadChannel r5 = r5.getContent()     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)     // Catch: java.lang.Throwable -> L51
            r2 = 0
            r5.cancel(r2)     // Catch: java.lang.Throwable -> L51
        L51:
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = r6.join(r0)
            if (r5 != r1) goto L5c
            return r1
        L5c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.cleanup(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|7|(1:(1:(1:(1:(2:13|14)(3:16|17|18))(3:19|20|21))(5:22|23|24|25|(1:27)(2:28|29)))(2:36|37))(3:46|47|(1:49)(1:50))|38|39|40|(1:42)(3:43|25|(0)(0))))|54|6|7|(0)(0)|38|39|40|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0093, code lost:            r10 = th;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r10v13, types: [kotlin.jvm.functions.Function2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object execute(io.ktor.client.statement.HttpStatement$execute$4 r10, kotlin.coroutines.Continuation r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof io.ktor.client.statement.HttpStatement$execute$1
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.client.statement.HttpStatement$execute$1 r0 = (io.ktor.client.statement.HttpStatement$execute$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpStatement$execute$1 r0 = new io.ktor.client.statement.HttpStatement$execute$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L61
            if (r2 == r7) goto L55
            if (r2 == r6) goto L44
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L35
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            java.lang.Object r10 = r0.L$0
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.util.concurrent.CancellationException -> La2
            goto La1
        L3e:
            java.lang.Object r10 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.util.concurrent.CancellationException -> La2
            goto L92
        L44:
            java.lang.Object r10 = r0.L$1
            io.ktor.client.statement.HttpResponse r10 = (io.ktor.client.statement.HttpResponse) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.client.statement.HttpStatement r2 = (io.ktor.client.statement.HttpStatement) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L50
            goto L84
        L50:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L94
        L55:
            java.lang.Object r10 = r0.L$1
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.client.statement.HttpStatement r2 = (io.ktor.client.statement.HttpStatement) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.util.concurrent.CancellationException -> La2
            goto L72
        L61:
            kotlin.ResultKt.throwOnFailure(r11)
            r0.L$0 = r9     // Catch: java.util.concurrent.CancellationException -> La2
            r0.L$1 = r10     // Catch: java.util.concurrent.CancellationException -> La2
            r0.label = r7     // Catch: java.util.concurrent.CancellationException -> La2
            java.lang.Object r11 = r9.executeUnsafe(r0)     // Catch: java.util.concurrent.CancellationException -> La2
            if (r11 != r1) goto L71
            return r1
        L71:
            r2 = r9
        L72:
            io.ktor.client.statement.HttpResponse r11 = (io.ktor.client.statement.HttpResponse) r11     // Catch: java.util.concurrent.CancellationException -> La2
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L93
            r0.L$1 = r11     // Catch: java.lang.Throwable -> L93
            r0.label = r6     // Catch: java.lang.Throwable -> L93
            java.lang.Object r10 = r10.invoke(r11, r0)     // Catch: java.lang.Throwable -> L93
            if (r10 != r1) goto L81
            return r1
        L81:
            r8 = r11
            r11 = r10
            r10 = r8
        L84:
            r0.L$0 = r11     // Catch: java.util.concurrent.CancellationException -> La2
            r0.L$1 = r3     // Catch: java.util.concurrent.CancellationException -> La2
            r0.label = r5     // Catch: java.util.concurrent.CancellationException -> La2
            java.lang.Object r10 = r2.cleanup(r10, r0)     // Catch: java.util.concurrent.CancellationException -> La2
            if (r10 != r1) goto L91
            return r1
        L91:
            r10 = r11
        L92:
            return r10
        L93:
            r10 = move-exception
        L94:
            r0.L$0 = r10     // Catch: java.util.concurrent.CancellationException -> La2
            r0.L$1 = r3     // Catch: java.util.concurrent.CancellationException -> La2
            r0.label = r4     // Catch: java.util.concurrent.CancellationException -> La2
            java.lang.Object r11 = r2.cleanup(r11, r0)     // Catch: java.util.concurrent.CancellationException -> La2
            if (r11 != r1) goto La1
            return r1
        La1:
            throw r10     // Catch: java.util.concurrent.CancellationException -> La2
        La2:
            r10 = move-exception
            java.lang.Throwable r10 = kotlin.jdk7.AutoCloseableKt.unwrapCancellationException(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.execute(io.ktor.client.statement.HttpStatement$execute$4, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object executeUnsafe(kotlin.coroutines.Continuation<? super io.ktor.client.statement.HttpResponse> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.client.statement.HttpStatement$executeUnsafe$1
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.client.statement.HttpStatement$executeUnsafe$1 r0 = (io.ktor.client.statement.HttpStatement$executeUnsafe$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpStatement$executeUnsafe$1 r0 = new io.ktor.client.statement.HttpStatement$executeUnsafe$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.util.concurrent.CancellationException -> L4e
            goto L47
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r5)
            io.ktor.client.request.HttpRequestBuilder r5 = new io.ktor.client.request.HttpRequestBuilder     // Catch: java.util.concurrent.CancellationException -> L4e
            r5.<init>()     // Catch: java.util.concurrent.CancellationException -> L4e
            io.ktor.client.request.HttpRequestBuilder r2 = r4.builder     // Catch: java.util.concurrent.CancellationException -> L4e
            r5.takeFromWithExecutionContext(r2)     // Catch: java.util.concurrent.CancellationException -> L4e
            io.ktor.client.HttpClient r2 = r4.client     // Catch: java.util.concurrent.CancellationException -> L4e
            r0.label = r3     // Catch: java.util.concurrent.CancellationException -> L4e
            java.lang.Object r5 = r2.execute$ktor_client_core(r5, r0)     // Catch: java.util.concurrent.CancellationException -> L4e
            if (r5 != r1) goto L47
            return r1
        L47:
            io.ktor.client.call.HttpClientCall r5 = (io.ktor.client.call.HttpClientCall) r5     // Catch: java.util.concurrent.CancellationException -> L4e
            io.ktor.client.statement.HttpResponse r5 = r5.getResponse()     // Catch: java.util.concurrent.CancellationException -> L4e
            return r5
        L4e:
            r5 = move-exception
            java.lang.Throwable r5 = kotlin.jdk7.AutoCloseableKt.unwrapCancellationException(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.executeUnsafe(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String toString() {
        return "HttpStatement[" + this.builder.url + ']';
    }

    public final Object execute(Continuation<? super HttpResponse> continuation) {
        return execute(new HttpStatement$execute$4(null), continuation);
    }
}
