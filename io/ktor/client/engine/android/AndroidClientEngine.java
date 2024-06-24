package io.ktor.client.engine.android;

import io.ktor.client.engine.HttpClientEngineBase;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.plugins.HttpTimeout;
import java.util.Set;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: AndroidClientEngine.kt */
/* loaded from: classes3.dex */
public final class AndroidClientEngine extends HttpClientEngineBase {
    public final AndroidEngineConfig config;
    public final SynchronizedLazyImpl dispatcher$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineDispatcher>() { // from class: io.ktor.client.engine.android.AndroidClientEngine$dispatcher$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final CoroutineDispatcher invoke() {
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            return Dispatchers.IO.limitedParallelism(AndroidClientEngine.this.config.threadsCount);
        }
    });
    public final Set<HttpClientEngineCapability<?>> supportedCapabilities = SetsKt__SetsKt.setOf(HttpTimeout.Plugin);

    public AndroidClientEngine(AndroidEngineConfig androidEngineConfig) {
        this.config = androidEngineConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x02b8 A[PHI: r1
  0x02b8: PHI (r1v10 java.lang.Object) = (r1v8 java.lang.Object), (r1v1 java.lang.Object) binds: [B:19:0x02b5, B:11:0x002e] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x02b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x005d  */
    /* JADX WARN: Type inference failed for: r11v2, types: [io.ktor.client.engine.android.AndroidClientEngine$execute$connection$1$1] */
    @Override // io.ktor.client.engine.HttpClientEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object execute(io.ktor.client.request.HttpRequestData r22, kotlin.coroutines.Continuation<? super io.ktor.client.request.HttpResponseData> r23) {
        /*
            Method dump skipped, instructions count: 697
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.android.AndroidClientEngine.execute(io.ktor.client.request.HttpRequestData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public final AndroidEngineConfig getConfig() {
        return this.config;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, io.ktor.client.engine.HttpClientEngine
    public final Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return this.supportedCapabilities;
    }
}
