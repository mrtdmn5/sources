package io.ktor.client.plugins;

import com.animaconnected.secondo.R;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: HttpPlainText.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpPlainText$Plugin$install$2", f = "HttpPlainText.kt", l = {R.styleable.AppTheme_stepsHistoryColumnColorDetail, R.styleable.AppTheme_stepsHistoryColumnTodayColorDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpPlainText$Plugin$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    public final /* synthetic */ HttpPlainText $plugin;
    public /* synthetic */ PipelineContext L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpPlainText$Plugin$install$2(HttpPlainText httpPlainText, Continuation<? super HttpPlainText$Plugin$install$2> continuation) {
        super(3, continuation);
        this.$plugin = httpPlainText;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        HttpPlainText$Plugin$install$2 httpPlainText$Plugin$install$2 = new HttpPlainText$Plugin$install$2(this.$plugin, continuation);
        httpPlainText$Plugin$install$2.L$0 = pipelineContext;
        httpPlainText$Plugin$install$2.L$1 = httpResponseContainer;
        return httpPlainText$Plugin$install$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readRemaining;
        PipelineContext pipelineContext;
        TypeInfo typeInfo;
        Charset charset;
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
            if (Intrinsics.areEqual(typeInfo2.type, Reflection.getOrCreateKotlinClass(String.class))) {
                Object obj2 = httpResponseContainer.response;
                if (obj2 instanceof ByteReadChannel) {
                    this.L$0 = pipelineContext2;
                    this.L$1 = typeInfo2;
                    this.label = 1;
                    readRemaining = ((ByteReadChannel) obj2).readRemaining(Long.MAX_VALUE, this);
                    if (readRemaining == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    pipelineContext = pipelineContext2;
                    obj = readRemaining;
                    typeInfo = typeInfo2;
                }
            }
            return Unit.INSTANCE;
        }
        ByteReadPacket body = (ByteReadPacket) obj;
        HttpClientCall call = (HttpClientCall) pipelineContext.context;
        HttpPlainText httpPlainText = this.$plugin;
        httpPlainText.getClass();
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(body, "body");
        ContentType contentType = HttpMessagePropertiesKt.contentType(call.getResponse());
        if (contentType != null) {
            charset = ContentTypesKt.charset(contentType);
        } else {
            charset = null;
        }
        if (charset == null) {
            charset = httpPlainText.responseCharsetFallback;
        }
        HttpPlainTextKt.LOGGER.trace("Reading response body for " + call.getRequest().getUrl() + " as String with charset " + charset);
        HttpResponseContainer httpResponseContainer2 = new HttpResponseContainer(typeInfo, StringsKt.readText$default(body, charset));
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (pipelineContext.proceedWith(httpResponseContainer2, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }
}
