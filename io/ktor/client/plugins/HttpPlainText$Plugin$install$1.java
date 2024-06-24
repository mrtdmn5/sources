package io.ktor.client.plugins;

import com.animaconnected.secondo.R;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.TextContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* compiled from: HttpPlainText.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpPlainText$Plugin$install$1", f = "HttpPlainText.kt", l = {R.styleable.AppTheme_statusTopStripeSetup}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpPlainText$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    public final /* synthetic */ HttpPlainText $plugin;
    public /* synthetic */ PipelineContext L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpPlainText$Plugin$install$1(HttpPlainText httpPlainText, Continuation<? super HttpPlainText$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = httpPlainText;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpPlainText$Plugin$install$1 httpPlainText$Plugin$install$1 = new HttpPlainText$Plugin$install$1(this.$plugin, continuation);
        httpPlainText$Plugin$install$1.L$0 = pipelineContext;
        httpPlainText$Plugin$install$1.L$1 = obj;
        return httpPlainText$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ContentType contentType;
        Charset charset;
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
            PipelineContext pipelineContext = this.L$0;
            Object obj2 = this.L$1;
            HttpRequestBuilder context = (HttpRequestBuilder) pipelineContext.context;
            HttpPlainText httpPlainText = this.$plugin;
            httpPlainText.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
            List<String> list = HttpHeaders.UnsafeHeadersList;
            HeadersBuilder headersBuilder = context.headers;
            if (headersBuilder.get("Accept-Charset") == null) {
                Logger logger = HttpPlainTextKt.LOGGER;
                StringBuilder sb = new StringBuilder("Adding Accept-Charset=");
                String value = httpPlainText.acceptCharsetHeader;
                sb.append(value);
                sb.append(" to ");
                sb.append(context.url);
                logger.trace(sb.toString());
                Intrinsics.checkNotNullParameter(value, "value");
                headersBuilder.validateValue(value);
                List<String> ensureListForKey = headersBuilder.ensureListForKey("Accept-Charset");
                ensureListForKey.clear();
                ensureListForKey.add(value);
            }
            if (!(obj2 instanceof String)) {
                return Unit.INSTANCE;
            }
            TContext tcontext = pipelineContext.context;
            ContentType contentType2 = HttpMessagePropertiesKt.contentType((HttpMessageBuilder) tcontext);
            if (contentType2 != null) {
                if (!Intrinsics.areEqual(contentType2.contentType, ContentType.Text.Plain.contentType)) {
                    return Unit.INSTANCE;
                }
            }
            HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) tcontext;
            String str = (String) obj2;
            if (contentType2 == null) {
                contentType = ContentType.Text.Plain;
            } else {
                contentType = contentType2;
            }
            if (contentType2 == null || (charset = ContentTypesKt.charset(contentType2)) == null) {
                charset = httpPlainText.requestCharset;
            }
            HttpPlainTextKt.LOGGER.trace("Sending request body to " + httpRequestBuilder.url + " as text/plain with charset " + charset);
            Intrinsics.checkNotNullParameter(contentType, "<this>");
            Intrinsics.checkNotNullParameter(charset, "charset");
            TextContent textContent = new TextContent(str, contentType.withParameter("charset", CharsetJVMKt.getName(charset)));
            this.L$0 = null;
            this.label = 1;
            if (pipelineContext.proceedWith(textContent, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
