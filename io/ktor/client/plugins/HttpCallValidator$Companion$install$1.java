package io.ktor.client.plugins;

import com.animaconnected.secondo.R;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.Headers;
import io.ktor.http.HeadersImpl;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmBase;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import org.slf4j.Logger;

/* compiled from: HttpCallValidator.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator$Companion$install$1", f = "HttpCallValidator.kt", l = {R.styleable.AppTheme_statusTopStripeSetup, 133}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpCallValidator$Companion$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    public final /* synthetic */ HttpCallValidator $plugin;
    public /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidator$Companion$install$1(HttpCallValidator httpCallValidator, Continuation<? super HttpCallValidator$Companion$install$1> continuation) {
        super(3, continuation);
        this.$plugin = httpCallValidator;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpCallValidator$Companion$install$1 httpCallValidator$Companion$install$1 = new HttpCallValidator$Companion$install$1(this.$plugin, continuation);
        httpCallValidator$Companion$install$1.L$0 = pipelineContext;
        httpCallValidator$Companion$install$1.L$1 = obj;
        return httpCallValidator$Companion$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [io.ktor.util.pipeline.PipelineContext] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ?? r1 = this.label;
        final HttpCallValidator httpCallValidator = this.$plugin;
        try {
            if (r1 != 0) {
                if (r1 != 1) {
                    if (r1 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th = (Throwable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th;
                }
                PipelineContext pipelineContext = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                r1 = pipelineContext;
            } else {
                ResultKt.throwOnFailure(obj);
                PipelineContext pipelineContext2 = (PipelineContext) this.L$0;
                Object obj2 = this.L$1;
                ((HttpRequestBuilder) pipelineContext2.context).attributes.computeIfAbsent(HttpCallValidatorKt.ExpectSuccessAttributeKey, new Function0<Boolean>() { // from class: io.ktor.client.plugins.HttpCallValidator$Companion$install$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(HttpCallValidator.this.expectSuccess);
                    }
                });
                this.L$0 = pipelineContext2;
                this.label = 1;
                Object proceedWith = pipelineContext2.proceedWith(obj2, this);
                r1 = pipelineContext2;
                if (proceedWith == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            Throwable unwrapCancellationException = AutoCloseableKt.unwrapCancellationException(th2);
            final HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) r1.context;
            Logger logger = HttpCallValidatorKt.LOGGER;
            HttpRequest httpRequest = new HttpRequest(httpRequestBuilder) { // from class: io.ktor.client.plugins.HttpCallValidatorKt$HttpRequest$1
                public final AttributesJvmBase attributes;
                public final HeadersImpl headers;
                public final HttpMethod method;
                public final Url url;

                {
                    this.method = httpRequestBuilder.method;
                    this.url = httpRequestBuilder.url.build();
                    this.attributes = httpRequestBuilder.attributes;
                    this.headers = httpRequestBuilder.headers.build();
                }

                @Override // io.ktor.client.request.HttpRequest
                public final Attributes getAttributes() {
                    return this.attributes;
                }

                public final HttpClientCall getCall() {
                    throw new IllegalStateException("Call is not initialized".toString());
                }

                @Override // io.ktor.client.request.HttpRequest, kotlinx.coroutines.CoroutineScope
                public final CoroutineContext getCoroutineContext() {
                    getCall();
                    throw null;
                }

                @Override // io.ktor.http.HttpMessage
                public final Headers getHeaders() {
                    return this.headers;
                }

                @Override // io.ktor.client.request.HttpRequest
                public final HttpMethod getMethod() {
                    return this.method;
                }

                @Override // io.ktor.client.request.HttpRequest
                public final Url getUrl() {
                    return this.url;
                }
            };
            this.L$0 = unwrapCancellationException;
            this.label = 2;
            if (HttpCallValidator.access$processException(httpCallValidator, unwrapCancellationException, httpRequest, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            throw unwrapCancellationException;
        }
    }
}
