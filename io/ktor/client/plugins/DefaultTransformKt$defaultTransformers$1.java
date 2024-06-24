package io.ktor.client.plugins;

import com.amazonaws.http.HttpHeader;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$2;
import io.ktor.utils.io.pool.ByteArrayPoolKt;
import io.ktor.utils.io.pool.ByteArrayPoolKt$ByteArrayPool$1;
import java.io.InputStream;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;

/* compiled from: DefaultTransform.kt */
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1", f = "DefaultTransform.kt", l = {57}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DefaultTransformKt$defaultTransformers$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    public /* synthetic */ PipelineContext L$0;
    public /* synthetic */ Object L$1;
    public int label;

    public DefaultTransformKt$defaultTransformers$1(Continuation<? super DefaultTransformKt$defaultTransformers$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        DefaultTransformKt$defaultTransformers$1 defaultTransformKt$defaultTransformers$1 = new DefaultTransformKt$defaultTransformers$1(continuation);
        defaultTransformKt$defaultTransformers$1.L$0 = pipelineContext;
        defaultTransformKt$defaultTransformers$1.L$1 = obj;
        return defaultTransformKt$defaultTransformers$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        OutgoingContent outgoingContent;
        ContentType contentType;
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
            final Object body = this.L$1;
            HeadersBuilder headersBuilder = ((HttpRequestBuilder) pipelineContext.context).headers;
            List<String> list = HttpHeaders.UnsafeHeadersList;
            String str = headersBuilder.get(HttpHeader.ACCEPT);
            TContext tcontext = pipelineContext.context;
            if (str == null) {
                ((HttpRequestBuilder) tcontext).headers.append(HttpHeader.ACCEPT, "*/*");
            }
            final ContentType contentType2 = HttpMessagePropertiesKt.contentType((HttpMessageBuilder) tcontext);
            if (body instanceof String) {
                String str2 = (String) body;
                if (contentType2 == null) {
                    contentType2 = ContentType.Text.Plain;
                }
                outgoingContent = new TextContent(str2, contentType2);
            } else if (body instanceof byte[]) {
                outgoingContent = new OutgoingContent.ByteArrayContent(contentType2, body) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$1
                    public final /* synthetic */ Object $body;
                    public final long contentLength;
                    public final ContentType contentType;

                    {
                        this.$body = body;
                        if (contentType2 == null) {
                            ContentType contentType3 = ContentType.Application.Json;
                            r1 = ContentType.Application.OctetStream;
                        }
                        this.contentType = r1;
                        this.contentLength = ((byte[]) body).length;
                    }

                    @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
                    public final byte[] bytes() {
                        return (byte[]) this.$body;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public final Long getContentLength() {
                        return Long.valueOf(this.contentLength);
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public final ContentType getContentType() {
                        return this.contentType;
                    }
                };
            } else if (body instanceof ByteReadChannel) {
                outgoingContent = new OutgoingContent.ReadChannelContent(pipelineContext, contentType2, body) { // from class: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1$content$2
                    public final /* synthetic */ Object $body;
                    public final Long contentLength;
                    public final ContentType contentType;

                    {
                        Long l;
                        this.$body = body;
                        HeadersBuilder headersBuilder2 = pipelineContext.context.headers;
                        List<String> list2 = HttpHeaders.UnsafeHeadersList;
                        String str3 = headersBuilder2.get("Content-Length");
                        if (str3 != null) {
                            l = Long.valueOf(Long.parseLong(str3));
                        } else {
                            l = null;
                        }
                        this.contentLength = l;
                        this.contentType = contentType2 == null ? ContentType.Application.OctetStream : contentType2;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public final Long getContentLength() {
                        return this.contentLength;
                    }

                    @Override // io.ktor.http.content.OutgoingContent
                    public final ContentType getContentType() {
                        return this.contentType;
                    }

                    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                    public final ByteReadChannel readFrom() {
                        return (ByteReadChannel) this.$body;
                    }
                };
            } else if (body instanceof OutgoingContent) {
                outgoingContent = (OutgoingContent) body;
            } else {
                final HttpRequestBuilder context = (HttpRequestBuilder) tcontext;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(body, "body");
                if (body instanceof InputStream) {
                    outgoingContent = new OutgoingContent.ReadChannelContent(context, contentType2, body) { // from class: io.ktor.client.plugins.DefaultTransformersJvmKt$platformRequestDefaultTransform$1
                        public final /* synthetic */ Object $body;
                        public final Long contentLength;
                        public final ContentType contentType;

                        {
                            Long l;
                            this.$body = body;
                            List<String> list2 = HttpHeaders.UnsafeHeadersList;
                            String str3 = context.headers.get("Content-Length");
                            if (str3 != null) {
                                l = Long.valueOf(Long.parseLong(str3));
                            } else {
                                l = null;
                            }
                            this.contentLength = l;
                            this.contentType = contentType2 == null ? ContentType.Application.OctetStream : contentType2;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public final Long getContentLength() {
                            return this.contentLength;
                        }

                        @Override // io.ktor.http.content.OutgoingContent
                        public final ContentType getContentType() {
                            return this.contentType;
                        }

                        @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                        public final ByteReadChannel readFrom() {
                            InputStream inputStream = (InputStream) this.$body;
                            DefaultIoScheduler context2 = Dispatchers.IO;
                            ByteArrayPoolKt$ByteArrayPool$1 pool = ByteArrayPoolKt.ByteArrayPool;
                            Intrinsics.checkNotNullParameter(inputStream, "<this>");
                            Intrinsics.checkNotNullParameter(context2, "context");
                            Intrinsics.checkNotNullParameter(pool, "pool");
                            return CoroutinesKt.writer(GlobalScope.INSTANCE, context2, true, new ReadingKt$toByteReadChannel$2(pool, inputStream, null)).channel;
                        }
                    };
                } else {
                    outgoingContent = null;
                }
            }
            if (outgoingContent != null) {
                contentType = outgoingContent.getContentType();
            } else {
                contentType = null;
            }
            if (contentType != null) {
                HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) tcontext;
                httpRequestBuilder.headers.values.remove("Content-Type");
                DefaultTransformKt.LOGGER.trace("Transformed with default transformers request body for " + httpRequestBuilder.url + " from " + Reflection.getOrCreateKotlinClass(body.getClass()));
                this.L$0 = null;
                this.label = 1;
                if (pipelineContext.proceedWith(outgoingContent, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
