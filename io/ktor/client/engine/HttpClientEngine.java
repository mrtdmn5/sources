package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.engine.android.AndroidEngineConfig;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import java.io.Closeable;
import java.util.Set;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HttpClientEngine.kt */
/* loaded from: classes3.dex */
public interface HttpClientEngine extends CoroutineScope, Closeable {

    /* compiled from: HttpClientEngine.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static final java.lang.Object access$executeWithinCallContext(io.ktor.client.engine.HttpClientEngine r7, io.ktor.client.request.HttpRequestData r8, kotlin.coroutines.Continuation r9) {
            /*
                boolean r0 = r9 instanceof io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1
                if (r0 == 0) goto L13
                r0 = r9
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = (io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 1
                r4 = 2
                if (r2 == 0) goto L3b
                if (r2 == r3) goto L33
                if (r2 != r4) goto L2b
                kotlin.ResultKt.throwOnFailure(r9)
                goto La0
            L2b:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L33:
                io.ktor.client.request.HttpRequestData r8 = r0.L$1
                io.ktor.client.engine.HttpClientEngine r7 = r0.L$0
                kotlin.ResultKt.throwOnFailure(r9)
                goto L7e
            L3b:
                kotlin.ResultKt.throwOnFailure(r9)
                kotlinx.coroutines.Job r9 = r8.executionContext
                r0.L$0 = r7
                r0.L$1 = r8
                r0.label = r3
                kotlinx.coroutines.CoroutineName r2 = io.ktor.client.engine.HttpClientEngineKt.CALL_COROUTINE
                kotlinx.coroutines.JobImpl r2 = new kotlinx.coroutines.JobImpl
                r2.<init>(r9)
                kotlin.coroutines.CoroutineContext r9 = r7.getCoroutineContext()
                kotlin.coroutines.CoroutineContext r9 = r9.plus(r2)
                kotlinx.coroutines.CoroutineName r5 = io.ktor.client.engine.HttpClientEngineKt.CALL_COROUTINE
                kotlin.coroutines.CoroutineContext r9 = r9.plus(r5)
                kotlin.coroutines.CoroutineContext r5 = r0.getContext()
                kotlinx.coroutines.Job$Key r6 = kotlinx.coroutines.Job.Key.$$INSTANCE
                kotlin.coroutines.CoroutineContext$Element r5 = r5.get(r6)
                kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
                if (r5 != 0) goto L6a
                goto L7b
            L6a:
                io.ktor.client.engine.UtilsKt$attachToUserJob$cleanupHandler$1 r6 = new io.ktor.client.engine.UtilsKt$attachToUserJob$cleanupHandler$1
                r6.<init>()
                kotlinx.coroutines.DisposableHandle r3 = kotlinx.coroutines.Job.DefaultImpls.invokeOnCompletion$default(r5, r3, r6, r4)
                io.ktor.client.engine.UtilsKt$attachToUserJob$2 r5 = new io.ktor.client.engine.UtilsKt$attachToUserJob$2
                r5.<init>()
                r2.invokeOnCompletion(r5)
            L7b:
                if (r9 != r1) goto L7e
                goto La1
            L7e:
                kotlin.coroutines.CoroutineContext r9 = (kotlin.coroutines.CoroutineContext) r9
                io.ktor.client.engine.KtorCallContextElement r2 = new io.ktor.client.engine.KtorCallContextElement
                r2.<init>(r9)
                kotlin.coroutines.CoroutineContext r9 = r9.plus(r2)
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2 r2 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2
                r3 = 0
                r2.<init>(r7, r8, r3)
                kotlinx.coroutines.DeferredCoroutine r7 = kotlinx.coroutines.BuildersKt.async$default(r7, r9, r2, r4)
                r0.L$0 = r3
                r0.L$1 = r3
                r0.label = r4
                java.lang.Object r9 = r7.await(r0)
                if (r9 != r1) goto La0
                goto La1
            La0:
                r1 = r9
            La1:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.HttpClientEngine.DefaultImpls.access$executeWithinCallContext(io.ktor.client.engine.HttpClientEngine, io.ktor.client.request.HttpRequestData, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    Object execute(HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation);

    AndroidEngineConfig getConfig();

    Set<HttpClientEngineCapability<?>> getSupportedCapabilities();

    void install(HttpClient httpClient);
}
