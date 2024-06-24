package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.http.ContentType;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaderValueParserKt$parseAndSortHeader$$inlined$sortedByDescending$1;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.Url;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: ContentNegotiation.kt */
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiation$Plugin$install$2", f = "ContentNegotiation.kt", l = {262, 265}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContentNegotiation$Plugin$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ContentNegotiation $plugin;
    public /* synthetic */ PipelineContext L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentNegotiation$Plugin$install$2(ContentNegotiation contentNegotiation, Continuation<? super ContentNegotiation$Plugin$install$2> continuation) {
        super(3, continuation);
        this.$plugin = contentNegotiation;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        ContentNegotiation$Plugin$install$2 contentNegotiation$Plugin$install$2 = new ContentNegotiation$Plugin$install$2(this.$plugin, continuation);
        contentNegotiation$Plugin$install$2.L$0 = pipelineContext;
        contentNegotiation$Plugin$install$2.L$1 = httpResponseContainer;
        return contentNegotiation$Plugin$install$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Charset charset;
        Charset charset2;
        PipelineContext pipelineContext;
        TypeInfo typeInfo;
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
            typeInfo = (TypeInfo) this.L$1;
            pipelineContext = this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            PipelineContext pipelineContext2 = this.L$0;
            HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.L$1;
            TypeInfo typeInfo2 = httpResponseContainer.expectedType;
            Object obj2 = httpResponseContainer.response;
            ContentType contentType = HttpMessagePropertiesKt.contentType(((HttpClientCall) pipelineContext2.context).getResponse());
            if (contentType == null) {
                ContentNegotiationKt.LOGGER.trace("Response doesn't have \"Content-Type\" header, skipping ContentNegotiation plugin");
                return Unit.INSTANCE;
            }
            HttpClientCall httpClientCall = (HttpClientCall) pipelineContext2.context;
            Headers headers = httpClientCall.getRequest().getHeaders();
            Charset defaultCharset = Charsets.UTF_8;
            Intrinsics.checkNotNullParameter(headers, "<this>");
            Intrinsics.checkNotNullParameter(defaultCharset, "defaultCharset");
            List<String> list = HttpHeaders.UnsafeHeadersList;
            Iterator it = CollectionsKt___CollectionsKt.sortedWith(HttpHeaderValueParserKt.parseHeaderValue(headers.get("Accept-Charset")), new HttpHeaderValueParserKt$parseAndSortHeader$$inlined$sortedByDescending$1()).iterator();
            while (true) {
                if (it.hasNext()) {
                    String str = ((HeaderValue) it.next()).value;
                    if (Intrinsics.areEqual(str, "*")) {
                        charset = defaultCharset;
                        break;
                    }
                    if (Charset.isSupported(str)) {
                        charset = Charset.forName(str);
                        break;
                    }
                } else {
                    charset = null;
                    break;
                }
            }
            if (charset == null) {
                charset2 = defaultCharset;
            } else {
                charset2 = charset;
            }
            ContentNegotiation contentNegotiation = this.$plugin;
            Url url = httpClientCall.getRequest().getUrl();
            this.L$0 = pipelineContext2;
            this.L$1 = typeInfo2;
            this.label = 1;
            Object convertResponse$ktor_client_content_negotiation = contentNegotiation.convertResponse$ktor_client_content_negotiation(url, typeInfo2, obj2, contentType, charset2, this);
            if (convertResponse$ktor_client_content_negotiation == coroutineSingletons) {
                return coroutineSingletons;
            }
            pipelineContext = pipelineContext2;
            obj = convertResponse$ktor_client_content_negotiation;
            typeInfo = typeInfo2;
        }
        if (obj == null) {
            return Unit.INSTANCE;
        }
        HttpResponseContainer httpResponseContainer2 = new HttpResponseContainer(typeInfo, obj);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (pipelineContext.proceedWith(httpResponseContainer2, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }
}
