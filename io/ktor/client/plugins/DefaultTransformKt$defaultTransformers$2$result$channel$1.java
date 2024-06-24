package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelJVMKt;
import io.ktor.utils.io.WriterScope;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExceptionsKt;

/* compiled from: DefaultTransform.kt */
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$result$channel$1", f = "DefaultTransform.kt", l = {99}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DefaultTransformKt$defaultTransformers$2$result$channel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Object $body;
    public final /* synthetic */ HttpResponse $response;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultTransformKt$defaultTransformers$2$result$channel$1(Object obj, HttpResponse httpResponse, Continuation<? super DefaultTransformKt$defaultTransformers$2$result$channel$1> continuation) {
        super(2, continuation);
        this.$body = obj;
        this.$response = httpResponse;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultTransformKt$defaultTransformers$2$result$channel$1 defaultTransformKt$defaultTransformers$2$result$channel$1 = new DefaultTransformKt$defaultTransformers$2$result$channel$1(this.$body, this.$response, continuation);
        defaultTransformKt$defaultTransformers$2$result$channel$1.L$0 = obj;
        return defaultTransformKt$defaultTransformers$2$result$channel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((DefaultTransformKt$defaultTransformers$2$result$channel$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        HttpResponse httpResponse = this.$response;
        try {
            try {
                try {
                    if (r1 != 0) {
                        if (r1 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        WriterScope writerScope = (WriterScope) this.L$0;
                        ByteReadChannel byteReadChannel = (ByteReadChannel) this.$body;
                        ByteChannel channel$1 = writerScope.getChannel$1();
                        this.label = 1;
                        if (ByteReadChannelJVMKt.copyTo(byteReadChannel, channel$1, Long.MAX_VALUE, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    HttpResponseKt.complete(httpResponse);
                    return Unit.INSTANCE;
                } catch (CancellationException e) {
                    CoroutineScopeKt.cancel(httpResponse, e);
                    throw e;
                }
            } catch (Throwable th) {
                CoroutineScopeKt.cancel(httpResponse, ExceptionsKt.CancellationException("Receive failed", th));
                throw th;
            }
        } catch (Throwable th2) {
            HttpResponseKt.complete(httpResponse);
            throw th2;
        }
    }
}
