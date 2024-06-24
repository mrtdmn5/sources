package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import io.ktor.utils.io.jvm.javaio.InputAdapter;
import java.io.InputStream;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;

/* compiled from: DefaultTransformersJvm.kt */
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformersJvmKt$platformResponseDefaultTransformers$1", f = "DefaultTransformersJvm.kt", l = {36}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DefaultTransformersJvmKt$platformResponseDefaultTransformers$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    public /* synthetic */ PipelineContext L$0;
    public /* synthetic */ HttpResponseContainer L$1;
    public int label;

    public DefaultTransformersJvmKt$platformResponseDefaultTransformers$1(Continuation<? super DefaultTransformersJvmKt$platformResponseDefaultTransformers$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        DefaultTransformersJvmKt$platformResponseDefaultTransformers$1 defaultTransformersJvmKt$platformResponseDefaultTransformers$1 = new DefaultTransformersJvmKt$platformResponseDefaultTransformers$1(continuation);
        defaultTransformersJvmKt$platformResponseDefaultTransformers$1.L$0 = pipelineContext;
        defaultTransformersJvmKt$platformResponseDefaultTransformers$1.L$1 = httpResponseContainer;
        return defaultTransformersJvmKt$platformResponseDefaultTransformers$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            final PipelineContext pipelineContext = this.L$0;
            HttpResponseContainer httpResponseContainer = this.L$1;
            TypeInfo typeInfo = httpResponseContainer.expectedType;
            Object obj2 = httpResponseContainer.response;
            if (!(obj2 instanceof ByteReadChannel)) {
                return Unit.INSTANCE;
            }
            if (Intrinsics.areEqual(typeInfo.type, Reflection.getOrCreateKotlinClass(InputStream.class))) {
                ByteReadChannel byteReadChannel = (ByteReadChannel) obj2;
                Job job = (Job) ((HttpClientCall) pipelineContext.context).getCoroutineContext().get(Job.Key.$$INSTANCE);
                SynchronizedLazyImpl synchronizedLazyImpl = BlockingKt.ADAPTER_LOGGER$delegate;
                Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
                final InputAdapter inputAdapter = new InputAdapter(byteReadChannel, job);
                HttpResponseContainer httpResponseContainer2 = new HttpResponseContainer(typeInfo, new InputStream() { // from class: io.ktor.client.plugins.DefaultTransformersJvmKt$platformResponseDefaultTransformers$1$response$1
                    @Override // java.io.InputStream
                    public final int available() {
                        return inputAdapter.available();
                    }

                    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                    public final void close() {
                        super.close();
                        inputAdapter.close();
                        HttpResponseKt.complete(pipelineContext.context.getResponse());
                    }

                    @Override // java.io.InputStream
                    public final int read() {
                        return inputAdapter.read();
                    }

                    @Override // java.io.InputStream
                    public final int read(byte[] b, int r3, int r4) {
                        Intrinsics.checkNotNullParameter(b, "b");
                        return inputAdapter.read(b, r3, r4);
                    }
                });
                this.L$0 = null;
                this.label = 1;
                if (pipelineContext.proceedWith(httpResponseContainer2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
