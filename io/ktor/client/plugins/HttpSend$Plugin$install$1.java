package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpSend;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.ranges.IntProgressionIterator;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt__IndentKt;

/* compiled from: HttpSend.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpSend$Plugin$install$1", f = "HttpSend.kt", l = {104, 105}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpSend$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    public final /* synthetic */ HttpSend $plugin;
    public final /* synthetic */ HttpClient $scope;
    public /* synthetic */ PipelineContext L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpSend$Plugin$install$1(HttpSend httpSend, HttpClient httpClient, Continuation<? super HttpSend$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = httpSend;
        this.$scope = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpSend$Plugin$install$1 httpSend$Plugin$install$1 = new HttpSend$Plugin$install$1(this.$plugin, this.$scope, continuation);
        httpSend$Plugin$install$1.L$0 = pipelineContext;
        httpSend$Plugin$install$1.L$1 = obj;
        return httpSend$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v13, types: [T, io.ktor.client.plugins.HttpSend$DefaultSender] */
    /* JADX WARN: Type inference failed for: r7v5, types: [T, io.ktor.client.plugins.HttpSend$InterceptedSender] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PipelineContext pipelineContext;
        String trimMargin;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pipelineContext = this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            pipelineContext = this.L$0;
            Object obj2 = this.L$1;
            if (obj2 instanceof OutgoingContent) {
                HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) pipelineContext.context;
                if (obj2 == null) {
                    NullBody nullBody = NullBody.INSTANCE;
                    httpRequestBuilder.getClass();
                    httpRequestBuilder.body = nullBody;
                    TypeReference typeOf = Reflection.typeOf(OutgoingContent.class);
                    httpRequestBuilder.setBodyType(new TypeInfo(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(OutgoingContent.class), typeOf));
                } else if (obj2 instanceof OutgoingContent) {
                    httpRequestBuilder.getClass();
                    httpRequestBuilder.body = obj2;
                    httpRequestBuilder.setBodyType(null);
                } else {
                    httpRequestBuilder.getClass();
                    httpRequestBuilder.body = obj2;
                    TypeReference typeOf2 = Reflection.typeOf(OutgoingContent.class);
                    httpRequestBuilder.setBodyType(new TypeInfo(TypesJVMKt.getJavaType(typeOf2), Reflection.getOrCreateKotlinClass(OutgoingContent.class), typeOf2));
                }
                HttpSend httpSend = this.$plugin;
                ?? defaultSender = new HttpSend.DefaultSender(httpSend.maxSendCount, this.$scope);
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = defaultSender;
                ArrayList arrayList = httpSend.interceptors;
                int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
                IntProgressionIterator intProgressionIterator = new IntProgressionIterator(lastIndex, ProgressionUtilKt.getProgressionLastElement(lastIndex, 0, -1), -1);
                while (intProgressionIterator.hasNext) {
                    ref$ObjectRef.element = new HttpSend.InterceptedSender((Function3) arrayList.get(intProgressionIterator.nextInt()), (Sender) ref$ObjectRef.element);
                }
                Sender sender = (Sender) ref$ObjectRef.element;
                HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) pipelineContext.context;
                this.L$0 = pipelineContext;
                this.label = 1;
                obj = sender.execute(httpRequestBuilder2, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                trimMargin = StringsKt__IndentKt.trimMargin("\n|Fail to prepare request body for sending. \n|The body type is: " + Reflection.getOrCreateKotlinClass(obj2.getClass()) + ", with Content-Type: " + HttpMessagePropertiesKt.contentType((HttpMessageBuilder) pipelineContext.context) + ".\n|\n|If you expect serialized body, please check that you have installed the corresponding plugin(like `ContentNegotiation`) and set `Content-Type` header.", "|");
                throw new IllegalStateException(trimMargin.toString());
            }
        }
        this.L$0 = null;
        this.label = 2;
        if (pipelineContext.proceedWith((HttpClientCall) obj, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }
}
