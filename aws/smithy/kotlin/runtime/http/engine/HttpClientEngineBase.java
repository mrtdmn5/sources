package aws.smithy.kotlin.runtime.http.engine;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: HttpClientEngine.kt */
/* loaded from: classes.dex */
public abstract class HttpClientEngineBase implements CloseableHttpClientEngine {
    public static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientEngineBase.class, "closed");
    public final CoroutineContext coroutineContext = CoroutineContext.DefaultImpls.plus(SupervisorKt.SupervisorJob$default(), new CoroutineName("http-client-engine-OkHttp-context"));
    public volatile /* synthetic */ int closed = 0;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        CompletableJob completableJob;
        if (!closed$FU.compareAndSet(this, 0, 1)) {
            return;
        }
        int r0 = Job.$r8$clinit;
        CoroutineContext.Element element = this.coroutineContext.get(Job.Key.$$INSTANCE);
        if (element instanceof CompletableJob) {
            completableJob = (CompletableJob) element;
        } else {
            completableJob = null;
        }
        if (completableJob == null) {
            return;
        }
        completableJob.complete();
        completableJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: aws.smithy.kotlin.runtime.http.engine.HttpClientEngineBase$close$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Throwable th) {
                HttpClientEngineBase.this.shutdown();
                return Unit.INSTANCE;
            }
        });
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public void shutdown() {
    }
}
