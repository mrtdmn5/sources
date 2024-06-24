package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.request.DefaultHttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.statement.DefaultHttpResponse;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ClientEventsKt;
import io.ktor.http.HeadersImpl;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.http.UnsafeHeaderException;
import io.ktor.http.Url;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.JobKt;

/* compiled from: HttpClientEngine.kt */
@DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$install$1", f = "HttpClientEngine.kt", l = {70, 82}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpClientEngine$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    public final /* synthetic */ HttpClient $client;
    public /* synthetic */ PipelineContext L$0;
    public /* synthetic */ Object L$1;
    public int label;
    public final /* synthetic */ HttpClientEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClientEngine$install$1(HttpClient httpClient, HttpClientEngine httpClientEngine, Continuation<? super HttpClientEngine$install$1> continuation) {
        super(3, continuation);
        this.$client = httpClient;
        this.this$0 = httpClientEngine;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpClientEngine$install$1 httpClientEngine$install$1 = new HttpClientEngine$install$1(this.$client, this.this$0, continuation);
        httpClientEngine$install$1.L$0 = pipelineContext;
        httpClientEngine$install$1.L$1 = obj;
        return httpClientEngine$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        OutgoingContent outgoingContent;
        HttpClientEngine httpClientEngine;
        Object access$executeWithinCallContext;
        PipelineContext pipelineContext;
        HttpRequestData requestData;
        HttpClientEngineCapability<?> next;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r2 = this.label;
        HttpClient client = this.$client;
        if (r2 != 0) {
            if (r2 != 1) {
                if (r2 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            requestData = (HttpRequestData) this.L$1;
            PipelineContext pipelineContext2 = this.L$0;
            ResultKt.throwOnFailure(obj);
            pipelineContext = pipelineContext2;
            access$executeWithinCallContext = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            PipelineContext pipelineContext3 = this.L$0;
            Object obj2 = this.L$1;
            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
            httpRequestBuilder.takeFromWithExecutionContext((HttpRequestBuilder) pipelineContext3.context);
            if (obj2 == null) {
                httpRequestBuilder.body = NullBody.INSTANCE;
                TypeReference typeOf = Reflection.typeOf(Object.class);
                httpRequestBuilder.setBodyType(new TypeInfo(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(Object.class), typeOf));
            } else if (obj2 instanceof OutgoingContent) {
                httpRequestBuilder.body = obj2;
                httpRequestBuilder.setBodyType(null);
            } else {
                httpRequestBuilder.body = obj2;
                TypeReference typeOf2 = Reflection.typeOf(Object.class);
                httpRequestBuilder.setBodyType(new TypeInfo(TypesJVMKt.getJavaType(typeOf2), Reflection.getOrCreateKotlinClass(Object.class), typeOf2));
            }
            client.monitor.raise(ClientEventsKt.HttpRequestIsReadyForSending);
            Url build = httpRequestBuilder.url.build();
            HttpMethod httpMethod = httpRequestBuilder.method;
            HeadersImpl build2 = httpRequestBuilder.headers.build();
            Object obj3 = httpRequestBuilder.body;
            if (obj3 instanceof OutgoingContent) {
                outgoingContent = (OutgoingContent) obj3;
            } else {
                outgoingContent = null;
            }
            if (outgoingContent != null) {
                HttpRequestData httpRequestData = new HttpRequestData(build, httpMethod, build2, outgoingContent, httpRequestBuilder.executionContext, httpRequestBuilder.attributes);
                httpRequestData.attributes.put(HttpClientEngineKt.CLIENT_CONFIG, client.config);
                Set<String> names = httpRequestData.headers.names();
                ArrayList arrayList = new ArrayList();
                for (Object obj4 : names) {
                    if (HttpHeaders.UnsafeHeadersList.contains((String) obj4)) {
                        arrayList.add(obj4);
                    }
                }
                if (!(!arrayList.isEmpty())) {
                    Iterator<HttpClientEngineCapability<?>> it = httpRequestData.requiredCapabilities.iterator();
                    do {
                        boolean hasNext = it.hasNext();
                        httpClientEngine = this.this$0;
                        if (hasNext) {
                            next = it.next();
                        } else {
                            this.L$0 = pipelineContext3;
                            this.L$1 = httpRequestData;
                            this.label = 1;
                            access$executeWithinCallContext = HttpClientEngine.DefaultImpls.access$executeWithinCallContext(httpClientEngine, httpRequestData, this);
                            if (access$executeWithinCallContext == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            pipelineContext = pipelineContext3;
                            requestData = httpRequestData;
                        }
                    } while (httpClientEngine.getSupportedCapabilities().contains(next));
                    throw new IllegalArgumentException(("Engine doesn't support " + next).toString());
                }
                throw new UnsafeHeaderException(arrayList.toString());
            }
            throw new IllegalStateException(("No request transformation found: " + httpRequestBuilder.body).toString());
        }
        HttpResponseData responseData = (HttpResponseData) access$executeWithinCallContext;
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        Intrinsics.checkNotNullParameter(responseData, "responseData");
        HttpClientCall httpClientCall = new HttpClientCall(client);
        httpClientCall.request = new DefaultHttpRequest(httpClientCall, requestData);
        httpClientCall.response = new DefaultHttpResponse(httpClientCall, responseData);
        Object obj5 = responseData.body;
        if (!(obj5 instanceof ByteReadChannel)) {
            httpClientCall.getAttributes().put(HttpClientCall.CustomResponse, obj5);
        }
        HttpResponse response = httpClientCall.getResponse();
        client.monitor.raise(ClientEventsKt.HttpResponseReceived);
        JobKt.getJob(response.getCoroutineContext()).invokeOnCompletion(new Function1<Throwable, Unit>(response) { // from class: io.ktor.client.engine.HttpClientEngine$install$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Throwable th) {
                if (th != null) {
                    HttpClient.this.monitor.raise(ClientEventsKt.HttpResponseCancelled);
                }
                return Unit.INSTANCE;
            }
        });
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (pipelineContext.proceedWith(httpClientCall, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }
}
