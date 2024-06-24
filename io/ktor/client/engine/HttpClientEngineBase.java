package io.ktor.client.engine;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import io.ktor.client.HttpClient;
import io.ktor.client.engine.android.AndroidClientEngine;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.util.CoroutinesUtilsKt$SilentSupervisor$$inlined$CoroutineExceptionHandler$1;
import java.io.Closeable;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.EmptySet;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorJobImpl;

/* compiled from: HttpClientEngineBase.kt */
/* loaded from: classes3.dex */
public abstract class HttpClientEngineBase implements HttpClientEngine {
    public static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientEngineBase.class, "closed");
    public final String engineName = "ktor-android";
    private volatile /* synthetic */ int closed = 0;
    public final SynchronizedLazyImpl coroutineContext$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineContext>() { // from class: io.ktor.client.engine.HttpClientEngineBase$coroutineContext$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final CoroutineContext invoke() {
            CoroutineContext plus = CoroutineContext.DefaultImpls.plus(new SupervisorJobImpl(null), new CoroutinesUtilsKt$SilentSupervisor$$inlined$CoroutineExceptionHandler$1());
            HttpClientEngineBase httpClientEngineBase = HttpClientEngineBase.this;
            return plus.plus((CoroutineDispatcher) ((AndroidClientEngine) httpClientEngineBase).dispatcher$delegate.getValue()).plus(new CoroutineName(ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), httpClientEngineBase.engineName, "-context")));
        }
    });

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        CompletableJob completableJob;
        if (!closed$FU.compareAndSet(this, 0, 1)) {
            return;
        }
        CoroutineContext coroutineContext = getCoroutineContext();
        int r1 = Job.$r8$clinit;
        CoroutineContext.Element element = coroutineContext.get(Job.Key.$$INSTANCE);
        if (element instanceof CompletableJob) {
            completableJob = (CompletableJob) element;
        } else {
            completableJob = null;
        }
        if (completableJob == null) {
            return;
        }
        completableJob.complete();
        completableJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.client.engine.HttpClientEngineBase$close$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Throwable th) {
                CoroutineContext.Element element2 = (CoroutineDispatcher) ((AndroidClientEngine) HttpClientEngineBase.this).dispatcher$delegate.getValue();
                try {
                    if (element2 instanceof ExecutorCoroutineDispatcher) {
                        ((ExecutorCoroutineDispatcher) element2).close();
                    } else if (element2 instanceof Closeable) {
                        ((Closeable) element2).close();
                    }
                } catch (Throwable unused) {
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return (CoroutineContext) this.coroutineContext$delegate.getValue();
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return EmptySet.INSTANCE;
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public final void install(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        client.sendPipeline.intercept(HttpSendPipeline.Engine, new HttpClientEngine$install$1(client, this, null));
    }
}
